package gus06.entity.gus.sys.quickreplace.holder.build;

import gus06.framework.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.text.JTextComponent;
import java.util.List;
import javax.swing.JLabel;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160430";}


	private Service perform;
	
	public EntityImpl() throws Exception
	{
		perform = Outside.service(this,"gus.sys.quickreplace.perform");
	}
	
	
	
	public Object t(Object obj) throws Exception
	{return new Holder((JTextComponent) obj);}
	
	
	
	
	private class Holder implements P, I, DocumentListener, CaretListener
	{
		private JTextComponent comp;
		private boolean justEdited = false;
		private JLabel label;
		
		private StringBuffer replace;
		private int del_after;
		private int del_before;
		
		private String memSelected;
		private String memText;
		private int memPos;
		
		private int dot0;
		private int mark0;
		
		
		public Holder(JTextComponent comp)
		{
			this.comp = comp;
			label = new JLabel();
			replace = new StringBuffer();
			
			comp.addCaretListener(this);
			comp.getDocument().addDocumentListener(this);
		}

        
		public void caretUpdate(CaretEvent e)
		{
			dot0 = e.getDot();
			mark0 = e.getMark();
			
			if(!justEdited) reset();
			justEdited=false;
		}
		
		public void changedUpdate(DocumentEvent e) {}
		
		public void insertUpdate(DocumentEvent e)
		{
			int start = e.getOffset();
			int length = e.getLength();
			if(start==0 && length==e.getDocument().getLength()) return;
			
			try
			{
				String text = e.getDocument().getText(start,length);
				replace.append(text);
			}
			catch(Exception ex){}
			
			justEdited = true;
			updateLabel();
		}
        
		public void removeUpdate(DocumentEvent e)
		{
			int start = e.getOffset();
			int length = e.getLength();
			if(start==0 && length==e.getDocument().getLength()) return;
			
			if(dot0!=mark0)
			{
			}
			else if(start==dot0)
			{
				del_after++;
			}
			else if(start==dot0-1)
			{
				if(replace.length()>0)
				replace.deleteCharAt(replace.length()-1);
				else del_before++;
			}
			
			justEdited = true;
			updateLabel();
		}
		
		
		
		private void reset()
		{
			replace = new StringBuffer();
			del_before = 0;
			del_after = 0;
			
			memText = comp.getText();
			memSelected = comp.getSelectedText();
			memPos = comp.getCaretPosition();
			
			updateLabel();
		}
		
		
		private void updateLabel()
		{
			label.setText("  "+memPos+"|"+memSelected+" \u2192 "+del_before+"|"+replace+"|"+del_after);
		}
		
		
		
		public void p(Object obj) throws Exception
		{
			T t = (T) obj;
			
			String[] params1 = new String[]{memText,memSelected,replace.toString()};
			int[] params2 = new int[]{memPos,del_before,del_after};
			
			T trans = (T) t.t(new Object[]{params1,params2});
			
			perform.p(new Object[]{comp,memText,trans});
			
			int len = comp.getText().length();
			int pos = Math.min(len,memPos);
			comp.setCaretPosition(pos);
			comp.requestFocus();
			
			reset();
		}
		
		
		public Object i() throws Exception
		{return label;}
	}
}
