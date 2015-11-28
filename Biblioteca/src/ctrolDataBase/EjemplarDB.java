package ctrolDataBase;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import entity.Ejemplar;
import entity.Libro;

public class EjemplarDB {

	public static int obtenerNumeroEjemplar(){
		ConexionDB con = new ConexionDB();
		int a=0;
		String query = ("SELECT nextval('sec_codigolibros') ;"); 
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
		/* Statement st = con.createStatement("SELECT last_value FROM forums_id_seq");
			  ResultSet rsgfid = stgfid.executeQuery();
			  rsgfid.next();
			  int forumId = rsgfid.getInt(1);
			  rsgfid.close();
			  stgfid.close()
		 */

		return a;

	}	

	public static void insertarEjemplar(int idinventario,Date fechaAlta,String codUbicacion, String isbn) {
		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager
					.getConnection("jdbc:postgresql://localhost:5432/TP Final",
							"postgres", "ale123");
			c.setAutoCommit(false);
			stmt = c.createStatement();
			String sql = ("INSERT INTO ejemplar2 (idinventario,fechaalta,codUbicacion,isbn) VALUES ( "+idinventario+",'"+fechaAlta+"','"+codUbicacion+"','"+isbn+"');" );
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




	public static String convertirFechaString(Date date){
		return new SimpleDateFormat("yyyy-MM-dd ").format(date);
	}

	public static ArrayList<Libro>  buscarXISBN(String isbn) {
		ConexionDB con = new ConexionDB();
		String query = ("select distinct  l.isbn,l.titulo,l.fpublicacion,l.paginas,l.editorial,a.autor from libro l,autorLibro al,autor a where (l.isbn='"+isbn+"' and al.isbn='"+isbn+"' and a.idautor=al.idautor);"); 
		con.start();
		ArrayList <Libro> lista = new ArrayList<>(0);
		try{
			Statement st = con.getConexion().createStatement();
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


	public static Ejemplar  encontrarEjemplar(int buscado) {
		ConexionDB con = new ConexionDB();
		Ejemplar c = new Ejemplar();
		String query = ("select * from ejemplar2 where idinventario="+buscado+";"); 
		System.out.println(query);
		con.start();
		try{
			Statement st = con.getConexion().createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()){
				c.setNumInventario(rs.getInt("idinventario"));
				c.setIsbn(rs.getString("isbn"));
				c.setCodUbicaion(rs.getString("codubicacion"));
				c.setFechaAlta(rs.getDate("fechaalta"));
			}
			con.close();
			st.close();}
		catch(Exception e){
			System.out.println("Error al obtener lista de datos");
		}
		return c;
	}


	public static Ejemplar  eliminarEjemplar(int buscado) {
		ConexionDB con = new ConexionDB();
		Ejemplar c = new Ejemplar();
		String query = ("delete from ejemplar2 where idinventario="+buscado+";"); 
		System.out.println(query);
		con.start();
		try{
			Statement st = con.getConexion().createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()){
			}
			con.close();
			st.close();}
		catch(Exception e){
			System.out.println("Error al obtener lista de datos");
		}
		return c;
	}



}
