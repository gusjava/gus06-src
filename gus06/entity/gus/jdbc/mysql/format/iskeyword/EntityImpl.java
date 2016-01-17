package gus06.entity.gus.jdbc.mysql.format.iskeyword;

import gus06.framework.*;

public class EntityImpl implements Entity, F {

	public String creationDate() {return "20150624";}

	

	public boolean f(Object obj) throws Exception
	{
		String name = (String) obj;
		return MYSQL_RESERVED_WORDS.isReservedWord(name);
	}
	
	/*
	 * Autre manière : utiliser la méthode dbmd.getSQLKeywords() à partir des metadata de la connexion
	 */
}
