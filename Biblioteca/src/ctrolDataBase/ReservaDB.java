package ctrolDataBase;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import entity.Prestamo;
import entity.Reserva;

public class ReservaDB {

	public static ArrayList<Prestamo>  EjemplaresNoDisposibles(String isbn ) {
		ConexionDB con = new ConexionDB();
		String query = ("select distinct  p.numiden, p.fechalimite,p.dni from prestamo p, ejemplar2 ej, libro l where( l.isbn='"+isbn+"' and ej.isbn='"+isbn+"' and ej.idinventario=p.numiden and (fechadevolucion is null));"); 
		con.start();
		System.out.println(query);
		ArrayList <Prestamo> lista = new ArrayList<>(0);
		System.out.println("Paso 1");
		try{
			Statement st = con.getConexion().createStatement();
			ResultSet rs = st.executeQuery(query);
			System.out.println("Paso 2");
			while (rs.next()){
				Prestamo c = new Prestamo();
				System.out.println("Paso 3");
				c.setFechaDevolución(rs.getDate("fechalimite"));
				System.out.println("Paso 4");
				c.setDniSocio(rs.getInt("dni"));
				System.out.println("Paso 5");
				c.setNumEjemplarDB(rs.getInt("numiden"));
				lista.add(c);
			}
			con.close();
			st.close();}
		catch(Exception e){
			lista=null;
			System.out.println("Error al obtener lista de datos");
		}
		return lista;
	}

	public static ArrayList<Reserva>  EjemplaresNoDisposiblesReservados(String isbn ) {
		ConexionDB con = new ConexionDB();
		String query = ("select distinct  r.numidenejemplar,r.fechalimite,r.dni from prestamo p, ejemplar2 ej, libro l,reserva r where( l.isbn='"+isbn+"' and ej.isbn='"+isbn+"' and ej.idinventario=r.numidenejemplar and (r.fechalimite > now()));"); 
		con.start();
		System.out.println(query);
		ArrayList <Reserva> lista = new ArrayList<>(0);
		System.out.println("Paso 1");
		try{
			Statement st = con.getConexion().createStatement();
			ResultSet rs = st.executeQuery(query);
			System.out.println("Paso 2");
			while (rs.next()){
				Reserva c = new Reserva();
				System.out.println("Paso 3");
				c.setFechaFin(rs.getDate("fechalimite"));
				System.out.println("Paso 4");
				c.setDni(rs.getInt("dni"));
				System.out.println("Paso 5");
				c.setCodEjemplar(rs.getInt("numidenejemplar"));
				lista.add(c);
			}
			con.close();
			st.close();}
		catch(Exception e){
			lista=null;
			System.out.println("Error al obtener lista de datos");
		}
		return lista;
	}

	public static void insertarReserva(Date fechaInicio,Date fechaFin, int dni, int numEjemplar) {
		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager
					.getConnection("jdbc:postgresql://localhost:5432/TP Final",
							"postgres", "ale123");
			c.setAutoCommit(false);
			stmt = c.createStatement();
			String sql = ("INSERT INTO reserva (fechainicio,fechalimite,dni,numidenEJEMPLAR) VALUES ( '"+fechaInicio+"','"+fechaFin+"',"+dni+","+numEjemplar+");" );
			System.out.println(sql);
			stmt.executeUpdate(sql);
			stmt.close();
			c.commit();
			c.close();
		} catch (Exception e) {
			System.err.println( e.getClass().getName()+": "+ e.getMessage() );
			JOptionPane.showMessageDialog(null, e.getMessage()); 
			System.exit(0);
		}

	}
	
	
	
	public static ArrayList<Reserva>  reservasActivas() {
		ConexionDB con = new ConexionDB();
		String query = ("select distinct * from reserva where (fechalimite > now());"); 
		con.start();
		ArrayList <Reserva> lista = new ArrayList<>(0);
		try{
			Statement st = con.getConexion().createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()){
				Reserva c = new Reserva();
				c.setFechaFin(rs.getDate("fechalimite"));
				c.setDni(rs.getInt("dni"));
				c.setCodEjemplar(rs.getInt("numidenejemplar"));
				c.setFechaRegistro(rs.getDate("fechaInicio"));
				lista.add(c);
			}
			con.close();
			st.close();}
		catch(Exception e){
			lista=null;
			System.out.println("Error al obtener lista de datos");
		}
		return lista;
	}
	
	
	public static void eliminarReserva(java.util.Date fehaInicio,java.util.Date fehaFin, int dni, int numEjemplar) {
		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager
					.getConnection("jdbc:postgresql://localhost:5432/TP Final",
							"postgres", "ale123");
			c.setAutoCommit(false);
			stmt = c.createStatement();
			String sql = ("delete from reserva where (fechainicio='"+fehaInicio+"' and fechalimite='"+fehaFin+"' and dni="+dni+")" );
			System.out.println(sql);
			stmt.executeUpdate(sql);
			stmt.close();
			c.commit();
			c.close();
		} catch (Exception e) {
			System.err.println( e.getClass().getName()+": "+ e.getMessage() );
			JOptionPane.showMessageDialog(null, e.getMessage()); 
			System.exit(0);
		}

	}


}
