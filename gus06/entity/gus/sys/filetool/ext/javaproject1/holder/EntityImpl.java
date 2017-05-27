package gus06.entity.gus.sys.filetool.ext.javaproject1.holder;

import gus06.framework.*;
import java.util.Map;
import java.io.File;

public class EntityImpl implements Entity, I, P, Runnable {

	public String creationDate() {return "20170220";}
	
	
	private Service findRoot;
	private Service gui;
	
	private Map map;
	private Thread t;
	


	public EntityImpl() throws Exception
	{
		findRoot = Outside.service(this,"gus.sys.filetool.findroot");
		gui = Outside.service(this,"*gus.sys.javaprojectviewer1.gui");
	}
	
	
	public Object i() throws Exception
	{return gui.i();}
	
	
	
	public void p(Object obj) throws Exception
	{
		if(t!=null && t.isAlive()) return;
		
		map = (Map) obj;
		
		t = new Thread(this,"THREAD_"+getClass().getName());
		t.start();
	}
	
	
	public void run()
	{
		try
		{
			File root = (File) findRoot.t(map);
			gui.p(root);
		}
		catch(Exception e)
		{Outside.err(this,"run()",e);}
	}
}
