package interfaz;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;


import ctrolDataBase.EjemplarDB;
import ctrolDataBase.PrestamoDB;
import ctrolDataBase.SancionDB;
import ctrolDataBase.SociosDB;
import entity.Ejemplar;
import entity.Prestamo;
import entity.Socio;
import impresion.Impresion;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import java.util.Locale;
import com.toedter.calendar.JDateChooser;

public class INuevoPrestamo extends JDialog {
	public static JTextField txBuscado;
	private JTextField txDni;
	private JTextField txIDEJemplar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			INuevoPrestamo dialog = new INuevoPrestamo();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public INuevoPrestamo() {
		setTitle("FCYT BIBLIOTECA - NUEVO PRESTAMO");
		setBounds(100, 100, 674, 632);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 630, 300);
		getContentPane().add(panel);
		Border bordejpanel = new TitledBorder(new EtchedBorder(),"Buscar Ejemplares Disponibles");
		panel.setBorder(bordejpanel);
		panel.setLayout(null);

		JLabel lblLibro = new JLabel("ISBN");
		lblLibro.setForeground(Color.BLUE);
		lblLibro.setBounds(10, 27, 59, 14);
		panel.add(lblLibro);

	
		


		JButton btnBuscarIsbn = new JButton("Buscar Libro");
		btnBuscarIsbn.setBackground(Color.LIGHT_GRAY);
		btnBuscarIsbn.setForeground(Color.BLUE);
		btnBuscarIsbn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				IBuscarLibro bl = new IBuscarLibro();
				bl.setVisible(true);
			}
		});
		btnBuscarIsbn.setBounds(175, 23, 111, 23);
		panel.add(btnBuscarIsbn);

		JScrollPane scrollPane = new JScrollPane();

		scrollPane.setBounds(10, 68, 613, 196);
		panel.add(scrollPane);
		scrollPane.setAlignmentX(Component.RIGHT_ALIGNMENT);

		JTable table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"IDEjemplar", "FechaAlta","Cod Ubicación","ISBN"
				}
				));
		DefaultTableModel modelo = (DefaultTableModel)table.getModel();

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int fila=table.getSelectedRow();
				Integer valorCelda =  (Integer) table.getValueAt(fila,0);
				txIDEJemplar.setText(String.valueOf(valorCelda));
			}
		});

		scrollPane.setViewportView(table);


		
		
		
		JButton btnBuscarEjempalr = new JButton("Buscar Ejemplar");
		btnBuscarEjempalr.setBackground(Color.LIGHT_GRAY);
		btnBuscarEjempalr.setForeground(Color.BLUE);
		btnBuscarEjempalr.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ArrayList<Ejemplar> le = ctrolDataBase.PrestamoDB.EjemplaresDisponibles(txBuscado.getText());
				if(le.isEmpty()){
					IPreguntaReserva pr = new IPreguntaReserva();
					pr.setLocationRelativeTo(null);
					pr.setVisible(true);
				}
				for (int x=0; x<le.size();x++){
					Ejemplar e = le.get(x);
					modelo.addRow(new Object[]{e.getNumInventario(),e.getFechaAlta(),e.getCodUbicaion(),e.getIsbn()});

				}

			}
		});
		btnBuscarEjempalr.setBounds(296, 23, 130, 23);
		panel.add(btnBuscarEjempalr);

		JButton btnLimpiarTabla = new JButton("Limpiar Tabla");
		btnLimpiarTabla.setForeground(Color.BLUE);
		btnLimpiarTabla.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				for (int i = 0; i < table.getRowCount(); i++) {
					modelo.removeRow(i);
					i-=1;
				}
			}
		});
		btnLimpiarTabla.setIcon(new ImageIcon(INuevoPrestamo.class.getResource("/Images/Login/8fc03fbe37e8ed0e1e784244c68f3fe8.png")));
		btnLimpiarTabla.setBackground(Color.LIGHT_GRAY);
		btnLimpiarTabla.setBounds(478, 44, 142, 23);
		panel.add(btnLimpiarTabla);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 314, 306, 214);
		getContentPane().add(panel_1);
		Border bordejpanel_1 = new TitledBorder(new EtchedBorder(),"Datos prestamo");
		panel_1.setBorder(bordejpanel_1);
		panel_1.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.CYAN, null, null, null));
		panel_3.setBounds(95, 137, 185, 20);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JDateChooser calendarCombo1 = new JDateChooser();
		calendarCombo1.setBounds(0, 0, 185, 20);
		calendarCombo1.getJCalendar().setMinSelectableDate(new Date());
		panel_3.add(calendarCombo1);
		

		/*calendarCombo = new JCalendarCombo();
		calendarCombo.setBounds(0, 0, 185, 20);
		panel_3.add(calendarCombo);
		calendarCombo.setTodayFont(UIManager.getFont("ComboBox.font"));
		calendarCombo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		calendarCombo.setBackground(new Color(0, 153, 255));
		calendarCombo.setForeground(Color.LIGHT_GRAY);
		calendarCombo.setDayOfWeekFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		calendarCombo.setDayFont(new Font("Century", Font.BOLD | Font.ITALIC, 14));
		calendarCombo.setEditable(true);
		calendarCombo.setModel(new DefaultComboBoxModel(new String[] {"Seleccione una fecha"}));
		calendarCombo.setNullAllowed(false);
		*/

		JLabel lblDni = new JLabel("DNI");
		lblDni.setForeground(Color.BLUE);
		lblDni.setBounds(10, 32, 46, 14);
		panel_1.add(lblDni);

		

		txIDEJemplar = new JTextField();
		txIDEJemplar.setBounds(131, 79, 86, 20);
		panel_1.add(txIDEJemplar);
		txIDEJemplar.setColumns(10);

		JLabel lblIdEjemplar = new JLabel("ID Ejemplar");
		lblIdEjemplar.setForeground(Color.BLUE);
		lblIdEjemplar.setBounds(10, 85, 75, 14);
		panel_1.add(lblIdEjemplar);

		JLabel lblFechaLimite = new JLabel("Fecha Limite");
		lblFechaLimite.setForeground(Color.BLUE);
		lblFechaLimite.setBounds(10, 140, 75, 14);
		panel_1.add(lblFechaLimite);

		JPanel panel_2 = new JPanel();
		panel_2.setForeground(Color.BLUE);
		panel_2.setBounds(336, 314, 306, 214);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		Border bordejpanel_2 = new TitledBorder(new EtchedBorder(),"Datos Socio");
		panel_2.setBorder(bordejpanel_2);
		panel_2.setLayout(null);

		JLabel lblIdentidad = new JLabel("Identidad");
		lblIdentidad.setForeground(Color.BLUE);
		lblIdentidad.setBounds(10, 24, 100, 14);
		panel_2.add(lblIdentidad);

		JLabel lblDireccin = new JLabel("Direcci\u00F3n");
		lblDireccin.setForeground(Color.BLUE);
		lblDireccin.setBounds(10, 65, 100, 14);
		panel_2.add(lblDireccin);

		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setForeground(Color.BLUE);
		lblTelefono.setBounds(10, 106, 100, 14);
		panel_2.add(lblTelefono);

		JLabel lblCIdentidad = new JLabel("");
		lblCIdentidad.setBounds(86, 24, 179, 14);
		panel_2.add(lblCIdentidad);

		JLabel lblCDireccion = new JLabel("");
		lblCDireccion.setBounds(86, 65, 179, 14);
		panel_2.add(lblCDireccion);

		JLabel lblCTelefono = new JLabel("");
		lblCTelefono.setBounds(86, 106, 179, 14);
		panel_2.add(lblCTelefono);

		JLabel lblSocioSancionado = new JLabel("El socio se encuentra sancionado");
		lblSocioSancionado.setFont(new Font("Thames", Font.PLAIN, 13));
		lblSocioSancionado.setForeground(new Color(255, 0, 0));
		lblSocioSancionado.setBounds(47, 151, 229, 14);
		lblSocioSancionado.setVisible(false);
		panel_2.add(lblSocioSancionado);
		

		JButton btnValidar = new JButton("Validar");
		btnValidar.setBackground(Color.LIGHT_GRAY);
		btnValidar.setForeground(Color.BLUE);
		btnValidar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				if(txDni.getText().length()==0){ISocioNoEncontrado sne = new ISocioNoEncontrado();
				sne.setLocationRelativeTo(null);
				sne.setVisible(true);}
				else{
					ArrayList<Socio> ls =ctrolDataBase.SociosDB.buscarXDNI(Integer.parseInt(txDni.getText()));
					try {
						Socio s= ls.get(0);
						lblCIdentidad.setText(s.getIdentidad());
						lblCTelefono.setText(s.getTelefono());
						lblCDireccion.setText(s.getDomicilio());
					} catch (Exception e) {
						// TODO: handle exception
						ISocioNoEncontrado sne = new ISocioNoEncontrado();
						sne.setLocationRelativeTo(null);
						sne.setVisible(true);
					}

				}
				int a = SancionDB.SancionVigente(Integer.valueOf(txDni.getText()));
				if(a!=0){lblSocioSancionado.setVisible(true);}else{lblSocioSancionado.setVisible(false);}


			}
		});
		btnValidar.setBounds(207, 180, 89, 23);
		panel_1.add(btnValidar);

		JButton btnResgitrarprestamo = new JButton("ResgitrarPrestamo");
		btnResgitrarprestamo.setBackground(Color.LIGHT_GRAY);
		btnResgitrarprestamo.setForeground(Color.BLUE);
		btnResgitrarprestamo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				ArrayList<Socio> ls =ctrolDataBase.SociosDB.buscarXDNI(Integer.parseInt(txDni.getText()));
				Socio s= ls.get(0);
				lblCIdentidad.setText(s.getIdentidad());
				lblCTelefono.setText(s.getTelefono());
				lblCDireccion.setText(s.getDomicilio());
				Calendar calendar = Calendar.getInstance();
				java.sql.Date date = new java.sql.Date(calendar.getTime().getTime());
				Date fechaHoy = date;
				Calendar calendar2 = calendarCombo1.getCalendar().getInstance();
				calendar2.set(Calendar.YEAR, calendarCombo1.getCalendar().get(calendar.YEAR));
				calendar2.set(Calendar.DAY_OF_MONTH, calendarCombo1.getCalendar().get(Calendar.DAY_OF_MONTH));
				calendar2.set(Calendar.MONTH, calendarCombo1.getCalendar().get(Calendar.MONTH) ); // Assuming you wanted May 1st
				java.sql.Date fechalimite = new java.sql.Date(calendar2.getTime().getTime());
				System.out.println("----> "+ fechalimite);
				try {
					ctrolDataBase.PrestamoDB.nuevoPrestamo((java.sql.Date) fechaHoy,Integer.parseInt(txIDEJemplar.getText()) , fechalimite, null, Integer.parseInt(txDni.getText()));
					Impresion.imprimirComprobante(Integer.parseInt(txDni.getText()), fechalimite, Integer.parseInt(txIDEJemplar.getText()));

				} catch (Exception e) {
					// TODO: handle exception
				}
				
				
				try {
		        	Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+"C:\\Users\\Alejandro\\Google Drive\\Facultad\\3ro\\Biblioteca\\Biblioteca\\reporte_2_Comprobante_PDF.pdf");
		        	System.out.println("Final");
		        	} catch (IOException e) {
		        	// TODO Auto-generated catch block
		        	e.printStackTrace();
		        	}
				dispose();
				ArrayList<Prestamo> listaPrestamo= PrestamoDB.PrestamosVigentes();
				int cant=listaPrestamo.size();
				for (int i = 0; i < UIPrincipañ.table.getRowCount(); i++) {
					UIPrincipañ.modelo.removeRow(i);
					i-=1;
				}
				for(int x=0;x< cant;x++) {
					Prestamo pe = new Prestamo();
					pe = listaPrestamo.get(x); 
					Calendar calendar1 = Calendar.getInstance();
					java.sql.Date date1 = new java.sql.Date(calendar1.getTime().getTime());
					Date fechaHoy1 = date1;
						Color c= new Color(51,102,0);
						String titulo = EjemplarDB.ObtenerTitulo(pe.getNumEjemplarDB());
						ArrayList<Socio> soc = SociosDB.buscarXDNI(pe.getDniSocio());
						Socio s1= soc.get(0);
						UIPrincipañ.modelo.addRow(new Object[]{pe.getFechaPrestamo(),pe.getNumEjemplarDB(),titulo,pe.getFechaLimite(),pe.getDniSocio(),s1.getIdentidad()});
						System.out.println("paso "+x);
					}
				}

		});
		btnResgitrarprestamo.setBounds(341, 547, 175, 23);
		getContentPane().add(btnResgitrarprestamo);

		JButton btnVolver = new JButton("Volver");
		btnVolver.setBackground(Color.LIGHT_GRAY);
		btnVolver.setForeground(Color.BLUE);
		btnVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
			}
		});
		btnVolver.setBounds(547, 547, 89, 23);
		getContentPane().add(btnVolver);

		JButton btnRegistrarDevolucin = new JButton("Registrar Devoluci\u00F3n");
		btnRegistrarDevolucin.setBackground(Color.LIGHT_GRAY);
		btnRegistrarDevolucin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				IDevolucionPrestamo dp = new IDevolucionPrestamo();
				dp.setVisible(true);


			}
		});
		btnRegistrarDevolucin.setForeground(new Color(0, 128, 0));
		btnRegistrarDevolucin.setBounds(156, 547, 175, 23);
		getContentPane().add(btnRegistrarDevolucin);

		
		txBuscado = new JTextField();
		txBuscado.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (txBuscado.getText().length() == 10) {
					System.out.println("entro..");
					ArrayList<Ejemplar> le = ctrolDataBase.PrestamoDB.EjemplaresDisponibles(txBuscado.getText());
					if (le.isEmpty()) {
						IPreguntaReserva pr = new IPreguntaReserva();
						pr.setLocationRelativeTo(null);
						pr.setVisible(true);
					}
					for (int x = 0; x < le.size(); x++) {
						Ejemplar e1 = le.get(x);
						modelo.addRow(new Object[] { e1.getNumInventario(), e1.getFechaAlta(), e1.getCodUbicaion(),
								e1.getIsbn() });

					}
				} else {
					IBuscarLibro bl = new IBuscarLibro();
					bl.setVisible(true);
				}
			}
		});
		txBuscado.setBounds(79, 24, 86, 20);
		panel.add(txBuscado);
		txBuscado.setColumns(10);
		
		
		txDni = new JTextField();
		txDni.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
					try {
						if (txDni.getText().length()> 6 && txDni.getText().length()<9 ){
						ArrayList<Socio> ls =ctrolDataBase.SociosDB.buscarXDNI(Integer.parseInt(txDni.getText()));
							Socio s= ls.get(0);
							lblCIdentidad.setText(s.getIdentidad());
							lblCTelefono.setText(s.getTelefono());
							lblCDireccion.setText(s.getDomicilio());
						}
					} catch (Exception e2) {
						// TODO: handle exception
					}
					if(txDni.getText().length()> 7 && lblCIdentidad.getText().length()==0){
						ISocioNoEncontrado sne = new ISocioNoEncontrado();
						sne.setLocationRelativeTo(null);
						sne.setVisible(true);
					}
						
				
			}
		});
		txDni.setBounds(131, 26, 86, 20);
		panel_1.add(txDni);
		txDni.setColumns(10);

	}
	
}
