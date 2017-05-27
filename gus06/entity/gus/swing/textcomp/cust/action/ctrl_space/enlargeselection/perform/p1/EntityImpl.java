package gus06.entity.gus.swing.textcomp.cust.action.ctrl_space.enlargeselection.perform.p1;

import gus06.framework.*;
import javax.swing.text.JTextComponent;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20160426";}


	private Service perform_p2;
	private Service perform_xml;

	public EntityImpl() throws Exception
	{
		perform_p2 = Outside.service(this,"gus.swing.textcomp.cust.action.ctrl_space.enlargeselection.perform.p2");
		perform_xml = Outside.service(this,"gus.swing.textcomp.cust.action.ctrl_space.enlargeselection.perform.xml");
	}
	
	
	public void p(Object obj) throws Exception
	{selectLine((JTextComponent) obj);}
	
	
	
	private void selectLine(JTextComponent comp) throws Exception
	{
		String s = comp.getSelectedText();
	
		if(s!=null && s.matches("<[^>]+>"))
		{perform_xml.p(comp);return;}
		
		int pos = comp.getCaretPosition();
		String text = comp.getText();
		int length = text.length();
		
		int start = pos-1;
		int end = pos;
		
		while(start>=0 && !isLineDelim(text.charAt(start))) start--;
		while(end<length && !isLineDelim(text.charAt(end))) end++;
		
		if(start==end-1)
		{
			perform_p2.p(comp);
			return;
		}
		if(start==comp.getSelectionStart()-1 && end==comp.getSelectionEnd())
		{
			perform_p2.p(comp);
			return;
		}
		if(start>comp.getSelectionStart()-1 || end<comp.getSelectionEnd())
		{
			perform_p2.p(comp);
			return;
		}
		comp.select(start+1,end);
	}
	
	
	private boolean isLineDelim(char c)
	{return c=='\n' || c=='\r';}
}
