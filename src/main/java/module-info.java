module com.example.restcountriesfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;
    requires java.net.http;


    opens com.example.restcountriesfx to javafx.fxml;
    exports com.example.restcountriesfx;
    exports com.example.restcountriesfx.Models;
}