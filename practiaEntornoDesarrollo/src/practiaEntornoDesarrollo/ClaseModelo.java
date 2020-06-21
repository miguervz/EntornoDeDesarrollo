package practiaEntornoDesarrollo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ClaseModelo
{

	// Conexión a la base de datos
	static String driver = "com.mysql.jdbc.Driver";
	static String url = "jdbc:mysql://localhost:3306/empresa?useSSL=false";
	static String usuario = "root";
	static String clave = "Studium2019;";
	static Connection connection = null;
	static String sentencia = "";
	static Statement statement = null;
	static ResultSet rs = null;

}