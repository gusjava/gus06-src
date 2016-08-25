package gus06.entity.gus.math.function.build.fromrule;

import gus06.framework.*;
import java.util.Map;
import java.util.HashMap;

public class EntityImpl implements Entity, R {

	public String creationDate() {return "20160808";}


	private Map map;
	
	public EntityImpl() throws Exception
	{
		map = new HashMap();
		
		put("abs",Outside.service(this,"gus.math.function.h.abs"));
		put("cube",Outside.service(this,"gus.math.function.h.cube"));
		put("cbrt",Outside.service(this,"gus.math.function.h.cuberoot"));
		put("decr",Outside.service(this,"gus.math.function.h.decrement"));
		put("double",Outside.service(this,"gus.math.function.h.double1"));
		put("half",Outside.service(this,"gus.math.function.h.half"));
		put("incr",Outside.service(this,"gus.math.function.h.increment"));
		put("inv",Outside.service(this,"gus.math.function.h.inverse"));
		put("opp",Outside.service(this,"gus.math.function.h.opp"));
		put("sigmoid",Outside.service(this,"gus.math.function.h.sigmoid"));
		put("square",Outside.service(this,"gus.math.function.h.square"));
		put("sqrt",Outside.service(this,"gus.math.function.h.squareroot"));
		put("triple",Outside.service(this,"gus.math.function.h.triple"));
		put("cos",Outside.service(this,"gus.math.function.trigo.cosine"));
		put("sin",Outside.service(this,"gus.math.function.trigo.sine"));
		put("tan",Outside.service(this,"gus.math.function.trigo.tangent"));
		put("hcos",Outside.service(this,"gus.math.function.hyperbolic.cosine"));
		put("hsin",Outside.service(this,"gus.math.function.hyperbolic.sine"));
		put("htan",Outside.service(this,"gus.math.function.hyperbolic.tangent"));
	}
	
	
	private void put(String key, H h)
	{map.put(key,new H_Wrap(h));}
	
	
	public Object r(String key) throws Exception
	{
		if(map.containsKey(key)) 	return map.get(key);
		if(key.matches("x[0-9]+")) 	return new H_x(key.substring(1));
		return null;
	}
	
	
	
	private class H_Wrap implements H
	{
		private H h;
		public H_Wrap(H h) {this.h = h;}
		
		public double h(double value) throws Exception
		{return h.h(value);}
	}
	
	
	private class H_x implements H
	{
		private int times;
		public H_x(String s)
		{times = Integer.parseInt(s);}
		
		public double h(double value) throws Exception
		{return times*value;}
	}
}
