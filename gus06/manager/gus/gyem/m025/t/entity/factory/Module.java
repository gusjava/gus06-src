package gus06.manager.gus.gyem.m025.t.entity.factory;

import gus06.framework.T;
import gus06.framework.R;
import gus06.framework.G;
import gus06.manager.gus.gyem.GyemSystem;

public class Module extends GyemSystem implements T, R {

	
	public Object t(Object obj) throws Exception
	{
		String entityName = (String) obj;
		return new Factory(entityName);
	}
	
	
	public Object r(String key) throws Exception
	{return t(key);}

	

	private class Factory implements G
	{
		private String entityName;
		
		public Factory(String entityName)
		{this.entityName = entityName;}
		
		public Object g() throws Exception
		{return ((T) module(M028_T_ENTITY_GENERATOR)).t(entityName);}
	}
}