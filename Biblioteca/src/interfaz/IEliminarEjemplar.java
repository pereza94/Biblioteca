package interfaz;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

import entity.Ejemplar;
import entity.Libro;

public class IEliminarEjemplar extends JDialog {
	private JTextField txBuscar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			IEliminarEjemplar dialog = new IEliminarEjemplar();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public IEliminarEjemplar() {
		setBounds(100, 100, 671, 487);
		getContentPane().setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, SystemColor.activeCaption, null));
		panel_1.setBounds(20, 209, 596, 168);
		getContentPane().add(panel_1);
		
		JLabel label = new JLabel("Datos del Libro");
		label.setForeground(SystemColor.textHighlight);
		label.setBounds(291, 11, 93, 14);
		panel_1.add(label);
		
		JLabel label_1 = new JLabel("Autor:");
		label_1.setForeground(SystemColor.textHighlight);
		label_1.setBounds(10, 58, 60, 14);
		panel_1.add(label_1);
		
		JLabel lblAutor = new JLabel("");
		lblAutor.setForeground(new Color(0, 128, 0));
		lblAutor.setBounds(145, 58, 439, 14);
		panel_1.add(lblAutor);
		
		JLabel label_3 = new JLabel("Titulo:");
		label_3.setForeground(SystemColor.textHighlight);
		label_3.setBounds(10, 33, 60, 14);
		panel_1.add(label_3);
		
		JLabel lbl_4 = new JLabel("");
		lbl_4.setForeground(new Color(0, 128, 0));
		lbl_4.setBounds(145, 33, 439, 14);
		panel_1.add(lbl_4);
		
		JLabel label_5 = new JLabel("Editorial:");
		label_5.setForeground(SystemColor.textHighlight);
		label_5.setBounds(10, 83, 60, 14);
		panel_1.add(label_5);
		
		JLabel lblEditorial = new JLabel("");
		lblEditorial.setForeground(new Color(0, 128, 0));
		lblEditorial.setBounds(145, 83, 439, 14);
		panel_1.add(lblEditorial);
		
		JLabel label_7 = new JLabel("Fecha Publicaci\u00F3n:");
		label_7.setForeground(SystemColor.textHighlight);
		label_7.setBounds(10, 108, 106, 14);
		panel_1.add(label_7);
		
		JLabel lblFecha = new JLabel("");
		lblFecha.setForeground(new Color(0, 128, 0));
		lblFecha.setBounds(145, 108, 439, 14);
		panel_1.add(lblFecha);
		
		JLabel lblIsbn = new JLabel("ID Ejemplar:");
		lblIsbn.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIsbn.setForeground(new Color(128, 0, 128));
		lblIsbn.setBounds(85, 27, 115, 14);
		getContentPane().add(lblIsbn);
		
		txBuscar = new JTextField();
		txBuscar.setBounds(220, 24, 232, 20);
		getContentPane().add(txBuscar);
		txBuscar.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 128, 128), null));
		panel.setBounds(20, 52, 596, 142);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblDatosEjemlplar = new JLabel("                  Datos Ejemlplar");
		lblDatosEjemlplar.setForeground(new Color(34, 139, 34));
		lblDatosEjemlplar.setHorizontalAlignment(SwingConstants.CENTER);
		lblDatosEjemlplar.setBounds(10, 11, 576, 14);
		panel.add(lblDatosEjemlplar);
		
		JLabel lblEditorial_1 = new JLabel("Cod. Ubicaci\u00F3n");
		lblEditorial_1.setBounds(20, 40, 87, 14);
		panel.add(lblEditorial_1);
		
		JLabel lblIsbn_1 = new JLabel("ISBN");
		lblIsbn_1.setBounds(20, 65, 46, 14);
		panel.add(lblIsbn_1);
		
		JLabel lblFechaAlta = new JLabel("Fecha alta:");
		lblFechaAlta.setBounds(20, 90, 79, 14);
		panel.add(lblFechaAlta);
		
		JLabel lblCUbicación = new JLabel("");
		lblCUbicación.setBounds(117, 40, 346, 14);
		panel.add(lblCUbicación);
		
		JLabel lblCFAlta = new JLabel("");
		lblCFAlta.setBounds(117, 90, 346, 14);
		panel.add(lblCFAlta);
		
		JLabel lblCISBN = new JLabel("");
		lblCISBN.setBounds(117, 65, 346, 14);
		panel.add(lblCISBN);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBackground(Color.LIGHT_GRAY);
		btnBuscar.setToolTipText("Permite validar datos de un ejemplar");
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			

				String buscado = txBuscar.getText();
				entity.Ejemplar eje = new entity.Ejemplar();
				eje =ctrolDataBase.EjemplarDB.encontrarEjemplar(Integer.parseInt(buscado));
				lblCISBN.setText(eje.getIsbn());
				lblCUbicación.setText(eje.getCodUbicaion());
				lblCFAlta.setText(ctrolDataBase.EjemplarDB.convertirFechaString(eje.getFechaAlta()));
				buscado=eje.getIsbn();
				ArrayList<Libro> ll = ctrolDataBase.EjemplarDB.buscarXISBN(buscado);
				System.out.println(ll.size());
				if(ll.size()== 0){
					ArrayList<Libro> llsa = ctrolDataBase.EjemplarDB.buscarXISBNSAutor(buscado);
					Libro l = llsa.get(0);
					lbl_4.setText(l.getTitulo());
					lblAutor.setText(l.getAutor());
					lblEditorial.setText(l.getEditorial());
					lblFecha.setText(ctrolDataBase.EjemplarDB.convertirFechaString(l.getAnio()));

				}else
				{
					Libro l = ll.get(0);
					lbl_4.setText(l.getTitulo());
					lblEditorial.setText(l.getEditorial());System.out.println(l.getAutor());
					lblFecha.setText(ctrolDataBase.EjemplarDB.convertirFechaString(l.getAnio()));
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

						lblAutor.setText(autores);
					}

				}

			}



		});
		btnBuscar.setForeground(new Color(0, 0, 255));
		btnBuscar.setIcon(new ImageIcon(IEliminarEjemplar.class.getResource("/Images/Login/lupa (1).png")));
		btnBuscar.setBounds(489, 23, 115, 23);
		getContentPane().add(btnBuscar);
		
		JButton btnEliminarEjemplar = new JButton("Eliminar Ejemplar");
		btnEliminarEjemplar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				entity.Ejemplar eje = new entity.Ejemplar();
				eje = ctrolDataBase.EjemplarDB.eliminarEjemplar(Integer.parseInt(txBuscar.getText()));
				if(eje!=null ){JOptionPane.showMessageDialog(null, "Ejemplar eliminado correctamente");
				dispose();}
			}
		});
		btnEliminarEjemplar.setIcon(new ImageIcon(IEliminarEjemplar.class.getResource("/Images/Login/abort-146072_640 (1).png")));
		btnEliminarEjemplar.setToolTipText("elimina el ejemplar");
		btnEliminarEjemplar.setForeground(new Color(255, 0, 0));
		btnEliminarEjemplar.setBackground(Color.LIGHT_GRAY);
		btnEliminarEjemplar.setBounds(356, 402, 168, 23);
		getContentPane().add(btnEliminarEjemplar);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBackground(Color.LIGHT_GRAY);
		btnVolver.setToolTipText("Vuelve a la pantalla anterior");
		btnVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
			}
		});
		btnVolver.setForeground(new Color(0, 0, 205));
		btnVolver.setBounds(556, 402, 89, 23);
		getContentPane().add(btnVolver);
		
		
	}
}
