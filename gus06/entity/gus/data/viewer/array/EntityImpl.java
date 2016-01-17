package gus06.entity.gus.data.viewer.array;

import gus06.framework.*;
import javax.swing.JComponent;
import javax.swing.JPanel;
import java.util.Arrays;


public class EntityImpl implements Entity, I, P, G {

	public String creationDate() {return "20140731";}

	private Service listViewer;
	private Object[] data;

	
	public EntityImpl() throws Exception
	{listViewer = Outside.service(this,"*gus.data.viewer.list");}
	
	
	public Object g() throws Exception
	{return data;}
	
	
	public Object i() throws Exception
	{return listViewer.i();}
	
	
	public void p(Object obj) throws Exception
	{
		data = (Object[]) obj;
		if(data==null) listViewer.p(null);
		else listViewer.p(Arrays.asList(data));
	}
}
