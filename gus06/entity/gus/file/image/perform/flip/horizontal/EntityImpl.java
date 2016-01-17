package gus06.entity.gus.file.image.perform.flip.horizontal;

import java.io.File;
import gus06.framework.*;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20151002";}


	private Service applyTransform;
	private Service op;
	
	public EntityImpl() throws Exception
	{
		applyTransform = Outside.service(this,"gus.file.image.perform.apply.t");
		op = Outside.service(this,"gus.awt.renderedimage.transform.flip.horizontal");
	}


	public void p(Object obj) throws Exception
	{
		File file = (File) obj;
		applyTransform.p(new Object[]{file,op});
	}
}
