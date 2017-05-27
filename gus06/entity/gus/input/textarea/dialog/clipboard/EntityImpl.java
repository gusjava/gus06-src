package gus06.entity.gus.input.textarea.dialog.clipboard;

import gus06.framework.*;

public class EntityImpl implements Entity, G, T {

	public String creationDate() {return "20170421";}


	private Service dialog;
	private Service clipboard;

	public EntityImpl() throws Exception
	{
		dialog = Outside.service(this,"gus.input.textarea.dialog");
		clipboard = Outside.service(this,"gus.clipboard.access.string");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		String title = (String) obj;
		String initValue = (String) clipboard.g();
		if(initValue==null) initValue = "";
		
		return dialog.t(new String[]{title,initValue});
	}
	
	public Object g() throws Exception
	{return t("INPUT");}
}
