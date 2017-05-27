package gus06.entity.gus.sys.clustering1.engine1;

import gus06.framework.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170107";}


	private Service findShortest;

	public EntityImpl() throws Exception
	{
		findShortest = Outside.service(this,"gus.sys.clustering1.distance.shortest");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		List list1 = (List) o[0];
		int target = Integer.parseInt(""+o[1]);
		
		
		List list2a = new ArrayList();
		List list2b = new ArrayList();
		List list2c = new ArrayList();
		
		for(int i=0;i<list1.size();i++)
		{
			Object point = list1.get(i);
			list2a.add(toDD(point));
			list2b.add(toDD(point));
			list2c.add(toSet(i));
		}
		
		while(list2a.size()>target)
		{
			Object[] info = (Object[]) findShortest.t(list2a);
			int n1 = ((Integer) info[0]).intValue();
			int n2 = ((Integer) info[1]).intValue();
			
			double[] sum1 = (double[]) list2b.get(n1);
			double[] sum2 = (double[]) list2b.get(n2);
			double[] sumT = merge(sum1,sum2);
			
			Set set1 = (Set) list2c.get(n1);
			Set set2 = (Set) list2c.get(n2);
			Set setT = merge(set1,set2);
			
			int n1_ = Math.min(n1,n2);
			int n2_ = Math.max(n1,n2);
			
			list2a.remove(n2_);
			list2b.remove(n2_);
			list2c.remove(n2_);
			
			list2a.remove(n1_);
			list2b.remove(n1_);
			list2c.remove(n1_);
			
			list2a.add(centroid(sumT,setT));
			list2b.add(sumT);
			list2c.add(setT);
		}
		
		return new List[]{list2c,list2a};
	}
	
	
	private double[] toDD(Object obj) throws Exception
	{
		if(obj instanceof int[])
		{
			int[] p = (int[]) obj;
			return new double[]{p[0],p[1]};
		}
		if(obj instanceof double[])
		{
			double[] p = (double[]) obj;
			return new double[]{p[0],p[1]};
		}
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	private Set toSet(int i)
	{
		Set s = new HashSet();
		s.add(new Integer(i));
		return s;
	}
	
	
	private double[] merge(double[] d1, double[] d2)
	{
		return new double[]{d1[0]+d2[0],d1[1]+d2[1]};
	}
	
	private Set merge(Set s1, Set s2)
	{
		Set ss = new HashSet();
		ss.addAll(s1);
		ss.addAll(s2);
		return ss;
	}
	
	private double[] centroid(double[] sum, Set set)
	{
		int nb = set.size();
		return new double[]{sum[0]/nb,sum[1]/nb};
	}
}
