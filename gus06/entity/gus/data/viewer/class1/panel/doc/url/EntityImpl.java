package gus06.entity.gus.data.viewer.class1.panel.doc.url;

import gus06.framework.*;
import javax.swing.JComponent;
import java.net.URL;


public class EntityImpl implements Entity, I, P, G {

	public String creationDate() {return "20160507";}


	private Service classToDocUrl;
	private Service urlViewer;
    
	private Class data;
	private URL url;


	public EntityImpl() throws Exception
	{
		classToDocUrl = Outside.service(this,"gus.java.fromclass.docurl");
		urlViewer = Outside.service(this,"*gus.data.viewer.url");
	}
	
	
	public Object g() throws Exception
	{return url;}
	
	
	public Object i() throws Exception
	{return urlViewer.i();}
	
	
	public void p(Object obj) throws Exception
	{
		data = (Class) obj;
		url = findURL();
		urlViewer.p(url);
	}
		
	
	private URL findURL() throws Exception
	{
		if(data==null) return null;
		return (URL) classToDocUrl.t(data);
	}
}
