module DB.Client {
    requires javafx.fxml;
    requires javafx.controls;
    requires java.sql;

    opens sample;
    opens sample.models;
}