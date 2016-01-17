package gus06.entity.gus.appli.gusclient1.execute.space.projects.createproject;

import gus06.framework.*;

public class EntityImpl implements Entity, E {

	public String creationDate() {return "20140830";}


	private Service input;
	private Service perform;


	public EntityImpl() throws Exception
	{
		input = Outside.service(this,"gus.input.text.dialog");
		perform = Outside.service(this,"gus.appli.gusclient1.project.createnew");
	}
	
	
	public void e() throws Exception
	{
		String id = (String) input.t("Enter project id:");
		if(id==null || id.equals("")) return;
		perform.p(id);
	}
}
