package gus06.entity.gus.sys.clipboard1.todir.writecontent.image;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20151021";}


	private Service buildFile;
	private Service writeFile;


	public EntityImpl() throws Exception
	{
		buildFile = Outside.service(this,"gus.sys.clipboard1.g.listfiles.buildfile");
		writeFile = Outside.service(this,"gus.file.write.image.jai.bmp");
	}
	
	
	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		File dir = (File) o[0];
		Object image = o[1];
		
		File file = (File) buildFile.t(new Object[]{dir,"bmp"});
		dir.mkdirs();
		writeFile.p(new Object[]{file,image});
	}
}
