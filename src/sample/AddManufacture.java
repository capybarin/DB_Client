package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import sample.data.Database;

public class AddManufacture {
    public TextField name;

    private Database db;
    {
        try {
            db = Database.getInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void initialize(){

    }

    @FXML
    private void save(){

    }

    @FXML
    private void close(){

    }
}
