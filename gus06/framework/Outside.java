package gus06.framework;


public final class Outside {

    
    private static Manager manager;
    
    public static void setManager(Manager manager0)
    {if(manager==null) manager = manager0;}
    
    
    
        
    public static Service service(Entity entity, String id) throws Exception
    {return manager.callService(entity,id);}
    
    public static Object resource(Entity entity, String id) throws Exception
    {return manager.callResource(entity,id);}
    
    public static void err(Entity entity, String id, Exception e)
    {manager.sendError(entity,id,e);}
}