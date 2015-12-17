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

import entity.Ejemplar;
import entity.Libro;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.SystemColor;

public class INuevoEjemplar extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public static JTextField txISBN;
	private JTextField txUbicacion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			INuevoEjemplar dialog = new INuevoEjemplar();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public INuevoEjemplar() {
		setBounds(100, 100, 704, 420);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);

		JPanel panel = new JPanel();
		panel.setBounds(20, 11, 670, 411);
		getContentPane().add(panel);
		Border bordejpanel = new TitledBorder(new EtchedBorder(),"Nuevo Ejemplar");
		panel.setBorder(bordejpanel);
		panel.setLayout(null);

		JLabel lblIsbn = new JLabel("ISBN");
		lblIsbn.setForeground(SystemColor.textHighlight);
		lblIsbn.setBounds(60, 29, 72, 14);
		panel.add(lblIsbn);

		txISBN = new JTextField();
		txISBN.setBounds(136, 26, 86, 20);
		panel.add(txISBN);
		txISBN.setColumns(10);


		JLabel lblNmeroDeInventario = new JLabel("N\u00FAmero de Inventario");
		lblNmeroDeInventario.setForeground(SystemColor.textHighlight);
		lblNmeroDeInventario.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNmeroDeInventario.setBounds(10, 115, 122, 14);
		panel.add(lblNmeroDeInventario);

		txUbicacion = new JTextField();
		txUbicacion.setBounds(136, 70, 86, 20);
		panel.add(txUbicacion);
		txUbicacion.setColumns(10);

		JLabel lblllnnnn = new JLabel("(LLNNNN)");
		lblllnnnn.setForeground(SystemColor.textHighlight);
		lblllnnnn.setBounds(232, 73, 65, 14);
		panel.add(lblllnnnn);

		JLabel lblLugarDeUbicain = new JLabel("Lugar de Ubicai\u00F3n");
		lblLugarDeUbicain.setForeground(SystemColor.textHighlight);
		lblLugarDeUbicain.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLugarDeUbicain.setBounds(10, 73, 122, 14);
		panel.add(lblLugarDeUbicain);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, SystemColor.activeCaption, null));
		panel_1.setBounds(10, 159, 667, 155);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblDatosDelLibro = new JLabel("Datos del Libro");
		lblDatosDelLibro.setForeground(SystemColor.textHighlight);
		lblDatosDelLibro.setBounds(291, 11, 93, 14);
		panel_1.add(lblDatosDelLibro);

		JLabel lblAutor = new JLabel("Autor:");
		lblAutor.setForeground(SystemColor.textHighlight);
		lblAutor.setBounds(10, 58, 60, 14);
		panel_1.add(lblAutor);

		JLabel lblCAutor = new JLabel("");
		lblCAutor.setForeground(new Color(0, 128, 0));
		lblCAutor.setBounds(145, 58, 439, 14);
		panel_1.add(lblCAutor);

		JLabel lblTitulo = new JLabel("Titulo:");
		lblTitulo.setForeground(SystemColor.textHighlight);
		lblTitulo.setBounds(10, 33, 60, 14);
		panel_1.add(lblTitulo);

		JLabel lblCTitulo = new JLabel("");
		lblCTitulo.setForeground(new Color(0, 128, 0));
		lblCTitulo.setBounds(145, 33, 439, 14);
		panel_1.add(lblCTitulo);

		JLabel lblEditorial = new JLabel("Editorial:");
		lblEditorial.setForeground(SystemColor.textHighlight);
		lblEditorial.setBounds(10, 83, 60, 14);
		panel_1.add(lblEditorial);

		JLabel lblCEditorial = new JLabel("");
		lblCEditorial.setForeground(new Color(0, 128, 0));
		lblCEditorial.setBounds(145, 83, 439, 14);
		panel_1.add(lblCEditorial);

		JLabel lblFechaPublicacin = new JLabel("Fecha Publicaci\u00F3n:");
		lblFechaPublicacin.setForeground(SystemColor.textHighlight);
		lblFechaPublicacin.setBounds(10, 108, 106, 14);
		panel_1.add(lblFechaPublicacin);

		JLabel lblCFechaPublicacion = new JLabel("");
		lblCFechaPublicacion.setForeground(new Color(0, 128, 0));
		lblCFechaPublicacion.setBounds(145, 108, 439, 14);
		panel_1.add(lblCFechaPublicacion);

		JButton button = new JButton("Cerrar");
		button.setToolTipText("cerrar ventana");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
			}
		});
		button.setIcon(new ImageIcon(INuevoEjemplar.class.getResource("/Images/Login/210px-Cruz_roja (1).png")));
		button.setVerticalTextPosition(SwingConstants.BOTTOM);
		button.setInheritsPopupMenu(true);
		button.setIgnoreRepaint(true);
		button.setHorizontalTextPosition(SwingConstants.LEFT);
		button.setForeground(new Color(165, 42, 42));
		button.setFont(new Font("Segoe Print", Font.BOLD, 11));
		button.setBackground(Color.LIGHT_GRAY);
		button.setBounds(566, 325, 105, 23);
		panel.add(button);



		JLabel lbIDLIBRO = new JLabel("");
		lbIDLIBRO.setBounds(151, 115, 65, 14);
		panel.add(lbIDLIBRO);

		JButton btnBuscarLibro = new JButton("Validar Datos");
		btnBuscarLibro.setToolTipText("Permite verficar datos sobre el ISBN");
		btnBuscarLibro.setBackground(Color.LIGHT_GRAY);
		btnBuscarLibro.setIcon(new ImageIcon(INuevoEjemplar.class.getResource("/Images/Login/checkok.jpg")));
		btnBuscarLibro.setForeground(SystemColor.textHighlight);
		btnBuscarLibro.addMouseListener(new MouseAdapter() {
			private String autores;

			@Override
			public void mouseClicked(MouseEvent e) {
				int a= (ctrolDataBase.EjemplarDB.obtenerNumeroEjemplar()+7);

				lbIDLIBRO.setText(String.valueOf(a));
				String buscado = txISBN.getText();
				ArrayList<Libro> ll = ctrolDataBase.EjemplarDB.buscarXISBN(buscado);
				System.out.println(ll.size());
				if(ll.size()== 0){
					ArrayList<Libro> llsa = ctrolDataBase.EjemplarDB.buscarXISBNSAutor(buscado);
					Libro l = llsa.get(0);
					lblCTitulo.setText(l.getTitulo());
					lblCAutor.setText(l.getAutor());
					lblCEditorial.setText(l.getEditorial());
					lblCFechaPublicacion.setText(ctrolDataBase.EjemplarDB.convertirFechaString(l.getAnio()));

				}else
				{
					Libro l = ll.get(0);
					lblCTitulo.setText(l.getTitulo());
					lblCEditorial.setText(l.getEditorial());System.out.println(l.getAutor());
					lblCFechaPublicacion.setText(ctrolDataBase.EjemplarDB.convertirFechaString(l.getAnio()));
					String var1 = "";String var2 = "";String var3 = "";String var4 = "";
					for(int x=0; x< ll.size();x++){
						l =ll.get(x);
						switch (x) {
						case 0:  var1 = l.getAutor();	break;
						case 1:  var2 = l.getAutor();	break;
						case 2:  var3 = l.getAutor();	break;
						case 3:  var4 = l.getAutor();	break;
						default:
							break;
						}
						String autores = var1 +" - "+ var2+" - " + var3+" - " + var4;

						lblCAutor.setText(autores);
					}

				}


			}
		});

		btnBuscarLibro.setBounds(232, 25, 149, 23);
		panel.add(btnBuscarLibro);

		JButton button_1 = new JButton("");
		button_1.setToolTipText("Buscar Libro");
		button_1.setBackground(Color.LIGHT_GRAY);
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				IBuscarLibro ibl = new IBuscarLibro();
				ibl.setVisible(true);
			}
		});
		button_1.setIcon(new ImageIcon(INuevoEjemplar.class.getResource("/Images/Login/lupa (1).png")));
		button_1.setBounds(389, 25, 40, 23);
		panel.add(button_1);

		JButton btnGuardarEjemplar = new JButton("Guardar Ejemplar");
		btnGuardarEjemplar.setToolTipText("Almacena ejemplar");
		btnGuardarEjemplar.addMouseListener(new MouseAdapter() {
			private DateFormat calendarCombo;

			@Override
			public void mouseClicked(MouseEvent e) {
				entity.Ejemplar e1 = new entity.Ejemplar();
				e1.setNumInventario((Integer.parseInt(lbIDLIBRO.getText())));
				e1.setIsbn(txISBN.getText());
				e1.setCodUbicaion(txUbicacion.getText().toUpperCase());
				calendarCombo = null;
				calendarCombo.getInstance();
				Calendar calendar = Calendar.getInstance();
				java.sql.Date date = new java.sql.Date(calendar.getTime().getTime());
				e1.setFechaAlta(date);
				ctrolDataBase.EjemplarDB.insertarEjemplar(e1.getNumInventario(), e1.getFechaAlta(), e1.getCodUbicaion(), e1.getIsbn());
				JOptionPane.showMessageDialog(null, "Ejemplar almacenado correctamente");
				dispose();
			}
		});
		btnGuardarEjemplar.setBackground(Color.LIGHT_GRAY);
		btnGuardarEjemplar.setIcon(new ImageIcon(INuevoEjemplar.class.getResource("/Images/Login/checkok.jpg")));
		btnGuardarEjemplar.setForeground(new Color(0, 100, 0));
		btnGuardarEjemplar.setBounds(389, 325, 168, 23);
		panel.add(btnGuardarEjemplar);

		JButton btnEliminar = new JButton("");
		btnEliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				IEliminarEjemplar ee = new IEliminarEjemplar();
				ee.setVisible(true);
			}
		});
		btnEliminar.setToolTipText("Eliminar un ejemplar");
		btnEliminar.setForeground(Color.RED);
		btnEliminar.setBackground(Color.LIGHT_GRAY);
		btnEliminar.setIcon(new ImageIcon(INuevoEjemplar.class.getResource("/Images/Login/abort-146072_640 (1).png")));
		btnEliminar.setBounds(438, 25, 40, 23);
		panel.add(btnEliminar);





	}
}
