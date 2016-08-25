package gus06.entity.gus.file.editor.ext.gus.console;

import gus06.framework.*;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import java.io.File;
import java.io.PrintStream;
import java.awt.Font;
import java.awt.Color;
import javax.swing.text.JTextComponent;
import java.awt.Insets;
import java.util.Map;

public class EntityImpl implements Entity, I, P {

	public String creationDate() {return "20151101";}
	
	
	public static final Font FONT = new Font("Courier New", Font.PLAIN, 15);


	private Service compHolder;
	private Service engine;
	private Service readText;
	

	private JPanel panel;
	private JTextComponent console;
	
	private File inputFile;
	private File outputFile;
	
	private String input;
	private String output;
	
	
	

	public EntityImpl() throws Exception
	{
		compHolder = Outside.service(this,"*gus.swing.textpane.holder.printstreamcomp");
		engine = Outside.service(this,"gus.sys.script1.main.main1");
		readText = Outside.service(this,"gus.file.read.string.autodetect");
		
		console = (JTextComponent) compHolder.i();
		
		console.setMargin(new Insets(3,3,3,3));
		console.setBackground(Color.BLACK);
		console.setEditable(false);
		console.setFont(FONT);
		
		panel = new JPanel(new BorderLayout());
		panel.add(new JScrollPane(console),BorderLayout.CENTER);
	}
	
	
	public Object i() throws Exception
	{return panel;}
	
	
	
	
	public void p(Object obj) throws Exception
	{
		console.setText("");
		if(obj==null) return;
		
		if(obj instanceof File)
		{
			inputFile = (File) obj;
			input = (String) readText.t(inputFile);
			executeScript();
		}
		else if(obj instanceof Object[])
		{
			Object[] o = (Object[]) obj;
			if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
			
			inputFile = (File) o[0];
			input = (String) o[1];
			executeScript();
		}
	}
	
	
	


	private void executeScript() throws Exception
	{
		try
		{
			PrintStream p_out = p_out();
			engine.p(new Object[]{inputFile,p_out});
			p_out.close();
			
			output = console.getText().trim();
			outputFile = new File(inputFile.getAbsolutePath()+"_output.txt");
			
			if(!output.equals(""))
				print(outputFile,output);
			else clear(outputFile);
		}
		catch(Exception e)
		{
			Outside.err(this,"executeScript()",e);
			e.printStackTrace(p_err());
		}
	}
	
	
	private PrintStream p_out() throws Exception
	{return (PrintStream) compHolder.r("white");}
	
	private PrintStream p_err() throws Exception
	{return (PrintStream) compHolder.r("red");}
	
	
	private void print(File f, String s) throws Exception
	{
		PrintStream p = new PrintStream(f,"UTF-8");
		p.print(s);
		p.close();
	}
	
	private void clear(File f)
	{if(f.exists()) f.delete();}
		
}
