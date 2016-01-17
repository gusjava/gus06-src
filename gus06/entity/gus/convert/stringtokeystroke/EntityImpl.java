package gus06.entity.gus.convert.stringtokeystroke;

import gus06.framework.*;

import java.awt.event.KeyEvent;
import javax.swing.KeyStroke;
import java.awt.Event;


public class EntityImpl implements Entity, T {

	public String creationDate() {return "20140727";}
	
	
	public Object t(Object obj) throws Exception
	{
		String s = (String) obj;
		if(s.startsWith("ctrl "))
			return keyStroke_ctrl(s.substring(5));
		return keyStroke(s);
	}


	private KeyStroke keyStroke(String s) throws Exception
	{return KeyStroke.getKeyStroke(code(s),0);}

	private KeyStroke keyStroke_ctrl(String s) throws Exception
	{return KeyStroke.getKeyStroke(code(s),Event.CTRL_MASK);}




    private int code(String s) throws Exception
    {
	s = s.toUpperCase();

    	if(s.equals("F1")) return KeyEvent.VK_F1;
    	if(s.equals("F2")) return KeyEvent.VK_F2;
    	if(s.equals("F3")) return KeyEvent.VK_F3;
    	if(s.equals("F4")) return KeyEvent.VK_F4;
    	if(s.equals("F5")) return KeyEvent.VK_F5;
    	if(s.equals("F6")) return KeyEvent.VK_F6;
    	if(s.equals("F7")) return KeyEvent.VK_F7;
    	if(s.equals("F8")) return KeyEvent.VK_F8;
    	if(s.equals("F9")) return KeyEvent.VK_F9;
    	if(s.equals("F10")) return KeyEvent.VK_F10;
    	if(s.equals("F11")) return KeyEvent.VK_F11;
    	if(s.equals("F12")) return KeyEvent.VK_F12;
        
    	if(s.equals("A")) return KeyEvent.VK_A;
    	if(s.equals("B")) return KeyEvent.VK_B;
    	if(s.equals("C")) return KeyEvent.VK_C;
    	if(s.equals("D")) return KeyEvent.VK_D;
    	if(s.equals("E")) return KeyEvent.VK_E;
    	if(s.equals("F")) return KeyEvent.VK_F;
    	if(s.equals("G")) return KeyEvent.VK_G;
    	if(s.equals("H")) return KeyEvent.VK_H;
    	if(s.equals("I")) return KeyEvent.VK_I;
    	if(s.equals("J")) return KeyEvent.VK_J;
    	if(s.equals("K")) return KeyEvent.VK_K;
    	if(s.equals("L")) return KeyEvent.VK_L;
    	if(s.equals("M")) return KeyEvent.VK_M;
    	if(s.equals("N")) return KeyEvent.VK_N;
    	if(s.equals("O")) return KeyEvent.VK_O;
    	if(s.equals("P")) return KeyEvent.VK_P;
    	if(s.equals("Q")) return KeyEvent.VK_Q;
    	if(s.equals("R")) return KeyEvent.VK_R;
    	if(s.equals("S")) return KeyEvent.VK_S;
    	if(s.equals("T")) return KeyEvent.VK_T;
    	if(s.equals("U")) return KeyEvent.VK_U;
    	if(s.equals("V")) return KeyEvent.VK_V;
    	if(s.equals("W")) return KeyEvent.VK_W;
    	if(s.equals("X")) return KeyEvent.VK_X;
    	if(s.equals("Y")) return KeyEvent.VK_Y;
    	if(s.equals("Z")) return KeyEvent.VK_Z;

    	if(s.equals("SPACE")) return KeyEvent.VK_SPACE;
    	
    	throw new Exception("Unknown code: "+s);
    }
}
