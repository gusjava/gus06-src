package gus06.entity.gus.appli.gusprojectmanager.gui.settings;

import gus06.framework.*;
import javax.swing.JComponent;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.JPasswordField;

public class EntityImpl implements Entity, I {

	public String creationDate() {return "20150614";}
	
	public static final String KEY_PROJECTDIR = "projectdir";
	public static final String KEY_ICONDIR = "icondir";
	public static final String KEY_JARDIR = "jardir";
	public static final String KEY_DLLDIR = "dlldir";
	
	

	private Service form;
	private Service option;
	
	private JPanel panel;

	public EntityImpl() throws Exception
	{
		form = Outside.service(this,"*gus.swing.panel.formpanel");
		option = Outside.service(this,"gus.sys.option.comp.register");
		
		addField(KEY_PROJECTDIR,	"R�pertoire des projets");
		addField(KEY_ICONDIR,		"R�pertoire des icones");
		addField(KEY_JARDIR,		"R�pertoire des jars");
		addField(KEY_DLLDIR,		"R�pertoire des dll");
		
		panel = new JPanel(new BorderLayout());
		panel.add((JComponent) form.i(),BorderLayout.CENTER);
		
		panel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
	}
	
	
	public Object i() throws Exception
	{return panel;}
	
	
	
	private void addField(String key, String label) throws Exception
	{
		JTextField field = new JTextField();
		option.v(key,field);
		form.v(label,field);
	}
	
	private void addPwd(String key, String label) throws Exception
	{
		JPasswordField field = new JPasswordField();
		option.v(key,field);
		form.v(label,field);
	}
}
