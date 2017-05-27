package gus06.entity.gus.file.editor.ext.jar.entryviewer.panel.class1;

import gus06.framework.*;
import javax.swing.JComponent;
import java.io.InputStream;
import java.util.Set;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextArea;
import java.awt.Insets;
import javax.swing.JScrollPane;
import java.util.Map;

public class EntityImpl implements Entity, I, P {

	public String creationDate() {return "20140809";}

	private Service formPanel;
	private Service jdkMapping;
	private Service analyze;
	private Service setToString;
	
	private JPanel panel;
	private JTextArea area;
	
	public EntityImpl() throws Exception
	{
		formPanel = Outside.service(this,"*gus.swing.panel.formpanel.map");
		jdkMapping = Outside.service(this,"gus.java.jdk.versionmapping");
		analyze = Outside.service(this,"gus.java.bytecode.jdepend.analyze.data");
		setToString = Outside.service(this,"gus.tostring.set");
		
		area = new JTextArea();
		area.setEditable(false);
		area.setMargin(new Insets(3,3,3,3));
		
		panel = new JPanel(new BorderLayout());
		panel.add((JComponent) formPanel.i(),BorderLayout.NORTH);
		panel.add(new JScrollPane(area),BorderLayout.CENTER);
	}
	
	
	public Object i() throws Exception
	{return panel;}
	
	
	
	public void p(Object obj) throws Exception
	{
		InputStream is = (InputStream) obj;
		Map data = (Map) analyze.t(is);
		
		Integer minor = (Integer) data.get("minorversion");
		Integer major = (Integer) data.get("majorversion");
		Set imports = (Set) data.get("imports");
		
		String jdkVer = (String) jdkMapping.t(major);
		String imports_ = (String) setToString.t(imports);
	
		formPanel.v("JDK version",jdkVer);
		formPanel.v("Minor version",""+minor);
		formPanel.v("Major version",""+major);
		formPanel.v("Imports nb",""+imports.size());
		
		area.setText(imports_);
	}
}
