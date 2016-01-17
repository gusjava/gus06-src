package gus06.entity.gus.swing.textarea.buildpanel1.custcomp;

import gus06.framework.*;
import javax.swing.JTextArea;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20150425";}


	private Service execute; //b
	private Service removeLine; //d
	private Service doubleLine; //e
	private Service search; //f
	private Service regexp; //g
	private Service tool; //h
	private Service wrapLine; //p
	private Service undo; //yz
	
	private Service enlarge;
	
	private Service nextHigh;
	private Service previousHigh;
	
	private Service increaseFont;
	private Service decreaseFont;
	


	public EntityImpl() throws Exception
	{
		execute = Outside.service(this,"gus.swing.textcomp.cust.action.b.execute");
		removeLine = Outside.service(this,"gus.swing.textcomp.cust.action.d.removeline");
		doubleLine = Outside.service(this,"gus.swing.textcomp.cust.action.e.doubleline");
		search = Outside.service(this,"gus.swing.textcomp.cust.action.f.search");
		regexp = Outside.service(this,"gus.swing.textcomp.cust.action.g.regexp");
		tool = Outside.service(this,"gus.swing.textcomp.cust.action.h.tool");
		wrapLine = Outside.service(this,"gus.swing.textcomp.cust.action.p.wrapline");
		undo = Outside.service(this,"gus.swing.textcomp.cust.action.zy.undoredo");
		
		enlarge = Outside.service(this,"gus.swing.textcomp.cust.action.space.enlargeselection");
		
		nextHigh = Outside.service(this,"gus.swing.textcomp.cust.action.right.gotohigh.next");
		previousHigh = Outside.service(this,"gus.swing.textcomp.cust.action.left.gotohigh.previous");
		
		increaseFont = Outside.service(this,"gus.swing.textcomp.cust.action.plus.increasefontsize");
		decreaseFont = Outside.service(this,"gus.swing.textcomp.cust.action.minus.decreasefontsize");
	}
	
	
	
	public void p(Object obj) throws Exception
	{
		JTextArea comp = (JTextArea) obj;
		
		execute.p(comp);
		removeLine.p(comp);
		doubleLine.p(comp);
		search.p(comp);
		regexp.p(comp);
		tool.p(comp);
		wrapLine.p(comp);
		undo.p(comp);
		enlarge.p(comp);
		nextHigh.p(comp);
		previousHigh.p(comp);
		increaseFont.p(comp);
		decreaseFont.p(comp);
	}
}
