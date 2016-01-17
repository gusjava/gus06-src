package gus06.entity.gus.swing.tree.perform.file.createdir;

import gus06.framework.*;
import javax.swing.JTree;
import java.io.File;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20140917";}


	private Service askCreateDir;


	public EntityImpl() throws Exception
	{
		askCreateDir = Outside.service(this,"gus.dir.perform.create.ask");
	}
	
	
	public void p(Object obj) throws Exception
	{
		JTree tree = (JTree) obj;
		File file = (File) tree.getLastSelectedPathComponent();
		if(file==null) return;
		
		boolean done = askCreateDir.f(file);
		if(!done) return;
		
		TreePath path = tree.getSelectionPath();
		if(file.isFile()) path = path.getParentPath();
		tree.getModel().valueForPathChanged(path,null);
	}
}
