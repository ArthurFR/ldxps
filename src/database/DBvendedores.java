package database;

import model.Clientes;
import model.Vendedores;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

public class DBvendedores {
	static Statement stmt = null;
	static String query;
	
	public static ArrayList<Vendedores> pegarVendedores() throws java.text.ParseException
	{
		Vendedores vendedor;
		ArrayList<Vendedores> vendedores = new ArrayList<>();
		ResultSet queryResult = null;

		try {
			DBconnection.connectDatabase("", "");
			stmt = DBconnection.connection.createStatement();

			query = "SELECT * FROM vendedores";

			queryResult = stmt.executeQuery(query);

			while (queryResult.next()) {
				
				//float f = Float.parseFloat(queryResult.getString("dslim"));
				int f = Integer.parseInt(queryResult.getString("cdtab"));
				
					DateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
					java.util.Date date = formatter.parse(queryResult.getString("dtnasc"));
					java.sql.Date sqlDate = new java.sql.Date(date.getTime());
					
					vendedor = new Vendedores(queryResult.getString("cdvend"),queryResult.getString("dsnome"),f,sqlDate);
					vendedores.add(vendedor);

			}

			stmt.close();

		} catch (SQLException e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}

		System.out.println("Produto encontrado");
		
		DBconnection.closeConnection();
		return vendedores;
	}
	public static Vendedores pegarVendedor(String cdvend) throws java.text.ParseException
	{
		Vendedores vendedor = null;
		ResultSet queryResult = null;

		try {
			DBconnection.connectDatabase("", "");
			stmt = DBconnection.connection.createStatement();

			query = "SELECT * FROM vendedores WHERE cdvend = '"+ cdvend +"';";

			queryResult = stmt.executeQuery(query);

			while (queryResult.next()) {
				
				//float f = Float.parseFloat(queryResult.getString("dslim"));
				int f = Integer.parseInt(queryResult.getString("cdtab"));
				
					DateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
					java.util.Date date = formatter.parse(queryResult.getString("dtnasc"));
					java.sql.Date sqlDate = new java.sql.Date(date.getTime());
					
					vendedor = new Vendedores(queryResult.getString("cdvend"),queryResult.getString("dsnome"),f,sqlDate);

			}

			stmt.close();

		} catch (SQLException e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}

		
		
		DBconnection.closeConnection();
		return vendedor;
	}
	public static void insereVendedor(String cdvend, String dsnome,String cdtab,String dtnasc)
	{
		try {
			DBconnection.connectDatabase("", "");
			stmt = DBconnection.connection.createStatement();

			query = "INSERT INTO vendedores (cdvend, dsnome, cdtab, dtnasc)"
					+ "VALUES "
					+ "(" 
					+ cdvend + ",'"
					+ dsnome + "',"
					+ cdtab + ",'"
					+ dtnasc + "');";

			stmt.executeUpdate(query);

			stmt.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}

		
		DBconnection.closeConnection();
	}
	public static void updateVendedor(String cdvend, String dsnome,String cdtab,String dtnasc)
	{
		try {
			DBconnection.connectDatabase("", "");
			stmt = DBconnection.connection.createStatement();
			
			
			query = "UPDATE vendedores set "
					+ "dsnome='"+ dsnome + "',"
					+ "cdtab="+ cdtab + ","
					+ "dtnasc='"+ dtnasc + "'"
					+ " WHERE cdvend ='"+cdvend+"';";

			stmt.executeUpdate(query);
			

			stmt.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}

		
		DBconnection.closeConnection();
	}
	public static Clientes excluiVendedor(String cdvend)
	{
		Clientes cliente = null;
		

		try {
			DBconnection.connectDatabase("", "");
			stmt = DBconnection.connection.createStatement();

			query = "DELETE FROM vendedores WHERE cdvend = '"+ cdvend +"';" ;
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
