package gus06.entity.gus.appli.gusclient1.execute.pseudo.reset;

import gus06.framework.*;

public class EntityImpl implements Entity, E {

	public String creationDate() {return "20140904";}

	public static final String KEY_PSEUDO = "dev.pseudo";


	private Service confirm;
	private Service unset;


	public EntityImpl() throws Exception
	{
		confirm = Outside.service(this,"gus.input.confirm.dialog");
		unset = Outside.service(this,"gus.command.prop2.unset");
	}
	
	
	public void e() throws Exception
	{
		boolean ok = confirm.f("The application will exit after reseting your pseudo.\nProceed ?");
		if(!ok) return;
		
		unset.p(KEY_PSEUDO);
		System.exit(0);
	}
}
