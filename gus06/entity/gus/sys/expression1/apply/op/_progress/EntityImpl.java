package gus06.entity.gus.sys.expression1.apply.op._progress;

import gus06.framework.*;
import java.util.List;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160922";}

	
	private Service factory;
	
	public EntityImpl() throws Exception
	{factory = Outside.service(this,"factory#gus.swing.progressbar.progress1a");}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		
		if(obj instanceof Integer) return build((Integer) obj);
		if(obj instanceof Object[]) return build((Object[]) obj);
		if(obj instanceof List) return build((List) obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	
	private Object build(Integer n) throws Exception
	{return build(n.intValue());}
	
	private Object build(List l) throws Exception
	{return build(l.size());}
	
	private Object build(Object[] oo) throws Exception
	{return build(oo.length);}
	
	
	
	private Object build(int n) throws Exception
	{
		V progress = (V) factory.g();
		progress.v("size",""+n);
		return progress;
	}
}
