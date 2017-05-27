package gus06.entity.gus.sys.filetool.ext.javacompiler1.holder;

import gus06.framework.*;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.util.Map;
import java.io.File;
import javax.swing.JTextArea;
import java.io.PrintStream;
import javax.swing.JScrollPane;

public class EntityImpl implements Entity, I, P, Runnable {

	public String creationDate() {return "20161107";}
	
	public static final String PATH_SRC = "path.src";
	public static final String PATH_BIN = "path.bin";
	public static final String PATH_LIB = "path.lib";
	public static final String PATH_JDK = "path.jdk";
	
	
	private Service findRoot;
	private Service compiler;
	private Service buildButton;
	private Service factory;
	private Service build;
	
	private JPanel panel;
	private JTextArea area;
	private JButton button;
	
	private Map map;
	private File root;
	private PrintStream p;
	
	private File srcDir;
	private File binDir;
	private File libDir;
	private File jdkDir;
	
	


	public EntityImpl() throws Exception
	{
		findRoot = Outside.service(this,"gus.sys.filetool.findroot");
		compiler = Outside.service(this,"gus.java.compiler.v2");
		buildButton = Outside.service(this,"gus.swing.button.build.runnable");
		factory = Outside.service(this,"gus.swing.textarea.factory.console1.black.white");
		build = Outside.service(this,"gus.io.printstream.textarea1");
		
		area = (JTextArea) factory.i();
		area.setEditable(false);
		p = (PrintStream) build.t(area);
		
		button = (JButton) buildButton.t(this);
		button.setText("compile");
		
		panel = new JPanel(new BorderLayout());
		panel.add(new JScrollPane(area),BorderLayout.CENTER);
		panel.add(button,BorderLayout.SOUTH);
	}
	
	
	public Object i() throws Exception
	{return panel;}
	
	
	
	public void p(Object obj) throws Exception
	{
		map = (Map) obj;
		root = (File) findRoot.t(map);
		
		srcDir = findSrcDir();
		binDir = findBinDir();
		libDir = findLibDir();
		jdkDir = findJdkDir();
	}
	
	
	private File findSrcDir()
	{
		String path = get0(PATH_SRC);
		if(path!=null) return new File(path);
		return defaultDir("src");
	}
	
	private File findBinDir()
	{
		String path = get0(PATH_BIN);
		if(path!=null) return new File(path);
		return defaultDir("bin");
	}
	
	private File findLibDir()
	{
		String path = get0(PATH_LIB);
		if(path!=null) return new File(path);
		return defaultDir("lib");
	}
	
	private File findJdkDir()
	{
		String path = get0(PATH_JDK);
		if(path!=null) return new File(path);
		return null;
	}
	
	
	
	private File defaultDir(String name)
	{
		File d = new File(root,name);
		d.mkdirs();
		return d;
	}
	
	
	
	public void run()
	{perform();}
	
	
	
	private void perform()
	{
		try
		{
			compiler.v("srcDir",srcDir);
			compiler.v("binDir",binDir);
			compiler.v("libDir",libDir);
			compiler.v("jdkDir",jdkDir);
			compiler.v("output",p);
			compiler.e();
		}
		catch(Exception e)
		{Outside.err(this,"perform()",e);}
	}
	

	
	private String get0(String key)
	{
		if(map==null) return null;
		if(!map.containsKey(key)) return null;
		return (String) map.get(key);
	}
}
