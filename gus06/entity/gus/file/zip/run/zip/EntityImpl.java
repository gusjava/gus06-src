package gus06.entity.gus.file.zip.run.zip;

import gus06.framework.*;
import java.io.File;
import java.util.Set;
import java.nio.charset.Charset;
import java.io.FileOutputStream;
import java.io.BufferedOutputStream;
import java.util.zip.ZipOutputStream;
import java.util.zip.ZipEntry;
import java.io.FileInputStream;
import java.util.List;
import java.util.ArrayList;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20150605";}
	
	public static final Charset CHARSET = Charset.forName("Cp437");
	public static int BUFFER = 2048;
	public static int LEVEL = 7;




	private Service listing;
	
	public EntityImpl() throws Exception
	{
		listing = Outside.service(this,"gus.dir.listing.topaths");
	}
		
	
	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=4) throw new Exception("Wrong data number: "+o.length);
		
		Object input = o[0];
		File zipFile = (File) o[1];
		Object progress = o[2];
		Set interrupt = (Set) o[3];
		
		List l = buildListing(input);
		
		int number = l.size();
		File parent = getParent(input);
		int rootLength = parent.getAbsolutePath().length();
		
		ZipOutputStream zos = null;
		
		try
		{
			zipFile.getParentFile().mkdirs();
			FileOutputStream fos = new FileOutputStream(zipFile);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			zos = new ZipOutputStream(bos,CHARSET);
        
			zos.setMethod(ZipOutputStream.DEFLATED);
			zos.setLevel(LEVEL);
		
		
			if(progress!=null) ((V)progress).v("size",""+number);
			for(int i=0;i<number;i++)
			{
				File f = (File) l.get(i);
				String name = entryName(f,rootLength);
			
				ZipEntry entry = new ZipEntry(name);
				zos.putNextEntry(entry);
				
				if(f.isFile())
				{
					int b;
					byte data[] = new byte[BUFFER];
					FileInputStream fis = new FileInputStream(f);
					while((b = fis.read(data,0,BUFFER))!=-1)
					{zos.write(data,0,b);}
					fis.close();
				}
            
				zos.closeEntry();
				
				if(progress!=null) ((E)progress).e();
				if(interrupt!=null && !interrupt.isEmpty()) break;
			}
		}
		finally
		{
			if(zos!=null)
			{
				zos.finish();
				zos.close();
			}
		}
	}
	
	
	
	
	private List buildListing(Object input) throws Exception
	{return (List) listing.t(input);}
	
	
	
	private File getParent(Object input) throws Exception
	{
		if(input instanceof File)
			return ((File) input).getParentFile();
		if(input instanceof File[])
			return ((File[]) input)[0].getParentFile();
			
		throw new Exception("Invalid data type: "+input.getClass().getName());
	}
	
	
	
	private String entryName(File f, int rootLength)
	{
		String n = f.getAbsolutePath().substring(rootLength).replace(File.separator,"/");
		if(n.startsWith("/")) n = n.substring(1);
		if(f.isDirectory() && !n.endsWith("/")) n = n+"/";
		return n;
	}
}
