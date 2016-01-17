package gus06.manager.gus.gyem.tools;

import java.io.PrintStream;
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Tool_Thread {

	/*
     * THREAD
     */
	
	public static final String LINE = "______________________________";
    
	
	
	
    
    public static StackTraceElement[] ste()
    {
    	return Thread.currentThread().getStackTrace();
    }
    
    
    public static String ste_location(int level)
    {
    	StackTraceElement[] ste = ste();
    	if(level<0 || level>ste.length-1) return "Invalid ste level: "+level;
    	return location(ste[level]);
    }
    
    
    public static void printlnLoc()
    {
    	String loc = ste_location(4);
    	System.out.println(loc);
    }
    
    
    
    
    
    public static String location(StackTraceElement ste)
    {
    	if(ste==null) return "null STE";
    	return ste.getClassName()+"@"+ste.getMethodName()+" ("+ste.getFileName()+":"+ste.getLineNumber()+")";
    }
    
    
    public static String lastLocation(Thread t)
    {
    	return lastLocation(t.getStackTrace());
    }
    
    
    public static String lastLocation(StackTraceElement[] ste)
    {
    	if(ste==null) return "null stack trace";
    	if(ste.length==0) return "empty stack trace";
    	return location(ste[0]);
    }
    
    
    public static String deep(StackTraceElement[] ste)
    {
    	if(ste==null) return "null stack trace";
    	return ""+ste.length;
    }
    
    
    
    public static void printStackTrace(PrintStream p, StackTraceElement[] ste)
    {
    	if(ste==null) {p.println("null stack trace");return;}
    	if(ste.length==0) {p.println("empty stack trace");return;}
    	
    	for(int i=0;i<ste.length;i++)
    	p.println("at "+location(ste[i]));
    	p.println("");
    }
    
    
    
    
    
    
    public static String owner(ThreadInfo info)
    {
    	String name = info.getLockOwnerName();
    	long id = info.getLockOwnerId();
    	return name+" ["+id+"]";
    }
    
    
    public static String name(ThreadInfo info)
    {
    	String name = info.getThreadName();
    	long id = info.getThreadId();
    	return name+" ["+id+"]";
    }
    
    
    
    public static boolean isBlocked(Thread t)
    {
    	if(t==null) return false;
    	return t.getState()==Thread.State.BLOCKED;
    }
    
    
    public static String group(Thread t)
	{
		ThreadGroup g = t.getThreadGroup();
		return g==null?"":g.getName();
	}
    
    
    public static String state(Thread t)
    {
    	Thread.State state = t.getState();
    	return state==null?"":state.name();
    }
    
    
    
    
    
    public static List blockedList(Thread[] t)
    {
    	List list = new ArrayList();
    	for(int i=0;i<t.length;i++)
    		if(isBlocked(t[i])) list.add(t[i]);
    	return list;
    }
    
    
    
    
    
    public static void printThreadState(PrintStream p)
    {
    	int threadCount = Thread.activeCount();
    	Thread[] t = new Thread[threadCount];
    	Thread.enumerate(t);
    	
    	List blockedList = blockedList(t);
    	int blockedCount = blockedList.size();
    	
    	p.println("THREAD number: "+threadCount);
    	p.println("BLOCKED number: "+blockedCount);
    	
    	p.println();
    	p.println("BLOCKED listing:");
    	
    	for(int i=0;i<blockedCount;i++)
    	{
    		Thread b = (Thread) blockedList.get(i);
    		p.println(b.getName()+" ["+b.getId()+"]\t"+lastLocation(b));
    	}
    	
    	p.println();
    	p.println("THREAD detailed information:");
    	
    	for(int i=0;i<threadCount;i++)
    	{
    		p.println(LINE);
    		printThread(p,t[i]);
    	}
    }
    
    
    
    
    
    
    
    
    public static void printDeadLockState(PrintStream p) throws Exception
    {
        ThreadMXBean mxb = ManagementFactory.getThreadMXBean();
        long[] threadIds = mxb.findMonitorDeadlockedThreads();
        int deadlockedNumber = threadIds!=null?threadIds.length:0;
        if(deadlockedNumber==0)
        {
        	p.println("NO DEAD LOCK");
        	return;
        }

        p.println("DEAD LOCK DETECTED");
        
        Set done = new HashSet();
        ThreadInfo[] info = mxb.getThreadInfo(threadIds,5);
        for(int i=0;i<info.length;i++)
        {
        	String display = name(info[i]);
        	if(!done.contains(display))
        	{
        		p.println(LINE);
        		printThreadInfo(p,info[i]);
        		done.add(display);
        	}
        }
    }
    
    
    
    
    
    
    public static void printThread(PrintStream p, Thread t)
    {
    	long id = t.getId();
    	int priority = t.getPriority();
    	boolean isDaemon = t.isDaemon();
    	String name = t.getName();
    	String state = state(t);
    	String group = group(t);
    	String ste_deep = deep(t.getStackTrace());
    	
    	p.println("id: "+id);
    	p.println("name: "+name);
    	p.println("group: "+group);
    	p.println("state: "+state);
    	p.println("priority: "+priority);
    	p.println("isDaemon: "+isDaemon);
    	p.println("STE deep: "+ste_deep);
    	p.println();
    	
    	StackTraceElement[] ste = t.getStackTrace();
    	printStackTrace(p,ste);
    }
    
    
    
    
    public static void printThreadInfo(PrintStream p, ThreadInfo info)
    {
    	String name = name(info);
    	String owner = owner(info);
    	String lock = info.getLockName();
    	
    	p.println("THREAD DEAD-LOCKED: "+name);
    	p.println("waiting for lock "+lock);
    	p.println("currently owned by thread "+owner);
    	
    	StackTraceElement[] ste = info.getStackTrace();
    	printStackTrace(p,ste);
    }
    

}