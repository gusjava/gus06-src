package gus06.entity.gus.java.bytecode.jdepend.analyze.imports;

import gus06.framework.*;
import java.io.InputStream;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170223";}


	private Service findInputStream;
	private ClassFileParser parser;

	public EntityImpl() throws Exception
	{
		findInputStream = Outside.service(this,"gus.find.inputstream");
		parser = new ClassFileParser();
	}


	public Object t(Object obj) throws Exception
	{
		InputStream is = (InputStream) findInputStream.t(obj);
		JavaClass jClass = parser.parse(is);
		return jClass.getImportedPackageNames();
	}
}
