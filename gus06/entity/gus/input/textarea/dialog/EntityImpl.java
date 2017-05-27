package gus06.entity.gus.input.textarea.dialog;

import gus06.framework.*;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;

public class EntityImpl implements Entity, T, G {

	public String creationDate() {return "20170128";}
	
	public static final int WIDTH = 500;
	public static final int HEIGHT = 300;


	private Service dialog;
	private Service buildLabelTitle;
	private Service buildTextArea;
	private Service okCancel;
	
	private JLabel labelTitle;
	private JTextArea textArea;
	private JPanel panel;
	
	
	public EntityImpl() throws Exception
	{
		dialog = Outside.service(this,"gus.swing.dialog.blocked1.okcancel");
		buildLabelTitle = Outside.service(this,"gus.swing.label.build.titlelabel1");
		buildTextArea = Outside.service(this,"gus.swing.textarea.buildarea1");
		okCancel = Outside.service(this,"gus.swing.dialog.blocked1.okcancel");
		
		labelTitle = (JLabel) buildLabelTitle.i();
		textArea = (JTextArea) buildTextArea.i();
		
		panel = new JPanel(new BorderLayout());
		panel.add(labelTitle,BorderLayout.NORTH);
		panel.add(new JScrollPane(textArea),BorderLayout.CENTER);
	}

	
	
	public Object t(Object obj) throws Exception
	{
		if(obj instanceof String)
		{
			String title = (String) obj;
			String initValue = "";
			return askForInput(title,initValue);
		}
		if(obj instanceof String[])
		{
			String[] o = (String[]) obj;
			if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
			
			String title = o[0];
			String initValue = o[1];
			return askForInput(title,initValue);
		}
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	public Object g() throws Exception
	{
		return askForInput("INPUT","");
	}
	
	
	
	private String askForInput(String title, String initValue) throws Exception
	{
		labelTitle.setText(title);
		textArea.setText(initValue);
		
		okCancel.v("width",""+WIDTH);
		okCancel.v("height",""+HEIGHT);
		boolean result = okCancel.f(panel);
		
		return result ? textArea.getText() : null;
	}
}
