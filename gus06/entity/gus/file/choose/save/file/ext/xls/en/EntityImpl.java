package gus06.entity.gus.file.choose.save.file.ext.xls.en;

import gus06.framework.*;

public class EntityImpl implements Entity, G {

	public String creationDate() {return "20150710";}

	public static final String EXTENSION = "xls;xlsx";
	public static final String FILEDESC = "Excel files";

	private Service builder;
	private G g;


	public EntityImpl() throws Exception
	{
		builder = Outside.service(this,"gus.file.choose.save.file.builder.ext");
		g = (G) builder.t(new String[]{EXTENSION,FILEDESC});
	}
	
	public Object g() throws Exception
	{return g.g();}
}
