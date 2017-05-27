package gus06.entity.gus.array.paginator.holder;

import gus06.framework.*;
import java.util.Arrays;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20161219";}
	
	public static final int DEFAULT_LENGTH = 10;

	
	
	public Object t(Object obj) throws Exception
	{return new Holder((Object[]) obj);}
	
	
	
	private class Holder implements T, E, V
	{
		private Object[] array;
		
		private int index;
		private int length;
		
		public Holder(Object[] array)
		{
			this.array = array;
			
			index = 0;
			length = DEFAULT_LENGTH;
		}
		
		public void v(String key, Object obj) throws Exception
		{
			if(key.equals("page")) {setPage(toInt(obj));return;}
			if(key.equals("index")) {setIndex(toInt(obj));return;}
			if(key.equals("length")) {setLength(toInt(obj));return;}
			
			throw new Exception("Unknown key: "+key);
		}
		
		public Object t(Object obj) throws Exception
		{
			if(obj instanceof Integer) return get((Integer) obj);
			
			if(obj.equals("list")) return array;
			if(obj.equals("length")) return new Integer(length);
			if(obj.equals("tail")) return new Integer(tail());
			if(obj.equals("pagecount")) return new Integer(pagecount());
			if(obj.equals("pagecount1")) return new Integer(pagecount1());
			
			if(obj.equals("size")) return new Integer(size());
			if(obj.equals("index")) return new Integer(index);
			if(obj.equals("current")) return current();
			
			if(obj.equals("currentPageIndex"))	return new Integer(currentPageIndex());
			if(obj.equals("currentPageSize"))	return new Integer(currentPageSize());
			if(obj.equals("currentPage"))		return currentPage();
			
			if(obj.equals("firstPage"))		return firstPage();
			if(obj.equals("nextPage"))		return nextPage();
			if(obj.equals("previousPage"))		return previousPage();
			if(obj.equals("lastPage"))		return lastPage();
			
			if(obj.equals("first"))			return first();
			if(obj.equals("previous"))		return previous();
			if(obj.equals("next"))			return next();
			if(obj.equals("last"))			return last();
			
			throw new Exception("Unknown command: "+obj);
		}
		
		public void e() throws Exception
		{
			index = 0;
		}
		
		private int size()
		{
			return array.length;
		}
		
		private Object current()
		{
			if(index<0 || index>=size()) return null;
			return array[index];
		}
		
		
		private Object first()
		{
			setIndex(0);
			return current();
		}
		
		private Object previous()
		{
			setIndex(index-1);
			return current();
		}
		
		private Object next()
		{
			setIndex(index+1);
			return current();
		}
		
		private Object last()
		{
			setIndex(size()-1);
			return current();
		}
		
		private Object get(Integer n)
		{
			setIndex(n.intValue());
			return current();
		}
		
		
		private void setPage(int page)
		{setIndex(length*page);}
		
		
		private void setIndex(int v)
		{
			int size = size();
			if(size==0) {index=-1;return;}
			
			while(v<0) v += size;
			while(v>=size) v -= size;
			index = v;
		}
		
		private void setLength(int length) throws Exception
		{
			if(length<=1) throw new Exception("Invalid length value: "+length);
			this.length = length;
		}
		
		
		private int tail()
		{return size()%length;}
		
		
		private int pagecount1()
		{return size()/length;}
		
		
		private int pagecount()
		{
			int size = size();
			int count = size/length;
			int tail = size%length;
			return tail>0 ? count+1 : count;
		}
		
		private int currentPageIndex()
		{return index/length;}
		
		
		private int currentPageSize()
		{
			int tail = tail();
			int size = size();
			return index>=size-tail ? tail : length;
		}
		
		private Object[] currentPage()
		{
			int i = currentPageIndex();
			int start = i*length;
			int end = start + currentPageSize();
			return Arrays.copyOfRange(array,start,end);
		}
		
		private Object[] firstPage()
		{
			setIndex(0);
			return currentPage();
		}
		
		private Object[] previousPage()
		{
			setIndex(index-length);
			return currentPage();
		}
		
		private Object[] nextPage()
		{
			setIndex(index+length);
			return currentPage();
		}
		
		private Object[] lastPage()
		{
			setIndex(size()-tail());
			return currentPage();
		}
		
		private int toInt(Object obj)
		{return Integer.parseInt(""+obj);}
	}
}
