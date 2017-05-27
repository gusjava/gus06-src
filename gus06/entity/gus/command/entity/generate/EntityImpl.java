package gus06.entity.gus.command.entity.generate;

import java.util.HashMap;
import java.util.Map;
import gus06.framework.*;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20140703";}

	
	private Service generateCode;
	private Service checkOwn;
	
	
	public EntityImpl() throws Exception
	{
		generateCode = Outside.service(this,"gus.entitydev.generate.srccode1");
		checkOwn = Outside.service(this,"gus.entitydev.entityname.check.own");
	}


	public void p(Object obj) throws Exception
	{
		String rule = (String) obj;
		String[] n = rule.split(" ");
		
		String entityName = (String) checkOwn.t(n[0]);
		String features = n.length>1?n[1]:"";
		String calls = n.length>2?n[2]:"";
		
		Map map = new HashMap();
		map.put(SRCGEN.KEY_ENTITYNAME,entityName);
		map.put(SRCGEN.KEY_FEATURES,formatFeatures(features));
		map.put(SRCGEN.KEY_CALLS,calls);
		
		generateCode.p(map);
	}
	
	
	
	private String formatFeatures(String features)
	{
		if(features.equals("all")) return "EFGHIPRSTX";
		return features;
	}
}