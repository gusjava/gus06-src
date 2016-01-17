package gus06.entity.gus.file.image.perform.edition1.dialog;

import gus06.framework.*;
import java.awt.image.RenderedImage;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151005";}


	private Service dialogOkCancel;
	private Service imageEditor;


	public EntityImpl() throws Exception
	{
		dialogOkCancel = Outside.service(this,"gus.swing.dialog.blocked1.okcancel");
		imageEditor = Outside.service(this,"*gus.data.editor.renderedimage.editor1");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		RenderedImage image = (RenderedImage) obj;
		
		imageEditor.p(image);
		
		dialogOkCancel.v("width","400");
		dialogOkCancel.v("height","400");
		System.out.println("dialogOkCancel.f");
		boolean ok = dialogOkCancel.f(imageEditor.i());
		
		return ok? imageEditor.g():null;
	}
}
