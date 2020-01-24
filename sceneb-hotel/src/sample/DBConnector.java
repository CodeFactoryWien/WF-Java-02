package sample;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnector {
    public static Connection getConnection()throws SQLException{
        Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/hoteldb" +
                "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
        return connection;
    }
}
