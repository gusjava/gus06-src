package gus06.entity.gus.swing.textcomp.perform3.transformtext;

import gus06.framework.*;
import javax.swing.text.JTextComponent;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20141105";}


	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		JTextComponent comp = (JTextComponent) o[0];
		T t = (T) o[1];
		
		if(hasSelection(comp))
			transformSelection(comp,t);
		else transformAll(comp,t);
	}
	
	
	
	private void transformAll(JTextComponent comp, T t) throws Exception
	{
		String s0 = comp.getText();
		String s1 = (String) t.t(s0);
		
		int p = comp.getCaretPosition();
		int l = s1.length();
		int p1 = Math.min(l,p);
		
		comp.setText(s1);
		comp.requestFocus();
		comp.setCaretPosition(p1);
	}
	
	
	private void transformSelection(JTextComponent comp, T t) throws Exception
	{
		String s0 = comp.getSelectedText();
		String s1 = (String) t.t(s0);
		
		int start = comp.getSelectionStart();
		int length = s1.length();
		
		comp.replaceSelection(s1);
		comp.requestFocus();
		comp.select(start,start+length);
	}
	
	
	private boolean hasSelection(JTextComponent comp)
	{
		String s = comp.getSelectedText();
		return s!=null && !s.equals("");
	}
}
