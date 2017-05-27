package gus06.entity.gus.sys.keystroke1.manager;

import gus06.framework.*;
import javax.swing.text.JTextComponent;
import javax.swing.Action;
import java.util.Map;
import java.util.HashMap;
import javax.swing.KeyStroke;
import java.util.Iterator;

public class EntityImpl extends S1 implements Entity, G, P, E {

	public String creationDate() {return "20170512";}


	private Service buildHolder;

	private Map map;
	

	public EntityImpl() throws Exception
	{
		buildHolder = Outside.service(this,"gus.sys.keystroke1.holder.id");
		
		map = new HashMap();
	}
	
	
	
	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=4) throw new Exception("Wrong data number: "+o.length);
		
		String id = (String) o[0];
		String key = (String) o[1];
		JTextComponent comp = (JTextComponent) o[2];
		Action action = (Action) o[3];
		
		if(!map.containsKey(id))
		{
			Object holder = buildHolder.t(new Object[]{id,key,comp,action});
			map.put(id,holder);
			added();
		}
		else
		{
			V holder = (V) map.get(id);
			holder.v("comp_action",new Object[]{comp,action});
		}
	}
	
	
	
	public void e() throws Exception
	{
		Iterator it = map.keySet().iterator();
		while(it.hasNext())
		{
			String key = (String) it.next();
			E holder = (E) map.get(key);
			holder.e();
		}
	}
	
	
	
	public Object g() throws Exception
	{return map;}
	
	
	private void added()
	{send(this,"added()");}
}
