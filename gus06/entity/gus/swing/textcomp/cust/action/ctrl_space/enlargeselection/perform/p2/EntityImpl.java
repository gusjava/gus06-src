package gus06.entity.gus.swing.textcomp.cust.action.ctrl_space.enlargeselection.perform.p2;

import gus06.framework.*;
import javax.swing.text.JTextComponent;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20160426";}


	private Service perform_p3;
	private Service perform_xml;

	public EntityImpl() throws Exception
	{
		perform_p3 = Outside.service(this,"gus.swing.textcomp.cust.action.ctrl_space.enlargeselection.perform.p3");
		perform_xml = Outside.service(this,"gus.swing.textcomp.cust.action.ctrl_space.enlargeselection.perform.xml");
	}
	
	
	public void p(Object obj) throws Exception
	{selectBloc((JTextComponent) obj);}
	


	private void selectBloc(JTextComponent comp) throws Exception
	{
		if(comp.getSelectedText().matches("<[^>]+>"))
		{perform_xml.p(comp);return;}
		
		int pos = comp.getCaretPosition();
		String text = comp.getText();
		int length = text.length();
	
		int start = pos-1;
		int end = pos;
	
		while(start>0 && !(isLineDelim(text.charAt(start)) && isLineDelim(text.charAt(start+1)))) start--;	
		while(end<length && !(isLineDelim(text.charAt(end)) && isLineDelim(text.charAt(end-1)))) end++;
	
		while(start<pos-1 && isLineDelim(text.charAt(start))) start++;	
		while(end>pos && isLineDelim(text.charAt(end))) end--;
		
		if(start==end-1)
		{
			perform_p3.p(comp);
			return;
		}
		if(start==comp.getSelectionStart() && end==comp.getSelectionEnd()-1)
		{
			perform_p3.p(comp);
			return;
		}
		if(start>comp.getSelectionStart() || end<comp.getSelectionEnd()-1)
		{
			perform_p3.p(comp);
			return;
		}
		comp.select(start,end+1);
	}
	
	
	private boolean isLineDelim(char c)
	{return c=='\n' || c=='\r';}
}
