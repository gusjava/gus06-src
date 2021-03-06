package gus06.entity.gus.data.viewer.date;

import gus06.framework.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import javax.swing.*;
import java.awt.Insets;

public class EntityImpl implements Entity, I, P, G {

	public String creationDate() {return "20140731";}

	private SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");

	private Date data;

	private JTextArea area;
	private JScrollPane scroll;

	public EntityImpl() throws Exception
	{
		area = new JTextArea();
		area.setMargin(new Insets(3,3,3,3));
		area.setEditable(false);
		scroll = new JScrollPane(area);
	}
	
	
	public Object g() throws Exception
	{return data;}
	
	
	public Object i() throws Exception
	{return scroll;}
	
	
	public void p(Object obj) throws Exception
	{
		data = (Date) obj;
		if(data==null) area.setText("");
		else area.setText(data+"\n"+sdf.format(data));
	}
}
