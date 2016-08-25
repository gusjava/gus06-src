package gus06.entity.gus.data.viewer.class1.panel.doc.entity;

import gus06.framework.*;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.Insets;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.Font;


public class EntityImpl implements Entity, I, P, G {

	public String creationDate() {return "20160507";}

	public static final Font FONT = new Font("Calibri",Font.PLAIN,20);

	private Service findLingString;

    
	private String name;
	private String doc;
	
	private JPanel panel;
	private JTextArea area;


	public EntityImpl() throws Exception
	{
		findLingString = Outside.service(this,"gus.ling.find.lingstring");
		
		area = new JTextArea();
		area.setEditable(false);
		area.setMargin(new Insets(3,3,3,3));
		area.setLineWrap(true);
		area.setWrapStyleWord(true);
		area.setFont(FONT);
		
		panel = new JPanel(new BorderLayout());
		panel.add(new JScrollPane(area),BorderLayout.CENTER);
	}
	
	
	public Object g() throws Exception
	{return name;}
	
	
	public Object i() throws Exception
	{return panel;}
	
	
	public void p(Object obj) throws Exception
	{
		name = (String) obj;
		doc = (String) findLingString.r("doc_"+name);
		area.setText(doc);
	}
}
