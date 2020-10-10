/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class Expense {
    
    Long expenseId;
    String expenseDetails;
     Double expensePrice;
    String date;
Long outletid;
    Expense(Long id,  String expenseDetails,  Double expensePrice , String date,Long outletid) {
        this.expenseId = id;
        this.expenseDetails = expenseDetails;
      this.expensePrice = expensePrice;
        this.date = date;
    this.outletid=outletid;    
    }
 

       Expense(ResultSet rs) throws SQLException, ClassNotFoundException {
        this.expenseId = rs.getLong("id");
        this.expenseDetails= rs.getString("expenseetails");
        this.expensePrice = rs.getDouble("expenseprice");
        this.date = rs.getString("date");
 this.outletid = rs.getLong("outletid");
    }

    /**
     * Gets all rows from inventory table
     *
     * @return a list of object from class InventoryItem
     */
    static ObservableList<Expense> getAll() {

        // initialize an empty list that contains objects of class InventoryItem
        ObservableList<Expense> oblist = FXCollections.observableArrayList();
        try {
            // execute query on the database
            ResultSet rs = DbConnection.executeQuery("SELECT * FROM Expense ;");

            // iterate over every row that is returned from the executed
            // query above. next() method returns next row untill there are
            // no rows left
            while (rs.next()) {
                // add InventoryItem object in the empty list we created above
                oblist.add(new Expense(rs));
            }
        } catch (Exception e) {
            System.err.println(e);
        }

        // returning the list. This list
        // now contains all the rows fetched from the database
        return oblist;

    }

    static Expense getOne(Long id) throws SQLException, ClassNotFoundException, NoSuchElementException {

        // execute query on the database
        ResultSet rs = DbConnection.executeQuery("SELECT * FROM Expense WHERE id=" + id);
        if (rs.first()) {
            return new Expense(rs);
        } else {
            throw new NoSuchElementException();
        }
    }

    static void updateOne(Expense item) throws SQLException, ClassNotFoundException {
   //     DbConnection.executeUpdate("UPDATE inventory " + " SET name='" + item.customer_name + " SET description='" + item.order_details+ " SET qty=" + item.qty+ " SET purchasing_price=" + item.purchasing_price+ " SET retail_price=" + item.retail_price+ " SET date='" + item.date+ " SET outletid=" + item. outletid+"WHERE id="+ item.id);
    }
     
    static void addOne(Expense item) throws SQLException, ClassNotFoundException {
 DbConnection.executeUpdate(" insert into Orders (customername,orderdetails,ordertotal,quantity,date, outletId)"
        + " values ('ammar','molfix5', 1000,1, '2001',1)");
    }
    
    static void deleteOne(Long id) throws SQLException, ClassNotFoundException {
       // DbConnection.executeQuery("DELETE inventory WHERE id="+  );
    }

}