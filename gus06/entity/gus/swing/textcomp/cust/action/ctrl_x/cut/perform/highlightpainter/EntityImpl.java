package gus06.entity.gus.swing.textcomp.cust.action.ctrl_x.cut.perform.highlightpainter;

import gus06.framework.*;
import javax.swing.text.*;
import java.util.List;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20160427";}


	private Service clipboard;
	private Service findForPainter;

	public EntityImpl() throws Exception
	{
		clipboard = Outside.service(this,"gus.clipboard.access.string");
		findForPainter = Outside.service(this,"gus.swing.textcomp.highlight.find.forpainter");
	}
	
	
	
	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		JTextComponent comp = (JTextComponent) o[0];
		Highlighter.HighlightPainter painter = (Highlighter.HighlightPainter) o[1];
		
		List l = (List) findForPainter.t(new Object[]{comp,painter});
		
		StringBuffer b = new StringBuffer();
		
		
		for(int i=0;i<l.size();i++)
		{
			Highlighter.Highlight ht = (Highlighter.Highlight) l.get(i);
			
			int start = ht.getStartOffset();
			int end = ht.getEndOffset();
			String text = comp.getText(start,end-start);
			
			b.append(text+"\n");
		}
		
		if(b.length()>0) b.deleteCharAt(b.length()-1);
		
		((V) comp).v("undoable","true");
		
		int length = comp.getDocument().getLength();
		
		for(int i=l.size()-1;i>=0;i--)
		{
			Highlighter.Highlight ht = (Highlighter.Highlight) l.get(i);
			
			int start = ht.getStartOffset();
			int end = ht.getEndOffset();
			if(end>length) end = length;
			
			comp.getDocument().remove(start,end-start);
		}
		
		((V) comp).v("undoable","false");
		
		clipboard.p(b.toString());
	}
	
}
