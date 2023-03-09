package com.example.demo;

import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TableCopyPasteCellsDemo extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    private final ObservableList<Person> data = FXCollections.observableArrayList(new Person("Jacob", "Smith", 18), new Person("Isabella", "Johnson", 19), new Person("Ethan", "Williams", 20), new Person("Michael", "Brown", 21));

    @Override
    public void start(Stage stage) {

        stage.setWidth(500);
        stage.setHeight(550);

        // create table columns
        TableColumn<Person, String> firstNameCol = new TableColumn<Person, String>("First Name");
        firstNameCol.setMinWidth(100);
        firstNameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("firstName"));

        TableColumn<Person, String> lastNameCol = new TableColumn<Person, String>("Last Name");
        lastNameCol.setMinWidth(100);
        lastNameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("lastName"));

        TableColumn<Person, Integer> ageCol = new TableColumn<Person, Integer>("Age");
        ageCol.setMinWidth(60);
        ageCol.setCellValueFactory(new PropertyValueFactory<Person, Integer>("age"));


        TableView<Person> table = new TableView<>();
        table.setPlaceholder(new Text("No content in table"));
        table.setItems(data);
        table.getColumns().addAll(firstNameCol, lastNameCol, ageCol);

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 10, 10, 10));

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(table);

        vbox.getChildren().addAll(borderPane);

        vbox.getChildren().add(new Label("Select cells and press CTRL+C. Paste the data into Excel or Notepad"));

        Scene scene = new Scene(vbox);

        stage.setScene(scene);
        stage.show();

        // enable multi-selection
        table.getSelectionModel().setCellSelectionEnabled(true);
        table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        // enable copy/paste
        TableUtils.installCopyPasteHandler(table);
    }
}
