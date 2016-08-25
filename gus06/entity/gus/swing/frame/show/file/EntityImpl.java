package gus06.entity.gus.swing.frame.show.file;

import gus06.framework.*;

public class EntityImpl implements Entity, T, V, P {

	public String creationDate() {return "20160412";}


	private Service show;
	private Service newEditor;


	public EntityImpl() throws Exception
	{
		show = Outside.service(this,"gus.swing.frame.show");
		newEditor = Outside.service(this,"factory#gus.file.editor.main");
	}
	
	
	
	private Object comp(Object obj) throws Exception
	{
		Object editor = newEditor.g();
		((P)editor).p(obj);
		return ((I)editor).i();
	}
	
	
	public void p(Object obj) throws Exception
	{show.p(comp(obj));}
	
	public void v(String key, Object obj) throws Exception
	{show.v(key,comp(obj));}
	
	public Object t(Object obj) throws Exception
	{return show.t(comp(obj));}
}
