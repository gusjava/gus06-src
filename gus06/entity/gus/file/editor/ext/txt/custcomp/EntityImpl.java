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
		
		list.add(Outside.service(this,"gus.swing.textcomp.cust.action.c.copy"));
		
		list.add(Outside.service(this,"gus.swing.textcomp.cust.action.d.removeline"));
		
		list.add(Outside.service(this,"gus.swing.textcomp.cust.action.e.doubleline"));
		
		list.add(Outside.service(this,"gus.swing.textcomp.cust.action.f.search"));
		list.add(Outside.service(this,"gus.swing.textcomp.cust.action.f_shift.search"));
		list.add(Outside.service(this,"gus.swing.textcomp.cust.action.alt_f.search1"));
		
		list.add(Outside.service(this,"gus.swing.textcomp.cust.action.g.regex"));
		list.add(Outside.service(this,"gus.swing.textcomp.cust.action.g_shift.regex.rule"));
		
		list.add(Outside.service(this,"gus.swing.textcomp.cust.action.h.tool"));
		
		list.add(Outside.service(this,"gus.swing.textcomp.cust.action.j.high1"));
		
		list.add(Outside.service(this,"gus.swing.textcomp.cust.action.p.wrapline"));
		
		list.add(Outside.service(this,"gus.swing.textcomp.cust.action.q.keepselection"));
		list.add(Outside.service(this,"gus.swing.textcomp.cust.action.q_shift.keepselection.focus"));
		
		list.add(Outside.service(this,"gus.swing.textcomp.cust.action.r.keepline"));
		list.add(Outside.service(this,"gus.swing.textcomp.cust.action.r_shift.keepline.focus"));
		
		list.add(Outside.service(this,"gus.swing.textcomp.cust.action.t.truncate"));
		list.add(Outside.service(this,"gus.swing.textcomp.cust.action.t_shift.truncate.inv"));
		
		list.add(Outside.service(this,"gus.swing.textcomp.cust.action.v.paste"));
		
		list.add(Outside.service(this,"gus.swing.textcomp.cust.action.w.quickreplace"));
		list.add(Outside.service(this,"gus.swing.textcomp.cust.action.w_shift.smartreplace"));
		
		list.add(Outside.service(this,"gus.swing.textcomp.cust.action.x.cut"));
		
		list.add(Outside.service(this,"gus.swing.textcomp.cust.action.space.enlargeselection"));
		
		list.add(Outside.service(this,"gus.swing.textcomp.cust.action.escap.focusback"));
		
		list.add(Outside.service(this,"gus.swing.textcomp.cust.action.del"));
		
		list.add(Outside.service(this,"gus.swing.textcomp.cust.action.plus.increasefontsize"));
		list.add(Outside.service(this,"gus.swing.textcomp.cust.action.minus.decreasefontsize"));
		
		list.add(Outside.service(this,"gus.swing.textcomp.cust.action.down.select.after"));
		list.add(Outside.service(this,"gus.swing.textcomp.cust.action.right.select.forward"));
		list.add(Outside.service(this,"gus.swing.textcomp.cust.action.left.select.back"));
		list.add(Outside.service(this,"gus.swing.textcomp.cust.action.up.select.before"));
		
		list.add(Outside.service(this,"gus.swing.textcomp.cust.action.alt_down.gotodown"));
		list.add(Outside.service(this,"gus.swing.textcomp.cust.action.alt_left.gotoleft"));
		list.add(Outside.service(this,"gus.swing.textcomp.cust.action.alt_right.gotoright"));
		list.add(Outside.service(this,"gus.swing.textcomp.cust.action.alt_up.gotoup"));
		
		list.add(Outside.service(this,"gus.swing.textcomp.paint.caretline"));
		list.add(Outside.service(this,"gus.swing.textcomp.cust.autoedit.tab1"));
		list.add(Outside.service(this,"gus.swing.textcomp.cust.autoedit.enter1"));
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
