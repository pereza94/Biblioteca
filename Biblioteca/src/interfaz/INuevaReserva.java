package interfaz;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.freixas.jcalendar.JCalendarCombo;

import ctrolDataBase.ReservaDB;
import entity.Reserva;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;

public class INuevaReserva extends JDialog {
	public static JTextField textIdEjemplar;
	private JTextField txCDNI;
	public static JTextField txISBNaBuscar;



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			INuevaReserva dialog = new INuevaReserva();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 * @return 
	 */
	public INuevaReserva() {

		setBounds(100, 100, 610, 384);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setForeground(Color.BLUE);
		panel.setBounds(10, 11, 572, 326);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblIdEjemplar = new JLabel("ID EJEMPLAR");
		lblIdEjemplar.setForeground(Color.BLUE);
		lblIdEjemplar.setBounds(31, 63, 85, 14);
		panel.add(lblIdEjemplar);

		textIdEjemplar = new JTextField();
		textIdEjemplar.setBounds(132, 60, 86, 20);
		panel.add(textIdEjemplar);
		textIdEjemplar.setColumns(10);

		JButton btnBuscarLibros = new JButton("Buscar Ejemplares");
		btnBuscarLibros.setBackground(Color.LIGHT_GRAY);
		btnBuscarLibros.setForeground(Color.BLUE);
		btnBuscarLibros.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				IMostrarEjemplaresParaReserva mepr = new IMostrarEjemplaresParaReserva(txISBNaBuscar.getText());
				mepr.setVisible(true);

			}
		});
		btnBuscarLibros.setBounds(376, 25, 156, 23);
		panel.add(btnBuscarLibros);

		JLabel lblFechaInicio = new JLabel("Fecha Inicio");
		lblFechaInicio.setForeground(Color.BLUE);
		lblFechaInicio.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFechaInicio.setBounds(31, 114, 67, 14);
		panel.add(lblFechaInicio);

		JCalendarCombo calendarComboFechaInicio = new JCalendarCombo();
		calendarComboFechaInicio.setModel(new DefaultComboBoxModel(new String[] {"Seleccione una fecha"}));
		calendarComboFechaInicio.setForeground(Color.BLUE);
		calendarComboFechaInicio.setBounds(132, 111, 185, 20);
		panel.add(calendarComboFechaInicio);

		JLabel lblFechaFin = new JLabel("Fecha Fin");
		lblFechaFin.setForeground(Color.BLUE);
		lblFechaFin.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFechaFin.setBounds(31, 175, 67, 14);
		panel.add(lblFechaFin);

		JCalendarCombo calendarComboFechaFin = new JCalendarCombo();
		calendarComboFechaFin.setModel(new DefaultComboBoxModel(new String[] {"Seleccione una fecha"}));
		calendarComboFechaFin.setForeground(Color.BLUE);
		calendarComboFechaFin.setBounds(132, 175, 185, 20);
		panel.add(calendarComboFechaFin);

		JLabel lblDni = new JLabel("DNI");
		lblDni.setForeground(Color.BLUE);
		lblDni.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDni.setBounds(31, 234, 67, 14);
		panel.add(lblDni);

		txCDNI = new JTextField();
		txCDNI.setBounds(132, 231, 86, 20);
		panel.add(txCDNI);
		txCDNI.setColumns(10);

		JButton btnRegistrarReserva = new JButton("Registrar Reserva");
		btnRegistrarReserva.setBackground(Color.LIGHT_GRAY);
		btnRegistrarReserva.setForeground(Color.BLUE);
		btnRegistrarReserva.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Calendar calendar = Calendar.getInstance();
				Calendar calendar2 = calendarComboFechaInicio.getCalendar().getInstance();
				calendar2.set(Calendar.YEAR, calendarComboFechaInicio.getCalendar().get(calendar.YEAR));
				calendar2.set(Calendar.DAY_OF_MONTH, calendarComboFechaInicio.getCalendar().get(Calendar.DAY_OF_MONTH));
				calendar2.set(Calendar.MONTH, calendarComboFechaInicio.getCalendar().get(Calendar.MONTH) + 1); // Assuming you wanted May 1st
				java.sql.Date fechaInicio = new java.sql.Date(calendar2.getTime().getTime());
				Calendar calendar1 = calendarComboFechaFin.getCalendar().getInstance();
				calendar1.set(Calendar.YEAR, calendarComboFechaFin.getCalendar().get(calendar.YEAR));
				calendar1.set(Calendar.DAY_OF_MONTH, calendarComboFechaFin.getCalendar().get(Calendar.DAY_OF_MONTH));
				calendar1.set(Calendar.MONTH, calendarComboFechaFin.getCalendar().get(Calendar.MONTH) + 1); // Assuming you wanted May 1st
				java.sql.Date fechaFin = new java.sql.Date(calendar2.getTime().getTime());
				ctrolDataBase.ReservaDB.insertarReserva(fechaInicio, fechaFin,Integer.parseInt(txCDNI.getText()) ,Integer.parseInt(textIdEjemplar.getText()));
				JOptionPane.showMessageDialog(null,"Nueva reserva almacenada");

			}
		});
		btnRegistrarReserva.setBounds(263, 276, 156, 23);
		panel.add(btnRegistrarReserva);

		JLabel lblIsbn = new JLabel("ISBN");
		lblIsbn.setForeground(Color.BLUE);
		lblIsbn.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIsbn.setBounds(31, 29, 67, 14);
		panel.add(lblIsbn);

		txISBNaBuscar = new JTextField();
		txISBNaBuscar.setBounds(132, 26, 86, 20);
		panel.add(txISBNaBuscar);
		txISBNaBuscar.setColumns(10);

		JButton btnBuscarLibro = new JButton("Buscar Libro");
		btnBuscarLibro.setBackground(Color.LIGHT_GRAY);
		btnBuscarLibro.setForeground(Color.BLUE);
		btnBuscarLibro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				IBuscarLibro ibl = new IBuscarLibro();
				ibl.setVisible(true);

			}
		});
		btnBuscarLibro.setBounds(234, 25, 132, 23);
		panel.add(btnBuscarLibro);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		btnVolver.setForeground(Color.RED);
		btnVolver.setBackground(Color.LIGHT_GRAY);
		btnVolver.setBounds(437, 276, 93, 23);
		panel.add(btnVolver);



	}
}
