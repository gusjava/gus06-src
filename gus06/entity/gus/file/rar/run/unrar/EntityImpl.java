package gus06.entity.gus.file.rar.run.unrar;

import gus06.framework.*;
import java.io.File;
import java.util.Set;
import java.nio.charset.Charset;
import java.io.FileOutputStream;
import java.util.zip.ZipFile;
import java.util.zip.ZipEntry;
import java.util.ArrayList;
import java.util.Enumeration;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20150630";}


	private Service perform;
	

	public EntityImpl() throws Exception
	{
		perform = Outside.service(this,"gus.file.rar.innosystec.unrar");
	}


	
	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=4) throw new Exception("Wrong data number: "+o.length);
		
		File file = (File) o[0];
		File dir = (File) o[1];
		Object progress = o[2];
		Set interrupt = (Set) o[3];
		
		T t = new Trans(dir);
		perform.p(new Object[]{file,t,progress,interrupt});
	}
	
	
	
	
	
	private class Trans implements T
	{
		private File dir;
		public Trans(File dir) {this.dir = dir;}
		
		public Object t(Object obj) throws Exception
		{
			String name = (String) obj;
			name = name.replace("\\",File.separator).replace("/",File.separator);
			
			File f = new File(dir,name);
			f.getParentFile().mkdirs();
			return new FileOutputStream(f);
		}
	}
}
