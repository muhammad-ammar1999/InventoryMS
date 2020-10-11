///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package ims;
//
//import java.net.URL;
//import java.util.ResourceBundle;
//import javafx.beans.property.SimpleStringProperty;
//import javafx.collections.ObservableList;
//import javafx.fxml.FXML;
//import javafx.fxml.Initializable;
//import javafx.scene.control.Button;
//import javafx.scene.control.TableColumn;
//import javafx.scene.control.TableView;
//import javafx.scene.control.TextField;
//
///**
// *
// * @author muhammadammar  
// */
//public class OutletClassController implements Initializable {
//
//@FXML
//    private Button addOutlet;    
//    
//@FXML
//    private TextField outletId;
//         @FXML
//    private TextField outletAddress;     
//    @Override
//    public void initialize(URL url, ResourceBundle rb) {
//
//outlet itemToAdd = new outlet(new Long(1),"ammar","ammar");  
//       try {
//            
////          outlet.addOne(ItemToAdd);
////              System.out.println("ammar");
////    
//  
// 
//            ObservableList<outlet> oblist = outlet.getAll();
//
//             id.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().id.toString()));
//            expenseDetails.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().expenseDetails));
//            expensePrice.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().expensePrice.toString()));
//            expensDate.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().date));
//            expenseid.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().outletid.toString()));
//            
//            expensetable.setItems(oblist);
////        } catch (SQLException ex) {
////            Logger.getLogger(InventoryTableController.class.getName()).log(Level.SEVERE, null, ex);
////        } catch (ClassNotFoundException ex) {
////            Logger.getLogger(InventoryTableController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//         catch (Exception e) {
//            System.out.println(e);
//        }
//    }
//}
//
//    
//
