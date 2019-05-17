package Laborator9.PA;

import java.sql.*;

public class PersonController {

    public void create(String name) throws SQLException {
        Connection con = Database.getConnection();
        Integer id = 1;
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select max(id) from PERSONS");
        id =rs.next()? rs.getInt(1)+1 : id ;
        try (PreparedStatement pstmt = con.prepareStatement("insert into PERSONS (id, name) values (?,?)")) {
            pstmt.setInt(1, id);
            pstmt.setString(2,name);
            pstmt.executeUpdate();
        }
    }
    public Integer findByName(String name) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select id from PERSONS where name like '%" + name + "%'")) {
            return rs.next() ? rs.getInt(1) : null;
        }

    }
    public String findById(int id) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select NAME from PERSONS where ID like '" + id + "'")) {
            return rs.next() ? rs.getString("name"): "Nothing found!";
        }
    }

}
