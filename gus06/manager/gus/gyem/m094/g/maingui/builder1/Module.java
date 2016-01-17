package gus06.manager.gus.gyem.m094.g.maingui.builder1;

import javax.swing.JComponent;
import gus06.manager.gus.gyem.GyemSystem;
import gus06.framework.*;


public class Module extends GyemSystem implements G {

	public Object g() throws Exception
	{
		Object obj = ((T) module(M103_T_GENERATOR)).t(PROP_MAINGUI);
		return toComp(obj);
	}
	
	
	private JComponent toComp(Object obj) throws Exception
	{
		if(obj==null) return null;
		if(obj instanceof JComponent) return (JComponent) obj;
		if(obj instanceof I) return (JComponent) ((I) obj).i();
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
}