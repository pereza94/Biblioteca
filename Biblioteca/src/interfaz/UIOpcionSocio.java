package interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UIOpcionSocio extends JDialog {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIOpcionSocio dialog = new UIOpcionSocio();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public UIOpcionSocio() {
		getContentPane().setBackground(Color.DARK_GRAY);
		setBackground(Color.DARK_GRAY);
		setTitle("Biblioteca FCYT - GESTI\u00D3N SOCIO");
		setBounds(100, 100, 377, 217);
		getContentPane().setLayout(null);
		{
			JButton btnModificarSocio = new JButton("Modificar Socio");
			btnModificarSocio.setBackground(Color.LIGHT_GRAY);
			btnModificarSocio.setForeground(Color.BLUE);
			btnModificarSocio.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
					ISocioMoficar sm = new ISocioMoficar();
					sm.setLocationRelativeTo(null);
					sm.setVisible(true);
				}
			});
			btnModificarSocio.setBounds(10, 54, 333, 32);
			getContentPane().add(btnModificarSocio);
		}
		{
			JButton btnNuevoSocio = new JButton("Nuevo Socio");
			btnNuevoSocio.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					dispose();
					INuevoSocio ns = new INuevoSocio();
					ns.setLocationRelativeTo(null);
					ns.setVisible(true);
				}
			});
			btnNuevoSocio.setBackground(Color.LIGHT_GRAY);
			btnNuevoSocio.setForeground(Color.BLUE);
			btnNuevoSocio.setBounds(10, 11, 333, 32);
			getContentPane().add(btnNuevoSocio);
		}
		
		JButton button = new JButton("Listar/Buscar Socios");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				IListadoSocios ls = new IListadoSocios();
				ls.setLocationRelativeTo(null);
				ls.setVisible(true);
			}
		});
		button.setForeground(Color.BLUE);
		button.setBackground(Color.LIGHT_GRAY);
		button.setBounds(10, 140, 333, 32);
		getContentPane().add(button);
		{
			JButton btnLibrosxSocio = new JButton("Prestamos por Socio");
			btnLibrosxSocio.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					dispose();
					ILibrosPorSocio lps = new ILibrosPorSocio();
					lps.setLocationRelativeTo(null);
					lps.setVisible(true);
				}
			});
			btnLibrosxSocio.setForeground(Color.BLUE);
			btnLibrosxSocio.setBackground(Color.LIGHT_GRAY);
			btnLibrosxSocio.setBounds(10, 97, 333, 32);
			getContentPane().add(btnLibrosxSocio);
		}
	}

}
