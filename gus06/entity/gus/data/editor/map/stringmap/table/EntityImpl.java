package gus06.entity.gus.data.editor.map.stringmap.table;

import gus06.framework.*;
import javax.swing.*;
import java.util.Map;
import java.util.ArrayList;
import java.util.Collections;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.table.AbstractTableModel;


public class EntityImpl implements Entity, I, P, ActionListener {

	public String creationDate() {return "20150329";}


	private Map map;
	
	private TableModel0 model;
	private JTable table;
	private JScrollPane scroll;

	

	public EntityImpl() throws Exception
	{
		model = new TableModel0();
		table = new JTable(model);
		scroll = new JScrollPane(table);
		
		table.setCellSelectionEnabled(true);
		
		table.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e)
			{
				if(table.getSelectionModel().isSelectionEmpty())return;
				if(e.getKeyCode()==KeyEvent.VK_DELETE) deleteFromJTable();
			}
		});
	}
	
	
	public Object i() throws Exception
	{return scroll;}
	
	
	
	public void p(Object obj) throws Exception
	{
		if(map!=null) throw new Exception("Map already initialized");
		map = (Map) obj;
		((S) map).addActionListener(this);
		SwingUtilities.invokeLater(model);
	}
	
	
	
	public void actionPerformed(ActionEvent evt)
	{SwingUtilities.invokeLater(model);}
	
	
	
	private class TableModel0 extends AbstractTableModel implements Runnable
	{
		private volatile ArrayList keys;
        
		public TableModel0()
		{keys = new ArrayList();}
    	
		public int getRowCount(){return keys.size();}
		public int getColumnCount(){return 2;}
    	
		public boolean isCellEditable(int x, int y){return true;}
		public Class getColumnClass(int y){return String.class;}
		public String getColumnName(int y){return y==0?"key":"value";}
    	
		public Object getValueAt(int x, int y)
		{
			Object key = keys.get(x);
			if(y==0)return key;
			return map.get(key);
		}
    	
		public void setValueAt(Object value, int x, int y)
		{
			if(y==0)modifyKeyAt(x,value);
			if(y==1)modifyValueAt(x,value);
		}

		private void modifyKeyAt(int index, Object newKey)
		{
			Object key = keys.get(index);
			Object value = map.get(key);
			map.remove(key);
			map.put(newKey,value);
			SwingUtilities.invokeLater(this);
		}

		private void modifyValueAt(int index, Object newValue)
		{
			Object key = keys.get(index);
			map.put(key,newValue);
			SwingUtilities.invokeLater(this);
		}

		public void run()
		{
			keys = map!=null?new ArrayList(map.keySet()):new ArrayList();
			Collections.sort(keys);
			fireTableDataChanged();
		}
	}
	
	
	
	
	
	
	
	private void deleteFromJTable()
	{
		int[] row = table.getSelectedRows();
		String[] keys_ = new String[row.length];
		for(int i=0;i<row.length;i++)
		keys_[i] = (String) table.getValueAt(row[i],0);
		SwingUtilities.invokeLater(new DeleteHolder(keys_));
	}


	private class DeleteHolder implements Runnable
	{
		private String[] keys_;
		public DeleteHolder(String[] keys_) {this.keys_= keys_;}
		
		public void run()
		{
			table.getCellEditor().cancelCellEditing();
			for(int i=0;i<keys_.length;i++)
			map.remove(keys_[i]);
			model.run();
		}
	}
}
