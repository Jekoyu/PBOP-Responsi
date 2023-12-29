package Connection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
public class Conn {
    public static Connection getKoneksi(){
        Connection koneksi = null;
        try{
            String url = "jdbc:mysql://localhost/PBOP-Responsi";
            String user = "root";
            String password = "";
            koneksi = DriverManager.getConnection(url, user, password);
            System.out.println("Koneksi sukses!");
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return koneksi;
    }
}
