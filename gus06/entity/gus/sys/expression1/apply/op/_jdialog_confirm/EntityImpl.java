package gus06.entity.gus.sys.expression1.apply.op._jdialog_confirm;

import gus06.framework.*;
import java.util.Map;
import javax.swing.JOptionPane;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160318";}
	
	public final static String KEY_MESSAGE = "message";
	public final static String KEY_TITLE = "title";
	
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		if(obj instanceof String) return confirm((String) obj);
		if(obj instanceof Map) return confirm((Map) obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	
	private Boolean confirm(String message)
	{
		String title = "Confirmation";
		
		int r = JOptionPane.showConfirmDialog(null,message,title,JOptionPane.YES_NO_OPTION);
		return new Boolean(r==JOptionPane.YES_OPTION);
	}
	
	private Boolean confirm(Map map)
	{
		String message = get(map,KEY_MESSAGE,"");
		String title = get(map,KEY_TITLE,"");
		
		int r = JOptionPane.showConfirmDialog(null,message,title,JOptionPane.YES_NO_OPTION);
		return new Boolean(r==JOptionPane.YES_OPTION);
	}
	
	private String get(Map map, String key, String defaultValue)
	{
		if(!map.containsKey(key)) return defaultValue;
		return (String) map.get(key);
	}
}
