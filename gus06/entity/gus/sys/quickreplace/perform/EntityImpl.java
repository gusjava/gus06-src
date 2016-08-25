package gus06.entity.gus.sys.quickreplace.perform;

import gus06.framework.*;
import java.util.List;
import javax.swing.text.*;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20160430";}

	public static final String PAINTER_KEY = "replace";


	private Service getPainter;
	private Service highClear;
	
	private DefaultHighlighter.DefaultHighlightPainter painter;
	
	
	
	public EntityImpl() throws Exception
	{
		getPainter = Outside.service(this,"gus.swing.textcomp.highlight.painter.manager1");
		highClear = Outside.service(this,"gus.sys.quickreplace.highlight.clear");
		
		painter = (DefaultHighlighter.DefaultHighlightPainter) getPainter.r(PAINTER_KEY);
	}
	
	
	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=3) throw new Exception("Wrong data number: "+o.length);
		
		JTextComponent comp = (JTextComponent) o[0];
		String textMem = (String) o[1];
		T trans = (T) o[2];
		
		
		List ranges = (List) trans.t(textMem);
		comp.setText(textMem);
		
		((V) comp).v("undoable","true");
		
		Highlighter high = comp.getHighlighter();
		highClear.p(new Object[]{comp,painter});
		
		for(int i=ranges.size()-1;i>=0;i--)
		{
			Object[] range = (Object[]) ranges.get(i);
			
			Integer start_ = (Integer) range[0];
			Integer end_ = (Integer) range[1];
			String replacement = (String) range[2];
			
			int start = start_.intValue();
			int end = end_.intValue();
			int end1 = start + replacement.length();
			
			comp.getDocument().insertString(end,replacement,null);
			comp.getDocument().remove(start,end-start);
			
			high.addHighlight(start,end1,painter);
		}
		
		((V) comp).v("undoable","false");
	}
}
