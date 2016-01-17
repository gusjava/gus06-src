package gus06.entity.gus.io.outputstream.textarea1;

import java.io.OutputStream;

import javax.swing.JTextArea;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20140717";}
	
	
	public Object t(Object obj) throws Exception
	{return new OutputStreamJTextArea((JTextArea) obj);}
	
	
	private class OutputStreamJTextArea extends OutputStream
	{
		private JTextArea gui;
		
		public OutputStreamJTextArea(JTextArea gui)
		{this.gui = gui;}
		
		public void write(int b)
		{
			byte[] t = {(byte)b};
			gui.append(new String(t));
			gui.setCaretPosition(gui.getDocument().getLength());
		}
	}
}