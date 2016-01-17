package gus06.entity.gus.nnn.clipboard.access.string.debug;

import gus06.framework.*;
import java.awt.datatransfer.*;
import java.awt.Toolkit;
import javax.swing.JTextArea;

public class EntityImpl implements Entity, P, G {

	public String creationDate() {return "20150305";}
	
	
	public Object g() throws Exception
	{
		try{return c().getData(DataFlavor.stringFlavor);}
		catch(Exception e) {return null;}
	}
	
	
	public void p(Object obj) throws Exception
	{
		copy((String) obj);
		test((String) obj);
	}
	
	
	
	private Clipboard c()
	{return Toolkit.getDefaultToolkit().getSystemClipboard();}
	
	
	
	private void copy(String s)
	{
		StringSelection t = new StringSelection(s);
		c().setContents(t,t);
	}
	
	
	
	
	
	
	
	private JTextArea area = new JTextArea();
	
	private void test(String s)
	{
		if(!corrupted(s)) return;
		
		int length = s.length();
		System.out.println("CLIPBOARD PASTE CORRUTION HAS BEEN DETECTED !!!");
		System.out.println("String length: "+length);
		
		if(length<=5) System.out.println("String: "+s);
		else
		{
			System.out.println("String start: "+s.substring(0,5));
			System.out.println("String end: "+s.substring(s.length()-5));
		}
		
		System.out.println();
		for(int i=0;i<length;i++)
		{
			String c = ""+s.charAt(i);
			System.out.print(c);
			
			copy(c);
			if(corrupted(c)) System.out.print("###"+codePoint(c)+"###");
		}
		
		copy(s);
	}
	
	private boolean corrupted(String s)
	{
		area.setText("");
		area.paste();
		return !s.equals(area.getText());
	}
	
	private String codePoint(String s)
	{
		int codePoint = s.codePointAt(0);
		return "\\u"+hexa(codePoint);
	}
	
	private String hexa(int n)
	{
		String v = ""+Integer.toHexString(n);
		while(v.length()<4) v="0"+v;
		return v;
	}
}
