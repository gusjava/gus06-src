package gus06.entity.gus.file.editor.ext.zip.entryviewer;

import gus06.framework.*;
import javax.swing.JComponent;
import java.io.File;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class EntityImpl implements Entity, P, I, ActionListener {

	public String creationDate() {return "20141024";}


	public static final String DELIM = "/";
	
	
	private Service entryLabel;
	private Service entryPanel;
	private Service writeToFile;
    
	private JPanel panel;
	private JButton button;
	
	private File file;
	private String entry;
	
	

	public EntityImpl() throws Exception
	{
		entryLabel = Outside.service(this,"*gus.file.editor.ext.jar.entryviewer.label");
		entryPanel = Outside.service(this,"*gus.file.editor.ext.jar.entryviewer.panel");
		writeToFile = Outside.service(this,"gus.io.transfer.writetofile.choosedir");
		
		button = new JButton("Extract");
		button.setEnabled(false);

		panel = new JPanel(new BorderLayout());
		panel.add((JComponent) entryLabel.i(),BorderLayout.NORTH);
		panel.add((JComponent) entryPanel.i(),BorderLayout.CENTER);
		panel.add(button,BorderLayout.SOUTH);
		
		button.addActionListener(this);
	}
	
	
	public Object i() throws Exception
	{return panel;}
	
	
	
	public void p(Object obj) throws Exception
	{
		if(obj==null) {resetGui();return;}
	
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		file = (File) o[0];
		entry = (String) o[1];
		
		updateGui();
	}
	
	
	
	
	
	private void updateGui() throws Exception
	{
		entryLabel.p(entry);
		button.setEnabled(true);
		
		ZipFile zipFile = new ZipFile(file,ZipFile.OPEN_READ);
		ZipEntry zipEntry = zipFile.getEntry(entry);
		InputStream is = zipFile.getInputStream(zipEntry);
		
		String ext = getExtension();
		entryPanel.v(ext,is);
		
		is.close();
		zipFile.close();
	}
	
	
	
	
	private void resetGui() throws Exception
	{
		file = null;
		entry = null;
		entryLabel.p(null);
		entryPanel.v(null,null);
		button.setEnabled(false);
	}
	
	
	
	
	public void actionPerformed(ActionEvent e)
	{extract();}
	
	
	
	private void extract()
	{
		try
		{
			if(file==null) return;
			
			ZipFile zipFile = new ZipFile(file,ZipFile.OPEN_READ);
			ZipEntry zipEntry = zipFile.getEntry(entry);
			InputStream is = zipFile.getInputStream(zipEntry);
			
			String fileName = getFileName();
			writeToFile.v(fileName,is);
			
			is.close();
			zipFile.close();
		}
		catch(Exception e)
		{Outside.err(this,"extract()",e);}
	}
	
	
	
	
	
	private String getExtension()
	{
		if(entry==null) return null;
		if(entry.endsWith(DELIM)) return "#";
		if(!entry.contains(".")) return "";
		
		String[] n = entry.split("\\."); 
		return n[n.length-1];
	}
	
	
	private String getFileName()
	{
		if(entry==null) return null;
		if(entry.endsWith(DELIM)) return "#";
		if(!entry.contains(DELIM)) return "";
		
		String[] n = entry.split(DELIM); 
		return n[n.length-1];
	}
}
