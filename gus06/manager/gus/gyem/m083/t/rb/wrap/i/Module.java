package gus06.manager.gus.gyem.m083.t.rb.wrap.i;

import javax.swing.JComponent;

import gus06.framework.I;
import gus06.framework.T;
import gus06.manager.gus.gyem.GyemSystem;

public class Module extends GyemSystem implements T {

	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		String buildInfo = (String) o[0];
		Object src = o[1];
		
		JComponent comp = (JComponent) ((T) module(M054_T_MANAGER_RESOURCE)).t(new Object[]{null,buildInfo});
		return new Wrap(comp);
	}
	
	
	private class Wrap implements I
	{
		private JComponent comp;
		public Wrap(JComponent comp) {this.comp = comp;}
		
		public JComponent i() throws Exception
		{return comp;}
	}
}