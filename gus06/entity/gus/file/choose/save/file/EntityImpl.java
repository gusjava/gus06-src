package gus06.entity.gus.file.choose.save.file;

import gus06.framework.*;
import javax.swing.JFileChooser;

public class EntityImpl implements Entity, G {

	public String creationDate() {return "20141017";}


	private Service fcHolder;
	private JFileChooser fc;
	
	
	public EntityImpl() throws Exception
	{
		fcHolder = Outside.service(this,"*gus.swing.filechooser.holder");
		fc = (JFileChooser) fcHolder.i();
		fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
	}
	
	
	public Object g() throws Exception
	{
		int val = fc.showSaveDialog(null);
		if(val==JFileChooser.APPROVE_OPTION)
			return fc.getSelectedFile();
		return null;
	}
}
