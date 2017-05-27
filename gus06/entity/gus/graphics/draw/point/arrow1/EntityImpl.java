package gus06.entity.gus.graphics.draw.point.arrow1;

import java.awt.Graphics2D;
import java.awt.Point;
import gus06.framework.*;

public class EntityImpl implements Entity, P, V {

	public String creationDate() {return "20161202";}

	
	public static final double ARROW_COEF = 8;
	

	private Graphics2D g2;
	private double arrowCoef = ARROW_COEF;
	
	
	public void v(String key, Object obj) throws Exception
	{
		if(key.equals("graphics2D")) {g2 = (Graphics2D) obj;return;}
		if(key.equals("arrowCoef")) {arrowCoef = Double.parseDouble((String) obj);return;}
		throw new Exception("Unknown key: "+key);
	}


	
	public void p(Object obj) throws Exception
	{
		Point[] p = (Point[]) obj;
		drawArrow(p[0],p[1]);
	}
	
	
	private void drawArrow(Point p1, Point p2)
	{
		drawLine(p1,p2);
		if(p1.equals(p2)) return;

		Point pc = getCenter(p1,p2);
		double d = getDistance(p1,p2);
		double k = arrowCoef/d;

		Point pa1 = getArrowPoint1(p1,p2,pc,k);
		Point pa2 = getArrowPoint2(p1,p2,pc,k);
		
		drawLine(pc,pa1);
		drawLine(pc,pa2);
	}


	
	private Point getCenter(Point p1, Point p2)
	{
		double x = (p1.x + p2.x)/2;
		double y = (p1.y + p2.y)/2;
		return new Point((int)x,(int)y);
	}
	
	
	private double getDistance(Point p1, Point p2)
	{
		int dx = p1.x - p2.x;
		int dy = p1.y - p2.y;
		return Math.sqrt(dx*dx + dy*dy);
	}
	
	
	private Point getArrowPoint1(Point p1, Point p2, Point pc, double k)
	{
		double x = pc.x + k*(p1.x-p2.x+p1.y-p2.y);
		double y = pc.y + k*(p2.x-p1.x+p1.y-p2.y);
		return new Point((int)x,(int)y);
	}
	
	private Point getArrowPoint2(Point p1, Point p2, Point pc, double k)
	{
		double x = pc.x + k*(p1.x-p2.x+p2.y-p1.y);
		double y = pc.y + k*(p1.x-p2.x+p1.y-p2.y);
		return new Point((int)x,(int)y);
	}
	
	
	private void drawLine(Point p1, Point p2)
	{g2.drawLine(p1.x,p1.y,p2.x,p2.y);}
}
