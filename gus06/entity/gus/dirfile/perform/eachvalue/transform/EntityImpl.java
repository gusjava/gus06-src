package gus06.entity.gus.dirfile.perform.eachvalue.transform;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20161115";}



	private Service handleProp;
	private Service isProp;


	public EntityImpl() throws Exception
	{
		handleProp = Outside.service(this,"gus.file.properties.perform.each.value.transform");
		isProp = Outside.service(this,"gus.file.filter.mime.istype.text.properties");
	}
	
	
	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		File input = (File) o[0];
		
		if(isProp.f(input)) {handleProp.p(obj);return;}
		
		throw new Exception("Invalid file type: "+input);
	}
}
