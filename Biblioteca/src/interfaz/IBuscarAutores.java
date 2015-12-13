package interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import entity.Autor;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.awt.Component;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class IBuscarAutores extends JDialog {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			IBuscarAutores dialog = new IBuscarAutores();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private JTable table;
	private JTextField txBuscar;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Create the dialog.
	 */
	public IBuscarAutores() {
		setTitle("Buscar Autor");
		setBounds(100, 100, 716, 472);
		getContentPane().setLayout(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setAlignmentX(Component.RIGHT_ALIGNMENT);
		scrollPane.setBounds(28, 119, 643, 252);
		getContentPane().add(scrollPane);


		JPanel panel = new JPanel();
		panel.setBounds(20, 11, 670, 411);
		getContentPane().add(panel);
		Border bordejpanel = new TitledBorder(new EtchedBorder(),"Buscar Autor");
		panel.setBorder(bordejpanel);
		panel.setLayout(null);

		JLabel lblBuscar = new JLabel("Buscar");
		lblBuscar.setBounds(3, 38, 48, 14);
		panel.add(lblBuscar);
		lblBuscar.setHorizontalAlignment(SwingConstants.RIGHT);



		JRadioButton rdbtnIdAutor = new JRadioButton("ID Autor");
		rdbtnIdAutor.setBounds(297, 72, 109, 23);
		panel.add(rdbtnIdAutor);
		buttonGroup.add(rdbtnIdAutor);

		JRadioButton rdbtnNombre = new JRadioButton("Nombre");
		rdbtnNombre.setBounds(136, 72, 109, 23);
		panel.add(rdbtnNombre);
		buttonGroup.add(rdbtnNombre);

		JButton button = new JButton("Cerrar");
		button.setBounds(555, 377, 105, 23);
		panel.add(button);
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
			}
		});

		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"ID Autor", "Identidad"
				}
				));
		DefaultTableModel modelo = (DefaultTableModel)table.getModel();


		scrollPane.setViewportView(table);


		button.setIcon(new ImageIcon(IBuscarAutores.class.getResource("/Images/Login/210px-Cruz_roja (1).png")));
		button.setVerticalTextPosition(SwingConstants.BOTTOM);
		button.setInheritsPopupMenu(true);
		button.setIgnoreRepaint(true);
		button.setHorizontalTextPosition(SwingConstants.LEFT);
		button.setForeground(new Color(165, 42, 42));
		button.setFont(new Font("Segoe Print", Font.BOLD, 11));
		button.setBackground(Color.LIGHT_GRAY);

		rdbtnNombre.setSelected(true);

		txBuscar = new JTextField();
		txBuscar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				for (int i = 0; i < table.getRowCount(); i++) {
					modelo.removeRow(i);
					i-=1;
				}
				if(rdbtnNombre.isSelected()){
					ArrayList<Autor> lista = ctrolDataBase.AutorDB.buscarXPatron(txBuscar.getText());
					int cant = lista.size();
					for(int x =0;x < cant;x++){
						Autor a =lista.get(x);
						int idAt = a.getIdAutor();
						String nombre = a.getIdentidad();
						modelo.addRow(new Object[]{idAt,nombre});
					}

				}
			}
		});
		txBuscar.setBounds(61, 35, 453, 20);
		panel.add(txBuscar);
		txBuscar.setColumns(10);


		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(519, 32, 126, 23);
		panel.add(btnBuscar);
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(rdbtnNombre.isSelected()){
					ArrayList<Autor> lista = ctrolDataBase.AutorDB.buscarXPatron(txBuscar.getText());
					int cant = lista.size();
					for(int x =0;x < cant;x++){
						Autor a =lista.get(x);
						int idAt = a.getIdAutor();
						String nombre = a.getIdentidad();
						modelo.addRow(new Object[]{idAt,nombre});
					}

				}
				if(rdbtnIdAutor.isSelected()){
					ArrayList<Autor> lista = ctrolDataBase.AutorDB.buscarXIdAutor(Integer.parseInt(txBuscar.getText()));
					int cant = lista.size();
					int x=0;
					Autor a =lista.get(x);
					int idAt = a.getIdAutor();
					String nombre = a.getIdentidad();
					modelo.addRow(new Object[]{idAt,nombre});
				}

			}

		});
		btnBuscar.setBackground(new Color(192, 192, 192));
		btnBuscar.setIcon(new ImageIcon(IBuscarAutores.class.getResource("/Images/Login/lupa (1).png")));
		btnBuscar.setForeground(new Color(100, 149, 237));

		JButton btnAgregarAutor = new JButton("Nuevo Autor");
		btnAgregarAutor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAgregarAutor.setBackground(SystemColor.activeCaptionBorder);
		btnAgregarAutor.setForeground(new Color(0, 102, 0));
		btnAgregarAutor.setIcon(new ImageIcon(IBuscarAutores.class.getResource("/Images/Login/red-sign-computer-green-icon-mark-symbol-cartoon.png")));
		btnAgregarAutor.setBounds(10, 377, 142, 24);
		panel.add(btnAgregarAutor);

		JButton button_1 = new JButton("Limpiar Tabla");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				{
					for (int i = 0; i < table.getRowCount(); i++) {
						modelo.removeRow(i);
						i-=1;
					}
				}

			}
		});
		button_1.setBounds(506, 85, 142, 23);
		panel.add(button_1);
		button_1.setIcon(new ImageIcon(IBuscarAutores.class.getResource("/Images/Login/8fc03fbe37e8ed0e1e784244c68f3fe8.png")));
		button_1.setBackground(Color.WHITE);

		JLabel lblBuscar_1 = new JLabel("Buscar por:");
		lblBuscar_1.setBounds(10, 76, 66, 14);
		panel.add(lblBuscar_1);

		JButton btnBuscarLibrosDe = new JButton("Buscar Libros de un Autor");
		btnBuscarLibrosDe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				IBuscarLibrosXAutor bla= new IBuscarLibrosXAutor();
				bla.setVisible(true);
			}
		});
		btnBuscarLibrosDe.setBackground(Color.LIGHT_GRAY);
		btnBuscarLibrosDe.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				IBuscarLibrosXAutor bla= new IBuscarLibrosXAutor();
				bla.setVisible(true);
			}
		});
		btnBuscarLibrosDe.setIcon(new ImageIcon(IBuscarAutores.class.getResource("/Images/Login/lupa (1).png")));
		btnBuscarLibrosDe.setForeground(new Color(0, 0, 255));
		btnBuscarLibrosDe.setBounds(238, 363, 222, 23);
		panel.add(btnBuscarLibrosDe);
		btnAgregarAutor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				INuevoAutor n = new INuevoAutor();
				n.setVisible(true);
			}
		});
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int fila=table.getSelectedRow();
				Integer valorCelda =  (Integer) table.getValueAt(fila,0);
				if (UIOpcionLibro.nl.isVisible()){
				if(INuevoLibro.txAutor1NuevoLibro.isVisible() && !INuevoLibro.txAutor2NuevoLibro.isVisible() && !INuevoLibro.txAutor3NuevoLibro.isVisible() && !INuevoLibro.txAutor4NuevoLibro.isVisible() && !INuevoLibro.txAutor5NuevoLibro.isVisible()){
				INuevoLibro.txAutor1NuevoLibro.setText(String.valueOf(valorCelda));
				}
				if(INuevoLibro.txAutor2NuevoLibro.isVisible() && INuevoLibro.txAutor1NuevoLibro.isVisible() && !INuevoLibro.txAutor3NuevoLibro.isVisible() && !INuevoLibro.txAutor4NuevoLibro.isVisible() && !INuevoLibro.txAutor5NuevoLibro.isVisible()){
					INuevoLibro.txAutor2NuevoLibro.setText(String.valueOf(valorCelda));
				}
				if(INuevoLibro.txAutor3NuevoLibro.isVisible()&& INuevoLibro.txAutor2NuevoLibro.isVisible() && INuevoLibro.txAutor1NuevoLibro.isVisible() && !INuevoLibro.txAutor4NuevoLibro.isVisible() && !INuevoLibro.txAutor5NuevoLibro.isVisible()){
					INuevoLibro.txAutor3NuevoLibro.setText(String.valueOf(valorCelda));
				}
				if(INuevoLibro.txAutor4NuevoLibro.isVisible()&& INuevoLibro.txAutor2NuevoLibro.isVisible() && INuevoLibro.txAutor3NuevoLibro.isVisible() && INuevoLibro.txAutor1NuevoLibro.isVisible() && !INuevoLibro.txAutor5NuevoLibro.isVisible()){
					INuevoLibro.txAutor4NuevoLibro.setText(String.valueOf(valorCelda));
				}
				if(INuevoLibro.txAutor5NuevoLibro.isVisible() && INuevoLibro.txAutor4NuevoLibro.isVisible() && INuevoLibro.txAutor3NuevoLibro.isVisible() && INuevoLibro.txAutor2NuevoLibro.isVisible() && INuevoLibro.txAutor1NuevoLibro.isVisible()){
					INuevoLibro.txAutor5NuevoLibro.setText(String.valueOf(valorCelda));
				}
				dispose();
				}

				if (UIOpcionLibro.ml.isVisible()){
					if(ILibroModificar.txAutor1NuevoLibro.isVisible()){
					INuevoLibro.txAutor1NuevoLibro.setText("");
					INuevoLibro.txAutor1NuevoLibro.setText(String.valueOf(valorCelda));
					System.out.println("entro ---->>"+valorCelda);
					}
					if(ILibroModificar.txAutor2NuevoLibro.isVisible() && ILibroModificar.txAutor1NuevoLibro.isVisible() && !ILibroModificar.txAutor3NuevoLibro.isVisible() && !ILibroModificar.txAutor4NuevoLibro.isVisible() && !ILibroModificar.txAutor5NuevoLibro.isVisible()){
						INuevoLibro.txAutor2NuevoLibro.setText(String.valueOf(valorCelda));
					}
					if(ILibroModificar.txAutor3NuevoLibro.isVisible()&& ILibroModificar.txAutor2NuevoLibro.isVisible() && ILibroModificar.txAutor1NuevoLibro.isVisible() && !ILibroModificar.txAutor4NuevoLibro.isVisible() && !ILibroModificar.txAutor5NuevoLibro.isVisible()){
						INuevoLibro.txAutor3NuevoLibro.setText(String.valueOf(valorCelda));
					}
					if(ILibroModificar.txAutor4NuevoLibro.isVisible()&& ILibroModificar.txAutor2NuevoLibro.isVisible() && ILibroModificar.txAutor3NuevoLibro.isVisible() && ILibroModificar.txAutor1NuevoLibro.isVisible() && !ILibroModificar.txAutor5NuevoLibro.isVisible()){
						INuevoLibro.txAutor4NuevoLibro.setText(String.valueOf(valorCelda));
					}
					if(ILibroModificar.txAutor5NuevoLibro.isVisible() && ILibroModificar.txAutor4NuevoLibro.isVisible() && ILibroModificar.txAutor3NuevoLibro.isVisible() && ILibroModificar.txAutor2NuevoLibro.isVisible() && ILibroModificar.txAutor1NuevoLibro.isVisible()){
						INuevoLibro.txAutor5NuevoLibro.setText(String.valueOf(valorCelda));
					}
					}


				dispose();
			}
		});
	}
}




