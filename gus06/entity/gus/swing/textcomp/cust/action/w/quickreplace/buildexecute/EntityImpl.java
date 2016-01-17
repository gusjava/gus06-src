package gus06.entity.gus.swing.textcomp.cust.action.w.quickreplace.buildexecute;

import gus06.framework.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.text.JTextComponent;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20140816";}


	private Service buildTransform;
	

	public EntityImpl() throws Exception
	{
		buildTransform = Outside.service(this,"gus.swing.textcomp.cust.action.w.quickreplace.buildexecute.t");
	}
	
	
	public Object t(Object obj) throws Exception
	{return new Execute((JTextComponent) obj);}
	
	
	
	
	
	private class Execute implements E, DocumentListener, CaretListener, KeyListener, MouseMotionListener, MouseListener
	{
		private JTextComponent comp;
		
		private StringBuffer replacement;
		private int del_after;
		private int del_before;
		private String selected = "";
		private String textMem = "";
		private int position;
		private int lastPressed = -1;
		
		public Execute(JTextComponent comp)
		{
			this.comp = comp;
			
			comp.addKeyListener(this);
			comp.addMouseListener(this);
			comp.addMouseMotionListener(this);
			comp.addCaretListener(this);
			comp.getDocument().addDocumentListener(this);
		}


		public void changedUpdate(DocumentEvent e) {}
        
		public void keyTyped(KeyEvent e) {}
		public void keyPressed(KeyEvent e) {lastPressed = e.getKeyCode();}
		public void keyReleased(KeyEvent e) {}

		public void mouseDragged(MouseEvent e) {captureSelection();}
		public void mouseMoved(MouseEvent e) {}

		public void mouseClicked(MouseEvent e) {}
		public void mousePressed(MouseEvent e) {caretMoved();}
		public void mouseReleased(MouseEvent e) {}
		public void mouseEntered(MouseEvent e) {}
		public void mouseExited(MouseEvent e) {}
        
        
        
		public void insertUpdate(DocumentEvent e)
		{
			int start = e.getOffset();
			int length = e.getLength();
			try
			{
				String insertedText = e.getDocument().getText(start,length);
				appendToReplacement(insertedText);
			}
			catch(Exception ex){}
		}
        
		public void removeUpdate(DocumentEvent e)
		{
			if(e.getLength()>1) initReplacement();
			else if(lastPressed==8 && selectionEmpty()) back();
			else if(lastPressed==127 && selectionEmpty()) suppr();
            
			lastPressed = -1;
		}
        
        
		public void caretUpdate(CaretEvent evt)
		{
			// arrows
			if(lastPressed==37) caretMoved();
			if(lastPressed==38) caretMoved();
			if(lastPressed==39) caretMoved();
			if(lastPressed==40) caretMoved();
            
			lastPressed = -1;
		}
        
        
        
		private boolean selectedEmpty()
		{return selected.equals("");}
        
		private boolean selectionEmpty()
		{return comp.getSelectedText()==null;}
        
        
        
		private void initReplacement()
		{
			replacement = new StringBuffer();
			del_before = 0;
			del_after = 0;
		}
        
        
		private void initSelected()
		{
			selected = "";
			textMem = comp.getText();
		}
        
        
		private void initPosition()
		{position = comp.getCaretPosition();}
        
       
        
		private void init()
		{
			initSelected();
			initReplacement();
			initPosition();
		}
        
        
        
        
		private void setSelected(String selected)
		{
			this.selected = selected;
			replacement = new StringBuffer(); 
		}
        
        
        
		private void appendToReplacement(String inserted)
		{
			if(inserted.equals(comp.getText()) && inserted.length()>1)
				replacement = new StringBuffer();
			else replacement.append(inserted);
			del_before = 0; 
		}
        
        
        
        
		private void back()
		{
			int n = replacement.length(); 
			if(n>0) replacement.delete(n-1,n);
			else del_before+=1; 
		}
        
        
		private void suppr()
		{del_after++;}
        
        
        
        
		private void captureSelection()
		{
			String val = comp.getSelectedText();
			if(val==null)return;
			if(val.equals(""))return;
			setSelected(val);
		}
        
        

		private void caretMoved()
		{
			init();
			captureSelection();
		}
		
		
		public void e() throws Exception
		{
			T t = (T) buildTransform.t(new Object[]{
				new String[]{textMem,selected,replacement.toString()},
				new int[]{position,del_before,del_after}
			});
			execute(comp,t,textMem);
			init();
		}
	}
	
	
	
	
	
	
	
	private void execute(JTextComponent comp, T t, String textMem)
        {
		try
		{
			comp.setText((String)t.t(textMem));
			comp.requestFocus();
		}
		catch(Exception e)
		{Outside.err(this,"execute(JTextComponent,T,String)",e);}
	}
}
