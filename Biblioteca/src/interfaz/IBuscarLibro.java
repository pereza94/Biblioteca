package interfaz;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import ctrolDataBase.LibroDB;
import ctrolDataBase.SociosDB;
import entity.Libro;
import entity.Socio;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.ComponentOrientation;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class IBuscarLibro extends JDialog {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			IBuscarLibro dialog = new IBuscarLibro();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	JTextField txBuscado;
	JTable table;
	private JTextField txBuscar;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Create the dialog.
	 */
	public IBuscarLibro() {



		getContentPane().setForeground(Color.BLUE);
		setBounds(100, 100, 677, 419);
		getContentPane().setLayout(null);

		setTitle("Nuevo Libro");
		setBounds(100, 100, 677, 419);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setForeground(Color.BLUE);
		panel.setBounds(10, 11, 645, 361);
		getContentPane().add(panel);
		Border bordejpanel = new TitledBorder(new EtchedBorder(),"Buscar Libro");
		panel.setBorder(bordejpanel);
		panel.setLayout(null);

		JLabel lblBuscar = new JLabel("Buscar");
		lblBuscar.setBounds(10, 26, 46, 14);
		lblBuscar.setForeground(Color.BLUE);
		panel.add(lblBuscar);

		

		JRadioButton rdbtnIsbn = new JRadioButton("ISBN");
		rdbtnIsbn.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		rdbtnIsbn.setBounds(102, 66, 109, 23);
		rdbtnIsbn.setForeground(Color.BLUE);
		buttonGroup.add(rdbtnIsbn);
		rdbtnIsbn.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(rdbtnIsbn);

		JRadioButton rdbtnTitulo = new JRadioButton("Titulo");
		rdbtnTitulo.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		rdbtnTitulo.setBounds(276, 66, 109, 23);
		rdbtnTitulo.setForeground(Color.BLUE);
		buttonGroup.add(rdbtnTitulo);
		rdbtnTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(rdbtnTitulo);

		JLabel lblBuscarPor = new JLabel("Buscar por:");
		lblBuscarPor.setBounds(10, 70, 74, 14);
		lblBuscarPor.setForeground(Color.BLUE);
		panel.add(lblBuscarPor);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 91, 613, 196);
		panel.add(scrollPane);
		scrollPane.setAlignmentX(Component.RIGHT_ALIGNMENT);

		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"ISBN", "Titulo","Editorial","F.Publicación","Autor/es"
				}
				));
		DefaultTableModel modelo = (DefaultTableModel)table.getModel();


		scrollPane.setViewportView(table);

		rdbtnTitulo.setSelected(true);


		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(rdbtnIsbn.isSelected()){
					String titulo =txBuscar.getText();
					ArrayList<Libro> lista = ctrolDataBase.LibroDB.buscarXISBN(titulo);
					int cant = lista.size();
					if(cant==0)
					{	
						ArrayList<Libro> lista1 = ctrolDataBase.LibroDB.buscarXISBNSAutor(titulo);
						int cantS = lista1.size();
						for(int x=0; x<cantS;x++){
							Libro l = lista1.get(x);
							modelo.addRow(new Object[]{l.getIsbn(),l.getTitulo(),l.getEditorial(),l.getAnio(),l.getAutor()});}
					}



					for(int x=0; x<cant;x++){
						Libro l = lista.get(x);
						modelo.addRow(new Object[]{l.getIsbn(),l.getTitulo(),l.getEditorial(),l.getAnio(),l.getAutor()});
					}
				}
				if (rdbtnTitulo.isSelected()){
					String titulo =txBuscar.getText().toUpperCase();
					ArrayList<Libro> lista = ctrolDataBase.LibroDB.buscarXTitulo(titulo);
					int cant = lista.size();
					if(cant==0)
					{	
						ArrayList<Libro> lista1 = ctrolDataBase.LibroDB.buscarXTituloSinAutor(titulo);
						int cantS = lista1.size();
						for(int x=0; x<cantS;x++){
							Libro l = lista1.get(x);
							modelo.addRow(new Object[]{l.getIsbn(),l.getTitulo(),l.getEditorial(),l.getAnio(),l.getAutor()});}
					}
					for(int x=0; x<cant;x++){
						Libro l = lista.get(x);
						modelo.addRow(new Object[]{l.getIsbn(),l.getTitulo(),l.getEditorial(),l.getAnio(),l.getAutor()});
					}
				}
			}
		});
		btnBuscar.setBounds(350, 22, 149, 23);
		btnBuscar.setForeground(Color.BLUE);
		btnBuscar.setIcon(new ImageIcon(IBuscarLibro.class.getResource("/Images/Login/lupa (1).png")));
		panel.add(btnBuscar);


		JButton btnLimpiarTabla = new JButton("Limpiar Tabla");
		btnLimpiarTabla.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				for (int i = 0; i < table.getRowCount(); i++) {
					modelo.removeRow(i);
					i-=1;
				}

			}
		});
		btnLimpiarTabla.setBackground(Color.WHITE);
		btnLimpiarTabla.setIcon(new ImageIcon(IBuscarLibro.class.getResource("/Images/Login/8fc03fbe37e8ed0e1e784244c68f3fe8.png")));
		btnLimpiarTabla.setBounds(481, 66, 142, 23);
		panel.add(btnLimpiarTabla);

		JButton button = new JButton("Nuevo Libro");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				INuevoLibro nl= new INuevoLibro();
				nl.setVisible(true);
			}
		});
		button.setBounds(10, 315, 142, 24);
		panel.add(button);
		button.setIcon(new ImageIcon(IBuscarLibro.class.getResource("/Images/Login/red-sign-computer-green-icon-mark-symbol-cartoon.png")));
		button.setForeground(new Color(0, 102, 0));
		button.setBackground(SystemColor.activeCaptionBorder);

		JButton button_1 = new JButton("Cerrar");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		button_1.setIcon(new ImageIcon(IBuscarLibro.class.getResource("/Images/Login/210px-Cruz_roja (1).png")));
		button_1.setVerticalTextPosition(SwingConstants.BOTTOM);
		button_1.setInheritsPopupMenu(true);
		button_1.setIgnoreRepaint(true);
		button_1.setHorizontalTextPosition(SwingConstants.LEFT);
		button_1.setForeground(new Color(165, 42, 42));
		button_1.setFont(new Font("Segoe Print", Font.BOLD, 11));
		button_1.setBackground(Color.LIGHT_GRAY);
		button_1.setBounds(507, 316, 105, 23);
		panel.add(button_1);



		txBuscar = new JTextField();
		txBuscar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				for (int i = 0; i < table.getRowCount(); i++) {
					modelo.removeRow(i);
					i-=1;
				}
				if(rdbtnIsbn.isSelected()){
				String titulo =txBuscar.getText();
				ArrayList<Libro> lista = ctrolDataBase.LibroDB.buscarXISBN(titulo);
				int cant = lista.size();
				if(cant==0)
				{	
					ArrayList<Libro> lista1 = ctrolDataBase.LibroDB.buscarXISBNSAutor(titulo);
					int cantS = lista1.size();
					for(int x=0; x<cantS;x++){
						Libro l = lista1.get(x);
						modelo.addRow(new Object[]{l.getIsbn(),l.getTitulo(),l.getEditorial(),l.getAnio(),l.getAutor()});}
				}
				for(int x=0; x<cant;x++){
					Libro l = lista.get(x);
					
						
				}
				}
			
			if (rdbtnTitulo.isSelected()){
				String titulo1 =txBuscar.getText().toUpperCase();
				ArrayList<Libro> lista1 = ctrolDataBase.LibroDB.buscarXTitulo(titulo1);
				int cant1 = lista1.size();
				if(cant1==0)
				{	
					ArrayList<Libro> lista11 = ctrolDataBase.LibroDB.buscarXTituloSinAutor(titulo1);
					int cantS = lista11.size();
					for(int x=0; x<cantS;x++){
						Libro l = lista11.get(x);
						modelo.addRow(new Object[]{l.getIsbn(),l.getTitulo(),l.getEditorial(),l.getAnio(),l.getAutor()});}
				}
				for(int x=0; x<cant1;x++){
					Libro l = lista1.get(x);
					modelo.addRow(new Object[]{l.getIsbn(),l.getTitulo(),l.getEditorial(),l.getAnio(),l.getAutor()});
				}
			}
		
			}
		});
		txBuscar.setBounds(66, 23, 274, 20);
		panel.add(txBuscar);
		txBuscar.setColumns(10);
		
		
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int fila=table.getSelectedRow();
				String valorCelda =  (String) table.getValueAt(fila,0);	
				if(!UIPrincipañ.np.isActive()){
					INuevoPrestamo.txBuscado.setText(valorCelda);
					dispose();
				}

			}

		});
		
		
	}




}


