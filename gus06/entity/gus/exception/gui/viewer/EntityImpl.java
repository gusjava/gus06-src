package gus06.entity.gus.exception.gui.viewer;

import gus06.framework.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.OutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.border.BevelBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;


public class EntityImpl implements Entity, I, ActionListener {

	public String creationDate() {return "20140730";}


	private SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
	private String timeStamp(Date d){return sdf.format(d);}
	
	
	
	private Service buildOutput;
	private Service custArea;
	private Service splitCust;
	
	private List errors;
    
	private JSplitPane split;
	private JTable table;
	private JTextArea area;
	private JLabel label_number;
    
	private TableModel0 model;
	private PrintStream out;

	

	public EntityImpl() throws Exception
	{
		buildOutput = Outside.service(this,"gus.io.outputstream.textarea1");
		custArea = Outside.service(this,"gus.swing.textcomp.cust.console1.black.red");
		splitCust = Outside.service(this,"gus.swing.splitpane.cust.cust1");
		
		errors = (List) Outside.resource(this,"errors");
        
		model = new TableModel0();
		table = new JTable(model);
		table.getTableHeader().setReorderingAllowed(false);
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
			public void valueChanged(ListSelectionEvent e)
			{selectionChanged();}
		});
        
		area = new JTextArea();
		area.setEditable(false);
		custArea.p(area);
        
		out = new PrintStream((OutputStream) buildOutput.t(area));
		
		label_number = new JLabel(" 0");
        
		JLabel titleLabel = titleLabel("Exception detail view");
        
		JPanel p = new JPanel(new BorderLayout());
		p.add(titleLabel,BorderLayout.NORTH);
		p.add(new JScrollPane(area),BorderLayout.CENTER);
		p.add(label_number,BorderLayout.SOUTH);
        
		split = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		splitCust.p(split);
		
		split.setOneTouchExpandable(true);
		split.setDividerLocation(200);
        
		split.setLeftComponent(new JScrollPane(table));
		split.setRightComponent(p);
		
		((S)errors).addActionListener(this);
		updateGui();
	}
	
	
	public Object i() throws Exception
	{return split;}
	
	
	public void actionPerformed(ActionEvent e)
	{updateGui();}
    
    
    
    
	private void updateGui()
	{
		label_number.setText(" "+errors.size());
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run(){model.fireTableStructureChanged();}
		});
	}
	
	
	
	private void selectionChanged()
	{
		area.setText("");
		if(table.getSelectionModel().isSelectionEmpty()) return;
		
		int row = table.getSelectedRow();
		Object[] info = (Object[]) errors.get(row);
		Exception e = (Exception) info[2];
		e.printStackTrace(out);
		area.setCaretPosition(0);
	}
		
		
	
	private class TableModel0 extends AbstractTableModel
	{
		public int getColumnCount() {return 5;}
		public int getRowCount() {return errors.size();}
        
		public String getColumnName(int y)
		{
			if(y==0) return "time";
			if(y==1) return "source";
			if(y==2) return "id";
			if(y==3) return "type";
			if(y==4) return "message";
			return null;
		}
        
		public Class getColumnClass(int y)
		{return String.class;}
        
		public boolean isCellEditable(int x, int y)
		{return false;}

		public Object getValueAt(int x, int y)
		{
			Object[] info = (Object[]) errors.get(x);
			Exception e = (Exception)info[2];
            
			if(y==0) return timeStamp((Date)info[3]);  // time stamp
			if(y==1) return sourceName(info[0]);  // source
			if(y==2) return (String)info[1]; // id
			if(y==3) return e.getClass().getSimpleName();
			if(y==4) return e.getMessage();
			return null;
		}
	}
    
    
    
    
    
    
	private JLabel titleLabel(String title)
	{
		JLabel label = new JLabel(title);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		return label;
	}
    
	private String sourceName(Object source)
	{
		if(source==null) return "null";
		if(source instanceof Class) return ((Class)source).getSimpleName();
		return source.getClass().getSimpleName();
	}
}
