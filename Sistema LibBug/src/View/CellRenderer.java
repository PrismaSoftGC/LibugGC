package View;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class CellRenderer extends DefaultTableCellRenderer {
    
    public CellRenderer() {
		super();
	}
	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {
		if ((row % 2) == 0)
			super.setBackground(Color.WHITE);
		else
			super.setBackground(Color.LIGHT_GRAY);
		return super.getTableCellRendererComponent(table, value, isSelected,
				hasFocus, row, column);
	}
}
