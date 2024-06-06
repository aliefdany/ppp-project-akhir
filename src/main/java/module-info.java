module com.example.pppprojectakhir {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.pppprojectakhir to javafx.fxml;
    exports com.example.pppprojectakhir;
}