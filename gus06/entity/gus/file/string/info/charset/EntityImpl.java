package gus06.entity.gus.file.string.info.charset;

import gus06.framework.*;

import java.io.File;
import java.io.FileInputStream;
import java.nio.charset.Charset;
import org.mozilla.universalchardet.UniversalDetector;


public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150822";}
	
	public Object t(Object obj) throws Exception
	{
		File file = (File) obj;
		if(!file.isFile()) return null;
		
		FileInputStream fis = new FileInputStream(file);
		UniversalDetector detector = new UniversalDetector(null);

		byte[] buf = new byte[4096];
		int nread;
		
		while((nread = fis.read(buf)) > 0 && !detector.isDone())
		detector.handleData(buf, 0, nread);
		
		detector.dataEnd();
		fis.close();

		String name = detector.getDetectedCharset();
		
		detector.reset();
		if(name==null) return Charset.defaultCharset();
		
		// BUG de détection quand on a un fichier texte windows-1252 avec des éé
		if(name.equals("WINDOWS-1255")) name = "WINDOWS-1252";
		
		try{return Charset.forName(name);}
		catch(Exception e)
		{
    			String message = "Charset not found for name: "+name;
    			Outside.err(this,"t(Object)",new Exception(message,e));
    			return Charset.defaultCharset();
		}
	}
}
