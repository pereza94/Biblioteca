package interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Font;

public class UIOpcionReserva extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public static INuevaReserva nr;
	public static IBajaReserva br;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIOpcionReserva dialog = new UIOpcionReserva();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public UIOpcionReserva() {
		setTitle("FCYT BIBLIOTECA - OPC RESERVA");
		setBounds(100, 100, 309, 154);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.DARK_GRAY);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JButton btnNuevaReserva = new JButton("Nueva Reserva");
		btnNuevaReserva.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNuevaReserva.setBackground(Color.LIGHT_GRAY);
		btnNuevaReserva.setForeground(Color.BLUE);
		btnNuevaReserva.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
				nr= new INuevaReserva();
				nr.setVisible(true);
			}
		});
		btnNuevaReserva.setBounds(29, 25, 234, 23);
		contentPanel.add(btnNuevaReserva);
		
		JButton btnEliminarReserva = new JButton("Listar / Eliminar Reserva");
		btnEliminarReserva.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEliminarReserva.setBackground(Color.LIGHT_GRAY);
		btnEliminarReserva.setForeground(Color.BLUE);
		btnEliminarReserva.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				br= new IBajaReserva();
				br.setVisible(true);
			}
		});
		btnEliminarReserva.setBounds(29, 59, 234, 23);
		contentPanel.add(btnEliminarReserva);
	}
}
