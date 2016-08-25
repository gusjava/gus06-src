package gus06.entity.gus.swing.textcomp.buildlabel.caretposition;


import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.JLabel;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.text.Element;
import javax.swing.text.JTextComponent;
import javax.swing.text.PlainDocument;
import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160517";}



	public Object t(Object obj) throws Exception
	{return new JLabel1((JTextComponent) obj);}




	public class JLabel1 extends JLabel implements CaretListener, MouseMotionListener {
	
		private JTextComponent comp;
		private PlainDocument document;
		
		public JLabel1(JTextComponent comp) throws Exception
		{
			super();
			setFont(getFont().deriveFont(Font.PLAIN));
			
			this.comp = comp;
			
			if(comp.getDocument() instanceof PlainDocument)
			{
				comp.addCaretListener(this);
				comp.addMouseMotionListener(this);
				document = (PlainDocument)comp.getDocument();
				update();
			}
			else throw new Exception("invalid document for caret position display");
		}
	
		private void update()
		{
			int pos = comp.getCaretPosition();
			int select = comp.getCaret().getDot() - comp.getCaret().getMark();
			
			//Element line = document.getParagraphElement(pos);
			//int start = line.getStartOffset();
			//int lineIndex = document.getDefaultRootElement().getElementIndex(start) + 1;
			//int columnIndex = pos-start;
			//setText(" caret:"+pos+" ["+lineIndex+":"+columnIndex+"] ");
			
			if(select!=0) setText(" "+pos+" ["+select+"] ");
			else setText(" "+pos+" ");
		}
	
		public void caretUpdate(CaretEvent e) {update();}
		public void mouseDragged(MouseEvent e) {update();}
		public void mouseMoved(MouseEvent e) {}
	}

}
