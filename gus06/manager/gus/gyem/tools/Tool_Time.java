package gus06.manager.gus.gyem.tools;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Tool_Time {

	
	public static final SimpleDateFormat yyyyMMdd_HHmmss_SS = new SimpleDateFormat("yyyyMMdd_HHmmss_SS");
    public static final SimpleDateFormat yyyyMMdd_HHmmss = new SimpleDateFormat("yyyyMMdd_HHmmss");
    public static final SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyyMMdd");
    public static final SimpleDateFormat yyyyMM = new SimpleDateFormat("yyyyMM");
    public static final SimpleDateFormat yyyy = new SimpleDateFormat("yyyy");
    public static final SimpleDateFormat MM = new SimpleDateFormat("MM");
    public static final SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
    
    public static String yyyyMMdd_HHmmss_SS(Date d)	{return yyyyMMdd_HHmmss_SS.format(d);}
    public static String yyyyMMdd_HHmmss(Date d)	{return yyyyMMdd_HHmmss.format(d);}
    public static String yyyyMMdd(Date d)			{return yyyyMMdd.format(d);}
    public static String yyyyMM(Date d)				{return yyyyMM.format(d);}
    public static String yyyy(Date d)				{return yyyy.format(d);}
    public static String MM(Date d)					{return MM.format(d);}
    public static String sdf1(Date d)				{return sdf1.format(d);}
    
    public static String now_SS()					{return yyyyMMdd_HHmmss_SS(new Date());}
    public static String now()						{return yyyyMMdd_HHmmss(new Date());}
    public static String today()					{return yyyyMMdd(new Date());}
    public static String thisYear()					{return yyyy(new Date());}
    public static String thisMonth()				{return MM(new Date());}
}