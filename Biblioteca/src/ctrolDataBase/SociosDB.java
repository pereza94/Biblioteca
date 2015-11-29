package ctrolDataBase;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import entity.Autor;
import entity.Socio;


public class SociosDB {




	public static ArrayList<Socio>  buscarXDNI(int dni) {
		ConexionDB con = new ConexionDB();
		String query = ("select * from socio where socio.dni="+dni+";"); 
		con.start();
		ArrayList <Socio> lista = new ArrayList<>(0);
		try{
			Statement st = con.getConexion().createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()){
				Socio c = new Socio();
				c.setDniSocio( rs.getInt("dni"));
				c.setIdentidad(rs.getString("nombre"));
				c.setDomicilio(rs.getString("direccion"));
				c.setSexo(rs.getString("sexo"));
				c.setTelefono(rs.getString("telefono"));
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



	public static ArrayList<Socio>  buscarXIdentidad(String iden) {
		ConexionDB con = new ConexionDB();
		String query = ("select * from socio where nombre like '"+iden.toUpperCase()+"%'"); 
		con.start();
		ArrayList <Socio> lista = new ArrayList<>(0);
		try{
			Statement st = con.getConexion().createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()){
				Socio c = new Socio();
				c.setDniSocio( rs.getInt("dni"));
				c.setIdentidad(rs.getString("nombre"));
				c.setDomicilio(rs.getString("direccion"));
				c.setSexo(rs.getString("sexo"));
				c.setTelefono(rs.getString("telefono"));
				// System.out.println(c.getDniSocio()+" "+c.getIdentidad());
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







	public static ArrayList<Socio>  sociosTodos() {
		ConexionDB con = new ConexionDB();
		String query = ("select * from socio"); 
		con.start();
		ArrayList <Socio> lista = new ArrayList<>(0);
		try{
			Statement st = con.getConexion().createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()){
				Socio c = new Socio();
				c.setDniSocio( rs.getInt("dni"));
				c.setIdentidad(rs.getString("nombre"));
				c.setDomicilio(rs.getString("direccion"));
				c.setSexo(rs.getString("sexo"));
				c.setTelefono(rs.getString("telefono"));
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


	public static void insertarSocio(int dni,String identidad, String direccion, String telefono, String sexo) {
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
			String sql = "INSERT INTO socio (dni,nombre,direccion,sexo,telefono) "
					+ "VALUES ("+dni+", '"+identidad+"', '"+direccion+"', '"+sexo+"', '"+telefono+"' );";
			stmt.executeUpdate(sql);
			stmt.close();
			c.commit();
			c.close();
		} catch (Exception e) {
			System.err.println( e.getClass().getName()+": "+ e.getMessage() );
			JOptionPane.showMessageDialog(null, e.getMessage()); 
			System.exit(0);
		}
		JOptionPane.showMessageDialog(null,"Socio añadido correctamente");
	}

	
	public static void ModificarSocio(int dni,String identidad, String direccion, String telefono, String sexo) {
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
			String sql = "update socio set nombre='"+identidad+"',direccion='"+direccion+"',sexo='"+sexo+"',telefono="+telefono+"   where dni="+dni+";";
			stmt.executeUpdate(sql);
			stmt.close();
			c.commit();
			c.close();
		} catch (Exception e) {
			System.err.println( e.getClass().getName()+": "+ e.getMessage() );
			JOptionPane.showMessageDialog(null, e.getMessage()); 
			System.exit(0);
		}
		JOptionPane.showMessageDialog(null,"Socio modificado correctamente");
	}
	

}
