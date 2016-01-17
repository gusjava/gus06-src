package gus06.entity.gus.nnn.debug.init.errortosysout;

import java.io.File;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import gus06.framework.*;


public class EntityImpl implements Entity, ActionListener {

	public String creationDate() {return "20141010";}

	private SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
	private String now() {return sdf.format(new Date());}
	
	
	private List errors;

	public EntityImpl() throws Exception
	{
		errors = (List) Outside.resource(this,"errors");
		((S) errors).addActionListener(this);
	}
	
	
	
	public void actionPerformed(ActionEvent e)
	{printLastErr();}
	
	
	public void printLastErr()
	{
		try
		{
			Object[] o = (Object[]) errors.get(errors.size()-1);
			if(o.length!=4) throw new Exception("Wrong data number: "+o.length);
		
			Entity entity = (Entity) o[0];
			String id = (String) o[1];
			Exception exp = (Exception) o[2];
			Date date = (Date) o[3];
		
			String src = entity.getClass().getName()+"@"+id;
			String timeStamp = sdf.format(date);
		
			println("___________________");
			println("time:"+timeStamp);
			println("src:"+src);
			println("");
			exp.printStackTrace(System.out);
		}
		catch(Exception e)
		{Outside.err(this,"printLastErr()",e);}
	}
	
	
	private void println(String m)
	{System.out.println(m);}
}
