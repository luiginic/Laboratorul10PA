package Laborator9.PA;

import java.sql.*;

public class MovieController {

    public void create(String movieName,int directorId) throws SQLException {
        Connection con = Database.getConnection();
        Integer id = 1;
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select max(ID) from MOVIES ");
        id =rs.next()? rs.getInt(1)+1 : id ;
        try (PreparedStatement pstmt = con.prepareStatement("insert into MOVIES (id, name, DIRECTOR_ID) values (?,?,?)")) {
            pstmt.setInt(1, id);
            pstmt.setString(2, movieName);
            pstmt.setInt(3,directorId);
            pstmt.executeUpdate();
        }
    }
}
