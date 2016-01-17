package gus06.entity.gus.appli.allocinesearch.movie.buildpanel;

import gus06.framework.*;
import java.util.Map;
import javax.swing.JPanel;
import java.awt.BorderLayout;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150210";}
	
	
	public static final String ENTITY = "gus.appli.allocinesearch.movie.buildpanel.holder";
	//public static final String ENTITY = "gus.data.viewer.map";


	private Service formatData;
	private Service newEntity;

	

	public EntityImpl() throws Exception
	{
		formatData = Outside.service(this,"gus.appli.allocinesearch.movie.formatdata");
		newEntity = Outside.service(this,"entitynew");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		Object viewer = newEntity();
		((P)viewer).p(obj);
		return ((I)viewer).i();
	}
	
	
	private Object newEntity() throws Exception
	{return newEntity.t(ENTITY);}
}
