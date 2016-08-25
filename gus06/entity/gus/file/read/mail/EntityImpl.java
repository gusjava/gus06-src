package gus06.entity.gus.file.read.mail;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160609";}


	private Service emlToMessage;


	public EntityImpl() throws Exception
	{
		emlToMessage = Outside.service(this,"gus.mail.message.emlfile.tomessage");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		return emlToMessage.t(obj);
	}
}
