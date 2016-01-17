package gus06.entity.gus.crypto.asymkeys.privatekey.keyspec.dsa;

import gus06.framework.*;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.DSAPrivateKeySpec;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20141014";}


	private KeyFactory kf;
	
	public EntityImpl() throws Exception
	{
		kf = KeyFactory.getInstance("DSA");
	}
	
	public Object t(Object obj) throws Exception
	{
		PrivateKey key = (PrivateKey) obj;
		return kf.getKeySpec(key,DSAPrivateKeySpec.class);
	}
}
