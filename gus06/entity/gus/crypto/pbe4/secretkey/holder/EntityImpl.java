package gus06.entity.gus.crypto.pbe4.secretkey.holder;

import gus06.framework.*;
import java.util.Map;
import java.util.HashMap;

public class EntityImpl implements Entity, T, R {

	public String creationDate() {return "20170520";}


	private Service keyBuilder;
	private Map map;
	
	public EntityImpl() throws Exception
	{
		keyBuilder = Outside.service(this,"gus.crypto.pbe.secretkey.builder.askpwd");
		map = new HashMap();
	}

	public Object r(String key) throws Exception
	{
		if(!map.containsKey(key)) map.put(key,keyBuilder.g());
		return map.get(key);
	}
	
	public Object t(Object obj) throws Exception
	{return r((String) obj);}
}
