package gus06.entity.gus.swing.textcomp.cust.action.space.enlargeselection.perform.xml;

import gus06.framework.*;
import javax.swing.text.JTextComponent;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20160426";}

	
	
	public void p(Object obj) throws Exception
	{
		JTextComponent comp = (JTextComponent) obj;
		
		String s = comp.getSelectedText();
		if(!s.startsWith("<") || !s.endsWith(">"))
			throw new Exception("Invalid xml tag: "+s);
		
		if(s.charAt(1)=='/')
		{
			String name = s.substring(2,s.length()-1);
			goBack(comp,name);
		}
		else
		{
			String name = s.substring(1,s.length()-1).split(" ")[0];
			goForward(comp,name);
		}
	}
	
	
	
	
	private void goForward(JTextComponent comp, String name)
	{
		String startTag = "<"+name+">";
		String startTag0 = "<"+name+" ";
		String closeTag = "</"+name+">";
		
		int l1 = startTag.length();
		int l10 = startTag0.length();
		int l2 = closeTag.length();
		
		int start = comp.getSelectionStart();
		int end = comp.getSelectionEnd();
		
		String text = comp.getText();
		int length = text.length();
		
		int pos = end;
		int k = 1;
		
		while(k>0 && pos<length)
		{
			char c = text.charAt(pos);
			if(c=='<')
			{
				String text_ = text.substring(pos);
				
				if(text_.startsWith(startTag))
				{k++;pos+=l1;}
				
				else if(text_.startsWith(startTag0))
				{k++;pos+=l10;}
				
				else if(text_.startsWith(closeTag))
				{k--;pos+=l2;}
			}
			pos++;
		}
		
		comp.select(start,pos-1);
	}
	
	
	
	
	
	private void goBack(JTextComponent comp, String name)
	{
		String startTag = "<"+name+">";
		String startTag0 = "<"+name+" ";
		String closeTag = "</"+name+">";
		
		int start = comp.getSelectionStart();
		int end = comp.getSelectionEnd();
		String text = comp.getText();
		
		int pos = start-1;
		int k = 1;
		
		while(k>0 && pos>=0)
		{
			char c = text.charAt(pos);
			if(c=='<')
			{
				String text_ = text.substring(pos);
				
				if(text_.startsWith(startTag))k--;
				else if(text_.startsWith(startTag0))k--;
				else if(text_.startsWith(closeTag))k++;
			}
			pos--;
		}
		
		comp.select(pos+1,end);
	}
}
