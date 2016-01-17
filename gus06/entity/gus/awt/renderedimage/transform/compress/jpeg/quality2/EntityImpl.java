package gus06.entity.gus.awt.renderedimage.transform.compress.jpeg.quality2;


import java.awt.image.RenderedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Iterator;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;

import gus06.framework.*;



public class EntityImpl implements Entity, T {



	public String creationDate() {return "20151004";}

	public static final float QUALITY = 0.2f;
	
	

	public Object t(Object obj) throws Exception
	{
		RenderedImage image = (RenderedImage) obj;
		
		Iterator writers = ImageIO.getImageWritersBySuffix("jpeg");
		if (!writers.hasNext()) throw new Exception("No writers found");
		ImageWriter writer = (ImageWriter) writers.next();
		
		ImageWriteParam param = writer.getDefaultWriteParam();
		param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
		param.setCompressionQuality(QUALITY);

		ByteArrayOutputStream bos = new ByteArrayOutputStream(32768);
		ImageOutputStream ios = ImageIO.createImageOutputStream(bos);
		
		writer.setOutput(ios);
		writer.write(null, new IIOImage(image, null, null), param);
		ios.flush();
		
		ByteArrayInputStream in = new ByteArrayInputStream(bos.toByteArray());
		image = ImageIO.read(in);
		in.close();
		
		return image;
	}
}
