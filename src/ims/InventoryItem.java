
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
public class InventoryItem  {

    Long id;
    String name;
    String description;
    Long qty;
    Double purchasing_price;
    Double retail_price;
    String date;
 Long outletid;
    InventoryItem(Long id, String name, String description, Long qty, Double purchasing_price, Double retail_price, String date,Long outletid) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.qty = qty;
        this.purchasing_price = purchasing_price;
        this.retail_price = retail_price;
        this.date = date;
this.outletid=outletid;
    }
 

    InventoryItem(ResultSet rs) throws SQLException, ClassNotFoundException {
        this.id = rs.getLong("id");
        this.name = rs.getString("name");
        this.description = rs.getString("description");
        this.qty = rs.getLong("qty");
        this.purchasing_price = rs.getDouble("purchasing_price");
        this.retail_price = rs.getDouble("purchasing_price");
        this.date = rs.getString("date");
       this.outletid = rs.getLong("outletid");

    }

    /**
     * Gets all rows from inventory table
     *
     * @return a list of object from class InventoryItem
     */
 
    static ObservableList<InventoryItem> getAll() {

        // initialize an empty list that contains objects of class InventoryItem
        ObservableList<InventoryItem> oblist = FXCollections.observableArrayList();
        try {
            // execute query on the database
            ResultSet rs = DbConnection.executeQuery("SELECT * FROM inventory;");

            // iterate over every row that is returned from the executed
            // query above. next() method returns next row untill there are
            // no rows left
            while (rs.next()) {
                // add InventoryItem object in the empty list we created above
                oblist.add(new InventoryItem(rs));
            }
        } catch (Exception e) {
            System.err.println(e);
        }

        // returning the list. This list
        // now contains all the rows fetched from the database
        return oblist;

    }

    static InventoryItem getOne(Long id) throws SQLException, ClassNotFoundException, NoSuchElementException {

        // execute query on the database
        ResultSet rs = DbConnection.executeQuery("SELECT * FROM inventory WHERE id=" + id);
        if (rs.first()) {
            return new InventoryItem(rs);
        } else {
            throw new NoSuchElementException();
        }
    } 

    static void updateOne(InventoryItem item) throws SQLException, ClassNotFoundException {
        DbConnection.executeUpdate("UPDATE inventory SET name = 'momsy' where  id =" + item.id);
    }       
    
    static void addOne(InventoryItem item) throws SQLException, ClassNotFoundException {
        DbConnection.executeUpdate(" insert into inventory (name,description,qty,purchasing_price,retail_price,date, outletId)"
        + " values ('canbaby','stage', 6,100.0,200.0, '2001',1)");

    }
    
    static void deleteOne(Long id) throws SQLException, ClassNotFoundException {
        DbConnection.executeUpdate("DELETE from inventory WHERE id=" + id );
    }
 
}