package gus06.entity.gus.sys.listchooser1.gui.selector1;

import gus06.framework.*;
import java.awt.BorderLayout;
import java.awt.event.*;
import java.util.List;
import java.util.Vector;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class EntityImpl extends S1 implements Entity, I, P, G, ActionListener, ListSelectionListener {

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
				
				if(code==KeyEvent.VK_F5)		typed_F5();
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
	{return list.getSelectedValue();}
	
	
	
	public void p(Object obj) throws Exception
	{
		input = (List) findList.t(obj);
		refresh();
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
	
	private void typed_F5()
	{send(this,"typed_F5()");}
	
	private void typed_space()
	{send(this,"typed_space()");}

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
	
	
	
	
	private Vector toVector(List keys)
	{return keys!=null ? new Vector(keys) : new Vector();}
	
	private String query() throws Exception
	{return (String) fieldHolder.g();}
	
	private boolean hasResults()
	{return results!=null && results.size()>0;}
	
	private int resultNumber()
	{return results!=null ? results.size() : 0;}
	
	private void selectFirstRow()
	{list.getSelectionModel().setSelectionInterval(0,0);}
}
