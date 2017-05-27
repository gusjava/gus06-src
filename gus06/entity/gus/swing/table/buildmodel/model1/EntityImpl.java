package gus06.entity.gus.swing.table.buildmodel.model1;

import gus06.framework.*;
import javax.swing.table.AbstractTableModel;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Collections;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170412";}

	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = buildInput(obj);
		
		List data = (List) o[0];
		List columns = (List) o[1];
		Map display = (Map) o[2];
		
		return new TableModel1(data,columns,display);
	}
	
	
	private Object[] buildInput(Object obj) throws Exception
	{
		if(obj instanceof List) return new Object[]{obj,null,null};
		if(obj instanceof Object[])
		{
			Object[] o = (Object[]) obj;
			if(o.length==1) return new Object[]{o[0],null,null};
			if(o.length==2) return new Object[]{o[0],o[1],null};
			if(o.length==3) return new Object[]{o[0],o[1],o[2]};
			
			throw new Exception("Wrong data number: "+o.length);
		}
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	
	
	private class TableModel1 extends AbstractTableModel
	{
		private List data;
		private List columns;
		private Map display;
		
		public TableModel1(List data, List columns, Map display)
		{
			this.data = data;
			this.columns = columns;
			this.display = display;
			
			if(columns==null)
			this.columns = columnsFromData(data);
		}
		
		public int getColumnCount(){return columns.size();}
		public int getRowCount() {return data.size();}
		
		public Class getColumnClass(int y)
		{return Object.class;}
		
		
		public String getColumnName(int y)
		{
			String col = (String) columns.get(y);
			if(display==null || !display.containsKey(col)) return col;
			return (String) display.get(col);
		}

		public Object getValueAt(int x, int y)
		{
			Map map = (Map) data.get(x);
			String col = (String) columns.get(y);
			
			if(!map.containsKey(col)) return null;
			return map.get(col);
		}
	}
	
	
	
	private List columnsFromData(List data)
	{
		if(data.isEmpty()) return null;
		Map m = (Map) data.get(0);
		List l = new ArrayList(m.keySet());
		Collections.sort(l);
		return l;
	}
}
