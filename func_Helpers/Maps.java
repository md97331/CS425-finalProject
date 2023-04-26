package func_Helpers;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class Maps {
    public static String SQLPASSWORD = "First5210";
    public Map<Integer, String> initTablesFromFirstAdminMenu() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Passenger");
        map.put(2, "Flight");
        map.put(3, "Connection");
        map.put(4, "FlightClass");
        map.put(5, "Ticket");
        map.put(6, "Payment");
        return map;
    }

    public Map<String, Object> initMapTable(String selectedTable) throws ClassNotFoundException, SQLException {
        Map<String, Object> map = new HashMap<>();
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/airline_database?serverTimezone=UTC&characterEncoding=utf-8&useSSL=false","root",SQLPASSWORD);
        Statement stmt=con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from " + selectedTable);
        ResultSetMetaData rsMetaData = rs.getMetaData();
        int count = rsMetaData.getColumnCount();

        for(int i=1; i<= count ; i++){
            map.put(rsMetaData.getColumnName(i), null);
        }
        rs.close();
        stmt.close();
        con.close();
        return map;
    }
}