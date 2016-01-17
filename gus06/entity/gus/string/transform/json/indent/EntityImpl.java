package gus06.entity.gus.string.transform.json.indent;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151129";}


	private Service evaluate;
	private Service display;


	public EntityImpl() throws Exception
	{
		evaluate = Outside.service(this,"gus.sys.jsonparser1.evaluate");
		display = Outside.service(this,"gus.tostring.display");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		String s = (String) obj;
		Object data = evaluate.t(s);
		return display.t(data);
	}
}
