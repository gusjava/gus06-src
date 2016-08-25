package gus06.entity.gus.jdbc.mysql.perform.table.create1;

import gus06.framework.*;
import java.sql.Connection;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20160409";}


	private Service createTable;


	public EntityImpl() throws Exception
	{
		createTable = Outside.service(this,"gus.jdbc.mysql.perform.table.create");
	}
	
	
	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=3) throw new Exception("Wrong data number: "+o.length);
		
		Connection cx = (Connection) o[0];
		String path = (String) o[1];
		Map map = (Map) o[2];
		
		List fields = new ArrayList(map.keySet());
		Collections.sort(fields);
		int nb = fields.size();
		
		List pkList = new ArrayList();
		String[] col = new String[nb];
		String[] type = new String[nb];
		
		for(int i=0;i<nb;i++)
		{
			String key = (String) fields.get(i);
			String value = (String) map.get(key);
			String[] n = value.split("[ \t]+");
			
			StringBuffer b = new StringBuffer(n[0]);
			String infos = n.length>1?n[1]:null;
			String dvalue = n.length>2?n[2]:null;
			
			if(infos.contains("0")) b.append(" NULL");
			else if(infos.contains("1")) b.append(" NOT NULL");
			
			if(dvalue!=null) b.append(" default "+dvalue);
			if(infos.contains("+")) b.append(" auto_increment");
			
			col[i] = key;
			type[i] = b.toString();
			if(infos.contains("*")) pkList.add(key);
		}
		
		String[] primary = new String[pkList.size()];
		pkList.toArray(primary);
		
		createTable.p(new Object[]{cx,path,col,type,primary});
	}
}
