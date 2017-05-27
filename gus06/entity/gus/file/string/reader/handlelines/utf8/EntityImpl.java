package gus06.entity.gus.file.string.reader.handlelines.utf8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import gus06.framework.*;
import java.util.Set;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20160913";}
	
	public static final String CHARSET = "UTF-8";


	private Service getLineNumber;
	
	public EntityImpl() throws Exception
	{
		getLineNumber = Outside.service(this,"gus.file.string.info.linenumber");
	}


	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=4) throw new Exception("Wrong data number: "+o.length);
		
		File file = (File) o[0];
		P handler = (P) o[1];
		Object progress = o[2];
		Set interrupt = (Set) o[3];
		
		String nb = (String) getLineNumber.t(file);
		if(progress!=null) ((V)progress).v("size",nb);
		
		FileInputStream fis = new FileInputStream(file);
		InputStreamReader isr = new InputStreamReader(fis,CHARSET);
		BufferedReader br = new BufferedReader(isr);
		
		try
		{
			String line = null;
			while((line = br.readLine())!=null)
			{
				handler.p(line);
				if(progress!=null) ((E) progress).e();
				if(interrupt!=null && !interrupt.isEmpty()) break;
			}
		}
		finally {fis.close();}
	}
}
