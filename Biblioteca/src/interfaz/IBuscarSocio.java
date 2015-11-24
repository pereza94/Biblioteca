package interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.html.parser.Entity;

import ctrolDataBase.SociosDB;
import entity.Socio;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class IBuscarSocio extends JDialog {
	private JTextField txBuscado;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			IBuscarSocio dialog = new IBuscarSocio();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public IBuscarSocio() {
		JRadioButton rdbtnDni;
		
		setBounds(100, 100, 744, 489);
		getContentPane().setLayout(null);
		{
			txBuscado = new JTextField();
			txBuscado.setBounds(10, 29, 431, 20);
			getContentPane().add(txBuscado);
			txBuscado.setColumns(10);
		}
		
		rdbtnDni = new JRadioButton("D.N.I");
		buttonGroup.add(rdbtnDni);
		rdbtnDni.setBounds(112, 67, 109, 23);
		getContentPane().add(rdbtnDni);
		
		JRadioButton rdbtnNombreYApellido = new JRadioButton("Nombre y Apellido");
		buttonGroup.add(rdbtnNombreYApellido);
		rdbtnNombreYApellido.setBounds(223, 67, 136, 23);
		getContentPane().add(rdbtnNombreYApellido);
		
		
		JLabel lblBuscarPor = new JLabel("Buscar por:");
		lblBuscarPor.setBounds(10, 71, 66, 14);
		getContentPane().add(lblBuscarPor);
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 108, 632, 254);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"DNI", "Identidad", "Direcci\u00F3n", "Sexo", "Telefono"
			}
		));
		DefaultTableModel modelo = (DefaultTableModel)table.getModel();
		
		
		scrollPane.setViewportView(table);
		
		
		{
			JButton btnBucar = new JButton("Buscar");
			btnBucar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					if(rdbtnDni.isSelected()==true){;
					int cant = SociosDB.buscarXDNI((Integer.parseInt(txBuscado.getText()))).size();
					if(cant==0){ JOptionPane.showMessageDialog(null,"No se econtro ningun socio");}
					else{
					for(int x=0;x<=cant ;x++) {
						entity.Socio s= new entity.Socio();
						ArrayList<Socio> sl = SociosDB.buscarXDNI(Integer.parseInt(txBuscado.getText()));
						s = sl.get(x);
						modelo.addRow(new Object[]{s.getDniSocio(),s.getIdentidad(),s.getDomicilio(),s.getSexo(),s.getTelefono()});
					}
					}
					}
					if(rdbtnNombreYApellido.isSelected()==true){
						int cant =SociosDB.buscarXIdentidad(txBuscado.getText().toUpperCase()).size();
						if(cant==0){ JOptionPane.showMessageDialog(null,"No se econtro ningun socio");}
						else{
						for(int x=0;x<=cant;x++){
							ArrayList<Socio> sl = SociosDB.buscarXIdentidad(txBuscado.getText().toUpperCase());
							entity.Socio s = new Socio();
							s = sl.get(x);
							modelo.addRow(new Object[]{s.getDniSocio(),s.getIdentidad(),s.getDomicilio(),s.getSexo(),s.getTelefono()});
					}
					}
					}
				
				}
			});
			btnBucar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				}
			});
			btnBucar.setBounds(532, 28, 89, 23);
			getContentPane().add(btnBucar);
		}
		
		
		/*for(int x=0;x<SociosDB.buscarXDNI(Integer.parseInt(txBuscado.getText())).size();x++) {
			//modelo.addRow(new Object[]{SociosDB.buscarXDNI(Integer.parseInt(txBuscado.getText())).get(x).getDniSocio(),SociosDB.buscarXDNI(Integer.parseInt(txBuscado.getText())).get(x).getIdentidad(),SociosDB.buscarXDNI(Integer.parseInt(txBuscado.getText())).get(x).getDomicilio(),SociosDB.buscarXDNI(Integer.parseInt(txBuscado.getText())),SociosDB.buscarXDNI(Integer.parseInt(txBuscado.getText())).get(x).getTelefono()});
			}
		*/
	}
}
