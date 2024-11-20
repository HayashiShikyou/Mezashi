package app.jlpt.mezashi.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import app.jlpt.database.controller.InputDB;

public class InputTestCtrl implements Initializable {

    @FXML
    private TextArea txaConsole;

    @FXML
    private TextField txfInput;

    @FXML
    void inputData(ActionEvent event) {
        try {
            InputDB.saveBook(txfInput.getText());
            txaConsole.setText(InputDB.getAllBooks());
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "DB Error");
        }
    }

    @FXML
    void showAllBooks(ActionEvent event) {
        try {
            txaConsole.setText(InputDB.getAllBooks());
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR);
;        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub
    }
}
