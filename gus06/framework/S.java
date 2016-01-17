package gus06.framework;

import java.awt.event.ActionListener;
import java.util.List;


public interface S {

	public void addActionListener(ActionListener listener);
	public void removeActionListener(ActionListener listener);
	public List listeners();
}