package gus06.entity.gus.swing.textcomp.cust.action.r.keepline.perform.caret.painter;

import gus06.framework.*;
import javax.swing.text.*;
import java.util.HashSet;
import java.util.Set;
import java.util.List;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20151104";}

	private Service findHigh;

	public EntityImpl() throws Exception
	{
		findHigh = Outside.service(this,"gus.swing.textcomp.highlight.find.forpainter");
	}
	
	
	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		JTextComponent comp = (JTextComponent) o[0];
		
		List high = (List) findHigh.t(obj);
		
		PlainDocument document = (PlainDocument) comp.getDocument();
		Element root = document.getDefaultRootElement();
		int length = document.getLength();
		int number = root.getElementCount();
		
		Set<Integer> indexes = new HashSet<>();
		
		for(int i=0;i<high.size();i++)
		{
			Highlighter.Highlight h = (Highlighter.Highlight) high.get(i);
			int start = h.getStartOffset();
			int end = h.getEndOffset();
			
			int startIndex = root.getElementIndex(start);
			int endIndex = root.getElementIndex(end);
			
			for(int j=startIndex;j<=endIndex;j++)
			indexes.add(new Integer(j));
		}
		
		((V) comp).v("undoable","true");
		
		for(int i=number-1;i>=0;i--)
		{
			Element element = root.getElement(i);
			if(!indexes.contains(new Integer(i)))
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
