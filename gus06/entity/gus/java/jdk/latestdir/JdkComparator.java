package gus06.entity.gus.java.jdk.latestdir;

import java.io.File;
import java.util.Comparator;



public class JdkComparator implements Comparator {

    
    public int compare(Object jdk1, Object jdk2)
    {
        File jdkFile1 = (File) jdk1;
        File jdkFile2 = (File) jdk2;
        
        String jdkVersion1 = jdkFile1.getName().substring(3);
        String jdkVersion2 = jdkFile2.getName().substring(3);
        if(jdkVersion1.equals(jdkVersion2)) return 0;
        
        int[] n1 = parseJavaVersion(jdkVersion1);
        int[] n2 = parseJavaVersion(jdkVersion2);
        
        return compare(n1,n2);
    }
    
    
    
    
    private static int convertToInt(String value)
    {
        try{return Integer.parseInt(value);}
        catch(Exception e){return 0;}
    }
    
    private static int[] parseJavaVersion(String javaVersion)
    {
        String[] info = javaVersion.split("[_\\.-]");
        int[] weigth = new int[info.length];
        for(int i=0;i<info.length;i++)
        weigth[i] = convertToInt(info[i]);
        return weigth;
    }
    
    private static int compare(int[] a, int[] b)
    {
        for(int i=0;i<Math.min(a.length,b.length);i++)
        {
            if(a[i]>b[i]) return 1;
            if(a[i]<b[i]) return -1;
        }
        return 0;
    }
    
}
