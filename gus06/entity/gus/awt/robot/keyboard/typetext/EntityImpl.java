package gus06.entity.gus.awt.robot.keyboard.typetext;

import gus06.framework.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20160418";}
	
	public static final int KEY_MAJ = 16;
	public static final int KEY_ALT_GR = 17;


	private Robot robot;
	
	public EntityImpl() throws Exception
	{robot = new Robot();}
	
	
	
	public void p(Object obj) throws Exception
	{
		String s = (String) obj;
		for(int i=0;i<s.length();i++)
		handle(s.charAt(i));
	}
	
	
	
	private void handle(char c) throws Exception
	{
		if(c=='a') type(KeyEvent.VK_A);
		else if(c=='b') type(KeyEvent.VK_B);
		else if(c=='c') type(KeyEvent.VK_C);
		else if(c=='d') type(KeyEvent.VK_D);
		else if(c=='e') type(KeyEvent.VK_E);
		else if(c=='f') type(KeyEvent.VK_F);
		else if(c=='g') type(KeyEvent.VK_G);
		else if(c=='h') type(KeyEvent.VK_H);
		else if(c=='i') type(KeyEvent.VK_I);
		else if(c=='j') type(KeyEvent.VK_J);
		else if(c=='k') type(KeyEvent.VK_K);
		else if(c=='l') type(KeyEvent.VK_L);
		else if(c=='m') type(KeyEvent.VK_M);
		else if(c=='n') type(KeyEvent.VK_N);
		else if(c=='o') type(KeyEvent.VK_O);
		else if(c=='p') type(KeyEvent.VK_P);
		else if(c=='q') type(KeyEvent.VK_Q);
		else if(c=='r') type(KeyEvent.VK_R);
		else if(c=='s') type(KeyEvent.VK_S);
		else if(c=='t') type(KeyEvent.VK_T);
		else if(c=='u') type(KeyEvent.VK_U);
		else if(c=='v') type(KeyEvent.VK_V);
		else if(c=='w') type(KeyEvent.VK_W);
		else if(c=='x') type(KeyEvent.VK_X);
		else if(c=='y') type(KeyEvent.VK_Y);
		else if(c=='z') type(KeyEvent.VK_Z);
		
		else if(c=='A') type(KeyEvent.VK_A);
		else if(c=='B') type(KeyEvent.VK_B);
		else if(c=='C') type(KeyEvent.VK_C);
		else if(c=='D') type(KeyEvent.VK_D);
		else if(c=='E') type(KeyEvent.VK_E);
		else if(c=='F') type(KeyEvent.VK_F);
		else if(c=='G') type(KeyEvent.VK_G);
		else if(c=='H') type(KeyEvent.VK_H);
		else if(c=='I') type(KeyEvent.VK_I);
		else if(c=='J') type(KeyEvent.VK_J);
		else if(c=='K') type(KeyEvent.VK_K);
		else if(c=='L') type(KeyEvent.VK_L);
		else if(c=='M') type(KeyEvent.VK_M);
		else if(c=='N') type(KeyEvent.VK_N);
		else if(c=='O') type(KeyEvent.VK_O);
		else if(c=='P') type(KeyEvent.VK_P);
		else if(c=='Q') type(KeyEvent.VK_Q);
		else if(c=='R') type(KeyEvent.VK_R);
		else if(c=='S') type(KeyEvent.VK_S);
		else if(c=='T') type(KeyEvent.VK_T);
		else if(c=='U') type(KeyEvent.VK_U);
		else if(c=='V') type(KeyEvent.VK_V);
		else if(c=='W') type(KeyEvent.VK_W);
		else if(c=='X') type(KeyEvent.VK_X);
		else if(c=='Y') type(KeyEvent.VK_Y);
		else if(c=='Z') type(KeyEvent.VK_Z);
		
		else if(c=='0') type(KeyEvent.VK_NUMPAD0);
		else if(c=='1') type(KeyEvent.VK_NUMPAD1);
		else if(c=='2') type(KeyEvent.VK_NUMPAD2);
		else if(c=='3') type(KeyEvent.VK_NUMPAD3);
		else if(c=='4') type(KeyEvent.VK_NUMPAD4);
		else if(c=='5') type(KeyEvent.VK_NUMPAD5);
		else if(c=='6') type(KeyEvent.VK_NUMPAD6);
		else if(c=='7') type(KeyEvent.VK_NUMPAD7);
		else if(c=='8') type(KeyEvent.VK_NUMPAD8);
		else if(c=='9') type(KeyEvent.VK_NUMPAD9);
		
		else if(c=='\t') type(KeyEvent.VK_TAB);
		else if(c=='\n') type(KeyEvent.VK_ENTER);
		else if(c==' ') type(KeyEvent.VK_SPACE);
		else if(c=='_') type(KeyEvent.VK_UNDERSCORE);
		else if(c=='@') typeAltGr(KeyEvent.VK_0);
		
		else throw new Exception("Unsupported character: "+c);
	}
	
	
	private void typeMaj(int c) throws Exception
	{
		press(KEY_MAJ);
		type(c);
		release(KEY_MAJ);
	}
	
	private void typeAltGr(int c) throws Exception
	{
		press(KEY_ALT_GR);
		type(c);
		release(KEY_ALT_GR);
	}
	
	
	
	
	
	private void type(int c) throws Exception
	{
		press(c);
		release(c);
	}
	
	private void press(int c) throws Exception
	{
		try{robot.keyPress(c);}
		catch(IllegalArgumentException e)
		{throw new Exception("keyPress failed with code="+c,e);}
	}
	
	private void release(int c) throws Exception
	{
		try{robot.keyRelease(c);}
		catch(IllegalArgumentException e)
		{throw new Exception("keyReleased failed with code="+c,e);}
	}
}
