package gus06.entity.gus.data.viewer.class1.panel.src;

import gus06.framework.*;
import javax.swing.JComponent;


public class EntityImpl implements Entity, I, P, G {

	public String creationDate() {return "20140806";}


	private Service classToSrc;
	private Service srcViewer;
    
	private Class data;
	private String src;


	public EntityImpl() throws Exception
	{
		classToSrc = Outside.service(this,"gus.java.fromclass.javasrc");
		srcViewer = Outside.service(this,"*gus.data.viewer.string.src.java");
	}
	
	
	public Object g() throws Exception
	{return src;}
	
	
	public Object i() throws Exception
	{return srcViewer.i();}
	
	
	public void p(Object obj) throws Exception
	{
		data = (Class) obj;
		src = findSrc();
		srcViewer.p(src);
	}
		
	
	private String findSrc() throws Exception
	{
		if(data==null) return null;
		return (String) classToSrc.t(data);
	}
}
