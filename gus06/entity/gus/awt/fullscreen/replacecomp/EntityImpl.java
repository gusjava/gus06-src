package gus06.entity.gus.awt.fullscreen.replacecomp;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.LayoutManager;
import javax.swing.JComponent;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JViewport;
import gus06.framework.*;

public class EntityImpl implements Entity, P, E, T {

	public String creationDate() {return "20151015";}


	private E holder;


	public void p(Object obj) throws Exception
	{holder = buildCompHolder(obj);}
	
	
	public Object t(Object obj) throws Exception
	{return buildCompHolder(obj);}
	
	
	
	public void e() throws Exception
	{
		if(holder==null) throw new Exception("holder is null");
		holder.e();
	}
	
	
	
	
	private E buildCompHolder(Object obj) throws Exception
	{
		if(obj==null) throw new Exception("Component is null");
		if(!(obj instanceof JComponent)) throw new Exception("Invalid data type: "+obj.getClass().getName());
		
		JComponent comp = (JComponent) obj;
		Container parent = comp.getParent();
		
		if(parent==null) return new E(){public void e() throws Exception {}};
		
		if(parent instanceof JPanel)
		{
			JPanel p = (JPanel)parent;
			LayoutManager layout = p.getLayout();
			
			if(layout instanceof BorderLayout)
				return new Holder_PanelBorderLayout(p,comp);
			return new Holder_PanelGridLayout(p,comp);
		}
		if(parent instanceof JTabbedPane)
		{
			JTabbedPane p = (JTabbedPane)parent;
			return new Holder_TabbedPane(p,comp);
		}
		if(parent instanceof JSplitPane)
		{
			JSplitPane p = (JSplitPane)parent;
			return new Holder_SplitPane(p);
		}
		if(parent instanceof JViewport)
		{
			JViewport p = (JViewport)parent;
			return new Holder_Viewport(p,comp);
		}
		if(parent instanceof JLayeredPane)
		{
			JLayeredPane p = (JLayeredPane)parent;
			return new Holder_LayeredPane(p,comp);
		}
		throw new Exception("Parent type not supported: "+parent.getClass().getName());
	}
}
