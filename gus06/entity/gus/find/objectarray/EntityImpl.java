package gus06.entity.gus.find.objectarray;

import gus06.framework.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151101";}


	private Service fromList;
	private Service fromDoubleArray;
	private Service fromIntArray;
	private Service fromBooleanArray;
	private Service fromLongArray;
	private Service fromFloatArray;
	private Service fromByteArray;
	private Service fromShortArray;
	
	
	public EntityImpl() throws Exception
	{
		fromList = Outside.service(this,"gus.convert.listtoobjectarray");
		fromDoubleArray = Outside.service(this,"gus.convert.doublearraytoobjarray");
		fromIntArray = Outside.service(this,"gus.convert.intarraytoobjarray");
		fromBooleanArray = Outside.service(this,"gus.convert.booleanarraytoobjarray");
		fromLongArray = Outside.service(this,"gus.convert.longarraytoobjarray");
		fromFloatArray = Outside.service(this,"gus.convert.floatarraytoobjarray");
		fromByteArray = Outside.service(this,"gus.convert.bytearraytoobjarray");
		fromShortArray = Outside.service(this,"gus.convert.shortarraytoobjarray");
	}

	
	
	public Object t(Object obj) throws Exception
	{
		if(obj instanceof Object[]) return (Object[]) obj;
		if(obj instanceof List) return fromList.t(obj);
		if(obj instanceof Set) return fromList.t(new ArrayList((Set) obj));
		
		if(obj instanceof double[]) return fromDoubleArray.t(obj);
		if(obj instanceof int[]) return fromIntArray.t(obj);
		if(obj instanceof boolean[]) return fromBooleanArray.t(obj);
		if(obj instanceof long[]) return fromLongArray.t(obj);
		if(obj instanceof float[]) return fromFloatArray.t(obj);
		if(obj instanceof byte[]) return fromByteArray.t(obj);
		if(obj instanceof short[]) return fromShortArray.t(obj);
		
		return new Object[]{obj};
	}
}
