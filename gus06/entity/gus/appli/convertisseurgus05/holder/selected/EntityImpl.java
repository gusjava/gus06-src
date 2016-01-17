package gus06.entity.gus.appli.convertisseurgus05.holder.selected;

import gus06.framework.*;

public class EntityImpl extends S1 implements Entity, P, G {

	public String creationDate() {return "20150525";}


	private String name;
	
	public Object g() throws Exception
	{return name;}
	
	
	public void p(Object obj) throws Exception
	{
		name = (String) obj;
		modified();
	}
	
	
	private void modified()
	{send(this,"modified()");}
}
