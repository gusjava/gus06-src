package gus06.entity.gus.file.editor.ext.java.custcomp;

import gus06.framework.*;
import javax.swing.text.JTextComponent;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20140727";}

	
	private Service custComp;
	private Service autoImport;
	//private Service highSyntax;


	public EntityImpl() throws Exception
	{
		custComp = Outside.service(this,"gus.file.editor.ext.txt.custcomp");
		autoImport = Outside.service(this,"gus.swing.textcomp.cust.action.f2.java.autoimport");
		//highSyntax = Outside.service(this,"gus.swing.textpane.cust.syntax.java.ostermiller");
	}
	
	
	
	public void p(Object obj) throws Exception
	{
		JTextComponent comp = (JTextComponent) obj;

		custComp.p(comp);
		autoImport.p(comp);
		//highSyntax.p(comp);
	}
}
