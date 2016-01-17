package gus06.entity.gus.swing.table.cust.tooltip2;

import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import javax.swing.text.JTextComponent;


class TooltipHandler extends MouseMotionAdapter {

    private JTable table;

    public TooltipHandler(JTable table)
    {
        super();
        this.table = table;
        table.addMouseMotionListener(this);
    }
    
    public synchronized void mouseMoved(MouseEvent evt)
    {
        Point p = evt.getPoint();
        
        int x = table.rowAtPoint(p);
        int y = table.columnAtPoint(p);
        
        if(x>0 && y>0 && table.getRowCount()>x && table.getColumnCount()>y && table.getValueAt(x,y)!=null)
        {
        	String s = getCellDisplay(table,x,y);
        	table.setToolTipText(s.equals("")?null:s);
        }
        else table.setToolTipText(null);
        
        if(y>0 && table.getColumnCount()>y && table.getColumnName(y)!=null)
        {
        	String s = getHeaderDisplay(table,y);
        	table.getTableHeader().setToolTipText(s.equals("")?null:s);
        } 
        else table.getTableHeader().setToolTipText(null);
    }
    
    
    
    
    private String getCellDisplay(JTable table, int x, int y)
    {
    	Class columnClass = table.getColumnClass(y);
    	Object value = table.getValueAt(x,y);
    	TableCellRenderer renderer = table.getDefaultRenderer(columnClass);
    	
    	if(renderer!=null)
    	{
    		Component comp = renderer.getTableCellRendererComponent(table, value, false, false, x, y);
        	
        	if(comp instanceof JLabel)
        	{
        		JLabel l = (JLabel) comp;
        		return l.getText();
        	}
        	if(comp instanceof JTextComponent)
        	{
        		JTextComponent l = (JTextComponent) comp;
        		return l.getText();
        	}
    	}
    	return value!=null?value.toString():null;
    }
    
    
    
    
    
    private String getHeaderDisplay(JTable table, int y)
    {
    	TableCellRenderer renderer = table.getColumnModel().getColumn(y).getCellRenderer();
    	if(renderer==null) renderer = table.getTableHeader().getDefaultRenderer();
    	
    	String columnName = table.getColumnName(y);
    	
    	if(renderer!=null)
    	{
    		Component comp = renderer.getTableCellRendererComponent(table, columnName, false, false, 0, y);
        	
        	if(comp instanceof JLabel)
        	{
        		JLabel l = (JLabel) comp;
        		return l.getText();
        	}
        	if(comp instanceof JTextComponent)
        	{
        		JTextComponent l = (JTextComponent) comp;
        		return l.getText();
        	}
    	}
    	
    	renderer = table.getTableHeader().getDefaultRenderer();
    	return columnName;
    }
}
