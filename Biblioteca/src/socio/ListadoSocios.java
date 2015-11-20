package socio;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;


import ctrolSocio.SociosDB;

import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JTable;
import java.awt.Color;

public class ListadoSocios extends JDialog {
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListadoSocios dialog = new ListadoSocios();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListadoSocios() {
		setBounds(100, 100, 619, 300);
		getContentPane().setLayout(null);
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(27, 34, 528, 163);
			getContentPane().add(scrollPane);
			{
				table = new JTable();
				table.setForeground(Color.BLUE);
				table.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
						"DNI", "Identidad", "Direcci\u00F3n", "Sexo", "Telefono"
					}
				));
				scrollPane.setViewportView(table);
			}
		DefaultTableModel modelo = (DefaultTableModel)table.getModel();
		
		
		for(int x=0;x<SociosDB.sociosTodos().size();x++) {
			entity.Socio s = new entity.Socio();
			s = SociosDB.sociosTodos().get(x); 
			modelo.addRow(new Object[]{s.getDniSocio(),s.getIdentidad(),s.getDomicilio(),s.getSexo(),s.getTelefono()});
			}
		
		
		}
	}

}
