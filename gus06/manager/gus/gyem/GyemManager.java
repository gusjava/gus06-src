package gus06.manager.gus.gyem;

import gus06.framework.Entity;
import gus06.framework.Manager;
import gus06.framework.P;
import gus06.framework.Service;
import gus06.framework.T;

public class GyemManager extends GyemSystem implements Manager {

	
	public void sendError(Entity entity, String id, Exception e)
	{
		try{((P) module(M052_P_MANAGER_ERR)).p(new Object[]{entity,id,e});}
		catch(Exception e1){fatal_manager(e1);}
	}
	
	public Service callService(Entity entity, String id) throws Exception
	{return (Service) ((T) module(M053_T_MANAGER_SERVICE)).t(new Object[]{entity,id});}

	
	public Object callResource(Entity entity, String id) throws Exception
	{return ((T) module(M054_T_MANAGER_RESOURCE)).t(new Object[]{entity,id});}
}