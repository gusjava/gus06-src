package gus06.entity.gus.swing.textcomp.autocomplete.entity.addimport;

import gus06.framework.*;
import java.util.*;
import javax.swing.text.JTextComponent;


public class EntityImpl implements Entity, V, P {

	public String creationDate() {return "20140915";}
	
	
	private Service extractStructure;
	private Service extractImports;
	private Service searchClass;
	private Service findCaretWord;
	private Service replaceCaretWord;
	
	private String fullName;
	private String className;
	private String packageName;
	


	public EntityImpl() throws Exception
	{
		extractStructure = Outside.service(this,"gus.java.srccode.extract.entity.structure1");
		extractImports = Outside.service(this,"gus.java.srccode.extract.imports1");
		searchClass = Outside.service(this,"gus.java.searchclass.fromrt.preferred");
		findCaretWord = Outside.service(this,"gus.swing.textcomp.find.caretword");
		replaceCaretWord = Outside.service(this,"gus.swing.textcomp.find.caretword.replace");
	}
	
	
	
	
	public void p(Object obj) throws Exception
	{
		String query = (String) findCaretWord.t(obj);
		if(query==null) return;
		
		searchClass(query);
		if(fullName==null) return;
		
		importToComp((JTextComponent) obj);
		replaceCaretWord.v(className,obj);
	}
	
	
	
	
	public void v(String key, Object obj) throws Exception
	{
		searchClass(key);
		if(fullName==null) return;
		
		importToComp((JTextComponent) obj);
	}
	
	
	
	
	
	
	private void searchClass(String query) throws Exception
	{
		fullName = null;
		className = null;
		packageName = null;
		
		fullName = (String) searchClass.t(query);
		if(fullName==null) return;
		
		String[] n = fullName.split("\\.");
		className = n[n.length-1];
		packageName = fullName.substring(0,fullName.length()-className.length()-1);
	}
	
	
	
	
	
	
	private void importToComp(JTextComponent comp) throws Exception
	{
		String text = comp.getText();
		
		if(hasImport(text)) return;
		
		int pos = findPosForNextImport(text);
		String insert = "import "+fullName+";";
		
		int caretPos = comp.getCaretPosition();
		if(caretPos>pos) caretPos += insert.length()+1;
		
		String[] lines = text.split("\n");
		StringBuffer b = new StringBuffer();
		
		for(int i=0;i<lines.length;i++)
		{
			String line = lines[i];
			b.append(line+"\n");
			if(i==pos) b.append(insert+"\n");
		}
		
		comp.setText(b.toString());
		comp.setCaretPosition(caretPos);
	}
	
	
	
	
	
	private boolean hasImport(String src) throws Exception
	{
		if(packageName.equals("java.lang")) return true;
		
		Set imports = (Set) extractImports.t(src);
		Iterator it = imports.iterator();
		while(it.hasNext())
		{
			String import_ = (String) it.next();
			if(import_.endsWith("."+className)) return true;
			if(import_.equals(packageName+".*")) return true;
		}
		return false;
	}
	
	
	
	
	private int findPosForNextImport(String src) throws Exception
	{
		Map struct = (Map) extractStructure.t(src);
		if(!struct.containsKey("import"))
			throw new Exception("Import data not found inside structure");
		
		int[] n = (int[]) struct.get("import");
		return n[1];
	}
	
	
	private String findPackage(String fullName)
	{
		String[] n = fullName.split("\\.");
		String last = n[n.length-1];
		return fullName.substring(0,fullName.length()-last.length()-1);
	}
	
	
	private String findClassName(String fullName)
	{
		String[] n = fullName.split("\\.");
		return n[n.length-1];
	}
}
