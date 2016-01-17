package gus06.entity.gus.swing.pwdfield.persister.pwd;

import gus06.framework.*;
import javax.swing.text.JTextComponent;
import javax.swing.JPasswordField;


public class EntityImpl implements Entity, V {

	public String creationDate() {return "20150621";}


	private Service manager;


	public EntityImpl() throws Exception
	{
		manager = Outside.service(this,"gus.app.persister1.manager");
	}
	
	
	public void v(String key, Object obj) throws Exception
	{
		final JPasswordField comp = (JPasswordField) obj;
		
		String pwd = (String) manager.r(key);
		if(pwd!=null) comp.setText(pwd);
		
		manager.v(key,new G(){
			public Object g() throws Exception {return new String(comp.getPassword());}
		});
	}
}
