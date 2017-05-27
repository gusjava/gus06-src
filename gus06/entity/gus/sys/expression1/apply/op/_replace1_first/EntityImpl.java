package gus06.entity.gus.sys.expression1.apply.op._replace1_first;

import gus06.framework.*;
import java.util.List;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170124";}


	private Service perform;
	private Service builder;
	
	public EntityImpl() throws Exception
	{
		perform = Outside.service(this,"gus.data.string.replace1.first");
		builder = Outside.service(this,"gus.data.string.tool.replacebuilder");
	}


	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		
		if(obj instanceof String) return builder.t(new Object[]{perform,obj});
		if(obj instanceof String[]) return builder.t(new Object[]{perform,obj});
		if(obj instanceof List) return builder.t(new Object[]{perform,obj});
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
}
