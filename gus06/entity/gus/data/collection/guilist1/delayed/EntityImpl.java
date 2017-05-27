package gus06.entity.gus.data.collection.guilist1.delayed;

import gus06.framework.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;

public class EntityImpl implements Entity, I, P, G, S {

	public String creationDate() {return "20170507";}


	private Service gui;
	private Service buildSupport;
	
	private S support;


	public EntityImpl() throws Exception
	{
		gui = Outside.service(this,"*gus.data.collection.guilist1");
		buildSupport = Outside.service(this,"gus.support.build.delaysupport");
		support = (S) buildSupport.t(gui);
	}
	
	
	
	public Object g() throws Exception
	{return gui.g();}
	
	public Object i() throws Exception
	{return gui.i();}
	
	public void p(Object obj) throws Exception
	{gui.p(obj);}



	public void addActionListener(ActionListener l)
	{support.addActionListener(l);}

	public void removeActionListener(ActionListener l)
	{support.removeActionListener(l);}
	
	public List listeners()
	{return support.listeners();}
}
