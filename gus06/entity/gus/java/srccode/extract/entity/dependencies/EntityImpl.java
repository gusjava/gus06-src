package gus06.entity.gus.java.srccode.extract.entity.dependencies;

import gus06.framework.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Set;
import java.util.HashSet;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150311";}
	

	public static final String PART = "[a-z_][a-z0-9_]*";
	public static final String PSEUDO = "[a-z][a-z][a-z][a-z0-9]*";
	public static final String NAME = "("+PSEUDO+")(\\."+PART+")+";
	
	public static final Pattern P = Pattern.compile(NAME);
	
	
	
	private Service findPseudo;
	
	
	public EntityImpl() throws Exception
	{
		findPseudo = Outside.service(this,"gus.entitydev.find.pseudoset");
	}


	
	public Object t(Object obj) throws Exception
	{
		if(obj==null) return null;
		return extract((String) obj);
	}
	
	
	private Set extract(String s) throws Exception
	{
		Set set = new HashSet();
		Set pseudo = (Set) findPseudo.g();
		
		Matcher m = P.matcher(s);
		while(m.find())
		{
			String g = m.group();
			String g1 = m.group(1);
			
			if(pseudo.contains(g1)) set.add(g);
		}
		return set;
	}
}
