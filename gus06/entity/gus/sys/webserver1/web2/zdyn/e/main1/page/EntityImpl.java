package gus06.entity.gus.sys.webserver1.web2.zdyn.e.main1.page;

import gus06.framework.*;
import java.util.Map;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20141010";}


	private Service findPage;
	private Service htmlPage;
	private Service uniqueEntity;


	public EntityImpl() throws Exception
	{
		findPage = Outside.service(this,"gus.sys.webserver1.web2.zdyn.e.find.page");
		htmlPage = Outside.service(this,"gus.sys.webserver1.web2.zdyn.e.html");
		uniqueEntity = Outside.service(this,"entityunique");
	}
	
	
	public void p(Object obj) throws Exception
	{
		Map prop = (Map) ((R)obj).r("data config prop");
		String id = (String) findPage.t(obj);
		
		if(prop.containsKey("page."+id))
		{
			String entityName = (String) prop.get("page."+id);
			((P) uniqueEntity.t(entityName)).p(obj);
		}
		else htmlPage.p(obj);
	}
}
