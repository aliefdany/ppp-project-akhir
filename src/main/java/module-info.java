module com.example.pppprojectakhir {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.pppprojectakhir to javafx.fxml;
    exports com.example.pppprojectakhir;
    exports com.example.pppprojectakhir.controller;
    opens com.example.pppprojectakhir.controller to javafx.fxml;
    exports com.example.pppprojectakhir.model;
    opens com.example.pppprojectakhir.model to javafx.fxml;
}