package gus06.entity.gus.sys.clipboard1.gui.displaylabel1;

import gus06.framework.*;
import javax.swing.JLabel;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class EntityImpl implements Entity, I, MouseListener {

	public String creationDate() {return "20151017";}


	private Service labelHolder;
	private Service quickState;
	private Service perform;
	
	private JLabel label;


	public EntityImpl() throws Exception
	{
		labelHolder = Outside.service(this,"*gus.sys.clipboard1.gui.displaylabel");
		quickState = Outside.service(this,"gus.swing.label.perform.quickstate1");
		perform = Outside.service(this,"gus.sys.clipboard1.gui.displaylabel1.perform");
		
		label = (JLabel) labelHolder.i();
		label.setFocusable(true);
		label.addMouseListener(this);
	}
	
	
	public Object i() throws Exception
	{return label;}
	
	
	public void mouseExited(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseClicked(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mousePressed(MouseEvent e)
	{perform();}
	
	
	
	private void perform()
	{
		try
		{
			quickState.p(label);
			perform.e();
		}
		catch(Exception e)
		{Outside.err(this,"perform()",e);}
	}

}
