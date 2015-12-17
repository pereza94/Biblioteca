package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.UIManager;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JPasswordField;

public class ILogin extends JFrame {

	private JPanel contentPane;
	private JTextField txUSer;
	private JPasswordField txPassword;
	private JPasswordField passwordField;
	public static UIPrincipañ ip;

	/**
	 * Launch the application.0
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ILogin frame = new ILogin();
					frame.setLocationRelativeTo(null);
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
	public ILogin() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 411, 254);
		contentPane = new JPanel();
		contentPane.setBorder(UIManager.getBorder("Button.border"));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setToolTipText("\r\n");
		panel.setBounds(10, 11, 378, 198);
		contentPane.add(panel);
		Border bordejpanel = new TitledBorder(new EtchedBorder(),"Identificación de Bibliotecario");
		panel.setBorder(bordejpanel);
		panel.setLayout(null);

		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(53, 79, 44, 14);
		lblUsuario.setVerticalAlignment(SwingConstants.BOTTOM);
		panel.add(lblUsuario);

		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setBounds(10, 104, 87, 14);
		lblContrasea.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblContrasea);

		txUSer = new JTextField();
		txUSer.setBounds(107, 76, 129, 20);
		panel.add(txUSer);
		txUSer.setColumns(10);

		JLabel lblIngreseSuUsuario = new JLabel("Ingrese su usuario y contrase\u00F1a");
		lblIngreseSuUsuario.setBounds(81, 37, 224, 14);
		lblIngreseSuUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblIngreseSuUsuario.setForeground(Color.BLUE);
		panel.add(lblIngreseSuUsuario);

		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (ctrolDataBase.LoginDB.login(txUSer.getText(),passwordField.getText()) == true){
					dispose();
					ip = new UIPrincipañ();
					ip.setLocationRelativeTo(null);
					ip.setVisible(true);}
				else{
					Component frame = null;
					JOptionPane.showMessageDialog(frame,
							"Datos Incorrectos. Por favor intente nuevamente",
							"Error inicio de sesión",
							JOptionPane.ERROR_MESSAGE);
					passwordField.setText("");
				}
			}
		});
		btnAceptar.setBackground(new Color(192, 192, 192));
		btnAceptar.setFont(new Font("Segoe Print", Font.BOLD, 11));
		btnAceptar.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnAceptar.setForeground(new Color(0, 100, 0));
		btnAceptar.setInheritsPopupMenu(true);
		btnAceptar.setIgnoreRepaint(true);
		btnAceptar.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnAceptar.setIcon(new ImageIcon(ILogin.class.getResource("/Images/Login/checkok.jpg")));
		btnAceptar.setBounds(129, 164, 105, 23);
		panel.add(btnAceptar);

		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.setIcon(new ImageIcon(ILogin.class.getResource("/Images/Login/210px-Cruz_roja (1).png")));
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCerrar.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnCerrar.setInheritsPopupMenu(true);
		btnCerrar.setIgnoreRepaint(true);
		btnCerrar.setHorizontalTextPosition(SwingConstants.LEFT);
		btnCerrar.setForeground(new Color(165, 42, 42));
		btnCerrar.setFont(new Font("Segoe Print", Font.BOLD, 11));
		btnCerrar.setBackground(Color.LIGHT_GRAY);
		btnCerrar.setBounds(263, 164, 105, 23);
		panel.add(btnCerrar);

		JLabel label = DefaultComponentFactory.getInstance().createLabel("");
		label.setIcon(new ImageIcon(ILogin.class.getResource("/Images/Login/logoFacu.png")));
		label.setBounds(248, 79, 120, 45);
		panel.add(label);
		//txtPsw.setEchoChar('*');
		
		passwordField = new JPasswordField();
		passwordField.setBounds(107, 104, 129, 20);
		panel.add(passwordField);
		passwordField.setEchoChar('*');
		panel.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{txUSer, btnAceptar, btnCerrar}));
		
		




	}
}
