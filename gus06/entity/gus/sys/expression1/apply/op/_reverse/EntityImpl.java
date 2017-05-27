package gus06.entity.gus.sys.expression1.apply.op._reverse;

import gus06.framework.*;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import java.awt.image.RenderedImage;
import javax.swing.JTabbedPane;
import javax.swing.text.JTextComponent;
import java.util.Map;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151109";}


	private Service perform;
	
	public EntityImpl() throws Exception
	{
		perform = Outside.service(this,"gus.data.perform.reverse");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		
		if(obj instanceof String) return perform.t(obj);
		if(obj instanceof List) return perform.t(obj);
		if(obj instanceof Object[]) return perform.t(obj);
		if(obj instanceof Map) return perform.t(obj);
		
		if(obj instanceof double[]) return perform.t(obj);
		if(obj instanceof int[]) return perform.t(obj);
		if(obj instanceof long[]) return perform.t(obj);
		if(obj instanceof float[]) return perform.t(obj);
		if(obj instanceof byte[]) return perform.t(obj);
		if(obj instanceof boolean[]) return perform.t(obj);
		if(obj instanceof JPanel) return perform.t(obj);
		if(obj instanceof JSplitPane) return perform.t(obj);
		if(obj instanceof JTabbedPane) return perform.t(obj);
		if(obj instanceof JTextComponent) return perform.t(obj);
		
		if(obj instanceof RenderedImage) return perform.t(obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
}
