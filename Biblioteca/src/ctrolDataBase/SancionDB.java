package ctrolDataBase;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import entity.Sancion;

public class SancionDB {

	public static int obtenerNumeroSancion(){
		ConexionDB con = new ConexionDB();
		int a=0;
		String query = ("SELECT nextval('sancion_idsancion_seq') ;"); 
		con.start();
		try{

			Statement st = con.getConexion().createStatement();
			ResultSet rs = st.executeQuery(query);
			rs.next();
			a= rs.getInt(1);
		}
		catch(Exception e){
			a=0;
			System.out.println("Error al obtener lista de datos");
		}

		con.close();


		return a;

	}


	public static int sancionesAnteriores(int dni){
		ConexionDB con = new ConexionDB();
		int a = 0;
		String query = ("(select count(*) from sancion s where s.dni ="+dni+");"); 
		System.out.println(query);
		con.start();
		try{

			Statement st = con.getConexion().createStatement();
			ResultSet rs = st.executeQuery(query);
			rs.next();
			a= rs.getInt(1);
		}
		catch(Exception e){
			a=0;
			System.out.println("Error al obtener lista de datos");
		}

		con.close();


		return a;
	}
	
	public static int SancionVigente(int dni){
		ConexionDB con = new ConexionDB();
		int a = 0;
		String query = ("(select count(*) from sancion s where s.dni ="+dni+" and fechafin>now());"); 
		System.out.println(query);
		con.start();
		try{

			Statement st = con.getConexion().createStatement();
			ResultSet rs = st.executeQuery(query);
			rs.next();
			a= rs.getInt(1);
		}
		catch(Exception e){
			a=0;
			System.out.println("Error al obtener lista de datos");
		}

		con.close();


		return a;
	}





	public static void insertarSancion(int idsancion, int dni ,Date fechaInicio,Date fechaFin) {
		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager
					.getConnection("jdbc:postgresql://localhost:5432/TP Final",
							"postgres", "ale123");
			c.setAutoCommit(false);
			stmt = c.createStatement();
			String sql = ("INSERT INTO sancion (idsancion,dni,fechainicio,fechafin) VALUES ( "+idsancion+","+dni+",'"+fechaInicio+"','"+fechaFin+"');" );
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
	
	public static ArrayList<Sancion>  SancionesVigentes() {
		ConexionDB con = new ConexionDB();
		String query = ("(select distinct s.dni, s.nombre,sa.fechainicio,sa.fechafin from socio s, sancion sa where(sa.fechafin > now() and sa.dni=s.dni))order by sa.fechainicio asc;"); 
		con.start();
		ArrayList <Sancion> lista = new ArrayList<>(0);
		try{
			Statement st = con.getConexion().createStatement();
			System.out.println(query);
			ResultSet rs = st.executeQuery(query);
			while (rs.next()){
				Sancion s = new Sancion();
				s.setDni(rs.getInt("dni"));
				s.setFechaInicio(rs.getDate("fechainicio"));
				s.setFechaFin(rs.getDate("fechafin"));
				lista.add(s);
			}
			con.close();
			st.close();}
		catch(Exception e){
			lista=null;
			System.out.println("Error al obtener lista de datos");
		}
		return lista;
	}
	
	public static ArrayList<Sancion> HistorialSanciones() {
		ConexionDB con = new ConexionDB();
		String query = ("(select distinct * from  sancion sa )order by sa.fechainicio asc;"); 
		con.start();
		ArrayList <Sancion> lista = new ArrayList<>(0);
		try{
			Statement st = con.getConexion().createStatement();
			System.out.println(query);
			ResultSet rs = st.executeQuery(query);
			while (rs.next()){
				Sancion s = new Sancion();
				s.setDni(rs.getInt("dni"));
				s.setFechaInicio(rs.getDate("fechainicio"));
				s.setFechaFin(rs.getDate("fechafin"));
				lista.add(s);
			}
			con.close();
			st.close();}
		catch(Exception e){
			lista=null;
			System.out.println("Error al obtener lista de datos");
		}
		return lista;
	}
	
	public static void eliminarSancion(int dni, java.util.Date fechaInicio, java.util.Date fechaFin) {
		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager
					.getConnection("jdbc:postgresql://localhost:5432/TP Final",
							"postgres", "ale123");
			c.setAutoCommit(false);
			stmt = c.createStatement();
			String sql = ("delete from sancion where (fechainicio='"+fechaInicio+"' and fechafin='"+fechaFin+"' and dni="+dni+")" );
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
