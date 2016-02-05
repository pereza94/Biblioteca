package interfaz;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import entity.Socio;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.Font;

public class IRegistrarSancion extends JDialog {
	public static JTextField txDNI;
	public static JLabel lblHacerClickSobre = new JLabel("Hacer click sobre el Dni para verificar datos");
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			IRegistrarSancion dialog = new IRegistrarSancion();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
	/**
	 * Create the dialog.
	 */
	public IRegistrarSancion() {
		setBounds(100, 100, 704, 420);
		getContentPane().setLayout(null);


		JPanel panel = new JPanel();
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		panel.setBounds(0, 0, 688, 381);
		getContentPane().add(panel);
		Border bordejpanel = new TitledBorder(new EtchedBorder(),"Registrar Sanción");
		panel.setBorder(bordejpanel);
		panel.setLayout(null);

		JLabel lblDni = new JLabel("DNI");
		lblDni.setForeground(Color.BLUE);
		lblDni.setBounds(139, 25, 46, 14);
		panel.add(lblDni);

	

		JPanel panel_1 = new JPanel();
		panel_1.setForeground(new Color(153, 204, 102));
		panel_1.setBounds(48, 76, 453, 163);
		panel.add(panel_1);
		Border bordejpanel1 = new TitledBorder(new EtchedBorder(),"Datos Socios");
		panel_1.setBorder(bordejpanel1);
		panel_1.setLayout(null);

		JLabel lblIdentidad = new JLabel("Identidad");
		lblIdentidad.setForeground(new Color(0, 128, 0));
		lblIdentidad.setBounds(10, 32, 79, 14);
		panel_1.add(lblIdentidad);

		JLabel lblLocalidad = new JLabel("Direcci\u00F3n");
		lblLocalidad.setForeground(new Color(0, 128, 0));
		lblLocalidad.setBounds(10, 62, 80, 14);
		panel_1.add(lblLocalidad);

		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setForeground(new Color(0, 128, 0));
		lblTelefono.setBounds(10, 87, 80, 14);
		panel_1.add(lblTelefono);

		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setForeground(new Color(0, 128, 0));
		lblSexo.setBounds(10, 112, 80, 14);
		panel_1.add(lblSexo);

		JLabel lblCIDentidad = new JLabel("");
		lblCIDentidad.setForeground(new Color(153, 204, 102));
		lblCIDentidad.setBounds(81, 32, 231, 14);
		panel_1.add(lblCIDentidad);

		JLabel lblCDirección = new JLabel("");
		lblCDirección.setForeground(new Color(153, 204, 102));
		lblCDirección.setBounds(81, 62, 231, 14);
		panel_1.add(lblCDirección);

		JLabel lblCTelefono = new JLabel("");
		lblCTelefono.setForeground(new Color(153, 204, 102));
		lblCTelefono.setBounds(81, 87, 231, 14);
		panel_1.add(lblCTelefono);

		JLabel lblCSexo = new JLabel("");
		lblCSexo.setForeground(new Color(153, 204, 102));
		lblCSexo.setBounds(81, 112, 231, 14);
		panel_1.add(lblCSexo);

		JLabel lblSancionesAnteriores = new JLabel("Sanciones Anteriores");
		lblSancionesAnteriores.setForeground(new Color(0, 128, 0));
		lblSancionesAnteriores.setBounds(10, 137, 124, 14);
		panel_1.add(lblSancionesAnteriores);

		JLabel lblCSancionesAnterios = new JLabel("");
		lblCSancionesAnterios.setForeground(new Color(153, 204, 102));
		lblCSancionesAnterios.setBounds(160, 137, 46, 14);
		panel_1.add(lblCSancionesAnterios);

		JLabel lblCantidadDeDas = new JLabel("Cantidad de D\u00EDas");
		lblCantidadDeDas.setForeground(new Color(153, 0, 0));
		lblCantidadDeDas.setBounds(89, 252, 101, 14);
		panel.add(lblCantidadDeDas);

		

		JLabel lblFechaFinDe = new JLabel("Fecha Fin de la Sanci\u00F3n");
		lblFechaFinDe.setForeground(new Color(153, 0, 0));
		lblFechaFinDe.setBounds(298, 252, 147, 14);
		panel.add(lblFechaFinDe);

		JLabel lblCFechaFin = new JLabel("");
		lblCFechaFin.setForeground(SystemColor.textHighlight);
		lblCFechaFin.setHorizontalAlignment(SwingConstants.LEFT);
		lblCFechaFin.setBounds(432, 252, 124, 14);
		panel.add(lblCFechaFin);

		JButton btnVolver = new JButton("Volver");
		btnVolver.setBackground(Color.LIGHT_GRAY);
		btnVolver.setForeground(new Color(51, 51, 204));
		btnVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
			}
		});
		btnVolver.setBounds(557, 335, 89, 23);
		panel.add(btnVolver);

		
		
		lblHacerClickSobre.setEnabled(false);
		lblHacerClickSobre.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblHacerClickSobre.setHorizontalAlignment(SwingConstants.CENTER);
		lblHacerClickSobre.setForeground(new Color(60, 179, 113));
		lblHacerClickSobre.setBounds(139, 51, 289, 14);
		panel.add(lblHacerClickSobre);
		lblHacerClickSobre.setVisible(false);


		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBackground(Color.LIGHT_GRAY);
		btnBuscar.setForeground(Color.BLUE);
		btnBuscar.setIcon(new ImageIcon(IRegistrarSancion.class.getResource("/Images/Login/lupa (1).png")));
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				IBuscarSocio bs = new IBuscarSocio();
				bs.setVisible(true);
				lblHacerClickSobre.setVisible(true);
				entity.Socio socio = new entity.Socio();
				try {
					ArrayList<Socio> ll=ctrolDataBase.SociosDB.buscarXDNI(Integer.parseInt(txDNI.getText()));
					socio = ll.get(0);
					lblCIDentidad.setText(socio.getIdentidad());
					lblCDirección.setText(socio.getDomicilio());
					lblCTelefono.setText(socio.getTelefono());
					System.out.println(socio.getSexo());
					if(socio.getSexo().equals("M") ){lblCSexo.setText("Masculino");}
					else{lblCSexo.setText("Femenino");}

					lblCSancionesAnterios.setText(String.valueOf((ctrolDataBase.SancionDB.sancionesAnteriores(Integer.parseInt(txDNI.getText())))));

				} catch (Exception e2) {
					// TODO: handle exception
				}
				
				
				
			}
		});
		btnBuscar.setBounds(313, 21, 115, 23);
		panel.add(btnBuscar);
		JSpinner spinner = new JSpinner();
		spinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				int a = (int) spinner.getValue(); 
				int b = ctrolDataBase.SancionDB.obtenerNumeroSancion();
				Calendar calendar = Calendar.getInstance();
				java.sql.Date date = new java.sql.Date(calendar.getTime().getTime());
				Date fechaHoy = date;
				Calendar calendar2 = Calendar.getInstance();
				calendar2.setTime(date); // Configuramos la fecha que se recibe
				calendar2.add(Calendar.DAY_OF_YEAR, a);  // numero de días a añadir, o restar en caso de días<0
				java.sql.Date datefin = new java.sql.Date(calendar2.getTime().getTime());
				lblCFechaFin.setText(ctrolDataBase.EjemplarDB.convertirFechaString(datefin));
			}
		});
		
		spinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinner.setBounds(189, 249, 55, 20);
		panel.add(spinner);

		DateFormat calendarCombo;
		JButton btnRegistrarSancin = new JButton("Registrar Sanci\u00F3n");
		btnRegistrarSancin.setBackground(Color.LIGHT_GRAY);
		btnRegistrarSancin.setIcon(new ImageIcon(IRegistrarSancion.class.getResource("/Images/Login/checkok.jpg")));
		btnRegistrarSancin.setForeground(new Color(0, 102, 0));
		btnRegistrarSancin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int a = (int) spinner.getValue(); 
				int b = ctrolDataBase.SancionDB.obtenerNumeroSancion();
				System.out.print(b);
				Calendar calendar = Calendar.getInstance();
				java.sql.Date date = new java.sql.Date(calendar.getTime().getTime());
				Date fechaHoy = date;
				Calendar calendar2 = Calendar.getInstance();
				calendar2.setTime(date); // Configuramos la fecha que se recibe
				calendar2.add(Calendar.DAY_OF_YEAR, a);  // numero de días a añadir, o restar en caso de días<0
				java.sql.Date datefin = new java.sql.Date(calendar2.getTime().getTime());
				ctrolDataBase.SancionDB.insertarSancion(b, Integer.parseInt(txDNI.getText()),date,  datefin);
				lblCFechaFin.setText(ctrolDataBase.EjemplarDB.convertirFechaString(datefin));

				JOptionPane.showMessageDialog(null, "Sanción Registrada");
				dispose();
			}
		});
		btnRegistrarSancin.setBounds(351, 335, 186, 23);
		panel.add(btnRegistrarSancin);
		
	
	
		txDNI = new JTextField();
		txDNI.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				entity.Socio socio = new entity.Socio();
				ArrayList<Socio> ll=ctrolDataBase.SociosDB.buscarXDNI(Integer.parseInt(txDNI.getText()));
				socio = ll.get(0);
				lblCIDentidad.setText(socio.getIdentidad());
				lblCDirección.setText(socio.getDomicilio());
				lblCTelefono.setText(socio.getTelefono());
				System.out.println(socio.getSexo());
				if(socio.getSexo().equals("M") ){lblCSexo.setText("Masculino");}
				else{lblCSexo.setText("Femenino");}

				lblCSancionesAnterios.setText(String.valueOf((ctrolDataBase.SancionDB.sancionesAnteriores(Integer.parseInt(txDNI.getText())))));
			}
		});
		txDNI.setEditable(false);
		txDNI.setBounds(195, 22, 86, 20);
		panel.add(txDNI);
		txDNI.setColumns(10);
		
		
		
		
		
		
		
		
		


	}
	
}
