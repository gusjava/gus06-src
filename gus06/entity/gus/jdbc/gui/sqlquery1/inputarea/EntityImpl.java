package gus06.entity.gus.jdbc.gui.sqlquery1.inputarea;

import gus06.framework.*;
import javax.swing.JComponent;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.border.BevelBorder;
import javax.swing.BorderFactory;

public class EntityImpl extends S1 implements Entity, I, G, E {

	public String creationDate() {return "20150622";}
	
	public static final String TITLE = "SQL query";


	private Service syntax;
	private Service undo;
	private Service putAction;
	private Service persist;

	private JPanel panel;
	private JTextPane area;
	
	
	

	public EntityImpl() throws Exception
	{
		syntax = Outside.service(this,"gus.swing.textpane.cust.syntax.sql.ostermiller");
		undo = Outside.service(this,"gus.swing.textcomp.cust.action.ctrl_zy.undoredo");
		putAction = Outside.service(this,"gus.swing.textcomp.cust.putaction.ctrl_q");
		persist = Outside.service(this,"gus.swing.textcomp.persister.text");

		area = new JTextPane();
		initFont();
		
		undo.p(area);
		syntax.p(area);
		
		persist.v(getClass().getName()+"_area",area);
		putAction.p(new Object[]{area,this});
		
		JLabel titleLabel = new JLabel(TITLE);
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		titleLabel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		
		panel = new JPanel(new BorderLayout());
		panel.add(titleLabel,BorderLayout.NORTH);
		panel.add(new JScrollPane(area),BorderLayout.CENTER);
	}
	
	
	public Object i() throws Exception
	{return panel;}
	
	
	public Object g() throws Exception
	{return text();}


	public void e() throws Exception
	{perform();}

	
	private void perform()
	{send(this,"perform()");}



	
	private void initFont()
	{
		int fontSize = area.getFont().getSize();
		area.setFont(new Font("Courier New",Font.PLAIN,fontSize));
	}
	
	
	private String text()
	{
		String s = area.getSelectedText();
		if(s!=null && !s.equals("")) return s;
		return area.getText();
	}
}
