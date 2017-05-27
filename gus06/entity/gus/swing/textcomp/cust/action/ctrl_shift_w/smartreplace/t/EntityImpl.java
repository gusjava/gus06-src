package gus06.entity.gus.swing.textcomp.cust.action.ctrl_shift_w.smartreplace.t;

import gus06.framework.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160430";}

	private Service byRegex;
	private Service byPosition;

	public EntityImpl() throws Exception
	{
		byRegex = Outside.service(this,"gus.sys.quickreplace.t.byregex.smart");
		byPosition = Outside.service(this,"gus.sys.quickreplace.t.byposition.smart");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		String[] o1 = (String[]) o[0];
		int[] o2 = (int[]) o[1];
		
		String textMem = o1[0];
		String selected = o1[1];
		String replacement = o1[2];
		
		if(selected==null || selected.equals(""))
			return byPosition.t(obj);
		return byRegex.t(obj);
	}
}
