
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
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


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
 @FXML
    private TableColumn<InventoryItem, String> outletid;
    @FXML 
    private Button AddInventory;    
  @FXML
    private Button UpdateInventory;    
  @FXML
    private Button DeleteInventory;    
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

         @FXML
    private TableView<OrderItem> Ordertable;

    @FXML
    private TableColumn<OrderItem, String> Orderid;
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
@FXML
    private TableColumn<OrderItem, String> orderoutletid;
@FXML
    private Button AddOrder;    
  @FXML
    private Button UpdateOrder;    
  @FXML
    private Button DeleteOrder;    
  @FXML
    private TextField orderId;
         @FXML
    private TextField customername;     
         @FXML
    private TextField orderdetails;
         @FXML
    private TextField ordertotal;
         @FXML
    private TextField orderquantity;
         @FXML
    private TextField orderdate;
         @FXML
    private TextField orderOutlet;

         @FXML
    private Button addOutlet;    
    
@FXML
    private TextField outletId;
         @FXML
    private TextField outletAddress;     
  @FXML
    private ChoiceBox SelectOutlet;    
  
         @FXML
    private TableView<SalesReport> salestable;
    @FXML
    private TableColumn<SalesReport, String> sales_id;
    @FXML
    private TableColumn<SalesReport, String> sales_date;
    @FXML
    private TableColumn<SalesReport, String> total_sales;
    @FXML
    private TableColumn<SalesReport, String> total_purchases;
    @FXML
    private TableColumn<SalesReport, String> monthly_expenses;
  
    @FXML
    private TableColumn<SalesReport, String> total_expenses;
@FXML
    private TableColumn<SalesReport, String> investment;
@FXML
    private TableColumn<SalesReport, String> stock;
@FXML
    private TableColumn<SalesReport, String> net_income;
@FXML
    private TableColumn<SalesReport, String> profit_ratio;
@FXML
    private TableColumn<SalesReport, String> account;
@FXML
    private TableColumn<SalesReport, String> salesreport_Outlet;
@FXML
    private Button addSales_report;    
  @FXML
    private Button updateSales_report;    
  @FXML
    private Button DeleteSales_report;    
@FXML
    private TextField salesid;
         @FXML
    private TextField salesdate;     
         @FXML
    private TextField totalsales;
         @FXML
    private TextField totalpurchases;
         @FXML
    private TextField monthlyexpenses;
         @FXML
    private TextField totalexpenses;
         @FXML
    private TextField invest;
  @FXML
    private TextField stocks;
    @FXML
    private TextField netincome;
      @FXML
    private TextField profitratio;
        @FXML
    private TextField accounts;
        @FXML
    private TextField salesreportOutlet;
  

public  void inventoryAttachColumn(){
            id.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().id.toString()));
            name.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().name));
                description.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().description));
            qty.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().qty.toString()));
            purchasing_price.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().purchasing_price.toString()));
            retail_price.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().retail_price.toString()));
            date.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().date));
            Expenseoutletid.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().outletid.toString()));
}
public  void expenseAttachColumn(){
           expenseid.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().expenseId.toString()));
            expenseDetails.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().expenseDetails));
            expensePrice.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().expensePrice.toString()));
            expensDate.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().date));
            outletid.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().outletid.toString()));
 
}
public  void orderAttachColumn(){
    
      Orderid.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().oder_id.toString()));
            customer_name.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().customer_name));
            order_details.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().order_details));
            order_total.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().order_total.toString()));
            order_quantity.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().order_quantity.toString()));
            order_date.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().order_date));
            orderoutletid.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().outletid.toString()));

}
public  void salesReportAttachColumn()
{
      sales_id.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().id.toString()));
      sales_date.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().date));
      total_sales.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().totalSale.toString()));
      total_purchases.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().totalPurchase.toString()));
      monthly_expenses.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().monthlyExpense.toString()));
      total_expenses.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().totalExpense.toString()));
            investment.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().investment.toString()));
            stock.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().stocks.toString()));
            net_income.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().netIncome.toString()));
            profit_ratio.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().profitRatio.toString()));
            account.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().account.toString()));
            salesreport_Outlet.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().outletid.toString()));
  
}
    @Override
    public void initialize(URL url, ResourceBundle rb) {


try {
            
 
           ObservableList<InventoryItem> oblist = InventoryItem.getAll();
            inventoryAttachColumn();
            table.setItems(oblist);

            ObservableList<Expense> ob_expenselist = Expense.getAll();
           expenseAttachColumn();
            expensetable.setItems(ob_expenselist);
                  
            ObservableList<OrderItem> ob_orderlist = OrderItem.getAll();
               orderAttachColumn();
               Ordertable.setItems(ob_orderlist);
      
            ObservableList<SalesReport> ob_salesReportlist = SalesReport.getAll();          
            salesReportAttachColumn();  
            salestable.setItems(ob_salesReportlist);
          
//               ObservableList<outlet> ob_outletlist = outlet.getAll();          
//               ChoiceBox SelectOutlet = new ChoiceBox();
//                for (int i = 0; i<= ob_outletlist.size();i++) 
//                 SelectOutlet.getItems().add(""+ob_outletlist.get(i));
//                  HBox hbox = new HBox(SelectOutlet);        

System.out.println("invent to add");
//            
// InventoryItem itemToAdd = new InventoryItem(Long.parseLong(inventoryId.getText()),inventoryName.toString(),inventoryDescription.toString(), Long.parseLong(inventoryQty.getText()),Double.parseDouble(inventoryPurchase_price.getText()),Double.parseDouble(inventoryRetail_price.getText()),inventoryDate.toString(),Long.parseLong(inventoryOutlet.getText()));  
// AddInventory.setOnAction(e -> {
//               try {
//                   InventoryItem.addOne(itemToAdd);
//               } catch (SQLException ex) {
//                   Logger.getLogger(InventoryTableController.class.getName()).log(Level.SEVERE, null, ex);
//               } catch (ClassNotFoundException ex) {
//                   Logger.getLogger(InventoryTableController.class.getName()).log(Level.SEVERE, null, ex);
//               }
//           });
//UpdateInventory.setOnAction(e -> {
//               try {
//                   InventoryItem.updateOne(itemToAdd);
//               } catch (SQLException ex) {
//                   Logger.getLogger(InventoryTableController.class.getName()).log(Level.SEVERE, null, ex);
//               } catch (ClassNotFoundException ex) {
//                   Logger.getLogger(InventoryTableController.class.getName()).log(Level.SEVERE, null, ex);
//               }
//           });
// 
//DeleteInventory.setOnAction(e ->  {
//               try {
//                   InventoryItem.deleteOne(Long.parseLong(inventoryId.getText()));
//               } catch (SQLException ex) {
//                   Logger.getLogger(InventoryTableController.class.getName()).log(Level.SEVERE, null, ex);
//               } catch (ClassNotFoundException ex) {
//                   Logger.getLogger(InventoryTableController.class.getName()).log(Level.SEVERE, null, ex);
//               }
//           });
//  
OrderItem orderToAdd = new OrderItem(new Long(1),"ammar","momsy stage 5", new Long(1100),new Long(11), "2021",new Long(2));  
// OrderItem.addOne(orderToAdd);
//  OrderItem.updateOne(orderToAdd);
//OrderItem.deleteOne(new Long(2));
 
Expense expenseToAdd = new Expense(new Long(5),"petrol", 17700.0, "10",new Long(2));  
Expense.addOne(expenseToAdd);
System.out.println("expense to add");
 //Expense.updateOne(expenseToAdd);
//Expense.deleteOne(new Long(3));

SalesReport sales_ToAdd = new SalesReport(new Long(1),"10-10-20",1100.0, 100.0,100.0, 1100.0,100.0,10.0,1.0,5.0,1.0,new Long(3));  
//SalesReport.addOne(sales_ToAdd);
//SalesReport.updateOne(sales_ToAdd);
//SalesReport.deleteOne(new Long(3));
 
outlet outlet_ToAdd = new outlet(new Long(4),"discoBranch","discobakry");          
//outlet.addOne(outlet_ToAdd);
//outlet.updateOne(outlet_ToAdd);
//outlet.deleteOne(new Long(4));
        

} 
         catch (Exception e) {
           System.err.println(e.getMessage());
        }
    }    

}