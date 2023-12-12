module com.example.issuetrack {
    requires javafx.controls;
    requires javafx.fxml;
    requires mysql.connector.j;
    requires java.sql;


    opens com.example.issuetrack to javafx.fxml;
    exports com.example.issuetrack;
}