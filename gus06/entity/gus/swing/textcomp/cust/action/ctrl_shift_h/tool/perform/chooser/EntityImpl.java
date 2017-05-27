package gus06.entity.gus.swing.textcomp.cust.action.ctrl_shift_h.tool.perform.chooser;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160828";}
	
	
	private Service t1;
	private Service t2;

	public EntityImpl() throws Exception
	{
		t1 = Outside.service(this,"gus.swing.textcomp.cust.action.ctrl_shift_h.tool.perform.chooser.t1.key");
		t2 = Outside.service(this,"gus.swing.textcomp.cust.action.ctrl_shift_h.tool.perform.chooser.t2.build");
	}
	
	public Object t(Object obj) throws Exception
	{
		String key = (String) t1.g();
		return t2.t(new Object[]{obj,key});
	}
}
