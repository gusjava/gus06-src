package gus06.entity.gus.swing.icon.build.sensitive;

import gus06.framework.*;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.Icon;

public class EntityImpl implements Entity, T, V {

	public String creationDate() {return "20141203";}


	private Object rollover;
	private Object pressed;

	public EntityImpl() throws Exception
	{
	}
	
	
	public void v(String key, Object obj) throws Exception
	{
		if(key.equals("rollover")) {rollover = obj;return;}
		if(key.equals("pressed")) {pressed = obj;return;}
		throw new Exception("Unknown key: "+key);
	}
	
	
	public Object t(Object obj) throws Exception
	{
		Icon icon = (Icon) obj;
		Icon icon_rollover = buildIcon(rollover,icon);
		Icon icon_pressed = buildIcon(pressed,icon);
		
		return new SensitiveIcon(icon,icon_rollover,icon_pressed);
	}

	
	
	private Icon buildIcon(Object source, Icon icon) throws Exception
	{
		if(source==null)
			return null;
		if(source instanceof Icon)
			return (Icon) source;
		if(source instanceof T)
			return (Icon) ((T) source).t(icon);
		if(source instanceof G)
			return (Icon) ((G) source).g();
		
		throw new Exception("Invalid type: "+source.getClass().getName());
	}

	
	
	
	
	private class SensitiveIcon implements Icon, T
	{
		private Icon icon;
		private Icon icon_rollover;
		private Icon icon_pressed;
		
		private Map map;
		
		public SensitiveIcon(Icon icon, Icon icon_rollover, Icon icon_pressed)
		{
			this.icon = icon;
			this.icon_rollover = icon_rollover;
			this.icon_pressed = icon_pressed;
			
			map = new HashMap();
		}
		
		public void paintIcon(Component c, Graphics g, int x, int y)
		{
			IconPainter painter = getPainter(c);
			painter.updateInfos(x,y);
			
			if(painter.isPressed() && icon_pressed!=null)
				icon_pressed.paintIcon(c,g,x,y);
			else if(painter.isInside() && icon_rollover!=null)
				icon_rollover.paintIcon(c,g,x,y);
			else icon.paintIcon(c,g,x,y);
		}
		
		public int getIconWidth() {return icon.getIconWidth();}
		public int getIconHeight() {return icon.getIconHeight();}

		
		public Object t(Object obj) throws Exception
		{return getPainter((Component) obj);}
		
		
		private IconPainter getPainter(Component c)
		{
			if(!map.containsKey(c))
				map.put(c,new IconPainter(this,c));
			return (IconPainter) map.get(c);
		}
	}
	
	
	
	
	
	
	private class IconPainter extends S1 implements MouseListener, MouseMotionListener
	{
		private Icon icon;
		private Component c;
		
		private boolean mouseInside = false;
		private boolean mousePressed = false;
		
		public boolean isInside() {return mouseInside;}
		public boolean isPressed() {return mouseInside && mousePressed;}
		
		private int x = 0;
		private int y = 0;
		
		public IconPainter(Icon icon, Component c)
		{
			this.icon = icon;
			this.c = c;
			
			c.addMouseListener(this);
			c.addMouseMotionListener(this);
		}
		
		public void updateInfos(int x, int y)
		{
			this.x = x;
			this.y = y;
		}
		
		private void refreshComponent()
		{c.repaint();}
		
		
		private int w(){return icon.getIconWidth();}
		private int h(){return icon.getIconHeight();}
		
		private Rectangle getBounds()
		{return new Rectangle(x,y,w(),h());}
		
		private boolean inside(MouseEvent e)
		{return getBounds().contains(e.getPoint());}
		
		public void mouseDragged(MouseEvent e)
		{
			mouseInside = false;
			mousePressed = false;
			refreshComponent();
		}
		
		public void mousePressed(MouseEvent e)
		{
			mousePressed = true;
			refreshComponent();
		}
		
		public void mouseClicked(MouseEvent e)
		{if(inside(e)) clicked();}
		
		public void mouseReleased(MouseEvent e)
		{mouseMoved(e);}
		
		public void mouseMoved(MouseEvent e)
		{
			boolean inside_ = mouseInside;
			mouseInside = inside(e);
			
			if(mousePressed)
			{
				mousePressed = false;
				refreshComponent();
			}
			if(!inside_ && mouseInside)
			{
				refreshComponent();
				entered();
			}
			else if(inside_ && !mouseInside)
			{
				refreshComponent();
				exited();
			}
		}
		
		public void mouseEntered(MouseEvent e) {}
		public void mouseExited(MouseEvent e)
		{
			if(!mouseInside) return;
			mouseInside = false;
			refreshComponent();
			exited();
		}
		
		private void clicked()
		{send(this,"clicked()");}
		
		private void entered()
		{send(this,"entered()");}
		
		private void exited()
		{send(this,"exited()");}
	}

}