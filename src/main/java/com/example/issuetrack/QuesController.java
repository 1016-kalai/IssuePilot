package com.example.issuetrack;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class QuesController {

    @FXML
    private Button Developer;

    @FXML
    private Button Maintainer;

    @FXML
    private ImageView background;

    @FXML
    private Label heading;

    @FXML
    private AnchorPane homepage;

    @FXML
    private Text intro;


    private Connection connection;

    @FXML
    void gotodeveloperlogin(ActionEvent event) throws IOException {
        Stage stage = (Stage) Developer.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Developerlogin.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1920, 1080);
        stage.setTitle("Hello!");
        stage.setScene(scene);

    }

    @FXML
    void gotomaintainerlogin(ActionEvent event) throws  IOException {

        Stage stage = (Stage) Maintainer.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("maintainerlogin.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1920, 1080);
        stage.setTitle("Hello!");
        stage.setScene(scene);
    }

    public void connect() throws SQLException {
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/IssueP",
                "",
                ""
        );
    }



}
