package gus06.entity.gus.java.compiler.file;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20140727";}

	private Service findEntityName;
	private Service isManager;
	private Service isFramework;
	
	private Service compileEntity;
	private Service compileManager;
	private Service compileFramework;
	

	public EntityImpl() throws Exception
	{
		findEntityName = Outside.service(this,"gus.java.srcfile.extract.entity.name");
		isManager = Outside.service(this,"gus.java.srcfile.extract.manager.ismanager");
		isFramework = Outside.service(this,"gus.java.srcfile.extract.framework.isframework");
		
		compileEntity = Outside.service(this,"gus.java.compiler.entity");
		compileManager = Outside.service(this,"gus.java.compiler.manager");
		compileFramework = Outside.service(this,"gus.java.compiler.framework");
	}


	public void p(Object obj) throws Exception
	{
		File file = (File) obj;
	
		String entityName = (String) findEntityName.t(file);
		if(entityName!=null) {compileEntity.p(entityName);return;}
		
		if(isManager.f(file)) {compileManager.e();return;}
		if(isFramework.f(file)) {compileFramework.e();return;}
	}
}
