package gus06.manager.gus.gyem.m060.g.service.wrapper.empty;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import gus06.manager.gus.gyem.GyemSystem;
import gus06.framework.*;

public class Module extends GyemSystem implements G {


	public Object g() throws Exception
	{
		return new EmptyService();
	}


	private class EmptyService implements Service
	{
		public void run() {}
		public void e() throws Exception {}
		public boolean f(Object obj) throws Exception {return false;}
		public Object g() throws Exception {return null;}
		public double h(double value) throws Exception {return 0;}
		public Object i() throws Exception {return null;}
		public void p(Object obj) throws Exception {}
		public Object r(String key) throws Exception {return null;}
		public void addActionListener(ActionListener listener) {}
		public void removeActionListener(ActionListener listener) {}
		public List listeners() {return new ArrayList();}
		public Object t(Object obj) throws Exception {return null;}
		public void v(String key, Object obj) throws Exception {}
	}
}