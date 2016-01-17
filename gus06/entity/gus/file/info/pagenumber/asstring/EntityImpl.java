package gus06.entity.gus.file.info.pagenumber.asstring;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151006";}


	private Service pageNumber;
	
	
	public EntityImpl() throws Exception
	{
		pageNumber = Outside.service(this,"gus.file.info.pagenumber");
	}



	public Object t(Object obj) throws Exception
	{
		String nb = (String) pageNumber.t(obj);
		return nb!=null?nb:"";
	}
}
