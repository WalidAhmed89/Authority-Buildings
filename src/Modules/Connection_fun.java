
package Modules;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import oracle.jdbc.OracleDriver;

public class Connection_fun {
    public static Connection con() throws SQLException{
        DriverManager.registerDriver(new OracleDriver());
        Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","finalProject","project1131");
        return c;
    }
}
