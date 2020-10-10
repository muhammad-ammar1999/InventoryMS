
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
public class InventoryTableController implements Initializable {

    @FXML
    private TableView<InventoryItem> table;

    @FXML
    private TableColumn<InventoryItem, String> id;
    @FXML
    private TableColumn<InventoryItem, String> name;
    @FXML
    private TableColumn<InventoryItem, String> description;
    @FXML
    private TableColumn<InventoryItem, String> qty;
    @FXML
    private TableColumn<InventoryItem, String> purchasing_price;
    @FXML
    private TableColumn<InventoryItem, String> retail_price;
    @FXML
    private TableColumn<InventoryItem, String> date;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

InventoryItem itemToAdd = new InventoryItem(new Long(1),"momsy","stage4", new Long(11),100.0,200.0, "2021",new Long(2));  
 try {
            
InventoryItem.addOne(itemToAdd);
    InventoryItem.updateOne(itemToAdd);
 System.out.println("ammar");
    
           ObservableList<InventoryItem> oblist = InventoryItem.getAll();

            id.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().id.toString()));
            name.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().name));
            description.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().description));
            qty.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().qty.toString()));
            purchasing_price.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().purchasing_price.toString()));
            retail_price.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().retail_price.toString()));
            date.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().date));
           table.setItems(oblist);
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
