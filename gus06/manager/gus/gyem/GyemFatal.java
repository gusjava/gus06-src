package gus06.manager.gus.gyem;

import gus06.manager.gus.gyem.tools.Tool_Time;
import gus06.manager.gus.gyem.tools.Tool_Args;

import java.io.File;
import java.io.PrintStream;
import java.util.Date;

import javax.swing.JOptionPane;

public class GyemFatal extends GyemSystem {

	
	private File file;
	private PrintStream out;
	
	private boolean noDialog;
	private boolean noFile;
	
	
	
	public GyemFatal(Exception e, int exitCode)
	{
		Date abortTime = new Date();
		
		String abortTime_ = Tool_Time.yyyyMMdd_HHmmss(abortTime);
		String startTime_ = Tool_Time.yyyyMMdd_HHmmss(startTime);
		String argsLine = Tool_Args.toString(appArgs);
		
		noDialog = argsLine.startsWith("*");
		noFile = argsLine.startsWith("**");
		
		
		initFile(startTime_);
		
		if(out!=null)
		{
			out.println("FATAL ERROR REPORT");
			out.println("------------------");
			out.println("manager ID: ["+VERSION.ID+"]");
			out.println("args line: ["+argsLine+"]");
			out.println("launch dir: "+System.getProperty("user.dir"));
			out.println("start time: "+startTime_);
			out.println("abort time: "+abortTime_);
			out.println("exit code: "+exitCode);
			out.println("------------------");
			out.println("java version: "+System.getProperty("java.version"));
			out.println("java home: "+System.getProperty("java.home"));
			out.println("------------------");
			out.println("exception type: "+e.getClass().getName());
			out.println("exception message: "+e.getMessage());
			out.println("------------------");
			e.printStackTrace(out);
			out.close();
		}

		String message = message(e,exitCode);

		System.err.println(message);
		e.printStackTrace(System.err);

		showErr(message,"FATAL ERROR");
		
		System.err.println("System.exit("+exitCode+")");
		System.exit(exitCode);
	}
	
	
	
	
	
	
	private void initFile(String time)
	{
		if(noFile) return;
		String fileName = "fatalerr_"+time+"_"+VERSION.ID+".txt";
		file = new File(fileName);
		
		try
		{
			out = new PrintStream(file);
		}
		catch(Exception e)
		{
			String message = "Failed to initialize report file:\n"+file.getAbsolutePath()+"\n"+e;
			
			System.err.println(message);
			e.printStackTrace(System.err);

			showErr(message,"Report file failure");
		}
	}
	
	
	
	
	private String message(Exception e, int exitCode)
	{
		StringBuilder b = new StringBuilder();
		b.append("A fatal error has occurred:\n");
		b.append("Application must abort\n");
		b.append("Exit code: "+exitCode+"\n");
		b.append("manager ID: ["+VERSION.ID+"]\n");
		
		if(out!=null)
		{
			b.append("For further details, please read the FATAL ERROR REPORT file:\n");
			b.append(file.getAbsolutePath()+"\n");
		}
		
		b.append("\nERROR:\n"+truncate(e.toString()));
		return b.toString();
	}
	
	
	
	private void showErr(String message, String title)
	{
		if(noDialog) return;
		JOptionPane.showMessageDialog(null,message,title,JOptionPane.ERROR_MESSAGE);
	}
	
	
	public static final int LIMIT = 250;
	
	private String truncate(String s)
	{
		if(s.length()<LIMIT) return s;
		return s.substring(0,LIMIT)+"...";
	}
}