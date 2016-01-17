package gus06.entity.gus.sys.script1.tool.execute.content.part2;

import gus06.framework.*;
import java.util.Map;
import java.util.List;

public class EntityImpl implements Entity, P {
	
	public static final String ELSE = "else";

	public String creationDate() {return "20150902";}



	private Service execute;
	private Service getContent;
	private Service getName;

	public EntityImpl() throws Exception
	{
		execute = Outside.service(this,"gus.sys.script1.tool.execute.tag");
		getContent = Outside.service(this,"gus.sys.script1.access.tag.content1");
		getName = Outside.service(this,"gus.sys.script1.access.tag.name0");
	}
	
	
	
	
	public void p(Object obj) throws Exception
	{
		Map[] o = (Map[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Map tag = o[0];
		Map context = o[1];
		
		List content = (List) getContent.t(tag);
		boolean elseFound = false;
		
		for(int i=0;i<content.size();i++) 
		{
			Map child = (Map) content.get(i);
			String name = (String) getName.t(child);
			if(name!=null && name.equals(ELSE)) elseFound = true;
			
			if(elseFound) execute.p(new Map[]{child,context});
		}
	}
}
