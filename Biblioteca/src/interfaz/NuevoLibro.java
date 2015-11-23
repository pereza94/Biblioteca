
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

import java.awt.Color;
import java.awt.Container;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class NuevoLibro extends JDialog {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			NuevoLibro dialog = new NuevoLibro();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public NuevoLibro() {
		setTitle("Nuevo Libro");
		setBounds(100, 100, 430, 335);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 393, 271);
		getContentPane().add(panel);
		Border bordejpanel = new TitledBorder(new EtchedBorder(),"Nuevo Libro");
        panel.setBorder(bordejpanel);
        panel.setLayout(null);
        
        JLabel lblIsbn = new JLabel("ISBN");
        lblIsbn.setHorizontalAlignment(SwingConstants.RIGHT);
        lblIsbn.setBounds(84, 24, 52, 14);
        panel.add(lblIsbn);
        
        textField = new JTextField();
        textField.setBounds(143, 21, 86, 20);
        panel.add(textField);
        textField.setColumns(10);
        
        JLabel lblTitulo = new JLabel("Titulo");
        lblTitulo.setHorizontalAlignment(SwingConstants.RIGHT);
        lblTitulo.setBounds(10, 59, 59, 14);
        panel.add(lblTitulo);
        
        textField_1 = new JTextField();
        textField_1.setBounds(84, 56, 86, 20);
        panel.add(textField_1);
        textField_1.setColumns(10);
        
        JLabel lblAo = new JLabel("A\u00F1o");
        lblAo.setHorizontalAlignment(SwingConstants.RIGHT);
        lblAo.setBounds(208, 59, 46, 14);
        panel.add(lblAo);
        
        textField_2 = new JTextField();
        textField_2.setBounds(264, 56, 86, 20);
        panel.add(textField_2);
        textField_2.setColumns(10);
        
        JLabel lblIdAutor = new JLabel("ID Autor");
        lblIdAutor.setHorizontalAlignment(SwingConstants.RIGHT);
        lblIdAutor.setBounds(10, 127, 59, 14);
        panel.add(lblIdAutor);
        
        textField_3 = new JTextField();
        textField_3.setBounds(84, 124, 86, 20);
        panel.add(textField_3);
        textField_3.setColumns(10);
        
        JButton btnNewButton = new JButton("Buscar Autores");
        btnNewButton.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		IBuscarAutores c = new IBuscarAutores();
        		c.setVisible(true);
        	}
        });
        btnNewButton.setIcon(new ImageIcon(NuevoLibro.class.getResource("/Images/Login/lupa (1).png")));
        btnNewButton.setBounds(199, 123, 151, 23);
        panel.add(btnNewButton);
        
        JButton button = new JButton("Aceptar");
        button.setIcon(new ImageIcon(NuevoLibro.class.getResource("/Images/Login/checkok.jpg")));
        button.setVerticalTextPosition(SwingConstants.BOTTOM);
        button.setInheritsPopupMenu(true);
        button.setIgnoreRepaint(true);
        button.setHorizontalTextPosition(SwingConstants.RIGHT);
        button.setForeground(new Color(0, 100, 0));
        button.setFont(new Font("Segoe Print", Font.BOLD, 11));
        button.setBackground(Color.LIGHT_GRAY);
        button.setBounds(169, 212, 105, 23);
        panel.add(button);
        
        JButton button_1 = new JButton("Cerrar");
        button_1.setIcon(new ImageIcon(NuevoLibro.class.getResource("/Images/Login/210px-Cruz_roja (1).png")));
        button_1.setVerticalTextPosition(SwingConstants.BOTTOM);
        button_1.setInheritsPopupMenu(true);
        button_1.setIgnoreRepaint(true);
        button_1.setHorizontalTextPosition(SwingConstants.LEFT);
        button_1.setForeground(new Color(165, 42, 42));
        button_1.setFont(new Font("Segoe Print", Font.BOLD, 11));
        button_1.setBackground(Color.LIGHT_GRAY);
        button_1.setBounds(284, 212, 105, 23);
        panel.add(button_1);
	
	}
}
