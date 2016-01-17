package gus06.entity.gus.swing.tree.perform.file.duplicate;

import gus06.framework.*;
import javax.swing.JTree;
import java.io.File;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20140917";}


	private Service askDuplicate;


	public EntityImpl() throws Exception
	{
		askDuplicate = Outside.service(this,"gus.dirfile.perform.duplicate.ask");
	}
	
	
	public void p(Object obj) throws Exception
	{
		JTree tree = (JTree) obj;
		File file = (File) tree.getLastSelectedPathComponent();
		
		if(file==null) return;
		if(!file.exists()) return;
		
		boolean done = askDuplicate.f(file);
		if(!done) return;
		
		TreePath path = tree.getSelectionPath().getParentPath();
		tree.getModel().valueForPathChanged(path,null);
	}
}
