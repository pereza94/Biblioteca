package ctrolSocio;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class TablaSocio extends AbstractTableModel {
	
	private List<Socio> listaSoc; 
	
	// cabecera de la tabla
	private String[] columnNames = { "DNI", "NOMBRE", "DIRECCION", "SEXO",
			"TELEFONO" };

	// Lista del tipo de objetos a agregar
	
	
	// agrego cliente a fila de la tabla
	public void agregarSocio(entity.Socio so) {
			fireTableDataChanged();
	}

	public void eliminarTurno(int rowIndex) {
		SociosDB.sociosTodos().remove(rowIndex);
		fireTableDataChanged();
	}

	public void limpiarTurnos() {
		SociosDB.sociosTodos().clear();
		fireTableDataChanged();
	}

	@Override
	public String getColumnName(int columnIndex) {
		return columnNames[columnIndex];
	}

	@Override
	public int getRowCount() {
		return SociosDB.sociosTodos().size();
	}

	@Override
	public int getColumnCount() {
		return 5;
	}

	@Override
	public Object getValueAt(int row, int column) {
		switch (column) {
		case 0:
			return SociosDB.sociosTodos().get(row).getDniSocio();
		case 1:
			return SociosDB.sociosTodos().get(row).getIdentidad();
		case 2:
			return SociosDB.sociosTodos().get(row).getDomicilio();
		case 3:
			return SociosDB.sociosTodos().get(row).getSexo();
		case 4:
			return SociosDB.sociosTodos().get(row).getTelefono();
		case 5:
			
		}
		return null;
	}

	@Override
	public Class<String> getColumnClass(int columnIndex) {
		// return getValueAt(0, columnIndex).getClass();
		return String.class;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	@Override
	public void setValueAt(Object value, int rowIndex, int columnIndex) {
		// Turno turno = turnos.get(rowIndex);
		switch (columnIndex) {
		}
		fireTableCellUpdated(rowIndex, columnIndex);
	}

}