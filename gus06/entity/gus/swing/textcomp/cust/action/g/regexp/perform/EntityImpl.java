package gus06.entity.gus.swing.textcomp.cust.action.g.regexp.perform;

import gus06.framework.*;
import javax.swing.text.*;
import java.util.regex.*;
import java.awt.Color;
import javax.swing.JOptionPane;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20141105";}

	public static final String PAINTER_KEY = "regexp";


	private Service getPainter;
	private Service inferRegexp;
	
	private DefaultHighlighter.DefaultHighlightPainter painter;
	
	
	public EntityImpl() throws Exception
	{
		getPainter = Outside.service(this,"gus.swing.textcomp.highlight.painter.manager1");
		inferRegexp = Outside.service(this,"gus.string.transform.regexp.infer");
		
		painter = (DefaultHighlighter.DefaultHighlightPainter) getPainter.r(PAINTER_KEY);
	}
	
	
	
	
	
	public void p(Object obj) throws Exception
	{perform((JTextComponent) obj);}
	
	
	
	private void perform(JTextComponent comp) throws Exception
	{
		Highlighter high = comp.getHighlighter();
		boolean removed = removeHighlights(high);
		if(removed) return;
		
		String selection = selection(comp);
		String exp = findExpression(selection);
		if(exp==null || exp.equals("")) return;
		
		Pattern p = Pattern.compile(exp,Pattern.DOTALL);
                String text = comp.getText();
                Matcher m = p.matcher(text);
                
                while(m.find())
                {
                    int start = m.start();
                    int end = m.end();
                    high.addHighlight(start,end,painter);
                }
	}
	
	
	
	
	



	private boolean removeHighlights(Highlighter high)
	{
		Highlighter.Highlight[] h = high.getHighlights();
		boolean removed = false;
		for(int i=0;i<h.length;i++)
		if(h[i].getPainter().equals(painter))
		{
			high.removeHighlight(h[i]);
			removed = true;
		}
		return removed;
	}
	
	
	
	
	private String findExpression(String selection) throws Exception
	{
		if(selection!=null) return (String) inferRegexp.t(selection);
           	return JOptionPane.showInputDialog(null,"Please, type an expression:",
		"Search expression",JOptionPane.PLAIN_MESSAGE);
	}
	
	
	private String selection(JTextComponent comp)
	{
		String s = comp.getSelectedText();
		if(s!=null && !s.equals("")) return s;
		return null;
	}
}
