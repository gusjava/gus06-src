package gus06.entity.gus.crypto.pbe.secretkey.builder;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150613";}

	public static final String ALGO = "PBEWithMD5AndDES";

	private SecretKeyFactory keyFactory;
	
	public EntityImpl() throws Exception
	{keyFactory = SecretKeyFactory.getInstance(ALGO);}

	public Object t(Object obj) throws Exception
	{
		String password = (String) obj;
		PBEKeySpec keySpec = new PBEKeySpec(password.toCharArray());
		return keyFactory.generateSecret(keySpec);
	}
}