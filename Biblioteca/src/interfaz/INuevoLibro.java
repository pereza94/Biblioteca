
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
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.util.Calendar;
import java.awt.Choice;
import org.freixas.jcalendar.JCalendar;
import org.freixas.jcalendar.JCalendarCombo;

public class INuevoLibro extends JDialog {
	public static JTextField txISBNNuevoLibro;
	public static JTextField txTextoNuevoLibro;
	public static JTextField txAutor1NuevoLibro;
	public static JTextField txAutor2NuevoLibro;
	public static JTextField txAutor3NuevoLibro;
	public static JTextField txAutro3NuevoLibro;
	public static JTextField txAutor5NuevoLibro;
	public static JTextField txAutor4NuevoLibro;
	public static JTextField txEditorialNuevoLibro;
	public static JTextField txTituloNuevoLibro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			INuevoLibro dialog = new INuevoLibro();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public INuevoLibro() {
		setTitle("Nuevo Libro");
		setBounds(100, 100, 529, 384);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 25, 493, 306);
		getContentPane().add(panel);
		Border bordejpanel = new TitledBorder(new EtchedBorder(),"Nuevo Libro");
		panel.setBorder(bordejpanel);
		panel.setLayout(null);

		JLabel lblIsbn = new JLabel("ISBN");
		lblIsbn.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIsbn.setBounds(57, 24, 52, 14);
		panel.add(lblIsbn);

		txISBNNuevoLibro = new JTextField();
		txISBNNuevoLibro.setBounds(119, 21, 86, 20);
		panel.add(txISBNNuevoLibro);
		txISBNNuevoLibro.setColumns(10);

		JLabel lblTitulo = new JLabel("Titulo");
		lblTitulo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTitulo.setBounds(10, 79, 59, 14);
		panel.add(lblTitulo);

		txTituloNuevoLibro = new JTextField();
		txTituloNuevoLibro.setBounds(84, 76, 86, 20);
		panel.add(txTituloNuevoLibro);
		txTituloNuevoLibro.setColumns(10);

		JLabel lblAo = new JLabel("Fecha Publicaci\u00F3n");
		lblAo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAo.setBounds(180, 79, 118, 14);
		panel.add(lblAo);

		JLabel lblIdAutor = new JLabel("ID Autor");
		lblIdAutor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIdAutor.setBounds(10, 127, 59, 14);
		panel.add(lblIdAutor);

		txAutor1NuevoLibro = new JTextField();
		txAutor1NuevoLibro.setBounds(84, 124, 86, 20);
		panel.add(txAutor1NuevoLibro);
		txAutor1NuevoLibro.setColumns(10);

		JButton btnNewButton = new JButton("Buscar Autores");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				IBuscarAutores c = new IBuscarAutores();
				c.setVisible(true);
			}
		});


		JButton button_1 = new JButton("Cerrar");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		button_1.setIcon(new ImageIcon(INuevoLibro.class.getResource("/Images/Login/210px-Cruz_roja (1).png")));
		button_1.setVerticalTextPosition(SwingConstants.BOTTOM);
		button_1.setInheritsPopupMenu(true);
		button_1.setIgnoreRepaint(true);
		button_1.setHorizontalTextPosition(SwingConstants.LEFT);
		button_1.setForeground(new Color(165, 42, 42));
		button_1.setFont(new Font("Segoe Print", Font.BOLD, 11));
		button_1.setBackground(Color.LIGHT_GRAY);
		button_1.setBounds(301, 238, 105, 23);
		panel.add(button_1);

		txAutor2NuevoLibro = new JTextField();
		txAutor2NuevoLibro.setBounds(84, 154, 86, 20);
		panel.add(txAutor2NuevoLibro);
		txAutor2NuevoLibro.setColumns(10);
		txAutor2NuevoLibro.setVisible(false);txAutor2NuevoLibro.setText("0");

		txAutor3NuevoLibro = new JTextField();
		txAutor3NuevoLibro.setBounds(84, 185, 86, 20);
		panel.add(txAutor3NuevoLibro);
		txAutor3NuevoLibro.setColumns(10);
		txAutor3NuevoLibro.setVisible(false);
		txAutor3NuevoLibro.setText("0");

		txAutor4NuevoLibro = new JTextField();
		txAutor4NuevoLibro.setBounds(188, 154, 86, 20);
		panel.add(txAutor4NuevoLibro);
		txAutor4NuevoLibro.setColumns(10);
		txAutor4NuevoLibro.setVisible(false);
		txAutor4NuevoLibro.setText("0");

		txAutor5NuevoLibro = new JTextField();
		txAutor5NuevoLibro.setBounds(188, 185, 86, 20);
		panel.add(txAutor5NuevoLibro);
		txAutor5NuevoLibro.setColumns(10);
		txAutor5NuevoLibro.setVisible(false);
		txAutor5NuevoLibro.setText("0");


		JButton button_2 = new JButton("+");
		button_2.setForeground(Color.BLUE);
		button_2.addMouseListener(new MouseAdapter() {

			int x=2;
			public void mouseClicked(MouseEvent arg0) {
				switch (x) {
				case 2:
					txAutor2NuevoLibro.setVisible(true);x++;break;
				case 3:txAutor3NuevoLibro.setVisible(true);x++;break; 
				case 4: txAutor4NuevoLibro.setVisible(true);x++;break;
				case 5: txAutor5NuevoLibro.setVisible(true);x++;break;
				}


			}
		});
		button_2.setBounds(180, 123, 53, 23);
		panel.add(button_2);


		JLabel lblEditorial = new JLabel("Editorial");
		lblEditorial.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEditorial.setBounds(239, 24, 59, 14);
		panel.add(lblEditorial);

		txEditorialNuevoLibro = new JTextField();
		txEditorialNuevoLibro.setBounds(308, 21, 86, 20);
		panel.add(txEditorialNuevoLibro);
		txEditorialNuevoLibro.setColumns(10);

		JCalendarCombo calendarCombo = new JCalendarCombo();
		calendarCombo.setBounds(300, 76, 183, 20);
		panel.add(calendarCombo);


		btnNewButton.setIcon(new ImageIcon(INuevoLibro.class.getResource("/Images/Login/lupa (1).png")));
		btnNewButton.setBounds(243, 123, 151, 23);
		panel.add(btnNewButton);

		JButton button = new JButton("Aceptar");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String isbn =txISBNNuevoLibro.getText();if(isbn.length()!= 10){JOptionPane.showMessageDialog(null, "El ISBN debe poseer 10(diez) caracteres");}
				String titulo =txTituloNuevoLibro.getText().toUpperCase();
				//Date fecha = new ; System.out.println(""+fecha);
				Calendar calendar = calendarCombo.getCalendar().getInstance();
				calendar.set(Calendar.YEAR, calendarCombo.getCalendar().get(calendar.YEAR));
				calendar.set(Calendar.DAY_OF_MONTH, calendarCombo.getCalendar().get(Calendar.DAY_OF_MONTH));
				calendar.set(Calendar.MONTH, calendarCombo.getCalendar().get(Calendar.MONTH) + 1); // Assuming you wanted May 1st
				java.sql.Date date = new java.sql.Date(calendar.getTime().getTime());
				int numpaginas = 0;
				int idau1 =Integer.parseInt(txAutor1NuevoLibro.getText());
				int idau2 =Integer.parseInt(txAutor2NuevoLibro.getText());
				int idau3 =Integer.parseInt(txAutor3NuevoLibro.getText());
				int idau4 =Integer.parseInt(txAutor4NuevoLibro.getText());
				int idau5 =Integer.parseInt(txAutor5NuevoLibro.getText());
				String editorial = txEditorialNuevoLibro.getText();
				ctrolDataBase.LibroDB.insertarLibro(isbn, titulo, date, numpaginas, editorial);
				ctrolDataBase.LibroDB.insertarLibroAutor(isbn, idau1);
				if(Integer.parseInt(txAutor2NuevoLibro.getText())!=0){ctrolDataBase.LibroDB.insertarLibroAutor(isbn, idau2);}
				if(Integer.parseInt(txAutor3NuevoLibro.getText())!=0){ctrolDataBase.LibroDB.insertarLibroAutor(isbn, idau3);}
				if(Integer.parseInt(txAutor4NuevoLibro.getText())!=0){ctrolDataBase.LibroDB.insertarLibroAutor(isbn, idau4);}
				if(Integer.parseInt(txAutor5NuevoLibro.getText())!=0){ctrolDataBase.LibroDB.insertarLibroAutor(isbn, idau5);}


			}
		});
		button.setIcon(new ImageIcon(INuevoLibro.class.getResource("/Images/Login/checkok.jpg")));
		button.setVerticalTextPosition(SwingConstants.BOTTOM);
		button.setInheritsPopupMenu(true);
		button.setIgnoreRepaint(true);
		button.setHorizontalTextPosition(SwingConstants.RIGHT);
		button.setForeground(new Color(0, 100, 0));
		button.setFont(new Font("Segoe Print", Font.BOLD, 11));
		button.setBackground(Color.LIGHT_GRAY);
		button.setBounds(180, 239, 105, 23);
		panel.add(button);

	}
}
