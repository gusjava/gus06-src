package gus06.entity.gus.file.perform.filecontent.fromclipboard.deletesrc;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, P, F, T {

	public String creationDate() {return "20151022";}


	private Service perform;
	private Service delete;



	public EntityImpl() throws Exception
	{
		perform = Outside.service(this,"gus.file.perform.filecontent.fromclipboard");
		delete = Outside.service(this,"gus.file.op.delete");
	}
	
	
	public void p(Object obj) throws Exception
	{f(obj);}
	
	
	public boolean f(Object obj) throws Exception
	{return t(obj)==null;}
	
	
	
	public Object t(Object obj) throws Exception
	{
		Object data = perform.t(obj);
		if(data==null) return null;
		
		if(data instanceof File) delete.p(data);
		return data;
	}
}
