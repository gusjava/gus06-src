package gus06.manager.gus.gyem.m050.g.mapping.outside.file;

import java.io.File;

import gus06.framework.G;
import gus06.manager.gus.gyem.GyemSystem;
import gus06.manager.gus.gyem.tools.Tool_File;

public class Module extends GyemSystem implements G {

	public Object g() throws Exception
	{
		File file = (File) ((G) module(M023_G_PATH_FIND_MAPPINGFILE)).g();
		return Tool_File.prop(file);
	}
}