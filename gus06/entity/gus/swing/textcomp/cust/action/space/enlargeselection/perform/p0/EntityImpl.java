package gus06.entity.gus.swing.textcomp.cust.action.space.enlargeselection.perform.p0;

import gus06.framework.*;
import javax.swing.text.JTextComponent;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20160426";}


	private Service perform_p1;
	private Service delim;
	private String delim_;
	

	public EntityImpl() throws Exception
	{
		perform_p1 = Outside.service(this,"gus.swing.textcomp.cust.action.space.enlargeselection.perform.p1");
		delim = Outside.service(this,"gus.string.split.words1.delim");
		delim_ = (String) delim.g();
	}
	
	
	public void p(Object obj) throws Exception
	{selectWord((JTextComponent) obj);}
	
	
	
	
	private void selectWord(JTextComponent comp) throws Exception
	{
		String text = comp.getText();
		int length = text.length();
		int pos = comp.getCaretPosition();
		int start1 = comp.getSelectionStart();
		int end1 = comp.getSelectionEnd();
		
		int start = pos-1;
		int end = pos;
		
		char c_before = start>=0 ? text.charAt(start) : '~';
		char c_after = end<length ? text.charAt(end) : '~';
		
		
		
		if(c_before=='"')
		{
			end = reachNext(text,length,end,'"');
		}
		else if(c_before=='\'')
		{
			end = reachNext(text,length,end,'\'');
		}
		else if(c_before=='<')
		{
			end = reachClosing(text,length,end+1,'<','>');
		}
		else if(c_before=='(')
		{
			end = reachClosing(text,length,end,'(',')');
		}
		else if(c_before=='[')
		{
			end = reachClosing(text,length,end+1,'[',']');
		}
		else if(c_before=='{')
		{
			end = reachClosing(text,length,end+1,'{','}');
		}
		else if(c_before=='>')
		{
			// A FAIRE
			// ici il faut d�tecter si le caret est juste apr�s un tag xml ouvrant <name> ou <name ...>
			// et s�lection jusqu'au caract�re avant le tag xml fermant correspondant </name>
		}
		
		
		
		else if(c_after=='"')
		{
			end = reachNext(text,length,end+1,'"');
			if(end<length) end++;
		}
		else if(c_after=='\'')
		{
			end = reachNext(text,length,end+1,'\'');
			if(end<length) end++;
		}
		else if(c_after=='<')
		{
			end = reachClosing(text,length,end+1,'<','>');
			if(end<length) end++;
		}
		else if(c_after=='(')
		{
			end = reachClosing(text,length,end+1,'(',')');
			if(end<length) end++;
		}
		else if(c_after=='[')
		{
			end = reachClosing(text,length,end+1,'[',']');
			if(end<length) end++;
		}
		else if(c_after=='{')
		{
			end = reachClosing(text,length,end+1,'{','}');
			if(end<length) end++;
		}
		
		
		else
		{
			while(start>=0 && !isWordDelim(text.charAt(start))) start--;
			while(end<length && !isWordDelim(text.charAt(end))) end++;
		}
		
		
		if(start==end-1)
		{
			perform_p1.p(comp);
			return;
		}
		if(start==start1-1 && end==end1)
		{
			perform_p1.p(comp);
			return;
		}
		if(start>start1-1 || end<end1)
		{
			perform_p1.p(comp);
			return;
		}
		comp.select(start+1,end);
	}
	
	
	
	
	private int reachNext(String text, int length, int pos, char last)
	{
		while(pos<length && text.charAt(pos)!=last) pos++;
		return pos;
	}
	
	
	private int reachClosing(String text, int length, int pos, char opening, char closing)
	{
		int k = 0;
		char c = text.charAt(pos);
		while(pos<length-1 && (c!=closing || k>0))
		{
			if(c==opening) k++;
			else if(c==closing) k--;
			c = text.charAt(++pos);
		}
		return pos;
	}
	

	private boolean isWordStart(String s, int start)
	{
		if(start==0) return true;
		if(start>=1 && isWordDelim(s.charAt(start-1))) return true;
		return false;
	}
	
	private boolean isWordEnd(String s, int end)
	{
		int length = s.length();
		if(end==length) return true;
		if(end<=length-1 && isWordDelim(s.charAt(length-1))) return true;
		return false;
	}
	
	private boolean isWordDelim(char c)
	{return delim_.indexOf(c)>=0;}
}
