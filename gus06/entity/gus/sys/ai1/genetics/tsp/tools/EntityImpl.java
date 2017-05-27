package gus06.entity.gus.sys.ai1.genetics.tsp.tools;

import gus06.framework.*;

public class EntityImpl implements Entity, R {

	public String creationDate() {return "20170428";}


	private Service crossover_ox;


	public EntityImpl() throws Exception
	{
		crossover_ox = Outside.service(this,"gus.sys.ai1.genetics.tsp.crossover.ox");
	}
	
	
	public Object r(String key) throws Exception
	{
		if(key.equals("crossover_ox")) return crossover_ox;
		if(key.equals("keys")) return new String[]{"crossover_ox"};
		
		throw new Exception("Unknown key: "+key);
	}
}
