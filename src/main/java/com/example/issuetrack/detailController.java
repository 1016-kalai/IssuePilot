package com.example.issuetrack;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class detailController implements Initializable {

    @FXML
    private TableColumn<?, ?> authorColumn;

    @FXML
    private TableView<?> commentsTable;

    @FXML
    private TableColumn<?, ?> contentColumn;

    @FXML
    private Button createNewCommentButton;

    @FXML
    private TableColumn<?, ?> createdColumn;

    @FXML
    private TextField createdField;

    @FXML
    private TextArea descriptionArea;

    @FXML
    private TextField numberField;

    @FXML
    private Button refreshCommentButton;

    @FXML
    private ChoiceBox<String> statusChoiceBox;

    @FXML
    private TextField titleField;

    @FXML
    private Button updateBugButton;

    @FXML
    private TextField updatedField;

    @FXML

    private void updateDetails() throws SQLException {
        String number=numberField.getText();
        String title =titleField.getText();
        String description = descriptionArea.getText();
        String created = createdField.getText();
        String updated = updatedField.getText();
        String status = statusChoiceBox.getValue().toString();

        String sql = "INSERT INTO issues VALUES (" + number + ",'" + title + "','" + description + "','" + created + "','" + updated + "','" + status + "'"+");";

//        Data d=new Data(Integer.parseInt(number),title,description,created,updated,status);
//        DataManager.addJob(d);
//        System.out.println(sql);

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


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        statusChoiceBox.getItems().addAll("On going", "Completed");
    }

    @FXML
    void updateDetails(ActionEvent event) throws IOException, SQLException {
        try {
            updateDetails();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("bug-view.fxml"));
        Parent root=fxmlLoader.load();

//        bugviewController control= fxmlLoader.getController();
//        control.initialize();

        Stage stage = (Stage) updateBugButton.getScene().getWindow();
//        Scene scene = new Scene(fxmlLoader.load(), 1920, 1080);
//        stage.setTitle("Hello!");
//        stage.setScene(scene);
        stage.setScene(new Scene(root));
        stage.show();
    }
}
