/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ims;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 *
 * @author muhammadammar
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

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try {
      
            ObservableList<Expense> oblist = Expense.getAll();

            expenseid.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().expenseId.toString()));
            System.out.println(expenseid);
           expenseDetails.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().expenseDetails));
            expensePrice.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().expensePrice.toString()));
            expensDate.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().date));
            expensetable.setItems(oblist);
    
        
        } catch (Exception e) {
            System.out.println(e);
        }

    }
    
}
