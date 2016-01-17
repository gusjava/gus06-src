package gus06.entity.gus.file.excel.jxl.sheetjtable.v2;

import gus06.framework.*;
import jxl.Sheet;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150522";}

	public Object t(Object obj) throws Exception
	{return new SheetJTable((Sheet)obj);}
}
