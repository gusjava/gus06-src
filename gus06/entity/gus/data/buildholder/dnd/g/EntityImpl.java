package gus06.entity.gus.data.buildholder.dnd.g;

import gus06.framework.*;
import javax.swing.JComponent;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20161016";}


	private Service dnd;
	
	public EntityImpl() throws Exception
	{
		dnd = Outside.service(this,"gus.awt.dnd");
	}

	
	public Object t(Object obj) throws Exception
	{return new Holder((JComponent) obj);}
	
	
	
	private class Holder extends S1 implements P, G, R
	{
		private JComponent comp;
		private Object data;
		
		public Holder(JComponent comp) throws Exception
		{
			this.comp = comp;
			
			dnd.v("g",this);
			dnd.p(comp);
		}
		
		public Object g() throws Exception
		{return data;}
		
		public void p(Object obj) throws Exception
		{
			data = obj;
			modified();
		}
		
		
		public Object r(String key) throws Exception
		{
			if(key.equals("comp")) return comp;
			if(key.equals("keys")) return new String[]{"comp"};
			
			throw new Exception("Unknown key: "+key);
		}
		
		private void modified()
		{send(this,"modified()");}
	}
}
