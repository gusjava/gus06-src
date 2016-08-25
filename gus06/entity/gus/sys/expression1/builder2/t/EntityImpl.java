package gus06.entity.gus.sys.expression1.builder2.t;

import gus06.framework.*;
import java.util.Map;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160129";}


	private Service rToT;
	private Service fToT;
	private Service hToT;
	private Service gToT;
	private Service mapToT;
	
	private Service builder1;
	private Service simpleTrans;
	

	public EntityImpl() throws Exception
	{
		rToT = Outside.service(this,"gus.convert.rtot");
		fToT = Outside.service(this,"gus.convert.ftot");
		hToT = Outside.service(this,"gus.convert.htot");
		gToT = Outside.service(this,"gus.convert.gtot");
		mapToT = Outside.service(this,"gus.convert.maptot");
		
		builder1 = Outside.service(this,"gus.sys.expression1.builder1.t");
		simpleTrans = Outside.service(this,"gus.data.transform.object.fromrule");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Object data = o[0];
		Map opMap = (Map) o[1];
		
		return findT(data,opMap);
	}
	
	private T findT(Object data, Map opMap) throws Exception
	{
		if(data instanceof T)		return (T) data;
		if(data instanceof Map) 	return (T) mapToT.t(data);
		if(data instanceof R) 		return (T) rToT.t(data);
		if(data instanceof F) 		return (T) fToT.t(data);
		if(data instanceof H) 		return (T) hToT.t(data);
		if(data instanceof G) 		return (T) gToT.t(data);
		if(data instanceof String)	return stringToT(""+data,opMap);
		if(data instanceof Integer)	return stringToT(""+data,opMap);
		
		throw new Exception("Invalid data type: "+data.getClass().getName());
	}
	
	
	private T stringToT(String data, Map opMap) throws Exception
	{
		T t = (T) simpleTrans.r(data);
		if(t!=null) return t;
		return (T) builder1.t(new Object[]{data,opMap});
	}
}
