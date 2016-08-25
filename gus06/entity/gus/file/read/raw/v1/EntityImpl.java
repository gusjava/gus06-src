package gus06.entity.gus.file.read.raw.v1;

import gus06.framework.*;
import java.io.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160526";}

	
	
	public Object t(Object obj) throws Exception
	{return read((File) obj);}
	
	
	
	private byte[] read(File file) throws Exception
	{
		ByteArrayOutputStream ous = null;
		InputStream ios = null;
		try
		{
			byte[] buffer = new byte[4096];
			ous = new ByteArrayOutputStream();
			ios = new FileInputStream(file);
			int read = 0;
			while((read = ios.read(buffer)) != -1)
			ous.write(buffer,0,read);
		}
		finally
		{
			try{if(ous != null) ous.close();}
			catch(IOException e) {}

			try{if(ios != null) ios.close();}
			catch(IOException e) {}
		}
		return ous.toByteArray();
	}
}
