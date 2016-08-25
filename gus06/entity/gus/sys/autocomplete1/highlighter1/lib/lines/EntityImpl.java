package gus06.entity.gus.sys.autocomplete1.highlighter1.lib.lines;

import gus06.framework.*;
import javax.swing.text.*;
import java.util.Map;
import java.util.Iterator;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Set;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20160604";}

	public static final String PAINTER_KEY = "f1";


	private Service getPainter;
	private Service getString;
	private Service splitLines;
	
	private DefaultHighlighter.DefaultHighlightPainter painter;


	public EntityImpl() throws Exception
	{
		getPainter = Outside.service(this,"gus.swing.textcomp.highlight.painter.manager1");
		getString = Outside.service(this,"gus.sys.clipboard1.g.string");
		splitLines = Outside.service(this,"gus.string.split.lines1.set");
		
		painter = (DefaultHighlighter.DefaultHighlightPainter) getPainter.r(PAINTER_KEY);
	}

	
	
	
	public void p(Object obj) throws Exception
	{
		JTextComponent comp = (JTextComponent) obj;
		String s = (String) getString.g();
		
		if(s==null || s.equals("")) return;
		
		Highlighter high = comp.getHighlighter();
		String text = comp.getText();
		
		Set lines = (Set) splitLines.t(s);
		Iterator it = lines.iterator();
		while(it.hasNext())
		handle(high,text,(String) it.next());
	}
	
	
	
	private void handle(Highlighter high, String text, String exp) throws Exception
	{
		Pattern p = Pattern.compile(Pattern.quote(exp),Pattern.DOTALL);
                Matcher m = p.matcher(text);
                
                while(m.find())
                {
                    int start = m.start();
                    int end = m.end();
                    high.addHighlight(start,end,painter);
                }
	}
}
