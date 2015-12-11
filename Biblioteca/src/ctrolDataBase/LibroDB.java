package ctrolDataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import entity.Libro;
import entity.Socio;

public class LibroDB {

	public static void insertarLibro(String isbn,String titulo, Date fpublicaion , int numpaginas, String editorial) {
		System.out.println("paso 1");
		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager
					.getConnection("jdbc:postgresql://localhost:5432/TP Final",
							"postgres", "ale123");
			c.setAutoCommit(false);
			System.out.println("Opened database successfully");

			stmt = c.createStatement();
			String sql = "INSERT INTO libro (isbn,titulo,fpublicacion,paginas,editorial) "
					+ "VALUES ("+isbn+", '"+titulo+"', '"+fpublicaion+"', "+numpaginas+", '"+editorial+"' );";
			stmt.executeUpdate(sql);
			stmt.close();
			c.commit();
			c.close();
		} catch (Exception e) {
			System.err.println( e.getClass().getName()+": "+ e.getMessage() );
			JOptionPane.showMessageDialog(null, e.getMessage()); 
			System.exit(0);
		}
		JOptionPane.showMessageDialog(null,"Libro añadido correctamente");
	}

	public static void insertarLibroAutor(String isbn,int idAutor) {
		System.out.println("paso 1"); 
		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager
					.getConnection("jdbc:postgresql://localhost:5432/TP Final",
							"postgres", "ale123");
			c.setAutoCommit(false);
			System.out.println("Opened database successfully");

			stmt = c.createStatement();
			String sql = "INSERT INTO autorLibro (idautor,isbn) VALUES ( '"+idAutor+"','"+isbn+"' );";
			System.out.println(sql);
			stmt.executeUpdate(sql);
			System.out.println("paso 2");
			stmt.close();
			c.commit();
			c.close();
			System.out.println("paso 3");
		} catch (Exception e) {
			System.err.println( e.getClass().getName()+": "+ e.getMessage() );
			JOptionPane.showMessageDialog(null, e.getMessage()); 
			System.exit(0);
		}

	}






	public static ArrayList<Libro>  buscarXISBN(String isbn) {
		ConexionDB con = new ConexionDB();
		String query = ("select distinct  l.isbn,l.titulo,l.fpublicacion,l.paginas,l.editorial,a.autor from libro l,autorLibro al,autor a where (l.isbn='"+isbn+"' and al.isbn='"+isbn+"' and a.idautor=al.idautor);"); 
		con.start();
		ArrayList <Libro> lista = new ArrayList<>(0);
		try{
			Statement st = con.getConexion().createStatement();
			System.out.println(query);
			ResultSet rs = st.executeQuery(query);
			while (rs.next()){
				Libro c = new Libro();
				c.setIsbn( rs.getString("isbn"));
				c.setAnio(rs.getDate("fpublicacion"));
				c.setTitulo(rs.getString("titulo"));
				c.setEditorial(rs.getString("editorial"));
				c.setAutor(rs.getString("autor"));
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









	public static ArrayList<Libro>  buscarXISBNSAutor(String isbn) {
		ConexionDB con = new ConexionDB();
		String query = ("select distinct  l.isbn,l.titulo,l.fpublicacion,l.paginas,l.editorial from libro l where (l.isbn='"+isbn+"');"); 
		con.start();
		ArrayList <Libro> lista = new ArrayList<>(0);
		try{
			Statement st = con.getConexion().createStatement();
			System.out.println(query);
			ResultSet rs = st.executeQuery(query);
			while (rs.next()){
				Libro c = new Libro();
				c.setIsbn( rs.getString("isbn"));
				c.setAnio(rs.getDate("fpublicacion"));
				c.setTitulo(rs.getString("titulo"));
				c.setEditorial(rs.getString("editorial"));
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






	public static ArrayList<Libro>  buscarXTitulo(String s) {
		ConexionDB con = new ConexionDB();
		String query = ("(select Distinct l.isbn,l.titulo,l.fpublicacion,l.paginas,l.editorial,a.autor from libro l, autorLibro al,autor a where (l.titulo like '"+s+"%' and al.isbn=l.isbn and al.idautor=a.idautor));"); 
		con.start();
		ArrayList <Libro> lista = new ArrayList<>(0);
		try{
			Statement st = con.getConexion().createStatement();
			System.out.println(query);
			ResultSet rs = st.executeQuery(query);
			while (rs.next()){
				Libro c = new Libro();
				c.setIsbn( rs.getString("isbn"));
				c.setAnio(rs.getDate("fpublicacion"));
				c.setTitulo(rs.getString("titulo"));
				c.setEditorial(rs.getString("editorial"));
				c.setAutor(rs.getString("autor"));
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

	public static ArrayList<Libro>  buscarXTituloSinAutor(String s) {
		ConexionDB con = new ConexionDB();
		String query = ("(select Distinct l.isbn,l.titulo,l.fpublicacion,l.paginas,l.editorial from libro l, autorLibro al,autor a where (l.titulo like '"+s+"%' ));"); 
		con.start();
		ArrayList <Libro> lista = new ArrayList<>(0);
		try{
			Statement st = con.getConexion().createStatement();
			System.out.println(query);
			ResultSet rs = st.executeQuery(query);
			while (rs.next()){
				Libro c = new Libro();
				c.setIsbn( rs.getString("isbn"));
				c.setAnio(rs.getDate("fpublicacion"));
				c.setTitulo(rs.getString("titulo"));
				c.setEditorial(rs.getString("editorial"));
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
	
	public static void ModificarLibro(String isbn, String titulo,String editorial, Date fechaPublicaion ) {
		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager
					.getConnection("jdbc:postgresql://localhost:5432/TP Final",
							"postgres", "ale123");
			c.setAutoCommit(false);
			System.out.println("Opened database successfully");

			stmt = c.createStatement();
			String sql = "update libro set titulo='"+titulo+"',fpublicacion='"+fechaPublicaion+"',editorial='"+editorial+"'   where isbn='"+isbn+"';";
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
		JOptionPane.showMessageDialog(null,"Libro modificado correctamente");
	}
	
	
	public static void EliminarAutorLibro(String isbn ) {
		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager
					.getConnection("jdbc:postgresql://localhost:5432/TP Final",
							"postgres", "ale123");
			c.setAutoCommit(false);
			System.out.println("Opened database successfully");

			stmt = c.createStatement();
			String sql = "delete from  autorlibro where isbn='"+isbn+"';";
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
