package gus06.entity.gus.io.transfer.toprintstream;

import gus06.framework.*;
import java.io.*;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20140725";}
	
	
	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[])obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);

		InputStream is = (InputStream) o[0];
		PrintStream p = (PrintStream) o[1];
        
		InputStreamReader isr = null;
		BufferedReader br = null;

		try
		{
			isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
		
			String line = null;
			while((line = br.readLine())!=null) p.println(line);
		}
		finally
		{
			if(br!=null) br.close();
		}
	}
}
