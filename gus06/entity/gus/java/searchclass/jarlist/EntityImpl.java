package gus06.entity.gus.java.searchclass.jarlist;

import gus06.framework.*;
import java.io.File;
import java.util.List;
import java.util.ArrayList;

public class EntityImpl implements Entity, G {

	public String creationDate() {return "20140819";}


	private Service findBoot;
	private Service findExt;
	private Service findPath;
	
	private List files;
	

	public EntityImpl() throws Exception
	{
		findBoot = Outside.service(this,"gus.java.home.bootstrap.jarlist");
		findExt = Outside.service(this,"gus.java.home.ext.jarlist");
		findPath = Outside.service(this,"gus.java.home.classpath.jarlist");
	}
	
	
	public Object g() throws Exception
	{
		if(files==null) init();
		return files;
	}
	
	
	private void init() throws Exception
	{
		List bootList = (List) findBoot.g();
		List extList = (List) findExt.g();
		List pathList = (List) findPath.g();
		
		files = new ArrayList();
		
		files.addAll(bootList);
		files.addAll(extList);
		files.addAll(pathList);
	}
}
