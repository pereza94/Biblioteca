 	package interfaz;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import org.freixas.jcalendar.JCalendarCombo;

import entity.Ejemplar;
import entity.Socio;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.Cursor;

public class INuevoPrestamo extends JDialog {
	private JTextField txBuscado;
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
		setBounds(100, 100, 882, 600);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 630, 300);
		getContentPane().add(panel);
		Border bordejpanel = new TitledBorder(new EtchedBorder(),"Buscar Ejemplares Disponibles");
        panel.setBorder(bordejpanel);
        panel.setLayout(null);
        
        JLabel lblLibro = new JLabel("ISBN");
        lblLibro.setBounds(10, 27, 59, 14);
        panel.add(lblLibro);
        
        txBuscado = new JTextField();
        txBuscado.setBounds(79, 24, 86, 20);
        panel.add(txBuscado);
        txBuscado.setColumns(10);
        
       
       
        
        JButton btnBuscarIsbn = new JButton("Buscar Libro");
        btnBuscarIsbn.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent arg0) {
        		IBuscarLibro bl = new IBuscarLibro();
        		bl.setVisible(true);
        	}
        });
        btnBuscarIsbn.setBounds(315, 23, 111, 23);
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
		
		
		scrollPane.setViewportView(table);
		
		
		 JButton btnBuscarEjempalr = new JButton("Buscar Ejemplar");
	        btnBuscarEjempalr.addMouseListener(new MouseAdapter() {
	        	@Override
	        	public void mouseClicked(MouseEvent arg0) {
	        		ArrayList<Ejemplar> le = ctrolDataBase.PrestamoDB.EjemplaresDisponibles(txBuscado.getText());
	        		if(le.isEmpty()){JOptionPane.showMessageDialog(null, "No se enuentran ejemplares disponibles");}
	        		for (int x=0; x<le.size();x++){
	        		Ejemplar e = le.get(x);
	        		modelo.addRow(new Object[]{e.getNumInventario(),e.getFechaAlta(),e.getCodUbicaion(),e.getIsbn()});
	        		
	        		}
	        	
	        	}
	        });
	    btnBuscarEjempalr.setBounds(175, 23, 130, 23);
	    panel.add(btnBuscarEjempalr);
	    
	    JButton btnLimpiarTabla = new JButton("Limpiar Tabla");
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
	    btnLimpiarTabla.setBackground(Color.WHITE);
	    btnLimpiarTabla.setBounds(478, 44, 142, 23);
	    panel.add(btnLimpiarTabla);
	    
	    JPanel panel_1 = new JPanel();
	    panel_1.setBounds(10, 314, 306, 214);
	    getContentPane().add(panel_1);
	    Border bordejpanel_1 = new TitledBorder(new EtchedBorder(),"Datos prestamo");
        panel_1.setBorder(bordejpanel_1);
        panel_1.setLayout(null);
        
        JCalendarCombo calendarCombo = new JCalendarCombo();
        calendarCombo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        calendarCombo.setBackground(new Color(0, 153, 255));
        calendarCombo.setForeground(Color.LIGHT_GRAY);
        calendarCombo.setDayOfWeekFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
        calendarCombo.setDayFont(new Font("Britannic Bold", Font.BOLD, 12));
        calendarCombo.setEditable(true);
        calendarCombo.setModel(new DefaultComboBoxModel(new String[] {"Viernes 27 de noviembre "}));
        calendarCombo.setNullAllowed(false);
        calendarCombo.setBounds(95, 137, 185, 20);
        panel_1.add(calendarCombo);
        
        JLabel lblDni = new JLabel("DNI");
        lblDni.setBounds(10, 32, 46, 14);
        panel_1.add(lblDni);
        
        txDni = new JTextField();
        txDni.setBounds(131, 26, 86, 20);
        panel_1.add(txDni);
        txDni.setColumns(10);
        
        txIDEJemplar = new JTextField();
        txIDEJemplar.setBounds(131, 79, 86, 20);
        panel_1.add(txIDEJemplar);
        txIDEJemplar.setColumns(10);
        
        JLabel lblIdEjemplar = new JLabel("ID Ejemplar");
        lblIdEjemplar.setBounds(10, 85, 75, 14);
        panel_1.add(lblIdEjemplar);
        
        JLabel lblFechaLimite = new JLabel("Fecha Limite");
        lblFechaLimite.setBounds(10, 140, 75, 14);
        panel_1.add(lblFechaLimite);
       
        JPanel panel_2 = new JPanel();
        panel_2.setBounds(336, 314, 332, 214);
        getContentPane().add(panel_2);
        panel_2.setLayout(null);
        Border bordejpanel_2 = new TitledBorder(new EtchedBorder(),"Datos Socio");
        panel_2.setBorder(bordejpanel_2);
        panel_2.setLayout(null);
        
        JLabel lblIdentidad = new JLabel("Identidad");
        lblIdentidad.setBounds(10, 24, 100, 14);
        panel_2.add(lblIdentidad);
        
        JLabel lblDireccin = new JLabel("Direcci\u00F3n");
        lblDireccin.setBounds(10, 65, 100, 14);
        panel_2.add(lblDireccin);
        
        JLabel lblTelefono = new JLabel("Telefono");
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
        
        JButton btnValidar = new JButton("Validar");
        btnValidar.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent arg0) {
        		
        		ArrayList<Socio> ls =ctrolDataBase.SociosDB.buscarXDNI(Integer.parseInt(txDni.getText()));
        		if(ls.isEmpty()){JOptionPane.showMessageDialog(null, "El DNI, no se corresponde con ningun socio");}
        		else{
        		Socio s= ls.get(0);
        		lblCIdentidad.setText(s.getIdentidad());
        		lblCTelefono.setText(s.getTelefono());
        		lblCDireccion.setText(s.getDomicilio());
        		}
        	}
        });
        btnValidar.setBounds(207, 180, 89, 23);
        panel_1.add(btnValidar);
        
        JButton btnResgitrarprestamo = new JButton("ResgitrarPrestamo");
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
				Calendar calendar2 = calendarCombo.getCalendar().getInstance();
        		calendar2.set(Calendar.YEAR, calendarCombo.getCalendar().get(calendar.YEAR));
        		calendar2.set(Calendar.DAY_OF_MONTH, calendarCombo.getCalendar().get(Calendar.DAY_OF_MONTH));
        		calendar2.set(Calendar.MONTH, calendarCombo.getCalendar().get(Calendar.MONTH) + 1); // Assuming you wanted May 1st
        		java.sql.Date fechalimite = new java.sql.Date(calendar2.getTime().getTime());
				
        		ctrolDataBase.PrestamoDB.nuevoPrestamo((java.sql.Date) fechaHoy,Integer.parseInt(txIDEJemplar.getText()) , fechalimite, null, Integer.parseInt(txDni.getText()));
        		JOptionPane.showMessageDialog(null, "Prestamo almacenado");
        	}
        });
        btnResgitrarprestamo.setBounds(436, 538, 142, 23);
        getContentPane().add(btnResgitrarprestamo);
        
        JButton btnVolver = new JButton("Volver");
        btnVolver.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent arg0) {
        		dispose();
        	}
        });
        btnVolver.setBounds(642, 538, 89, 23);
        getContentPane().add(btnVolver);
        
        JButton btnRegistrarDevolucin = new JButton("Registrar Devoluci\u00F3n");
        btnRegistrarDevolucin.setBounds(280, 538, 146, 23);
        getContentPane().add(btnRegistrarDevolucin);
        
      
        
	}
}
