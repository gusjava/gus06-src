package gus06.entity.gus.swing.textcomp.cust.action.w.quickreplace.buildexecute.t;

import gus06.framework.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20140816";}


	public EntityImpl() throws Exception
	{
	}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		String[] o1 = (String[]) o[0];
		int[] o2 = (int[]) o[1];
		
		String textMem = o1[0];
		String selected = o1[1];
		String replacement = o1[2];
		
		int position = o2[0];
		int del_before = o2[1];
		int del_after = o2[2];
		
		if(selected.equals(""))
			return replaceByPosition(textMem,replacement,del_before,del_after,position);
		return replaceByRegex(selected,replacement,del_before,del_after);
	}
	
	
	private T replaceByPosition(String textMem, String replacement, int del_before, int del_after, int position) throws Exception
	{
		if(position==textMem.length() || textMem.charAt(position)=='\n')
		return new ReplaceAtEndOfLine(replacement,del_before,del_after);
		
		int d = 0;
		while(d<position && textMem.charAt(position-d-1)!='\n') d++;
		return new ReplaceAtFixedPosition(replacement,del_before,del_after,d);
	}
		
		
	private T replaceByRegex(String selected, String replacement, int del_before, int del_after) throws Exception
	{
		StringBuffer b = new StringBuffer();
		for(int i=0;i<del_before;i++) b.append(".");
		b.append(convert(selected));
		for(int i=0;i<del_after;i++) b.append(".");
            
		String exp = b.toString();
		String newExp = convert(replacement);
            
		return new ReplaceByRegex(exp,newExp); 
	}
	
	
	
	private String convert(String in)
        {
        	StringBuffer b = new StringBuffer();
        	for(int i=0;i<in.length();i++)
        	{
        		char c = in.charAt(i);
        		if(c=='*' || c=='?' || c=='+' || c=='.' || c=='\\'
        		|| c=='(' || c==')' || c==']' || c=='[' || c=='{' || c=='}')
        			b.append('\\');
        		b.append(c);
        	}
        	return b.toString();
        }
	
	
	
	
	
	
	public class ReplaceAtEndOfLine implements T
	{
		private String replacement;
		private int del_before;
		private int del_after;
    
		public ReplaceAtEndOfLine(String replacement, int del_before, int del_after)
		{
			this.replacement = replacement;
			this.del_before = del_before;
			this.del_after = del_after;
		}
		
		public Object t(Object obj) throws Exception
		{
			String text = (String) obj;
			StringBuffer b = new StringBuffer();
        
			for(int i=0;i<text.length();i++)
			{
				if(text.charAt(i)=='\n')
				{
					if(del_before>0) b.delete(b.length()-del_before,b.length());
					if(del_after>0) i += del_after;
					b.append(replacement);
				}
				b.append(text.charAt(i));
			}
			if(del_before>0) b.delete(b.length()-del_before,b.length());
			b.append(replacement);        
			return b.toString();
		}
	}
	
	
	
	
	
	
	
	
	public class ReplaceAtFixedPosition implements T
	{
		private String replacement;
		private int del_before;
		private int del_after;
		private int d;
    
		private int counter;
		private StringBuffer b;

		public ReplaceAtFixedPosition(String replacement, int del_before, int del_after, int d)
		{
			this.replacement = replacement;
			this.del_before = del_before;
			this.del_after = del_after;
			this.d = d;
		}

		public Object t(Object obj) throws Exception
		{
			String text = (String) obj;
			b = new StringBuffer();
			counter=0;
        
			for(int i=0;i<text.length();i++)
			{
				char c = text.charAt(i);
				handlePosition(i,c);
				counter++;
				if(c=='\n') endOfLine(i);
			}
			return b.toString();
		}
		
		private void handlePosition(int currentPos, char currentChar)
		{
			if(counter==d) b.append(replacement);
			if(counter<d-del_before || counter>=d+del_after) b.append(currentChar);
		}
    
		private void endOfLine(int currentPos)
		{counter=0;}
	}







	public class ReplaceByRegex implements T
	{
		private String exp;
		private String newExp;

		public ReplaceByRegex(String exp, String newExp)
		{
			this.exp = exp;
			this.newExp = newExp;
		}
		
		public Object t(Object obj) throws Exception
		{
			String text = (String) obj;
			Matcher m = Pattern.compile(exp).matcher(text);
			return m.replaceAll(newExp);
		}
	}
}
