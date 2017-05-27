package gus06.entity.gus.data.perform.inv;

import gus06.framework.*;
import java.util.Map;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JSplitPane;
import java.awt.image.RenderedImage;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151117";}


	private Service invFilter;
	private Service invFunction;
	private Service invMap;
	private Service invJPanel;
	private Service invJTabbedPane;
	private Service invJSplitPane;
	private Service invImage;
	
	public EntityImpl() throws Exception
	{
		invFilter = Outside.service(this,"gus.feature.op.filter.inv");
		invFunction = Outside.service(this,"gus.feature.op.function.inv");
		invMap = Outside.service(this,"gus.map.inv.map");
		invJPanel = Outside.service(this,"gus.swing.panel.inv.grid");
		invJTabbedPane = Outside.service(this,"gus.swing.tabbedpane.inv");
		invJSplitPane = Outside.service(this,"gus.swing.splitpane.inv");
		invImage = Outside.service(this,"gus.awt.renderedimage.transform.flip.diagonal");
	}

	
	
	public Object t(Object obj) throws Exception
	{
		if(obj instanceof Boolean) return inv((Boolean) obj);
		if(obj instanceof Double) return inv((Double) obj);
		if(obj instanceof Integer) return inv((Integer) obj);
		if(obj instanceof Float) return inv((Float) obj);
		
		if(obj instanceof F) return invFilter.t(obj);
		if(obj instanceof H) return invFunction.t(obj);
		if(obj instanceof Map) return invMap.t(obj);
		if(obj instanceof JPanel) return invJPanel.t(obj);
		if(obj instanceof JTabbedPane) return invJTabbedPane.t(obj);
		if(obj instanceof JSplitPane) return invJSplitPane.t(obj);
		if(obj instanceof RenderedImage) return invImage.t(obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	
	private Boolean inv(Boolean b)
	{return new Boolean(!b.booleanValue());}
	
	private Double inv(Double b)
	{return new Double(1.0/b.doubleValue());}
	
	private Double inv(Integer b)
	{return new Double(1.0/b.doubleValue());}
	
	private Float inv(Float b)
	{return new Float(1.0/b.floatValue());}
}
