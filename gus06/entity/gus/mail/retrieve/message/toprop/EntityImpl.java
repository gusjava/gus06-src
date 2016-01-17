package gus06.entity.gus.mail.retrieve.message.toprop;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public static final String KEY_FROM = "from";
	public static final String KEY_DEST = "dest";
	public static final String KEY_EMAIL = "email";
	public static final String KEY_SENT = "sent";
	public static final String KEY_RECEIVED = "received";
	public static final String KEY_SUBJECT = "subject";
	public static final String KEY_CONTENT = "content";
	public static final String KEY_TYPE = "type";
	

	public String creationDate() {return "20151014";}

	
	private Service contentToString;
	
	
	public EntityImpl() throws Exception
	{contentToString = Outside.service(this,"gus.mail.retrieve.message.content.tostring");}



	public Object t(Object obj) throws Exception
	{return buildProp((Message) obj);}

	
	private Properties buildProp(Message message) throws Exception
	{
		Properties prop = new Properties();
		
		String from = from(message);
		String email = email(from);
		String dest = dest(message);
		String sent = dateToString(message.getSentDate());
		String received = dateToString(message.getReceivedDate());
		String type = message.getContentType();
		String subject = subject(message);
		String content = content(message);
		
		prop.setProperty(KEY_FROM,from);
		prop.setProperty(KEY_DEST,dest);
		prop.setProperty(KEY_EMAIL,email);
		prop.setProperty(KEY_SENT,sent);
		prop.setProperty(KEY_RECEIVED,received);
		prop.setProperty(KEY_SUBJECT,subject);
		prop.setProperty(KEY_CONTENT,content);
		prop.setProperty(KEY_TYPE,type);
		
		return prop;
	}
	
	
	
	
	
	
	
	private String subject(Message message) throws MessagingException
	{
		String s = message.getSubject();
		return s==null?"":s;
	}
	
	
	
	private String from(Message mail) throws MessagingException
	{
		String[] n = mail.getHeader("From");
		if(n!=null && n.length>0) return n[0];
		
		n = mail.getHeader("from");
		if(n!=null && n.length>0) return n[0];
		
		return "?";
	}
	
	
	private String dest(Message mail) throws MessagingException
	{
		Address[] d = mail.getAllRecipients();
		String s = InternetAddress.toString(d);
		return s==null?"":s;
	}
	
	
	
	
	private String email(String from)
	{
		String[] n = from.split("[<>]+");
		if(n.length==1)return from;
		else return n[1];
	}
	
	
	
	private String content(Message mail)
	{
		try{return (String) contentToString.t(mail);}
		catch(Exception e)
		{
			Outside.err(this,"content(Message)",e);
			return e.toString();
		}
	}
	
	
	
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
	
	private String dateToString(Date date)
	{return date==null?"":sdf.format(date);}

}
