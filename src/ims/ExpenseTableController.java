
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
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 *
 * @author bilal
 */
public class ExpenseTableController implements Initializable {

    @FXML
    private TableView<Expense> expensetable;

    @FXML
    private TableColumn<Expense, String> expenseid;
    @FXML
    private TableColumn<Expense, String> expenseDetails;
    @FXML
    private TableColumn<Expense, String> expensePrice;
    
    @FXML
    private TableColumn<Expense, String> expensDate;
  
    @FXML
    private TableColumn<Expense, String> Expenseoutletid;
@FXML
    private Button AddExpense;    
  @FXML
    private Button UpdateExpense;    
  @FXML
    private Button DeleteExpense;    
    
@FXML
    private TextField ExpenseId;
         @FXML
    private TextField ExpenseDetails;     
         @FXML
    private TextField ExpensePrice;
         @FXML
    private TextField Expensedate;
         @FXML
    private TextField ExpenseOutlet;
      
    @Override
    public void initialize(URL url, ResourceBundle rb) {

Expense itemToAdd = new Expense(new Long(1),"ammar", 1100.0, "2021",new Long(2));  
       try {
            
//          Expense.addOne(ItemToAdd);
//              System.out.println("ammar");
//    
  
 
            ObservableList<Expense> oblist = Expense.getAll();

            expenseid.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().expenseId.toString()));
            expenseDetails.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().expenseDetails));
            expensePrice.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().expensePrice.toString()));
            expensDate.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().date));
            expenseid.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().outletid.toString()));
            
            expensetable.setItems(oblist);
//        } catch (SQLException ex) {
//            Logger.getLogger(InventoryTableController.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(InventoryTableController.class.getName()).log(Level.SEVERE, null, ex);
        }
         catch (Exception e) {
            System.out.println(e);
        }
    }
}

    