package interfaz;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

import UpperEssential.UpperEssentialLookAndFeel;
import ctrolDataBase.EjemplarDB;
import ctrolDataBase.PrestamoDB;
import ctrolDataBase.SociosDB;
import entity.Prestamo;
import entity.Socio;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowListener;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;

public class UIPrincipañ extends JDialog {

	public static DefaultTableModel modelo;
	public static JTable table;
	public static UIOpcionSocio os ;
	public static UIOpcionLibro ol;
	public static UIOpcionReserva or;
	public static INuevoPrestamo np ;
	public static UIOpcSancion rs ;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {

			UIPrincipañ dialog = new UIPrincipañ();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



	/**
	 * Create the dialog.
	 */
	public UIPrincipañ() {
		setTitle("FCYT BIBLIOTECA");

		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		/*try {
			UIManager.setLookAndFeel(new UpperEssentialLookAndFeel());
		} catch (UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
		setBounds(100, 100, 1021, 576);
		getContentPane().setLayout(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 36, 775, 344);
		getContentPane().add(scrollPane);
		{
			table = new JTable();
			table.setForeground(Color.BLUE);
			table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Fecha Prestamo", "ID Ejemplar", "Titulo ", "Fecha Limite", "DNI", "Socio"
				}
			));
			table.getColumnModel().getColumn(0).setPreferredWidth(60);
			table.getColumnModel().getColumn(2).setPreferredWidth(130);
			table.getColumnModel().getColumn(3).setPreferredWidth(71);
			table.getColumnModel().getColumn(5).setPreferredWidth(120);
			scrollPane.setViewportView(table);
		}
		modelo = (DefaultTableModel)table.getModel();
		ArrayList<Prestamo> listaPrestamo= PrestamoDB.PrestamosVigentes();
		int cant=listaPrestamo.size();

		for(int x=0;x< cant;x++) {
			Prestamo pe = new Prestamo();
			pe = listaPrestamo.get(x); 
			Calendar calendar = Calendar.getInstance();
			java.sql.Date date = new java.sql.Date(calendar.getTime().getTime());
			Date fechaHoy = date;
			if(pe.getFechaLimite().after(fechaHoy))
			{
				Color c= new Color(51,102,0);
				table.setForeground(c);	
				String titulo = EjemplarDB.ObtenerTitulo(pe.getNumEjemplarDB());
				ArrayList<Socio> soc = SociosDB.buscarXDNI(pe.getDniSocio());
				Socio s= soc.get(0);
				modelo.addRow(new Object[]{pe.getFechaPrestamo(),pe.getNumEjemplarDB(),titulo,pe.getFechaLimite(),pe.getDniSocio(),s.getIdentidad()});

			}
			if(pe.getFechaLimite().before(fechaHoy))
			{
				String titulo = EjemplarDB.ObtenerTitulo(pe.getNumEjemplarDB());
				ArrayList<Socio> soc = SociosDB.buscarXDNI(pe.getDniSocio());
				Socio s= soc.get(0);
				modelo.addRow(new Object[]{pe.getFechaPrestamo(),pe.getNumEjemplarDB(),titulo,pe.getFechaLimite(),pe.getDniSocio(),s.getIdentidad()});

			}
		}


		JLabel lblPrestamosVigentes = new JLabel("Prestamos vigentes");
		lblPrestamosVigentes.setForeground(new Color(0, 128, 0));
		lblPrestamosVigentes.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrestamosVigentes.setBounds(299, 11, 132, 14);
		getContentPane().add(lblPrestamosVigentes);

		JLabel lblprestamosVigentes = new JLabel("*Prestamos vigentes");
		lblprestamosVigentes.setForeground(new Color(0, 100, 0));
		lblprestamosVigentes.setBounds(25, 403, 156, 33);
		getContentPane().add(lblprestamosVigentes);

		JButton btnGestinSocio = new JButton("Gesti\u00F3n Socio");
		btnGestinSocio.setToolTipText(" ");
		btnGestinSocio.setBackground(Color.LIGHT_GRAY);
		btnGestinSocio.setIcon(new ImageIcon(UIPrincipañ.class.getResource("/Images/Login/userlogo0111 (1) (2).png")));
		btnGestinSocio.setForeground(Color.BLUE);
		btnGestinSocio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		buttonGroup.add(btnGestinSocio);
		btnGestinSocio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (os != null) {//si existe una venta, la cierra.
					os.dispose();
				}
				os= new UIOpcionSocio();
				os.setLocationRelativeTo(null);
				os.setVisible(true);

			}
		});
		btnGestinSocio.setBounds(823, 36, 156, 40);
		getContentPane().add(btnGestinSocio);

		JButton btnGLibro = new JButton("Gesti\u00F3n Libro");
		btnGLibro.setBackground(Color.LIGHT_GRAY);
		btnGLibro.setIcon(new ImageIcon(UIPrincipañ.class.getResource("/Images/Login/Gu\u00EDa (1).png")));
		btnGLibro.setForeground(Color.BLUE);
		buttonGroup.add(btnGLibro);
		btnGLibro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (ol != null) {//si existe una venta, la cierra.
					ol.dispose();
				}
				ol = new UIOpcionLibro();
				ol.setLocationRelativeTo(null);
				ol.setVisible(true);
			}
		});
		btnGLibro.setBounds(823, 112, 156, 40);
		getContentPane().add(btnGLibro);

		JButton btnGestinReserva = new JButton("Gesti\u00F3n Reserva");
		btnGestinReserva.setBackground(Color.LIGHT_GRAY);
		btnGestinReserva.setIcon(new ImageIcon(UIPrincipañ.class.getResource("/Images/Login/icono_calendario (1).png")));
		btnGestinReserva.setForeground(Color.BLUE);
		buttonGroup.add(btnGestinReserva);
		btnGestinReserva.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (or != null) {//si existe una venta, la cierra.
					or.dispose();
				}
				or = new UIOpcionReserva();
				or.setLocationRelativeTo(null);
				or.setVisible(true);
			}
		});
		btnGestinReserva.setBounds(823, 200, 156, 40);
		getContentPane().add(btnGestinReserva);

		JButton btnNuevoPrestamo = new JButton("Nuevo Prestamo / Devoluci\u00F3n");
		btnNuevoPrestamo.setIcon(new ImageIcon(UIPrincipañ.class.getResource("/Images/Login/prestamo (2).png")));
		btnNuevoPrestamo.setBackground(Color.LIGHT_GRAY);
		btnNuevoPrestamo.setForeground(Color.BLUE);
		btnNuevoPrestamo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (np != null) {//si existe una venta, la cierra.
					np.dispose();
				}
				np= new INuevoPrestamo();
				np.setLocationRelativeTo(null);
				np.setVisible(true);
			}
		});
		btnNuevoPrestamo.setBounds(22, 463, 775, 33);
		getContentPane().add(btnNuevoPrestamo);

		JButton btnGSancion = new JButton("Gesti\u00F3n Sanci\u00F3n");
		btnGSancion.setBackground(Color.LIGHT_GRAY);
		btnGSancion.setIcon(new ImageIcon(UIPrincipañ.class.getResource("/Images/Login/Prohibido.png")));
		btnGSancion.setForeground(Color.BLUE);
		buttonGroup.add(btnGSancion);
		btnGSancion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (rs != null) {//si existe una venta, la cierra.
					rs.dispose();
				}
				rs= new UIOpcSancion();
				rs.setLocationRelativeTo(null);
				rs.setVisible(true);
			}
		});
		btnGSancion.setBounds(823, 283, 156, 40);
		getContentPane().add(btnGSancion);

		JButton btnSalir = new JButton("Salir");
		btnSalir.setBackground(Color.LIGHT_GRAY);
		btnSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
			}
		});
		btnSalir.setForeground(Color.RED);
		btnSalir.setBounds(904, 488, 89, 23);
		getContentPane().add(btnSalir);


	}



}