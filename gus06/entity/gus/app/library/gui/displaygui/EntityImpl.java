package gus06.entity.gus.app.library.gui.displaygui;

import gus06.framework.*;
import javax.swing.JTabbedPane;
import java.lang.reflect.Field;
import java.util.Vector;
import javax.swing.JComponent;

public class EntityImpl implements Entity, I {

	public String creationDate() {return "20150607";}


	private Service dataViewer1;
	private Service dataViewer2;
	private Service dataViewer3;
	
	private JTabbedPane tab;


	public EntityImpl() throws Exception
	{
		dataViewer1 = Outside.service(this,"*gus.data.viewer.list-1");
		dataViewer2 = Outside.service(this,"*gus.data.viewer.list-2");
		dataViewer3 = Outside.service(this,"*gus.data.viewer.list-3");
		
		dataViewer1.p(getLib("loadedLibraryNames"));
		dataViewer2.p(getLib("systemNativeLibraries"));
		dataViewer3.p(getLib1("nativeLibraries"));
		
		tab = new JTabbedPane();
		tab.addTab("Loaded lib names",(JComponent) dataViewer1.i());
		tab.addTab("System native libs",(JComponent) dataViewer2.i());
		tab.addTab("Native libs",(JComponent) dataViewer3.i());
	}
	
	
	
	
	public Object i() throws Exception
	{return tab;}
	
	
	
	
	private Vector getLib(String method) throws Exception
	{
		final Field field = ClassLoader.class.getDeclaredField(method);
		field.setAccessible(true);
		return (Vector) field.get(null);
	}
	
	private Vector getLib1(String method) throws Exception
	{
		ClassLoader cl = getClass().getClassLoader();
		final Field field = ClassLoader.class.getDeclaredField(method);
		field.setAccessible(true);
		return (Vector) field.get(cl);
	}
}
