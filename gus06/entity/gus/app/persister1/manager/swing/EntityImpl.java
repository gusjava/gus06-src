package gus06.entity.gus.app.persister1.manager.swing;

import gus06.framework.*;
import javax.swing.JComboBox;
import javax.swing.text.JTextComponent;
import javax.swing.JTabbedPane;
import javax.swing.JFrame;
import javax.swing.JPasswordField;

public class EntityImpl implements Entity, V {

	public String creationDate() {return "20150509";}


	private Service persistComboBox;
	private Service persistPwdField;
	private Service persistTextComponent;
	private Service persistTabbedPane;
	private Service persistFrame;


	public EntityImpl() throws Exception
	{
		persistComboBox = Outside.service(this,"gus.swing.combobox.persister.index");
		persistPwdField = Outside.service(this,"gus.swing.pwdfield.persister.pwd");
		persistTextComponent = Outside.service(this,"gus.swing.textcomp.persister.text");
		persistTabbedPane = Outside.service(this,"gus.swing.tabbedpane.persister.tab");
		persistFrame = Outside.service(this,"gus.swing.frame.persister.bounds");
	}
	
	
	public void v(String key, Object obj) throws Exception
	{
		V v = findPersister(obj);
		v.v(key,obj);
	}
	
	
	
	private V findPersister(Object obj) throws Exception
	{
		if(obj instanceof JComboBox) return persistComboBox;
		if(obj instanceof JPasswordField) return persistPwdField;
		if(obj instanceof JTextComponent) return persistTextComponent;
		if(obj instanceof JTabbedPane) return persistTabbedPane;
		if(obj instanceof JFrame) return persistFrame;
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
}
