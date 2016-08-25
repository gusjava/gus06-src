package gus06.entity.gus.sys.quickreplace.t.byposition.smart;

import gus06.framework.*;
import java.util.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160430";}


	// A DEVELOPPER !!!!!!!
	
	
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
		
		int length = textMem.length();
		
		if(position==0 || textMem.charAt(position-1)=='\n')
		return new ReplaceAtStartOfLine(replacement,del_before,del_after);
		
		int d = position;
		while(d<length && textMem.charAt(d)!='\n') d++;
		return new ReplaceAtFixedPosition(replacement,del_before,del_after,d-position);
	}
	
	
	
	public class ReplaceAtStartOfLine implements T
	{
		private String replacement;
		private int del_before;
		private int del_after;
    
		public ReplaceAtStartOfLine(String replacement, int del_before, int del_after)
		{
			this.replacement = replacement;
			this.del_before = del_before;
			this.del_after = del_after;
		}
		
		public Object t(Object obj) throws Exception
		{
			String text = (String) obj;
			int length = text.length();
			List ranges = new ArrayList();
			
			for(int i=0;i<length;i++)
			if(i==0 || text.charAt(i-1)=='\n')
			{
				int start = i-del_before;
				int end = i+del_after;
				
				if(start<0) start = 0;
				if(end>length) end = length;
				
				Object[] range = new Object[]{start,end,replacement};
				ranges.add(range);
			}
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
			int length = text.length();
			List ranges = new ArrayList();
			
			int d1 = length-d;
			
			for(int i=0;i<text.length();i++)
			if(i==d1 || (i+d<length && text.charAt(i+d)=='\n'))
			{
				int start = i-del_before;
				int end = i+del_after;
				
				if(start<0) start = 0;
				if(end>length) end = length;
			
				Object[] range = new Object[]{start,end,replacement};
				ranges.add(range);
			}
			
			return ranges;
		}
	}
}
