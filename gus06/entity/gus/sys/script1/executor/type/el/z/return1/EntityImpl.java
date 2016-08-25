package gus06.entity.gus.sys.script1.executor.type.el.z.return1;

import gus06.framework.*;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;

public class EntityImpl implements Entity, T {
	
	public String creationDate() {return "20160415";}
	
	public static final String C_EXECUTION = "execution";
	public static final String X_RETURN = "return";
	
	
	private Service wrapping;
	
	public EntityImpl() throws Exception
	{wrapping = Outside.service(this,"gus.sys.script1.tool.execute.wrapping1");}
	
	
	
	public Object t(Object obj) throws Exception
	{return new Executor((Map) obj);}
	
	
	
	private class Executor implements P
	{
		private Map tag;
		public Executor(Map tag) {this.tag = tag;}
		
		public void p(Object obj) throws Exception
		{
			Map context = (Map) obj;
			wrapping.p(new Object[]{context,tag,new Wrap()});
			
		}
	}
	
	
	private class Wrap implements P
	{
		public void p(Object obj) throws Exception
		{
			Object[] o = (Object[]) obj;
			if(o.length!=5) throw new Exception("Wrong data number: "+o.length);
			
			Map context = (Map) o[0];
			Map tag = (Map) o[1];
			Map pool1 = (Map) o[2];
			Object main = o[3];
			Map data = (Map) o[4];
			
			Set returnSet = new HashSet();
			returnSet.add(main);
	 		
			Map execution = (Map) context.get(C_EXECUTION);
			execution.put(X_RETURN,returnSet);
		}
	}
}
