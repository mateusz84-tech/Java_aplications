package DBUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class DBUtil {

    private static final String url = "jdbc:mysql://localhost:3306/db_name?serverTimezone=UTC&useSSL=false&characterEncoding=utf8";
    private static final String user = "root";
    public static void main(String[] args) throws SQLException {

        System.out.println(conn("db_mk"));
    }

    public static Connection conn(String dbName) throws SQLException{
        Scanner input = new Scanner(System.in);
        System.out.print("Podaj hasło: ");
        String password = input.next();
        return DriverManager.getConnection(url.replace("db_name",dbName),user,password);
    }

}
