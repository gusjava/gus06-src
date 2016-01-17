package gus06.entity.gus.swing.textcomp.persister.text;

import gus06.framework.*;
import javax.swing.text.JTextComponent;


public class EntityImpl implements Entity, V {

	public String creationDate() {return "20140912";}


	private Service manager;


	public EntityImpl() throws Exception
	{
		manager = Outside.service(this,"gus.app.persister1.manager");
	}
	
	
	public void v(String key, Object obj) throws Exception
	{
		final JTextComponent comp = (JTextComponent) obj;
		
		String text = (String) manager.r(key);
		if(text!=null) comp.setText(text);
		
		manager.v(key,new G(){
			public Object g() throws Exception {return comp.getText();}
		});
	}
}
