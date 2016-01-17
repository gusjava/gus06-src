package gus06.entity.gus.file.read.properties.from.eml;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151015";}


	private Service emlToMessage;
	private Service messageToProp;


	public EntityImpl() throws Exception
	{
		emlToMessage = Outside.service(this,"gus.mail.message.emlfile.tomessage");
		messageToProp = Outside.service(this,"gus.mail.retrieve.message.toprop");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		obj = emlToMessage.t(obj);
		return messageToProp.t(obj);
	}
}
