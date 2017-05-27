package gus06.entity.gus.sys.listchooser1.gui.selector1;

import gus06.framework.*;
import java.awt.BorderLayout;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class EntityImpl extends S1 implements Entity, I, P, G, V, ActionListener, ListSelectionListener {

	public String creationDate() {return "20160504";}

	public static final String ICONID = "ELEMENT";
	

	private Service fieldHolder;
	private Service buildJList;
	private Service linkerListField;
	private Service listFilter;
	private Service findList;
	
	
	private JPanel panel;
	private JTextField field;
	private JList list;
	private JLabel label;
	
	private List input;
	private List results;
	private Map mapping;


	public EntityImpl() throws Exception
	{
		fieldHolder = Outside.service(this,"*gus.data.editor.string.textfield.editor1");
		buildJList = Outside.service(this,"gus.swing.list.build.fromicon");
		linkerListField = Outside.service(this,"gus.swing.list.textfield.linker");
		listFilter = Outside.service(this,"gus.list.filter.rule.all");
		findList = Outside.service(this,"gus.find.list");
		
		
		label = new JLabel(" ");
		field = (JTextField) fieldHolder.i();
		list = (JList) buildJList.t(ICONID);

		panel = new JPanel(new BorderLayout());
		panel.add(field,BorderLayout.NORTH);
		panel.add(new JScrollPane(list),BorderLayout.CENTER);
		panel.add(label,BorderLayout.SOUTH);
		
		fieldHolder.addActionListener(this);
		list.addListSelectionListener(this);
		linkerListField.p(new Object[]{list,field});
		
		list.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent e)
			{
				int code = e.getKeyCode();
				
				if(code==KeyEvent.VK_F1)		typed_F1();
				else if(code==KeyEvent.VK_F2)		typed_F2();
				else if(code==KeyEvent.VK_F3)		typed_F3();
				else if(code==KeyEvent.VK_F4)		typed_F4();
				else if(code==KeyEvent.VK_F5)		typed_F5();
				else if(code==KeyEvent.VK_F6)		typed_F6();
				else if(code==KeyEvent.VK_F7)		typed_F7();
				else if(code==KeyEvent.VK_F8)		typed_F8();
				else if(code==KeyEvent.VK_F9)		typed_F9();
				else if(code==KeyEvent.VK_F10)		typed_F10();
				else if(code==KeyEvent.VK_F11)		typed_F11();
				else if(code==KeyEvent.VK_F12)		typed_F12();
				
				else if(code==KeyEvent.VK_DELETE)	typed_delete();
				else if(code==KeyEvent.VK_SPACE)	typed_space();
				else if(code==KeyEvent.VK_ENTER)	typed_enter();
				else if(code==KeyEvent.VK_ESCAPE)	typed_escape();
			}
		});
		
		field.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent e)
			{
				int code = e.getKeyCode();
				if(code==KeyEvent.VK_ESCAPE)
				{
					if(field.getText().equals("")) typed_escape();
				}
				else if(code==KeyEvent.VK_ENTER)
				{
					SwingUtilities.invokeLater(new Runnable(){
						public void run() {
							if(!hasResults()) return;
							selectFirstRow();
							typed_enter();
						}
					});
				}
			}
		});
	}
	
	
	
	public Object i() throws Exception
	{return panel;}
	
	
	
	public Object g() throws Exception
	{
		Object selected = list.getSelectedValue();
		if(mapping==null) return selected;
		
		if(!mapping.containsKey(selected)) return null;
		return mapping.get(selected);
	}
	
	
	
	public void p(Object obj) throws Exception
	{
		if(obj instanceof Map)
		{
			mapping = (Map) obj;
			input = new ArrayList(mapping.keySet());
			Collections.sort(input);
		}
		else
		{
			mapping = null;
			input = (List) findList.t(obj);
		}
		refresh();
	}
	
	
	
	public void v(String key, Object obj) throws Exception
	{
		if(key.equals("select")) {select(obj);return;}
		throw new Exception("Unknown key: "+key);
	}
	
	

	public void valueChanged(ListSelectionEvent e)
	{selectionChanged();}
	
	
	public void actionPerformed(ActionEvent e)
	{
		SwingUtilities.invokeLater(new Runnable(){
			public void run() {refresh();}
		});
	}

	
	
	private void selectionChanged()
	{send(this,"selectionChanged()");}
	
	
	
	private void typed_F1()
	{send(this,"typed_F1()");}
	
	private void typed_F2()
	{send(this,"typed_F2()");}
	
	private void typed_F3()
	{send(this,"typed_F3()");}
	
	private void typed_F4()
	{send(this,"typed_F4()");}
	
	private void typed_F5()
	{send(this,"typed_F5()");}
	
	private void typed_F6()
	{send(this,"typed_F6()");}
	
	private void typed_F7()
	{send(this,"typed_F7()");}
	
	private void typed_F8()
	{send(this,"typed_F8()");}
	
	private void typed_F9()
	{send(this,"typed_F9()");}
	
	private void typed_F10()
	{send(this,"typed_F10()");}
	
	private void typed_F11()
	{send(this,"typed_F11()");}
	
	private void typed_F12()
	{send(this,"typed_F12()");}
	
	private void typed_space()
	{send(this,"typed_space()");}

	private void typed_delete()
	{send(this,"typed_delete()");}

	private void typed_enter()
	{send(this,"typed_enter()");}

	private void typed_escape()
	{send(this,"typed_escape()");}
	
	
	
	
	
	private void refresh()
	{
		try
		{
			results = (List) listFilter.t(new Object[]{input,query()});
			list.setListData(toVector(results));
			
			if(hasResults()) selectFirstRow();
			label.setText(" number: "+resultNumber());
			field.requestFocusInWindow();
		}
		catch(Exception e)
		{Outside.err(this,"refresh()",e);}
	}
	
	
	
	private void select(Object obj)
	{
		list.setSelectedValue(obj,true);
		list.requestFocusInWindow();
	}
	
	private void selectFirstRow()
	{
		list.setSelectedIndex(0);
		list.requestFocusInWindow();
	}
	
	
	private Vector toVector(List keys)
	{return keys!=null ? new Vector(keys) : new Vector();}
	
	private String query() throws Exception
	{return (String) fieldHolder.g();}
	
	private boolean hasResults()
	{return results!=null && results.size()>0;}
	
	private int resultNumber()
	{return results!=null ? results.size() : 0;}
	
	
}
