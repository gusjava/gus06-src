package gus06.entity.gus.swing.dialog.cust2.position;

import gus06.framework.*;
import javax.swing.JDialog;

public class EntityImpl implements Entity, V {

	public String creationDate() {return "20160605";}


	private Service toIntArray;

	public EntityImpl() throws Exception
	{toIntArray = Outside.service(this,"gus.convert.stringtointarray");}
	
	
	public void v(String key, Object obj) throws Exception
	{perform(key,(JDialog) obj);}
	
	
	private void perform(String info, JDialog dialog) throws Exception
	{
		int[] a = (int[]) toIntArray.t(info);
		if(a.length<4) throw new Exception("Invalid info for dialog bounds: "+info);
		
		dialog.setLocation(a[0],a[1]);
	}
}
