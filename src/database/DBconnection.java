package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class DBconnection {
	static Connection connection = null;
    static Statement stmt = null;
    
    
    public static void connectDatabase(String senha,String user)
    {
            System.out.println("-------- MySQL Connection Testing ------------\n");

            String driver = "com.mysql.jdbc.Driver";
            //String user = "ldxps";
            //String senha = "ldxps";
            String url = "jdbc:mysql://localhost:3306/ldxps";

            try {
                    Class.forName(driver);

                    connection = (Connection) DriverManager.getConnection(url, "ldxps","ldxps");
                    System.out.println("Deu certo ");

                    //JOptionPane.showMessageDialog(null,"Conexão realizada com Sucesso!");

            } catch (ClassNotFoundException | SQLException e) {
                    System.err.print(e.getMessage());
                    //JOptionPane.showMessageDialog(null,"Usuário ou Senha Inválido");
            }

    }
    public static void closeConnection()
    {
            try {
                    connection.close();
            } catch (SQLException e) {
                    System.err.println(e.getClass().getName() + ": " + e.getMessage());
                    System.exit(0);
            }

            System.out.println("Conexão encerrada");
    }
}

