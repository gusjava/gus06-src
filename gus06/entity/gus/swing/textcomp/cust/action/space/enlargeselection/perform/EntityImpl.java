package gus06.entity.gus.swing.textcomp.cust.action.space.enlargeselection.perform;

import gus06.framework.*;
import javax.swing.text.Element;
import javax.swing.text.JTextComponent;
import javax.swing.text.PlainDocument;
import javax.swing.JTextArea;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20140816";}



	public static final int SELECTION_EMPTY = 0;
	public static final int SELECTION_WORD = 1;
	public static final int SELECTION_LINE = 2;
	public static final int SELECTION_BLOC = 3;
	public static final int SELECTION_ALL = 4;

	public EntityImpl() throws Exception
	{
	}
	
	
	public void p(Object obj) throws Exception
	{
		if(obj instanceof JTextArea)
		perform((JTextComponent) obj);
	}
	
	
	
	
	private void perform(JTextComponent comp) throws Exception
	{
		if(comp.getSelectedText()==null) {selectWord(comp);return;}
		
		int start = comp.getSelectionStart();
		int end = comp.getSelectionEnd();
		int caret = comp.getCaretPosition();
		String selection = comp.getSelectedText();
		String text = comp.getText();
			
		int level = selectionLevel(text,selection,start,end);
			
		if(level==SELECTION_EMPTY) {selectWord(comp);return;}
		if(level==SELECTION_WORD) {selectLine(comp);return;}
		if(level==SELECTION_LINE) {selectBloc(comp);return;}
		if(level==SELECTION_BLOC) {comp.selectAll();return;}
		if(level==SELECTION_ALL) {comp.select(caret,caret);return;}
	}
	
	
	
	private void selectWord(JTextComponent comp)
	{
		int pos = comp.getCaretPosition();
		String text = comp.getText();
		int length = text.length();
		
		int start = pos-1;
		int end = pos;
		
		while(start>=0 && !isWordDelim(text.charAt(start))) start--;	
		while(end<length && !isWordDelim(text.charAt(end))) end++;
		
		if(start==end-1)
		{
			selectLine(comp);
			return;
		}
		if(start==comp.getSelectionStart()-1 && end==comp.getSelectionEnd())
		{
			selectLine(comp);
			return;
		}
		if(start>comp.getSelectionStart()-1 || end<comp.getSelectionEnd())
		{
			selectLine(comp);
			return;
		}
		comp.select(start+1,end);
	}
	
	
	
	
	
	private void selectLine(JTextComponent comp)
	{
		int pos = comp.getCaretPosition();
		String text = comp.getText();
		int length = text.length();
		
		int start = pos-1;
		int end = pos;
		
		while(start>=0 && !isLineDelim(text.charAt(start))) start--;	
		while(end<length && !isLineDelim(text.charAt(end))) end++;
		
		if(start==end-1)
		{
			comp.selectAll();
			return;
		}
		if(start==comp.getSelectionStart()-1 && end==comp.getSelectionEnd())
		{
			comp.selectAll();
			return;
		}
		if(start>comp.getSelectionStart()-1 || end<comp.getSelectionEnd())
		{
			comp.selectAll();
			return;
		}
		comp.select(start+1,end);
	}
	




	private void selectBloc(JTextComponent comp)
	{
		int pos = comp.getCaretPosition();
			String text = comp.getText();
			int length = text.length();
		
			int start = pos-1;
			int end = pos;
		
			while(start>=0 && !(isLineDelim(text.charAt(start)) && isLineDelim(text.charAt(start+1)))) start--;	
			while(end<length && !(isLineDelim(text.charAt(end)) && isLineDelim(text.charAt(end-1)))) end++;
		
			if(start==end-1)
			{
				comp.selectAll();
				return;
			}
			if(start==comp.getSelectionStart()-1 && end==comp.getSelectionEnd())
			{
				comp.selectAll();
				return;
			}
			if(start>comp.getSelectionStart()-1 || end<comp.getSelectionEnd())
			{
				comp.selectAll();
				return;
			}
			comp.select(start+1,end);
	}
	
	
	
	
	
	
	private int selectionLevel(String s, String selection, int start, int end)
	{
		if(start==end)
			return SELECTION_EMPTY;

		if(start==0 && end==s.length())
			return SELECTION_ALL;

		if(selection.contains("\n\n"))
			return SELECTION_BLOC;
		
		if(isBlocStart(s,start) && isBlocEnd(s,end))
			return SELECTION_BLOC;
		
		if(containsLineDelim(selection))
			return SELECTION_LINE;
	
		if(isLineStart(s,start) && isLineEnd(s,end))
			return SELECTION_LINE;
		
		if(containsWordDelim(selection))
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
	
	private boolean containsLineDelim(String s)
	{
		for(int i=0;i<s.length();i++)
		if(isLineDelim(s.charAt(i))) return true;
		return false;
	}
	
	
	private boolean isWordDelim(char c)
	{return " ,;:.!?{}()[]/\\\t\n\r<>=-+'\"".contains(""+c);}
	
	private boolean isLineDelim(char c)
	{return c=='\n' || c=='\r';}
}
