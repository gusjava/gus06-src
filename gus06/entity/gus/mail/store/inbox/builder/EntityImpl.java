package gus06.entity.gus.mail.store.inbox.builder;

import gus06.framework.*;
import javax.mail.Store;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160608";}
	
	public static final String INBOX = "INBOX";


	private Service storeBuilder;


	public EntityImpl() throws Exception
	{
		storeBuilder = Outside.service(this,"gus.mail.store.builder");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		Store store = (Store) storeBuilder.t(obj);
		return store.getFolder(INBOX);
	}
}
