package gus06.entity.gus.swing.comp.cust3.map1;

import gus06.framework.*;
import javax.swing.JComponent;
import java.util.Map;
import java.util.Iterator;
import javax.swing.border.Border;
import java.awt.Color;
import java.awt.Font;


public class EntityImpl implements Entity, P {

	public String creationDate() {return "20140907";}


	private Service stringToBorder;
	private Service stringToColor;
	private Service stringToFont;
	private Service deriveFont;


	public EntityImpl() throws Exception
	{
		stringToBorder = Outside.service(this,"gus.convert.stringtoborder");
		stringToColor = Outside.service(this,"gus.convert.stringtocolor");
		stringToFont = Outside.service(this,"gus.convert.stringtofont");
		deriveFont = Outside.service(this,"gus.font.derivefont");
	}
	
	
	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		JComponent comp = (JComponent) o[0];
		Map map = (Map) o[1];
		
		Iterator it = map.keySet().iterator();
		while(it.hasNext())
		{
			String key = (String) it.next();
			String value = (String) map.get(key);
			cust(comp,key,value);
		}
	}
	
	
	
	private void cust(JComponent comp, String key, String value) throws Exception
	{
		if(matches(key,"border"))		custBorder(comp,value);
		else if(matches(key,"foreground"))	custForeground(comp,value);
		else if(matches(key,"background"))	custBackground(comp,value);
		else if(matches(key,"opaque"))		custOpaque(comp,value);
		else if(matches(key,"font"))		custFont(comp,value);
		else if(matches(key,"tooltiptext"))	custToolTipText(comp,value);
	}
	
	private boolean matches(String key, String type)
	{return key.equals(type) || key.endsWith("."+type);}
	
	
	private void custBorder(JComponent comp, String value) throws Exception
	{
		Border border = (Border) stringToBorder.t(value);
		comp.setBorder(border);
	}
	
	
	private void custForeground(JComponent comp, String value) throws Exception
	{
		Color color = (Color) stringToColor.t(value);
		comp.setForeground(color);
	}
	
	
	private void custBackground(JComponent comp, String value) throws Exception
	{
		Color color = (Color) stringToColor.t(value);
		comp.setBackground(color);
	}
	
	
	private void custOpaque(JComponent comp, String value) throws Exception
	{
		boolean isOpaque = Boolean.parseBoolean(value);
		comp.setOpaque(isOpaque);
	}
	
	
	private void custFont(JComponent comp, String value) throws Exception
	{
		if(value.startsWith("derive "))
			comp.setFont(deriveFont(comp.getFont(),value.substring(7)));
		else comp.setFont(stringToFont(value));
	}
	
	
	private void custToolTipText(JComponent comp, String value) throws Exception
	{
		comp.setToolTipText(value);
	}
	
	
	
	
	
	
	private Font deriveFont(Font font, String value) throws Exception
	{return (Font) deriveFont.t(new Object[]{font,value});}
	
	private Font stringToFont(String value) throws Exception
	{return (Font) stringToFont.t(value);}

}
