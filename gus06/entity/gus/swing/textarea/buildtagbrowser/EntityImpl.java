package gus06.entity.gus.swing.textarea.buildtagbrowser;

import gus06.framework.*;
import javax.swing.JTextArea;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20161021";}

	
	public Object t(Object obj) throws Exception
	{
		return new TagJTree((JTextArea)obj);
	}
}
