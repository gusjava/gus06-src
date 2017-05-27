package gus06.entity.gus.string.extract.extract1.find.f.rf;

import gus06.framework.*;
import java.util.regex.Pattern;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160821";}


	private Service buildPattern;
	private Service perform;

	public EntityImpl() throws Exception
	{
		buildPattern = Outside.service(this,"gus.string.extract.extract1.pattern.reluctant");
		perform = Outside.service(this,"gus.string.extract.match.first");
	}

	public Object t(Object obj) throws Exception
	{
		String[] o = (String[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		return extract(o[0],o[1]);
	}
	
	private Object extract(String data, String rule) throws Exception
	{
		String pattern = (String) buildPattern.t(rule);
		Pattern p = Pattern.compile(pattern,Pattern.DOTALL);
		return perform.t(new Object[]{data,p});
	}
}
