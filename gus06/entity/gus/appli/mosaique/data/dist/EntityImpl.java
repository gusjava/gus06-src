package gus06.entity.gus.appli.mosaique.data.dist;

import gus06.framework.*;

public class EntityImpl implements Entity, G {

	public String creationDate() {return "20141122";}


	private Service distance;

	public EntityImpl() throws Exception
	{
		distance = Outside.service(this,"gus.awt.bufferedimage.distance.grid_3_3");
	}
	
	
	public Object g() throws Exception
	{
		return distance;
	}
	
	
}
