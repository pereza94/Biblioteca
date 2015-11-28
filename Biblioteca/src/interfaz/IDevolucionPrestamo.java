package interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.PageAttributes;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entity.Prestamo;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
		setBounds(100, 100, 441, 216);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.GRAY, Color.LIGHT_GRAY, null, null));
			panel.setBounds(10, 11, 395, 104);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JLabel lblIdEjemplar = new JLabel("ID Ejemplar");
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
				lblDasDeDemora.setBounds(12, 63, 86, 14);
				panel.add(lblDasDeDemora);
			}
			{
				JLabel lblCdiasDemora = new JLabel("");
				lblCdiasDemora.setBounds(156, 63, 46, 14);
				panel.add(lblCdiasDemora);
			}


			JLabel lblfechaCLimite = new JLabel("");
			lblfechaCLimite.setBounds(104, 63, 157, 14);
			panel.add(lblfechaCLimite);



			{
				JButton btnRegistrar = new JButton("Registrar");
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
								JOptionPane.showMessageDialog(null,"La fecha limite ha sido superada");
								String fecha = ctrolDataBase.EjemplarDB.convertirFechaString((java.sql.Date) p.getFechaLimite());
								lblfechaCLimite.setText(fecha);

							}
						}
						else{JOptionPane.showMessageDialog(null,"No se encontro el prestamo Solicitado");}
					}
				});
				btnRegistrar.setBounds(212, 23, 89, 23);
				panel.add(btnRegistrar);
			}


		}
		{
			JButton btnNewButton = new JButton("Volver");
			btnNewButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					dispose();
				}
			});
			btnNewButton.setBounds(316, 143, 89, 23);
			contentPanel.add(btnNewButton);
		}
	}

}
