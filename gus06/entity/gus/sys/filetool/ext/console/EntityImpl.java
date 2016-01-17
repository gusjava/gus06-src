package gus06.entity.gus.sys.filetool.ext.console;

import gus06.framework.*;
import java.io.File;
import java.util.Map;


public class EntityImpl implements Entity, T {

	public String creationDate() {return "20141230";}


	private Service findRoot;

	
	public EntityImpl() throws Exception
	{findRoot = Outside.service(this,"gus.sys.filetool.findroot");}
	
	
	
	public Object t(Object obj) throws Exception
	{
		Map map = (Map) obj;
		
		Service console = newConsole();
		console.v("cmdBuilder",new CmdBuilder(map));
		console.v("root",findRoot(map));
		
		String colorWait = get(map,"color.wait");
		String colorIn = get(map,"color.in");
		
		if(colorWait!=null) console.v("colorWait",colorWait);
		if(colorIn!=null) console.v("colorIn",colorIn);
		
		return console.i();
	}
	
	
	private Service newConsole() throws Exception
	{return Outside.service(this,"*gus.sys.console.gui1");}
	
	
	private File findRoot(Map map) throws Exception
	{return (File) findRoot.t(map);}
	
	
	
	private String get(Map map, String key)
	{return map.containsKey(key)?(String) map.get(key):null;}
	
	
	
	
	private class CmdBuilder implements T
	{
		private Map map;
		public CmdBuilder(Map map) {this.map = map;}

		public Object t(Object obj) throws Exception
		{
			String text = (String) obj;
			if(map.containsKey("alias."+text))
				return (String) map.get("alias."+text);
			return text;
		}
	}
}
