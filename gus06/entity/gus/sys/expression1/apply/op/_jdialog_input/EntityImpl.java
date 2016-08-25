package gus06.entity.gus.sys.expression1.apply.op._jdialog_input;

import gus06.framework.*;
import java.util.Map;
import javax.swing.JOptionPane;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160318";}
	
	public final static String KEY_MESSAGE = "message";
	public final static String KEY_TITLE = "title";
	public final static String KEY_INITVALUE = "initvalue";
	
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		if(obj instanceof String) return input((String) obj);
		if(obj instanceof Map) return input((Map) obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	
	private String input(String message)
	{
		String title = "Input text";
		
		return JOptionPane.showInputDialog(null,message,title,JOptionPane.PLAIN_MESSAGE);
	}
	
	private String input(Map map)
	{
		String message = get(map,KEY_MESSAGE,"");
		String title = get(map,KEY_TITLE,"");
		String initValue = get(map,KEY_INITVALUE,"");
		
		return (String) JOptionPane.showInputDialog(null,message,title,JOptionPane.PLAIN_MESSAGE,null,null,initValue);
	}
	
	private String get(Map map, String key, String defaultValue)
	{
		if(!map.containsKey(key)) return defaultValue;
		return (String) map.get(key);
	}
}
