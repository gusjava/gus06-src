package gus06.entity.gus.sys.autocomplete1.highlighter1;

import gus06.framework.*;

public class EntityImpl implements Entity, V {

	public String creationDate() {return "20160516";}


	private Service clear;
	private Service keep;
	private Service remove;
	private Service add;
	private Service merge;
	private Service invert;
	private Service elLine;
	private Service libLines;
	private Service libWords;
	private Service libMap;
	
	

	
	public EntityImpl() throws Exception
	{
		clear = Outside.service(this,"gus.sys.autocomplete1.highlighter1.clear");
		keep = Outside.service(this,"gus.sys.autocomplete1.highlighter1.keep");
		remove = Outside.service(this,"gus.sys.autocomplete1.highlighter1.remove");
		add = Outside.service(this,"gus.sys.autocomplete1.highlighter1.add");
		merge = Outside.service(this,"gus.sys.autocomplete1.highlighter1.merge");
		invert = Outside.service(this,"gus.sys.autocomplete1.highlighter1.invert");
		elLine = Outside.service(this,"gus.sys.autocomplete1.highlighter1.el.line");
		libLines = Outside.service(this,"gus.sys.autocomplete1.highlighter1.lib.lines");
		libWords = Outside.service(this,"gus.sys.autocomplete1.highlighter1.lib.words");
		libMap = Outside.service(this,"gus.sys.autocomplete1.highlighter1.lib.map");
	}

	
	
	public void v(String key, Object obj) throws Exception
	{
		if(key.equals("clear"))		{clear.p(obj);return;}
		if(key.equals("keep"))		{keep.p(obj);return;}
		if(key.equals("remove"))	{remove.p(obj);return;}
		if(key.equals("add"))		{add.p(obj);return;}
		if(key.equals("merge"))		{merge.p(obj);return;}
		if(key.equals("invert"))	{invert.p(obj);return;}
		if(key.equals("liblines"))	{libLines.p(obj);return;}
		if(key.equals("libwords"))	{libWords.p(obj);return;}
		if(key.equals("libmap"))	{libMap.p(obj);return;}
		
		if(key.startsWith("line "))	{elLine.v(p2(key),obj);return;}
		
		throw new Exception("Invalid rule: "+key);
	}
	
	
	
	private String p2(String s)
	{return s.split(" ",2)[1];}
	
}
