package ctrolDataBase;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import entity.Ejemplar;
import entity.Prestamo;

public class PrestamoDB {


	public static void nuevoPrestamo(Date fechaprestamo, int nuniden,Date fechalimite,Date fechadevolucion,int dni ) {
		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TP Final",
					"postgres", "ale123");
			c.setAutoCommit(false);
			stmt = c.createStatement();
			String sql = ("INSERT INTO prestamo (fechaprestamo,numiden,fechalimite,fechadevolucion,dni) VALUES ( '"+fechaprestamo+"',"+nuniden+",'"+fechalimite+"',"+fechadevolucion+","+dni+");" );
			System.out.println(sql);
			stmt.executeUpdate(sql);
			stmt.close();
			c.commit();
			c.close();
			JOptionPane.showMessageDialog(null, "Prestamo almacenado");
		} catch (Exception e) {
			System.err.println( e.getClass().getName()+": "+ e.getMessage() );
			JOptionPane.showMessageDialog(null, e.getMessage()); 
		}

	}


	public static void RegistarDevolución(Date fechaHoy, int codEje) {
		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TP Final",
					"postgres", "ale123");
			c.setAutoCommit(false);
			stmt = c.createStatement();
			String sql = ("update prestamo set fechaDevolucion='"+fechaHoy+"'  where (numiden="+codEje+" and (fechadevolucion is null));" );
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


	public static Prestamo VerificarFechas(Date fechaHoy, int codEje ) {
		Prestamo c = new entity.Prestamo();
		ConexionDB con = new ConexionDB();
		String query = ("select * from prestamo   where (numiden="+codEje+" and  fechaDevolucion='"+fechaHoy+"');" );
		con.start();
		System.out.println(query);
		ArrayList <Ejemplar> lista = new ArrayList<>(0);
		try{
			Statement st = con.getConexion().createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()){

				c.setFechaLimite(rs.getDate("fechalimite"));
			}
			con.close();
			st.close();}
		catch(Exception e){
			c=null;
			System.out.println("Error al obtener lista de datos");
		}
		return c;
	}


	public static ArrayList<Ejemplar>  EjemplaresDisponibles(String isbn ) {
		ConexionDB con = new ConexionDB();
		String query = ("select distinct  e.idinventario,e.codUbicacion,e.isbn,e.fechaalta from ejemplar2 e, prestamo p where((e.isbn='"+isbn+"'and p.numiden=e.idinventario and (p.fechadevolucion is not null))or(e.isbn='"+isbn+"'and e.idinventario != p.numiden and ((select count(*) from prestamo p where(p.numiden=e.idinventario))=0)));"); 
		con.start();
		System.out.println(query);
		ArrayList <Ejemplar> lista = new ArrayList<>(0);
		try{
			Statement st = con.getConexion().createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()){
				Ejemplar c = new Ejemplar();
				c.setNumInventario( rs.getInt("idinventario"));
				c.setCodUbicaion(rs.getString("codubicacion"));
				c.setFechaAlta(rs.getDate("fechaalta"));
				c.setIsbn(rs.getString("isbn"));
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

	

	public static ArrayList<Prestamo>  PrestamosVigentes() {
		ConexionDB con = new ConexionDB();
		String query = ("select distinct * from prestamo where fechadevolucion is  null;"); 
		con.start();
		System.out.println(query);
		ArrayList <Prestamo> lista = new ArrayList<>(0);
		try{
			Statement st = con.getConexion().createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()){
				Prestamo c = new Prestamo();
				c.setDniSocio(rs.getInt("dni"));
				c.setNumEjemplarDB(rs.getInt("numiden"));
				c.setFechaPrestamo(rs.getDate("fechaprestamo"));
				c.setFechaLimite(rs.getDate("fechalimite"));
				
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

}
