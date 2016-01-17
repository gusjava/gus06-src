package gus06.entity.gus.string.transform.normalize.filename;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20140909";}


	public static final char C = '_';

	/*
	 * caractères interdits dans les noms de fichier sous Windows :
	 * \ / : * ? " < > |
	 */
	public Object t(Object obj) throws Exception
	{
		String s = (String) obj;
		
		return s.replace('\\',C).
				replace('/',C).
				replace(':',C).
				replace('*',C).
				replace('?',C).
				replace('"',C).
				replace('<',C).
				replace('>',C).
				replace('|',C).
				replace('\t',C).
				replace('\n',C).
				replace('\r',C);
	}
}
