package gus06.entity.gus.list.map.builder1;

import gus06.framework.*;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Collection;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160816";}


	private Service findObjectArray;
	private Service findStringArray;


	public EntityImpl() throws Exception
	{
		findObjectArray = Outside.service(this,"gus.find.objectarray");
		findStringArray = Outside.service(this,"gus.find.stringarray");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		String[] col = (String[]) findStringArray.t(obj);
		return new List1(col);
	}
	
	
	
	private Map toMap(String[] col, Object obj) throws Exception
	{
		if(obj instanceof Map) return (Map) obj;
		
		Map m = new HashMap();
		
		Object[] values = (Object[]) findObjectArray.t(obj);
		if(values.length!=col.length)
			throw new Exception("Invalid array size: "+values.length+" (column number="+col.length+")");
		
		int nb = values.length;
		for(int i=0;i<nb;i++) m.put(col[i],values[i]);
		return m;
	}
	
	
	
	private class List1 implements List, P
	{
		private List l;
		private String[] col;
		
		public List1(String[] col)
		{
			this.col = col;
			l = new ArrayList();
		}
		
		public void p(Object obj) throws Exception
		{
			Map map = toMap(col,obj);
			l.add(map);
		}
		
		public int size()
		{return l.size();}
		
		public boolean isEmpty()
		{return l.isEmpty();}
		
		public void clear()
		{l.clear();}
		
		public boolean add(Object obj)
		{return l.add(obj);}
		
		public void add(int index, Object element)
		{l.add(index,element);}
		
		public boolean addAll(Collection c)
		{return l.addAll(c);}
		
		public boolean addAll(int index, Collection c)
		{return l.addAll(c);}
		
		public boolean contains(Object o)
		{return l.contains(o);}
		
		public boolean containsAll(Collection c)
		{return l.containsAll(c);}
		
		public Object get(int index)
		{return l.get(index);}
		
		public int indexOf(Object o)
		{return l.indexOf(o);}
		
		public Iterator iterator()
		{return l.iterator();}
		
		public int lastIndexOf(Object o)
		{return l.lastIndexOf(o);}
		
		public ListIterator listIterator()
		{return l.listIterator();}
		
		public ListIterator listIterator(int index)
		{return l.listIterator(index);}
		
		public Object remove(int index)
		{return l.remove(index);}
		
		public boolean remove(Object o)
		{return l.remove(o);}
		
		public boolean removeAll(Collection c)
		{return l.removeAll(c);}
		
		public boolean retainAll(Collection c)
		{return l.retainAll(c);}
		
		public Object set(int index, Object element)
		{return l.set(index,element);}
		
		public List subList(int fromIndex, int toIndex)
		{return l.subList(fromIndex,toIndex);}
		
		public Object[] toArray()
		{return l.toArray();}
		
		public Object[] toArray(Object[] a)
		{return l.toArray(a);}
	}
}
