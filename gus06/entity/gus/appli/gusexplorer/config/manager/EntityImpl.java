package gus06.entity.gus.appli.gusexplorer.config.manager;

import gus06.framework.*;
import java.util.List;
import java.util.ArrayList;

public class EntityImpl extends S1 implements Entity, E, P, G, V, R {

	public String creationDate() {return "20160419";}


	private Service namePersister;
	private Service namesPersister;
	private Service listPersister;
	
	
	private String name;
	private List names;
	private List list;


	public EntityImpl() throws Exception
	{
		namePersister = Outside.service(this,"gus.app.persister1");
		namesPersister = Outside.service(this,"gus.app.persister1.data.list");
		listPersister = Outside.service(this,"gus.app.persister1.data.filelist");
		
		loadName();
		loadNames();
		loadList();
	}
	
	
	
	private String pKeyName()
	{return getClass().getName()+"_name";}
	
	private String pKeyNames()
	{return getClass().getName()+"_names";}
	
	private String pKeyList()
	{return getClass().getName()+"_config_"+name;}
	
	
	
	
	private void saveName() throws Exception
	{namePersister.v(pKeyName(),name);}
	
	private void saveNames() throws Exception
	{namesPersister.v(pKeyNames(),names);}
	
	private void saveList() throws Exception
	{listPersister.v(pKeyList(),list);}
	
	
	
	
	private void loadName() throws Exception
	{
		name = (String) namePersister.r(pKeyName());
		if(name==null) name = "default";
	}
	
	private void loadNames() throws Exception
	{
		names = (List) namesPersister.r(pKeyNames());
		if(names==null) names = new ArrayList();
		if(!names.contains(name)) names.add(name);
	}
	
	private void loadList() throws Exception
	{list = (List) listPersister.r(pKeyList());}
	
	
	
	
	
	
	public void e() throws Exception
	{saveList();}
	
	
	public Object g() throws Exception
	{return list;}
	
	
	public void p(Object obj) throws Exception
	{load((String) obj);}
	
	
	
	public Object r(String key) throws Exception
	{
		if(key.equals("name")) return name;
		if(key.equals("names")) return names;
		if(key.equals("list")) return list;
		
		if(key.equals("keys")) return new String[]{"name","names","list"};
		throw new Exception("Unknown key: "+key);
	}
	
	
	public void v(String key, Object obj) throws Exception
	{
		if(key.equals("save")) {save((String) obj);return;}
		if(key.equals("load")) {load((String) obj);return;}
		
		throw new Exception("Unknown key: "+key);
	}
	
	
	
	
	
	private void save(String name) throws Exception
	{
		//System.out.println("save config:"+name);
		this.name = name;
		names.remove(name);
		names.add(0,name);
		
		saveName();
		saveNames();
		saveList();
	}
	
	private void load(String name) throws Exception
	{
		//System.out.println("load config:"+name);
		this.name = name;
		names.remove(name);
		names.add(0,name);
		
		saveName();
		saveNames();
		loadList();
		modified();
	}
	
	
	private void modified()
	{send(this,"modified()");}
}
