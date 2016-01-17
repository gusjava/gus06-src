package gus06.entity.gus.swing.textcomp.highlight.find.forpainter;

import gus06.framework.*;
import java.util.List;
import java.util.ArrayList;
import javax.swing.text.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151108";}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		JTextComponent comp = (JTextComponent) o[0];
		Highlighter.HighlightPainter painter = (Highlighter.HighlightPainter) o[1];
		
		List l = new ArrayList();
		
		Highlighter high = comp.getHighlighter();
		Highlighter.Highlight[] ht = high.getHighlights();
		
		for(int i=0;i<ht.length;i++)
		if(ht[i].getPainter()==painter) l.add(ht[i]);
		
		return l;
	}
}
