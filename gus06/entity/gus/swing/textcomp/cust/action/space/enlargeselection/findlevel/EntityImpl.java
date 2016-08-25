package gus06.entity.gus.swing.textcomp.cust.action.space.enlargeselection.findlevel;

import gus06.framework.*;
import javax.swing.text.JTextComponent;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160426";}

	public static final String SELECTION_EMPTY = "EMPTY";
	public static final String SELECTION_WORD = "WORD";
	public static final String SELECTION_LINE = "LINE";
	public static final String SELECTION_BLOC = "BLOC";
	public static final String SELECTION_ALL = "ALL";


	
	
	public Object t(Object obj) throws Exception
	{
		JTextComponent comp = (JTextComponent) obj;
		
		if(comp.getSelectedText()==null)
			return SELECTION_EMPTY;
		
		int start = comp.getSelectionStart();
		int end = comp.getSelectionEnd();
		
		String s1 = comp.getSelectedText();
		String s = comp.getText();
		
		if(start==end)
			return SELECTION_EMPTY;

		if(start==0 && end==s.length())
			return SELECTION_ALL;

		if(s1.contains("\n\n"))
			return SELECTION_BLOC;
		
		if(isBlocStart(s,start) && isBlocEnd(s,end))
			return SELECTION_BLOC;
		
		if(containsLineDelim(s1))
			return SELECTION_LINE;
	
		if(isLineStart(s,start) && isLineEnd(s,end))
			return SELECTION_LINE;
		
		if(containsWordDelim(s1))
			return SELECTION_WORD;

		if(isWordStart(s,start) && isWordEnd(s,end))
			return SELECTION_WORD;

		return SELECTION_EMPTY;
	}
	
	
	
	
	private boolean isBlocStart(String s, int start)
	{
		if(start==0) return true;
		if(start==1 && isLineDelim(s.charAt(0))) return true;
		if(start>=2 && isLineDelim(s.charAt(start-1)) && isLineDelim(s.charAt(start-2))) return true;
		return false;
	}
	
	private boolean isBlocEnd(String s, int end)
	{
		int length = s.length();
		if(end==length) return true;
		if(end==length-1 && isLineDelim(s.charAt(length-1))) return true;
		if(end<=length-2 && isLineDelim(s.charAt(end+1)) && isLineDelim(s.charAt(end+2))) return true;
		return false;
	}
	
	
	
	
	
	private boolean isLineStart(String s, int start)
	{
		if(start==0) return true;
		if(start>=1 && isLineDelim(s.charAt(start-1))) return true;
		return false;
	}
	
	private boolean isLineEnd(String s, int end)
	{
		int length = s.length();
		if(end==length) return true;
		if(end<=length-1 && isLineDelim(s.charAt(length-1))) return true;
		return false;
	}
	
	private boolean containsLineDelim(String s)
	{
		for(int i=0;i<s.length();i++)
		if(isLineDelim(s.charAt(i))) return true;
		return false;
	}
	
	private boolean isLineDelim(char c)
	{return c=='\n' || c=='\r';}
	
	
	
	
	
	
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
	
	private boolean containsWordDelim(String s)
	{
		for(int i=0;i<s.length();i++)
		if(isWordDelim(s.charAt(i))) return true;
		return false;
	}
	
	private boolean isWordDelim(char c)
	{return " ,;:.!?{}()[]/\\\t\n\r<>=-+'\"".contains(""+c);}
}