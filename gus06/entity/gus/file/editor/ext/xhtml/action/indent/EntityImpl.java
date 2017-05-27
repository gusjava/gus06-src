package gus06.entity.gus.file.editor.ext.xhtml.action.indent;

import gus06.framework.*;
import javax.swing.text.JTextComponent;
import javax.swing.SwingUtilities;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170228";}
	
	public static final String DISPLAY = "TEXT_indent#Indent code";


	private Service perform;
	private Service transformText;
	private Service buildAction;


	public EntityImpl() throws Exception
	{
		perform = Outside.service(this,"gus.string.transform.xhtml.indent");
		transformText = Outside.service(this,"gus.swing.textcomp.perform3.transformtext");
		buildAction = Outside.service(this,"gus.swing.action.builder1");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		JTextComponent comp = (JTextComponent) obj;
		Holder holder = new Holder(comp);
		
		return buildAction.t(new Object[]{DISPLAY,holder});
	}
	
	
	private void perform(JTextComponent comp)
	{
		try
		{
			transformText.p(new Object[]{comp,perform});
		}
		catch(Exception e)
		{Outside.err(this,"perform(JTextComponent)",e);}
	}
	
	
	
	
	private class Holder implements E, Runnable
	{
		private JTextComponent comp;
		public Holder(JTextComponent comp)
		{this.comp = comp;}
		
		public void e() throws Exception
		{SwingUtilities.invokeLater(this);}
		
		public void run()
		{perform(comp);}
	}
}
