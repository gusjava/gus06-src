package gus06.entity.gus.swing.textcomp.textfocus.manager;

import gus06.framework.*;
import java.util.Map;
import java.util.HashMap;
import javax.swing.text.JTextComponent;
import java.util.ArrayList;
import java.util.List;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151107";}

	private Service back;
	private Map map;

	public EntityImpl() throws Exception
	{
		back = Outside.service(this,"gus.swing.textcomp.textfocus.back");
		map = new HashMap();
	}
	
	
	public Object t(Object obj) throws Exception
	{
		JTextComponent comp = (JTextComponent) obj;
		if(!map.containsKey(comp))
			map.put(comp,new Holder(comp));
		return map.get(comp);
	}
	
	
	private class Holder extends S1 implements P, G, E
	{
		private JTextComponent comp;
		private List queue;
		
		public Holder(JTextComponent comp)
		{
			this.comp = comp;
			queue = new ArrayList();
		}
		
		public void p(Object obj) throws Exception
		{
			Object[] o = (Object[]) obj;
			if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
			List l = (List) o[0];
			String text = (String) o[1];
			
			queue.add(l);
			comp.setText(text);
			focusChanged();
		}
		
		public void e() throws Exception
		{
			if(queue.isEmpty()) return;
			List l = (List) queue.remove(queue.size()-1);
			back.p(new Object[]{comp,l});
			focusChanged();
		}
		
		
		public Object g() throws Exception
		{return queue;}
		
		
		private void focusChanged()
		{send(this,"focusChanged()");}
	}
}
