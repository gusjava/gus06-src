package gus06.entity.gus.security.askinfo.password1;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.LayoutManager;


public class FormLayout implements LayoutManager {
	
	protected int m_divider = -1;
	protected int m_hGap = 10;
	protected int m_vGap = 5;
	
	
	public FormLayout() {}
	public FormLayout(int hGap, int vGap) {
		m_hGap = hGap;
		m_vGap = vGap;
	}
	
	public void addLayoutComponent(String name, Component comp) {}
	public void removeLayoutComponent(Component comp) {}
	
	
	
	public Dimension preferredLayoutSize(Container parent) {
		int divider = getDivider(parent);
		int w = 0;
		int h = 0;
		for (int k=1 ; k<parent.getComponentCount(); k+=2) {
			Component comp = parent.getComponent(k);
			Dimension d = comp.getPreferredSize();
			w = Math.max(w, d.width);
			h += d.height + m_vGap;
		}
		h -= m_vGap;
		Insets insets = parent.getInsets();
		return new Dimension(divider+w+insets.left+insets.right,
				h+insets.top+insets.bottom);
	}
	
	

//	public Dimension maximumLayoutSize(Container parent) {
//		return preferredLayoutSize(parent);
//	}



	public Dimension minimumLayoutSize(Container parent) {
		return new Dimension(0,0);
	}
	
	
	
	
	public void layoutContainer(Container parent) {
		int divider = getDivider(parent);
		Insets insets = parent.getInsets();
		int w = parent.getWidth() - insets.left
		- insets.right - divider;
		int x = insets.left;
		int y = insets.top;
		for (int k=1 ; k<parent.getComponentCount(); k+=2)
		{
			Component comp1 = parent.getComponent(k-1);
			Component comp2 = parent.getComponent(k);
			Dimension d = comp2.getPreferredSize();
			comp1.setBounds(x, y, divider-m_hGap, d.height);
			comp2.setBounds(x+divider, y, w, d.height);
			y += d.height + m_vGap;
		}
	}
	
	
	
	
	public int getHGap() {return m_hGap;}
	public int getVGap() {return m_vGap;}
	
	
	
	
	public void setDivider(int divider) {
		if(divider>0)m_divider = divider;
	}
	
	
	public int getDivider() {return m_divider;}
	
	
	protected int getDivider(Container parent) {
		if (m_divider > 0)
			return m_divider;
		int divider = 0;
		for (int k=0 ; k<parent.getComponentCount(); k+=2) {
			Component comp = parent.getComponent(k);
			Dimension d = comp.getPreferredSize();
			divider = Math.max(divider, d.width);
		}
		divider += m_hGap;
		return divider;
	}
	
	
	
	public String toString() {
		return getClass().getName() + "[hgap=" + m_hGap + ",vgap="
		+ m_vGap + ",divider=" + m_divider + "]";
	}
	
}
