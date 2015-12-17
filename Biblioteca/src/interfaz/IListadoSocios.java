package interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import ctrolDataBase.SociosDB;
import entity.Socio;

import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class IListadoSocios extends JDialog {
	private JTable table;
	private JTextField textField;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application. Prueba!!!
	 */
	public static void main(String[] args) {
		try {
			IListadoSocios dialog = new IListadoSocios();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public IListadoSocios() {
		setTitle("FCYT BIBLIOTECA - BUSQUEDA SOCIO");
		setBounds(100, 100, 713, 440);
		getContentPane().setLayout(null);
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(34, 76, 610, 245);
			getContentPane().add(scrollPane);
			{
				table = new JTable();
				table.setFont(new Font("Arial", Font.PLAIN, 11));
				table.setForeground(new Color(0, 0, 128));
				table.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
						"DNI", "Identidad", "Direcci\u00F3n", "Sexo", "Telefono"
					}
				));
				table.getColumnModel().getColumn(0).setPreferredWidth(60);
				table.getColumnModel().getColumn(1).setPreferredWidth(150);
				table.getColumnModel().getColumn(2).setPreferredWidth(110);
				table.getColumnModel().getColumn(3).setPreferredWidth(38);
				table.getColumnModel().getColumn(4).setPreferredWidth(100);
				scrollPane.setViewportView(table);
			}

			JLabel lblBuscar = new JLabel("Buscar");
			lblBuscar.setForeground(Color.BLUE);
			lblBuscar.setBounds(34, 24, 46, 14);
			getContentPane().add(lblBuscar);



			JButton btnBuscar = new JButton("Buscar");
			btnBuscar.setForeground(Color.BLUE);
			btnBuscar.setBounds(584, 20, 89, 23);
			getContentPane().add(btnBuscar);

			JLabel lblBuscarPor = new JLabel("Buscar por:");
			lblBuscarPor.setForeground(Color.BLUE);
			lblBuscarPor.setBounds(34, 49, 74, 14);
			getContentPane().add(lblBuscarPor);

			JRadioButton rdbtnNombre = new JRadioButton("Nombre");
			rdbtnNombre.setSelected(true);
			rdbtnNombre.setForeground(Color.BLUE);
			buttonGroup.add(rdbtnNombre);
			rdbtnNombre.setBounds(135, 46, 109, 23);
			getContentPane().add(rdbtnNombre);

			JRadioButton rdbtnDni = new JRadioButton("DNI");
			rdbtnDni.setForeground(Color.BLUE);
			buttonGroup.add(rdbtnDni);
			rdbtnDni.setBounds(291, 46, 109, 23);
			getContentPane().add(rdbtnDni);

			JButton btnLimpiarTabla = new JButton("Limpiar Tabla");
			btnLimpiarTabla.setIcon(new ImageIcon(IListadoSocios.class.getResource("/Images/Login/8fc03fbe37e8ed0e1e784244c68f3fe8.png")));
			btnLimpiarTabla.setBackground(Color.WHITE);
			btnLimpiarTabla.setBounds(507, 52, 142, 23);
			getContentPane().add(btnLimpiarTabla);

			JButton button_1 = new JButton("Cerrar");
			button_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					dispose();
				}
			});
			button_1.setIcon(new ImageIcon(IListadoSocios.class.getResource("/Images/Login/210px-Cruz_roja (1).png")));
			button_1.setVerticalTextPosition(SwingConstants.BOTTOM);
			button_1.setInheritsPopupMenu(true);
			button_1.setIgnoreRepaint(true);
			button_1.setHorizontalTextPosition(SwingConstants.LEFT);
			button_1.setForeground(new Color(165, 42, 42));
			button_1.setFont(new Font("Segoe Print", Font.BOLD, 11));
			button_1.setBackground(Color.LIGHT_GRAY);
			button_1.setBounds(569, 354, 105, 23);
			getContentPane().add(button_1);

			JButton btnNuevoSocio = new JButton("Nuevo Socio");
			btnNuevoSocio.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					dispose();
					INuevoSocio ns = new INuevoSocio();
					ns.setVisible(true);
				}
			});
			btnNuevoSocio.setIcon(new ImageIcon(IListadoSocios.class.getResource("/Images/Login/red-sign-computer-green-icon-mark-symbol-cartoon.png")));
			btnNuevoSocio.setForeground(new Color(0, 102, 0));
			btnNuevoSocio.setBackground(SystemColor.activeCaptionBorder);
			btnNuevoSocio.setBounds(10, 353, 142, 24);
			getContentPane().add(btnNuevoSocio);
			DefaultTableModel modelo = (DefaultTableModel)table.getModel();

			textField = new JTextField();
			textField.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent arg0) {
					for (int i = 0; i < table.getRowCount(); i++) {
						modelo.removeRow(i);
						i-=1;
					}
					if(rdbtnNombre.isSelected()){
						ArrayList<Socio> ls = SociosDB.BusquedaSocio(textField.getText().toUpperCase());
						int cant=ls.size();
						for(int x=0;x<cant;x++) {
							entity.Socio s = new entity.Socio();
							s = ls.get(x); 
							modelo.addRow(new Object[]{s.getDniSocio(),s.getIdentidad(),s.getDomicilio(),s.getSexo(),s.getTelefono()});
						}
					}
					if(rdbtnDni.isSelected()){
						ArrayList<Socio> ls = SociosDB.buscarXDNI(Integer.valueOf(textField.getText()));
						Socio s=ls.get(0);
						modelo.addRow(new Object[]{s.getDniSocio(),s.getIdentidad(),s.getDomicilio(),s.getSexo(),s.getTelefono()});
					}
				}
			});
			textField.setBounds(90, 21, 484, 20);
			getContentPane().add(textField);
			textField.setColumns(10);





		}
	}
}
