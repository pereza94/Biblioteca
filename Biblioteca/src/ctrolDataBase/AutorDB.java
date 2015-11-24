package ctrolDataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import entity.Autor;
import entity.Libro;
import entity.Socio;

public class AutorDB {

	/**
	 * @wbp.parser.entryPoint
	 */
	public static void insertarAutor(String identidad) {
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
	         String sql = "INSERT INTO autor (autor) "
	               + "VALUES ('"+identidad+"' );";
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
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public static Autor buscarAutor(String iden) {
		Autor c = new Autor(); 
		ConexionDB con = new ConexionDB();
		 String query = ("select * from autor where autor.autor='"+iden.toUpperCase()+"';"); 
		 con.start();
		 try{
		 Statement st = con.getConexion().createStatement();
		 ResultSet rs = st.executeQuery(query);
		 while (rs.next()){
	     
	     c.setIdAutor( rs.getInt("idautor"));
	     c.setIdentidad(rs.getString("autor"));
		 
		// System.out.println(c.getDniSocio()+" "+c.getIdentidad());
		 }
		 con.close();
		 st.close();}
		 catch(Exception e){
		 System.out.println("Error al obtener lista de datos");
		 }
		 return c;
	}
	
	
	public static ArrayList<Autor>  buscarXPatron(String iden) {
		ConexionDB con = new ConexionDB();
		 String query = ("select * from autor where autor like '"+iden.toUpperCase()+"%'"); 
		 con.start();
		 ArrayList <Autor> lista = new ArrayList<>(0);
		 try{
		Statement st = con.getConexion().createStatement();
		System.out.println(query);
		 ResultSet rs = st.executeQuery(query);
		 while (rs.next()){
		Autor c = new Autor();
	     c.setIdAutor( rs.getInt("idautor"));
	     c.setIdentidad(rs.getString("autor"));
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
	
	
	public static ArrayList<Autor>  buscarXIdAutor(int id) {
		ConexionDB con = new ConexionDB();
		String query = ("select * from autor where autor.idautor="+id+";"); 
		con.start();
		 ArrayList <Autor> lista = new ArrayList<>(0);
		 try{
		 Statement st = con.getConexion().createStatement();
		 ResultSet rs = st.executeQuery(query);
		 while (rs.next()){
			 Autor c = new Autor();
		     c.setIdAutor( rs.getInt("idautor"));
		     c.setIdentidad(rs.getString("autor"));
			 lista.add(c);
			 //System.out.println(c.getDniSocio()+" "+c.getIdentidad());
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
	
	
	
	public static ArrayList<Libro>  buscarLibroDeUnAutor(String a) {
		ConexionDB con = new ConexionDB();
		String query = ("select distinct a.autor,l.isbn,l.titulo, l.fpublicacion,l.editorial from autor a, autorLibro al, libro l where(al.idautor='"+a+"' and a.idautor=al.idautor and al.isbn=l.isbn);"); 
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
	
	
}
