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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author muhammadammar
 */ 
public class outlet {


    Long id;
    String name;
    String address;
   
    outlet(Long id, String name, String address)
    {   this.id = id;
        this.name = name;
        this.address =address;
       }
 
       
  outlet(ResultSet rs) throws SQLException, ClassNotFoundException {
        this.id = rs.getLong("id");
      //  this.name = rs.getString("name");
        this.address= rs.getString("address");
       }
    /**
     * Gets all rows from inventory table
     * @return a list of object from class InventoryItem
     */
    static ObservableList<outlet> getAll() {

        // initialize an empty list that contains objects of class InventoryItem
        ObservableList<outlet> oblist = FXCollections.observableArrayList();
        try {
            // execute query on the database
            ResultSet rs = DbConnection.executeQuery("SELECT * FROM outlet;");

            // iterate over every row that is returned from the executed
            // query above. next() method returns next row untill there are
            // no rows left
            while (rs.next()) {
                // add InventoryItem object in the empty list we created above
                oblist.add(new outlet(rs));
            }
        } catch (Exception e) {
            System.err.println(e);
        }
           // returning the list. This list
        // now contains all the rows fetched from the database
        return oblist;
    }
        static outlet getOne(Long id) throws SQLException, ClassNotFoundException, NoSuchElementException {

        // execute query on the database
        ResultSet rs = DbConnection.executeQuery("SELECT * FROM outlet WHERE id=" + id);
        if (rs.first()) {
            return new outlet(rs);
        } else {
            throw new NoSuchElementException();
        } 
    } 

    static void updateOne(outlet item) throws SQLException, ClassNotFoundException {
        DbConnection.executeUpdate("UPDATE outlet SET address = malir15 where  id =" + item.id);
    }       
    
            
   static void addOne(outlet item) throws SQLException, ClassNotFoundException {
 DbConnection.executeUpdate(" insert into outlet (address)"
        + " values ('nagan13d')");
    }
    
    static void deleteOne(Long id) throws SQLException, ClassNotFoundException {
        DbConnection.executeUpdate("DELETE from outlet WHERE id=" + id );
    }
}