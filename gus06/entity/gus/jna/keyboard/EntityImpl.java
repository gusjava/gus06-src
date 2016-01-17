package gus06.entity.gus.jna.keyboard;

import gus06.framework.*;

import com.sun.jna.Platform;
import com.sun.jna.Structure;
import com.sun.jna.platform.win32.Kernel32;
import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinUser;
import com.sun.jna.platform.win32.BaseTSD.ULONG_PTR;
import com.sun.jna.platform.win32.WinDef.HMODULE;
import com.sun.jna.platform.win32.WinDef.LRESULT;
import com.sun.jna.platform.win32.WinDef.WPARAM;
import com.sun.jna.platform.win32.WinUser.HHOOK;
import com.sun.jna.platform.win32.WinUser.HOOKPROC;
import com.sun.jna.platform.win32.WinUser.MSG;
import java.util.List;
import java.util.Arrays;
import java.util.HashSet;



public class EntityImpl extends S1 implements Entity, G, F, Runnable {

	public String creationDate() {return "20141217";}

	public static final int K_PRESSED = 256;
	public static final int K_RELEASED = 257;

	public static final int K_ALT_PRESSED = 260;
	public static final int K_ALT_RELEASED = 261;
	
	
	 
	private HHOOK hhk;
	private String code;
	private HashSet set;


	public EntityImpl() throws Exception
	{
		set = new HashSet();
		if(!Platform.isWindows()) return;
		new Thread(this,"THREAD_"+getClass().getName()).start();
	}
	
	public void run()
	{
		LowLevelKeyboardProcImpl llkpi = new LowLevelKeyboardProcImpl();
		HMODULE hmodule = Kernel32.INSTANCE.GetModuleHandle(null);
		hhk = User32.INSTANCE.SetWindowsHookEx(WinUser.WH_KEYBOARD_LL,llkpi,hmodule,0);
		User32.INSTANCE.GetMessage(new MSG(),null,0,0);
	}
	
	
	public Object g() throws Exception
	{return code;}
	
	public boolean f(Object obj) throws Exception
	{return set.contains(obj);}
	
	
	
	private void keyPressed()
	{send(this,"keyPressed()");}
	
	private void keyReleased()
	{send(this,"keyReleased()");}
	
	
	
	
	private interface LowLevelKeyboardProc extends HOOKPROC
	{
		LRESULT callback(int nCode, WPARAM wParam, KEYBOARDHOOKSTRUCT lParam);
	}

	private class LowLevelKeyboardProcImpl implements LowLevelKeyboardProc
	{
		public LRESULT callback(int nCode, WPARAM wParam, KEYBOARDHOOKSTRUCT info)
		{
			if(nCode>=0)
			{
				code = convert(info.vkCode);
				switch(wParam.intValue())
				{
					case K_PRESSED:
						set.add(code);
						keyPressed();
						break;
    			
					case K_ALT_PRESSED:
						set.add(code);
						keyPressed();
						break;
    			
					case K_RELEASED:
						set.remove(code);
						keyReleased();
						break;
    			
					case K_ALT_RELEASED:
						set.remove(code);
						keyReleased();
						break;
    			
					default:break;
				}
			}
			return User32.INSTANCE.CallNextHookEx(hhk,nCode,wParam,info.getPointer());
		}
	}



	public static class KEYBOARDHOOKSTRUCT extends Structure
	{
		public static class ByReference extends KEYBOARDHOOKSTRUCT implements Structure.ByReference {};

		public int vkCode;
		public int scanCode;
		public int flags;
		public int time;
		public ULONG_PTR dwExtraInfo;

		protected List getFieldOrder()
		{
			return Arrays.asList(new String[] { "vkCode", "scanCode", "flags", "time" , "dwExtraInfo" });
		}
	}



	private String convert(int vkCode)
	{
		switch(vkCode)
		{
		case 13: return "10";//VK_ENTER
		case 44: return "154";//VK_PRINTSCREEN
		case 45: return "155";//VK_INSERT
		case 46: return "127";//VK_DELETE
		case 91: return "524";//VK_WINDOWS
		case 93: return "525";//VK_CONTEXT_MENU
		case 160: return "16";//VK_SHIFT
		case 161: return "16";//VK_SHIFT
		case 162: return "17";//VK_CONTROL
		case 163: return "17";//VK_CONTROL
		case 164: return "18";//VK_ALT
		case 165: return "18";//VK_ALT
		case 186: return "515";//VK_DOLLAR
		case 187: return "61";//VK_EQUALS
		case 188: return "44";//VK_COMMA
		case 190: return "59";//VK_SEMICOLON
		case 191: return "513";//VK_UNDEFINED
		case 192: return "0";//VK_COLON
		case 219: return "522";//VK_RIGHT_PARENTHESIS
		case 220: return "151";//VK_ASTERISK
		case 221: return "130";//VK_DEAD_CIRCUMFLEX
		case 222: return "0";//VK_UNDEFINED
		case 223: return "517";//VK_EXCLAMATION_MARK

		default: return ""+vkCode;
		}
	}
}
