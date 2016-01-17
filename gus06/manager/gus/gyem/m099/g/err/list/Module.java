package gus06.manager.gus.gyem.m099.g.err.list;

import java.util.List;

import gus06.framework.G;
import gus06.framework.T;
import gus06.manager.gus.gyem.GyemSystem;

public class Module extends GyemSystem implements G {

	private List list;
	
	public Object g() throws Exception
	{
		if(list==null) init();
		return list;
	}
	
	
	private void init() throws Exception
	{
		list = (List) ((T) module(M105_T_BUILD_LIST)).t("err");
	}
}