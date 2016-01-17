package gus06.entity.gus.swing.tree.perform.file.pastepath;

import gus06.framework.*;
import javax.swing.JTree;
import java.io.File;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20151021";}


	private Service copyFiles;


	public EntityImpl() throws Exception
	{
		copyFiles = Outside.service(this,"gus.dir.perform.copyfiles.fromclipboard.paths");
	}
	
	
	public void p(Object obj) throws Exception
	{
		JTree tree = (JTree) obj;
		File file = (File) tree.getLastSelectedPathComponent();
		if(file==null) return;
		
		File dir = file.isFile()?file.getParentFile():file;
		boolean done = copyFiles.f(dir);
		if(!done) return;
				
		TreePath path = tree.getSelectionPath();
		if(file.isFile()) path = path.getParentPath();
		tree.getModel().valueForPathChanged(path,null);
	}
}
