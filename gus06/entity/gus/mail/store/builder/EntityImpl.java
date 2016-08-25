package gus06.entity.gus.mail.store.builder;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160608";}


	private Service buildHotmail;
	private Service buildGmail;


	public EntityImpl() throws Exception
	{
		buildHotmail = Outside.service(this,"gus.mail.store.builder.hotmail");
		buildGmail = Outside.service(this,"gus.mail.store.builder.gmail");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		String[] o = (String[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		String login = o[0];
		String password = o[1];
		
		Service builder = findBuilder(login);
		return builder.t(obj);
	}
	
	
	private Service findBuilder(String login) throws Exception
	{
		if(login.endsWith("@hotmail.com")) return buildHotmail;
		if(login.endsWith("@hotmail.fr")) return buildHotmail;
		
		if(login.endsWith("@gmail.com")) return buildGmail;
		if(login.endsWith("@gmail.fr")) return buildGmail;
		
		throw new Exception("Unsupported address: "+login);
	}
}
