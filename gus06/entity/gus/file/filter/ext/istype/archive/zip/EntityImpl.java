package gus06.entity.gus.file.filter.ext.istype.archive.zip;

import java.io.File;
import java.io.FileFilter;
import gus06.framework.*;

public class EntityImpl implements Entity, F, G, FileFilter {

	public String creationDate() {return "20150628";}


	/*
	 * Le format JAR (Java Archive), 
	 * l'ODT (OpenDocument) et 
	 * l'Open XML (OOXML) sont basés sur le format ZIP.
	 */
	public boolean accept(File f)
	{
		String n = f.getName().toLowerCase();
		return n.endsWith(".zip") || 
				n.endsWith(".jar") || //Java Archive 
				n.endsWith(".cbz") || //Comic Book Zip
				n.endsWith(".odt") || //Open Document
				n.endsWith(".ooxml"); //Open XML
	}
	
	
	public boolean f(Object obj) throws Exception
	{return accept((File)obj);}
	
	
	public Object g() throws Exception
	{return this;}
}