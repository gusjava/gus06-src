package gus06.entity.gus.file.editor.ext.lnk;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, I, P, G {

	public String creationDate() {return "20170409";}

	
	private Service extractPath;
	private Service formPanel;
	private Service buildDesc;
	
	private File file;
	


	public EntityImpl() throws Exception
	{
		extractPath = Outside.service(this,"gus.file.lnk.extract.path");
		formPanel = Outside.service(this,"*gus.swing.panel.formpanel.map");
		buildDesc = Outside.service(this,"gus.tostring.desc.short1.file");
	}
	
	
	public Object i() throws Exception
	{return formPanel.i();}
	
	
	public Object g() throws Exception
	{return file;}
	
	
	
	
	
	
	public void p(Object obj) throws Exception
	{
		file = (File) obj;
		if(file==null) {resetGui();return;}
		
		File target = (File) extractPath.t(file);
		String desc = (String) buildDesc.t(target);
		
		formPanel.v("Target",desc);
	}
	
	
	
	private void resetGui() throws Exception
	{formPanel.e();}
}
