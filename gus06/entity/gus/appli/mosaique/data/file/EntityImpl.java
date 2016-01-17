package gus06.entity.gus.appli.mosaique.data.file;

import gus06.framework.*;
import java.io.File;

public class EntityImpl extends S1 implements Entity, P, G {

	public String creationDate() {return "20141115";}


	private Service persister;
	

	private File file;
	
	public EntityImpl() throws Exception
	{
		persister = Outside.service(this,"gus.app.persister1.data.file");
		file = (File) persister.r(getClass().getName());
	}

	public Object g() throws Exception
	{return file;}
	
	public void p(Object obj) throws Exception
	{
		file = (File) obj;
		persister.v(getClass().getName(),file);
		modified();
	}
	
	private void modified()
	{send(this,"modified()");}
}
