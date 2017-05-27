package gus06.entity.gus.sys.expression1.apply.op._caret_word_repl;

import gus06.framework.*;
import javax.swing.text.JTextComponent;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170224";}

	
	private Service perform;
	
	public EntityImpl() throws Exception
	{perform = Outside.service(this,"gus.swing.textcomp.caret.word.replace");}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		
		if(obj instanceof JTextComponent) return new T1((JTextComponent) obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	
	private class T1 implements T
	{
		private JTextComponent comp;
		
		public T1(JTextComponent comp)
		{this.comp = comp;}
		
		public Object t(Object obj) throws Exception
		{return new E1(comp,(String) obj);}
	}
	
	
	private class E1 implements E
	{
		private JTextComponent comp;
		private String s;
		
		public E1(JTextComponent comp, String s)
		{
			this.comp = comp;
			this.s = s;
		}
		
		public void e() throws Exception
		{perform.v(s,comp);}
	}
}
