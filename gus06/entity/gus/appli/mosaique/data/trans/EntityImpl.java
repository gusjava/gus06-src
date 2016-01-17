package gus06.entity.gus.appli.mosaique.data.trans;

import gus06.framework.*;

public class EntityImpl implements Entity, G {

	public String creationDate() {return "20141115";}


	private Service bestFit;

	public EntityImpl() throws Exception
	{bestFit = Outside.service(this,"gus.appli.mosaique.processor.bestfit");}
	
	
	public Object g() throws Exception
	{return bestFit;}
}
