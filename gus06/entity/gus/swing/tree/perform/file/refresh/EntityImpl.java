package gus06.entity.gus.swing.tree.perform.file.refresh;

import gus06.framework.*;
import javax.swing.JTree;
import java.io.File;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20141010";}




	public EntityImpl() throws Exception
	{
	}
	
	
	public void p(Object obj) throws Exception
	{
		JTree tree = (JTree) obj;
		((E) tree).e();
	}
}
