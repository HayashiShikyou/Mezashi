package app.jlpt.database.controller;

import app.jlpt.database.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class InputDB {
    public static void getSql(String sql) throws Exception {
        Connection con = DBConnection.getConnection();
        PreparedStatement psst = con.prepareStatement(sql);
        psst.executeUpdate();
        System.out.println("Changed");
        psst.close();
        con.close();
    }

    public static void saveBook(String intInput) throws Exception {
        int bkId = 1;
        Connection con = DBConnection.getConnection();
        String sql = "select max(bk_ID) from book";

        PreparedStatement psst = con.prepareStatement(sql);
        ResultSet rs = psst.executeQuery();
        if (rs.next())
            bkId = rs.getInt(1) + 1;

        sql = "INSERT INTO book VALUES(?, ?)";
        psst = con.prepareStatement(sql);
        psst.setInt(1, bkId);
        psst.setString(2, intInput);
        psst.executeUpdate();
        System.out.println("Added" + bkId);
        psst.close();
        con.close();
    }

    public static String getAllBooks() throws Exception {
        String sql = "SELECT * FROM book";
        List<String> ls = new ArrayList<>();
        Connection con = DBConnection.getConnection();
        PreparedStatement psst = con.prepareStatement(sql);
        ResultSet rs = psst.executeQuery();
        while (rs.next()) {
            ls.add(rs.getString(1));
            ls.add(rs.getString(2));
//				System.out.println(rs.getInt(1));
//				System.out.println(rs.getString(2));
        }
        psst.close();
        con.close();
        return ls.toString();
    }

    public static void main(String[] args) {
        String sql = "CREATE TABLE book(bk_id int, name varchar(40), PRIMARY KEY (bk_id))";
//        sql = "Delete From book";
        String sql1 = "water";
        try {
//            getSql(sql);
//            saveBook(sql1);
            getAllBooks();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
