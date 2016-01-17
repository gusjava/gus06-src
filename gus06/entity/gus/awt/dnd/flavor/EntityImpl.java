package gus06.entity.gus.awt.dnd.flavor;

import gus06.framework.*;
import java.awt.datatransfer.*;

public class EntityImpl implements Entity, G {

	public String creationDate() {return "20141115";}

	private DataFlavor[] flavor;
	
	public EntityImpl() throws Exception
	{
		flavor = new DataFlavor[]{new ObjectFlavor(),DataFlavor.javaFileListFlavor};
	}
	
	public Object g() throws Exception
	{return flavor;}
	
	
	public class ObjectFlavor extends DataFlavor
	{
		public ObjectFlavor() throws ClassNotFoundException 
		{super(javaJVMLocalObjectMimeType+";class=java.lang.Object");}
	}
}
