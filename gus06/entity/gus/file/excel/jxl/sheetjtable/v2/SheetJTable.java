package gus06.entity.gus.file.excel.jxl.sheetjtable.v2;

import javax.swing.JTable;
import jxl.Cell;
import jxl.Sheet;


public class SheetJTable extends JTable {

    private SheetTableModel model;
    private SheetTableCellRenderer renderer;
    
    public SheetJTable(Sheet sheet)
    {
        model = new SheetTableModel(sheet);
        renderer = new SheetTableCellRenderer();
        
        setModel(model);
        setDefaultRenderer(Cell.class,renderer);
        setCellSelectionEnabled(true);
    }
}
