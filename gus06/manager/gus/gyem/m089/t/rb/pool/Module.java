package gus06.manager.gus.gyem.m089.t.rb.pool;

import java.io.File;

import gus06.framework.R;
import gus06.framework.T;
import gus06.manager.gus.gyem.GyemSystem;

public class Module extends GyemSystem implements T {

	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		String buildInfo = (String) o[0];
		Object src = o[1];
		
		
		String entityName = srcToEntityName(src);
		
		File poolDir = (File) ((R) module(M102_R_FILEPROVIDER)).r(PATH_GYEM_POOLDIR);
		if(poolDir==null) throw new Exception("Pool dir could not be found");
		
		File entityDir = new File(poolDir,entityName);
		
		entityDir.mkdirs();
		if(!entityDir.isDirectory())
			throw new Exception("Failed to initialize entity pool dir: "+entityDir);
		
		return entityDir;
	}


	
	
	private String srcToEntityName(Object src) throws Exception
	{
		String srcString = (String) ((T) module(M062_T_SERVICE_SRCTOSTRING)).t(src);
		return srcString.split("@")[0];
	}
}