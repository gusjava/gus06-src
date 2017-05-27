package gus06.entity.gus.app.inside.script2;

import gus06.framework.*;
import java.util.Map;

public class EntityImpl implements Entity, T, R {

	public String creationDate() {return "20170409";}


	private Service getScript;
	private Service decrypter;
	private Service inside;
	
	private Map crypt;
	
	
	public EntityImpl() throws Exception
	{
		getScript = Outside.service(this,"gus.app.inside.script1");
		decrypter = Outside.service(this,"gus.crypto.pbe.string.decrypt");
		inside = Outside.service(this,"inside");
		
		crypt = (Map) inside.t("prop.script/crypt");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		String id = (String) obj;
		String script = (String) getScript.t(id);
		
		if(crypt==null) return script;
		if(!crypt.containsKey(id)) return script;
		
		String key = (String) crypt.get(id);
		return decrypt(script,key);
	}
	
	
	public Object r(String key) throws Exception
	{return t(key);}
	
	
	
	private String decrypt(String script, String key) throws Exception
	{
		T t = (T) decrypter.t(key);
		return (String) t.t(script);
	}
}
