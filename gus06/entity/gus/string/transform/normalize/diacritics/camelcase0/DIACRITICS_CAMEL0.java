package gus06.entity.gus.string.transform.normalize.diacritics.camelcase0;

public class DIACRITICS_CAMEL0 {

	public static String normalize(String s)
	{
		int l = s.length();
		StringBuilder b = new StringBuilder();
		boolean started = false;
		for(int i=0;i<l;i++)
		started = handle(b,s.charAt(i),started);
		return b.toString();
	}
	
	private static boolean handle(StringBuilder b, char c, boolean z)
	{
		switch(c)
		{
		// lowercase
		
		case 'a':b.append(z?'A':'a');break;//a
		case 'b':b.append(z?'B':'b');break;//b
		case 'c':b.append(z?'C':'c');break;//c
		case 'd':b.append(z?'D':'d');break;//d
		case 'e':b.append(z?'E':'e');break;//e
		case 'f':b.append(z?'F':'f');break;//f
		case 'g':b.append(z?'G':'g');break;//g
		case 'h':b.append(z?'H':'h');break;//h
		case 'i':b.append(z?'I':'i');break;//i
		case 'j':b.append(z?'J':'j');break;//j
		case 'k':b.append(z?'K':'k');break;//k
		case 'l':b.append(z?'L':'l');break;//l
		case 'm':b.append(z?'M':'m');break;//m
		case 'n':b.append(z?'N':'n');break;//n
		case 'o':b.append(z?'O':'o');break;//o
		case 'p':b.append(z?'P':'p');break;//p
		case 'q':b.append(z?'Q':'q');break;//q
		case 'r':b.append(z?'R':'r');break;//r
		case 's':b.append(z?'S':'s');break;//s
		case 't':b.append(z?'T':'t');break;//t
		case 'u':b.append(z?'U':'u');break;//u
		case 'v':b.append(z?'V':'v');break;//v
		case 'w':b.append(z?'W':'w');break;//w
		case 'x':b.append(z?'X':'x');break;//x
		case 'y':b.append(z?'Y':'y');break;//y
		case 'z':b.append(z?'Z':'z');break;//z
		
		// uppercase
		
		case 'A':b.append('A');break;//A
		case 'B':b.append('B');break;//B
		case 'C':b.append('C');break;//C
		case 'D':b.append('D');break;//D
		case 'E':b.append('E');break;//E
		case 'F':b.append('F');break;//F
		case 'G':b.append('G');break;//G
		case 'H':b.append('H');break;//H
		case 'I':b.append('I');break;//I
		case 'J':b.append('J');break;//J
		case 'K':b.append('K');break;//K
		case 'L':b.append('L');break;//L
		case 'M':b.append('M');break;//M
		case 'N':b.append('N');break;//N
		case 'O':b.append('O');break;//O
		case 'P':b.append('P');break;//P
		case 'Q':b.append('Q');break;//Q
		case 'R':b.append('R');break;//R
		case 'S':b.append('S');break;//S
		case 'T':b.append('T');break;//T
		case 'U':b.append('U');break;//U
		case 'V':b.append('V');break;//V
		case 'W':b.append('W');break;//W
		case 'X':b.append('X');break;//X
		case 'Y':b.append('Y');break;//Y
		case 'Z':b.append('Z');break;//Z
		
		// digits
		
		case '0':b.append('0');break;//0
		case '1':b.append('1');break;//1
		case '2':b.append('2');break;//2
		case '3':b.append('3');break;//3
		case '4':b.append('4');break;//4
		case '5':b.append('5');break;//5
		case '6':b.append('6');break;//6
		case '7':b.append('7');break;//7
		case '8':b.append('8');break;//8
		case '9':b.append('9');break;//9
		
		// lowercase diacritics
		
		case '\u00e0':b.append(z?'A':'a');break;//� accent grave
		case '\u00e1':b.append(z?'A':'a');break;//� accent aigu
		case '\u00e2':b.append(z?'A':'a');break;//� accent circonflexe
		case '\u00e3':b.append(z?'A':'a');break;//� tilde
		case '\u00e4':b.append(z?'A':'a');break;//� tr�ma
		case '\u00e5':b.append(z?'A':'a');break;//� rond en chef
		case '\u0101':b.append(z?'A':'a');break;//a macron (accent plat)
		case '\u0103':b.append(z?'A':'a');break;//a br�ve (accent goutte)
		case '\u0105':b.append(z?'A':'a');break;//a ogonek (petite queue)
		case '\u1ea1':b.append(z?'A':'a');break;//a point souscrit
		case '\u01ce':b.append(z?'A':'a');break;//a hatchek (accent hirondelle)
		case '\u0227':b.append(z?'A':'a');break;//a point suscrit
		
		case '\u00e6':b.append(z?"Ae":"ae");break;//�
		case '\u01fd':b.append(z?"Ae":"ae");break;//� accent aigu
		case '\u01e3':b.append(z?"Ae":"ae");break;//� macron
		
		case '\u1e03':b.append(z?'B':'b');break;//b point suscrit
		case '\u1e05':b.append(z?'B':'b');break;//b point souscrit
		case '\u0253':b.append(z?'B':'b');break;//b crochet
		
		case '\u00e7':b.append(z?'C':'c');break;//� c�dille
		case '\u0107':b.append(z?'C':'c');break;//c accent aigu
		case '\u0109':b.append(z?'C':'c');break;//c accent circonflexe
		case '\u010b':b.append(z?'C':'c');break;//c point suscrit
		case '\u010d':b.append(z?'C':'c');break;//c hatchek
		case '\u0188':b.append(z?'C':'c');break;//c crochet
		case '\u00f0':b.append(z?'C':'c');break;//� barre
		
		case '\u010f':b.append(z?'D':'d');break;//d hatchek
		case '\u0257':b.append(z?'D':'d');break;//d crochet
		case '\u1e0b':b.append(z?'D':'d');break;//d point suscrit
		case '\u1e0d':b.append(z?'D':'d');break;//d point souscrit
		case '\u1e11':b.append(z?'D':'d');break;//d c�dille
		
		case '\u00e8':b.append(z?'E':'e');break;//� accent grave
		case '\u00e9':b.append(z?'E':'e');break;//� accent aigu
		case '\u00ea':b.append(z?'E':'e');break;//� accent circonflexe
		case '\u00eb':b.append(z?'E':'e');break;//� tr�ma
		case '\u0113':b.append(z?'E':'e');break;//e macron
		case '\u0115':b.append(z?'E':'e');break;//e br�ve
		case '\u0117':b.append(z?'E':'e');break;//e point suscrit
		case '\u0119':b.append(z?'E':'e');break;//e ogonek
		case '\u011b':b.append(z?'E':'e');break;//e hatchek
		case '\u0229':b.append(z?'E':'e');break;//e c�dille
		case '\u1eb9':b.append(z?'E':'e');break;//e point souscrit
		case '\u1ebd':b.append(z?'E':'e');break;//e tilde
		
		case '\u1e1f':b.append(z?'F':'f');break;//f point suscrit
		
		case '\u011d':b.append(z?'G':'g');break;//g accent circonflexe
		case '\u011f':b.append(z?'G':'g');break;//g br�ve
		case '\u0121':b.append(z?'G':'g');break;//g point suscrit
		case '\u0123':b.append(z?'G':'g');break;//g c�dille
		case '\u01e5':b.append(z?'G':'g');break;//g barre
		case '\u01e7':b.append(z?'G':'g');break;//g hatchek
		case '\u0260':b.append(z?'G':'g');break;//g crochet
		case '\u01f5':b.append(z?'G':'g');break;//g accent aigu
		case '\u1e21':b.append(z?'G':'g');break;//g macron
		
		case '\u0125':b.append(z?'H':'h');break;//h accent circonflexe
		case '\u0127':b.append(z?'H':'h');break;//h barre
		case '\u1e23':b.append(z?'H':'h');break;//h point suscrit
		case '\u1e25':b.append(z?'H':'h');break;//h point souscrit
		case '\u1e27':b.append(z?'H':'h');break;//h tr�ma
		case '\u1e29':b.append(z?'H':'h');break;//h c�dille
		case '\u021f':b.append(z?'H':'h');break;//h hatchek
		
		case '\u00ec':b.append(z?'I':'i');break;//� accent grave
		case '\u00ed':b.append(z?'I':'i');break;//� accent aigu
		case '\u00ee':b.append(z?'I':'i');break;//� accent circonflexe
		case '\u00ef':b.append(z?'I':'i');break;//� tr�ma
		case '\u01d0':b.append(z?'I':'i');break;//i hatchek
		case '\u0129':b.append(z?'I':'i');break;//i tilde
		case '\u012b':b.append(z?'I':'i');break;//i macron
		case '\u012d':b.append(z?'I':'i');break;//i br�ve
		case '\u012f':b.append(z?'I':'i');break;//i ogonek
		case '\u1ecb':b.append(z?'I':'i');break;//i point souscrit
		
		case '\u0135':b.append(z?'J':'j');break;//j accent circonflexe
		case '\u01f0':b.append(z?'J':'j');break;//j hatchek
		
		case '\u1e31':b.append(z?'K':'k');break;//k accent aigu
		case '\u1e33':b.append(z?'K':'k');break;//k point souscrit
		case '\u0137':b.append(z?'K':'k');break;//k c�dille
		case '\u0199':b.append(z?'K':'k');break;//k crochet
		case '\u01e9':b.append(z?'K':'k');break;//k hatchek
		
		case '\u1e37':b.append(z?'L':'l');break;//l point souscrit
		case '\u013a':b.append(z?'L':'l');break;//l accent aigu
		case '\u013c':b.append(z?'L':'l');break;//l c�dille
		case '\u013e':b.append(z?'L':'l');break;//l hatchek
		case '\u0142':b.append(z?'L':'l');break;//l barre
		
		case '\u1e3f':b.append(z?'M':'m');break;//m accent aigu
		case '\u1e41':b.append(z?'M':'m');break;//m point suscrit
		case '\u1e43':b.append(z?'M':'m');break;//m point souscrit
		
		case '\u1e45':b.append(z?'N':'n');break;//n point suscrit
		case '\u1e47':b.append(z?'N':'n');break;//n point souscrit
		case '\u01f9':b.append(z?'N':'n');break;//n accent grave
		case '\u00f1':b.append(z?'N':'n');break;//� tilde
		case '\u0144':b.append(z?'N':'n');break;//n accent aigu
		case '\u0146':b.append(z?'N':'n');break;//n c�dille
		case '\u0148':b.append(z?'N':'n');break;//n hatchek
		
		case '\u00f2':b.append(z?'O':'o');break;//� accent grave
		case '\u00f3':b.append(z?'O':'o');break;//� accent aigu
		case '\u00f4':b.append(z?'O':'o');break;//� accent circonflexe
		case '\u00f5':b.append(z?'O':'o');break;//� tilde
		case '\u00f6':b.append(z?'O':'o');break;//� tr�ma
		case '\u00f8':b.append(z?'O':'o');break;//� barre
		case '\u014d':b.append(z?'O':'o');break;//o macron
		case '\u014f':b.append(z?'O':'o');break;//o br�ve
		case '\u0151':b.append(z?'O':'o');break;//o double accent aigu
		case '\u01a1':b.append(z?'O':'o');break;//o corne
		case '\u01d2':b.append(z?'O':'o');break;//o hatchek
		case '\u01eb':b.append(z?'O':'o');break;//o ogonek
		case '\u022f':b.append(z?'O':'o');break;//o point suscrit
		case '\u1ecd':b.append(z?'O':'o');break;//o point souscrit
		
		case '\u0153':b.append(z?"Oe":"oe");break;//�

		case '\u1e55':b.append(z?'P':'p');break;//p accent aigu
		case '\u1e57':b.append(z?'P':'p');break;//p point suscrit
		case '\u01a5':b.append(z?'P':'p');break;//p crochet
		
		case '\u1e59':b.append(z?'R':'r');break;//r point suscrit
		case '\u1e5b':b.append(z?'R':'r');break;//r point souscrit
		case '\u0155':b.append(z?'R':'r');break;//r accent aigu
		case '\u0157':b.append(z?'R':'r');break;//r c�dille
		case '\u0159':b.append(z?'R':'r');break;//r hatchek
		
		case '\u1e61':b.append(z?'S':'s');break;//s point suscrit
		case '\u1e63':b.append(z?'S':'s');break;//s point souscrit
		case '\u015b':b.append(z?'S':'s');break;//s accent aigu
		case '\u015d':b.append(z?'S':'s');break;//s accent circonflexe
		case '\u015f':b.append(z?'S':'s');break;//s c�dille
		case '\u0161':b.append(z?'S':'s');break;//� hatchek
		case '\u0219':b.append(z?'S':'s');break;//s virgule
		
		case '\u1e6b':b.append(z?'T':'t');break;//t point suscrit
		case '\u1e6d':b.append(z?'T':'t');break;//t point souscrit
		case '\u0163':b.append(z?'T':'t');break;//t c�dille
		case '\u0165':b.append(z?'T':'t');break;//t hatchek
		case '\u0167':b.append(z?'T':'t');break;//t barre
		case '\u01ad':b.append(z?'T':'t');break;//t crochet
		case '\u021b':b.append(z?'T':'t');break;//t virgule
		case '\u1e97':b.append(z?'T':'t');break;//t tr�ma
		
		case '\u1ee5':b.append(z?'U':'u');break;//u point souscrit
		case '\u00f9':b.append(z?'U':'u');break;//� accent grave
		case '\u00fa':b.append(z?'U':'u');break;//� accent aigu
		case '\u00fb':b.append(z?'U':'u');break;//� accent circonflexe
		case '\u00fc':b.append(z?'U':'u');break;//� tr�ma
		case '\u0169':b.append(z?'U':'u');break;//u tilde
		case '\u016b':b.append(z?'U':'u');break;//u macron
		case '\u016d':b.append(z?'U':'u');break;//u br�ve
		case '\u016f':b.append(z?'U':'u');break;//u rond en chef
		case '\u0171':b.append(z?'U':'u');break;//u double accent aigu
		case '\u0173':b.append(z?'U':'u');break;//u ogonek
		case '\u01b0':b.append(z?'U':'u');break;//u corne
		case '\u01d4':b.append(z?'U':'u');break;//u hatchek
		
		case '\u1e7d':b.append(z?'V':'v');break;//v tilde
		case '\u1e7f':b.append(z?'V':'v');break;//v point souscrit
		
		case '\u0175':b.append(z?'W':'w');break;//w accent circonflexe
		case '\u1e81':b.append(z?'W':'w');break;//w accent grave
		case '\u1e83':b.append(z?'W':'w');break;//w accent aigu
		case '\u1e85':b.append(z?'W':'w');break;//w tr�ma
		case '\u1e87':b.append(z?'W':'w');break;//w point suscrit
		case '\u1e89':b.append(z?'W':'w');break;//w point souscrit
		case '\u1e98':b.append(z?'W':'w');break;//w rond en chef
		
		case '\u1e8b':b.append(z?'X':'x');break;//x point suscrit
		case '\u1e8d':b.append(z?'X':'x');break;//x tr�ma
		
		case '\u0177':b.append(z?'Y':'y');break;//y accent circonflexe
		case '\u00ff':b.append(z?'Y':'y');break;//� tr�ma
		case '\u00fd':b.append(z?'Y':'y');break;//� accent aigu
		case '\u1e8f':b.append(z?'Y':'y');break;//y point suscrit
		case '\u01b4':b.append(z?'Y':'y');break;//y crochet
		case '\u0233':b.append(z?'Y':'y');break;//y macron
		case '\u1ef5':b.append(z?'Y':'y');break;//y point souscrit
		case '\u1ef9':b.append(z?'Y':'y');break;//y tilde
		case '\u1ef3':b.append(z?'Y':'y');break;//y accent grave
		case '\u1e99':b.append(z?'Y':'y');break;//y rond en chef
		
		case '\u017a':b.append(z?'Z':'z');break;//z accent aigu
		case '\u017c':b.append(z?'Z':'z');break;//z point suscrit
		case '\u017e':b.append(z?'Z':'z');break;//� hatchek
		case '\u01b6':b.append(z?'Z':'z');break;//z barre
		case '\u1e91':b.append(z?'Z':'z');break;//z accent circonflexe
		case '\u1e93':b.append(z?'Z':'z');break;//z point souscrit
		
		// uppercase diacritics
		
		case '\u00c0':b.append('A');break;//� accent grave
		case '\u00c1':b.append('A');break;//� accent aigu
		case '\u00c2':b.append('A');break;//� accent circonflexe
		case '\u00c3':b.append('A');break;//� tilde
		case '\u00c4':b.append('A');break;//� tr�ma
		case '\u00c5':b.append('A');break;//� rond en chef
		case '\u0100':b.append('A');break;//A macron
		case '\u0102':b.append('A');break;//A br�ve
		case '\u0104':b.append('A');break;//A ogonek
		case '\u1ea0':b.append('A');break;//A point souscrit
		case '\u01cd':b.append('A');break;//A hatchek
		case '\u0226':b.append('A');break;//A point suscrit
		
		case '\u00c6':b.append("Ae");break;//�
		case '\u01fc':b.append("Ae");break;//� accent aigu
		case '\u01e2':b.append("Ae");break;//� macron
		
		case '\u0243':b.append('B');break;//B barre
		case '\u1e02':b.append('B');break;//B point suscrit
		case '\u1e04':b.append('B');break;//B point souscrit
		case '\u0181':b.append('B');break;//B crochet
		
		case '\u00c7':b.append('C');break;//� c�dille
		case '\u0106':b.append('C');break;//C accent aigu
		case '\u0108':b.append('C');break;//C accent circonflexe
		case '\u010a':b.append('C');break;//C point suscrit
		case '\u010c':b.append('C');break;//C hatchek
		case '\u0187':b.append('C');break;//C crochet
		
		case '\u00d0':b.append('D');break;//D barre
		case '\u010e':b.append('D');break;//D hatchek
		case '\u018a':b.append('D');break;//D crochet
		case '\u1e0a':b.append('D');break;//D point suscrit
		case '\u1e0c':b.append('D');break;//D point souscrit
		case '\u1e10':b.append('D');break;//D c�dille
		
		case '\u00c8':b.append('E');break;//� accent grave
		case '\u00c9':b.append('E');break;//� accent aigu
		case '\u00ca':b.append('E');break;//� accent circonflexe
		case '\u00cb':b.append('E');break;//� tr�ma
		case '\u0112':b.append('E');break;//E macron
		case '\u0114':b.append('E');break;//E br�ve
		case '\u0116':b.append('E');break;//E point suscrit
		case '\u0118':b.append('E');break;//E ogonek
		case '\u011a':b.append('E');break;//E hatchek
		case '\u0228':b.append('E');break;//E c�dille
		case '\u1eb8':b.append('E');break;//E point souscrit
		case '\u1ebc':b.append('E');break;//E tilde
		
		case '\u1e1e':b.append('F');break;//F point suscrit
		
		case '\u011c':b.append('G');break;//G accent circonflexe
		case '\u011e':b.append('G');break;//G br�ve
		case '\u0120':b.append('G');break;//G point suscrit
		case '\u0122':b.append('G');break;//G c�dille
		case '\u01e4':b.append('G');break;//G barre
		case '\u01e6':b.append('G');break;//G hatchek
		case '\u0193':b.append('G');break;//G crochet
		case '\u01f4':b.append('G');break;//G accent aigu
		case '\u1e20':b.append('G');break;//G macron
		
		case '\u0124':b.append('H');break;//H accent circonflexe
		case '\u0126':b.append('H');break;//H barre
		case '\u1e22':b.append('H');break;//H point suscrit
		case '\u1e24':b.append('H');break;//H point souscrit
		case '\u1e26':b.append('H');break;//H tr�ma
		case '\u1e28':b.append('H');break;//H c�dille
		case '\u021e':b.append('H');break;//H hatchek
		
		case '\u00cc':b.append('I');break;//� accent grave
		case '\u00cd':b.append('I');break;//� accent aigu
		case '\u00ce':b.append('I');break;//� accent circonflexe
		case '\u00cf':b.append('I');break;//� tr�ma
		case '\u01cf':b.append('I');break;//I hatchek
		case '\u0128':b.append('I');break;//I tilde
		case '\u012a':b.append('I');break;//I macron
		case '\u012c':b.append('I');break;//I br�ve
		case '\u012e':b.append('I');break;//I ogonek
		case '\u0130':b.append('I');break;//I point suscrit
		case '\u1eca':b.append('I');break;//I point souscrit
		
		case '\u0134':b.append('J');break;//J accent circonflexe
		
		case '\u1e30':b.append('K');break;//K accent aigu
		case '\u1e32':b.append('K');break;//K point souscrit
		case '\u0136':b.append('K');break;//K c�dille
		case '\u0198':b.append('K');break;//K crochet
		case '\u01e8':b.append('K');break;//K hatchek
		
		case '\u1e36':b.append('L');break;//L point souscrit
		case '\u0139':b.append('L');break;//L accent aigu
		case '\u013b':b.append('L');break;//L c�dille
		case '\u013d':b.append('L');break;//L hatchek
		case '\u0141':b.append('L');break;//L barre
		
		case '\u1e3e':b.append('M');break;//M accent aigu
		case '\u1e40':b.append('M');break;//M point suscrit
		case '\u1e42':b.append('M');break;//M point souscrit
	
		case '\u1e44':b.append('N');break;//N point suscrit
		case '\u1e46':b.append('N');break;//N point souscrit
		case '\u01f8':b.append('N');break;//N accent grave
		case '\u00d1':b.append('N');break;//N tilde
		case '\u0143':b.append('N');break;//N accent aigu
		case '\u0145':b.append('N');break;//N c�dille
		case '\u0147':b.append('N');break;//N hatchek
		
		case '\u00d2':b.append('O');break;//� accent grave
		case '\u00d3':b.append('O');break;//� accent aigu
		case '\u00d4':b.append('O');break;//� accent circonflexe
		case '\u00d5':b.append('O');break;//� tilde
		case '\u00d6':b.append('O');break;//� tr�ma
		case '\u00d8':b.append('O');break;//� barre
		case '\u014c':b.append('O');break;//O macron
		case '\u014e':b.append('O');break;//O br�ve
		case '\u0150':b.append('O');break;//O double accent aigu
		case '\u01a0':b.append('O');break;//O corne
		case '\u01d1':b.append('O');break;//O hatchek
		case '\u01ea':b.append('O');break;//O ogonek
		case '\u022e':b.append('O');break;//O point suscrit
		case '\u1ecc':b.append('O');break;//O point souscrit
		
		case '\u0152':b.append("Oe");break;//�
		
		case '\u1e54':b.append('P');break;//P accent aigu
		case '\u1e56':b.append('P');break;//P point suscrit
		case '\u01a4':b.append('P');break;//P crochet
		
		case '\u1e58':b.append('R');break;//R point suscrit
		case '\u1e5a':b.append('R');break;//R point souscrit
		case '\u0154':b.append('R');break;//R accent aigu
		case '\u0156':b.append('R');break;//R c�dille
		case '\u0158':b.append('R');break;//R hatchek
		
		case '\u1e60':b.append('S');break;//S point suscrit
		case '\u1e62':b.append('S');break;//S point souscrit
		case '\u015a':b.append('S');break;//S accent aigu
		case '\u015c':b.append('S');break;//S accent circonflexe
		case '\u015e':b.append('S');break;//S c�dille
		case '\u0160':b.append('S');break;//S hatchek
		case '\u0218':b.append('S');break;//S virgule
		
		case '\u1e6a':b.append('T');break;//T point suscrit
		case '\u1e6c':b.append('T');break;//T point souscrit
		case '\u0162':b.append('T');break;//T c�dille
		case '\u0164':b.append('T');break;//T hatchek
		case '\u0166':b.append('T');break;//T barre
		case '\u01ac':b.append('T');break;//T crochet
		case '\u021a':b.append('T');break;//T virgule
		
		case '\u1ee4':b.append('U');break;//U point souscrit
		case '\u00d9':b.append('U');break;//� accent grave
		case '\u00da':b.append('U');break;//� accent aigu
		case '\u00db':b.append('U');break;//� accent circonflexe
		case '\u00dc':b.append('U');break;//� tr�ma
		case '\u0168':b.append('U');break;//U tilde
		case '\u016a':b.append('U');break;//U macron
		case '\u016c':b.append('U');break;//U br�ve
		case '\u016e':b.append('U');break;//U rond en chef
		case '\u0170':b.append('U');break;//U double accent aigu
		case '\u0172':b.append('U');break;//U ogonek
		case '\u01af':b.append('U');break;//U corne
		case '\u01d3':b.append('U');break;//U hatchek
		
		case '\u1e7c':b.append('V');break;//V tilde
		case '\u1e7e':b.append('V');break;//V point souscrit
		
		case '\u0174':b.append('W');break;//W accent circonflexe
		case '\u1e80':b.append('W');break;//W accent grave
		case '\u1e82':b.append('W');break;//W accent aigu
		case '\u1e84':b.append('W');break;//W tr�ma
		case '\u1e86':b.append('W');break;//W point suscrit
		case '\u1e88':b.append('W');break;//W point souscrit
		
		case '\u1e8a':b.append('X');break;//X point suscrit
		case '\u1e8c':b.append('X');break;//X tr�ma
		
		case '\u0176':b.append('Y');break;//Y accent circonflexe
		case '\u0178':b.append('Y');break;//� tr�ma
		case '\u00dd':b.append('Y');break;//� accent aigu
		case '\u1e8e':b.append('Y');break;//Y point suscrit
		case '\u01b3':b.append('Y');break;//Y crochet
		case '\u0232':b.append('Y');break;//Y macron
		case '\u1ef4':b.append('Y');break;//Y point souscrit
		case '\u1ef8':b.append('Y');break;//Y tilde
		case '\u1ef2':b.append('Y');break;//Y accent grave
		
		case '\u0179':b.append('Z');break;//Z accent aigu
		case '\u017b':b.append('Z');break;//Z point suscrit
		case '\u017d':b.append('Z');break;//Z hatchek
		case '\u01b5':b.append('Z');break;//Z barre
		case '\u1e90':b.append('Z');break;//Z accent circonflexe
		case '\u1e92':b.append('Z');break;//Z point souscrit
		
		default: return true;
		}
		return false;
	}
}
