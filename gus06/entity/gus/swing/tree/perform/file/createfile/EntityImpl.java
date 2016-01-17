package gus06.entity.gus.swing.tree.perform.file.createfile;

import gus06.framework.*;
import javax.swing.JTree;
import java.io.File;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20140917";}


	private Service askCreateFile;


	public EntityImpl() throws Exception
	{
		askCreateFile = Outside.service(this,"gus.file.perform.create.ask");
	}
	
	
	public void p(Object obj) throws Exception
	{
		JTree tree = (JTree) obj;
		File file = (File) tree.getLastSelectedPathComponent();
		if(file==null) return;
		
		boolean done = askCreateFile.f(file);
		if(!done) return;
		
		TreePath path = tree.getSelectionPath();
		if(file.isFile()) path = path.getParentPath();
		tree.getModel().valueForPathChanged(path,null);
	}
}
