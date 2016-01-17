package gus06.entity.gus.swing.tree.perform.file.copy;

import gus06.framework.*;
import javax.swing.JTree;
import java.io.File;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;
import java.util.ArrayList;
import java.util.List;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20140918";}


	private Service copyFiles;
	private Service selectionToList;


	public EntityImpl() throws Exception
	{
		copyFiles = Outside.service(this,"gus.clipboard.access.listfiles");
		selectionToList = Outside.service(this,"gus.swing.tree.selection.tofileslist");
	}
	
	
	public void p(Object obj) throws Exception
	{
		List files = treeToSelection((JTree) obj);
		if(!files.isEmpty()) copyFiles.p(files);
	}
	
	private List treeToSelection(JTree tree) throws Exception
	{return (List) selectionToList.t(tree);}
}
