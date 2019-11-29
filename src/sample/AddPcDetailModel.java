package sample;

import io.reactivex.rxjavafx.schedulers.JavaFxScheduler;
import io.reactivex.schedulers.Schedulers;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import sample.data.Database;

public class AddPcDetailModel {
    public TextField name;
    public TextField manufactureId;
    public TextField pcDetailTypeId;

    private Database db;
    {
        try {
            db = Database.getInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void close(ActionEvent actionEvent){
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }

    public void save(ActionEvent actionEvent){if(!name.getText().isBlank()){
        if(!manufactureId.getText().isBlank()){
            if(!pcDetailTypeId.getText().isBlank()){
                db.addDetailModel(name.getText(),manufactureId.getText(),pcDetailTypeId.getText())
                        .subscribeOn(Schedulers.io())
                        .observeOn(JavaFxScheduler.platform())
                        .subscribe(result -> {
                            System.out.println("success");
                            ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
                        }, throwable -> {
                            System.out.println(throwable.getLocalizedMessage());
                        });
            } else {
                System.out.println("Detail type id is empty");

            }
        } else {
            System.out.println("Manufacture id is empty");

        }
    } else {
        System.out.println("Name is empty");

    }}
}
