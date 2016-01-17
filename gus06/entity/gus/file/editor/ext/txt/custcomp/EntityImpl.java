package gus06.entity.gus.file.editor.ext.txt.custcomp;

import gus06.framework.*;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.text.JTextComponent;
import java.awt.Color;
import java.util.List;
import java.util.ArrayList;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20140831";}

	public static final Font FONT = new Font("Courier",Font.PLAIN,14);
	public static final Insets MARGIN = new Insets(0,5,0,5);
	public static final Color SELECTION = Color.BLACK;
	public static final Color SELECTED = Color.WHITE;
	
	
	
	private List<P> list;

	public EntityImpl() throws Exception
	{
		list = new ArrayList<>();
		
		list.add(Outside.service(this,"gus.swing.textcomp.cust.action.f1.autocomplete"));
		list.add(Outside.service(this,"gus.swing.textcomp.cust.action.e.doubleline"));
		
		list.add(Outside.service(this,"gus.swing.textcomp.cust.action.d.removeline"));
		list.add(Outside.service(this,"gus.swing.textcomp.cust.action.r.keepline"));
		list.add(Outside.service(this,"gus.swing.textcomp.cust.action.q.keepselection"));
		
		list.add(Outside.service(this,"gus.swing.textcomp.cust.action.p.wrapline"));
		list.add(Outside.service(this,"gus.swing.textcomp.cust.action.space.enlargeselection"));
		list.add(Outside.service(this,"gus.swing.textcomp.cust.action.w.quickreplace"));
		
		list.add(Outside.service(this,"gus.swing.textcomp.cust.action.right.gotohigh.next"));
		list.add(Outside.service(this,"gus.swing.textcomp.cust.action.left.gotohigh.previous"));
		
		list.add(Outside.service(this,"gus.swing.textcomp.paint.caretline"));
		list.add(Outside.service(this,"gus.swing.textcomp.cust.action.h.tool"));
		
		// HIGHLIGHT
		
		list.add(Outside.service(this,"gus.swing.textcomp.cust.action.f.search"));
		list.add(Outside.service(this,"gus.swing.textcomp.cust.action.f_shift.search"));
		list.add(Outside.service(this,"gus.swing.textcomp.cust.action.g.regexp"));
		
		list.add(Outside.service(this,"gus.swing.textcomp.cust.action.plus.increasefontsize"));
		list.add(Outside.service(this,"gus.swing.textcomp.cust.action.minus.decreasefontsize"));
		
		list.add(Outside.service(this,"gus.swing.textcomp.cust.action.t.truncate"));
		list.add(Outside.service(this,"gus.swing.textcomp.cust.action.t_shift.truncate.inv"));
		
		// TEXT FOCUS
		
		list.add(Outside.service(this,"gus.swing.textcomp.cust.action.q_shift.keepselection.focus"));
		list.add(Outside.service(this,"gus.swing.textcomp.cust.action.r_shift.keepline.focus"));
		list.add(Outside.service(this,"gus.swing.textcomp.cust.action.escap.focusback"));
	}
	
	
	
	
	public void p(Object obj) throws Exception
	{
		JTextComponent comp = (JTextComponent) obj;
		
		comp.setMargin(MARGIN);
		comp.setFont(FONT);
		comp.setSelectionColor(SELECTION);
		comp.setSelectedTextColor(SELECTED);
		
		for(P p:list) p.p(comp);
	}
}
