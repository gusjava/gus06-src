package gus06.entity.gus.sys.store.t.map.comp.label;

import gus06.framework.*;
import java.util.Map;
import javax.swing.JLabel;


public class EntityImpl implements Entity, T {

	public String creationDate() {return "20140907";}

	private Service custComp;
	private Service custLabel;
	
	public EntityImpl() throws Exception
	{
		custComp = Outside.service(this,"gus.swing.comp.cust3.map1");
		custLabel = Outside.service(this,"gus.swing.label.cust3.map1");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		Map map = (Map) obj;
		
		JLabel label = new JLabel();
		custComp.p(new Object[]{label,map});
		custLabel.p(new Object[]{label,map});
		
		return label;
	}
	
	
	private String get(Map map, String key)
	{
		if(!map.containsKey(key)) return null;
		return (String) map.get(key);
	}
}
