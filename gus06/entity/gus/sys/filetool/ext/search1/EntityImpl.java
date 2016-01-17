package gus06.entity.gus.sys.filetool.ext.search1;

import gus06.framework.*;
import javax.swing.JPanel;
import java.util.Map;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150324";}
	
	public EntityImpl() throws Exception
	{
	}
	
	public Object t(Object obj) throws Exception
	{
		Map map = (Map) obj;
		return new JPanel();
	}
}
