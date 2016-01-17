package gus06.entity.gus.file.editor.ext.php.custcomp;

import gus06.framework.*;
import javax.swing.text.JTextComponent;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20141215";}

	
	private Service custComp;
	private Service autoEdit;


	public EntityImpl() throws Exception
	{
		custComp = Outside.service(this,"gus.file.editor.ext.txt.custcomp");
		autoEdit = Outside.service(this,"gus.swing.textcomp.cust.autoedit.javaediting1");
	}
	
	
	
	public void p(Object obj) throws Exception
	{
		JTextComponent comp = (JTextComponent) obj;

		custComp.p(comp);
		autoEdit.p(comp);
	}
}
