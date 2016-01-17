package gus06.entity.gus.appli.allocinesearch.movie.posterscreen;

import gus06.framework.*;
import javax.swing.Icon;

public class EntityImpl implements Entity, I, P {

	public String creationDate() {return "20150215";}

	private Service imageViewer;
	private Icon notFoundIcon;
	
	
	public EntityImpl() throws Exception
	{
		imageViewer = Outside.service(this,"*gus.web.imagepanel1");
		notFoundIcon = (Icon) Outside.resource(this,"icon#notfound");
	}
	
	
	public Object i() throws Exception
	{return imageViewer.i();}
	
	
	public void p(Object obj) throws Exception
	{imageViewer.p(obj==null?notFoundIcon:obj);}
}
