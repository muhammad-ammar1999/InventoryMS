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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author muhammadammar
 */
public class Form_ToAddController implements Initializable {
           @FXML
    private Button saveInventory;
           @FXML
    private TextField inventoryId;
         @FXML
    private TextField inventoryName;     
         @FXML
    private TextField inventoryDescription;
         @FXML
    private TextField inventoryQty;
         @FXML
    private TextField inventoryPurchase_price;
         @FXML
    private TextField inventoryRetail_price;
         @FXML
    private TextField inventoryDate;
         @FXML
    private TextField inventoryOutlet;
@FXML 
void SaveInventory(ActionEvent event) {
    
        try {
       Parent root = FXMLLoader.load(getClass().getResource("Form_ToAdd.fxml"));
        Stage stage = new Stage();
            
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
        }
        catch (Exception e) {
        System.out.println(e);
        }
 InventoryItem item_ToAdd = new InventoryItem(Long.parseLong(inventoryId.getText()) , inventoryName.getText(), inventoryDescription.getText(),Long.parseLong(inventoryQty.getText()),Double.parseDouble(inventoryPurchase_price.getText()), Double.parseDouble(inventoryRetail_price.getText()), inventoryDate.getText());
           item_ToAdd.addInventory(item_ToAdd);
     
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
