package ctrolDataBase;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import entity.Socio;

public class LoginDB {

	public static boolean login(String user, String password) {
		boolean acierto = false;
		ConexionDB con = new ConexionDB();
		String query = ("select * from bibliotecario where bibliotecario.nombre='"+user+"' and bibliotecario.psw='"+password+"';"); 
		con.start();
		try{
			System.out.println("paso1");
			Statement st = con.getConexion().createStatement();
			System.out.println(query);
			ResultSet rs = st.executeQuery(query);

			while (rs.next()){
				acierto = true;
			}
			con.close();
			st.close();}
		catch(Exception e){
			System.out.println("Error al obtener lista de datos");
		}
		return acierto;

	}
}
