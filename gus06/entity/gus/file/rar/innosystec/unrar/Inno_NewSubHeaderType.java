package gus06.entity.gus.file.rar.innosystec.unrar;

import java.util.Arrays;

public class Inno_NewSubHeaderType {
    
    public static final Inno_NewSubHeaderType SUBHEAD_TYPE_CMT = new Inno_NewSubHeaderType(new byte[]{'C','M','T'});
    public static final Inno_NewSubHeaderType SUBHEAD_TYPE_ACL = new Inno_NewSubHeaderType(new byte[]{'A','C','L'});
    public static final Inno_NewSubHeaderType SUBHEAD_TYPE_STREAM = new Inno_NewSubHeaderType(new byte[]{'S','T','M'});
    public static final Inno_NewSubHeaderType SUBHEAD_TYPE_UOWNER = new Inno_NewSubHeaderType(new byte[]{'U','O','W'});
    public static final Inno_NewSubHeaderType SUBHEAD_TYPE_AV = new Inno_NewSubHeaderType(new byte[]{'A','V'});
    public static final Inno_NewSubHeaderType SUBHEAD_TYPE_RR = new Inno_NewSubHeaderType(new byte[]{'R','R'});
    public static final Inno_NewSubHeaderType SUBHEAD_TYPE_OS2EA = new Inno_NewSubHeaderType(new byte[]{'E','A','2'});
    public static final Inno_NewSubHeaderType SUBHEAD_TYPE_BEOSEA = new Inno_NewSubHeaderType(new byte[]{'E','A','B','E'});
    
    private byte[] headerTypes;
    
    private Inno_NewSubHeaderType(byte[] headerTypes)
    {
        this.headerTypes = headerTypes;
    }
    
    public boolean byteEquals(byte[] toCompare)
    {
        return Arrays.equals(this.headerTypes, toCompare);
    }

    public String toString()
    {
        return new String(this.headerTypes);
    }
}