/*
 *  UCF COP3330 Summer 2021 Assignment 5 Solution
 *  Copyright 2021 Jamar Jackson
 */

package ucf.assignments;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

public class MainWindowController {
    @FXML
    private BorderPane borderPane;
    @FXML
    private MenuBar menuBar;
    @FXML
    private javafx.scene.control.Menu fileMenu;
    @FXML
    private javafx.scene.control.MenuItem saveMenuItem;
    @FXML
    private javafx.scene.control.MenuItem saveAsMenuItem;
    @FXML
    private javafx.scene.control.MenuItem loadMenuItem;
    @FXML
    private SeparatorMenuItem separatorMenuItem;
    @FXML
    private javafx.scene.control.MenuItem closeMenuItem;
    @FXML
    private javafx.scene.control.Menu findMenu;
    @FXML
    private javafx.scene.control.MenuItem searchMenuItem;
    @FXML
    private Menu helpMenu;
    @FXML
    private MenuItem aboutMenuItem;
    @FXML
    private TableView<?> itemsTableView;
    @FXML
    private TableColumn<?, ?> itemsSerialNumberColumn;
    @FXML
    private TableColumn<?, ?> itemsNameColumn;
    @FXML
    private TableColumn<?, ?> itemsValueColumn;
    @FXML
    private VBox vBox;
    @FXML
    private HBox newItemHBox;
    @FXML
    private TextField itemSerialNumberTextField;
    @FXML
    private TextField itemNameTextField;
    @FXML
    private TextField itemPriceTextField;
    @FXML
    private javafx.scene.control.Button addNewItemButton;
    @FXML
    private Label duplicateSerialNumberLabel;
    @FXML
    private HBox selectedItemHBox;
    @FXML
    private javafx.scene.control.Button editSelectedItemButton;
    @FXML
    private Button deleteSelectedItemButton;

    @FXML
    public void run() {
        itemsSerialNumberColumn.setCellValueFactory(new PropertyValueFactory<>("Serial Number"));
        itemsNameColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
        itemsValueColumn.setCellValueFactory(new PropertyValueFactory<>("Value"));
        itemsTableView.setItems();
    }

    @FXML
    public void saveButtonClicked(javafx.event.ActionEvent actionEvent) {
    }

    @FXML
    void saveAsButtonClicked(javafx.event.ActionEvent event) {
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

    @FXML
    public void loadButtonClicked(javafx.event.ActionEvent actionEvent) {
    }

    @FXML
    public void closeButtonClicked(javafx.event.ActionEvent actionEvent) {
        Platform.exit();
    }

    @FXML
    public void searchButtonClicked(javafx.event.ActionEvent actionEvent) {
    }

    @FXML
    public void aboutButtonClicked(javafx.event.ActionEvent actionEvent) {
    }

    @FXML
    void addNewItemButtonClicked(ActionEvent event) {
        String sn = itemSerialNumberTextField.getText();
        String name = itemNameTextField.getText();
        double value = itemPriceTextField.getText();

        Item item = addNewItem(sn, name, value);

        ListModel.add(item);
    }

    public Item addNewItem(String sn, String name, double value) {
        return new Item(sn, name, value);
    }

    @FXML
    public void editSelectedItemButtonClicked(javafx.event.ActionEvent actionEvent) {
    }

    @FXML
    public void deleteSelectedItemButtonClicked(javafx.event.ActionEvent actionEvent) {
    }

}