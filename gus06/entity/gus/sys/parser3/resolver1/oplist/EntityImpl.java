package gus06.entity.gus.sys.parser3.resolver1.oplist;

import gus06.framework.*;
import java.util.List;
import java.util.ArrayList;

public class EntityImpl implements Entity, G {

	public String creationDate() {return "20160109";}

	
	
	private List list;
	
	
	public EntityImpl() throws Exception
	{
		list = new ArrayList();
		
		// A # B
		add(
			Outside.service(this,"gus.sys.parser3.resolver1.op.binary.perform.cut"),
			Outside.service(this,"gus.sys.parser3.resolver1.op.binary.perform")
		);
		
		// A :: B
		add(
			Outside.service(this,"gus.sys.parser3.resolver1.op.binary.has.cut"),
			Outside.service(this,"gus.sys.parser3.resolver1.op.binary.has")
		);
		
		// A !: B
		add(
			Outside.service(this,"gus.sys.parser3.resolver1.op.binary.hasnot.cut"),
			Outside.service(this,"gus.sys.parser3.resolver1.op.binary.hasnot")
		);
		
		// A ? B : C
		add(
			Outside.service(this,"gus.sys.parser3.resolver1.op.ternary.cut"),
			Outside.service(this,"gus.sys.parser3.resolver1.op.ternary")
		);
		
		// A : B : C
		add(
			Outside.service(this,"gus.sys.parser3.resolver1.op.seq.enu.cut"),
			Outside.service(this,"gus.sys.parser3.resolver1.op.seq.enu")
		);
		
		// A && B && C
		add(
			Outside.service(this,"gus.sys.parser3.resolver1.op.seq.and.cut"),
			Outside.service(this,"gus.sys.parser3.resolver1.op.seq.and")
		);
		
		// A || B || C
		add(
			Outside.service(this,"gus.sys.parser3.resolver1.op.seq.or.cut"),
			Outside.service(this,"gus.sys.parser3.resolver1.op.seq.or")
		);
		
		// A | B | C
		add(
			Outside.service(this,"gus.sys.parser3.resolver1.op.seq.pipe.cut"),
			Outside.service(this,"gus.sys.parser3.resolver1.op.seq.pipe")
		);
		
		// A == B
		add(
			Outside.service(this,"gus.sys.parser3.resolver1.op.binary.equals.cut"),
			Outside.service(this,"gus.sys.parser3.resolver1.op.binary.equals")
		);
		
		// A != B
		add(
			Outside.service(this,"gus.sys.parser3.resolver1.op.binary.diff.cut"),
			Outside.service(this,"gus.sys.parser3.resolver1.op.binary.diff")
		);
		
		// A >= B
		add(
			Outside.service(this,"gus.sys.parser3.resolver1.op.binary.sup1.cut"),
			Outside.service(this,"gus.sys.parser3.resolver1.op.binary.sup1")
		);
		
		// A <= B
		add(
			Outside.service(this,"gus.sys.parser3.resolver1.op.binary.inf1.cut"),
			Outside.service(this,"gus.sys.parser3.resolver1.op.binary.inf1")
		);
		
		// A > B
		add(
			Outside.service(this,"gus.sys.parser3.resolver1.op.binary.sup2.cut"),
			Outside.service(this,"gus.sys.parser3.resolver1.op.binary.sup2")
		);
		
		// A < B
		add(
			Outside.service(this,"gus.sys.parser3.resolver1.op.binary.inf2.cut"),
			Outside.service(this,"gus.sys.parser3.resolver1.op.binary.inf2")
		);
		
		// A + B - C
		add(
			Outside.service(this,"gus.sys.parser3.resolver1.op.seq.sum.cut"),
			Outside.service(this,"gus.sys.parser3.resolver1.op.seq.sum")
		);
		
		// A * B * C
		add(
			Outside.service(this,"gus.sys.parser3.resolver1.op.seq.product.cut"),
			Outside.service(this,"gus.sys.parser3.resolver1.op.seq.product")
		);
		
		// A // B
		add(
			Outside.service(this,"gus.sys.parser3.resolver1.op.binary.div2.cut"),
			Outside.service(this,"gus.sys.parser3.resolver1.op.binary.div2")
		);
		
		// A / B
		add(
			Outside.service(this,"gus.sys.parser3.resolver1.op.binary.div.cut"),
			Outside.service(this,"gus.sys.parser3.resolver1.op.binary.div")
		);
		
		// A % B
		add(
			Outside.service(this,"gus.sys.parser3.resolver1.op.binary.modulo.cut"),
			Outside.service(this,"gus.sys.parser3.resolver1.op.binary.modulo")
		);
		
		// A !^ B
		add(
			Outside.service(this,"gus.sys.parser3.resolver1.op.binary.powernot.cut"),
			Outside.service(this,"gus.sys.parser3.resolver1.op.binary.powernot")
		);
		
		// A ^ B
		add(
			Outside.service(this,"gus.sys.parser3.resolver1.op.binary.power.cut"),
			Outside.service(this,"gus.sys.parser3.resolver1.op.binary.power")
		);
		
		// A . B . C
		add(
			Outside.service(this,"gus.sys.parser3.resolver1.op.seq.point.cut"),
			Outside.service(this,"gus.sys.parser3.resolver1.op.seq.point")
		);
	}
	
	
	public Object g() throws Exception
	{return list;}
	
	
	private void add(T t1, T t2)
	{list.add(new T[]{t1,t2});}
}
