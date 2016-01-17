package gus06.entity.gus.appli.gusclient1.menu.languages;

import java.util.List;

import gus06.framework.*;

import javax.swing.ButtonGroup;
import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class EntityImpl implements Entity, I {

	public String creationDate() {return "20140718";}

	public static final String KEY1 = "language_language";
	public static final String KEY2 = "language_";


	private Service langManager;
	private Service langList;
	private Service localize;
	
	private JMenu menu;

	public EntityImpl() throws Exception
	{
		langList = Outside.service(this,"gus.ling.language.list");
		langManager = Outside.service(this,"gus.ling.language.manager");
		localize = Outside.service(this,"gus.ling.localize.manager");
		
		List l = (List) langList.g();
		String lang0 = (String) langManager.g();
		
		menu = new JMenu("Language");
		localize.v(KEY1,menu);
		
		ButtonGroup group = new ButtonGroup();
		
		for(int i=0;i<l.size();i++)
		{
			String lang = (String) l.get(i);
			boolean selected = lang.equals(lang0);
			
			JRadioButtonMenuItem1 item = new JRadioButtonMenuItem1(lang,selected);
			localize.v(KEY2+lang,item);
			
			group.add(item);
			menu.add(item);
		}
	}
	
	
	
	public Object i() throws Exception
	{return menu;}
	
	
	
	
	private void changeLang(String id)
	{
		try{langManager.p(id);}
		catch(Exception e)
		{Outside.err(this,"changeLang(String)",e);}
	}
	
	
	
	
	
	private class JRadioButtonMenuItem1 extends JRadioButtonMenuItem implements ChangeListener
	{
		private String lang;
		public JRadioButtonMenuItem1(String lang, boolean selected)
		{
			super(lang,selected);
			this.lang = lang;
			addChangeListener(this);
		}
		
		public void stateChanged(ChangeEvent e)
		{if(isSelected()) changeLang(lang);}
	}
}
