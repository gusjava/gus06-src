package gus06.entity.gus.data.editor.renderedimage.editor1.action.rotate90;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151007";}
	
	public static final String DISPLAY = "IMG_rotation_90#Rotate 90";


	private Service perform;
	private Service buildAction;


	public EntityImpl() throws Exception
	{
		perform = Outside.service(this,"gus.awt.renderedimage.transform.rotate90");
		buildAction = Outside.service(this,"gus.swing.action.builder1");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		return buildAction.t(new Object[]{DISPLAY,new E1(obj)});
	}
	
	
	
	private class E1 implements E
	{
		private Object holder;
		
		public E1(Object holder)
		{this.holder = holder;}
		
		public void e() throws Exception
		{
			Object data = ((G)holder).g();
			data = perform.t(data);
			((P)holder).p(data);
		}
	}
}
