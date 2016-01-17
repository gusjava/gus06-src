package gus06.entity.gus.appli.entityhistory.srcfile.extractor;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150430";}


	private Service readFile;
	private Service srcToName;
	private Service srcToDate;

	public EntityImpl() throws Exception
	{
		readFile = Outside.service(this,"gus.file.read.string");
		srcToName = Outside.service(this,"gus.java.srccode.extract.entity.name");
		srcToDate = Outside.service(this,"gus.java.srccode.extract.entity.creationdate");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		String src = (String) readFile.t(obj);
		String name = (String) srcToName.t(src);
		String date = (String) srcToDate.t(src);
		return new String[]{name,date};
	}
}
