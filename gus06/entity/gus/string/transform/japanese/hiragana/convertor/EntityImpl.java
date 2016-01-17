package gus06.entity.gus.string.transform.japanese.hiragana.convertor;

import gus06.framework.*;

public class EntityImpl extends CodePointsHiragana implements Entity, T {

	public String creationDate() {return "20150305";}

	private StringBuffer input;
	private StringBuffer output;
	
	
	public Object t(Object obj) throws Exception
	{
		String text = (String) obj;
		input = new StringBuffer(text);
		output = new StringBuffer();
		
		while(input.length()>0) handleCodePoint(next());
		return output.toString();
	}
	
	
	private int next()
	{
		if(input.length()==0) return -1;
		
		int codePoint = Character.codePointAt(input,0);
		input.deleteCharAt(0);
		return codePoint;
	}
	
	private void put(String val)
	{output.append(val);}
	
	
	
	private void handleCodePoint(int codePoint)
	{
		if(codePoint==-1)return;
		
		if(codePoint==A){put("a");return;}
		if(codePoint==I){put("i");return;}
		if(codePoint==U){put("u");return;}
		if(codePoint==E){put("e");return;}
		if(codePoint==O){put("o");return;}
		
		if(codePoint==KA){put("ka");return;}
		if(codePoint==KI){ki(next());return;}
		if(codePoint==KU){put("ku");return;}
		if(codePoint==KE){put("ke");return;}
		if(codePoint==KO){put("ko");return;}
		
		if(codePoint==GA){put("ga");return;}
		if(codePoint==GI){gi(next());return;}
		if(codePoint==GU){put("gu");return;}
		if(codePoint==GE){put("ge");return;}
		if(codePoint==GO){put("go");return;}
		
		if(codePoint==MA){put("ma");return;}
		if(codePoint==MI){mi(next());return;}
		if(codePoint==MU){put("mu");return;}
		if(codePoint==ME){put("me");return;}
		if(codePoint==MO){put("mo");return;}
		
		if(codePoint==NA){put("na");return;}
		if(codePoint==NI){ni(next());return;}
		if(codePoint==NU){put("nu");return;}
		if(codePoint==NE){put("ne");return;}
		if(codePoint==NO){put("no");return;}

		if(codePoint==BA){put("ba");return;}
		if(codePoint==BI){bi(next());return;}
		if(codePoint==BU){put("bu");return;}
		if(codePoint==BE){put("be");return;}
		if(codePoint==BO){put("bo");return;}

		if(codePoint==PA){put("pa");return;}
		if(codePoint==PI){pi(next());return;}
		if(codePoint==PU){put("pu");return;}
		if(codePoint==PE){put("pe");return;}
		if(codePoint==PO){put("po");return;}

		if(codePoint==TA){put("ta");return;}
		if(codePoint==CHI){chi(next());return;}
		if(codePoint==TSU){put("tsu");return;}
		if(codePoint==TE){put("te");return;}
		if(codePoint==TO){put("to");return;}

		if(codePoint==DA){put("da");return;}
		if(codePoint==DJI){dji(next());return;}
		if(codePoint==DZU){put("dzu");return;}
		if(codePoint==DE){put("de");return;}
		if(codePoint==DO){put("do");return;}

		if(codePoint==RA){put("ra");return;}
		if(codePoint==RI){ri(next());return;}
		if(codePoint==RU){put("ru");return;}
		if(codePoint==RE){put("re");return;}
		if(codePoint==RO){put("ro");return;}

		if(codePoint==SA){put("sa");return;}
		if(codePoint==SHI){shi(next());return;}
		if(codePoint==SU){put("su");return;}
		if(codePoint==SE){put("se");return;}
		if(codePoint==SO){put("so");return;}

		if(codePoint==ZA){put("za");return;}
		if(codePoint==JI){ji(next());return;}
		if(codePoint==ZU){put("zu");return;}
		if(codePoint==ZE){put("ze");return;}
		if(codePoint==ZO){put("zo");return;}

		if(codePoint==HA){put("ha");return;}
		if(codePoint==HI){hi(next());return;}
		if(codePoint==FU){put("fu");return;}
		if(codePoint==HE){put("he");return;}
		if(codePoint==HO){put("ho");return;}

		if(codePoint==WA){put("wa");return;}
		if(codePoint==WI){put("wi");return;}
		if(codePoint==WE){put("we");return;}
		if(codePoint==WO){put("wo");return;}
		
		if(codePoint==YA){put("ya");return;}
		if(codePoint==YU){put("yu");return;}
		if(codePoint==YO){put("yo");return;}

		if(codePoint==N){put("n");return;}
		if(codePoint==TSU_SMALL){kkk(next());return;}
	}
	
	
	
	
	
	private void ki(int codePoint)
	{
		if(codePoint==YA_SMALL){put("kya");return;}
		if(codePoint==YU_SMALL){put("kyu");return;}
		if(codePoint==YO_SMALL){put("kyo");return;}

		put("ki");
		handleCodePoint(codePoint);
	}
	
	
	private void gi(int codePoint)
	{
		if(codePoint==YA_SMALL){put("gya");return;}
		if(codePoint==YU_SMALL){put("gyu");return;}
		if(codePoint==YO_SMALL){put("gyo");return;}

		put("gi");
		handleCodePoint(codePoint);
	}
	
	
	
	private void hi(int codePoint)
	{
		if(codePoint==YA_SMALL){put("hya");return;}
		if(codePoint==YU_SMALL){put("hyu");return;}
		if(codePoint==YO_SMALL){put("hyo");return;}

		put("hi");
		handleCodePoint(codePoint);
	}
	
	
	private void bi(int codePoint)
	{
		if(codePoint==YA_SMALL){put("bya");return;}
		if(codePoint==YU_SMALL){put("byu");return;}
		if(codePoint==YO_SMALL){put("byo");return;}

		put("bi");
		handleCodePoint(codePoint);
	}
	
	
	private void pi(int codePoint)
	{
		if(codePoint==YA_SMALL){put("pya");return;}
		if(codePoint==YU_SMALL){put("pyu");return;}
		if(codePoint==YO_SMALL){put("pyo");return;}

		put("pi");
		handleCodePoint(codePoint);
	}
	
	
	
	private void mi(int codePoint)
	{
		if(codePoint==YA_SMALL){put("mya");return;}
		if(codePoint==YU_SMALL){put("myu");return;}
		if(codePoint==YO_SMALL){put("myo");return;}

		put("mi");
		handleCodePoint(codePoint);
	}
	
	
	
	private void ni(int codePoint)
	{
		if(codePoint==YA_SMALL){put("nya");return;}
		if(codePoint==YU_SMALL){put("nyu");return;}
		if(codePoint==YO_SMALL){put("nyo");return;}

		put("ni");
		handleCodePoint(codePoint);
	}
	
	
	
	
	private void shi(int codePoint)
	{
		if(codePoint==YA_SMALL){put("sha");return;}
		if(codePoint==YU_SMALL){put("shu");return;}
		if(codePoint==YO_SMALL){put("sho");return;}

		put("shi");
		handleCodePoint(codePoint);
	}
	
	
	
	
	private void chi(int codePoint)
	{
		if(codePoint==YA_SMALL){put("cha");return;}
		if(codePoint==YU_SMALL){put("chu");return;}
		if(codePoint==YO_SMALL){put("cho");return;}

		put("chi");
		handleCodePoint(codePoint);
	}
	
	
	
	private void ji(int codePoint)
	{
		if(codePoint==YA_SMALL){put("ja");return;}
		if(codePoint==YU_SMALL){put("ju");return;}
		if(codePoint==YO_SMALL){put("jo");return;}

		put("ji");
		handleCodePoint(codePoint);
	}
	
	
	
	private void dji(int codePoint)
	{
		if(codePoint==YA_SMALL){put("dja");return;}
		if(codePoint==YU_SMALL){put("dju");return;}
		if(codePoint==YO_SMALL){put("djo");return;}

		put("dji");
		handleCodePoint(codePoint);
	}
	
	
	
	private void ri(int codePoint)
	{
		if(codePoint==YA_SMALL){put("rya");return;}
		if(codePoint==YU_SMALL){put("ryu");return;}
		if(codePoint==YO_SMALL){put("ryo");return;}

		put("ri");
		handleCodePoint(codePoint);
	}
	
	
	
	
	private void kkk(int codePoint)
	{
		if(codePoint==KA){put("kka");return;}
		if(codePoint==KI){put("k");ki(next());return;}
		if(codePoint==KU){put("kku");return;}
		if(codePoint==KE){put("kke");return;}
		if(codePoint==KO){put("kko");return;}
		
		if(codePoint==GA){put("gga");return;}
		if(codePoint==GI){put("g");gi(next());return;}
		if(codePoint==GU){put("ggu");return;}
		if(codePoint==GE){put("gge");return;}
		if(codePoint==GO){put("ggo");return;}
		
		if(codePoint==MA){put("mma");return;}
		if(codePoint==MI){put("m");mi(next());return;}
		if(codePoint==MU){put("mmu");return;}
		if(codePoint==ME){put("mme");return;}
		if(codePoint==MO){put("mmo");return;}
		
		if(codePoint==NA){put("nna");return;}
		if(codePoint==NI){put("n");ni(next());return;}
		if(codePoint==NU){put("nnu");return;}
		if(codePoint==NE){put("nne");return;}
		if(codePoint==NO){put("nno");return;}

		if(codePoint==BA){put("bba");return;}
		if(codePoint==BI){put("b");bi(next());return;}
		if(codePoint==BU){put("bbu");return;}
		if(codePoint==BE){put("bbe");return;}
		if(codePoint==BO){put("bbo");return;}

		if(codePoint==PA){put("ppa");return;}
		if(codePoint==PI){put("p");pi(next());return;}
		if(codePoint==PU){put("ppu");return;}
		if(codePoint==PE){put("ppe");return;}
		if(codePoint==PO){put("ppo");return;}

		if(codePoint==TA){put("tta");return;}
		if(codePoint==CHI){put("c");chi(next());return;}
		if(codePoint==TSU){put("ttsu");return;}
		if(codePoint==TE){put("tte");return;}
		if(codePoint==TO){put("tto");return;}

		if(codePoint==DA){put("dda");return;}
		if(codePoint==DJI){put("d");dji(next());return;}
		if(codePoint==DZU){put("ddzu");return;}
		if(codePoint==DE){put("dde");return;}
		if(codePoint==DO){put("ddo");return;}

		if(codePoint==RA){put("rra");return;}
		if(codePoint==RI){put("r");ri(next());return;}
		if(codePoint==RU){put("rru");return;}
		if(codePoint==RE){put("rre");return;}
		if(codePoint==RO){put("rro");return;}

		if(codePoint==SA){put("ssa");return;}
		if(codePoint==SHI){put("s");shi(next());return;}
		if(codePoint==SU){put("ssu");return;}
		if(codePoint==SE){put("sse");return;}
		if(codePoint==SO){put("sso");return;}

		if(codePoint==ZA){put("zza");return;}
		if(codePoint==JI){put("j");ji(next());return;}
		if(codePoint==ZU){put("zzu");return;}
		if(codePoint==ZE){put("zze");return;}
		if(codePoint==ZO){put("zzo");return;}

		if(codePoint==HA){put("hha");return;}
		if(codePoint==HI){put("h");hi(next());return;}
		if(codePoint==FU){put("ffu");return;}
		if(codePoint==HE){put("hhe");return;}
		if(codePoint==HO){put("hho");return;}
	}
}
