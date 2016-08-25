package gus06.entity.gus.string.transform.regexp.fromrule;

import gus06.framework.*;
import java.util.Map;
import java.util.HashMap;

public class EntityImpl implements Entity, T, R, G {

	public String creationDate() {return "20160425";}
	
	
	public static final String KEY_QUOTE = "\'\'";
	public static final String REGEX_QUOTE = "\'[^\']*\'";
	
	public static final String KEY_QUOTE2 = "\"\"";
	public static final String REGEX_QUOTE2 = "\"[^\"]*\"";
	
	public static final String KEY_SQUARE = "[]";
	public static final String REGEX_SQUARE = "\\[[^\\]]*\\]";
	
	public static final String KEY_CURLY = "{}";
	public static final String REGEX_CURLY = "\\{[^\\}]*\\}";
	
	public static final String KEY_ANGLE = "<>";
	public static final String REGEX_ANGLE = "<[^>]*>";
	
	public static final String KEY_PARENTHESIS = "()";
	public static final String REGEX_PARENTHESIS = "\\([^\\)]*\\)";
	
	
	
	public static final String KEY_EMAIL = "email";
	public static final String REGEX_EMAIL = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}";
	
	public static final String KEY_URL = "url";
	public static final String REGEX_URL = "https?:\\/\\/[a-zA-Z0-9._%+-]+\\.[a-z]{2,4}(\\/[a-zA-Z0-9._%+-]+)*\\/?";
	
	public static final String KEY_TEL = "tel";
	public static final String REGEX_TEL = "(0|\\(33\\))[1-9][\\. -][0-9][0-9][\\. -][0-9][0-9][\\. -][0-9][0-9][\\. -][0-9][0-9]";
	
	public static final String KEY_COUNTRY = "country";
	public static final String REGEX_COUNTRY = "(Afghanistan)|(Afrique du Sud)|(Albanie)|(Algérie)|(Allemagne)|(Andorre)|(Angola)|(Anguilla)|(Antarctique)|(Antigua et Barbuda)|(Antilles Néerlandaises)|(Arabie Saoudite)|(Argentine)|(Arménie)|(Aruba)|(Australie)|(Autriche)|(Azerbaïdjan)|(Bahamas)|(Bahreïn)|(Bangladesh)|(Barbade)|(Belau)|(Belgique)|(Benin)|(Bermudes)|(Bhoutan)|(Biélo-Russie)|(Bolivie)|(Bonaire, Saint-Eustache et Saba)|(Bosnie-Herzégovine)|(Botswana)|(Brunei)|(Brésil)|(Bulgarie)|(Burkina Faso)|(Burundi)|(Bélize)|(Cambodge)|(Cameroun)|(Canada)|(Cap Vert)|(Chili)|(Chine)|(Chypre)|(Colombie)|(Comores)|(Congo)|(Corée du Nord)|(Corée du Sud)|(Costa Rica)|(Croatie)|(Cuba)|(Curaçao)|(Côte d'Ivoire)|(Danemark)|(Djibouti)|(Dominique)|(Dépendances américaines du Pacifique)|(Egypte)|(El Salvador)|(Emirats Arabes Unis)|(Equateur)|(Erythrée)|(Espagne)|(Estonie)|(Etats-Unis)|(Ethiopie)|(Fidji)|(Finlande)|(France)|(Gabon)|(Gambie)|(Ghana)|(Gibraltar)|(Grenade)|(Groenland)|(Grèce)|(Guadeloupe)|(Guam)|(Guatemala)|(Guernesey)|(Guinée Equatoriale)|(Guinée)|(Guinée-Bissau)|(Guyana)|(Guyane française)|(Géorgie du Sud et îles Sandwich du Sud)|(Géorgie)|(Haïti)|(Honduras)|(Hong-Kong)|(Hongrie)|(Ile de Man)|(Iles Vierges Américaines)|(Iles Vierges Britanniques)|(Inde)|(Indonésie)|(Irak)|(Iran)|(Irlande)|(Islande)|(Israël)|(Italie)|(Jamaïque)|(Japon)|(Jersey)|(Jordanie)|(Kazakhstan)|(Kenya)|(Kiribati)|(Koweit)|(Kyrgyzstan)|(La Réunion)|(Laos)|(Lesotho)|(Lettonie)|(Liban)|(Liberia)|(Libye)|(Liechtenstein)|(Lithuanie)|(Luxembourg)|(Macao)|(Macédoine)|(Madagascar)|(Malaisie)|(Malawi)|(Maldives)|(Mali)|(Malte)|(Maroc)|(Martinique)|(Maurice)|(Mauritanie)|(Mayotte)|(Mexique)|(Micronésie)|(Moldavie)|(Monaco)|(Mongolie)|(Montserrat)|(Monténégro)|(Mozambique)|(Myanmar)|(Namibie)|(Nauru)|(Nicaragua)|(Niger)|(Nigéria)|(Niue)|(Norvège)|(Nouvelle-Calédonie)|(Nouvelle-Zélande)|(Népal)|(Oman)|(Ouganda)|(Ouzbékistan)|(Pakistan)|(Palestine)|(Panama)|(Papouasie-Nouvelle-Guinée)|(Paraguay)|(Pays-Bas)|(Philippines)|(Pitcairn)|(Pologne)|(Polynésie Française)|(Porto Rico)|(Portugal)|(Pérou)|(Qatar)|(Roumanie)|(Royaume-Uni)|(Russie)|(Rwanda)|(République Centre-Africaine)|(République Dominicaine)|(République Tchèque)|(République démocratique du Congo)|(Sahara Occidental)|(Saint-Barthélemy)|(Saint-Christophe-et-Niévès)|(Saint-Marin)|(Saint-Martin (partie néerlandaise))|(Saint-Martin)|(Saint-Pierre-et-Miquelon)|(Saint-Vincent-et-les Grenadines)|(Sainte-Hélène)|(Sainte-Lucie)|(Samoa américaines)|(Samoa)|(Sao Tomé et Principe)|(Serbie)|(Seychelles)|(Sierra Leone)|(Singapour)|(Slovaquie)|(Slovénie)|(Somalie)|(Soudan)|(Sri Lanka)|(Sud-Soudan)|(Suisse)|(Suriname)|(Suède)|(Svalbard et Jan Mayen)|(Swaziland)|(Syrie)|(Sénégal)|(Tadjikistan)|(Taiwan)|(Tanzanie)|(Tchad)|(Territoires Français du Sud)|(Territoires britanniques de l'Océan Indien)|(Thaïlande)|(Timor-Leste)|(Togo)|(Tokelau)|(Tonga)|(Trinité-et-Tobago)|(Tunisie)|(Turkménistan)|(Turquie)|(Tuvalu)|(Ukraine)|(Uruguay)|(Vanuatu)|(Vatican)|(Vietnam)|(Vénézuela)|(Wallis-et-Futuna)|(Yémen)|(Zambie)|(Zimbabwe)|(Île Bouvet)|(Île Christmas)|(Île Heard et îles McDonald)|(Île Norfolk)|(Îles Caïmans)|(Îles Cocos)|(Îles Cook)|(Îles Féroé)|(Îles Malouines)|(Îles Mariannes du Nord)|(Îles Marshall)|(Îles Salomon)|(Îles Turks et Caicos)|(Îles Åland)";
	
	public static final String KEY_LANGUAGE = "language";
	public static final String REGEX_LANGUAGE = "(abkhaze)|(afar)|(afrikaans)|(akan)|(albanais)|(allemand)|(amharique)|(anglais)|(arabe)|(aragonais)|(arménien)|(assamais)|(avar)|(avestan)|(aymara)|(azéri)|(bachkir)|(bambara)|(basque)|(bengali)|(bichlamar)|(bihari)|(birman)|(biélorusse)|(bosniaque)|(breton)|(bulgare)|(catalan)|(chamorro)|(chinois)|(cornique)|(corse)|(coréen)|(cri)|(croate)|(créole d'Haïti)|(danois)|(divehi)|(dzongkha)|(ecossais gaélique)|(espagnol)|(espéranto)|(estonien)|(fidjien)|(finnois)|(français)|(frison)|(féroïen)|(galicien)|(galla)|(gallois)|(ganda)|(georgien)|(goudjrati)|(grec)|(groenlandais)|(guarani)|(haoussa)|(herero)|(hindi)|(hiri motu)|(hongrois)|(hébreu)|(ibo)|(ido)|(indonésien)|(interlingua)|(interlingue)|(inuktitut)|(inupiaq)|(irlandais)|(islandais)|(italien)|(japonais)|(javanais)|(kannada)|(kanouri)|(kashmiri)|(kazakh)|(khmer)|(kikuyu)|(kirghize)|(komi)|(kongo)|(kurde)|(kwanyama)|(lao)|(latin)|(letton)|(limbourgeois)|(lingala)|(lithuanien)|(luba-katanga)|(luxembourgeois)|(macédonien)|(malais)|(malayalam)|(malgache)|(maltais)|(manx)|(maori)|(marathe)|(marshall)|(moldave)|(mongol)|(nauruan)|(navaho)|(ndonga)|(ndébélé du Nord)|(ndébélé du Sud)|(norvégien)|(norvégien bokmål)|(norvégien nynorsk)|(nyanja)|(néerlandais)|(népalais)|(occitan)|(ojibwa)|(oriya)|(ossète)|(ourdou)|(ouzbek)|(ouïgour)|(pachto)|(pali)|(pendjabi)|(persan)|(peul)|(polonais)|(portugais)|(quechua)|(rhétoroman)|(roumain)|(rundi)|(russe)|(rwanda)|(sami du Nord)|(samoan)|(sango)|(sanscrit)|(sarde)|(serbe)|(setswana)|(shona)|(sindhi)|(singhalais)|(slavon d'église)|(slovaque)|(slovène)|(somali)|(sotho du sud)|(soundanais)|(suédois)|(swahili)|(swati)|(tadjik)|(tagalog)|(tahitien)|(tamoul)|(tatare)|(tchouvache)|(tchèque)|(tchétchène)|(telugu)|(thaï)|(tibétain)|(tigrigna)|(tonga)|(tsonga)|(turc)|(turkmène)|(twi)|(ukrainien)|(venda)|(vietnamien)|(volapük)|(wallon)|(wolof)|(xhosa)|(yi de Sichuan)|(yiddish)|(yoruba)|(zhuang)|(zoulou)|(éwé)";
	
	public static final String KEY_TITLED = "titled";
	public static final String REGEX_TITLED = "[A-Z][A-Za-z0-9]*";
	
	
	
	public static final String KEY_DIGIT = "digit";
	public static final String REGEX_DIGIT = "[0-9]";
	
	public static final String KEY_NUMBER = "number";
	public static final String REGEX_NUMBER = "[0-9]+";
	
	public static final String KEY_ROMAN_NUMBER = "roman_number";
	public static final String REGEX_ROMAN_NUMBER = "(I)|(II)|(III)|(IV)|(V)|(VI)|(VII)|(VIII)|(IX)|(X)"; // A poursuivre ...
	
	public static final String KEY_HEXA = "hexa";
	public static final String REGEX_HEXA = "[0-9a-fA-F]+";
	
	public static final String KEY_HTML_COLOR = "html_color";
	public static final String REGEX_HTML_COLOR = "#[0-9a-fA-F]{6}";
	
	
	
	public static final String KEY_LOWER = "lower";
	public static final String REGEX_LOWER = "[a-z]+";

	public static final String KEY_LOWER0 = "lower0";
	public static final String REGEX_LOWER0 = "[a-z0-9]+";

	public static final String KEY_LOWER1 = "lower1";
	public static final String REGEX_LOWER1 = "[a-z_]+";

	public static final String KEY_LOWER10 = "lower10";
	public static final String REGEX_LOWER10 = "[a-z0-9_]+";
	
	
	
	public static final String KEY_UPPER = "upper";
	public static final String REGEX_UPPER = "[A-Z]+";

	public static final String KEY_UPPER0 = "upper0";
	public static final String REGEX_UPPER0 = "[A-Z0-9]+";

	public static final String KEY_UPPER1 = "upper0";
	public static final String REGEX_UPPER1 = "[A-Z_]+";

	public static final String KEY_UPPER10 = "upper10";
	public static final String REGEX_UPPER10 = "[A-Z0-9_]+";
	
	

	public static final String KEY_WORD = "word";
	public static final String REGEX_WORD = "[A-Za-z]+";

	public static final String KEY_WORD1 = "word1";
	public static final String REGEX_WORD1 = "[A-Za-z_]+";

	public static final String KEY_K1 = "k1";
	public static final String REGEX_K1 = "([^\\t\\n]*?[^\\s]) *:";

	public static final String KEY_K2 = "k2";
	public static final String REGEX_K2 = "([^\\t\\n]*?[^\\s]) *=";


	public static final String KEY_ALPHANUM = "alphanum";
	public static final String REGEX_ALPHANUM = "[A-Za-z0-9]+";

	public static final String KEY_ALPHANUM1 = "alphanum1";
	public static final String REGEX_ALPHANUM1 = "[A-Za-z0-9_]+";
	
	
	
	public static final String KEY_HIRAGANA = "hiragana";
	public static final String REGEX_HIRAGANA = "\\p{IsHiragana}+";
	
	public static final String KEY_KATAKANA = "katakana";
	public static final String REGEX_KATAKANA = "\\p{IsKatakana}+";

	public static final String KEY_KANJI = "kanji";
	public static final String REGEX_KANJI = "\\p{InCJK_Unified_Ideographs}+";
	
	
	
	public static final String KEY_WHITE = "white";
	public static final String REGEX_WHITE = "\\s+";
	
	public static final String KEY_PUNCT = "punct";
	public static final String REGEX_PUNCT = "\\p{Punct}+";
	
	public static final String KEY_TAB = "tab";
	public static final String REGEX_TAB = "\t+";
	
	public static final String KEY_YEAR = "year";
	public static final String REGEX_YEAR = "[12][0-9]{3}";
	
	public static final String KEY_YEARP = "yearp";
	
	
	public static final String REGEX_99 = "[0-9]{2}";
	public static final String REGEX_DAY = "((0?[1-9])|(1[0-9])|(2[0-9])|(30)|(31))";
	public static final String REGEX_MONTH = "((0?[1-9])|(10)|(11)|(12))";
	public static final String REGEX_YEAR2 = "(("+REGEX_YEAR+")|("+REGEX_99+"))";

	public static final String KEY_MONTH_FR = "month_fr";
	public static final String REGEX_MONTH_FR = REGEX_MONTH+"/"+REGEX_YEAR2; //jj/mm/aaaa
	
	public static final String KEY_DATE_FR = "date_fr";
	public static final String REGEX_DATE_FR = REGEX_DAY+"/"+REGEX_MONTH+"/"+REGEX_YEAR2; //jj/mm/aaaa
	
	public static final String KEY_DATE_EN = "date_en";
	public static final String REGEX_DATE_EN = REGEX_YEAR2+"-"+REGEX_MONTH+"-"+REGEX_DAY; //aaaa-mm-jj
	
	//mm-jj-aa	aaaa-mmm-jj
	
	



	private Service quote;
	private Service regexYearP;
	private Service starPattern;
	
	private Map map;
	

	public EntityImpl() throws Exception
	{
		quote = Outside.service(this,"gus.string.transform.regexp.quote");
		regexYearP = Outside.service(this,"gus.time.regex.year.y1900tothisyear");
		starPattern = Outside.service(this,"gus.string.extract.extract1.pattern.greedy");
		
		map = new HashMap();
		
		map.put(KEY_QUOTE,REGEX_QUOTE);
		map.put(KEY_QUOTE2,REGEX_QUOTE2);
		map.put(KEY_SQUARE,REGEX_SQUARE);
		map.put(KEY_CURLY,REGEX_CURLY);
		map.put(KEY_ANGLE,REGEX_ANGLE);
		map.put(KEY_PARENTHESIS,REGEX_PARENTHESIS);
		
		map.put(KEY_EMAIL,REGEX_EMAIL);
		map.put(KEY_URL,REGEX_URL);
		map.put(KEY_TEL,REGEX_TEL);
		map.put(KEY_COUNTRY,REGEX_COUNTRY);
		map.put(KEY_LANGUAGE,REGEX_LANGUAGE);
		map.put(KEY_TITLED,REGEX_TITLED);
		
		map.put(KEY_DIGIT,REGEX_DIGIT);
		map.put(KEY_NUMBER,REGEX_NUMBER);
		map.put(KEY_HEXA,REGEX_HEXA);
		map.put(KEY_HTML_COLOR,REGEX_HTML_COLOR);
		
		map.put(KEY_LOWER,REGEX_LOWER);
		map.put(KEY_LOWER0,REGEX_LOWER0);
		map.put(KEY_LOWER1,REGEX_LOWER1);
		map.put(KEY_LOWER10,REGEX_LOWER10);
		
		map.put(KEY_UPPER,REGEX_UPPER);
		map.put(KEY_UPPER0,REGEX_UPPER0);
		map.put(KEY_UPPER1,REGEX_UPPER1);
		map.put(KEY_UPPER10,REGEX_UPPER10);
		
		map.put(KEY_WORD,REGEX_WORD);
		map.put(KEY_WORD1,REGEX_WORD1);
		
		map.put(KEY_K1,REGEX_K1);
		map.put(KEY_K2,REGEX_K2);
		
		map.put(KEY_ALPHANUM,REGEX_ALPHANUM);
		map.put(KEY_ALPHANUM1,REGEX_ALPHANUM1);
		
		map.put(KEY_HIRAGANA,REGEX_HIRAGANA);
		map.put(KEY_KATAKANA,REGEX_KATAKANA);
		map.put(KEY_KANJI,REGEX_KANJI);
		
		map.put(KEY_WHITE,REGEX_WHITE);
		map.put(KEY_PUNCT,REGEX_PUNCT);
		map.put(KEY_TAB,REGEX_TAB);
		
		map.put(KEY_YEAR,REGEX_YEAR);
		map.put(KEY_YEARP,regexYearP.g());
		
		map.put(KEY_MONTH_FR,REGEX_MONTH_FR);
		map.put(KEY_DATE_FR,REGEX_DATE_FR);
		map.put(KEY_DATE_EN,REGEX_DATE_EN);
	}
	
	
	
	public Object g() throws Exception
	{return map;}
	
	
	public Object r(String key) throws Exception
	{return t(key);}
	
	
	public Object t(Object obj) throws Exception
	{
		String rule = (String) obj;
		
		if(map.containsKey(rule))
			return map.get(rule);
		
		if(rule.startsWith("chars:"))
		{
			String s = rule.split(":",2)[1];
			String s_ = (String) quote.t(s);
			return "["+s_+"]+";
		}
		if(rule.startsWith("words:"))
		{
			String s = rule.split(":",2)[1];
			String s_ = (String) quote.t(s);
			return s_.replace(" ","|");
		}
		if(rule.startsWith("words_i:"))
		{
			String s = rule.split(":",2)[1];
			String s_ = (String) quote.t(s);
			return "(?i)"+s_.replace(" ","|");
		}
		if(rule.startsWith("star:"))
		{
			String s = rule.split(":",2)[1];
			return ""+starPattern.t(s);
		}
		if(rule.startsWith("starf:"))
		{
			String s = rule.split(":",2)[1];
			return "("+starPattern.t(s)+")";
		}
		if(rule.startsWith("regex:"))
		{
			return rule.split(":",2)[1];
		}
		if(rule.startsWith("regexf:"))
		{
			return "("+rule.split(":",2)[1]+")";
		}
		
		// unicode
		// japanese
		// kanji
		// punctuation
		// filepath
		// package
		
		//stars: coucou (*) et [*]
		//mask: ....
		
		throw new Exception("Invalid rule: "+rule);
	}
}
