package database;
import model.Clientes;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
public class DBclientes {
	static Connection connection = null;
    static Statement stmt = null;
	static String query;
	
	
	public static ArrayList<Clientes> pegarClientes()
	{
		Clientes cliente;
		ArrayList<Clientes> clientes = new ArrayList<>();
		ResultSet queryResult = null;

		try {
			DBconnection.connectDatabase("", "");
			stmt = DBconnection.connection.createStatement();

			query = "SELECT * FROM clientes";

			queryResult = stmt.executeQuery(query);

			while (queryResult.next()) {
				
				float f = Float.parseFloat(queryResult.getString("dslim"));
				cliente = new Clientes(queryResult.getString("cdcl"),queryResult.getString("dsnome"),queryResult.getString("idtipo"),queryResult.getString("cdvend"),f);
				clientes.add(cliente);
               
			}

			stmt.close();

		} catch (SQLException e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}

		System.out.println("Produto encontrado");
		
		DBconnection.closeConnection();
		return clientes;
	}
	
	public static ArrayList<Clientes> pegarClientes(String cdvend)
	{
		Clientes cliente;
		ArrayList<Clientes> clientes = new ArrayList<>();
		ResultSet queryResult = null;

		try {
			DBconnection.connectDatabase("", "");
			stmt = DBconnection.connection.createStatement();

			query = "SELECT * FROM clientes WHERE cdvend = '"+ cdvend +"';" ;
			
			queryResult = stmt.executeQuery(query);

			while (queryResult.next()) {
				
				float f = Float.parseFloat(queryResult.getString("dslim"));
				cliente = new Clientes(queryResult.getString("cdcl"),queryResult.getString("dsnome"),queryResult.getString("idtipo"),queryResult.getString("cdvend"),f);
				clientes.add(cliente);
               
			}

			stmt.close();

		} catch (SQLException e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}

		System.out.println("Produto encontrado");
		
		DBconnection.closeConnection();
		return clientes;
	}
	public static Clientes pegarCliente(String cdcl)
	{
		Clientes cliente = null;
		ResultSet queryResult = null;

		try {
			DBconnection.connectDatabase("", "");
			stmt = DBconnection.connection.createStatement();

			query = "SELECT * FROM clientes WHERE cdcl = '"+ cdcl +"';" ;
			
			queryResult = stmt.executeQuery(query);

			while (queryResult.next()) {
				
				float f = Float.parseFloat(queryResult.getString("dslim"));
				cliente = new Clientes(queryResult.getString("cdcl"),queryResult.getString("dsnome"),queryResult.getString("idtipo"),queryResult.getString("cdvend"),f);
	               
			}

			stmt.close();

		} catch (SQLException e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		
		DBconnection.closeConnection();
		return cliente;
	}
	
	public static void insereCliente(String cdcl, String dsnome,String idtipo,String cdvend,String limite)
	{
		try {
			DBconnection.connectDatabase("", "");
			stmt = DBconnection.connection.createStatement();

			query = "INSERT INTO clientes (cdcl, dsnome, idtipo, cdvend,dslim)"
					+ "VALUES "
					+ "(" 
					+ cdcl + ",'"
					+ dsnome + "','"
					+ idtipo + "','"
					+ cdvend + "',"
					+ limite + ");";

			stmt.executeUpdate(query);

			stmt.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}

		System.out.println("Produto inserido com sucesso");
		DBconnection.closeConnection();
	}
	
	public static void updateCliente(String cdcl, String dsnome,String idtipo,String cdvend,String limite)
	{
		try {
			DBconnection.connectDatabase("", "");
			stmt = DBconnection.connection.createStatement();
			System.out.println(cdvend);
			
			query = "UPDATE clientes set "
					+ "dsnome='"+ dsnome + "',"
					+ "idtipo='"+ idtipo + "',"
					+ "cdvend='"+ cdvend + "',"
					+ "dslim="+ limite + " "
					+ "WHERE cdcl ='"+cdcl+"';";

			stmt.executeUpdate(query);

			stmt.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}

		System.out.println("Produto editado com sucesso");
		DBconnection.closeConnection();
	}
	public static void updateCliente(String cdcl,String cdvend)
	{
		try {
			DBconnection.connectDatabase("", "");
			stmt = DBconnection.connection.createStatement();
			System.out.println(cdvend);
			
			query = "UPDATE clientes set "
					+ "cdvend='"+ cdvend + "'"
					+ "WHERE cdcl ='"+cdcl+"';";

			stmt.executeUpdate(query);

			stmt.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}

		System.out.println("Produto editado com sucesso");
		DBconnection.closeConnection();
	}
	
	public static Clientes excluiCliente(String cdcl)
	{
		Clientes cliente = null;
		

		try {
			DBconnection.connectDatabase("", "");
			stmt = DBconnection.connection.createStatement();

			query = "DELETE FROM clientes WHERE cdcl = '"+ cdcl +"';" ;
			stmt.executeUpdate(query);
			stmt.close();

		} catch (SQLException e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}

		
		DBconnection.closeConnection();
		return cliente;
	}
}
