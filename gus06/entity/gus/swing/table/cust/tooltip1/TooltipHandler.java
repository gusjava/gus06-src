package gus06.entity.gus.swing.table.cust.tooltip1;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JTable;


class TooltipHandler extends MouseMotionAdapter {

    private JTable table;

    public TooltipHandler(JTable table)
    {
        super();
        this.table = table;
        table.addMouseMotionListener(this);
    }
    
    public void mouseMoved(MouseEvent evt)
    {
        Point p = evt.getPoint();
        
        int x = table.rowAtPoint(p);
        int y = table.columnAtPoint(p);
        
        if(x!=-1 && y!=-1 && table.getValueAt(x,y)!=null)
        table.setToolTipText(table.getValueAt(x,y).toString());
        else table.setToolTipText(null);
        
        if(y!=-1 && table.getColumnName(y)!=null)
        table.getTableHeader().setToolTipText(table.getColumnName(y));
        else table.getTableHeader().setToolTipText(null);
    }
}
