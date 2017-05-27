package gus06.entity.gus.appli.gusexplorer.config.manager;

import gus06.framework.*;
import java.util.List;
import java.util.ArrayList;

public class EntityImpl extends S1 implements Entity, R, G, V {

	public String creationDate() {return "20160419";}


	private Service namesPersister;
	private Service listPersister;
	private Service dataManager;
	
	private List names;



	public EntityImpl() throws Exception
	{
		namesPersister = Outside.service(this,"gus.app.persister1.data.list");
		listPersister = Outside.service(this,"gus.app.persister1.data.filelist");
		dataManager = Outside.service(this,"gus.appli.gusexplorer.data.manager");
		
		String keyNames = getClass().getName()+"_names";
		names = (List) namesPersister.r(keyNames);
		if(names==null) names = new ArrayList();
	}
	
	
	
	public Object g() throws Exception
	{return names;}
	
	
	
	
	
	public void v(String key, Object obj) throws Exception
	{
		if(key.equals("save")) {save((String) obj);return;}
		if(key.equals("load")) {load((String) obj);return;}
		if(key.equals("remove")) {remove((String) obj);return;}
		
		throw new Exception("Unknown key: "+key);
	}
	
	
	
	public Object r(String key) throws Exception
	{
		return nameToList(key);
	}
	
	
	
	private void save(String name) throws Exception
	{
		List list = (List) dataManager.g();
		
		String keyList = getClass().getName()+"_config_"+name;
		listPersister.v(keyList,list);
		
		names.remove(name);
		names.add(0,name);
		updateNames(name);
	}
	
	
	private void load(String name) throws Exception
	{
		List list = nameToList(name);
		dataManager.v("init",list);
	}
	
	
	private List nameToList(String name) throws Exception
	{
		if(!names.contains(name))
			throw new Exception("Config name not found: "+name);
		
		names.remove(name);
		names.add(0,name);
		updateNames(name);
		
		String keyList = getClass().getName()+"_config_"+name;
		return (List) listPersister.r(keyList);
	}
	
	
	private void remove(String name) throws Exception
	{
		if(!names.contains(name)) return;
		names.remove(name);
		updateNames(name);
	}
	
	
	
	
	private void updateNames(String name) throws Exception
	{
		String keyNames = getClass().getName()+"_names";
		namesPersister.v(keyNames,names);
		updated();
	}
	
	private void updated()
	{send(this,"updated()");}
}
