package gus06.entity.gus.sys.popup1.manager;

import gus06.framework.*;
import java.util.Map;
import java.util.HashMap;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class EntityImpl implements Entity, P, G {

	public String creationDate() {return "20161005";}
	
	public static final String KEY_DATE = "date";


	private Service getNow;
	private Service displayer;
	
	private List notifs;


	public EntityImpl() throws Exception
	{
		getNow = Outside.service(this,"gus.time.now");
		displayer = Outside.service(this,"gus.sys.popup1.displayer");
		
		notifs = new ArrayList();
	}
	
	
	public Object g() throws Exception
	{return notifs;}
	
	
	public void p(Object obj) throws Exception
	{
		Map notif = (Map) obj;
		
		notif.put(KEY_DATE,getNow.g());
		notifs.add(notif);
		
		displayer.p(notif);
	}
}
