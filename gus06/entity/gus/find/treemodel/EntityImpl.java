package gus06.entity.gus.find.treemodel;

import gus06.framework.*;
import javax.swing.tree.TreeModel;
import javax.swing.JTree;
import java.util.Map;
import java.util.List;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20161221";}


	private Service fromMap;
	private Service fromList;
	private Service fromStringArray;
	
	
	public EntityImpl() throws Exception
	{
		fromMap = Outside.service(this,"gus.swing.tree.model.build.frommap2");
		fromList = Outside.service(this,"gus.swing.tree.model.build.fromlist");
		fromStringArray = Outside.service(this,"gus.swing.tree.model.build.fromstringarray.tab");
	}


	public Object t(Object obj) throws Exception
	{
		if(obj==null) return null;
		if(obj instanceof TreeModel) return obj;
		if(obj instanceof JTree) return ((JTree) obj).getModel();
		if(obj instanceof Map) return fromMap.t(obj);
		if(obj instanceof List) return fromList.t(obj);
		if(obj instanceof String[]) return fromStringArray.t(obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
}
