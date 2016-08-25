package gus06.entity.gus.swing.textcomp.autocomplete.gusscript.op;

import gus06.framework.*;
import javax.swing.text.JTextComponent;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20160504";}
	
	public static final String MESSAGE = "Please, choose operator:";
	public static final String TITLE = "Operator chooser";


	private Service findCaretWord;
	private Service replaceCaretWord;
	private Service dialog;
	private Service getOpMap;
	
	private List names;
	
	
	
	public EntityImpl() throws Exception
	{
		findCaretWord = Outside.service(this,"gus.swing.textcomp.caretword.find");
		replaceCaretWord = Outside.service(this,"gus.swing.textcomp.caretword.replace");
		dialog = Outside.service(this,"gus.input.choose.dialog");
		getOpMap = Outside.service(this,"gus.sys.expression1.apply.opmap");
		
		Map map = (Map) getOpMap.g();
		
		names = new ArrayList(map.keySet());
		Collections.sort(names);
	}
	
	
	public void p(Object obj) throws Exception
	{
		JTextComponent comp = (JTextComponent) obj;
		String word = (String) findCaretWord.t(comp);
		
		String found = searchOp(word.toLowerCase());
		if(found!=null) replaceCaretWord.v(found,comp);
	}
	
	
	
	
	
	private String searchOp(String query) throws Exception
	{
		List filtered = new ArrayList();
		for(int i=0;i<names.size();i++)
		{
			String name = (String) names.get(i);
			if(name.contains(query)) filtered.add(name);
		}
		
		if(filtered.isEmpty()) return null;
		return (String) dialog.t(new Object[]{MESSAGE,TITLE,filtered});
	}
}
