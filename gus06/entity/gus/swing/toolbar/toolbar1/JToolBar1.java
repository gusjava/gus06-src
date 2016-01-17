
package gus06.entity.gus.swing.toolbar.toolbar1;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JToolBar;
import javax.swing.border.Border;


public class JToolBar1 extends JToolBar {

	private static Border empty = BorderFactory.createEmptyBorder();
	private static Border etched = BorderFactory.createEtchedBorder();
	
	private Dimension buttonSize;
	private Border border; 
	
	public static int H = 20;
	


	public JToolBar1()
	{this(H);}

	public JToolBar1(int x)
	{
		super();
		setFloatable(false);
		buttonSize = new Dimension(x,x);
		border = empty;
		
		setFocusable(true);
		setBorder(empty);
		
		addMouseListener(new MouseAdapter(){
		public void mousePressed(MouseEvent e)
		{requestFocusInWindow();}});
	}
	
	
	
	public JButton add(Action a)
	{
		JButton b = super.add(a);
		b.setMinimumSize(buttonSize);
		b.setMaximumSize(buttonSize);
		b.setBorder(border);
		setMinimumSize(new Dimension(0,0));
		b.setOpaque(false);
		return b;
	}

}
