package gus06.entity.gus.appli.entityanalyze.gui.settings;

import gus06.framework.*;
import javax.swing.JComponent;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.JPasswordField;

public class EntityImpl implements Entity, I {

	public String creationDate() {return "20150526";}
	
	public static final String KEY_SOURCEDIR = "sourcedir";
	public static final String KEY_BASEDIR = "basedir";
	
	

	private Service form;
	private Service option;
	
	private JPanel panel;

	public EntityImpl() throws Exception
	{
		form = Outside.service(this,"*gus.swing.panel.formpanel");
		option = Outside.service(this,"gus.sys.option.comp.register");
		
		addField(KEY_SOURCEDIR,		"R�pertoire des sources");
		addField(KEY_BASEDIR,		"R�pertoire de l'analyse");
		
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
