package gus06.entity.gus.file.creationtime.timestamp;

import gus06.framework.*;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.nio.file.Files;
import java.nio.file.Path;


public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150818";}
	
	public static final String FORMAT = "yyyyMMdd_HHmmss";
	
	private SimpleDateFormat sdf = new SimpleDateFormat(FORMAT);


	private Service findPath;


	
	public EntityImpl() throws Exception
	{
		findPath = Outside.service(this,"gus.find.path");
	}

	
	public Object t(Object obj) throws Exception
	{
		Path path = (Path) findPath.t(obj);
		BasicFileAttributes attr = Files.readAttributes(path,BasicFileAttributes.class);
		FileTime time = attr.creationTime();
		Date date = new Date(time.toMillis());
		return sdf.format(date);
	}
}
