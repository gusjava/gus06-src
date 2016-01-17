package gus06.entity.gus.file.lastmodified.timestamp.yyyymmdd;

import gus06.framework.*;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150630";}
	
	public static final String FORMAT = "yyyyMMdd";

	private SimpleDateFormat sdf = new SimpleDateFormat(FORMAT);
	
	
	public Object t(Object obj) throws Exception
	{
		File file = (File) obj;
		Date date = new Date(file.lastModified());
		return sdf.format(date);
	}
}
