package gus06.entity.gus.dir.runtask.corpus.filesdico1.r.scandir.choose;

import gus06.framework.*;
import java.io.File;
import java.util.Map;
import java.util.HashMap;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20170109";}
	
	public static final String KEY_FILEPATH = "file.path";
	public static final String KEY_FILEPATH0 = "file.path0";


	private Service runtask2;
	private Service chooseDir;
	private Service abslocation;
	private Service findLatest;
	
	public EntityImpl() throws Exception
	{
		runtask2 = Outside.service(this,"gus.dir.runtask2.report.filesdico1.r");
		chooseDir = Outside.service(this,"gus.file.choose.open.dir");
		abslocation = Outside.service(this,"gus.dirfile.find.abslocation");
		findLatest = Outside.service(this,"gus.dir.timestampedname.latest");
	}

	
	
	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=3) throw new Exception("Wrong data number: "+o.length);
		
		File dir = (File) o[0];
		Object progress = o[1];
		Set interrupt = (Set) o[2];
		
		File targetDir = (File) chooseDir.g();
		if(targetDir==null) return;
		
		String location = (String) abslocation.t(targetDir);
		String part1 = location+".txt";
		
		File f0 = (File) findLatest.t(new Object[]{dir,part1});
		File f = new File(dir,now()+"_"+part1);
		
		Map map = new HashMap();
		map.put(KEY_FILEPATH,f.getAbsolutePath());
		
		if(f0!=null && f0.isFile())
		map.put(KEY_FILEPATH0,f0.getAbsolutePath());
		
		runtask2.p(new Object[]{map,targetDir,progress,interrupt});
	}
	
	
	
	
	
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
	
	private String now() throws Exception
	{return sdf.format(new Date());}
}
