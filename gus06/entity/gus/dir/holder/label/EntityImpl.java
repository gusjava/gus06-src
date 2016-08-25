package gus06.entity.gus.dir.holder.label;

import java.io.File;
import javax.swing.Icon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import gus06.framework.*;

public class EntityImpl extends S1 implements Entity, P, G, I {

	public String creationDate() {return "20160421";}
	
	
	private Service dnd;
	private Service findFile;
	private Service fileIcon;
	
	private JLabel label;
	private File f;
	

	
	public EntityImpl() throws Exception
	{
		dnd = Outside.service(this,"gus.awt.dnd");
		fileIcon = Outside.service(this,"gus.file.icon.os");
		findFile = Outside.service(this,"gus.find.file");
		
		label = new JLabel("<>");
		
		dnd.v("pg",this);
		dnd.p(label);
	}
	
	
	
	public void p(Object obj) throws Exception
	{
		f = (File) findFile.t(obj);
		if(f==null || f.isFile())
		{
			f=null;
			return;
		}
		handle();
	}


	
	public Object g() throws Exception
	{return f;}
	
	
	public Object i()
	{return label;}
	
	
	
	
	
	private void handle() throws Exception
	{
		String path = f.getAbsolutePath();
		String name = f.getName();
		
		if(name.equals("")) name = path;
		
		label.setToolTipText(path);
		
		if(!f.exists())
		{
			label.setText("<"+name+">");
			label.setIcon(null);
			return;
		}
		
		label.setText(name);
		Icon icon = (Icon) fileIcon.t(f);
		if(icon!=null) label.setIcon(icon);
		
		send(this,"handle()");
	}
}
