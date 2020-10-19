package ims;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.NoSuchElementException;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author bilal
 */
public class SalesReport {

  
    Long id;
    String date;
    Double totalSale;
    Double totalPurchase;
   Double monthlyExpense;
   Double totalExpense;
   Double investment;
    Double stocks;
     Double netIncome;
      Double profitRatio;
   Double account;
 Long outletid; 
  
    public SalesReport(Long id, String date, Double totalSale, Double totalPurchase, Double monthlyExpense, Double totalExpense, Double investment, Double stocks, Double netIncome, Double profitRatio, Double account, Long outletid) {
        this.id = id;
        this.date = date;
        this.totalSale = totalSale;
        this.totalPurchase = totalPurchase;
        this.monthlyExpense = monthlyExpense;
        this.totalExpense = totalExpense;
        this.investment = investment;
        this.stocks = stocks;
        this.netIncome = netIncome;
        this.profitRatio = profitRatio;
        this.account = account;
        this.outletid = outletid;
    }
 
    SalesReport(ResultSet rs) throws SQLException, ClassNotFoundException {
        this.id = rs.getLong("id");
        this.date   = rs.getString("date");
        this.totalSale = rs.getDouble("totalsale");
        this.totalPurchase = rs.getDouble("totalpurchasing");
       this.monthlyExpense =rs.getDouble("monthlyexpenses");
        this.totalExpense =rs.getDouble("totalexpenses");
        this.investment =rs.getDouble("investment");       
        this.stocks =rs.getDouble("stocks");
        this.netIncome = rs.getDouble("netincome"); 
        this.profitRatio=rs.getDouble("profitratio");
        this.account=rs.getDouble("account");
        this.outletid = rs.getLong("outletid");

    }

    /**
     * Gets all rows from inventory table
     *
     * @return a list of object from class InventoryItem
     */
    static ObservableList<SalesReport> getAll() {

        // initialize an empty list that contains objects of class SalesReport
        ObservableList<SalesReport> oblist = FXCollections.observableArrayList();
        try {
            // execute query on the database
            ResultSet rs = DbConnection.executeQuery("SELECT * FROM SalesReport;");

            // iterate over every row that is returned from the executed
            // query above. next() method returns next row untill there are
            // no rows left
            while (rs.next()) {
                // add SalesReport object in the empty list we created above
                oblist.add(new SalesReport(rs));
            }
        } catch (Exception e) {
            System.err.println(e);
        }

        // returning the list. This list
        // now contains all the rows fetched from the database
        return oblist;

    }

 
    static SalesReport getOne(Long id) throws SQLException, ClassNotFoundException, NoSuchElementException {

        // execute query on the database
        ResultSet rs = DbConnection.executeQuery("SELECT * FROM SalesReport WHERE id=" + id);
        if (rs.first()) {
            return new SalesReport(rs);
        } else {
            throw new NoSuchElementException();
        }
    } 

    static void updateOne(SalesReport item) throws SQLException, ClassNotFoundException {
        DbConnection.executeUpdate("UPDATE SalesReport SET netincome = "+item.netIncome+" where  id =" + item.id);
    }       
    
    static void addOne(SalesReport item) throws SQLException, ClassNotFoundException {
          DbConnection.executeUpdate(" insert into SalesReport (date,totalsale,totalpurchasing,monthlyexpenses,totalexpenses,investment,stocks,netincome,profitratio,account,outletid)"
        + " values ('10-10-20', 1100, 1100, 1100, 1100, 110, 110, 1100, 1100, 1100, 3)");
 
    }
    
    static void deleteOne(Long id) throws SQLException, ClassNotFoundException {
        DbConnection.executeUpdate("DELETE from SalesReport WHERE id=" + id );
    }

}