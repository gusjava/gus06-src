package gus06.entity.gus.sys.drawingpanel1.build.point2d;

import gus06.framework.*;
import javax.swing.JPanel;
import java.awt.geom.Point2D;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170425";}


	private Service findPoint;
	private Service findDouble2;
	
	public EntityImpl() throws Exception
	{
		findPoint = Outside.service(this,"gus.find.point2d");
		findDouble2 = Outside.service(this,"gus.find.doublearray.dim2");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=3) throw new Exception("Wrong data number: "+o.length);
		
		Object data = o[0];
		JPanel panel = (JPanel) o[1];
		Object dimension = o[2];
		
		if(dimension==null) return findPoint.t(data);
		
		double[] p = (double[]) findDouble2.t(data);
		double[] q = (double[]) findDouble2.t(dimension);
		
		double x = p[0]*panel.getWidth()/q[0];
		double y = p[1]*panel.getHeight()/q[1];
		
		return findPoint.t(new double[]{x,y});
	}
}
