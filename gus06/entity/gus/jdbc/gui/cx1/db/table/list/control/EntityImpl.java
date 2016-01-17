package gus06.entity.gus.jdbc.gui.cx1.db.table.list.control;

import gus06.framework.*;
import javax.swing.JComponent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.sql.Connection;
import javax.swing.JToolBar;

public class EntityImpl implements Entity, ActionListener, I, P, V {

	public String creationDate() {return "20150622";}


	public static final String ACTIONID_ADD = "TABLE_add#Add table";
	public static final String ACTIONID_REMOVE = "TABLE_remove#Remove table";
	public static final String ACTIONID_RENAME = "TABLE_rename#Rename table";


	private Service addTable;
	private Service removeTable;
	private Service renameTable;
	
	private Service selectorSup;
	private Service actionBuilder;
	private Service toolbar;



	private JToolBar bar;
	
	private Object[] data;
	private G selector;
	
	
	private E execute_add;
	private E execute_remove;
	private E execute_rename;
	
	private Action action_add;
	private Action action_remove;
	private Action action_rename;
	
	
	
	public EntityImpl() throws Exception
	{
		addTable = Outside.service(this,"gus.jdbc.mysql.perform.table.create.ask");
		removeTable = Outside.service(this,"gus.jdbc.mysql.perform.table.drop.ask");
		renameTable = Outside.service(this,"gus.jdbc.mysql.perform.table.rename.ask");
		
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
		data = (Object[]) obj;
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
			boolean initialized = data!=null;
			
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
			if(data==null) return;
			
			G holder = (G) data[0];
			String dbName = (String) data[1];
			
			Connection cx = (Connection) holder.g();
			if(cx==null) return;
			
			boolean done = addTable.f(new Object[]{cx,dbName});
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
			
			if(data==null) return;
			
			G holder = (G) data[0];
			String dbName = (String) data[1];
			
			Connection cx = (Connection) holder.g();
			if(cx==null) return;
			
			boolean done = removeTable.f(new Object[]{cx,dbName,selection});
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
			
			if(data==null) return;
			
			G holder = (G) data[0];
			String dbName = (String) data[1];
			
			Connection cx = (Connection) holder.g();
			if(cx==null) return;
			
			boolean done = renameTable.f(new Object[]{cx,dbName,selection});
			if(done) ((P) holder).p("update");
		}
		catch(Exception e)
		{Outside.err(this,"rename()",e);}
	}
}
