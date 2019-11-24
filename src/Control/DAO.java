package Control;

import java.sql.*;

public class DAO {
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/quanlygiaidaucovua";

    private static final String USER = "root";
    private static final String PASS = "12345678";

    protected static Connection con;//declare the connection

    //constructor
    public DAO(){
        if(con == null){
            try {
                Class.forName(JDBC_DRIVER);
                con = DriverManager.getConnection (DB_URL, USER, PASS);
            }catch(Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
//        DAO.getInstance();
    }
}