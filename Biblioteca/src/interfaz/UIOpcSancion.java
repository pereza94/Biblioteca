package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

public class UIOpcSancion extends JFrame {

	private JPanel contentPane;
	public static IRegistrarSancion ns;
	public static IMostrarSanciones ls;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIOpcSancion frame = new UIOpcSancion();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UIOpcSancion() {
		setTitle("BIBLIOTECA FCYT -OPC SANCI\u00D3N");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 247, 188);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNuevaSancin = new JButton("Nueva Sanci\u00F3n");
		btnNuevaSancin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNuevaSancin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (ns != null) {//si existe una venta, la cierra.
					ns.dispose();
				}
				ns= new IRegistrarSancion();
				ns.setLocationRelativeTo(null);
				ns.setVisible(true);
				
			}
		});
		btnNuevaSancin.setBackground(Color.LIGHT_GRAY);
		btnNuevaSancin.setForeground(Color.BLUE);
		btnNuevaSancin.setBounds(10, 31, 211, 23);
		contentPane.add(btnNuevaSancin);
		
		JButton btnListarSancin = new JButton("Listar Sanciones");
		btnListarSancin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnListarSancin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (ls != null) {//si existe una venta, la cierra.
					ls.dispose();
				}
				ls= new IMostrarSanciones();
				ls.setLocationRelativeTo(null);
				ls.setVisible(true);
			}
		});
		btnListarSancin.setBackground(Color.LIGHT_GRAY);
		btnListarSancin.setForeground(Color.BLUE);
		btnListarSancin.setBounds(10, 99, 211, 23);
		contentPane.add(btnListarSancin);
		
		JButton btnEliminarSancin = new JButton("Eliminar Sanci\u00F3n");
		btnEliminarSancin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				IEliminarSancion es= new IEliminarSancion();
				es.setLocationRelativeTo(null);
				es.setVisible(true);
			}
		});
		btnEliminarSancin.setBackground(Color.LIGHT_GRAY);
		btnEliminarSancin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnEliminarSancin.setForeground(Color.BLUE);
		btnEliminarSancin.setBounds(10, 65, 211, 23);
		contentPane.add(btnEliminarSancin);
	}

}
