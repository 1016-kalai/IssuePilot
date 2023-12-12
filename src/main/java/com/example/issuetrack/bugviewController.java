package com.example.issuetrack;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class bugviewController {
    @FXML
    private TableColumn<Data,Integer >  NumberColumn;

//    private TableColumn<Data,Integer > bugNumberColumn;

    @FXML
    private TableView<Data> bugTable;

    @FXML
    private TableColumn<Data,String> createdColumn;

    @FXML
    private TableColumn<Data,String > descriptionColumn;

    @FXML
    private TableColumn<Data, String> statusColumn;

    @FXML
    private Button submitBug;

    @FXML
    private TableColumn<Data, String> titleColumn;

    @FXML
    private TableColumn<Data, String> updatedColumn;

    @FXML
    void gotodetails(ActionEvent event) throws IOException {
        Stage stage = (Stage) submitBug.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("details-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1920, 1080);
        stage.setTitle("Hello!");
        stage.setScene(scene);

    }
    public void initialize() throws SQLException, SQLException {

        String url = "jdbc:mysql://localhost:3306/IssueP";
        String username = "root";
        String password = "Kalai@2816";
        Connection con = DriverManager.getConnection(url, username, password);
        Statement s = con.createStatement();
        String s1 = "Select * from issues";
        ResultSet res = s.executeQuery(s1);
        DataManager.clear();
        while (res.next()) {
            DataManager.addJob(new Data(
                    res.getInt("Number"),
                    res.getString("Title"),
                    res.getString("Description"),
                    res.getString("Created"),
                    res.getString("Updated"),
                    res.getString("Status")


            ));
        }

        NumberColumn.setCellValueFactory(new PropertyValueFactory<Data, Integer>("Number"));
        createdColumn.setCellValueFactory(new PropertyValueFactory<Data, String>("Created"));
        titleColumn.setCellValueFactory(new PropertyValueFactory<Data, String>("Title"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<Data, String>("Description"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<Data, String>("Status"));
        updatedColumn.setCellValueFactory(new PropertyValueFactory<Data, String>("Updated"));




        bugTable.setItems(DataManager.getJobList());

    }

}
