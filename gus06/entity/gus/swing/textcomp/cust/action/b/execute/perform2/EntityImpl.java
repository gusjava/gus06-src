package gus06.entity.gus.swing.textcomp.cust.action.b.execute.perform2;

import gus06.framework.*;
import javax.swing.JTextArea;
import java.awt.Toolkit;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20150527";}


	private Service openFile;
	private Service openURL;
	private Service openURL2;
	private Service browse;
	private Service replaceTag;


	public EntityImpl() throws Exception
	{
		openFile = Outside.service(this,"gus.swing.textcomp.cust.action.b.execute.perform2.openfile");
		openURL = Outside.service(this,"gus.swing.textcomp.cust.action.b.execute.perform2.openurl");
		openURL2 = Outside.service(this,"gus.swing.textcomp.cust.action.b.execute.perform2.openurl2");
		browse = Outside.service(this,"gus.swing.textcomp.cust.action.b.execute.perform2.browse");
		replaceTag = Outside.service(this,"gus.string.transform.replace.tag.now");
	}
	
	
	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		JTextArea comp = (JTextArea) o[0];
		String line = (String) o[1];
		
		line = line.trim();
		if(line.equals("") || line.equals(".")) return;
		line = (String) replaceTag.t(line);
		
		if(browse(comp,line)) return;
		if(cmd(line)) return;
		if(url(line)) return;
		
		if(beep(line)) return;
		if(openFile(line)) return;
		if(openURL(line)) return;
	}
	
	
	
	private boolean browse(JTextArea comp, String line) throws Exception
	{
		if(!line.startsWith("->")) return false;
		return browse.f(new Object[]{comp,line.substring(2)});
	}
	
	private boolean cmd(String line) throws Exception
	{
		if(!line.startsWith("<>")) return false;
		Runtime.getRuntime().exec(line.substring(2));
		return true;
	}
	
	private boolean url(String line) throws Exception
	{
		if(!line.startsWith("u>")) return false;
		return openURL2(line.substring(2));
	}
	
	private boolean beep(String line)
	{
		if(!line.equals("beep")) return false;
		Toolkit.getDefaultToolkit().beep();
		return true;
	}
	
	
	
	private boolean openFile(String line) throws Exception
	{return openFile.f(line);}
	
	private boolean openURL(String line) throws Exception
	{return openURL.f(line);}
	
	private boolean openURL2(String line) throws Exception
	{return openURL2.f(line);}
}
