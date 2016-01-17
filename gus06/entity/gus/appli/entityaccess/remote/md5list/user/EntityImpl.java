package gus06.entity.gus.appli.entityaccess.remote.md5list.user;

import gus06.framework.*;
import java.util.Arrays;

public class EntityImpl implements Entity, G {

	public String creationDate() {return "20150814";}


	private Service sender;
	private Service buildMd5List;
	
	public EntityImpl() throws Exception
	{
		sender = Outside.service(this,"gus.appli.entityaccess.api.sender");
		buildMd5List = Outside.service(this,"gus.appli.entityaccess.api.build.md5list");
	}
	
	
	
	public Object g() throws Exception
	{
		String result = (String) sender.t("md5:user");
		if(result.startsWith("error:")) return result;
		return buildMd5List.t(result);
	}
}
