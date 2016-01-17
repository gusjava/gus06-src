package gus06.entity.gus.appli.gusclient1.space.manager;

import gus06.framework.*;

public class EntityImpl extends S1 implements Entity, G, P {

	public String creationDate() {return "20140718";}

	public static final String KEY = "space";
	public static final String KEY_DEFAULT = "space.default";


	private Service titleChanger;
	private Service save;

	private String id;
	
	
	public EntityImpl() throws Exception
	{
		titleChanger = Outside.service(this,"gus.app.mainframe.titlechanger.ling");
		save = Outside.service(this,"gus.command.prop2.set");
	}
	
	
	public Object g() throws Exception
	{
		if(id==null) init();
		return id;
	}
	
	
	public void p(Object obj) throws Exception
	{
		String newId = (String) obj;
		
		if(newId==null) return;
		if(g().equals(newId)) return;
		
		setId(newId);
		spaceChanged();
	}
	
	
	
	private void init() throws Exception
	{setId(initValue());}
	
	
	private String initValue() throws Exception
	{
		String v1 = (String) save.r(KEY);
		if(v1!=null) return v1;
	
		String v2 = (String) save.r(KEY_DEFAULT);
		if(v2!=null) return v2;
	
		throw new Exception("Initial space id not found");
	}
	
	
	
	
	private void setId(String id) throws Exception
	{
		this.id = id;
		save.v(KEY,id);
		titleChanger.p("gusclient1_space_"+id);
	}
	
	
	private void spaceChanged()
	{send(this,"spaceChanged()");}
}
