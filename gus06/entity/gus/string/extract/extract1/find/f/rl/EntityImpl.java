package gus06.entity.gus.string.extract.extract1.find.f.rl;

import gus06.framework.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.List;
import java.util.ArrayList;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160821";}


	private Service buildPattern;

	public EntityImpl() throws Exception
	{
		buildPattern = Outside.service(this,"gus.string.extract.extract1.pattern.reluctant");
	}



	
	public Object t(Object obj) throws Exception
	{
		String[] o = (String[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		return extract(o[0],o[1]);
	}
	
	
	
	
	private String extract(String data, String rule) throws Exception
	{
		String pattern = (String) buildPattern.t(rule);
		
		Pattern p = Pattern.compile(pattern,Pattern.DOTALL);
		Matcher m = p.matcher(data);
		
		String result = null;
		while(m.find()) result = m.group();
		return result;
	}
}
