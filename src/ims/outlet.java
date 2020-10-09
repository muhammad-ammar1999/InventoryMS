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
public class outlet {

    static ObservableList<outlet> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    Long id;
    String name;
    String description;
    Long qty;
    Double purchasing_price;
    Double retail_price;
    String date;

    outlet(Long id, String name, String description, Long qty, Double purchasing_price, Double retail_price, String date) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.qty = qty;
        this.purchasing_price = purchasing_price;
        this.retail_price = retail_price;
        this.date = date;
    }
  public void addInventory(InventoryItem itemToAdd) {
  String query = " insert into inventory (id, name, description, qty,purchasing_price,retail_price,date,outletid)"
        + " values (itemToAdd.id, itemToAdd.name, itemToAdd.description, itemToAdd.qty, itemToAdd.purchasing_price, itemToAdd.retail_price, itemToAdd.date)";

    }   
    /**
     * Gets all rows from inventory table
     * @return a list of object from class InventoryItem
     */
    static ObservableList<outlet> getAll() {
        
        // initialize an empty list that contains objects of class InventoryItem
        ObservableList<outlet> oblist = FXCollections.observableArrayList();
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
                oblist.add(new outlet(
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
