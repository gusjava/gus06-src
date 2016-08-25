package gus06.entity.gus.sys.quickreplace.holder.find;

import gus06.framework.*;
import java.util.Map;
import java.util.HashMap;
import javax.swing.text.JTextComponent;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160430";}


	private Service build;
	private Map map;



	public EntityImpl() throws Exception
	{
		build = Outside.service(this,"gus.sys.quickreplace.holder.build");
		map = new HashMap();
	}
	
	
	public Object t(Object obj) throws Exception
	{
		JTextComponent comp = (JTextComponent) obj;
		if(!map.containsKey(comp))
			map.put(comp,build.t(comp));
		return map.get(comp);
	}
}
