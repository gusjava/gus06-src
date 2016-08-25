package gus06.entity.gus.swing.dialog.persister.position;

import gus06.framework.*;
import javax.swing.JDialog;

public class EntityImpl implements Entity, V {

	public String creationDate() {return "20160605";}


	private Service manager;
	private Service dialogToInfo;
	private Service infoToDialog;


	public EntityImpl() throws Exception
	{
		manager = Outside.service(this,"gus.app.persister1.manager");
		dialogToInfo = Outside.service(this,"gus.swing.dialog.dialogtobounds");
		infoToDialog = Outside.service(this,"gus.swing.dialog.cust2.position");
	}
	
	
	public void v(String key, Object obj) throws Exception
	{
		final JDialog comp = (JDialog) obj;
		
		String text = (String) manager.r(key);
		if(text!=null && !text.equals("")) custDialog(text,comp);
		
		manager.v(key,new G(){
			public Object g() throws Exception
			{return dialogToInfo.t(comp);}
		});
	}
	
	
	
	private void custDialog(String text, JDialog comp)
	{
		try{infoToDialog.v(text,comp);}
		catch(Exception e)
		{Outside.err(this,"custDialog(String,JDialog)",e);}
	}
}
