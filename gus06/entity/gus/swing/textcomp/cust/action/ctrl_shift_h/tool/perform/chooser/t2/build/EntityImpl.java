package gus06.entity.gus.swing.textcomp.cust.action.ctrl_shift_h.tool.perform.chooser.t2.build;

import gus06.framework.*;
import java.util.Map;
import java.util.HashMap;
import javax.swing.text.JTextComponent;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170225";}
	
	
	
	private Service manager;
	
	public EntityImpl() throws Exception
	{
		manager = Outside.service(this,"gus.swing.textcomp.cust.action.ctrl_shift_h.tool.perform.chooser.manager");
	}
	
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		JTextComponent comp = (JTextComponent) o[0];
		String key = (String) o[1];
		
		
		Map data = new HashMap();
		Map data0 = findData(comp);
		
		if(data0!=null) data.putAll(data0);
		data.put("comp",comp);
		
		manager.v("data",data);
		return key!=null ? manager.r("trans_"+key) : null;
	}
	
	
	private Map findData(Object obj) throws Exception
	{
		if(!(obj instanceof R)) return null;
		try{return (Map) ((R) obj).r("data");}
		catch(Exception e){}
		return null;
	}
}
