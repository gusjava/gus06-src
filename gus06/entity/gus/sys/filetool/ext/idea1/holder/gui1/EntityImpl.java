package gus06.entity.gus.sys.filetool.ext.idea1.holder.gui1;

import gus06.framework.*;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.Scrollable;
import javax.swing.JTree;
import java.io.File;

public class EntityImpl implements Entity, I, P {

	public String creationDate() {return "20160915";}


	private Service tagBrowser;
	private Service treeRenderer;
	private Service expandCollapse;
	private Service buildPanel;
	private Service autoSaver;
	
	private JTextArea textArea;
	private JTree browser;
	private JSplitPane split;
	private JPanel panel;
	
	private File file;


	public EntityImpl() throws Exception
	{
		tagBrowser = Outside.service(this,"gus.swing.textarea.buildtagbrowser");
		treeRenderer = Outside.service(this,"gus.swing.tree.cust.renderer.display1");
		expandCollapse = Outside.service(this,"gus.swing.tree.cust.ui.expandcollapseicons");
		buildPanel = Outside.service(this,"gus.swing.textarea.buildpanel1");
		autoSaver = Outside.service(this,"*gus.file.editor.holder.text.autosaver");
		
		textArea = new JTextArea();
		
		browser = (JTree) tagBrowser.t(textArea);
		panel = (JPanel) buildPanel.t(textArea);
		
		treeRenderer.p(browser);
		expandCollapse.p(browser);

		split = new JSplitPane();
		split.setDividerLocation(200);
		split.setLeftComponent(new JScrollPane(browser));
		split.setRightComponent(panel);
		
		autoSaver.v("comp",textArea);
	}
	
	
	public void p(Object obj) throws Exception
	{
		file = (File) obj;
		boolean loaded = autoSaver.f(file);
	}
	
	
	
	public Object i() throws Exception
	{return split;}
}
