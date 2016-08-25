package gus06.entity.gus.file.read.string.from.docx;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160711";}


	private Service textFromWord;


	public EntityImpl() throws Exception
	{
		textFromWord = Outside.service(this,"gus.file.word.poi.docx.extract.text");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		return textFromWord.t(obj);
	}
}
