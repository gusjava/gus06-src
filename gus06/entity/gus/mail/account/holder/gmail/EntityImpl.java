package gus06.entity.gus.mail.account.holder.gmail;

import com.sun.mail.pop3.POP3SSLStore;
import gus06.framework.*;
import java.util.Properties;
import javax.mail.*;

public class EntityImpl implements Entity, R, V, E {

	public String creationDate() {return "20140904";}
	
	
	public static final String SMTP_HOST = "smtp.gmail.com";
	public static final int SMTP_PORT = 465;
    
	public static final String POP_HOST = "pop.gmail.com";
	public static final int POP_PORT = 995;
	
	
	
	
	private String login;
	private String password;

	private Session transportSession;
	private Transport transport;
	
	private Session storeSession;
	private Store store;
	
	
	
	
	
	
	public void e() throws Exception
	{
		resetAll();
	}
	


	public Object r(String key) throws Exception
	{
		if(key.equals("transport")) return getTransport();
		if(key.equals("store")) return getStore();
		if(key.equals("transportSession")) return transportSession;
		if(key.equals("storeSession")) return storeSession;
		
		if(key.equals("keys")) return new String[]{"transport","store","transportSession","storeSession"};
		throw new Exception("Unknown key: "+key);
	}
	
	
	
	public void v(String key, Object obj) throws Exception
	{
		if(key.equals("login")) {login = (String) obj;return;}
		if(key.equals("password")) {password = (String) obj;return;}
		
		throw new Exception("Unknown key: "+key);
	}
	
	
	
	
	
	
	private void initLogin(String login)
	{
		resetAll();
		this.login = login;
	}
	
	
	private void initPassword(String password)
	{
		resetAll();
		this.password = password;
	}
    
    
    
	private void resetAll()
	{
		if(transport!=null) closeTransport();
		if(store!=null) closeStore();
    	
		transportSession = null;
		transport = null;
		storeSession = null;
		store = null;
	}
	
	
	
	
	private void closeTransport()
	{
		if(transport==null) return;
		try{transport.close();}
		catch(Exception e){}
	}
    
	private void closeStore()
	{
		if(store==null) return;
		try{store.close();}
		catch(Exception e){}
	}
	
	
	
	
	private void checkLoginPassword() throws Exception
	{
		if(login==null || login.equals(""))
			throw new Exception("Login has not been initialized");
		if(password==null || password.equals(""))
			throw new Exception("Password has not been initialized");
	}
	
	
	
	
	private Transport getTransport() throws Exception
	{
		if(transport==null || !transport.isConnected()) initTransport();
		return transport;
	}

    
	private Store getStore() throws Exception
	{
		if(store==null || !store.isConnected()) initStore();
		return store;
	}
	
	
	
	private void initTransport() throws Exception
	{
		checkLoginPassword();
		
		Properties p = new Properties();
		p.put("mail.smtp.host", SMTP_HOST);
		p.put("mail.smtp.user", login);
		p.put("mail.smtp.port", ""+SMTP_PORT);
		p.put("mail.smtp.starttls.enable","true");
		p.put("mail.smtp.auth", "true");
		p.put("mail.smtp.debug", "true");
		p.put("mail.smtp.socketFactory.port", ""+SMTP_PORT);
		p.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		p.put("mail.smtp.socketFactory.fallback", "false");

		transportSession = Session.getDefaultInstance(p, null);
		transport = transportSession.getTransport("smtp");
		transport.connect(SMTP_HOST,login,password);
	}
	
	
	


	private void initStore() throws Exception
	{
		checkLoginPassword();
		
		Properties p = new Properties();
		p.setProperty("mail.pop3.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		p.setProperty("mail.pop3.socketFactory.fallback","false");
		p.setProperty("mail.pop3.port",""+POP_PORT);
		p.setProperty("mail.pop3.socketFactory.port",""+POP_PORT);
		
		URLName url = new URLName("pop3",POP_HOST,POP_PORT,"",login, password);
		
		storeSession = Session.getInstance(p, null);
		store = new POP3SSLStore(storeSession, url);
		store.connect();
	}
}
