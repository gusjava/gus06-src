package gus06.entity.gus.sys.expression1.apply.op._mailstore;

import gus06.framework.*;
import java.util.List;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20161003";}


	private Service builder;
	private Service listToArray;
	
	public EntityImpl() throws Exception
	{
		builder = Outside.service(this,"gus.mail.store.builder");
		listToArray = Outside.service(this,"gus.convert.listtostringarray.strict");
	}

	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		
		String[] array = toArray(obj);
		return builder.t(array);
	}
	
	
	private String[] toArray(Object obj) throws Exception
	{
		if(obj instanceof String[]) return (String[]) obj;
		if(obj instanceof String) return ((String) obj).split("\\|");
		if(obj instanceof List) return (String[]) listToArray.t(obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
}
