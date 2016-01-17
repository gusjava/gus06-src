package gus06.entity.gus.dir.explorer.resource.ling.dicopanel;

import gus06.framework.*;
import javax.swing.JComponent;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.AbstractTableModel;
import javax.swing.event.*;
import java.util.*;
import java.awt.Insets;
import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;


public class EntityImpl implements Entity, I, P, ListSelectionListener, DocumentListener {

	public String creationDate() {return "20140811";}
	
	
	public static final Font FONT = new Font("Calibri",Font.PLAIN,18);
	

	private Service splitCust;
	
	private JTable table;
	private TableModel1 model;

	private Map mapFiles;
	private Map mapProps;
	private List keys;
	private List langs;
	
	private JTextArea area;
	private JSplitPane split;
	
	
	

	public EntityImpl() throws Exception
	{
		splitCust = Outside.service(this,"gus.swing.splitpane.cust.cust1");
		
		model = new TableModel1();
		table = new JTable(model);
		
		table.getTableHeader().setReorderingAllowed(false);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setColumnSelectionAllowed(true);
		table.setRowSelectionAllowed(true);
		table.getSelectionModel().addListSelectionListener(this);
		table.getColumnModel().getSelectionModel().addListSelectionListener(this);
		
		area = new JTextArea();
		area.setEnabled(false);
		area.setLineWrap(true);
		area.setFont(FONT);
		area.setMargin(new Insets(3,3,3,3));
		area.getDocument().addDocumentListener(this);
		
		split = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		splitCust.p(split);
		
		split.setLeftComponent(new JScrollPane(table));
		split.setRightComponent(new JScrollPane(area));
		split.setDividerLocation(200);
	}
	
	
	
	public Object i() throws Exception
	{return split;}
	
	
	
	
	public void p(Object obj) throws Exception
	{
		mapFiles = (Map) obj;
		if(mapFiles==null) resetGui();
		else updateGui();
	}
	
	
	
	private void resetGui()
	{
		mapProps = null;
		keys = null;
		langs = null;
		model.fireTableStructureChanged();
	}
	
	
	private void updateGui()
	{
		try
		{
			mapProps = new HashMap();
			Set keys_ = new HashSet();
		
			Iterator it = mapFiles.keySet().iterator();
			while(it.hasNext())
			{
				String lang = (String) it.next();
				File file = (File) mapFiles.get(lang);
				Properties prop = load(file);
				
				keys_.addAll(prop.keySet());
				mapProps.put(lang,prop);
			}
			
			keys = new ArrayList(keys_);
			Collections.sort(keys);
			
			langs = new ArrayList(mapFiles.keySet());
			Collections.sort(langs);
			
			model.fireTableStructureChanged();
		}
		catch(Exception e)
		{Outside.err(this,"updateGui()",e);}
	}
	
	
	
	private Properties load(File file) throws Exception
	{
		Properties prop = new Properties();
		if(!file.exists()) return prop;
		FileInputStream fis = new FileInputStream(file);
		prop.load(fis);
		fis.close();
		return prop;
	}
	
	
	private void save(File file, Properties prop) throws Exception
	{
		FileOutputStream fos = new FileOutputStream(file);
		prop.store(fos,"");
		fos.close();
	}
	
	
	
	
	private File file(String lang)
	{return (File) mapFiles.get(lang);}
		
	private Properties prop(String lang)
	{return (Properties) mapProps.get(lang);}
	
	private String lang(int index)
	{return (String) langs.get(index);}
	
	private String key(int index)
	{return (String) keys.get(index);}
	
	
	
	
	
	private void editKey(String key, String key1)
	{
		try
		{
			for(int i=0;i<langs.size();i++)
			{
				String lang = lang(i);
				File f = file(lang);
				Properties p = prop(lang);
	
				String value = p.containsKey(key)?p.getProperty(key):"";
				p.remove(key);
				if(!key1.equals("")) p.setProperty(key1,value);
				save(f,p);
			}
			
			int index = keys.indexOf(key);
			keys.remove(key);
			if(!key1.equals(""))keys.add(index,key1);
		}
		catch(Exception e)
		{Outside.err(this,"editKey(String,String)",e);}
	}
	
	
	
	private void editLing(String key, String lang, String value)
	{
		try
		{
			Properties p = prop(lang);
			File f = file(lang);
			p.setProperty(key,value);
			save(f,p);
		}
		catch(Exception e)
		{Outside.err(this,"editLing(String,String,String)",e);}
	}
	
	
	
	
	
	private class TableModel1 extends AbstractTableModel
	{
		public int getColumnCount() {return langs==null?1:langs.size()+1;}
		public int getRowCount() {return keys==null?0:keys.size();}
		public boolean isCellEditable(int x, int y) {return false;}
		public Class getColumnClass(int y){return String.class;}
		
		public String getColumnName(int y)
		{
			if(y==0) return "KEYS";
			return lang(y-1);
		}
		
		public Object getValueAt(int x, int y)
		{
			if(keys.isEmpty()) return "";
			String key = key(x);
			if(y==0) return key;
			
			String lang = lang(y-1);
			Properties p = prop(lang);
		
			if(!p.containsKey(key)) return "";
			return p.getProperty(key);
		}
		
		public void setValueAt(Object value, int x, int y)
		{
			String v = (String) value;
			String key = key(x);
			if(y==0) editKey(key,v);
			else editLing(key,lang(y-1),v);
		}
	}
	
	
	
	
	
	public void valueChanged(ListSelectionEvent e)
	{selectionChanged();}
	
	
	public void changedUpdate(DocumentEvent e) {}
        public void insertUpdate(DocumentEvent e) {textChanged();}
        public void removeUpdate(DocumentEvent e) {textChanged();}
	
	
	
	private void selectionChanged()
	{
		try
		{
			if(table.getSelectionModel().isSelectionEmpty())
			{
				setAreaText("");
				area.setEnabled(false);
				return;
			}
			int x = table.getSelectedRow();
			int y = table.getSelectedColumn();
			String value = (String) table.getValueAt(x,y);
			
			setAreaText(value);
			area.setEnabled(true);
		}
		catch(Exception e)
		{Outside.err(this,"selectionChanged()",e);}
	}
	
	
	
	private void setAreaText(String text)
	{
		area.getDocument().removeDocumentListener(this);
		area.setText(text);
		area.getDocument().addDocumentListener(this);
	}
	
	
	
	private void textChanged()
	{
		if(table.getSelectionModel().isSelectionEmpty()) return;
		
		String value = area.getText();
		int x = table.getSelectedRow();
		int y = table.getSelectedColumn();
		
		table.setValueAt(value,x,y);
		table.repaint();
	}
}
