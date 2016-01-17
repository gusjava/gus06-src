package gus06.entity.gus.filter.string.haschar.punctuation;

import gus06.framework.*;

public class EntityImpl implements Entity, F {

	public String creationDate() {return "20150526";}

	public boolean f(Object obj) throws Exception
	{
		if(obj==null) return false;

		String str = (String) obj;
		for(int i=0;i<str.length();i++)
			if(isPunctuation(str.charAt(i))) return true;
		return false;
	}

	private boolean isPunctuation(char c)
	{
		for(char a:PUNC) if(a==c) return true;
		return false;
	}

	public static final char[] PUNC = new char[]{
		'&','~','"','#','\'','{','(','[','-',
		'|','`','_','\\','^','@','°',')',']',
		'=','+','}','<','>',',','?',';','.',
		':','/','!','§','*','%','$','£','€'};
}