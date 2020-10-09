
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
import javafx.beans.property.SimpleStringProperty;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author muhammadammar
 */
public class OrderTableController implements Initializable {
    
    

    @FXML
    private TableView<OrderItem> Ordertable;

    @FXML
    private TableColumn<OrderItem, String> Orderid;
    @FXML
    private TableColumn<OrderItem, String> customerName;
    @FXML
    private TableColumn<OrderItem, String> orderDetails;
    @FXML
    private TableColumn<OrderItem, String> orderTotal;
    @FXML
    private TableColumn<OrderItem, String> Orderdqty;
    @FXML
    private TableColumn<OrderItem, String> Orderdate;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try {
      
            ObservableList<OrderItem> oblist = OrderItem.getAll();

            Orderid.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().orderId.toString()));
            customerName.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().customerName));
            orderDetails.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().orderDetails));
            orderTotal.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().orderTotal.toString()));
            Orderdqty.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().qty.toString()));
            Orderdate.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().date));
            Ordertable.setItems(oblist);
    
        
        } catch (Exception e) {
            System.out.println(e);
        }

    }}