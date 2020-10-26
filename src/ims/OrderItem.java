
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
public class OrderItem {

    Long oder_id;
    String customer_name;
    String order_details ;
    Long order_total;
    Long order_quantity ;
    String order_date;
    Long outletid;
  OrderItem (Long oder_id, String customer_name, String order_details,Long order_total, Long  order_quantity , String order_date,Long outletid) {
        this.oder_id= oder_id;
        this.customer_name = customer_name;
        this. order_details =  order_details;
        this.order_total=order_total;
        this.order_quantity  = order_quantity ;
       this.order_date = order_date;
this.outletid=outletid;    
}
 

    OrderItem(ResultSet rs) throws SQLException, ClassNotFoundException {
        this.oder_id = rs.getLong("id");
        this.customer_name = rs.getString("customer_name");
        this.order_details= rs.getString("order_details");
       this.order_quantity = rs.getLong("quantity");
        this.order_total = rs.getLong("order_total");
        this.order_date = rs.getString("date");
 this.outletid = rs.getLong("outlet_id");
     }

    /**
     * Gets all rows from inventory table
     *
     * @return a list of object from class InventoryItem
     */
    static ObservableList<OrderItem> getAll() {

        // initialize an empty list that contains objects of class OrderItem
        ObservableList<OrderItem> oblist = FXCollections.observableArrayList();
        try {
            // execute query on the database
            ResultSet rs = DbConnection.executeQuery("SELECT * FROM Orders;");

            // iterate over every row that is returned from the executed
            // query above. next() method returns next row untill there are
            // no rows left
            while (rs.next()) {
                // add InventoryItem object in the empty list we created above
                oblist.add(new OrderItem(rs));
            }
        } catch (Exception e) {
            System.err.println(e);
        }

        // returning the list. This list
        // now contains all the rows fetched from the database
        return oblist;
 
    }
    static void printOne(OrderItem item){
            System.out.println(item.customer_name);
    System.out.println(item.oder_id);
    System.out.println(item.order_date);
    System.out.println(item.order_details);
    System.out.println(item.order_quantity);
    System.out.println(item.order_total);
    System.out.println(item.outletid);
    }

     static OrderItem getOne(Long id) throws SQLException, ClassNotFoundException, NoSuchElementException {

        // execute query on the database
        ResultSet rs = DbConnection.executeQuery("SELECT * FROM Orders WHERE id=" + id);
        if (rs.first()) {
            return new OrderItem(rs);
        } else {
            throw new NoSuchElementException();
        }
    } 

    static void updateOne(OrderItem item) throws SQLException, ClassNotFoundException {
        // execute query on the database
        DbConnection.executeUpdate("UPDATE Orders SET custome_rname = ''"+item.customer_name+" where  id =" + item.oder_id);
    }       
    
    static void addOne(OrderItem  item) throws SQLException, ClassNotFoundException {
 // execute query on the database
        DbConnection.executeUpdate(" insert into Orders (customer_name,order_details,order_total,quantity,date, outlet_id)"
        + " values (''"+item.customer_name+",''"+item.order_details+","+item.order_total+","+item.order_quantity+", ''"+item.order_date+","+item.outletid+")");


    }
    
    static void deleteOne(Long id) throws SQLException, ClassNotFoundException {
        DbConnection.executeUpdate("DELETE from Orders WHERE id=" + id );
    }
 
}