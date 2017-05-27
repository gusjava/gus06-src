package gus06.entity.gus.string.transform.format.html.decode;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170112";}

	
	
	public Object t(Object obj) throws Exception
	{
		String s = (String) obj;
		
		
		s = r(s,		"&lsquo;","�");
		s = r(s,		"&rsquo;","�");
		
		s = r(s,		"&ldquo;","�");
		s = r(s,		"&rdquo;","�");
		
		
		
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
		
		s = r(s,"&Aacute;",	"&#193;","�");
		s = r(s,"&Acirc;",	"&#194;","�");
		s = r(s,"&Aelig;",	"&#198;","�");
		s = r(s,"&Agrave;",	"&#192;","�");
		s = r(s,"&Aring;",	"&#197;","�");
		s = r(s,"&Atilde;",	"&#195;","�");
		s = r(s,"&Auml;",	"&#196;","�");
		s = r(s,"&Ccedil;",	"&#199;","�");
		s = r(s,"&Yuml;",	"&#159;","�");
		s = r(s,"&acute;",	"&#180;","�");
		s = r(s,"&brvbar;",	"&#166;","�");
		s = r(s,"&cedil;",	"&#184;","�");
		s = r(s,"&cent;",	"&#162;","�");
		s = r(s,"&copy;",	"&#169;","�");
		s = r(s,"&curren;",	"&#164;","�");
		s = r(s,"&deg;",	"&#176;","�");
		s = r(s,"&euro;",	"&#128;","�");
		s = r(s,"&frac12;",	"&#189;","�");
		s = r(s,"&frac14;",	"&#188;","�");
		s = r(s,"&frac34;",	"&#190;","�");
		s = r(s,"&gt;",		"&#155;","�");
		s = r(s,"&iexcl;",	"&#161;","�");
		s = r(s,"&iquest;",	"&#191;","�");
		s = r(s,"&laquo;",	"&#171;","�");
		s = r(s,"&lt;",		"&#139;","�");
		s = r(s,"&masr;",	"&#175;","�");
		s = r(s,"&micro;",	"&#181;","�");
		s = r(s,"&middot;",	"&#183;","�");
		s = r(s,"&nbsp;",	"&#160;"," ");
		s = r(s,"&not;",	"&#172;","�");
		s = r(s,"&para;",	"&#182;","�");
		s = r(s,"&plusmn;",	"&#177;","�");
		s = r(s,"&pound;",	"&#163;","�");
		s = r(s,"&raquo;",	"&#187;","�");
		s = r(s,"&reg;",	"&#174;","�");
		s = r(s,"&sect;",	"&#167;","�");
		s = r(s,"&shy;",	"&#173;","�");
		s = r(s,"&sup1;",	"&#185;","�");
		s = r(s,"&sup2;",	"&#178;","�");
		s = r(s,"&sup3;",	"&#179;","�");
		s = r(s,"&yen;",	"&#165;","�");
		s = r(s,"&uml;",	"&#168;","�");
		s = r(s,"&oelig;",	"&#156;","�");
		s = r(s,"&ordf;",	"&#170;","�");
		s = r(s,"&ordm;",	"&#186;","�");
		
		s = r(s,"&Eacute;",	"&#201;","�");
		s = r(s,"&Ecirc;",	"&#202;","�");
		s = r(s,"&Egrave;",	"&#200;","�");
		s = r(s,"&Euml;",	"&#203;","�");
		s = r(s,"&Iacute;",	"&#205;","�");
		s = r(s,"&Icirc;",	"&#206;","�");
		s = r(s,"&Igrave;",	"&#204;","�");
		s = r(s,"&Iuml;",	"&#207;","�");
		s = r(s,"&Ntilde;",	"&#209;","�");
		s = r(s,"&Oacute;",	"&#211;","�");
		s = r(s,"&Ocirc;",	"&#212;","�");
		s = r(s,"&Ograve;",	"&#210;","�");
		s = r(s,"&Oslash;",	"&#216;","�");
		s = r(s,"&Otilde;",	"&#213;","�");
		s = r(s,"&Ouml;",	"&#214;","�");
		s = r(s,"&Uacute;",	"&#218;","�");
		s = r(s,"&Ucirc;",	"&#219;","�");
		s = r(s,"&Ugrave;",	"&#217;","�");
		s = r(s,"&Uuml;",	"&#220;","�");
		s = r(s,"&Yacute;",	"&#221;","�");
		s = r(s,"&aacute;",	"&#225;","�");
		s = r(s,"&acirc;",	"&#226;","�");
		s = r(s,"&aelig;",	"&#230;","�");
		s = r(s,"&agrave;",	"&#224;","�");
		s = r(s,"&aring;",	"&#229;","�");
		s = r(s,"&atilde;",	"&#227;","�");
		s = r(s,"&auml;",	"&#228;","�");
		s = r(s,"&ccedil;",	"&#231;","�");
		s = r(s,"&divide;",	"&#247;","�");
		s = r(s,"&eacute;",	"&#233;","�");
		s = r(s,"&ecirc;",	"&#234;","�");
		s = r(s,"&egrave;",	"&#232;","�");
		s = r(s,"&eth;",	"&#208;","�");
		s = r(s,"&eth;",	"&#240;","�");
		s = r(s,"&euml;",	"&#235;","�");
		s = r(s,"&iacute;",	"&#237;","�");
		s = r(s,"&icirc;",	"&#238;","�");
		s = r(s,"&igrave;",	"&#236;","�");
		s = r(s,"&iuml;",	"&#239;","�");
		s = r(s,"&ntilde;",	"&#241;","�");
		s = r(s,"&oacute;",	"&#243;","�");
		s = r(s,"&ocirc;",	"&#244;","�");
		s = r(s,"&ograve;",	"&#242;","�");
		s = r(s,"&oslash;",	"&#248;","�");
		s = r(s,"&otilde;",	"&#245;","�");
		s = r(s,"&ouml;",	"&#246;","�");
		s = r(s,"&szlig;",	"&#223;","�");
		s = r(s,"&thorn;",	"&#222;","�");
		s = r(s,"&thorn;",	"&#254;","�");
		s = r(s,"&times;",	"&#215;","�");
		s = r(s,"&uacute;",	"&#250;","�");
		s = r(s,"&ucirc;",	"&#251;","�");
		s = r(s,"&ugrave;",	"&#249;","�");
		s = r(s,"&uuml;",	"&#252;","�");
		s = r(s,"&yacute;",	"&#253;","�");
		s = r(s,"&yuml;",	"&#255;","�");
		
		return s.replaceAll("(?s)\\s+"," ").trim();
	}
	
	
	private String r(String s, String in1, String rep)
	{return s.replace(in1,rep);}
	
	private String r(String s, String in1, String in2, String rep)
	{return s.replace(in1,rep).replace(in2,rep);}
}
