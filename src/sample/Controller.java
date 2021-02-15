package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;

public class Controller {

    ArrayList<Producto> productos = new ArrayList<>();
    int column = 0;
    int row = 1;
    @FXML
    private TextField outputID;
    @FXML
    private GridPane gridPane;
    @FXML
    private TextField inputDescription;
    @FXML
    private TextField inputProductName;
    @FXML
    private TextField editDescription;
    @FXML
    private TextField editProductName;

    @FXML
    void addProduct(ActionEvent event) {
        productos.add(new Producto("" + productos.size() ,inputProductName.getText(), inputDescription.getText()));
        gridPane.add(new Label("" + productos.size()), column, row);
        column++;


        gridPane.add(new Label(inputProductName.getText()), column, row);
        column++;

        Button edit = new Button("Edit");
        edit.setId("" + (productos.size() - 1));
        edit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                editProductName.setText(productos.get(Integer.parseInt(edit.getId())).getName());
                editDescription.setText(productos.get(Integer.parseInt(edit.getId())).getDescription());
                outputID.setText(edit.getId());
            }
        });

        gridPane.add(edit, column, row);
        column = 0;
        row++;
    }

    @FXML
    void edit(ActionEvent event) {
        productos.get(Integer.parseInt(outputID.getText())).setName(editProductName.getText());
        productos.get(Integer.parseInt(outputID.getText())).setDescription(editDescription.getText());
    }
}
