package gus06.entity.gus.sys.filetool.main.gui;

import gus06.framework.*;
import javax.swing.JComponent;
import java.util.Map;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EntityImpl implements Entity, I, P {

	public String creationDate() {return "20141229";}


	private Service shift;
	private Service mapToGui;
	
	private Map map;



	public EntityImpl() throws Exception
	{
		shift = Outside.service(this,"*gus.swing.panel.shiftpanel");
		mapToGui = Outside.service(this,"gus.sys.filetool.main.maptogui");
	}
	
	
	public Object i() throws Exception
	{return shift.i();}
	
	
	
	public void p(Object obj) throws Exception
	{
		map = (Map) obj;
		shift.p(comp());
	}
	
	
	private JComponent comp() throws Exception
	{
		if(map==null) return null;
		return (JComponent) mapToGui.t(map);
	}
}
