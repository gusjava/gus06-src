package gus06.entity.gus.data.perform.close;

import gus06.framework.*;
import java.io.IOException;
import java.io.Closeable;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20151115";}
	
	
	public void p(Object obj) throws Exception
	{
		if(obj instanceof AutoCloseable) {close((AutoCloseable) obj);return;}
		if(obj instanceof Closeable) {close((Closeable) obj);return;}
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	private void close(AutoCloseable o)
	{
		try{o.close();}
		catch(Exception e){}
	}
	
	private void close(Closeable o)
	{
		try{o.close();}
		catch(IOException e){}
	}
}
