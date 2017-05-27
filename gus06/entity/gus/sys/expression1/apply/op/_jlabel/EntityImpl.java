package gus06.entity.gus.sys.expression1.apply.op._jlabel;

import gus06.framework.*;
import java.util.Map;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.Icon;
import java.awt.Color;
import javax.swing.border.EmptyBorder;
import javax.swing.border.Border;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160907";}

	public final static String KEY_TEXT = "text";
	public final static String KEY_ICON = "icon";
	public final static String KEY_DISPLAY = "display";
	public final static String KEY_TOOLTIP = "tooltip";
	public final static String KEY_FONT = "font";
	public final static String KEY_FONTSIZE = "fontsize";
	public final static String KEY_FOREGROUND = "foreground";
	public final static String KEY_BACKGROUND = "background";
	public final static String KEY_OPAQUE = "opaque";
	public final static String KEY_MARGIN = "margin";
	public final static String KEY_BORDER = "border";
	
	
	
	private Service repaint;
	private Service findBorder;
	private Service findEmptyBorder;
	
	public EntityImpl() throws Exception
	{
		repaint = Outside.service(this,"gus.swing.label.cust2.display");
		findBorder = Outside.service(this,"gus.find.border");
		findEmptyBorder = Outside.service(this,"gus.find.emptyborder");
	}

	
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		if(obj instanceof String) return build((String) obj);
		if(obj instanceof Icon) return build((Icon) obj);
		if(obj instanceof Map) return build((Map) obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	
	private JLabel build(String display) throws Exception
	{
		JLabel label = new JLabel();
		repaint.v(display,label);
		return label;
	}
	
	
	private JLabel build(Icon icon) throws Exception
	{
		JLabel label = new JLabel();
		label.setIcon(icon);
		return label;
	}
	
	
	private JLabel build(Map map) throws Exception
	{
		String display = (String) get(map,KEY_DISPLAY);
		String text = (String) get(map,KEY_TEXT);
		Icon icon = (Icon) get(map,KEY_ICON);
		String tooltip = (String) get(map,KEY_TOOLTIP);
		Font font = (Font) get(map,KEY_FONT);
		Integer fontsize = (Integer) get(map,KEY_FONTSIZE);
		Color foreground = (Color) get(map,KEY_FOREGROUND);
		Color background = (Color) get(map,KEY_BACKGROUND);
		Boolean opaque = (Boolean) get(map,KEY_OPAQUE);
		Object margin = get(map,KEY_MARGIN);
		Object border = get(map,KEY_BORDER);
		
		JLabel label = new JLabel();
		
		if(display!=null)
		{
			repaint.v(display,label);
		}
		else
		{
			if(text!=null) label.setText(text);
			if(icon!=null) label.setIcon(icon);
		}
		
		if(font!=null)
		{
			label.setFont(font);
		}
		else
		{
			if(fontsize!=null) label.setFont(label.getFont().deriveFont(fontsize.floatValue()));
		}
		
		if(border!=null)
		{
			Border b = (Border) findBorder.t(border);
			label.setBorder(b);
		}
		else if(margin!=null)
		{
			EmptyBorder b = (EmptyBorder) findEmptyBorder.t(margin);
			label.setBorder(b);
		}
		
		if(tooltip!=null) label.setToolTipText(tooltip);
		if(foreground!=null) label.setForeground(foreground);
		if(background!=null) label.setBackground(background);
		if(opaque!=null) label.setOpaque(opaque.booleanValue());
		
		return label;
	}
	
	
	
	private Object get(Map map, String key)
	{
		if(!map.containsKey(key)) return null;
		return map.get(key);
	}
}
