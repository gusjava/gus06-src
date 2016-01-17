package gus06.entity.gus.jdbc.gui.cx1.db.list.control;

import gus06.framework.*;
import javax.swing.JComponent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.sql.Connection;
import javax.swing.JToolBar;

public class EntityImpl implements Entity, ActionListener, V, I, P {

	public String creationDate() {return "20150622";}
	
	
	public static final String ACTIONID_ADD = "BASE_add#Add database";
	public static final String ACTIONID_REMOVE = "BASE_remove#Remove database";
	public static final String ACTIONID_RENAME = "BASE_rename#Rename database";


	private Service addDb;
	private Service removeDb;
	private Service renameDb;
	
	private Service selectorSup;
	private Service actionBuilder;
	private Service toolbar;



	private JToolBar bar;
	
	private G holder;
	private G selector;
	
	
	private E execute_add;
	private E execute_remove;
	private E execute_rename;
	
	private Action action_add;
	private Action action_remove;
	private Action action_rename;
	
	
	
	public EntityImpl() throws Exception
	{
		addDb = Outside.service(this,"gus.jdbc.mysql.perform.db.create.ask");
		removeDb = Outside.service(this,"gus.jdbc.mysql.perform.db.drop.ask");
		renameDb = Outside.service(this,"gus.jdbc.mysql.perform.db.rename.ask");
		
		selectorSup = Outside.service(this,"*gus.support.holder");
		actionBuilder = Outside.service(this,"gus.swing.action.builder0");
		toolbar = Outside.service(this,"gus.swing.toolbar.toolbar1");
		
		selectorSup.addActionListener(this);
		
		execute_add = new E(){public void e() throws Exception {add();}};
		execute_remove = new E(){public void e() throws Exception {remove();}};
		execute_rename = new E(){public void e() throws Exception {rename();}};
		
		action_add = (Action) actionBuilder.t(new Object[]{ACTIONID_ADD,execute_add});
		action_remove = (Action) actionBuilder.t(new Object[]{ACTIONID_REMOVE,execute_remove});
		action_rename = (Action) actionBuilder.t(new Object[]{ACTIONID_RENAME,execute_rename});
		
		
		bar = (JToolBar) toolbar.i();
		
		bar.add(action_add);
		bar.add(action_remove);
		bar.add(action_rename);
	}
	
	
	
	
	public Object i() throws Exception
	{return bar;}
	
	
	
	public void p(Object obj) throws Exception
	{
		holder = (G) obj;
		updateGui();
	}
	
	
	
	
	
	public void v(String key, Object obj) throws Exception
	{
		if(key.equals("selector"))
		{
			selector = (G) obj;
			selectorSup.p(selector);
			updateGui();
			return;
		}
		throw new Exception("Unknown key: "+key);
	}
	
	
	


	public void actionPerformed(ActionEvent e)
	{updateGui();}
	
	
	
	private void updateGui()
	{
		try
		{
			if(selector==null) return;
			String selection = (String) selector.g();
			
			boolean selected = selection!=null && !selection.equals("");
			boolean initialized = holder!=null;
			
			action_add.setEnabled(initialized);
			action_rename.setEnabled(initialized && selected);
			action_remove.setEnabled(initialized && selected);
		}
		catch(Exception e)
		{Outside.err(this,"updateGui()",e);}
	}
	
	
	
	
	
	
	private void add()
	{
		try
		{
			if(holder==null) return;
			Connection cx = (Connection) holder.g();
			if(cx==null) return;
			
			boolean done = addDb.f(cx);
			if(done) ((P) holder).p("update");
		}
		catch(Exception e)
		{Outside.err(this,"add()",e);}
	}

	
	
	
	
	private void remove()
	{
		try
		{
			String selection = (String) selector.g();
			if(selection==null) return;
			
			if(holder==null) return;
			Connection cx = (Connection) holder.g();
			if(cx==null) return;
			
			boolean done = removeDb.f(new Object[]{cx,selection});
			if(done) ((P) holder).p("update");
		}
		catch(Exception e)
		{Outside.err(this,"remove()",e);}
	}
	
	
	
	
	private void rename()
	{
		try
		{
			String selection = (String) selector.g();
			if(selection==null) return;
			
			if(holder==null) return;
			Connection cx = (Connection) holder.g();
			if(cx==null) return;
			
			boolean done = renameDb.f(new Object[]{cx,selection});
			if(done) ((P) holder).p("update");
		}
		catch(Exception e)
		{Outside.err(this,"rename()",e);}
	}
}
