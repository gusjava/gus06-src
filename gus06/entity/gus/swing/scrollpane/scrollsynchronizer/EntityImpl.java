package gus06.entity.gus.swing.scrollpane.scrollsynchronizer;

import gus06.framework.*;

import javax.swing.BoundedRangeModel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class EntityImpl implements Entity, V, P {

	public String creationDate() {return "20150305";}


	private boolean vertical = true;
	private boolean horizontal = true;
	
	
	public void p(Object obj) throws Exception
	{
		JScrollPane[] scrolls = (JScrollPane[]) obj;
		if(scrolls.length<2) throw new Exception("not enough scroll for synchronizing: "+scrolls.length);
		
		if(vertical)
		{
			JScrollBar[] bars = new JScrollBar[scrolls.length];
			for(int i=0;i<bars.length;i++)
			bars[i] = scrolls[i].getVerticalScrollBar();
			new SynchScroll(bars);
		}
		if(horizontal)
		{
			JScrollBar[] bars = new JScrollBar[scrolls.length];
			for(int i=0;i<bars.length;i++)
			bars[i] = scrolls[i].getHorizontalScrollBar();
			new SynchScroll(bars);
		}
	}
	
	
	public void v(String key, Object obj) throws Exception
	{
		if(key.equals("vertical"))
		{vertical = Boolean.parseBoolean((String) obj);return;}
		
		if(key.equals("horizontal"))
		{horizontal = Boolean.parseBoolean((String) obj);return;}
		
		throw new Exception("Unknown key: "+key);
	}
	
	
	
	
	private class SynchScroll implements ChangeListener
	{
		private BoundedRangeModel[] models;
		
		public SynchScroll(JScrollBar[] bars)
		{
			models = new BoundedRangeModel[bars.length];
			for(int i=0;i<bars.length;i++)
			{
				models[i] = bars[i].getModel();
				models[i].addChangeListener(this);
			}
		}

		public void stateChanged(ChangeEvent e)
		{
			for(int i=0;i<models.length;i++)
			if(models[i].getMaximum()<=0)return;
			
			BoundedRangeModel modelSrc = (BoundedRangeModel)e.getSource();
			int value = modelSrc.getValue();
			
			for(int i=0;i<models.length;i++)
			models[i].setValue(value);
		}
	}
}
