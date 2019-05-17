package Laborator9.PA;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
    private static final String USER = "Luigi";
    private static final String PASSWORD = "luigi";
    private static Connection connection = null;
    private Database() {

    }
    public static Connection getConnection() {
        if (connection == null) {
            createConnection();
        }
        return connection;
    }

    public static void createConnection(){

//       DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            connection= DriverManager.getConnection(URL,USER,PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static void commit(){

        try {
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void closeConnection(){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
