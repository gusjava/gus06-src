package gus06.entity.gus.feature.wrap.comp.gpi;

import gus06.framework.*;
import javax.swing.JPanel;
import javax.swing.JComponent;

public class EntityImpl implements Entity, T, G {

	public String creationDate() {return "20150708";}

	
	
	public Object t(Object obj) throws Exception
	{return new Wrap((JComponent) obj);}
	
	public Object g() throws Exception
	{return new Wrap(new JPanel());}
	
	
	
	
	private class Wrap implements G, I, P
	{
		private JComponent data;
		public Wrap(JComponent data) {this.data = data;}
		
		public Object g() throws Exception
		{return data;}
		
		public void p(Object obj) throws Exception
		{this.data = (JComponent) obj;}
		
		public JComponent i() throws Exception
		{return data;}
	}
}
