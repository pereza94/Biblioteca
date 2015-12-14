package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
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
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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

		JPanel panel = new JPanel();
		panel.setForeground(new Color(0, 0, 128));
		panel.setBounds(10, 11, 655, 406);
		getContentPane().add(panel);
		Border bordejpanel = new TitledBorder(new EtchedBorder(),"Buscar Socio");
		panel.setBorder(bordejpanel);
		panel.setLayout(null);
		{
			
		}

		rdbtnDni = new JRadioButton("D.N.I");
		rdbtnDni.setForeground(new Color(0, 0, 128));
		rdbtnDni.setBounds(134, 72, 109, 23);
		panel.add(rdbtnDni);
		buttonGroup.add(rdbtnDni);

		JRadioButton rdbtnNombreYApellido = new JRadioButton("Nombre y Apellido");
		rdbtnNombreYApellido.setForeground(new Color(0, 0, 128));
		rdbtnNombreYApellido.setBounds(294, 71, 136, 23);
		panel.add(rdbtnNombreYApellido);
		buttonGroup.add(rdbtnNombreYApellido);


		JLabel lblBuscarPor = new JLabel("Buscar por:");
		lblBuscarPor.setForeground(new Color(0, 0, 128));
		lblBuscarPor.setBounds(31, 76, 66, 14);
		panel.add(lblBuscarPor);



		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 105, 632, 254);
		panel.add(scrollPane);

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
			btnBucar.setForeground(new Color(0, 0, 128));
			btnBucar.setBounds(533, 36, 89, 23);
			panel.add(btnBucar);

			JLabel lblBuscar = new JLabel("Buscar:");
			lblBuscar.setForeground(new Color(0, 0, 128));
			lblBuscar.setHorizontalAlignment(SwingConstants.RIGHT);
			lblBuscar.setBounds(20, 40, 52, 14);
			panel.add(lblBuscar);

			JButton btnNuevoSocio = new JButton("Nuevo Socio");
			btnNuevoSocio.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					INuevoSocio ns= new INuevoSocio();
					ns.setVisible(true);
				}
			});
			btnNuevoSocio.setIcon(new ImageIcon(IBuscarSocio.class.getResource("/Images/Login/red-sign-computer-green-icon-mark-symbol-cartoon.png")));
			btnNuevoSocio.setForeground(new Color(0, 102, 0));
			btnNuevoSocio.setBackground(SystemColor.activeCaptionBorder);
			btnNuevoSocio.setBounds(10, 372, 142, 24);
			panel.add(btnNuevoSocio);

			JButton button_1 = new JButton("Cerrar");
			button_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					dispose();
				}
			});
			button_1.setIcon(new ImageIcon(IBuscarSocio.class.getResource("/Images/Login/210px-Cruz_roja (1).png")));
			button_1.setVerticalTextPosition(SwingConstants.BOTTOM);
			button_1.setInheritsPopupMenu(true);
			button_1.setIgnoreRepaint(true);
			button_1.setHorizontalTextPosition(SwingConstants.LEFT);
			button_1.setForeground(new Color(165, 42, 42));
			button_1.setFont(new Font("Segoe Print", Font.BOLD, 11));
			button_1.setBackground(Color.LIGHT_GRAY);
			button_1.setBounds(538, 372, 105, 23);
			panel.add(button_1);

			JButton button_2 = new JButton("Limpiar Tabla");
			button_2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					for (int i = 0; i < table.getRowCount(); i++) {
						modelo.removeRow(i);
						i-=1;
					}

				}
			});
			rdbtnNombreYApellido.setSelected(true);
			
			txBuscado = new JTextField();
			txBuscado.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					for (int i = 0; i < table.getRowCount(); i++) {
						modelo.removeRow(i);
						i-=1;
					}
					if(rdbtnNombreYApellido.isSelected()==true){
						int cant =SociosDB.buscarXIdentidad(txBuscado.getText().toUpperCase()).size();
						if(cant==0){ JOptionPane.showMessageDialog(null,"No se econtro ningun socio");}
						else{
							for(int x=0;x<cant;x++){
								ArrayList<Socio> sl = SociosDB.buscarXIdentidad(txBuscado.getText().toUpperCase());
								entity.Socio s = new Socio();
								s = sl.get(x);
								modelo.addRow(new Object[]{s.getDniSocio(),s.getIdentidad(),s.getDomicilio(),s.getSexo(),s.getTelefono()});
							}
						}
					}

				}
			});
			txBuscado.setBounds(82, 38, 431, 20);
			panel.add(txBuscado);
			txBuscado.setColumns(10);
			
			button_2.setIcon(new ImageIcon(IBuscarSocio.class.getResource("/Images/Login/8fc03fbe37e8ed0e1e784244c68f3fe8.png")));
			button_2.setBackground(Color.WHITE);
			button_2.setBounds(501, 82, 141, 23);
			panel.add(button_2);
			
			JButton btnModificarSocio = new JButton("Modificar Socio");
			btnModificarSocio.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					ISocioMoficar ms = new ISocioMoficar();
					ms.setVisible(true);
				}
			});
			btnModificarSocio.setIcon(new ImageIcon(IBuscarSocio.class.getResource("/Images/Login/documento-de-modificar-el-archivo-de-papel-icono-4468-96 (1).png")));
			btnModificarSocio.setForeground(Color.BLUE);
			btnModificarSocio.setBackground(SystemColor.activeCaptionBorder);
			btnModificarSocio.setBounds(173, 373, 150, 24);
			panel.add(btnModificarSocio);
			btnBucar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					if(rdbtnDni.isSelected()==true){;
					int cant = SociosDB.buscarXDNI((Integer.parseInt(txBuscado.getText()))).size();
					if(cant==0){ JOptionPane.showMessageDialog(null,"No se econtro ningun socio");}
					else{
						for(int x=0;x<cant ;x++) {
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
							for(int x=0;x<cant;x++){
								ArrayList<Socio> sl = SociosDB.buscarXIdentidad(txBuscado.getText().toUpperCase());
								entity.Socio s = new Socio();
								s = sl.get(x);
								modelo.addRow(new Object[]{s.getDniSocio(),s.getIdentidad(),s.getDomicilio(),s.getSexo(),s.getTelefono()});
							}
						}
					}

				}
			});
			
		}


		setBounds(100, 100, 683, 470);
		getContentPane().setLayout(null);

		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int fila=table.getSelectedRow();
				Integer valorCelda =  (Integer) table.getValueAt(fila,0);
				ILibrosPorSocio.txDni.setText(String.valueOf(valorCelda));
				dispose();
			}
		});
		
		/*for(int x=0;x<SociosDB.buscarXDNI(Integer.parseInt(txBuscado.getText())).size();x++) {
			//modelo.addRow(new Object[]{SociosDB.buscarXDNI(Integer.parseInt(txBuscado.getText())).get(x).getDniSocio(),SociosDB.buscarXDNI(Integer.parseInt(txBuscado.getText())).get(x).getIdentidad(),SociosDB.buscarXDNI(Integer.parseInt(txBuscado.getText())).get(x).getDomicilio(),SociosDB.buscarXDNI(Integer.parseInt(txBuscado.getText())),SociosDB.buscarXDNI(Integer.parseInt(txBuscado.getText())).get(x).getTelefono()});
			}
		 */
	}
}
