package sample;

import io.reactivex.Scheduler;
import io.reactivex.rxjavafx.schedulers.JavaFxScheduler;
import io.reactivex.schedulers.Schedulers;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
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

    public void save(ActionEvent actionEvent){
        if(!name.getText().isBlank()){
            db.addManufacture(name.getText())
                    .subscribeOn(Schedulers.io())
                    .observeOn(JavaFxScheduler.platform())
                    .subscribe(result -> {
                        System.out.println("success");
                        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();

                    }, throwable -> {
                        System.out.println(throwable.getLocalizedMessage());
                    });
        }
    }


    public void close(ActionEvent actionEvent){
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }
}
