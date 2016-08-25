package gus06.entity.gus.feature.wrap.double1.gph;

import gus06.framework.*;

public class EntityImpl implements Entity, T, G {

	public String creationDate() {return "20150708";}

	
	
	public Object t(Object obj) throws Exception
	{return new Wrap((Double) obj);}
	
	public Object g() throws Exception
	{return new Wrap(new Double(0));}
	
	
	
	
	private class Wrap implements G, H, P
	{
		private Double data;
		public Wrap(Double data) {this.data = data;}
		
		public Object g() throws Exception
		{return data;}
		
		public void p(Object obj) throws Exception
		{this.data = (Double) obj;}
		
		public double h(double v) throws Exception
		{return data.doubleValue();}
	}
}
