module com.example.weather1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.json;


    opens com.example.weather1 to javafx.fxml;
    exports com.example.weather1;
}