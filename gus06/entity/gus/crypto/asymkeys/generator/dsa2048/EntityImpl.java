package gus06.entity.gus.crypto.asymkeys.generator.dsa2048;

import gus06.framework.*;
import java.security.KeyPairGenerator;

public class EntityImpl implements Entity, G {

	public String creationDate() {return "20141005";}

	public static final String ALGO = "DSA"; //Digital Signature Algorithm
	public static final int LENGTH = 2048;
	

	private KeyPairGenerator kpg;
	
	public EntityImpl() throws Exception
	{
		kpg = KeyPairGenerator.getInstance(ALGO);
		kpg.initialize(LENGTH);
	}
	
	
	public Object g() throws Exception
	{return kpg.genKeyPair();}
}
