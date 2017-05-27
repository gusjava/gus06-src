package gus06.entity.gus.sys.drawingpanel1.d.line;

import gus06.framework.*;
import java.util.Map;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import java.awt.geom.Point2D;
import java.awt.Color;
import java.awt.geom.Line2D;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170426";}
	
	public static final String KEY_COLOR = "color";
	public static final String KEY_START = "start";
	public static final String KEY_END = "end";


	private Service findPoint;

	public EntityImpl() throws Exception
	{
		findPoint = Outside.service(this,"gus.sys.drawingpanel1.build.point2d");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		return new Holder((Map) obj);
	}
	
	
	private class Holder implements P, V
	{
		private Map map;
		private Object dimension;
		
		public Holder(Map map)
		{this.map = map;}
		
		public void v(String key, Object obj) throws Exception
		{
			if(key.equals("dimension")) {dimension = obj;return;}
			throw new Exception("Unknown key: "+key);
		}
		
		public void p(Object obj) throws Exception
		{
			Object[] o = (Object[]) obj;
			if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
			
			Graphics2D g2 = (Graphics2D) o[0];
			JPanel panel = (JPanel) o[1];
			
			Color color = (Color) get0(map,KEY_COLOR);
			Object start = get1(map,KEY_START);
			Object end = get1(map,KEY_END);
			
			if(color!=null) g2.setPaint(color);
			
			Point2D p1 = (Point2D) findPoint.t(new Object[]{start,panel,dimension});
			Point2D p2 = (Point2D) findPoint.t(new Object[]{end,panel,dimension});
			
			g2.draw(new Line2D.Double(p1,p2));
		}
	}
	
	
	private Object get0(Map map, String key)
	{
		if(!map.containsKey(key)) return null;
		return map.get(key);
	}
	
	private Object get1(Map map, String key) throws Exception
	{
		if(!map.containsKey(key)) throw new Exception("Key not found: "+key);
		return map.get(key);
	}
}
