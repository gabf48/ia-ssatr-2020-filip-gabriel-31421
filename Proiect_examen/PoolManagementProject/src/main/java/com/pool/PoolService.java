package com.pool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.DecimalFormat;

/**
 *
 * @author Gabriel
 */
public class PoolService {

    private final DBAccess db;
    
    private static final DecimalFormat df2 = new DecimalFormat("#.##");
    private final Connection conn = DriverManager.getConnection("jdbc:derby://127.0.0.1:1527/dbname;create=false;user=gabriel;pass=gabriel");

    public PoolService() throws ClassNotFoundException, SQLException {
        db = new DBAccess();
    }
  
    public String customerManagement(String name) throws SQLException {
        CustomersEntity c = db.findCustomerByName(name);

        if (c == null) {
            CustomersEntity x = new CustomersEntity(name, System.currentTimeMillis());
            db.entryPool(x);
            return x.getNume() + " is in the pool.";
        } else {   
            double price = calculatePrice(c.getTimpIntrare());
            profit(price);
            db.deleteCustomer(name);
            totalProfit(price);
            return c.getNume() + " came out of the pool and has to pay " + df2.format(price) + " RON.";
        }
    }

    private double calculatePrice(long startCalcul) {      
        long crt = System.currentTimeMillis();
        return (double) ((crt - startCalcul) / 1000) * 0.1;
    }

    public void profit(double ron) throws SQLException {
            ProfitEntity x = new ProfitEntity(ron);
            db.recordProfit(x);   
    }
    
    public void totalProfit(double ron) throws SQLException {
            TotalProfitEntity x = new TotalProfitEntity(ron);
            db.recordTotalProfit(x);   
    }

    public static void main(String[] args) throws Exception {
        PoolService p = new PoolService();

        System.out.println(p.customerManagement("Dinu"));
        Thread.sleep(9000);
        System.out.println(p.customerManagement("Dinu"));
        p.totalProfit(12);

    }

}
