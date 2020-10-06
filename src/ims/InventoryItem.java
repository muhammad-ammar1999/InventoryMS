/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ims;

import java.sql.Connection;
import java.sql.ResultSet;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author bilal
 */
public class InventoryItem {

    Long id;
    String name;
    String description;
    Long qty;
    Double purchasing_price;
    Double retail_price;
    String date;

    InventoryItem(Long id, String name, String description, Long qty, Double purchasing_price, Double retail_price, String date) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.qty = qty;
        this.purchasing_price = purchasing_price;
        this.retail_price = retail_price;
        this.date = date;
    }
    
    /**
     * Gets all rows from inventory table
     * @return a list of object from class InventoryItem
     */
    static ObservableList<InventoryItem> getAll() {
        
        // initialize an empty list that contains objects of class InventoryItem
        ObservableList<InventoryItem> oblist = FXCollections.observableArrayList();
        try {
            // connect with the database
            Connection c = (Connection) DbConnection.connect();
            String query = "SELECT * FROM inventory";
            
            // execute query on the database
            ResultSet rs = c.createStatement().executeQuery(query);

            // iterate over every row that is returned from the executed
            // query above. next() method returns next row untill there are
            // no rows left
            while (rs.next()) {
                // add InventoryItem object in the empty list we created above
                oblist.add(new InventoryItem(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getLong("qty"),
                        rs.getDouble("purchasing_price"),
                        rs.getDouble("retail_price"),
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
