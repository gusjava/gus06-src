package gus06.entity.gus.data.perform.reverse;

import gus06.framework.*;
import java.util.List;
import java.util.Collections;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import java.awt.image.RenderedImage;
import javax.swing.JTabbedPane;
import javax.swing.text.JTextComponent;
import java.util.Map;

public class EntityImpl implements Entity, P, T {

	public String creationDate() {return "20151114";}


	private Service performArray;
	private Service performDoubleArray;
	private Service performIntArray;
	private Service performLongArray;
	private Service performFloatArray;
	private Service performByteArray;
	private Service performBooleanArray;
	private Service performJPanel;
	private Service performJSplitPane;
	private Service performJTabbedPane;
	private Service performJTextComp;
	private Service performImage;
	private Service performMap;
	
	
	public EntityImpl() throws Exception
	{
		performArray = Outside.service(this,"gus.array.objectarray.reverse");
		performDoubleArray = Outside.service(this,"gus.array.doublearray.reverse");
		performIntArray = Outside.service(this,"gus.array.intarray.reverse");
		performLongArray = Outside.service(this,"gus.array.longarray.reverse");
		performFloatArray = Outside.service(this,"gus.array.floatarray.reverse");
		performByteArray = Outside.service(this,"gus.array.bytearray.reverse");
		performBooleanArray = Outside.service(this,"gus.array.booleanarray.reverse");
		performJPanel = Outside.service(this,"gus.swing.panel.reverse");
		performJSplitPane = Outside.service(this,"gus.swing.splitpane.reverse");
		performJTabbedPane = Outside.service(this,"gus.swing.tabbedpane.reverse");
		performJTextComp = Outside.service(this,"gus.swing.textcomp.reverse");
		performImage = Outside.service(this,"gus.awt.renderedimage.transform.flip.vertical");
		performMap = Outside.service(this,"gus.map.reverse.map");
	}

	
	
	public void p(Object obj) throws Exception
	{
		if(obj instanceof StringBuffer) {handle((StringBuffer) obj);return;}
		if(obj instanceof List) {handle((List) obj);return;}
		
		if(obj instanceof Object[]) {performArray.p(obj);return;}
		if(obj instanceof double[]) {performDoubleArray.p(obj);return;}
		if(obj instanceof int[]) {performIntArray.p(obj);return;}
		if(obj instanceof long[]) {performLongArray.p(obj);return;}
		if(obj instanceof float[]) {performFloatArray.p(obj);return;}
		if(obj instanceof byte[]) {performByteArray.p(obj);return;}
		if(obj instanceof boolean[]) {performBooleanArray.p(obj);return;}
		if(obj instanceof Map) {performMap.p(obj);return;}
		if(obj instanceof JPanel) {performJPanel.p(obj);return;}
		if(obj instanceof JSplitPane) {performJSplitPane.p(obj);return;}
		if(obj instanceof JTabbedPane) {performJTabbedPane.p(obj);return;}
		if(obj instanceof JTextComponent) {performJTextComp.p(obj);return;}
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	
	public Object t(Object obj) throws Exception
	{
		if(obj instanceof String) return reverse((String) obj);
		if(obj instanceof List) return reverse((List) obj);
		
		if(obj instanceof Object[]) return performArray.t(obj);
		if(obj instanceof double[]) return performDoubleArray.t(obj);
		if(obj instanceof int[]) return performIntArray.t(obj);
		if(obj instanceof long[]) return performLongArray.t(obj);
		if(obj instanceof float[]) return performFloatArray.t(obj);
		if(obj instanceof byte[]) return performByteArray.t(obj);
		if(obj instanceof boolean[]) return performBooleanArray.t(obj);
		if(obj instanceof Map) return performMap.t(obj);
		if(obj instanceof JPanel) return performJPanel.t(obj);
		if(obj instanceof JSplitPane) return performJSplitPane.t(obj);
		if(obj instanceof JTabbedPane) return performJTabbedPane.t(obj);
		if(obj instanceof JTextComponent) return performJTextComp.t(obj);
		
		if(obj instanceof RenderedImage) return performImage.t(obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	
	private void handle(StringBuffer b)
	{b.reverse();}
	
	private void handle(List l)
	{Collections.reverse(l);}
	
	
	
	
	private String reverse(String s)
	{
		StringBuffer b = new StringBuffer(s);
		return b.reverse().toString();
	}
	
	
	private List reverse(List list)
	{
		List list1 = new ArrayList(list);
		Collections.reverse(list1);
		return list1;
	}
}
