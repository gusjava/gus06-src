package gus06.entity.gus.jna.keyboard.buffer.label.gadget;

import gus06.framework.*;
import javax.swing.JComponent;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import java.awt.*;

public class EntityImpl implements Entity, I {

	public String creationDate() {return "20141223";}

	public static final Dimension DIM = new Dimension(250,50);
	public static final Font FONT = new Font("ComicSans",Font.PLAIN,30);
	public static final Color COLOR = new Color(204,255,255);


	private Service keyPressedLabel;
	
	private JPanel panel;




	public EntityImpl() throws Exception
	{
		keyPressedLabel = Outside.service(this,"*gus.jna.keyboard.buffer.label");
		
		panel = new JPanel(new BorderLayout());
		panel.setOpaque(true);
		panel.setBackground(COLOR);
		panel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		panel.setMaximumSize(DIM);
		panel.setMinimumSize(DIM);
		panel.setPreferredSize(DIM);
		
		((JComponent) keyPressedLabel.i()).setFont(FONT);
		
		panel.add((JComponent) keyPressedLabel.i(),BorderLayout.CENTER);
	}

	public Object i() throws Exception
	{return panel;}
}