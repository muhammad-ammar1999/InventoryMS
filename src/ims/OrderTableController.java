
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ims;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import ims.InventoryItem;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Background;
import java.sql.Connection;
import ims.DbConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author bilal
 */
public class OrderTableController implements Initializable {

    @FXML
    private TableView<OrderItem> ordertable;

    @FXML
    private TableColumn<OrderItem, String> oder_id;
    @FXML
    private TableColumn<OrderItem, String> customer_name;
    @FXML
    private TableColumn<OrderItem, String> order_details;
    @FXML
    private TableColumn<OrderItem, String> order_total;
    
    @FXML
    private TableColumn<OrderItem, String> order_quantity;
  
    @FXML
    private TableColumn<OrderItem, String> order_date;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

OrderItem itemToAdd = new OrderItem(new Long(1),"ammar","momsy stage 5", new Long(1100),new Long(11), "2021",new Long(2));  
       try {
            
           OrderItem.addOne(itemToAdd);
              System.out.println("ammar");
    

            ObservableList<OrderItem> oblist = OrderItem.getAll();

            oder_id.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().oder_id.toString()));
            customer_name.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().customer_name));
            order_details.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().order_details));
            order_total.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().order_total.toString()));
            order_quantity.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().order_quantity.toString()));
            order_date.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().order_date));
            ordertable.setItems(oblist);
        } catch (SQLException ex) {
            Logger.getLogger(InventoryTableController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InventoryTableController.class.getName()).log(Level.SEVERE, null, ex);
        }
         catch (Exception e) {
            System.out.println(e);
        }
    }
}

    