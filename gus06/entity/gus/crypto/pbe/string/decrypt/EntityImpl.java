package gus06.entity.gus.crypto.pbe.string.decrypt;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150613";}

	
	private Service decrypt;
	private Service toByteArray;
	
	
	
	public EntityImpl() throws Exception
	{
		decrypt = Outside.service(this,"gus.crypto.pbe.bytearray.decrypt");
		toByteArray = Outside.service(this,"gus.convert.stringtobytearray.hexa");
	}

	

	public Object t(Object obj) throws Exception
	{
		T t = (T) decrypt.t(obj);
		return new Decrypter(t);
	}
	
	
	
	
	private class Decrypter implements T
	{
		private T t;
		public Decrypter(T t) {this.t = t;}

		private byte[] de(byte[] input) throws Exception
		{return (byte[]) t.t(input);}
		
		public Object t(Object obj) throws Exception
		{
			String text = (String) obj;
			byte[] b0 = toByteArray(text);
			return new String(de(b0),"UTF-8");
		}
	}
	
	private byte[] toByteArray(String s) throws Exception
	{return (byte[]) toByteArray.t(s);}
}
