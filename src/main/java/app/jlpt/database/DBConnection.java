package app.jlpt.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    public static Connection getConnection() throws Exception {
        String protocol = "jdbc:derby:";
        return DriverManager.getConnection(protocol + "derbyDB;create=true;");
    }

//    public static void shutDown() {
//        try {
//            DriverManager.getConnection("jdbc:derby:MyDbTest;shutdown=true");
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//        }
//    }

    public static void main(String[] args) {
        try {
            getConnection();
            System.out.println("Connected");
        } catch (Exception e) {
            // TODO Auto-generated catch block
        }
    }
}
