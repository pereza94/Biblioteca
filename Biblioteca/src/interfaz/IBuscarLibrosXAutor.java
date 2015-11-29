package interfaz;

import java.awt.BorderLayout;
import java.awt.Component;
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
import entity.Libro;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class IBuscarLibrosXAutor extends JDialog {
	private JTextField txBuscar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			IBuscarLibrosXAutor dialog = new IBuscarLibrosXAutor();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public IBuscarLibrosXAutor() {
		setBounds(100, 100, 645, 300);
		JPanel panel = new JPanel();
		panel.setForeground(new Color(0, 0, 255));
		panel.setBounds(20, 11, 670, 411);
		getContentPane().add(panel);
		Border bordejpanel = new TitledBorder(new EtchedBorder(),"Buscar Libros p/ Autor");
		panel.setBorder(bordejpanel);
		panel.setLayout(null);

		JLabel lblIdAutor = new JLabel("ID Autor");
		lblIdAutor.setForeground(new Color(0, 0, 255));
		lblIdAutor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIdAutor.setBounds(170, 40, 58, 14);
		panel.add(lblIdAutor);

		

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 91, 613, 98);
		panel.add(scrollPane);
		scrollPane.setAlignmentX(Component.RIGHT_ALIGNMENT);

		JTable table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"ISBN", "Titulo","Editorial","F.Publicación"
				}
				));
		DefaultTableModel modelo = (DefaultTableModel)table.getModel();

		txBuscar = new JTextField();
	/*	txBuscar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				for (int i = 0; i < table.getRowCount(); i++) {
					modelo.removeRow(i);
					i-=1;
				}
				
					ArrayList<Autor> lista = ctrolDataBase.AutorDB.buscarXPatron(txBuscar.getText());
					int cant = lista.size();
					for(int x =0;x < cant;x++){
						Autor a =lista.get(x);
						int idAt = a.getIdAutor();
						String nombre = a.getIdentidad();
						modelo.addRow(new Object[]{idAt,nombre});
					

				}
			}
		});*/
		txBuscar.setColumns(10);
		txBuscar.setBounds(245, 37, 131, 20);
		panel.add(txBuscar);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String titulo =txBuscar.getText();
				ArrayList<Libro> lista = ctrolDataBase.AutorDB.buscarLibroDeUnAutor(titulo);
				int cant = lista.size();
				for(int x=0; x<cant;x++){
					Libro l = lista.get(x);
					modelo.addRow(new Object[]{l.getIsbn(),l.getTitulo(),l.getEditorial(),l.getAnio()});
				}


			}
		});
		btnBuscar.setForeground(new Color(0, 0, 255));
		btnBuscar.setBounds(400, 36, 89, 23);
		panel.add(btnBuscar);



		scrollPane.setViewportView(table);

		JButton button = new JButton("Cerrar");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		button.setIcon(new ImageIcon(IBuscarLibrosXAutor.class.getResource("/Images/Login/210px-Cruz_roja (1).png")));
		button.setVerticalTextPosition(SwingConstants.BOTTOM);
		button.setInheritsPopupMenu(true);
		button.setIgnoreRepaint(true);
		button.setHorizontalTextPosition(SwingConstants.LEFT);
		button.setForeground(new Color(165, 42, 42));
		button.setFont(new Font("Segoe Print", Font.BOLD, 11));
		button.setBackground(Color.LIGHT_GRAY);
		button.setBounds(517, 230, 105, 23);
		panel.add(button);

	}
}
