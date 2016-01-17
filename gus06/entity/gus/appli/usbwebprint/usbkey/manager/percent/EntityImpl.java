package gus06.entity.gus.appli.usbwebprint.usbkey.manager.percent;

import gus06.framework.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EntityImpl extends S1 implements Entity, ActionListener, G {

	public String creationDate() {return "20140915";}

	public static final String STATE_READING = "reading";
	
	

	private Service extractor;
	private Service extractorState;
	
	private String value;


	public EntityImpl() throws Exception
	{
		extractor = Outside.service(this,"gus.appli.usbwebprint.usbkey.extractor");
		extractorState = Outside.service(this,"gus.appli.usbwebprint.usbkey.extractor.state");
		
		extractor.addActionListener(this);
		extractorState.addActionListener(this);
	}
	
	
	public Object g() throws Exception
	{return value;}
	


	public void actionPerformed(ActionEvent e)
	{updateGui();}
	
	
	
	
	private void updateGui()
	{
		try
		{
			value = computeValue();
			valueUpdated();
		}
		catch(Exception e)
		{Outside.err(this,"updateGui()",e);}
	}



	private void valueUpdated()
	{send(this,"valueUpdated()");}
	
	
	
	
	private String computeValue() throws Exception
	{
		String state = (String) extractorState.g();
		if(!state.equals(STATE_READING)) return null;
		
		int[] n = (int[]) extractor.r("progress");
		double d = (double)n[0]/(double)n[1]*100.0;
		return ""+(int) d;
	}
}
