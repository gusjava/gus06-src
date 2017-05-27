package gus06.entity.gus.file.editor.ext.jar;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, I, P, G {

	public String creationDate() {return "20140804";}

	
	private Service tab;
	private Service listingGui;
	private Service manifestGui;
	private Service depGui;
	
	private File file;
	

	public EntityImpl() throws Exception
	{
		tab = Outside.service(this,"*gus.swing.tabbedpane.holder1");
		listingGui = Outside.service(this,"*gus.file.editor.ext.jar.viewer.listing");
		manifestGui = Outside.service(this,"*gus.file.editor.ext.jar.viewer.manifest");
		depGui = Outside.service(this,"*gus.file.editor.ext.jar.viewer.dependencies");
		
		tab.v("Listing",listingGui.i());
		tab.v("Manifest",manifestGui.i());
		tab.v("Dependencies",depGui.i());
	}
	
	
	public Object i() throws Exception
	{return tab.i();}
	
	
	public Object g() throws Exception
	{return file;}
	
	
	
	public void p(Object obj) throws Exception
	{
		file = (File) obj;
		
		listingGui.p(obj);
		manifestGui.p(obj);
		depGui.p(obj);
	}
}
