module com.example.pppprojectakhir {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.pppprojectakhir to javafx.fxml;
    exports com.example.pppprojectakhir;
    exports com.example.pppprojectakhir.controller;
    opens com.example.pppprojectakhir.controller to javafx.fxml;
    exports com.example.pppprojectakhir.model.factory;
    opens com.example.pppprojectakhir.model.factory to javafx.fxml;
    exports com.example.pppprojectakhir.model.observer;
    opens com.example.pppprojectakhir.model.observer to javafx.fxml;
    exports com.example.pppprojectakhir.model.strategy;
    opens com.example.pppprojectakhir.model.strategy to javafx.fxml;
}