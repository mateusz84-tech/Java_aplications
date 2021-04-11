package DBUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class DBUtil {

    private static final String url = "jdbc:mysql://localhost:3306/db_mk?serverTimezone=UTC&useSSL=false&characterEncoding=utf8";
    private static final String user = "root";
    //private static final String password = "coderslab";
    public static void main(String[] args) throws SQLException {

        System.out.println(conn());
    }

    public static Connection conn() throws SQLException{
        Scanner input = new Scanner(System.in);
        System.out.print("Podaj hasło: ");
        String password = input.next();
        return DriverManager.getConnection(url,user,password);
    }

}
