package gus06.entity.gus.sys.filetool.ext.runtask1;

import gus06.framework.*;
import javax.swing.JPanel;
import java.util.Map;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150619";}
	
	public Object t(Object obj) throws Exception
	{
		Service holder = newHolder();
		holder.p(obj);
		return holder.i();
	}
	
	private Service newHolder() throws Exception
	{return Outside.service(this,"*gus.sys.filetool.ext.runtask1.holder");}
}
