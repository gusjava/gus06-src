package gus06.entity.gus.sys.filetool.main.maptogui;

import gus06.framework.*;
import java.util.Map;
import javax.swing.JPanel;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20141229";}


	private Service uniqueEntity;
	private Service mapToName;
	

	public EntityImpl() throws Exception
	{
		uniqueEntity = Outside.service(this,"entityunique");
		mapToName = Outside.service(this,"gus.sys.filetool.main.maptoname");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		Map map = (Map) obj;
		String name = (String) mapToName.t(map);
		T trans = (T) uniqueEntity.t(name);
		return trans.t(map);
	}
}
