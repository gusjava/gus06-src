package gus06.entity.gus.dir.explorer.treerenderer1;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.io.File;

import javax.swing.Icon;
import javax.swing.JTree;
import javax.swing.filechooser.FileSystemView;
import javax.swing.tree.DefaultTreeCellRenderer;

import gus06.framework.*;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20140723";}


	public static final int NB_LIMIT = 1000;
	
	
	private Service custUI;
	private Service findIcon;
	
	public EntityImpl() throws Exception
	{
		custUI = Outside.service(this,"gus.swing.tree.cust.ui.expandcollapseicons2");
		findIcon = Outside.service(this,"gus.file.icon.os");
	}



	public void p(Object obj) throws Exception
	{
		JTree tree = (JTree) obj;
		tree.setCellRenderer(new ExplorerTreeCellRenderer());
		custUI.p(tree);
	}
	
	
	private boolean isDriver(File file)
	{return FileSystemView.getFileSystemView().isDrive(file);}
	
	
	private boolean hasFiles(File dir)
	{
		File[] f = dir.listFiles();
		if(f==null || f.length==0) return false;
		
		for(int i=0;i<f.length;i++)
		{
			if(f[i].isFile()) return true;
			if(f[i].isDirectory() && hasFiles(f[i])) return true;
		}
		return false;
	}
	
	
	
	
	private Icon findIcon(File f)
	{
		try{return (Icon)findIcon.t(f);}
		catch(Exception e) {Outside.err(this,"findIcon(File)",e);}
		return null;
	}
	
	
	private Font findFont(Font font, File f)
	{
		if(!f.exists()) return font.deriveFont(Font.PLAIN);
		if(!f.canWrite()) return font.deriveFont(Font.ITALIC);
		return font.deriveFont(Font.PLAIN);
	}
	
	
	private Color findForeground(File f)
	{
		if(!f.exists()) return Color.GRAY;
		if(f.isFile() && f.length()==0) return Color.RED;
		if(f.isDirectory() && !hasFiles(f)) return Color.RED;
		if(f.isDirectory() && f.list().length>=NB_LIMIT) return Color.GREEN;
		return Color.BLACK;
	}
	
	
	private String findText(File f)
	{
		if(isDriver(f)) return f.getAbsolutePath();
		return f.getName();
	}
	
	
	
	
	
	
	
	
	private class ExplorerTreeCellRenderer extends DefaultTreeCellRenderer
	{
		public Component getTreeCellRendererComponent(JTree tree,Object value,boolean sel,boolean expanded,boolean leaf,int row,boolean hasFocus)
		{
			super.getTreeCellRendererComponent(tree,value,sel,expanded,leaf,row,hasFocus);
			
			if(value==null)return this; 
			if(!(value instanceof File))return this;
			File file = (File)value;
			
			setIcon(findIcon(file));
			setFont(findFont(getFont(),file));
			setForeground(findForeground(file));
			setText(findText(file));
			 
			return this;
		}
	}
}
