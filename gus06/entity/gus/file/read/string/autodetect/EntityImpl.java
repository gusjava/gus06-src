package gus06.entity.gus.file.read.string.autodetect;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

import gus06.framework.*;


public class EntityImpl implements Entity, T {

	public String creationDate() {return "20140710";}


	private Service findCharset;
	
	public EntityImpl() throws Exception
	{findCharset = Outside.service(this,"gus.file.string.info.charset");}


	public Object t(Object obj) throws Exception
	{
		File file = (File) obj;
		
		if(file==null) return "";
		if(!file.exists()) return "";
		if(file.length()==0) return "";
		
		Charset charset = charset(file);
		return read(file,charset);
	}
	
	
	private String read(File file, Charset charset) throws Exception
	{
		FileInputStream fis = new FileInputStream(file);
		InputStreamReader isr = new InputStreamReader(fis,charset);
		BufferedReader br = new BufferedReader(isr);
		StringBuffer b = new StringBuffer();
		
		String line;
		while((line = br.readLine())!=null) b.append(line+"\n");
		br.close();
		
		if(b.length()>0) b.deleteCharAt(b.length()-1);
		return b.toString();
	}
	
	
	private Charset charset(File file) throws Exception
	{
		Charset charset = (Charset) findCharset.t(file);
		return charset!=null?charset:Charset.defaultCharset();
	}
}
