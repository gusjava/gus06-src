package gus06.entity.gus.swing.textcomp.cust.action.d.removeline.perform.caret.highlightpainter;

import gus06.framework.*;
import javax.swing.text.*;
import java.util.HashSet;
import java.util.Set;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20151105";}


	
	
	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		JTextComponent comp = (JTextComponent) o[0];
		Highlighter.HighlightPainter painter = (Highlighter.HighlightPainter) o[1];
		
		
		PlainDocument document = (PlainDocument) comp.getDocument();
		Element root = document.getDefaultRootElement();
		int length = document.getLength();
		int number = root.getElementCount();
		
		
		Set<Integer> indexes = new HashSet<>();
		Highlighter high = comp.getHighlighter();
		Highlighter.Highlight[] ht = high.getHighlights();
		
		for(int i=ht.length-1;i>=0;i--)
		if(ht[i].getPainter()==painter)
		{
			int start = ht[i].getStartOffset();
			int end = ht[i].getEndOffset();
			
			int startLine = root.getElementIndex(start);
			int endLine = root.getElementIndex(end);
			
			for(int j=startLine;j<=endLine;j++)
			indexes.add(new Integer(j));
		}
		
		((V) comp).v("undoable","true");
		
		for(int i=number-1;i>=0;i--)
		{
			Element element = root.getElement(i);
			if(indexes.contains(new Integer(i)))
			{
				int start = element.getStartOffset();
				int end = element.getEndOffset();
				if(end>length) end = length;
				
				document.remove(start,end-start);
			}
		}
		
		((V) comp).v("undoable","false");
	}
}
