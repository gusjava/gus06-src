package gus06.entity.gus.file.perform.generate.icon.asico;

import gus06.framework.*;
import java.io.File;
import javax.swing.Icon;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20160208";}


	private Service fileToIcon;
	private Service writeIco;


	public EntityImpl() throws Exception
	{
		fileToIcon = Outside.service(this,"gus.file.icon.os");
		writeIco = Outside.service(this,"gus.file.write.ico");
	}
	
	
	public void p(Object obj) throws Exception
	{
		File[] o = (File[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Icon icon = (Icon) fileToIcon.t(o[0]);
		writeIco.p(new Object[]{o[1],icon});
	}
}
