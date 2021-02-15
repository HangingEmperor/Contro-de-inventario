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
    private TextField consultID;
    @FXML
    private TextField consultDescription;
    @FXML
    private TextField consultName;

    @FXML
    void addProduct(ActionEvent event) {
        productos.add(new Producto("" + productos.size() ,inputProductName.getText(), inputDescription.getText(), row));

        gridPane.add(new Label("" + productos.size()), column, row);
        gridPane.add(new Label(inputProductName.getText()), column + 1, row);

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

        Button consult = new Button("consult");
        consult.setId("" + (productos.size() - 1));
        consult.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                consultName.setText(productos.get(Integer.parseInt(consult.getId())).getName());
                consultDescription.setText(productos.get(Integer.parseInt(consult.getId())).getDescription());
                outputID.setText(consult.getId());
            }
        });

        Button remove = new Button("remove");
        remove.setId("" + (productos.size() - 1));
        remove.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                productos.remove(Integer.parseInt(remove.getId()));
                gridPane.getChildren().remove(productos.get(Integer.parseInt(outputID.getText())).getRow() -1);
            }
        });

        gridPane.add(edit, column + 2, row);
        gridPane.add(consult, column + 3, row);
        gridPane.add(remove, column + 4, row);
        column = 0;
        row++;
    }

    @FXML
    void edit(ActionEvent event) {
        productos.get(Integer.parseInt(outputID.getText())).setName(editProductName.getText());
        productos.get(Integer.parseInt(outputID.getText())).setDescription(editDescription.getText());
        System.out.println(gridPane.getChildren().get(1));
        gridPane.add(new Label(editProductName.getText()), 1, productos.get(Integer.parseInt(outputID.getText())).getRow());
    }
}
