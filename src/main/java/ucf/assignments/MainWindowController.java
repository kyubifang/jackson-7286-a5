/*
 *  UCF COP3330 Summer 2021 Assignment 5 Solution
 *  Copyright 2021 Jamar Jackson
 */

package ucf.assignments;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class MainWindowController {
    @FXML
    private TableView<?> itemsTableView;

    @FXML
    private TableColumn<?, ?> itemsSerialNumberColumn;

    @FXML
    private TableColumn<?, ?> itemsNameColumn;

    @FXML
    private TableColumn<?, ?> itemsValueColumn;

    @FXML
    private TextField itemSerialNumberTextField;

    @FXML
    void addNewItemButtonClicked(ActionEvent event) {
        String sn = itemSerialNumberTextField.getText();
        String name = itemNameTextField.getText();
        double value = itemPriceTextField.getText();

        Item item = addNewItem(sn, name, value);

        ListModel.add(item);
    }

    public void addNewItem(String sn, String name, double value) {
        return new Item(sn, name, value);
    }

    void saveAsButtonClicked(ActionEvent event) {
        filename = FileChooser.getName();
        filetype = FileChooser.getType();

        if(filetype == 'CSV') {
            FileManager.saveAsCSV(filename + filetype);
        }else if(filetype == 'HTML') {
            FileManager.saveAsHTML(filename + filetype);
        }else if(filetype == 'JSON') {
            FileManager.saveAsJSON(filename + filetype);
        }
    }


    public void addNewItemButtonClicked(javafx.event.ActionEvent actionEvent) {
    }

    public void editSelectedItemButtonClicked(javafx.event.ActionEvent actionEvent) {
    }

    public void deleteSelectedItemButtonClicked(javafx.event.ActionEvent actionEvent) {
    }
}