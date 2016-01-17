package gus06.manager.gus.gyem.m065.t.resource.builder.analyze;

import gus06.framework.T;
import gus06.manager.gus.gyem.GyemSystem;

public class Module extends GyemSystem implements T {


	public Object t(Object obj) throws Exception
	{
		String rule = (String) obj;
		if(rule.contains("#")) return rule.split("#",2);
		return new String[]{DEFAULTBUILDER,rule};
	}
}