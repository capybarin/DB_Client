module DB.Client {
    requires javafx.fxml;
    requires javafx.controls;
    requires java.sql;
    requires mysql.connector.java;
    requires io.reactivex.rxjava2;
    requires rxjavafx;

    opens sample;
    opens sample.models;
}