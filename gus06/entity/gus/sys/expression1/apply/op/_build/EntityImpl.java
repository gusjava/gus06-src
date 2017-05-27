package gus06.entity.gus.sys.expression1.apply.op._build;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160612";}


	private Service play1;
	private Service carto1;
	private Service points1;
	private Service drawing1;
	private Service mapEditor;
	private Service fileEditor;
	private Service listChooser;
	private Service tsp_tools1;
	
	
	public EntityImpl() throws Exception
	{
		play1 = Outside.service(this,"gus.sys.play1.manager");
		carto1 = Outside.service(this,"factory#gus.sys.carto1.panelholder");
		points1 = Outside.service(this,"factory#gus.swing.panel.screen.points");
		drawing1 = Outside.service(this,"factory#gus.sys.drawingpanel1.screen");
		mapEditor = Outside.service(this,"factory#gus.sys.mapediting1.gui.main");
		fileEditor = Outside.service(this,"factory#gus.file.editor.main");
		listChooser = Outside.service(this,"factory#gus.sys.listchooser1.gui.main");
		tsp_tools1 = Outside.service(this,"gus.sys.ai1.genetics.tsp.tools");
	}

	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		if(obj instanceof String) return build((String) obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	private Object build(String key) throws Exception
	{
		if(key.equals("play1")) return play1;
		if(key.equals("carto1")) return carto1.g();
		if(key.equals("points1")) return points1.g();
		if(key.equals("drawing1")) return drawing1.g();
		if(key.equals("mapeditor")) return mapEditor.g();
		if(key.equals("fileeditor")) return fileEditor.g();
		if(key.equals("listchooser")) return listChooser.g();
		if(key.equals("tsp_tools1")) return tsp_tools1;
		
		if(key.equals("keys")) return new String[]{
			"play1","carto1","points1","drawing1",
			"mapeditor","fileeditor","listchooser","tsp_tools1"};
		
		throw new Exception("Unknown key: "+key);
	}
}
