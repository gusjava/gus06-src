package gus06.entity.gus.appli.labomail.gui.connect;

import gus06.framework.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.mail.Transport;
import javax.mail.Store;
import javax.swing.*;

public class EntityImpl extends S1 implements Entity, Runnable, ActionListener, I, R {

	public String creationDate() {return "20160607";}


	private Service holderGmail;
	private Service holderHotmail;
	private Service form;
	private Service persister;
	
	private JTextField field_login;
	private JPasswordField field_pwd;
	

	private JPanel panel;
	private JComponent formComp;
	private JTextArea area;
	private JButton button;
	
	private Thread t;
	private Service holder;
	
	private Transport transport;
	private Store store;
	


	public EntityImpl() throws Exception
	{
		holderGmail = Outside.service(this,"gus.mail.account.holder.gmail");
		holderHotmail = Outside.service(this,"gus.mail.account.holder.hotmail");
		form = Outside.service(this,"*gus.swing.panel.formpanel");
		persister = Outside.service(this,"gus.app.persister1.manager.swing");
		
		field_login = new JTextField();
		field_pwd = new JPasswordField();
		
		form.v("User",field_login);
		form.v("Password",field_pwd);
		
		persist("login",field_login);
		persist("pwd",field_pwd);
		
		formComp = (JComponent) form.i();
		
		button = new JButton("Connect");
		button.addActionListener(this);
		
		area = new JTextArea();
		area.setEditable(false);
		
		panel = new JPanel(new BorderLayout());
		panel.add(formComp,BorderLayout.NORTH);
		panel.add(new JScrollPane(area),BorderLayout.CENTER);
		panel.add(button,BorderLayout.SOUTH);
	}
	
	
	public Object i() throws Exception
	{return panel;}
	
	
	
	public Object r(String key) throws Exception
	{
		if(key.equals("store")) return store;
		if(key.equals("transport")) return transport;
		if(key.equals("keys")) return new String[]{"store","transport"};
		
		throw new Exception("Unknown key: "+key);
	}




	private void persist(String key, JComponent comp) throws Exception
	{persister.v(getClass().getName()+"_"+key,comp);}


	public void actionPerformed(ActionEvent e)
	{connect();}
	
	
	private void connect()
	{
		if(t!=null && t.isAlive()) return;
		t = new Thread(this,"THREAD_"+getClass().getName());
		t.start();
	}
	
	
	
	
	public void run()
	{
		button.setForeground(Color.ORANGE);
		button.setText("Connecting...");
		
		area.setText("");
		
		perform();
		
		button.setForeground(Color.BLACK);
		button.setText("Connect");
	}
	
	
	
	
	
	private void perform()
	{
		if(!prepareHolder()) return;
		
		boolean storeOk = initStore();
		boolean transportOk = initTransport();
		
		if(storeOk || transportOk) connected();
	}
	
	
	
	
	private boolean prepareHolder()
	{
		try
		{
			
			String login = field_login.getText();
			String password = new String(field_pwd.getPassword());
			
			store = null;
			transport = null;
			
			holder = findHolder(login);
			holder.e();
			
			holder.v("login",login);
			holder.v("password",password);
			return true;
		}
		catch(Exception e)
		{
			Outside.err(this,"prepareHolder()",e);
			area.append(e+"\n");
			return false;
		}
	}
	
	
	
	
	
	private boolean initStore()
	{
		try
		{
			store = (Store) holder.r("store");
			area.append("Store initialized\n\n");
			return true;
		}
		catch(Exception e)
		{
			Outside.err(this,"initStore()",e);
			area.append("Store failed:\n"+e+"\n");
			return false;
		}
	}
	
	
	
	private boolean initTransport()
	{
		try
		{
			transport = (Transport) holder.r("transport");
			area.append("Transport initialized\n\n");
			return true;
		}
		catch(Exception e)
		{
			Outside.err(this,"initTransport()",e);
			area.append("Transport failed:\n"+e+"\n");
			return false;
		}
	}
	
	
	
	
	
	
	private Service findHolder(String login) throws Exception
	{
		if(login.endsWith("@hotmail.fr")) return holderHotmail;
		if(login.endsWith("@hotmail.com")) return holderHotmail;
		
		if(login.endsWith("@gmail.fr")) return holderGmail;
		if(login.endsWith("@gmail.com")) return holderGmail;
		
		throw new Exception("Unsupported email address: "+login);
	}


	private void connected()
	{send(this,"connected()");}
}
