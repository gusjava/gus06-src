package gus06.entity.gus.math.maze.solve.algo.breadthfirstsearch.many;

import gus06.framework.*;
import java.util.*;


public class EntityImpl extends AbstractSearch2 implements Entity {

	public String creationDate() {return "20150309";}

	private List<int[]> queue;
	private Map<String,int[]> parents;
	
	
	
	public EntityImpl() throws Exception
	{
		queue = new ArrayList<>();
		parents = new HashMap<>();
	}

	
	protected void performSearch()
	{
		queue.clear();
		parents.clear();
		
		addToQueue(start);
		while(!queue.isEmpty())
		{
			current = queue.remove(0);
			moved();
			
			if(isEnd(current)) {resolve(current);return;}
			
			for(int[] c:freeNeighbours(current))
			{
				addToQueue(c);
				setParent(c,current);
			}
		}
	}

	
	
	private void addToQueue(int[] p)
	{
		queue.add(p);
		fill(p);
	}
	
	
	private void resolve(int[] p)
	{
		List<int[]> path_ = new ArrayList<>();
		while(p!=null)
		{
			path_.add(p);
			p = getParent(p);
		}
		int length = path_.size();
		path = new int[length][2];
		for(int i=0;i<length;i++)
		path[i] = path_.get(length-i-1);
	}
	
	
	private void setParent(int[] c, int[] p)
	{parents.put(toString(c),p);}
	
	
	private int[] getParent(int[] p)
	{
		String p_ = toString(p);
		return parents.containsKey(p_)?parents.get(p_):null;
	}
}