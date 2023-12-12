package com.example.issuetrack;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MaintainerloginController {

    @FXML
    private Button button;

        @FXML
        private TextField passfield;

        @FXML
        private TextField userfield;





    @FXML

    private void handleLogin() throws SQLException {
        String userName=userfield.getText();
        String Password=passfield.getText();
        String sql="Insert into Maintainer values("+"'"+userName+"'"+","+"'"+Password+"'"+");";

        System.out.println(sql);

        DbConnect(sql);

    }

    private void DbConnect(String sql) throws SQLException {
        String url="jdbc:mysql://localhost:3306/IssueP";
        String name="root";
        String pass="Kalai@2816";

        Connection con= DriverManager.getConnection(url,name,pass);
        Statement st=con.createStatement();

        st.execute(sql);

    }

    @FXML
    void gotobugview(ActionEvent event) throws IOException {
        Stage stage = (Stage) button.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("bug-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1920, 1080);
        stage.setTitle("Hello!");
        stage.setScene(scene);

    }

}
