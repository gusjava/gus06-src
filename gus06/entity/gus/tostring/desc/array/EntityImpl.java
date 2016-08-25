package gus06.entity.gus.tostring.desc.array;

import java.util.Map;
import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151129";}


	private Service short1;
	
	public EntityImpl() throws Exception
	{short1 = Outside.service(this,"gus.tostring.desc.short1");}



	public Object t(Object obj) throws Exception
	{
		Object[] array = (Object[]) obj;
		
		StringBuffer b = new StringBuffer();
		b.append(short1.t(array)+"\n");
		
		for(int i=0;i<array.length;i++)
		{
			Object value = array[i];
			b.append(i+"-"+short1.t(value)+"\n");
		}
		if(b.length()>0) b.deleteCharAt(b.length()-1);
		return b.toString();
	}
}
