package gus06.entity.gus.sys.autocomplete1.all;

import gus06.framework.*;
import javax.swing.text.JTextComponent;
import java.util.Map;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20160603";}

	
	private Service subMap;
	private Service mapToString;
	
	public EntityImpl() throws Exception
	{
		subMap = Outside.service(this,"gus.app.prop.submap.autocomplete");
		mapToString = Outside.service(this,"gus.tostring.map");
	}

	
	public void p(Object obj) throws Exception
	{
		JTextComponent comp = (JTextComponent) obj;
		displayAll(comp);
	}
	
	
	private void displayAll(JTextComponent comp) throws Exception
	{
		Map map = (Map) subMap.g();
		String s = (String) mapToString.t(map);
		if(s.equals("")) s = "no rule found";
		comp.replaceSelection(s);
	}
}
