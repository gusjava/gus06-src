package gus06.entity.gus.data.editor.renderedimage.editor1;

import gus06.framework.*;
import javax.swing.JPanel;
import java.awt.image.RenderedImage;
import java.awt.BorderLayout;
import javax.swing.JComponent;
import javax.swing.Action;
import javax.swing.JToolBar;
import java.awt.Color;
import javax.swing.BorderFactory;

public class EntityImpl extends S1 implements Entity, I, P, G {

	public String creationDate() {return "20151007";}


	private Service screen;
	
	private Service action_rotate90;
	private Service action_rotate180;
	private Service action_rotate270;
	
	private Service action_flip_vertical;
	private Service action_flip_horizontal;
	private Service action_flip_diagonal;
	private Service action_flip_antidiagonal;


	private JPanel panel;
	private JToolBar toolbar;
	
	private RenderedImage image;
	
	
	
	public EntityImpl() throws Exception
	{
		screen = Outside.service(this,"*gus.swing.panel.screen.image");
		
		action_rotate90 = Outside.service(this,"gus.data.editor.renderedimage.editor1.action.rotate90");
		action_rotate180 = Outside.service(this,"gus.data.editor.renderedimage.editor1.action.rotate180");
		action_rotate270 = Outside.service(this,"gus.data.editor.renderedimage.editor1.action.rotate270");
		
		action_flip_vertical = Outside.service(this,"gus.data.editor.renderedimage.editor1.action.flip.vertical");
		action_flip_horizontal = Outside.service(this,"gus.data.editor.renderedimage.editor1.action.flip.horizontal");
		action_flip_diagonal = Outside.service(this,"gus.data.editor.renderedimage.editor1.action.flip.diagonal");
		action_flip_antidiagonal = Outside.service(this,"gus.data.editor.renderedimage.editor1.action.flip.antidiagonal");
		
		
		toolbar = new JToolBar();
		toolbar.setFloatable(false);
		toolbar.setBackground(Color.WHITE);
		toolbar.setBorder(BorderFactory.createEmptyBorder(10,0,0,0));
		
		add(action_rotate90);
		add(action_rotate180);
		add(action_rotate270);
		add(action_flip_vertical);
		add(action_flip_horizontal);
		add(action_flip_diagonal);
		add(action_flip_antidiagonal);
		
		JComponent screenComp = (JComponent) screen.i();
		screenComp.setBackground(Color.WHITE);
		
		panel = new JPanel(new BorderLayout());
		panel.add(screenComp,BorderLayout.CENTER);
		panel.add(center(toolbar),BorderLayout.SOUTH);
	}
	
	
	private void add(Service s) throws Exception
	{
		toolbar.addSeparator();
		toolbar.add((Action) s.t(this));
		toolbar.addSeparator();
	}
	
	
	
	private JPanel center(JComponent c)
	{
		JPanel p = new JPanel();
		p.setBackground(Color.WHITE);
		p.add(c);
		return p;
	}
	
	
	public Object g() throws Exception
	{return image;}
	
	
	public Object i() throws Exception
	{return panel;}
	
	
	public void p(Object obj) throws Exception
	{
		image = (RenderedImage) obj;
		screen.p(image);
	}
}
