package gus06.entity.gus.swing.tree.cust.eventhandler.file;

import gus06.framework.*;
import javax.swing.JTree;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20140917";}


	private Service createFile;
	private Service createDir;
	private Service createTool;
	
	private Service renameAsk;
	private Service renameTStamp;
	private Service duplicateAsk;
	private Service duplicateTStamp;
	private Service displayInfos1;
	private Service displayInfos2;
	
	private Service open;
	private Service remove;
	private Service refresh;
	private Service runTask;
	
	private Service copy;
	private Service copyPath;
	private Service copyContent;
	
	private Service paste;
	private Service pastePath;
	private Service pasteContent;
	
	private Service cut;
	private Service cutPath;
	private Service cutContent;
	
	private Service changeRoot;
	
	private Service clearCPC;
	
	


	public EntityImpl() throws Exception
	{
		createFile = Outside.service(this,"gus.swing.tree.perform.file.createfile");
		createDir = Outside.service(this,"gus.swing.tree.perform.file.createdir");
		createTool = Outside.service(this,"gus.swing.tree.perform.file.createtool");
		
		renameAsk = Outside.service(this,"gus.swing.tree.perform.file.rename.ask");
		renameTStamp = Outside.service(this,"gus.swing.tree.perform.file.rename.timestamped");
		
		duplicateAsk = Outside.service(this,"gus.swing.tree.perform.file.duplicate.ask");
		duplicateTStamp = Outside.service(this,"gus.swing.tree.perform.file.duplicate.timestamped");
		
		displayInfos1 = Outside.service(this,"gus.swing.tree.perform.file.display.infos1");
		displayInfos2 = Outside.service(this,"gus.swing.tree.perform.file.display.infos2");
		
		open = Outside.service(this,"gus.swing.tree.perform.file.open");
		remove = Outside.service(this,"gus.swing.tree.perform.file.remove");
		refresh = Outside.service(this,"gus.swing.tree.perform.file.refresh");
		runTask = Outside.service(this,"gus.swing.tree.perform.file.runtask");
		
		copy = Outside.service(this,"gus.swing.tree.perform.file.copy");
		copyPath = Outside.service(this,"gus.swing.tree.perform.file.copypath");
		copyContent = Outside.service(this,"gus.swing.tree.perform.file.copycontent");
		
		paste = Outside.service(this,"gus.swing.tree.perform.file.paste");
		pastePath = Outside.service(this,"gus.swing.tree.perform.file.pastepath");
		pasteContent = Outside.service(this,"gus.swing.tree.perform.file.pastecontent");
		
		cut = Outside.service(this,"gus.swing.tree.perform.file.cut");
		cutPath = Outside.service(this,"gus.swing.tree.perform.file.cutpath");
		cutContent = Outside.service(this,"gus.swing.tree.perform.file.cutcontent");
		
		changeRoot = Outside.service(this,"gus.swing.tree.perform.file.changeroot");
		
		clearCPC = Outside.service(this,"gus.swing.comp.action.clearcopypastecut");
	}
	
	
	public void p(Object obj) throws Exception
	{new Handler((JTree) obj);}
	
	
	
	
	
	
	
	
	private class Handler implements KeyListener
	{
		private JTree tree;
		
		public Handler(JTree tree) throws Exception
		{
			this.tree = tree;
			clearCPC.p(tree);
			tree.addKeyListener(this);
		}
		
		public void keyTyped(KeyEvent e) {}
		public void keyReleased(KeyEvent e) {}
		public void keyPressed(KeyEvent e)
		{
			if(tree.isSelectionEmpty()) return;
			
			if(is_ctrl_alt(e))
			{
				switch(e.getKeyCode())
				{
					case KeyEvent.VK_C:execute(tree,copyContent);break;
					case KeyEvent.VK_V:execute(tree,pasteContent);break;
					case KeyEvent.VK_X:execute(tree,cutContent);break;
				}
			}
			else if(is_ctrl_shift(e))
			{
				switch(e.getKeyCode())
				{
					case KeyEvent.VK_C:execute(tree,copyPath);break;
					case KeyEvent.VK_V:execute(tree,pastePath);break;
					case KeyEvent.VK_X:execute(tree,cutPath);break;
				}
			}
			else if(is_ctrl(e))
			{
				switch(e.getKeyCode())
				{
					case KeyEvent.VK_C:execute(tree,copy);break;
					case KeyEvent.VK_V:execute(tree,paste);break;
					case KeyEvent.VK_X:execute(tree,cut);break;
					
					case KeyEvent.VK_F1:execute(tree,createDir);break;
					case KeyEvent.VK_F2:execute(tree,renameTStamp);break;
					case KeyEvent.VK_F3:execute(tree,duplicateTStamp);break;
					case KeyEvent.VK_F4:execute(tree,displayInfos2);break;
					
					case KeyEvent.VK_SPACE:execute(tree,changeRoot);break;
				}
			}
			else
			{
				switch(e.getKeyCode())
				{
					case KeyEvent.VK_F1:execute(tree,createFile);break;
					case KeyEvent.VK_F2:execute(tree,renameAsk);break;
					case KeyEvent.VK_F3:execute(tree,duplicateAsk);break;
					case KeyEvent.VK_F4:execute(tree,displayInfos1);break;
					
					case KeyEvent.VK_F5:execute(tree,refresh);break;
					case KeyEvent.VK_F6:execute(tree,createTool);break;
					case KeyEvent.VK_F7:execute(tree,runTask);break;
					
					case KeyEvent.VK_DELETE:execute(tree,remove);break;
					case KeyEvent.VK_SPACE:execute(tree,open);break;
				}
			}
		}
	}
	
	
	
	
	
	private boolean is_ctrl(KeyEvent e)
	{return (e.getModifiers() & KeyEvent.CTRL_MASK)!=0;}
	
	private boolean is_ctrl_shift(KeyEvent e)
	{return e.getModifiers() == KeyEvent.CTRL_MASK + KeyEvent.SHIFT_MASK;}
	
	private boolean is_ctrl_alt(KeyEvent e)
	{return e.getModifiers() == KeyEvent.CTRL_MASK + KeyEvent.ALT_MASK;}
	
	
	
	
	
	private void execute(JTree tree, Service s)
	{
		try{s.p(tree);}
		catch(Exception e)
		{Outside.err(this,"execute(JTree,Service)",e);}
	}
}
