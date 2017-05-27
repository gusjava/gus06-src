package gus06.entity.gus.sys.expression1.apply.op._jpanel;

import gus06.framework.*;
import java.awt.Color;
import javax.swing.JComponent;
import java.awt.BorderLayout;
import javax.swing.JPanel;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160505";}


	private Service colorToPanel;
	
	public EntityImpl() throws Exception
	{
		colorToPanel = Outside.service(this,"gus.convert.colortojpanel");
	}

	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		if(obj instanceof Color) return colorToPanel.t(obj);
		if(obj instanceof JComponent) return compToJPanel((JComponent) obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	private JPanel compToJPanel(JComponent comp)
	{
		JPanel p = new JPanel(new BorderLayout());
		p.add(comp,BorderLayout.CENTER);
		return p;
	}
}
