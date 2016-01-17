package gus06.entity.gus.io.transfer.toprintstream.thr;

import gus06.framework.*;
import java.io.*;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20141231";}


	private Service transfer;
	
	
	public EntityImpl() throws Exception
	{transfer = Outside.service(this,"gus.io.transfer.toprintstream");}


	
	public void p(Object obj) throws Exception
	{
		Runnable r = new Runnable1(obj);
		new Thread(r,"THREAD_"+getClass().getName()).start();
	}
	
	
	private void transfer(Object data)
	{
		try{transfer.p(data);}
		catch(Exception e)
		{Outside.err(this,"transfer(Object)",e);}
	}
	
	
	
	
	private class Runnable1 implements Runnable
	{
		private Object data;
		public Runnable1(Object data)
		{this.data = data;}
		
		public void run()
		{transfer(data);}
	}
}
