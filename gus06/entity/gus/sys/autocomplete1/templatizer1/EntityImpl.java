package gus06.entity.gus.sys.autocomplete1.templatizer1;

import gus06.framework.*;
import javax.swing.text.JTextComponent;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;

public class EntityImpl implements Entity, V, P {

	public String creationDate() {return "20160518";}
	
	public static final String KEY_TITLED = "AAa";
	public static final String KEY_TITLED_INV = "aAa";
	public static final String KEY_UPPER = "AAA";
	public static final String KEY_LOWER = "aaa";
	public static final String KEY_UNDERSCORE = "a_a";


	private Service variantes;
	private Service format;
	
	
	public EntityImpl() throws Exception
	{
		variantes = Outside.service(this,"gus.string.case1.buildvariantes");
		format = Outside.service(this,"gus.string.transform.format.brackets.curly");
		
	}


	public void p(Object obj) throws Exception
	{v("name",obj);}

	
	
	public void v(String key, Object obj) throws Exception
	{
		JTextComponent comp = (JTextComponent) obj;
		
		String selected = comp.getSelectedText();
		if(selected==null || selected.trim().equals("")) return;
		
		Map map = (Map) variantes.t(selected);
		Map map1 = new HashMap();
		
		String upper = (String) map.get(KEY_UPPER);
		String lower = (String) map.get(KEY_LOWER);
		String titled = (String) map.get(KEY_TITLED);
		String titled_inv = (String) map.get(KEY_TITLED_INV);
		String underscore = (String) map.get(KEY_UNDERSCORE);
		
		add(map1,upper,"{>"+key+"._upper}");
		add(map1,lower,"{>"+key+"._lower}");
		add(map1,titled,"{>"+key+"._titled}");
		add(map1,titled_inv,"{>"+key+"}");
		add(map1,underscore,"{>"+key+"._camelcase_inv}");
		
		String text = comp.getText();
		int pos = comp.getCaretPosition();
		
		text = (String) format.t(text);
		
		Iterator it = map1.keySet().iterator();
		while(it.hasNext())
		{
			String k = (String) it.next();
			String v = (String) map1.get(k);
			
			text = text.replace(k,v);
		}
		
		pos = Math.min(pos,text.length());
		comp.setText(text);
		comp.setCaretPosition(pos);
	}
	
	
	
	private void add(Map map, String key, String value)
	{
		if(!map.containsKey(key)) map.put(key,value);
	}
}
