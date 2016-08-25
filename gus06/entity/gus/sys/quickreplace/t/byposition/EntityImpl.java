package gus06.entity.gus.sys.quickreplace.t.byposition;

import gus06.framework.*;
import java.util.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160430";}

	
	
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
		
		if(position==textMem.length() || textMem.charAt(position)=='\n')
		return new ReplaceAtEndOfLine(replacement,del_before,del_after);
		
		int d = 0;
		while(d<position && textMem.charAt(position-d-1)!='\n') d++;
		return new ReplaceAtFixedPosition(replacement,del_before,del_after,d);
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
			List ranges = new ArrayList();
			int length = text.length();
			
			for(int i=0;i<length;i++)
			if(text.charAt(i)=='\n')
			{
				int start = i-del_before;
				int end = i+del_after;
				
				if(start<0) start = 0;
				if(end>length) end = length;
				
				Object[] range = new Object[]{start,end,replacement};
				ranges.add(range);
			}
			
			int start = length-del_before;
			int end = length;
			
			Object[] range = new Object[]{start,end,replacement};
			ranges.add(range);
			
			return ranges;
		}
	}
	
	
	
	public class ReplaceAtFixedPosition implements T
	{
		private String replacement;
		private int del_before;
		private int del_after;
		private int d;

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
			List ranges = new ArrayList();
			int d0=0;
        
			for(int i=0;i<text.length();i++)
			{
				char c = text.charAt(i);
				if(d0==d)
				{
					Object[] range = new Object[]{i-del_before,i+del_after,replacement};
					ranges.add(range);
				}
				
				d0++;
				if(c=='\n') d0=0;
			}
			return ranges;
		}
	}
}
