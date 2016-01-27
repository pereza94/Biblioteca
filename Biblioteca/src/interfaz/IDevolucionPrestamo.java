package interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.PageAttributes;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ctrolDataBase.EjemplarDB;
import ctrolDataBase.PrestamoDB;
import ctrolDataBase.SociosDB;
import entity.Prestamo;
import entity.Socio;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.border.BevelBorder;
import java.awt.Color;

public class IDevolucionPrestamo extends JDialog {

	protected static final int MILLSECS_PER_DAY = 0;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			IDevolucionPrestamo dialog = new IDevolucionPrestamo();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public IDevolucionPrestamo() {
		setBounds(100, 100, 441, 267);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.GRAY, Color.LIGHT_GRAY, null, null));
			panel.setBounds(10, 11, 395, 149);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JLabel lblIdEjemplar = new JLabel("ID Ejemplar");
				lblIdEjemplar.setForeground(Color.BLUE);
				lblIdEjemplar.setBounds(12, 27, 72, 14);
				panel.add(lblIdEjemplar);
			}
			{
				textField = new JTextField();
				textField.setBounds(94, 24, 86, 20);
				panel.add(textField);
				textField.setColumns(10);
			}
			{
				JLabel lblDasDeDemora = new JLabel("Fecha Limite");
				lblDasDeDemora.setForeground(Color.BLUE);
				lblDasDeDemora.setBounds(12, 63, 86, 14);
				panel.add(lblDasDeDemora);
			}
			{
				JLabel lblCdiasDemora = new JLabel("");
				lblCdiasDemora.setForeground(new Color(0, 128, 0));
				lblCdiasDemora.setBounds(156, 63, 46, 14);
				panel.add(lblCdiasDemora);
			}


			JLabel lblfechaCLimite = new JLabel("");
			lblfechaCLimite.setBounds(104, 63, 157, 14);
			panel.add(lblfechaCLimite);



			{
				JButton btnRegistrar = new JButton("Registrar");
				btnRegistrar.setForeground(new Color(0, 128, 0));
				btnRegistrar.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						Calendar calendar = Calendar.getInstance();
						java.sql.Date date = new java.sql.Date(calendar.getTime().getTime());
						Date fechaHoy = date;
						ctrolDataBase.PrestamoDB.RegistarDevolución((java.sql.Date) fechaHoy, Integer.parseInt(textField.getText()));
						Prestamo p = ctrolDataBase.PrestamoDB.VerificarFechas((java.sql.Date) fechaHoy, Integer.parseInt(textField.getText()));
						if(p.getFechaLimite()!=null){
							if((p.getFechaLimite().after(fechaHoy)) || (p.getFechaLimite().equals(fechaHoy))){
								JOptionPane.showMessageDialog(null, "Devolución Registrada");
								String fecha = ctrolDataBase.EjemplarDB.convertirFechaString((java.sql.Date) p.getFechaLimite());
								lblfechaCLimite.setText(fecha);

							}
							else{
								String fecha1 = ctrolDataBase.EjemplarDB.convertirFechaString((java.sql.Date) p.getFechaLimite());
								IDevolucionAtrasada nda = new IDevolucionAtrasada();
								IDevolucionAtrasada.dias =  fecha1;
								nda.setVisible(true);
								

							}
						}
						else{JOptionPane.showMessageDialog(null,"No se encontro el prestamo Solicitado");}
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
							if(pe.getFechaLimite().after(fechaHoy1))
							{
								String titulo = EjemplarDB.ObtenerTitulo(pe.getNumEjemplarDB());
								ArrayList<Socio> soc = SociosDB.buscarXDNI(pe.getDniSocio());
								Socio s= soc.get(0);
								UIPrincipañ.modelo.addRow(new Object[]{pe.getFechaPrestamo(),pe.getNumEjemplarDB(),titulo,pe.getFechaLimite(),pe.getDniSocio(),s.getIdentidad()});
							
							}
							if(pe.getFechaLimite().before(fechaHoy1))
							{
								String titulo = EjemplarDB.ObtenerTitulo(pe.getNumEjemplarDB());
								ArrayList<Socio> soc = SociosDB.buscarXDNI(pe.getDniSocio());
								Socio s= soc.get(0);
								UIPrincipañ.modelo.addRow(new Object[]{pe.getFechaPrestamo(),pe.getNumEjemplarDB(),titulo,pe.getFechaLimite(),pe.getDniSocio(),s.getIdentidad()});						
							}
							}
						dispose();
					}
				});
				btnRegistrar.setBounds(296, 23, 89, 23);
				panel.add(btnRegistrar);
			}
			JLabel lbNombreSocio1 = new JLabel("");
			lbNombreSocio1.setForeground(new Color(0, 128, 0));
			lbNombreSocio1.setBounds(108, 105, 169, 14);
			panel.add(lbNombreSocio1);
			{
				JButton btnValidar = new JButton("Validar");
				btnValidar.setForeground(new Color(0, 0, 139));
				btnValidar.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						Calendar calendar = Calendar.getInstance();
						java.sql.Date date = new java.sql.Date(calendar.getTime().getTime());
						Date fechaHoy = date;
						Prestamo p = ctrolDataBase.PrestamoDB.ValidarVerificarFechas(null, Integer.parseInt(textField.getText()));
						if(p.getFechaLimite()!=null){
							if((p.getFechaLimite().after(fechaHoy)) || (p.getFechaLimite().equals(fechaHoy))){
								String fecha = ctrolDataBase.EjemplarDB.convertirFechaString((java.sql.Date) p.getFechaLimite());
								lblfechaCLimite.setText(fecha);
								int dni = p.getDniSocio();
								ArrayList<Socio> ls = SociosDB.buscarXDNI(dni);
								Socio s=ls.get(0);
								lbNombreSocio1.setText(s.getIdentidad());

							}
							else{
								String fecha = ctrolDataBase.EjemplarDB.convertirFechaString((java.sql.Date) p.getFechaLimite());
								lblfechaCLimite.setText(fecha);
								int dni = p.getDniSocio();
								ArrayList<Socio> ls = SociosDB.buscarXDNI(dni);
								Socio s=ls.get(0);
								lbNombreSocio1.setText(s.getIdentidad());

							}
						}
						else{JOptionPane.showMessageDialog(null,"No se encontro el prestamo Solicitado");}
						ArrayList<Prestamo> listaPrestamo= PrestamoDB.PrestamosVigentes();
						int cant=listaPrestamo.size();
						for (int i = 0; i < UIPrincipañ.table.getRowCount(); i++) {
							UIPrincipañ.modelo.removeRow(i);
							i-=1;
						}
						
						
					}
				});
				btnValidar.setBounds(197, 23, 89, 23);
				panel.add(btnValidar);
			}
			
			JLabel lblNombreSocio = new JLabel("Nombre Socio");
			lblNombreSocio.setForeground(Color.BLUE);
			lblNombreSocio.setBounds(12, 105, 86, 14);
			panel.add(lblNombreSocio);
			
			


		}
		{
			JButton btnNewButton = new JButton("Volver");
			btnNewButton.setForeground(new Color(128, 0, 0));
			btnNewButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					dispose();
				}
			});
			btnNewButton.setBounds(316, 171, 89, 23);
			contentPanel.add(btnNewButton);
		}
	}
}
