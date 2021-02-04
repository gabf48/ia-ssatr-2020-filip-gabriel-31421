package com.pool;

import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;

public class DBAccess {

    private final Connection conn;


    public DBAccess() throws ClassNotFoundException, SQLException {
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        conn = DriverManager.getConnection("jdbc:derby://localhost:1527/dbname;create=false;user=gabriel;pass=gabriel");
    }

    public void entryPool(CustomersEntity e) throws SQLException {
        try (Statement s = conn.createStatement()) {
            s.executeUpdate("INSERT INTO CLIENTI VALUES ('" + e.getNume() + "'," + e.getTimpIntrare() + ")");
        }
    }

    public void recordProfit(ProfitEntity e) throws SQLException {
        try (Statement s = conn.createStatement()) {
            s.executeUpdate("INSERT INTO PROFIT VALUES " + e.getRon());
        }
    }
    
     public void recordTotalProfit(TotalProfitEntity e) throws SQLException {
        try (Statement s = conn.createStatement()) {
            s.executeUpdate("INSERT INTO TOTALPROFIT VALUES " + e.getRon());
        }
    }

    public CustomersEntity findCustomerByName(String name) throws SQLException {
        Statement s = conn.createStatement();
        ResultSet rs = s.executeQuery("SELECT * FROM  CLIENTI WHERE NUME ='" + name + "'");
        if (rs.next()) {
            return new CustomersEntity(rs.getString("nume"), rs.getLong("timpIntrare"));
        } else {
            return null;
        }
    }

    public void deleteCustomer(String name) throws SQLException {
        Statement s = conn.createStatement();
        s.executeUpdate("DELETE FROM CLIENTI WHERE NUME ='" + name + "'");
    }

    public String displayCustomers() throws SQLException {
        Statement s = conn.createStatement();
        ResultSet rs = s.executeQuery("SELECT * FROM CLIENTI");
        String result = "";
        while (rs.next()) {
            result += rs.getString("nume") + "\n";
        }
        return result;
    }

    public int countCustomers() throws SQLException {
        Statement s = conn.createStatement();
        int c = 0;
        ResultSet rs = s.executeQuery("SELECT count(nume) FROM  CLIENTI");
        if (rs.next()) {
            c = rs.getInt(1);
        }
        return c;
    }

    public double displayProfit() throws SQLException {
        Statement s = conn.createStatement();
        double suma = 0;
        ResultSet rs = s.executeQuery("SELECT SUM(ron) FROM  PROFIT");
        if (rs.next()) {
            suma = rs.getDouble(1);
        }
        return suma;
    }
    
    public double displayTotalProfit() throws SQLException {
        Statement s = conn.createStatement();
        double suma = 0;
        ResultSet rs = s.executeQuery("SELECT SUM(RON) FROM  TOTALPROFIT");
        if (rs.next()) {
            suma = rs.getDouble(1);
        }
        return suma;
    }

    public void clearAllProfit() throws SQLException {
        Statement s = conn.createStatement();
        s.executeUpdate("DELETE FROM PROFIT");
    }
    
      public static void main(String[] args) throws Exception {
        DBAccess db = new DBAccess();
        db.displayTotalProfit();
      }
}
