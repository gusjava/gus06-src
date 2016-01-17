package gus06.framework;


public interface Manager {

    public Service callService(Entity entity, String id) throws Exception; 
    public Object callResource(Entity entity, String id) throws Exception;
    public void sendError(Entity entity, String id, Exception e);
}