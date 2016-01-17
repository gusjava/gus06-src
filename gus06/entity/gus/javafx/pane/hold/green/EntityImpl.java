package gus06.entity.gus.javafx.pane.hold.green;

import gus06.framework.*;
import javafx.scene.layout.Pane;

public class EntityImpl implements Entity, I {

	public String creationDate() {return "20150913";}
	
	private Pane pane;

	
	public EntityImpl() throws Exception
	{
		pane = new Pane();
		pane.setStyle("-fx-background-color: green;");
	}
	
	
	public Object i() throws Exception
	{return pane;}
}
