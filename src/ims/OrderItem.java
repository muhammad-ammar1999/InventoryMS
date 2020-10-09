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
 public class OrderItem {

    Long orderId;
    String customerName;
    String orderDetails;
    String orderTotal;
    Long qty;
    String date;

    OrderItem(Long id, String customerName, String orderDetails, String orderTotal, Long qty, String date) {
        this.orderId = id;
        this.customerName = customerName;
        this.orderDetails = orderDetails;
      this.orderTotal = orderTotal;
        this.qty = qty;
        this.date = date;
    }
    
    /**
     * Gets all rows from inventory table
     * @return a list of object from class InventoryItem
     */
    static ObservableList<OrderItem> getAll() {
        
        // initialize an empty list that contains objects of class InventoryItem
        ObservableList<OrderItem> oblist = FXCollections.observableArrayList();
        try {
            // connect with the database
            Connection c = (Connection) DbConnection.connect();
            String query = "SELECT * FROM Orders";
            
            // execute query on the database
            ResultSet rs = c.createStatement().executeQuery(query);

            // iterate over every row that is returned from the executed
            // query above. next() method returns next row untill there are
            // no rows left
            while (rs.next()) {
                // add InventoryItem object in the empty list we created above
                oblist.add(new OrderItem(
                        rs.getLong("id"),
                        rs.getString("customerName"),
                        rs.getString("orderDetails"),
                        rs.getString("OrderTotal"),
                       rs.getLong("qty"),
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