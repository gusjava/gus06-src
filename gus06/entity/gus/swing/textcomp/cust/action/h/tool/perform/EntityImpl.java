package gus06.entity.gus.swing.textcomp.cust.action.h.tool.perform;

import gus06.framework.*;
import javax.swing.text.Element;
import javax.swing.text.JTextComponent;
import javax.swing.text.PlainDocument;
import javax.swing.JTextArea;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20141105";}


	private Service transformText;
	private Service chooseTrans;


	public EntityImpl() throws Exception
	{
		transformText = Outside.service(this,"gus.swing.textcomp.perform3.transformtext");
		chooseTrans = Outside.service(this,"gus.swing.textcomp.cust.action.h.tool.chooser");
	}
	
	
	public void p(Object obj) throws Exception
	{perform((JTextComponent) obj);}
	
	
	
	private void perform(JTextComponent comp) throws Exception
	{
		T t = (T) chooseTrans.g();
		if(t==null) return;
		
		transformText.p(new Object[]{comp,t});
	}
}
