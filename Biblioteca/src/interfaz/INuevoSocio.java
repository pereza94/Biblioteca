package interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import UpperEssential.UpperEssentialLookAndFeel;
import ctrolDataBase.SociosDB;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.DefaultComboBoxModel;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Window.Type;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class INuevoSocio extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txNombre;
	private JTextField txDni;
	private JTextField txApellido;
	private JTextField txDireccion;
	private JTextField txTelefono;
	private JRadioButton rdbtnFemenino_1;
	private JRadioButton rdbtnMasculino_1;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			
			INuevoSocio dialog = new INuevoSocio();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public INuevoSocio() {
		/*try {
			UIManager.setLookAndFeel(new UpperEssentialLookAndFeel());
		} catch (UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
		setType(Type.UTILITY);
		setForeground(new Color(25, 25, 112));
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Alejandro\\Downloads\\Imagenes proyecto bilioteca\\10537167_814888468584804_6954407208930788448_n.png"));
		setTitle("BIBLIOTECA FCYT - NUEVO SOCIO");
		setBounds(100, 100, 478, 380);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setForeground(new Color(0, 0, 153));
		lblNombre.setBounds(10, 72, 74, 14);
		contentPanel.add(lblNombre);

		txNombre = new JTextField();
		txNombre.setForeground(new Color(51, 51, 51));
		txNombre.setBounds(111, 72, 298, 20);
		contentPanel.add(txNombre);
		txNombre.setColumns(10);

		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setForeground(new Color(0, 0, 153));
		lblApellido.setBounds(10, 109, 74, 14);
		contentPanel.add(lblApellido);

		JLabel lblDni = new JLabel("D.N.I");
		lblDni.setForeground(new Color(0, 0, 153));
		lblDni.setBounds(142, 40, 35, 14);
		contentPanel.add(lblDni);

		txDni = new JTextField();
		txDni.setForeground(new Color(51, 51, 51));
		txDni.setBounds(187, 37, 86, 20);
		contentPanel.add(txDni);
		txDni.setColumns(10);

		txApellido = new JTextField();
		txApellido.setForeground(new Color(51, 51, 51));
		txApellido.setBounds(111, 109, 298, 20);
		contentPanel.add(txApellido);
		txApellido.setColumns(10);

		JLabel lblDireccin = new JLabel("Direcci\u00F3n");
		lblDireccin.setForeground(new Color(0, 0, 153));
		lblDireccin.setBounds(10, 149, 73, 14);
		contentPanel.add(lblDireccin);

		txDireccion = new JTextField();
		txDireccion.setForeground(new Color(51, 51, 51));
		txDireccion.setBounds(111, 149, 298, 20);
		contentPanel.add(txDireccion);
		txDireccion.setColumns(10);

		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setForeground(new Color(0, 0, 153));
		lblTelefono.setBounds(10, 192, 80, 14);
		contentPanel.add(lblTelefono);

		txTelefono = new JTextField();
		txTelefono.setForeground(new Color(51, 51, 51));
		txTelefono.setBounds(111, 192, 298, 20);
		contentPanel.add(txTelefono);
		txTelefono.setColumns(10);

		JRadioButton rdbtnFemenino_1 = new JRadioButton("Femenino");
		rdbtnFemenino_1.setForeground(new Color(0, 0, 153));
		buttonGroup.add(rdbtnFemenino_1);
		rdbtnFemenino_1.setBounds(111, 229, 109, 23);
		contentPanel.add(rdbtnFemenino_1);

		JRadioButton rdbtnMasculino_1 = new JRadioButton("Masculino");
		rdbtnMasculino_1.setForeground(new Color(0, 0, 153));
		buttonGroup.add(rdbtnMasculino_1);
		rdbtnMasculino_1.setBounds(296, 229, 109, 23);
		contentPanel.add(rdbtnMasculino_1);

		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setForeground(new Color(0, 0, 153));
		lblSexo.setBounds(10, 233, 46, 14);
		contentPanel.add(lblSexo);

		JButton btnAceptar = new JButton("Guardar");
		btnAceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(txDni.getText().length()==0 || txApellido.getText().length()==0 ||txNombre.getText().length()==0 || txNombre.getText().length()==0 || txDireccion.getText().length()==0 ||(rdbtnFemenino_1.isSelected()==false && rdbtnMasculino_1.isSelected()==false)){JOptionPane.showMessageDialog(null, "Todos los campos deben ser completados");}
				else{
					Integer dni = Integer.parseInt(txDni.getText()) ;
					String identidad = txApellido.getText().toUpperCase()+" "+txNombre.getText().toUpperCase();
					String direccion = txDireccion.getText().toUpperCase();
					String telefono = txTelefono.getText().toUpperCase();
					String s = null;
					if (rdbtnMasculino_1.isSelected()){s = "M";}

					if(rdbtnFemenino_1.isSelected()){
						s = "F";
					}
					SociosDB.insertarSocio(dni,identidad,direccion,telefono,s);
				}
			}});

		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAceptar.setBounds(259, 307, 89, 23);
		contentPanel.add(btnAceptar);

		JButton btnVolver = new JButton("Volver");
		btnVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
			}
		});
		btnVolver.setBounds(358, 307, 89, 23);
		contentPanel.add(btnVolver);

		JLabel label = new JLabel("*");
		label.setForeground(new Color(0, 0, 153));
		label.setBounds(416, 72, 15, 14);
		contentPanel.add(label);

		JLabel label_1 = new JLabel("*");
		label_1.setForeground(new Color(0, 0, 153));
		label_1.setBounds(416, 109, 15, 14);
		contentPanel.add(label_1);

		JLabel label_2 = new JLabel("*");
		label_2.setForeground(new Color(0, 0, 153));
		label_2.setBounds(416, 149, 15, 14);
		contentPanel.add(label_2);

		JLabel label_3 = new JLabel("*");
		label_3.setForeground(new Color(0, 0, 153));
		label_3.setBounds(416, 195, 15, 14);
		contentPanel.add(label_3);

		JLabel lblCampoObligatorio = new JLabel("(*) Campo Obligatorio");
		lblCampoObligatorio.setForeground(new Color(0, 0, 153));
		lblCampoObligatorio.setBounds(10, 316, 127, 14);
		contentPanel.add(lblCampoObligatorio);


	}
}
