package gus06.entity.gus.dir.runtask.corpus.properties.mail.inbox.importmessages;

import gus06.framework.*;
import java.io.File;
import javax.mail.Folder;
import javax.mail.Message;
import java.util.Properties;
import java.util.Set;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20160608";}


	private Service buildInbox;
	private Service askInfos;
	private Service messageToProp;
	private Service messageToTimeStamp;
	private Service writeProp;
	
	public EntityImpl() throws Exception
	{
		buildInbox = Outside.service(this,"gus.mail.store.inbox.builder");
		askInfos = Outside.service(this,"gus.security.askinfo.loginpassword1");
		messageToProp = Outside.service(this,"gus.mail.retrieve.message.toprop");
		messageToTimeStamp = Outside.service(this,"gus.mail.retrieve.message.totimestamp");
		writeProp = Outside.service(this,"gus.dir.access.write.properties.autorename");
	}

	
	
	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=3) throw new Exception("Wrong data number: "+o.length);
		
		File dir = (File) o[0];
		Object progress = o[1];
		Set interrupt = (Set) o[2];
		
		String[] infos = (String[]) askInfos.g();
		if(infos==null) return;
		
		Folder folder = (Folder) buildInbox.t(infos);
		folder.open(Folder.READ_ONLY);
		
		Message[] messages = folder.getMessages();
		
		int size = messages.length;
		if(progress!=null) ((V)progress).v("size",""+size);
		
		for(int i=0;i<size;i++)
		{
			Properties p = (Properties) messageToProp.t(messages[i]);
			String timeStamp = (String) messageToTimeStamp.t(messages[i]);
			writeProp.p(new Object[]{dir,timeStamp,p});
			
			if(progress!=null) ((E)progress).e();
			if(interrupt!=null && !interrupt.isEmpty()) break;
		}
		
		folder.close(false);
	}
}
