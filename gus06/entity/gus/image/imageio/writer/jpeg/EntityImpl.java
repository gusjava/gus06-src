package gus06.entity.gus.image.imageio.writer.jpeg;

import java.util.Iterator;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriter;
import gus06.framework.*;

public class EntityImpl implements Entity, G {

	public String creationDate() {return "20160529";}

	public static final String SUFFIX = "jpeg";


	public Object g() throws Exception
	{
		Iterator writers = ImageIO.getImageWritersBySuffix(SUFFIX);
		if(!writers.hasNext()) throw new IllegalStateException("No writers found for suffix "+SUFFIX);
		return (ImageWriter) writers.next();
	}
}
