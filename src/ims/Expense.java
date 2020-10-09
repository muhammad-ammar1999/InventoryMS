/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ims;

import java.sql.Connection;
import java.sql.ResultSet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author muhammadammar
 */
public class Expense {
    
    Long expenseId;
    String expenseDetails;
     Double expensePrice;
    String date;

    Expense(Long id,  String expenseDetails,  Double expensePrice , String date) {
        this.expenseId = id;
        this.expenseDetails = expenseDetails;
      this.expensePrice = expensePrice;
        this.date = date;
    }
    
    /**
     * Gets all rows from inventory table
     * @return a list of object from class InventoryItem
     */
    static ObservableList<Expense> getAll() {
        
        // initialize an empty list that contains objects of class InventoryItem
        ObservableList<Expense> oblist = FXCollections.observableArrayList();
        try {
            // connect with the database
            Connection c = (Connection) DbConnection.connect();
            String query = "SELECT * FROM inventory ";
            
            // execute query on the database
            ResultSet rs = c.createStatement().executeQuery(query);
    System.out.println(rs);
        System.out.println("ammar");
        
            // iterate over every row that is returned from the executed
            // query above. next() method returns next row untill there are
            // no rows left
            while (rs.next()) {
                // add InventoryItem object in the empty list we created above
                oblist.add(new Expense(
                        rs.getLong("id"),
                        rs.getString("expenseDetails"),
                        rs.getDouble("expensePrice"),
                      
                        rs.getString("date"))
                );
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
        // returning the list. This list
        // now contains all the rows fetched from the database
        return oblist;

    }

    
}
