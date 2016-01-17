package gus06.entity.gus.file.perform.filecontent.fromclipboard;

import gus06.framework.*;
import java.io.File;
import java.util.List;

public class EntityImpl implements Entity, P, F, T {

	public String creationDate() {return "20150530";}


	private Service fromClipboard;
	private Service writeToFile;



	public EntityImpl() throws Exception
	{
		fromClipboard = Outside.service(this,"gus.clipboard.access");
		writeToFile = Outside.service(this,"gus.file.write.generic");
	}
	
	
	public void p(Object obj) throws Exception
	{t(obj);}
	
	
	public boolean f(Object obj) throws Exception
	{return t(obj)==null;}
	
	
	
	public Object t(Object obj) throws Exception
	{
		File file = (File) obj;
		
		Object data = fromClipboard.g();
		if(data==null) return null;
		
		if(data instanceof List) data = extractFile((List) data);
		if(data==null) return null;
		
		writeToFile.p(new Object[]{file,data});
		return data;
	}
	
	
	private File extractFile(List list)
	{
		if(list.size()!=1) return null;
		return (File) list.get(0);
	}
}
