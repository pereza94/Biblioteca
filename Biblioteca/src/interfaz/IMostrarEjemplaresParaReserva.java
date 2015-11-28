package interfaz;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import entity.Ejemplar;
import entity.Prestamo;
import entity.Reserva;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.EtchedBorder;

public class  IMostrarEjemplaresParaReserva extends JDialog {

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			IMostrarEjemplaresParaReserva dialog = new IMostrarEjemplaresParaReserva(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	/**
	 * Create the dialog.
	 */
	public IMostrarEjemplaresParaReserva(String isbn) {
	
		setBounds(100, 100, 458, 452);
		getContentPane().setLayout(null);
		{


			JPanel panel = new JPanel();
			panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.BLUE, null));
			panel.setBounds(10, 214, 422, 175);
			getContentPane().add(panel);
			panel.setLayout(null);

			JLabel lblProximosDisponibles = new JLabel("Proximos Disponibles");
			lblProximosDisponibles.setHorizontalAlignment(SwingConstants.CENTER);
			lblProximosDisponibles.setBounds(10, 11, 394, 14);
			panel.add(lblProximosDisponibles);

			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 39, 394, 97);
			panel.add(scrollPane);
			scrollPane.setAlignmentX(Component.RIGHT_ALIGNMENT);

			JTable table = new JTable();
			table.setModel(new DefaultTableModel(
					new Object[][] {
						
					},
					new String[] {
							"IDEjemplar", "FechaDevolución","Poseedor","Estado"
							
					}
					));
			table.addMouseListener(new MouseAdapter() {
			});
			DefaultTableModel modelo = (DefaultTableModel)table.getModel();
			scrollPane.setViewportView(table);
			
			

			JLabel lblEjemplaresPrestados = new JLabel("");
			lblEjemplaresPrestados.setHorizontalAlignment(SwingConstants.CENTER);
			lblEjemplaresPrestados.setForeground(Color.RED);
			lblEjemplaresPrestados.setBounds(10, 150, 394, 14);
			panel.add(lblEjemplaresPrestados);
			System.out.println("ISBN BUSCAR Ocupados:"+isbn);
			ArrayList<Reserva> lr = ctrolDataBase.ReservaDB.EjemplaresNoDisposiblesReservados(isbn);
			if(lr.isEmpty()){lblEjemplaresPrestados.setText("NO SE ENCUENTRAN EJEMPLARES RESERVADOS");}
			else
			{
				for (int x=0; x<lr.size();x++){
					Reserva r = lr.get(x);
					modelo.addRow(new Object[]{r.getCodEjemplar(),r.getFechaFin(),r.getDni(),"Reservado"});

				}
			}
			ArrayList<Prestamo> le = ctrolDataBase.ReservaDB.EjemplaresNoDisposibles(isbn);
			if(le.isEmpty()){lblEjemplaresPrestados.setText("NO SE ENCUENTRAN EJEMPLARES PRESTADOS");}
			else
			{
				for (int x=0; x<le.size();x++){
					Prestamo e = le.get(x);
					modelo.addRow(new Object[]{e.getNumEjemplarDB(),e.getFechaDevolución(),e.getDniSocio(),"Prestado"});

				}
			}
		}

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.ORANGE));
		panel.setBounds(10, 11, 414, 196);
		getContentPane().add(panel);
		panel.setLayout(null);
		{
			JLabel lblDisponiblesHoy = new JLabel("Disponibles hoy");
			lblDisponiblesHoy.setHorizontalAlignment(SwingConstants.CENTER);
			lblDisponiblesHoy.setBounds(10, 11, 394, 14);
			panel.add(lblDisponiblesHoy);
		}
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 36, 394, 97);
		panel.add(scrollPane);
		scrollPane.setAlignmentX(Component.RIGHT_ALIGNMENT);

		JTable table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"IDEjemplar", "FechaAlta","Cod Ubicación","ISBN"
				}
				));
		DefaultTableModel modelo = (DefaultTableModel)table.getModel();
		scrollPane.setViewportView(table);

	

		JLabel lblNoDisponibles = new JLabel("");
		lblNoDisponibles.setForeground(Color.RED);
		lblNoDisponibles.setHorizontalAlignment(SwingConstants.CENTER);
		lblNoDisponibles.setBounds(10, 171, 378, 14);
		panel.add(lblNoDisponibles);
		ArrayList<Reserva> lr = ctrolDataBase.ReservaDB.EjemplaresNoDisposiblesReservados(isbn);
		ArrayList<Ejemplar> le =ctrolDataBase.PrestamoDB.EjemplaresDisponibles(isbn); 
		for(int y=0;y<lr.size();y++){
			Reserva r =new Reserva();
			r=lr.get(y);
			r.getCodEjemplar();
			for(int x=0; x<le.size();x++){
				Ejemplar e =new Ejemplar();
				e=le.get(x);
				e.getNumInventario();
				System.out.println((e.getNumInventario())+"  "+(r.getCodEjemplar()));
				if(e.getNumInventario()==r.getCodEjemplar()){le.remove(x);}
			}

		}

		System.out.println("ISBN BUSCAR DISPONIBLES:"+isbn);
		if(le.isEmpty()){lblNoDisponibles.setText("NO SE ENCUENTRAN EJEMPLARES DISPONIBLES");}
		else{
			for (int x=0; x<le.size();x++){
				Ejemplar e = le.get(x);
				modelo.addRow(new Object[]{e.getNumInventario(),e.getFechaAlta(),e.getCodUbicaion(),e.getIsbn()});

			}


		}
		table.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
				int fila=table.getSelectedRow();
				Integer valorCelda =  (Integer) table.getValueAt(fila,0);		
				INuevaReserva.textIdEjemplar.setText(String.valueOf(valorCelda));
				
			}
			
		});
		 
		
			
			
	}

	



}
