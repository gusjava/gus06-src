package gus06.entity.gus.sys.expression1.apply.op._extract_parenthesis_f;

import gus06.framework.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.io.File;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160817";}

	public static final String KEY_PARENTHESIS = "()";


	private Service readText;
	private Service regexFromRule;
	private Pattern p;
	
	public EntityImpl() throws Exception
	{
		readText = Outside.service(this,"gus.file.read.string.generic");
		regexFromRule = Outside.service(this,"gus.string.transform.regexp.fromrule");
		String regex = (String) regexFromRule.r(KEY_PARENTHESIS);
		p = Pattern.compile(regex,Pattern.DOTALL);
	}


	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		if(obj instanceof String) return extract((String) obj);
		if(obj instanceof File) return extract((String) readText.t(obj));
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	private String extract(String data) throws Exception
	{
		Matcher m = p.matcher(data);
		
		if(!m.find()) return null;
		return m.group();
	}
}
