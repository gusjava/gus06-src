package gus06.entity.gus.reflection.method.getstaticreturn;

import gus06.framework.*;
import java.lang.reflect.Method;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20140821";}

	
	
	public Object t(Object obj) throws Exception
	{
		Method method = (Method) obj;
		
		if(method.isAccessible())
			return method.invoke(null,new Object[]{});
	
		method.setAccessible(true);
		Object value = method.invoke(null,new Object[]{});
		method.setAccessible(false);
		
		return value;
	}
}
