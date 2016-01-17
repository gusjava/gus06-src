package gus06.entity.gus.appli.entityhistory.gui.chart.days;

import gus06.framework.*;
import javax.swing.JComponent;
import javax.swing.JTable;
import java.util.Map;
import javax.swing.table.AbstractTableModel;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.awt.Color;

public class EntityImpl implements Entity, I, P {

	public String creationDate() {return "20150501";}
	
	public static final Color COLOR = new Color(196,216,169);
	public static final String COL1 = "date";
	public static final String COL2 = "entity number";


	private Service tableSort;
	private Service tableTooltip;
	private Service tableRenderer;

	private TableModel1 model;
	private JTable table;
	
	private Map freq;
	private List keys;

	public EntityImpl() throws Exception
	{
		tableSort = Outside.service(this,"gus.swing.table.cust.sort1");
		tableTooltip = Outside.service(this,"gus.swing.table.cust.tooltip1");
		tableRenderer = Outside.service(this,"gus.swing.table.cust.renderer.freqmap");
		
		model = new TableModel1();
		table = new JTable(model);
		
		tableSort.p(table);
		tableTooltip.p(table);
		
		tableRenderer.v("color",COLOR);
		tableRenderer.p(table);
		resizeColumns();
	}
	
	private void resizeColumns()
	{
		table.getColumnModel().getColumn(0).setMinWidth(80);
		table.getColumnModel().getColumn(0).setMaxWidth(80);
	}
	
	
	public Object i() throws Exception
	{return table;}
	
	
	
	public void p(Object obj) throws Exception
	{
		freq = (Map) obj;
		if(freq==null) keys = null;
		else
		{
			keys = new ArrayList(freq.keySet());
			Collections.sort(keys);
			Collections.reverse(keys);
		}
		model.fireTableStructureChanged();
		resizeColumns();
	}
	
	
	
	private class TableModel1 extends AbstractTableModel
	{
		public int getRowCount()
		{return keys==null?0:keys.size();}
		
		public int getColumnCount()
		{return 2;}
		
		public boolean isCellEditable(int x, int y)
		{return false;}
		
		public Class getColumnClass(int y)
		{return y==0?String.class:Integer.class;}
		
		public String getColumnName(int y)
		{return y==0?COL1:COL2;}
		
		public Object getValueAt(int x, int y)
		{
			String key = (String) keys.get(x);
			return y==0?formatKey(key):freq.get(key);
		}
	}
	
	
	
	
	private String formatKey(String key)
	{return key.substring(0,4)+"."+key.substring(4,6)+"."+key.substring(6,8);}
}
