package gus06.entity.gus.swing.textcomp.highlight.painter.builder1;

import gus06.framework.*;
import javax.swing.text.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Shape;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Graphics2D;


public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151107";}
	
	public static final int EDGE = 8;
	
	
	public Object t(Object obj) throws Exception
	{return new HPainter((Color) obj);}


	
	private class HPainter extends DefaultHighlighter.DefaultHighlightPainter
	{
		public HPainter(Color c)
		{super(c);}
		
		public Shape paintLayer(Graphics g, int offs0, int offs1, Shape bounds, JTextComponent c, View view)
		{
			Graphics2D g2 = (Graphics2D) g;
			
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,	RenderingHints.VALUE_ANTIALIAS_ON);
			g2.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL,	RenderingHints.VALUE_STROKE_PURE);
		
			Color color = getColor();
			if(color != null) g.setColor(color);
           		else g.setColor(c.getSelectionColor());

			Rectangle r;

			if(offs0 == view.getStartOffset() && offs1 == view.getEndOffset())
			{
				r = (bounds instanceof Rectangle) ? (Rectangle)bounds : bounds.getBounds();
			}
			else
			{
				try
				{
					Shape shape = view.modelToView(offs0, Position.Bias.Forward, offs1, Position.Bias.Backward, bounds);
					r = (shape instanceof Rectangle) ? (Rectangle)shape : shape.getBounds();
				}
				catch (BadLocationException e) {r = null;}
			}

			if(r != null)
			{
				r.width = Math.max(r.width,1);
				g.fillRoundRect(r.x, r.y, r.width, r.height,EDGE,EDGE);
			}

			return r;
		}
	}
}
