package gus06.entity.gus.string.transform.format.html.decode;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170112";}

	
	
	public Object t(Object obj) throws Exception
	{
		String s = (String) obj;
		
		
		s = r(s,		"&lsquo;","‘");
		s = r(s,		"&rsquo;","’");
		
		s = r(s,		"&ldquo;","“");
		s = r(s,		"&rdquo;","”");
		
		
		
		s = r(s,		"&#33;","!");
		s = r(s,"&quot;",	"&#34;","\"");
		s = r(s,		"&#35;","#");
		s = r(s,"&amp;",	"&#38;","&");
		s = r(s,"&apos;",	"&#39;","'");
		s = r(s,		"&#40;","(");
		s = r(s,		"&#41;",")");
		s = r(s,		"&#42;","*");
		s = r(s,"&sbquo;",	"&#44;",",");
		s = r(s,		"&#45;","-");
		s = r(s,		"&#46;",".");
		s = r(s,		"&#47;","/");
		s = r(s,		"&#58;",":");
		s = r(s,		"&#59;",";");
		s = r(s,		"&#61;","=");
		s = r(s,		"&#63;","?");
		s = r(s,		"&#91;","[");
		s = r(s,		"&#92;","\\");
		s = r(s,		"&#93;","]");
		
		s = r(s,		"&#033;","!");
		s = r(s,"&quot;",	"&#034;","\"");
		s = r(s,		"&#035;","#");
		s = r(s,"&amp;",	"&#038;","&");
		s = r(s,"&apos;",	"&#039;","'");
		s = r(s,		"&#040;","(");
		s = r(s,		"&#041;",")");
		s = r(s,		"&#042;","*");
		s = r(s,"&sbquo;",	"&#044;",",");
		s = r(s,		"&#045;","-");
		s = r(s,		"&#046;",".");
		s = r(s,		"&#047;","/");
		s = r(s,		"&#058;",":");
		s = r(s,		"&#059;",";");
		s = r(s,		"&#061;","=");
		s = r(s,		"&#063;","?");
		s = r(s,		"&#091;","[");
		s = r(s,		"&#092;","\\");
		s = r(s,		"&#093;","]");
		
		s = r(s,"&Aacute;",	"&#193;","Á");
		s = r(s,"&Acirc;",	"&#194;","Â");
		s = r(s,"&Aelig;",	"&#198;","Æ");
		s = r(s,"&Agrave;",	"&#192;","À");
		s = r(s,"&Aring;",	"&#197;","Å");
		s = r(s,"&Atilde;",	"&#195;","Ã");
		s = r(s,"&Auml;",	"&#196;","Ä");
		s = r(s,"&Ccedil;",	"&#199;","Ç");
		s = r(s,"&Yuml;",	"&#159;","Ÿ");
		s = r(s,"&acute;",	"&#180;","´");
		s = r(s,"&brvbar;",	"&#166;","¦");
		s = r(s,"&cedil;",	"&#184;","¸");
		s = r(s,"&cent;",	"&#162;","¢");
		s = r(s,"&copy;",	"&#169;","©");
		s = r(s,"&curren;",	"&#164;","¤");
		s = r(s,"&deg;",	"&#176;","°");
		s = r(s,"&euro;",	"&#128;","€");
		s = r(s,"&frac12;",	"&#189;","½");
		s = r(s,"&frac14;",	"&#188;","¼");
		s = r(s,"&frac34;",	"&#190;","¾");
		s = r(s,"&gt;",		"&#155;","›");
		s = r(s,"&iexcl;",	"&#161;","¡");
		s = r(s,"&iquest;",	"&#191;","¿");
		s = r(s,"&laquo;",	"&#171;","«");
		s = r(s,"&lt;",		"&#139;","‹");
		s = r(s,"&masr;",	"&#175;","¯");
		s = r(s,"&micro;",	"&#181;","µ");
		s = r(s,"&middot;",	"&#183;","·");
		s = r(s,"&nbsp;",	"&#160;"," ");
		s = r(s,"&not;",	"&#172;","¬");
		s = r(s,"&para;",	"&#182;","¶");
		s = r(s,"&plusmn;",	"&#177;","±");
		s = r(s,"&pound;",	"&#163;","£");
		s = r(s,"&raquo;",	"&#187;","»");
		s = r(s,"&reg;",	"&#174;","®");
		s = r(s,"&sect;",	"&#167;","§");
		s = r(s,"&shy;",	"&#173;","­");
		s = r(s,"&sup1;",	"&#185;","¹");
		s = r(s,"&sup2;",	"&#178;","²");
		s = r(s,"&sup3;",	"&#179;","³");
		s = r(s,"&yen;",	"&#165;","¥");
		s = r(s,"&uml;",	"&#168;","¨");
		s = r(s,"&oelig;",	"&#156;","œ");
		s = r(s,"&ordf;",	"&#170;","ª");
		s = r(s,"&ordm;",	"&#186;","º");
		
		s = r(s,"&Eacute;",	"&#201;","É");
		s = r(s,"&Ecirc;",	"&#202;","Ê");
		s = r(s,"&Egrave;",	"&#200;","È");
		s = r(s,"&Euml;",	"&#203;","Ë");
		s = r(s,"&Iacute;",	"&#205;","Í");
		s = r(s,"&Icirc;",	"&#206;","Î");
		s = r(s,"&Igrave;",	"&#204;","Ì");
		s = r(s,"&Iuml;",	"&#207;","Ï");
		s = r(s,"&Ntilde;",	"&#209;","Ñ");
		s = r(s,"&Oacute;",	"&#211;","Ó");
		s = r(s,"&Ocirc;",	"&#212;","Ô");
		s = r(s,"&Ograve;",	"&#210;","Ò");
		s = r(s,"&Oslash;",	"&#216;","Ø");
		s = r(s,"&Otilde;",	"&#213;","Õ");
		s = r(s,"&Ouml;",	"&#214;","Ö");
		s = r(s,"&Uacute;",	"&#218;","Ú");
		s = r(s,"&Ucirc;",	"&#219;","Û");
		s = r(s,"&Ugrave;",	"&#217;","Ù");
		s = r(s,"&Uuml;",	"&#220;","Ü");
		s = r(s,"&Yacute;",	"&#221;","Ý");
		s = r(s,"&aacute;",	"&#225;","á");
		s = r(s,"&acirc;",	"&#226;","â");
		s = r(s,"&aelig;",	"&#230;","æ");
		s = r(s,"&agrave;",	"&#224;","à");
		s = r(s,"&aring;",	"&#229;","å");
		s = r(s,"&atilde;",	"&#227;","ã");
		s = r(s,"&auml;",	"&#228;","ä");
		s = r(s,"&ccedil;",	"&#231;","ç");
		s = r(s,"&divide;",	"&#247;","÷");
		s = r(s,"&eacute;",	"&#233;","é");
		s = r(s,"&ecirc;",	"&#234;","ê");
		s = r(s,"&egrave;",	"&#232;","è");
		s = r(s,"&eth;",	"&#208;","Ð");
		s = r(s,"&eth;",	"&#240;","ð");
		s = r(s,"&euml;",	"&#235;","ë");
		s = r(s,"&iacute;",	"&#237;","í");
		s = r(s,"&icirc;",	"&#238;","î");
		s = r(s,"&igrave;",	"&#236;","ì");
		s = r(s,"&iuml;",	"&#239;","ï");
		s = r(s,"&ntilde;",	"&#241;","ñ");
		s = r(s,"&oacute;",	"&#243;","ó");
		s = r(s,"&ocirc;",	"&#244;","ô");
		s = r(s,"&ograve;",	"&#242;","ò");
		s = r(s,"&oslash;",	"&#248;","ø");
		s = r(s,"&otilde;",	"&#245;","õ");
		s = r(s,"&ouml;",	"&#246;","ö");
		s = r(s,"&szlig;",	"&#223;","ß");
		s = r(s,"&thorn;",	"&#222;","Þ");
		s = r(s,"&thorn;",	"&#254;","þ");
		s = r(s,"&times;",	"&#215;","×");
		s = r(s,"&uacute;",	"&#250;","ú");
		s = r(s,"&ucirc;",	"&#251;","û");
		s = r(s,"&ugrave;",	"&#249;","ù");
		s = r(s,"&uuml;",	"&#252;","ü");
		s = r(s,"&yacute;",	"&#253;","ý");
		s = r(s,"&yuml;",	"&#255;","ÿ");
		
		return s.replaceAll("(?s)\\s+"," ").trim();
	}
	
	
	private String r(String s, String in1, String rep)
	{return s.replace(in1,rep);}
	
	private String r(String s, String in1, String in2, String rep)
	{return s.replace(in1,rep).replace(in2,rep);}
}
