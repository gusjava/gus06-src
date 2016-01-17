package gus06.entity.gus.file.rar.innosystec.unrar;

import gus06.framework.*;
import java.io.File;
import java.io.OutputStream;
import java.util.List;
import java.util.Set;

public class EntityImpl implements Entity, P {
	
	public String creationDate() {return "20150630";}
	
	
	
   
	public void p(Object obj) throws Exception
	{
		Object[] t = (Object[]) obj;
		if(t.length!=4) throw new Exception("Wrong data number: "+t.length);
		
		File rarFile = (File) t[0];
		T tran = (T) t[1];
		Object progress = t[2];
		Set interrupt = (Set) t[3];
		
		Inno_Archive a = null;
		
		try
		{
			a = new Inno_Archive(rarFile);
			List<Inno_FileHeader> list = a.getFileHeaders();
		
			if(progress!=null) ((V)progress).v("size",""+list.size());
			for(int i=0; i<list.size(); i++)
			{
				Inno_FileHeader fh = list.get(i);
				handle(a,fh,tran);
				
				if(progress!=null) ((E)progress).e();
				if(interrupt!=null && !interrupt.isEmpty()) break;
			}
		}
		finally
		{
			if(a!=null) a.close();
		}
	}
	
	
	
	
	
	private void handle(Inno_Archive a, Inno_FileHeader fh, T tran) throws Exception
	{
		if(fh.isDirectory()) return;
		
		String name = fh.getFileNameString().trim();
		OutputStream os = (OutputStream) tran.t(name);
		a.extractFile(fh,os);
		os.close();
	}
}