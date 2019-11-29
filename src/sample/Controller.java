package sample;

import javafx.event.ActionEvent;
import sample.data.Database;

public class Controller {


    public void buttonAddClicked(ActionEvent actionEvent) {
    }

    public void buttonRemoveClicked(ActionEvent actionEvent) {
    }

    public void buttonConnectClicked(ActionEvent actionEvent) {
        try{
            Database bd = Database.getInstance();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
