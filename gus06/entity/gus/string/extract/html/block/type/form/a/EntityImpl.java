package gus06.entity.gus.string.extract.html.block.type.form.a;

import java.util.regex.Pattern;
import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170117";}


	private Service build;
	private Service perform;
	private Pattern p;

	public EntityImpl() throws Exception
	{
		build = Outside.service(this,"gus.string.extract.html.block.buildpattern");
		perform = Outside.service(this,"gus.string.extract.match.all");
		p = (Pattern) build.t("form");
	}

	public Object t(Object obj) throws Exception
	{return perform.t(new Object[]{obj,p});}
}
