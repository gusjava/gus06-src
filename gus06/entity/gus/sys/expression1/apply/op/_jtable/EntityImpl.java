package gus06.entity.gus.sys.expression1.apply.op._jtable;

import gus06.framework.*;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.Action;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import javax.swing.table.TableCellRenderer;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170412";}

	public final static String KEY_DATA = "data";
	public final static String KEY_COL = "col";
	public final static String KEY_COL_DISPLAY = "col_display";
	public final static String KEY_COL_SIZE = "col_size";
	public final static String KEY_RENDERER = "renderer";
	



	private Service buildModel;
	private Service buildRenderer;
	
	public EntityImpl() throws Exception
	{
		buildModel = Outside.service(this,"gus.swing.table.buildmodel.model1");
		buildRenderer = Outside.service(this,"gus.swing.table.renderer.builder1");
	}

	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		
		if(obj instanceof Map) return buildTable((Map) obj);
		if(obj instanceof List) return buildTable((List) obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	
	
	private JTable buildTable(Map map) throws Exception
	{
		List data = (List) get(map,KEY_DATA);
		List col = (List) get(map,KEY_COL);
		Map colDisplay = (Map) get(map,KEY_COL_DISPLAY);
		Map colSize = (Map) get(map,KEY_COL_SIZE);
		
		if(data==null) throw new Exception("Data not defined for JTable");
		if(col==null) col = columnsFromData(data);
		
		TableModel model = (TableModel) buildModel.t(new Object[]{data,col,colDisplay});
		JTable table = new JTable(model);
		
		TableCellRenderer renderer = buildTableCellRenderer(map);
		if(renderer!=null) table.setDefaultRenderer(Object.class,renderer);
		
		if(colSize!=null) initColSize(table,col,colSize);
		
		return table;
	}
	
	
	private JTable buildTable(List data) throws Exception
	{
		TableModel model = (TableModel) buildModel.t(data);
		return new JTable(model);
	}
	
	
	private TableCellRenderer buildTableCellRenderer(Map map) throws Exception
	{
		Object r = get(map,KEY_RENDERER);
		if(r==null) return null;
		if(r instanceof TableCellRenderer) return (TableCellRenderer) r;
		if(r instanceof T) return (TableCellRenderer) buildRenderer.t(r);
		throw new Exception("Invalid data type: "+r.getClass().getName());
	}
	
	
	
	private Object get(Map map, String key)
	{
		if(!map.containsKey(key)) return null;
		return map.get(key);
	}
	
	
	private List columnsFromData(List data)
	{
		if(data.isEmpty()) return null;
		Map m = (Map) data.get(0);
		List l = new ArrayList(m.keySet());
		Collections.sort(l);
		return l;
	}
	
	
	private void initColSize(JTable table, List col, Map colSize)
	{
		for(int i=0;i<col.size();i++)
		{
			String n = (String) col.get(i);
			if(colSize.containsKey(n))
			{
				Integer size = (Integer) colSize.get(n);
				setColumnSize(table,i,size.intValue());
			}
		}
	}
	
	private void setColumnSize(JTable table, int index, int size)
	{
		table.getColumnModel().getColumn(index).setMaxWidth(size);
		table.getColumnModel().getColumn(index).setMinWidth(size);
	}
}
