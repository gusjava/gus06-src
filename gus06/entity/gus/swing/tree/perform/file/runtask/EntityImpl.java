package gus06.entity.gus.swing.tree.perform.file.runtask;

import gus06.framework.*;
import javax.swing.JTree;
import java.io.File;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20150602";}


	private Service runtaskPath;


	public EntityImpl() throws Exception
	{
		runtaskPath = Outside.service(this,"gus.sys.runtask1.input.path");
	}
	
	
	public void p(Object obj) throws Exception
	{
		JTree tree = (JTree) obj;
		File path = (File) tree.getLastSelectedPathComponent();
		runtaskPath.p(path);
	}
}
