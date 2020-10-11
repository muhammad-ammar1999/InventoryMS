/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */ 
package ims;

import java.sql.SQLException;
import java.util.ArrayList;
import javafx.collections.ObservableList;

/**
 * 
 * @author bilal
 * @param <T>
 * T = Order
 */
public interface DBModel<T> { 
    ObservableList<T> getAll();
     T getOne(Long id);
    void addOne(T item);
    void deleteOne(Long id) throws SQLException;
    void updateOne(T item);
}
