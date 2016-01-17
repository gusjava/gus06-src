package gus06.entity.gus.appli.gusclient1.execute.pseudo.register.step2;

import gus06.framework.*;
import java.io.File;
import java.util.Map;
import javax.swing.JOptionPane;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20141014";}


	private Service init;
	private Service sendPost;


	
	public EntityImpl() throws Exception
	{
		init = Outside.service(this,"gus.sys.crypto.pseudo.init");
		sendPost = Outside.service(this,"gus.web.httprequest.post.send");
	}
	
	
	public void p(Object obj) throws Exception
	{
		String url = (String) obj;
		Map m = (Map) init.g();
		
		sendPost.v("map",m);
		String res = (String) sendPost.t(url);
		
		JOptionPane.showMessageDialog(null,message(res));
	}
	
	
	
	private String message(String res)
	{
		if(res.equals("done")) return "Pseudo successfully registered.";
		return "Registration has failed.";
	}
}
