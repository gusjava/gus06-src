package gus06.entity.gus.string.extract.date.en.a;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import gus06.framework.*;
import java.util.List;
import java.util.ArrayList;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170212";}
	
	public static final String REGEX_99 = "[0-9]{2}";
	public static final String REGEX_YEAR = "[12][0-9]{3}";
	public static final String REGEX_YEAR2 = "(("+REGEX_YEAR+")|("+REGEX_99+"))";
	
	public static final String REGEX_DAY = "((0?[1-9])|(1[0-9])|(2[0-9])|(30)|(31))";
	public static final String REGEX_MONTH = "((0?[1-9])|(10)|(11)|(12))";
	
	public static final String REGEX = REGEX_YEAR2+"-"+REGEX_MONTH+"-"+REGEX_DAY; //aaaa-mm-jj
	


	private Pattern p;

	public EntityImpl() throws Exception
	{
		p = Pattern.compile(REGEX);
	}



	public Object t(Object obj) throws Exception
	{
		String text = (String) obj;
		Matcher m = p.matcher(text.toLowerCase());
		
		List list = new ArrayList();
		while(m.find())	list.add(m.group());
		return list;
	}
}
