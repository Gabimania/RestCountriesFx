module com.example.restcountriesfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.restcountriesfx to javafx.fxml;
    exports com.example.restcountriesfx;
}