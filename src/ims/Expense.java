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
        this.expenseDetails= rs.getString("expensedetails");
        this.expensePrice = rs.getDouble("price");
        this.date = rs.getString("date");
 this.outletid = rs.getLong("outletid");
    }

    /**
     * Gets all rows from inventory table
     *
     * @return a list of object from class InventoryItem
     */
    static ObservableList<Expense> getAll() {
 
        // initialize an empty list that contains objects of class Expense
        ObservableList<Expense> oblist = FXCollections.observableArrayList();
        try {
            // execute query on the database
            ResultSet rs = DbConnection.executeQuery("SELECT * FROM Expense ;");

            // iterate over every row that is returned from the executed
            // query above. next() method returns next row untill there are
            // no rows left
            while (rs.next()) {
                // add Expense object in the empty list we created above
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
             // execute query on the database
        DbConnection.executeUpdate("UPDATE Expense SET price ="+ item.expensePrice+ " where  id =" + item.expenseId);
    }       
    
    static void addOne(Expense  item) throws SQLException, ClassNotFoundException {
      // execute query on the database
System.out.println(" insert into Expense (expensedetails,price ,date , outletid )"
        + " values (''"+ item.expenseDetails+","+item.expensePrice+","+item.date+","+item.outletid+")");

               DbConnection.executeUpdate(" insert into Expense (expensedetails,price ,date , outletid )"
        + " values ('{0}'"+ item.expenseDetails+","+item.expensePrice+","+item.date+","+item.outletid+")");

       
    } 
    
    static void deleteOne(Long id) throws SQLException, ClassNotFoundException {
              // execute query on the database
        DbConnection.executeUpdate("DELETE from Expense WHERE id=" + id );
    }

}