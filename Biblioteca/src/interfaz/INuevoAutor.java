package interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import org.eclipse.wb.swing.FocusTraversalOnArray;

import entity.Autor;

import java.awt.Component;

public class INuevoAutor extends JDialog {

	/**
	 * 
	 */

	private final JPanel contentPanel = new JPanel();
	private JTextField txIdentidad;
	private JButton button;
	private JButton button_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			INuevoAutor dialog = new INuevoAutor();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public INuevoAutor() {
		setTitle("Nuevo Autor");
		setBounds(100, 100, 376, 227);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBounds(10, 11, 340, 158);
			contentPanel.add(panel);
			Border bordejpanel = new TitledBorder(new EtchedBorder(),"Nuevo autor");
			panel.setBorder(bordejpanel);
			panel.setLayout(null);

			JLabel lblNombre = new JLabel("Nombre");
			lblNombre.setBounds(35, 35, 46, 14);
			panel.add(lblNombre);

			JLabel lblIdAutor = new JLabel("ID Autor:");
			lblIdAutor.setHorizontalAlignment(SwingConstants.RIGHT);
			lblIdAutor.setBounds(10, 60, 71, 14);
			panel.add(lblIdAutor);

			txIdentidad = new JTextField();
			txIdentidad.setBounds(91, 32, 128, 20);
			panel.add(txIdentidad);
			txIdentidad.setColumns(10);

			JLabel lblIDAutor = new JLabel("");
			lblIDAutor.setHorizontalAlignment(SwingConstants.RIGHT);
			lblIDAutor.setForeground(Color.BLUE);
			lblIDAutor.setFont(new Font("Arial Narrow", Font.BOLD, 13));
			lblIDAutor.setBounds(91, 60, 46, 14);
			panel.add(lblIDAutor);

			button = new JButton("Aceptar");
			button.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					ctrolDataBase.AutorDB.insertarAutor(txIdentidad.getText().toUpperCase());
					Autor a = ctrolDataBase.AutorDB.buscarAutor(txIdentidad.getText().toUpperCase());
					lblIDAutor.setText(String.valueOf(a.getIdAutor()));
				}
			});
			button.setIcon(new ImageIcon(INuevoAutor.class.getResource("/Images/Login/checkok.jpg")));
			button.setVerticalTextPosition(SwingConstants.BOTTOM);
			button.setInheritsPopupMenu(true);
			button.setIgnoreRepaint(true);
			button.setHorizontalTextPosition(SwingConstants.RIGHT);
			button.setForeground(new Color(0, 100, 0));
			button.setFont(new Font("Segoe Print", Font.BOLD, 11));
			button.setBackground(Color.LIGHT_GRAY);
			button.setBounds(95, 111, 105, 23);
			panel.add(button);

			button_1 = new JButton("Cerrar");
			button_1.setIcon(new ImageIcon(INuevoAutor.class.getResource("/Images/Login/210px-Cruz_roja (1).png")));
			button_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
			});
			button_1.setVerticalTextPosition(SwingConstants.BOTTOM);
			button_1.setInheritsPopupMenu(true);
			button_1.setIgnoreRepaint(true);
			button_1.setHorizontalTextPosition(SwingConstants.LEFT);
			button_1.setForeground(new Color(165, 42, 42));
			button_1.setFont(new Font("Segoe Print", Font.BOLD, 11));
			button_1.setBackground(Color.LIGHT_GRAY);
			button_1.setBounds(210, 110, 105, 23);
			panel.add(button_1);
		}
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{txIdentidad, button, button_1}));


	}
}
