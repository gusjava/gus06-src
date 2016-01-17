package gus06.entity.gus.swing.frame.cust2.size;

import gus06.framework.*;
import javax.swing.JFrame;
import java.awt.Dimension;

public class EntityImpl implements Entity, V {

	public String creationDate() {return "20140803";}


	private Service stringToDim;

	public EntityImpl() throws Exception
	{stringToDim = Outside.service(this,"gus.convert.stringtodimension");}
	
	
	public void v(String key, Object obj) throws Exception
	{perform(key,(JFrame) obj);}
	
	
	private void perform(String info, JFrame frame) throws Exception
	{frame.setSize(dim(info));}
	
	
	private Dimension dim(String id) throws Exception
	{return (Dimension) stringToDim.t(id);}
}
