package gus06.entity.gus.sys.play1.manager;

import gus06.framework.*;

public class EntityImpl extends S1 implements Entity, P, R, V {

	public String creationDate() {return "20160612";}


	public EntityImpl() throws Exception
	{
	}
	
	
	public void p(Object obj) throws Exception
	{
		String s = (String) obj;
		
		if(s.equals("show")) {show();return;}
		if(s.equals("hide")) {hide();return;}
	}
	
	
	public Object r(String key) throws Exception
	{
		return null;
	}
	
	
	public void v(String key, Object obj) throws Exception
	{
		
	}
	
	
	private void show() throws Exception
	{
		
	}
	
	private void hide() throws Exception
	{
		
	}
}