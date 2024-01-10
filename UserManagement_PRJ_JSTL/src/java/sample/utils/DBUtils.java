/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sample.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author truon
 */
public class DBUtils {
    private static final String DB_NAME = "UserManagement";
    private static final String DB_USER_NAME = "sa";
    private static final String DB_PASSWORD = "12345";
    public static Connection getConnectionV1() throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://localhost:1433;databasename="+DB_NAME;
        conn = DriverManager.getConnection(url, DB_USER_NAME, DB_PASSWORD);
        return conn;
    }
    
    public static Connection getConnection() throws ClassNotFoundException, SQLException, NamingException {
        Connection conn = null;
        Context context = new InitialContext();
        Context end = (Context) context.lookup("java:comp/env");
        DataSource ds = (DataSource) end.lookup("DBCon");
        conn = ds.getConnection();
        return conn;
    }
    
}
