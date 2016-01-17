package gus06.entity.gus.crypto.pbe.string.encrypt;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150625";}

	
	private Service encrypt;
	private Service toHexa;
	
	
	
	public EntityImpl() throws Exception
	{
		encrypt = Outside.service(this,"gus.crypto.pbe.bytearray.encrypt");
		toHexa = Outside.service(this,"gus.tostring.bytetohexa");
	}

	

	public Object t(Object obj) throws Exception
	{
		T t = (T) encrypt.t(obj);
		return new Encrypter(t);
	}
	
	
	
	
	private class Encrypter implements T
	{
		private T t;
		public Encrypter(T t) {this.t = t;}

		private byte[] en(byte[] input) throws Exception
		{return (byte[]) t.t(input);}
		
		public Object t(Object obj) throws Exception
		{
			String text = (String) obj;
			byte[] b0 = text.getBytes("UTF-8");
			return toHexa.t(en(b0));
		}
	}
	
	private byte[] toHexa(String s) throws Exception
	{return (byte[]) toHexa.t(s);}
}
