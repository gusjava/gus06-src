package gus06.entity.gus.string.transform.japanese.katakana.builder;

import gus06.framework.*;

public class EntityImpl extends CodePointsKatakana implements Entity, T {

	public String creationDate() {return "20150927";}

	private StringBuffer input;
	private StringBuffer output;
	
	
	public Object t(Object obj) throws Exception 
	{
		String text = (String) obj;
		input = new StringBuffer(text);
		output = new StringBuffer();
		
		while(input.length()>0) handleChar(next());
		return output.toString();
	}
	
	
	private char next()
	{
		if(input.length()==0) return '@';
		
		char c = input.charAt(0);
		input.deleteCharAt(0);
		return c;
	}
	
	private void put(int codePoint)
	{output.append(Character.toChars(codePoint));}
	
	private void put(char c)
	{output.append(c);}
	
	private void put(String s)
	{output.append(s);}
	
	
	
	
	
	
	
	private void handleChar(char c)
	{
		switch(c)
		{
		case 'a':put(A);break;
		case 'i':put(I);break;
		case 'u':put(U);break;
		case 'e':put(E);break;
		case 'o':put(O);break;
		case '.':put(POINT);break;
		case '-':put(LINE);break;
		
		case 'y':y(next());break;
		case 'k':k(next());break;
		case 'g':g(next());break;
		case 's':s(next());break;
		case 'z':z(next());break;
		case 'j':j(next());break;
		case 't':t(next());break;
		case 'd':d(next());break;
		case 'm':m(next());break;
		case 'n':n(next());break;
		case 'r':r(next());break;
		case 'h':h(next());break;
		case 'f':f(next());break;
		case 'b':b(next());break;
		case 'p':p(next());break;
		case 'c':c(next());break;
		case 'w':w(next());break;
		
		default:put(c);
		}
	}



	/*
	 * y
	 */
	private void y(char c)
	{
		switch(c)
		{
		case 'a':put(YA);break;
		case 'u':put(YU);break;
		case 'o':put(YO);break;
		
		case '@':put('y');break;
		default:put('y');put(c);
		}
	}
	
	
	
	
	
	/*
	 * k
	 */
	
	private void k(char c)
	{
		switch(c)
		{
		case 'a':put(KA);break;
		case 'i':put(KI);break;
		case 'u':put(KU);break;
		case 'e':put(KE);break;
		case 'o':put(KO);break;
		case 'y':ky(next());break;
		case 'k':kk(next());break;
		
		case '@':put('k');break;
		default:put('k');put(c);
		}
	}
	
	
	
	
	/*
	 * ky
	 */
	private void ky(char c)
	{
		switch(c)
		{
		case 'a':put(KI);put(YA_SMALL);break;
		case 'u':put(KI);put(YU_SMALL);break;
		case 'o':put(KI);put(YO_SMALL);break;

		case '@':put("ky");break;
		default:put("ky"+c);
		}
	}
	
	
	
	/*
	 * kk
	 */
	private void kk(char c)
	{
		switch(c)
		{
		case 'a':put(TSU_SMALL);put(KA);break;
		case 'i':put(TSU_SMALL);put(KI);break;
		case 'u':put(TSU_SMALL);put(KU);break;
		case 'e':put(TSU_SMALL);put(KE);break;
		case 'o':put(TSU_SMALL);put(KO);break;
		case 'y':kky(next());break;
		
		case '@':put("kk");break;
		default:put("kk"+c);
		}
	}

	
	/*
	 * kky
	 */
	private void kky(char c)
	{
		switch(c)
		{
		case 'a':put(TSU_SMALL);put(KI);put(YA_SMALL);break;
		case 'u':put(TSU_SMALL);put(KI);put(YU_SMALL);break;
		case 'o':put(TSU_SMALL);put(KI);put(YO_SMALL);break;
		
		case '@':put("kky");break;
		default:put("kky"+c);
		}
	}

	
	
	
	
	
	/*
	 * g
	 */
	private void g(char c)
	{
		switch(c)
		{
		case 'a':put(GA);break;
		case 'i':put(GI);break;
		case 'u':put(GU);break;
		case 'e':put(GE);break;
		case 'o':put(GO);break;
		case 'y':gy(next());break;
		case 'g':gg(next());break;
		
		case '@':put('g');break;
		default:put('g');put(c);
		}
	}
	
	
	
	
	
	/*
	 * gy
	 */
	private void gy(char c)
	{
		switch(c)
		{
		case 'a':put(GI);put(YA_SMALL);break;
		case 'u':put(GI);put(YU_SMALL);break;
		case 'o':put(GI);put(YO_SMALL);break;

		case '@':put("gy");break;
		default:put("gy"+c);
		}
	}
	
	
	
	/*
	 * gg
	 */
	private void gg(char c)
	{
		switch(c)
		{
		case 'a':put(TSU_SMALL);put(GA);break;
		case 'i':put(TSU_SMALL);put(GI);break;
		case 'u':put(TSU_SMALL);put(GU);break;
		case 'e':put(TSU_SMALL);put(GE);break;
		case 'o':put(TSU_SMALL);put(GO);break;
		case 'y':ggy(next());break;
		
		case '@':put("gg");break;
		default:put("gg"+c);
		}
	}

	
	/*
	 * ggy
	 */
	private void ggy(char c)
	{
		switch(c)
		{
		case 'a':put(TSU_SMALL);put(GI);put(YA_SMALL);break;
		case 'u':put(TSU_SMALL);put(GI);put(YU_SMALL);break;
		case 'o':put(TSU_SMALL);put(GI);put(YO_SMALL);break;
		
		case '@':put("ggy");break;
		default:put("ggy"+c);
		}
	}
	
	
	
	
	
	/*
	 * s
	 */
	private void s(char c)
	{
		switch(c)
		{
		case 'a':put(SA);break;
		case 'u':put(SU);break;
		case 'e':put(SE);break;
		case 'o':put(SO);break;
		case 'y':sy(next());break;
		case 'h':sh(next());break;
		case 's':ss(next());break;
		
		case '@':put('s');break;
		default:put('s');put(c);
		}
	}
	
	
	/*
	 * sy
	 */
	private void sy(char c)
	{
		switch(c)
		{
		case 'a':put(SHI);put(YA_SMALL);break;
		case 'u':put(SHI);put(YU_SMALL);break;
		case 'o':put(SHI);put(YO_SMALL);break;
		
		case '@':put("sy");break;
		default:put("sy"+c);
		}
	}
	

	
	/*
	 * sh
	 */
	private void sh(char c)
	{
		switch(c)
		{
		case 'i':put(SHI);break;
		case 'a':put(SHI);put(YA_SMALL);break;
		case 'u':put(SHI);put(YU_SMALL);break;
		case 'o':put(SHI);put(YO_SMALL);break;
		case 'y':shy(next());break;
		
		case '@':put("sh");break;
		default:put("sh"+c);
		}
	}
	
	
	
	
	/*
	 * shy
	 */
	private void shy(char c)
	{
		switch(c)
		{
		case 'a':put(SHI);put(YA_SMALL);break;
		case 'u':put(SHI);put(YU_SMALL);break;
		case 'o':put(SHI);put(YO_SMALL);break;
		
		case '@':put("shy");break;
		default:put("shy"+c);
		}
	}
	
	
	/*
	 * ss
	 */
	private void ss(char c)
	{
		switch(c)
		{
		case 'i':put(TSU_SMALL);put(SHI);break;
		case 'a':put(TSU_SMALL);put(SA);break;
		case 'u':put(TSU_SMALL);put(SU);break;
		case 'e':put(TSU_SMALL);put(SE);break;
		case 'o':put(TSU_SMALL);put(SO);break;
		case 'y':ssy(next());break;
		case 'h':ssh(next());break;
		
		case '@':put("ss");break;
		default:put("ss"+c);
		}
	}

	
	/*
	 * ssy
	 */
	private void ssy(char c)
	{
		switch(c)
		{
		case 'a':put(TSU_SMALL);put(SHI);put(YA_SMALL);break;
		case 'u':put(TSU_SMALL);put(SHI);put(YU_SMALL);break;
		case 'o':put(TSU_SMALL);put(SHI);put(YO_SMALL);break;
		
		case '@':put("ssy");break;
		default:put("ssy"+c);
		}
	}
	
	

	
	/*
	 * ssh
	 */
	private void ssh(char c)
	{
		switch(c)
		{
		case 'i':put(TSU_SMALL);put(SHI);break;
		case 'a':put(TSU_SMALL);put(SHI);put(YA_SMALL);break;
		case 'u':put(TSU_SMALL);put(SHI);put(YU_SMALL);break;
		case 'o':put(TSU_SMALL);put(SHI);put(YO_SMALL);break;
		case 'y':sshy(next());break;
		
		case '@':put("ssh");break;
		default:put("ssh"+c);
		}
	}
	
	
	
	
	/*
	 * sshy
	 */
	private void sshy(char c)
	{
		switch(c)
		{
		case 'a':put(TSU_SMALL);put(SHI);put(YA_SMALL);break;
		case 'u':put(TSU_SMALL);put(SHI);put(YU_SMALL);break;
		case 'o':put(TSU_SMALL);put(SHI);put(YO_SMALL);break;
		
		case '@':put("sshy");break;
		default:put("sshy"+c);
		}
	}
	
	
	
	
	/*
	 * z
	 */
	private void z(char c)
	{
		switch(c)
		{
		case 'a':put(ZA);break;
		case 'u':put(ZU);break;
		case 'e':put(ZE);break;
		case 'o':put(ZO);break;
		case 'y':zy(next());break;
		case 'z':zz(next());break;
		
		case '@':put('z');break;
		default:put('z');put(c);
		}
	}
	
	
	
	
	/*
	 * zy
	 */
	private void zy(char c)
	{
		switch(c)
		{
		case 'a':put(JI);put(YA_SMALL);break;
		case 'u':put(JI);put(YU_SMALL);break;
		case 'o':put(JI);put(YO_SMALL);break;
		
		case '@':put("zy");break;
		default:put("zy"+c);
		}
	}
	
	
	
	/*
	 * zz
	 */
	private void zz(char c)
	{
		switch(c)
		{
		case 'i':put(TSU_SMALL);put(SHI);break;
		case 'a':put(TSU_SMALL);put(SA);break;
		case 'u':put(TSU_SMALL);put(SU);break;
		case 'e':put(TSU_SMALL);put(SE);break;
		case 'o':put(TSU_SMALL);put(SO);break;
		case 'y':zzy(next());break;
		
		case '@':put("zz");break;
		default:put("zz"+c);
		}
	}

	
	/*
	 * zzy
	 */
	private void zzy(char c)
	{
		switch(c)
		{
		case 'a':put(TSU_SMALL);put(JI);put(YA_SMALL);break;
		case 'u':put(TSU_SMALL);put(JI);put(YU_SMALL);break;
		case 'o':put(TSU_SMALL);put(JI);put(YO_SMALL);break;
		
		case '@':put("zzy");break;
		default:put("zzy"+c);
		}
	}
	
	
	
	
	
	/*
	 * j
	 */
	private void j(char c)
	{
		switch(c)
		{
		case 'i':put(JI);break;
		case 'a':put(JI);put(YA_SMALL);break;
		case 'u':put(JI);put(YU_SMALL);break;
		case 'o':put(JI);put(YO_SMALL);break;
		case 'y':jy(next());break;
		case 'j':jj(next());break;
		
		case '@':put('j');break;
		default:put('j');put(c);
		}
	}
	
	/*
	 * jy
	 */
	private void jy(char c)
	{
		switch(c)
		{
		case 'a':put(JI);put(YA_SMALL);break;
		case 'u':put(JI);put(YU_SMALL);break;
		case 'o':put(JI);put(YO_SMALL);break;
		
		case '@':put("jy");break;
		default:put("jy"+c);
		}
	}
	
	
	
	/*
	 * jj
	 */
	private void jj(char c)
	{
		switch(c)
		{
		case 'i':put(TSU_SMALL);put(JI);break;
		case 'a':put(TSU_SMALL);put(JI);put(YA_SMALL);break;
		case 'u':put(TSU_SMALL);put(JI);put(YU_SMALL);break;
		case 'e':put(TSU_SMALL);put(JI);put(E_SMALL);break;
		case 'o':put(TSU_SMALL);put(JI);put(YO_SMALL);break;
		case 'y':jjy(next());break;
		
		case '@':put("jj");break;
		default:put("jj"+c);
		}
	}

	
	/*
	 * jjy
	 */
	private void jjy(char c)
	{
		switch(c)
		{
		case 'a':put(TSU_SMALL);put(JI);put(YA_SMALL);break;
		case 'u':put(TSU_SMALL);put(JI);put(YU_SMALL);break;
		case 'o':put(TSU_SMALL);put(JI);put(YO_SMALL);break;
		
		case '@':put("zzy");break;
		default:put("zzy"+c);
		}
	}
	
	
	
	
	/*
	 * t
	 */
	
	private void t(char c)
	{
		switch(c)
		{
		case 'a':put(TA);break;
		case 'i':put(CHI);break;
		case 'u':put(TSU);break;
		case 'e':put(TE);break;
		case 'o':put(TO);break;
		case 's':ts(next());break;
		case 'y':ty(next());break;
		case 'h':th(next());break;
		case 't':tt(next());break;

		case '@':put('t');break;
		default:put('t');put(c);
		}
	}
	
	
	
	/*
	 * ts
	 */
	
	private void ts(char c)
	{
		switch(c)
		{
			case 'u':put(TSU);break;
			
			case '@':put("ts");break;
			default:put("ts"+c);
		}
	}
	
	
	/*
	 * ty
	 */
	private void ty(char c)
	{
		switch(c)
		{
		case 'a':put(CHI);put(YA_SMALL);break;
		case 'u':put(CHI);put(YU_SMALL);break;
		case 'o':put(CHI);put(YO_SMALL);break;
		
		case '@':put("ty");break;
		default:put("ty"+c);
		}
	}
	
	/*
	 * th
	 */
	private void th(char c)
	{
		switch(c)
		{
		case 'a':put(TE);put(A_SMALL);break;
		case 'i':put(TE);put(I_SMALL);break;
		case 'u':put(TE);put(U_SMALL);break;
		case 'e':put(TE);put(E_SMALL);break;
		case 'o':put(TE);put(O_SMALL);break;
		
		case '@':put("th");break;
		default:put("th"+c);
		}
	}
	
	
	/*
	 * tt
	 */
	private void tt(char c)
	{
		switch(c)
		{
		case 'a':put(TSU_SMALL);put(TA);break;
		case 'i':put(TSU_SMALL);put(CHI);break;
		case 'u':put(TSU_SMALL);put(TSU);break;
		case 'e':put(TSU_SMALL);put(TE);break;
		case 'o':put(TSU_SMALL);put(TO);break;
		case 'y':tty(next());break;
		case 'h':tth(next());break;
		case 's':tts(next());break;
		
		case '@':put("tt");break;
		default:put("tt"+c);
		}
	}

	
	/*
	 * tty
	 */
	private void tty(char c)
	{
		switch(c)
		{
		case 'a':put(TSU_SMALL);put(CHI);put(YA_SMALL);break;
		case 'u':put(TSU_SMALL);put(CHI);put(YU_SMALL);break;
		case 'o':put(TSU_SMALL);put(CHI);put(YO_SMALL);break;
		
		case '@':put("tty");break;
		default:put("tty"+c);
		}
	}
	
	
	/*
	 * tth
	 */
	private void tth(char c)
	{
		switch(c)
		{
		case 'a':put(TSU_SMALL);put(TE);put(A_SMALL);break;
		case 'i':put(TSU_SMALL);put(TE);put(I_SMALL);break;
		case 'u':put(TSU_SMALL);put(TE);put(U_SMALL);break;
		case 'e':put(TSU_SMALL);put(TE);put(E_SMALL);break;
		case 'o':put(TSU_SMALL);put(TE);put(O_SMALL);break;
		
		case '@':put("tth");break;
		default:put("tth"+c);
		}
	}
	
	/*
	 * tts
	 */
	
	private void tts(char c)
	{
		switch(c)
		{
			case 'u':put(TSU_SMALL);put(TSU);break;
			
			case '@':put("tts");break;
			default:put("tts"+c);
		}
	}
	
	
	/*
	 * d
	 */
	
	private void d(char c)
	{
		switch(c)
		{
		case 'a':put(DA);break;
		case 'i':put(DJI);break;
		case 'u':put(DZU);break;
		case 'e':put(DE);break;
		case 'o':put(DO);break;
		case 'y':dy(next());break;
		case 'h':dh(next());break;
		case 'z':dz(next());break;
		case 'd':dd(next());break;

		case '@':put('d');break;
		default:put('d');put(c);
		}
	}
	
	
	
	/*
	 * dz
	 */
	private void dz(char c)
	{
		switch(c)
		{
		case 'u':put(DZU);break;

		case '@':put("dz");break;
		default:put("dz"+c);
		}
	}
	
	
	

	/*
	 * dy
	 */
	private void dy(char c)
	{
		switch(c)
		{
		case 'a':put(DJI);put(YA_SMALL);break;
		case 'u':put(DJI);put(YU_SMALL);break;
		case 'o':put(DJI);put(YO_SMALL);break;
		
		case '@':put("dy");break;
		default:put("dy"+c);
		}
	}
	
	
	/*
	 * dh
	 */
	private void dh(char c)
	{
		switch(c)
		{
		case 'a':put(DE);put(A_SMALL);break;
		case 'i':put(DE);put(I_SMALL);break;
		case 'u':put(DE);put(U_SMALL);break;
		case 'e':put(DE);put(E_SMALL);break;
		case 'o':put(DE);put(O_SMALL);break;
		
		case '@':put("dh");break;
		default:put("dh"+c);
		}
	}
	
	/*
	 * dd
	 */
	private void dd(char c)
	{
		switch(c)
		{
		case 'a':put(TSU_SMALL);put(DA);break;
		case 'i':put(TSU_SMALL);put(DJI);break;
		case 'u':put(TSU_SMALL);put(DZU);break;
		case 'e':put(TSU_SMALL);put(DE);break;
		case 'o':put(TSU_SMALL);put(DO);break;
		case 'y':ddy(next());break;
		case 'h':ddh(next());break;
		case 'z':ddz(next());break;
		
		case '@':put("dd");break;
		default:put("dd"+c);
		}
	}

	
	/*
	 * ddh
	 */
	private void ddh(char c)
	{
		switch(c)
		{
		case 'a':put(TSU_SMALL);put(DE);put(A_SMALL);break;
		case 'i':put(TSU_SMALL);put(DE);put(I_SMALL);break;
		case 'u':put(TSU_SMALL);put(DE);put(U_SMALL);break;
		case 'e':put(TSU_SMALL);put(DE);put(E_SMALL);break;
		case 'o':put(TSU_SMALL);put(DE);put(O_SMALL);break;
		
		case '@':put("ddh");break;
		default:put("ddh"+c);
		}
	}
	
	
	/*
	 * ddy
	 */
	private void ddy(char c)
	{
		switch(c)
		{
		case 'a':put(TSU_SMALL);put(DJI);put(YA_SMALL);break;
		case 'u':put(TSU_SMALL);put(DJI);put(YU_SMALL);break;
		case 'o':put(TSU_SMALL);put(DJI);put(YO_SMALL);break;
		
		case '@':put("ddy");break;
		default:put("ddy"+c);
		}
	}
	
	
	/*
	 * ddz
	 */
	private void ddz(char c)
	{
		switch(c)
		{
		case 'u':put(TSU_SMALL);put(DZU);break;

		case '@':put("ddz");break;
		default:put("ddz"+c);
		}
	}
	
	
	
	
	
	/*
	 * m
	 */
	private void m(char c)
	{
		switch(c)
		{
		case 'a':put(MA);break;
		case 'i':put(MI);break;
		case 'u':put(MU);break;
		case 'e':put(ME);break;
		case 'o':put(MO);break;
		case 'y':my(next());break;
		case 'm':mm(next());break;

		case '@':put('m');break;
		default:put('m');put(c);
		}
	}
	
	
	/*
	 * my
	 */
	private void my(char c)
	{
		switch(c)
		{
		case 'a':put(MI);put(YA_SMALL);break;
		case 'u':put(MI);put(YU_SMALL);break;
		case 'o':put(MI);put(YO_SMALL);break;
		
		case '@':put("my");break;
		default:put("my"+c);
		}
	}
	
	
	/*
	 * mm
	 */
	private void mm(char c)
	{
		switch(c)
		{
		case 'a':put(TSU_SMALL);put(MA);break;
		case 'i':put(TSU_SMALL);put(MI);break;
		case 'u':put(TSU_SMALL);put(MU);break;
		case 'e':put(TSU_SMALL);put(ME);break;
		case 'o':put(TSU_SMALL);put(MO);break;
		case 'y':mmy(next());break;
		
		case '@':put("mm");break;
		default:put("mm"+c);
		}
	}

	
	/*
	 * mmy
	 */
	private void mmy(char c)
	{
		switch(c)
		{
		case 'a':put(TSU_SMALL);put(MI);put(YA_SMALL);break;
		case 'u':put(TSU_SMALL);put(MI);put(YU_SMALL);break;
		case 'o':put(TSU_SMALL);put(MI);put(YO_SMALL);break;
		
		case '@':put("mmy");break;
		default:put("mmy"+c);
		}
	}
	
	
	
	
	/*
	 * n
	 */
	private void n(char c)
	{
		switch(c)
		{
		case 'a':put(NA);break;
		case 'i':put(NI);break;
		case 'u':put(NU);break;
		case 'e':put(NE);break;
		case 'o':put(NO);break;
		case 'y':ny(next());break;
		
		case 'k':put(N);k(next());break;
		case 'g':put(N);g(next());break;
		case 's':put(N);s(next());break;
		case 'z':put(N);z(next());break;
		case 'j':put(N);j(next());break;
		case 't':put(N);t(next());break;
		case 'd':put(N);d(next());break;
		case 'm':put(N);m(next());break;
		case 'n':put(N);break;
		case 'r':put(N);r(next());break;
		case 'h':put(N);h(next());break;
		case 'b':put(N);b(next());break;
		case 'p':put(N);p(next());break;
		case 'c':put(N);c(next());break;
		case 'w':put(N);w(next());break;
		case '.':put(N);put(POINT);break;
		case '-':put(N);put(LINE);break;
		
		case '\'':put(N);break;
		case '@':put(N);break;
		default:put(N);put(c);
		}
	}
	
	
	/*
	 * ny
	 */
	private void ny(char c)
	{
		switch(c)
		{
		case 'a':put(NI);put(YA_SMALL);break;
		case 'u':put(NI);put(YU_SMALL);break;
		case 'o':put(NI);put(YO_SMALL);break;
		
		case '@':put("ny");break;
		default:put("ny"+c);
		}
	}
	
	
	
	
	
	
	
	
	/*
	 * r
	 */
	private void r(char c)
	{
		switch(c)
		{
		case 'a':put(RA);break;
		case 'i':put(RI);break;
		case 'u':put(RU);break;
		case 'e':put(RE);break;
		case 'o':put(RO);break;
		case 'y':ry(next());break;
		case 'r':rr(next());break;
		
		case '@':put('r');break;
		default:put('r');put(c);
		}
	}
	
	
	/*
	 * ry
	 */
	private void ry(char c)
	{
		switch(c)
		{
		case 'a':put(RI);put(YA_SMALL);break;
		case 'u':put(RI);put(YU_SMALL);break;
		case 'o':put(RI);put(YO_SMALL);break;
		
		case '@':put("ry");break;
		default:put("ry"+c);
		}
	}
	
	
	/*
	 * rr
	 */
	private void rr(char c)
	{
		switch(c)
		{
		case 'a':put(TSU_SMALL);put(RA);break;
		case 'i':put(TSU_SMALL);put(RI);break;
		case 'u':put(TSU_SMALL);put(RU);break;
		case 'e':put(TSU_SMALL);put(RE);break;
		case 'o':put(TSU_SMALL);put(RO);break;
		case 'y':rry(next());break;
		
		case '@':put("rr");break;
		default:put("rr"+c);
		}
	}

	
	/*
	 * rry
	 */
	private void rry(char c)
	{
		switch(c)
		{
		case 'a':put(TSU_SMALL);put(RI);put(YA_SMALL);break;
		case 'u':put(TSU_SMALL);put(RI);put(YU_SMALL);break;
		case 'o':put(TSU_SMALL);put(RI);put(YO_SMALL);break;
		
		case '@':put("rry");break;
		default:put("rry"+c);
		}
	}
	
	
	
	
	
	/*
	 * h
	 */
	private void h(char c)
	{
		switch(c)
		{
		case 'a':put(HA);break;
		case 'i':put(HI);break;
		case 'u':put(FU);break;
		case 'e':put(HE);break;
		case 'o':put(HO);break;
		case 'y':hy(next());break;
		case 'h':hh(next());break;

		case '@':put('h');break;
		default:put('h');put(c);
		}
	}
	
	
	/*
	 * hy
	 */
	private void hy(char c)
	{
		switch(c)
		{
		case 'a':put(HI);put(YA_SMALL);break;
		case 'u':put(HI);put(YU_SMALL);break;
		case 'o':put(HI);put(YO_SMALL);break;
		
		case '@':put("hy");break;
		default:put("hy"+c);
		}
	}
	
	
	/*
	 * hh
	 */
	private void hh(char c)
	{
		switch(c)
		{
		case 'i':put(TSU_SMALL);put(HI);break;
		case 'a':put(TSU_SMALL);put(HA);break;
		case 'u':put(TSU_SMALL);put(FU);break;
		case 'e':put(TSU_SMALL);put(HE);break;
		case 'o':put(TSU_SMALL);put(HO);break;
		case 'y':hhy(next());break;
		
		case '@':put("hh");break;
		default:put("hh"+c);
		}
	}

	
	/*
	 * ssy
	 */
	private void hhy(char c)
	{
		switch(c)
		{
		case 'a':put(TSU_SMALL);put(HI);put(YA_SMALL);break;
		case 'u':put(TSU_SMALL);put(HI);put(YU_SMALL);break;
		case 'o':put(TSU_SMALL);put(HI);put(YO_SMALL);break;
		
		case '@':put("hhy");break;
		default:put("hhy"+c);
		}
	}
	
	
	
	/*
	 * f
	 */
	private void f(char c)
	{
		switch(c)
		{
		case 'a':put(FU);put(A_SMALL);break;
		case 'i':put(FU);put(I_SMALL);break;
		case 'u':put(FU);break;
		case 'e':put(FU);put(E_SMALL);break;
		case 'o':put(FU);put(O_SMALL);break;
		case 'f':ff(next());break;

		case '@':put('f');break;
		default:put('f');put(c);
		}
	}
	
	
	
	
	/*
	 * ff
	 */
	private void ff(char c)
	{
		switch(c)
		{
		case 'a':put(TSU_SMALL);put(FU);put(A_SMALL);break;
		case 'i':put(TSU_SMALL);put(FU);put(I_SMALL);break;
		case 'u':put(TSU_SMALL);put(FU);break;
		case 'e':put(TSU_SMALL);put(FU);put(E_SMALL);break;
		case 'o':put(TSU_SMALL);put(FU);put(O_SMALL);break;
		
		case '@':put("ff");break;
		default:put("ff"+c);
		}
	}
	
	
	
	/*
	 * b
	 */
	private void b(char c)
	{
		switch(c)
		{
		case 'a':put(BA);break;
		case 'i':put(BI);break;
		case 'u':put(BU);break;
		case 'e':put(BE);break;
		case 'o':put(BO);break;
		case 'y':by(next());break;
		case 'b':bb(next());break;
		
		case '@':put('b');break;
		default:put('b');put(c);
		}
	}
	
	
	/*
	 * by
	 */
	private void by(char c)
	{
		switch(c)
		{
		case 'a':put(BI);put(YA_SMALL);break;
		case 'u':put(BI);put(YU_SMALL);break;
		case 'o':put(BI);put(YO_SMALL);break;
		
		case '@':put("by");break;
		default:put("by"+c);
		}
	}
	
	
	/*
	 * bb
	 */
	private void bb(char c)
	{
		switch(c)
		{
		case 'a':put(TSU_SMALL);put(BA);break;
		case 'i':put(TSU_SMALL);put(BI);break;
		case 'u':put(TSU_SMALL);put(BU);break;
		case 'e':put(TSU_SMALL);put(BE);break;
		case 'o':put(TSU_SMALL);put(BO);break;
		case 'y':bby(next());break;
		
		case '@':put("bb");break;
		default:put("bb"+c);
		}
	}

	
	/*
	 * bby
	 */
	private void bby(char c)
	{
		switch(c)
		{
		case 'a':put(TSU_SMALL);put(BI);put(YA_SMALL);break;
		case 'u':put(TSU_SMALL);put(BI);put(YU_SMALL);break;
		case 'o':put(TSU_SMALL);put(BI);put(YO_SMALL);break;
		
		case '@':put("bby");break;
		default:put("bby"+c);
		}
	}
	
	
	
	
	
	/*
	 * p
	 */
	private void p(char c)
	{
		switch(c)
		{
		case 'a':put(PA);break;
		case 'i':put(PI);break;
		case 'u':put(PU);break;
		case 'e':put(PE);break;
		case 'o':put(PO);break;
		case 'y':py(next());break;
		case 'p':pp(next());break;

		case '@':put('p');break;
		default:put('p');put(c);
		}
	}
	
	
	
	/*
	 * py
	 */
	private void py(char c)
	{
		switch(c)
		{
		case 'a':put(PI);put(YA_SMALL);break;
		case 'u':put(PI);put(YU_SMALL);break;
		case 'o':put(PI);put(YO_SMALL);break;

		case '@':put("py");break;
		default:put("py"+c);
		}
	}
	
	
	/*
	 * pp
	 */
	private void pp(char c)
	{
		switch(c)
		{
		case 'a':put(TSU_SMALL);put(PA);break;
		case 'i':put(TSU_SMALL);put(PI);break;
		case 'u':put(TSU_SMALL);put(PU);break;
		case 'e':put(TSU_SMALL);put(PE);break;
		case 'o':put(TSU_SMALL);put(PO);break;
		case 'y':ppy(next());break;
		
		case '@':put("pp");break;
		default:put("pp"+c);
		}
	}

	
	/*
	 * ppy
	 */
	private void ppy(char c)
	{
		switch(c)
		{
		case 'a':put(TSU_SMALL);put(PI);put(YA_SMALL);break;
		case 'u':put(TSU_SMALL);put(PI);put(YU_SMALL);break;
		case 'o':put(TSU_SMALL);put(PI);put(YO_SMALL);break;
		
		case '@':put("ppy");break;
		default:put("ppy"+c);
		}
	}
	
	
	
	
	/*
	 * w
	 */
	private void w(char c)
	{
		switch(c)
		{
		case 'a':put(WA);break;
		case 'o':put(WO);break;
		case 'e':put(WE);break;
		case 'i':put(WI);break;
		
		case '@':put('w');break;
		default:put('w');put(c);
		}
	}
	
	
	
	
	
	

	
	/*
	 * c
	 */
	private void c(char c)
	{
		switch(c)
		{
		case 'h':ch(next());break;
		case 'c':cc(next());break;
		
		case '@':put('c');break;
		default:put('c');put(c);
		}
	}
	
	
	
	
	/*
	 * ch
	 */
	private void ch(char c)
	{
		switch(c)
		{
		case 'i':put(CHI);break;
		case 'a':put(CHI);put(YA_SMALL);break;
		case 'u':put(CHI);put(YU_SMALL);break;
		case 'e':put(CHI);put(E_SMALL);break;
		case 'o':put(CHI);put(YO_SMALL);break;
		case 'y':chy(next());break;

		case '@':put("ch");break;
		default:put("ch"+c);
		}
	}
	
	
	
	/*
	 * chy
	 */
	private void chy(char c)
	{
		switch(c)
		{
		case 'a':put(CHI);put(YA_SMALL);break;
		case 'u':put(CHI);put(YU_SMALL);break;
		case 'o':put(CHI);put(YO_SMALL);break;
		
		case '@':put("chy");break;
		default:put("chy"+c);
		}
	}

	
	
	/*
	 * c
	 */
	private void cc(char c)
	{
		switch(c)
		{
		case 'h':cch(next());break;
		
		case '@':put("cc");break;
		default:put("cc"+c);
		}
	}
	
	
	
	/*
	 * cch
	 */
	private void cch(char c)
	{
		switch(c)
		{
		case 'i':put(TSU_SMALL);put(CHI);break;
		case 'a':put(TSU_SMALL);put(CHI);put(YA_SMALL);break;
		case 'u':put(TSU_SMALL);put(CHI);put(YU_SMALL);break;
		case 'o':put(TSU_SMALL);put(CHI);put(YO_SMALL);break;
		case 'y':cchy(next());break;

		case '@':put("cch");break;
		default:put("cch"+c);
		}
	}
	
	
	/*
	 * cchy
	 */
	private void cchy(char c)
	{
		switch(c)
		{
		case 'a':put(TSU_SMALL);put(CHI);put(YA_SMALL);break;
		case 'u':put(TSU_SMALL);put(CHI);put(YU_SMALL);break;
		case 'o':put(TSU_SMALL);put(CHI);put(YO_SMALL);break;
		
		case '@':put("cchy");break;
		default:put("cchy"+c);
		}
	}

}
