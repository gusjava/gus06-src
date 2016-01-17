package gus06.entity.gus.jdbc.gui.tableview;

import gus06.framework.*;
import javax.swing.JComponent;
import javax.swing.JTabbedPane;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JTable;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import java.util.List;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import java.sql.ResultSetMetaData;
import java.awt.Dimension;
import javax.swing.table.TableModel;
import javax.swing.ListSelectionModel;

public class EntityImpl implements Entity, I, P {

	public String creationDate() {return "20150623";}


	private Service selectAll;
	private Service rsToList;
	private Service tooltip;
	private Service adjuster;
	
	
	private JTabbedPane tab;
	private JTable table;
	private TableModel0 model;
	
	private ResultSet rs;
	private ResultSetMetaData rsmd;
	
	private int colCount;
	private String[] colNames;
	private Class[] colClasses;
	private List data;
	
	
	
	private G holder;
	private String dbName;
	private String tableName;





	public EntityImpl() throws Exception
	{
		selectAll = Outside.service(this,"gus.jdbc.mysql.perform.select.all");
		rsToList = Outside.service(this,"gus.jdbc.resultset.toobjectlist");
		tooltip = Outside.service(this,"gus.swing.table.cust.tooltip1");
		adjuster = Outside.service(this,"gus.swing.table.cust.columnsize.adjuster");
		
		
		model = new TableModel0();
		table = new JTable0(model);
		
		table.getTableHeader().setReorderingAllowed(false);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		table.setCellSelectionEnabled(true);
		
		tooltip.p(table);
		adjuster.p(table);
		
		JPanel panelData = new JPanel(new BorderLayout());
		panelData.add(new JScrollPane(table),BorderLayout.CENTER);
	
		tab = new JTabbedPane();
		tab.addTab("Data",panelData);
	}
	
	
	public Object i() throws Exception
	{return tab;}
	
	
	
	
	public void p(Object obj) throws Exception
	{
		if(obj==null)
		{
			holder = null;
			dbName = null;
			tableName = null;
			resetGui();
			return;
		}
		
		Object[] o = (Object[]) obj;
		if(o.length!=3) throw new Exception("Wrong data number: "+o.length);
		
		holder = (G) o[0];
		dbName = (String) o[1];
		tableName = (String) o[2];
		updateGui();
	}
	
	
	
	
	private void updateGui() throws Exception
	{
		if(holder==null) return;
		Connection cx = (Connection) holder.g();
		if(cx==null) return;
		
		rs = (ResultSet) selectAll.t(new Object[]{cx,dbName+"."+tableName});
		rsmd = rs.getMetaData();
		
		colCount = rsmd.getColumnCount();
		colNames = new String[colCount];
		colClasses = new Class[colCount];
		
		for(int i=0;i<colCount;i++)
		{
			colNames[i] = rsmd.getColumnName(i+1);
			colClasses[i] = Class.forName(rsmd.getColumnClassName(i+1));
		}
			
		data = (List) rsToList.t(rs);
		model.fireTableStructureChanged();
	}
	
	
	
	private void resetGui() throws Exception
	{
		colCount = 0;
		colNames = new String[0];
		colClasses = new Class[0];
		data = new ArrayList();
		
		model.fireTableStructureChanged();
	}
	
	
	
	
	
	
	
	
	private class TableModel0 extends AbstractTableModel
	{
		public int getColumnCount() {return colCount;}
		public int getRowCount() {return data==null?0:data.size();}
		
		public String getColumnName(int y)
		{
			if(colNames==null) return null;
			if(y>=colNames.length || y<0) return null;
			return colNames[y];
		}
		
		public Class getColumnClass(int y)
		{
			if(colNames==null) return null;
			if(y>=colClasses.length || y<0) return null;
			return colClasses[y];
		}

		public Object getValueAt(int x, int y)
		{
			if(data==null) return null;
			Object[] row = (Object[]) data.get(x);
			if(row==null) return null;
			if(y>=row.length || y<0) return null;
			return row[y];
		}
	}
	
	
	
	private class JTable0 extends JTable
	{
		public JTable0(TableModel model)
		{super(model);}
		
		public Dimension getPreferredSize()
		{
			int w = 0;
			for(int i=0;i<getColumnModel().getColumnCount();i++)
			w += getColumnModel().getColumn(i).getPreferredWidth();
			
			int h = super.getPreferredSize().height;
			return new Dimension(w,h);
		}
	}
}
