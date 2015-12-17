package interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UIOpcionLibro extends JDialog{
	public static ILibroModificar ml ;
	public static INuevoLibro nl;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			
			UIOpcionLibro dialog = new UIOpcionLibro();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public UIOpcionLibro() {
		setBackground(Color.BLACK);
		setTitle("FCYT BIBLIOTECA - GESTI\u00D3N LIBROS");
		setBounds(100, 100, 301, 150);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.DARK_GRAY);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JButton btnNuevoLibro = new JButton("Nuevo  Libro");
		btnNuevoLibro.setBackground(Color.LIGHT_GRAY);
		btnNuevoLibro.setForeground(Color.BLUE);
		btnNuevoLibro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				nl = new INuevoLibro();
				nl.setVisible(true);
			}
		});
		btnNuevoLibro.setBounds(10, 11, 272, 23);
		contentPanel.add(btnNuevoLibro);
		
		JButton btnModificarLibro = new JButton("Modificar Libro");
		btnModificarLibro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
				 ml = new ILibroModificar();
				ml.setVisible(true);
				
			}
		});
		btnModificarLibro.setBackground(Color.LIGHT_GRAY);
		btnModificarLibro.setForeground(Color.BLUE);
		btnModificarLibro.setBounds(10, 45, 272, 23);
		contentPanel.add(btnModificarLibro);
		
		JButton btnListarEjemplaresDe = new JButton("Listar Ejemplares de un libro");
		btnListarEjemplaresDe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				IlibroEjemplarBuscado ibe = new IlibroEjemplarBuscado();
				ibe.setLocationRelativeTo(null);
				ibe.setVisible(true);
			}
		});
		btnListarEjemplaresDe.setBackground(Color.LIGHT_GRAY);
		btnListarEjemplaresDe.setForeground(Color.BLUE);
		btnListarEjemplaresDe.setBounds(10, 79, 272, 23);
		contentPanel.add(btnListarEjemplaresDe);
	}
}
