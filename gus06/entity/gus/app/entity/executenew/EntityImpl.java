package gus06.entity.gus.app.entity.executenew;

import gus06.framework.*;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20140809";}

	private Service newEntity;
	
	
	public EntityImpl() throws Exception
	{
		newEntity = Outside.service(this,"entitynew");
	}
	
	
	
	public void p(Object obj) throws Exception
	{
		String entityName = (String) obj;
		Object entity = newEntity.t(entityName);
		
		if(!(entity instanceof E))
			throw new Exception("Entity "+entityName+" is not executable");
		((E) entity).e();
	}
}
