package gus06.entity.gus.swing.textcomp.cust.action.ctrl_shift_w.smartreplace;

import gus06.framework.*;
import java.awt.event.ActionEvent;
import javax.swing.text.JTextComponent;
import javax.swing.AbstractAction;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20160430";}

	public static final String DEFAULT_KEY = "ctrl shift w";
	
	
	private Service buildHolder;
	private Service buildTransform;
	private Service manageKeyStroke;
	
	public EntityImpl() throws Exception
	{
		buildHolder = Outside.service(this,"gus.sys.quickreplace.holder.find");
		buildTransform = Outside.service(this,"gus.swing.textcomp.cust.action.ctrl_shift_w.smartreplace.t");
		manageKeyStroke = Outside.service(this,"gus.sys.keystroke1.manager");
	}
	
	
	public void p(Object obj) throws Exception
	{
		JTextComponent comp = (JTextComponent) obj;
		P holder = (P) buildHolder.t(comp);
		new Holder(comp,holder);
	}



	private class Holder extends AbstractAction
	{
		private P holder;
		
		public Holder(JTextComponent comp, P holder) throws Exception
		{
			this.holder = holder;
			manageKeyStroke.p(new Object[]{id(),DEFAULT_KEY,comp,this});
		}
		public void actionPerformed(ActionEvent e)
		{execute(holder);}
	}
	
	
	private void execute(P holder)
	{
		try{holder.p(buildTransform);}
		catch(Exception e)
		{Outside.err(this,"execute(P)",e);}
	}
	
	private String id()
	{return getClass().getName();}
}
