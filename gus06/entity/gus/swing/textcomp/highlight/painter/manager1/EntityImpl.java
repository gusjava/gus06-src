package gus06.entity.gus.swing.textcomp.highlight.painter.manager1;

import gus06.framework.*;
import java.awt.Color;

public class EntityImpl implements Entity, R {

	public String creationDate() {return "20151107";}

	public static final Color COLOR_SEARCH = new Color(51,204,255);
	public static final Color COLOR_SEARCH_I = new Color(102,153,255);
	public static final Color COLOR_REGEXP = new Color(255,102,51);
	
	public static final String KEY_SEARCH = "search";
	public static final String KEY_SEARCH_I = "search_i";
	public static final String KEY_REGEXP = "regexp";
	

	private Service buildPainter;
	
	private Object painter_search;
	private Object painter_search_i;
	private Object painter_regexp;
	
	
	public EntityImpl() throws Exception
	{
		buildPainter = Outside.service(this,"gus.swing.textcomp.highlight.painter.builder1");
		
		painter_search = buildPainter.t(COLOR_SEARCH);
		painter_search_i = buildPainter.t(COLOR_SEARCH_I);
		painter_regexp = buildPainter.t(COLOR_REGEXP);
	}
	
	
	public Object r(String key) throws Exception
	{
		if(key.equals(KEY_SEARCH)) return painter_search;
		if(key.equals(KEY_SEARCH_I)) return painter_search_i;
		if(key.equals(KEY_REGEXP)) return painter_regexp;
		
		throw new Exception("Unknown key: "+key);
	}
}
