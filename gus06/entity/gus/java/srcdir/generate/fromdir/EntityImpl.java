package gus06.entity.gus.java.srcdir.generate.fromdir;

import gus06.framework.*;
import java.io.File;
import java.util.List;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20170223";}


	private Service findFiles;
	private Service generate;


	public EntityImpl() throws Exception
	{
		findFiles = Outside.service(this,"gus.dir.listing.dirtofiles.forext.java");
		generate = Outside.service(this,"gus.java.srcdir.generate.fromfile");
	}
	
	
	public void p(Object obj) throws Exception
	{
		File[] o = (File[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		File dir_input = o[0];
		File dir_output = o[1];
		
		List files = (List) findFiles.t(dir_input);
		for(int i=0;i<files.size();i++)
		{
			File f = (File) files.get(i);
			if(isValid(f)) generate.p(new File[]{f,dir_output});
		}
	}
	
	
	private boolean isValid(File file)
	{
		String name = file.getName();
		return !name.equals("package-info.java");
	}
}
