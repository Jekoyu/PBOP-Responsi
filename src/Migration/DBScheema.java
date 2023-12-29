package Migration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

class DBSchema {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost/PBOP-Responsi";
        String user = "root";
        String password = "";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement()) {

            String createUserTable = "CREATE TABLE IF NOT EXISTS users ("
                    + "user_id INT PRIMARY KEY AUTO_INCREMENT,"
                    + "username VARCHAR(50) NOT NULL UNIQUE,"
                    + "password VARCHAR(100) NOT NULL,"
                    + "name VARCHAR(100) NOT NULL,"
                    + "role VARCHAR(20) NOT NULL"
                    + ")";
            statement.executeUpdate(createUserTable);
            String createTasksTable = "CREATE TABLE IF NOT EXISTS tasks ("
                    +"task_id INT PRIMARY KEY AUTO_INCREMENT,"
                    + "matkul VARCHAR(50),"
                    + "user_id INT,"
                    + "deskripsi VARCHAR(255) NOT NULL,"
                    + "tenggat DATE,"
                    + "prioritas VARCHAR(10),"
                    + "status VARCHAR(20) DEFAULT 'To-Do',"
                    + "FOREIGN KEY (user_id) REFERENCES users(user_id)"
                    + ")";
            statement.executeUpdate(createTasksTable);
            System.out.println("Updated!!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
