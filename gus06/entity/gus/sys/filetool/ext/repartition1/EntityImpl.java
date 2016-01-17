package gus06.entity.gus.sys.filetool.ext.repartition1;

import gus06.framework.*;
import java.io.File;
import java.util.Map;
import java.awt.Color;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151020";}
	

	private Service findRoot;
	private Service colorArray;
	private Service guiFactory;
	
	public EntityImpl() throws Exception
	{
		findRoot = Outside.service(this,"gus.sys.filetool.findroot");
		colorArray = Outside.service(this,"gus.sys.filetool.ext.repartition1.colorarray");
		guiFactory = Outside.service(this,"factory#gus.sys.filetool.ext.repartition1.gui.maingui");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		Map map = (Map) obj;
		
		File root = (File) findRoot.t(map);
		Color[] colors = (Color[]) colorArray.t(map);
		
		Object gui = guiFactory.g();
		
		((V)gui).v("colors",colors);
		((P)gui).p(root);
		
		return ((I)gui).i();
	}
}
