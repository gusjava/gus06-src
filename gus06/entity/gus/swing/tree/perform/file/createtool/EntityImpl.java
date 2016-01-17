package gus06.entity.gus.swing.tree.perform.file.createtool;

import gus06.framework.*;
import javax.swing.JTree;
import java.io.File;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20150524";}


	private Service askCreate;


	public EntityImpl() throws Exception
	{
		askCreate = Outside.service(this,"gus.file.perform.create.tool.ask");
	}
	
	
	public void p(Object obj) throws Exception
	{
		JTree tree = (JTree) obj;
		File dir = (File) tree.getLastSelectedPathComponent();
		if(dir==null) return;
		
		dir = dir.isDirectory()?dir:dir.getParentFile();
		boolean done = askCreate.f(dir);
		if(!done) return;
		
		TreePath path = tree.getSelectionPath().getParentPath();
		tree.getModel().valueForPathChanged(path,null);
	}
}
