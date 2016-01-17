package gus06.entity.gus.swing.textcomp.cust2.keystroke.init.control.q;

import gus06.framework.*;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20150908";}
	
	public static final String KEY = "control Q";


	private Service initKey;
	
	public EntityImpl() throws Exception
	{initKey = Outside.service(this,"gus.swing.textcomp.cust2.keystroke.init");}
	
	public void p(Object obj) throws Exception
	{initKey.v(KEY,obj);}
}