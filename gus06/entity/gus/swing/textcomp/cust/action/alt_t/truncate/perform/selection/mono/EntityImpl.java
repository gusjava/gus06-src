package gus06.entity.gus.swing.textcomp.cust.action.alt_t.truncate.perform.selection.mono;

import gus06.framework.*;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20160903";}


	private Service mono;

	public EntityImpl() throws Exception
	{mono = Outside.service(this,"gus.swing.textcomp.cust.action.alt_t.truncate.perform.caret");}

	public void p(Object obj) throws Exception
	{mono.p(obj);}
}
