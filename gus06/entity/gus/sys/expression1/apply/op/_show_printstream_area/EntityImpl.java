package gus06.entity.gus.sys.expression1.apply.op._show_printstream_area;

import gus06.framework.*;
import javax.swing.JTextArea;
import java.io.PrintStream;
import javax.swing.JScrollPane;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20161109";}

	

	private Service factory;
	private Service build;
	private Service show;
		
	public EntityImpl() throws Exception
	{
		factory = Outside.service(this,"gus.swing.textarea.factory.console1.black.white");
		build = Outside.service(this,"gus.io.printstream.textarea1");
		show = Outside.service(this,"gus.swing.frame.show");
	}

	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		
		if(obj instanceof String) return build((String) obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	private PrintStream build(String title) throws Exception
	{
		JTextArea area = (JTextArea) factory.i();
		area.setEditable(false);
		PrintStream p = (PrintStream) build.t(area);
		show.v(title,new JScrollPane(area));
		return p;
	}
}
