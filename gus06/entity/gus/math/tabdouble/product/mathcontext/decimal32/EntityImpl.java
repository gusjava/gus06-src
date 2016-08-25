package gus06.entity.gus.math.tabdouble.product.mathcontext.decimal32;

import gus06.framework.*;
import java.math.BigDecimal;
import java.math.MathContext;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160711";}

	
	public Object t(Object obj) throws Exception
	{
		double[] dd = (double[]) obj;
		BigDecimal product = new BigDecimal(1);
		for(double d:dd) product = product.multiply(new BigDecimal(d), MathContext.DECIMAL32);
		return new Double(product.doubleValue());
	}
}
