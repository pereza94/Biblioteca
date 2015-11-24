package interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
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
		setBounds(100, 100, 716, 433);
		getContentPane().setLayout(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setAlignmentX(Component.RIGHT_ALIGNMENT);
		scrollPane.setBounds(24, 91, 643, 252);
		getContentPane().add(scrollPane);
		
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
		
		JLabel lblBuscar = new JLabel("Buscar");
		lblBuscar.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBuscar.setBounds(10, 32, 48, 14);
		getContentPane().add(lblBuscar);
		
		txBuscar = new JTextField();
		txBuscar.setBounds(61, 29, 453, 20);
		getContentPane().add(txBuscar);
		txBuscar.setColumns(10);
		
		JRadioButton rdbtnIdAutor = new JRadioButton("ID Autor");
		buttonGroup.add(rdbtnIdAutor);
		rdbtnIdAutor.setBounds(84, 56, 109, 23);
		getContentPane().add(rdbtnIdAutor);
		
		JRadioButton rdbtnNombre = new JRadioButton("Nombre");
		buttonGroup.add(rdbtnNombre);
		rdbtnNombre.setBounds(276, 56, 109, 23);
		getContentPane().add(rdbtnNombre);
		
		JButton button = new JButton("Cerrar");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			dispose();
			}
		});
		button.setIcon(new ImageIcon(IBuscarAutores.class.getResource("/Images/Login/210px-Cruz_roja (1).png")));
		button.setVerticalTextPosition(SwingConstants.BOTTOM);
		button.setInheritsPopupMenu(true);
		button.setIgnoreRepaint(true);
		button.setHorizontalTextPosition(SwingConstants.LEFT);
		button.setForeground(new Color(165, 42, 42));
		button.setFont(new Font("Segoe Print", Font.BOLD, 11));
		button.setBackground(Color.LIGHT_GRAY);
		button.setBounds(585, 360, 105, 23);
		getContentPane().add(button);
		
		JButton btnBuscar = new JButton("Buscar");
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
		btnBuscar.setBounds(541, 28, 126, 23);
		getContentPane().add(btnBuscar);
		
		JButton btnAgregarAutor = new JButton("Agregar Autor");
		btnAgregarAutor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				INuevoAutor n = new INuevoAutor();
				n.setVisible(true);
			}
		});
		btnAgregarAutor.setBounds(21, 361, 126, 23);
		getContentPane().add(btnAgregarAutor);
		
		
	
	}
}
