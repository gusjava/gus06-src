package gus06.entity.gus.swing.tree.perform.file.duplicate.timestamped;

import gus06.framework.*;
import javax.swing.JTree;
import java.io.File;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20151004";}


	private Service perform;

	public EntityImpl() throws Exception
	{
		perform = Outside.service(this,"gus.dirfile.perform.duplicate.timestamped");
	}
	
	
	public void p(Object obj) throws Exception
	{
		JTree tree = (JTree) obj;
		File file = (File) tree.getLastSelectedPathComponent();
		
		if(file==null) return;
		if(!file.exists()) return;
		
		boolean done = perform.f(file);
		if(!done) return;
		
		TreePath path = tree.getSelectionPath().getParentPath();
		tree.getModel().valueForPathChanged(path,null);
	}
}
