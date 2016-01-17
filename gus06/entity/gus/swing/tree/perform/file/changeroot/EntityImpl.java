package gus06.entity.gus.swing.tree.perform.file.changeroot;

import gus06.framework.*;
import javax.swing.JTree;
import java.io.File;
import javax.swing.tree.TreeModel;

public class EntityImpl implements Entity, V, P {

	public String creationDate() {return "20151003";}


	private P rootChanger;
	
	
	public void p(Object obj) throws Exception
	{
		JTree tree = (JTree) obj;
		File file = (File) tree.getLastSelectedPathComponent();
		
		if(file==null) return;
		
		File root = (File) tree.getModel().getRoot();
		File newRoot = file.equals(root)? root.getParentFile() : file;
		
		if(newRoot==null) return;
		
		if(rootChanger==null) throw new Exception("rootChanger not initialized yet");
		rootChanger.p(new File[]{root,newRoot});
	}
	
	
	public void v(String key, Object obj) throws Exception
	{
		if(key.equals("rootChanger")) {rootChanger = (P) obj;return;}
		throw new Exception("Unknown key: "+key);
	}
}
