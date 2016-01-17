package gus06.entity.gus.swing.textcomp.cust.action.f1.autocomplete.perform;

import gus06.framework.*;
import javax.swing.text.Element;
import javax.swing.text.JTextComponent;
import javax.swing.text.PlainDocument;
import javax.swing.JTextArea;
import java.util.Map;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20140818";}


	private Service input;
	private Service subMap;
	
	public EntityImpl() throws Exception
	{
		input = Outside.service(this,"gus.input.text.dialog");
		subMap = Outside.service(this,"gus.app.prop.submap.autocomplete");
	}
	
	
	public void p(Object obj) throws Exception
	{
		if(obj instanceof JTextArea)
		perform((JTextArea) obj);
	}
	
	
	
	
	private void perform(JTextArea comp) throws Exception
	{
		String rule = (String) input.t("Type rule:");
		if(rule==null) return;
		
		String[] n = rule.split(" ",2);
		Object obj = find(n[0]);
		
		if(n.length==1) ((P)obj).p(comp);
		else ((V)obj).v(n[1],comp);
	}
	
	
	
	private Object find(String name) throws Exception
	{
		Map map = (Map) subMap.g();
		if(!map.containsKey(name))
			throw new Exception("Unknown autocomplete action: "+name);
		String rule = (String) map.get(name);
		return Outside.service(this,rule);
	}
}
