package sample;

import io.reactivex.rxjavafx.schedulers.JavaFxScheduler;
import io.reactivex.schedulers.Schedulers;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import sample.data.Database;

public class AddPcDetail {
    public TextField pcDetailModelId;
    public TextField detailName;
    public TextField detailPrice;

    private Database db;
    {
        try {
            db = Database.getInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void save(ActionEvent actionEvent){
        if(!pcDetailModelId.getText().isBlank()){
            if(!detailName.getText().isBlank()){
                if(!detailPrice.getText().isBlank()){
                    db.addPcDetail(pcDetailModelId.getText(),detailName.getText(),detailPrice.getText())
                            .subscribeOn(Schedulers.io())
                            .observeOn(JavaFxScheduler.platform())
                            .subscribe(result -> {
                                System.out.println("success");
                                ((Node)(actionEvent.getSource())).getScene().getWindow().hide();

                            }, throwable -> {
                                System.out.println(throwable.getLocalizedMessage());
                            });
                }
                System.out.println("Detail price is empty");
            }
            System.out.println("Detail name is empty");
        }
        System.out.println("Model id is empty");
    }

    public void close(ActionEvent actionEvent){
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }
}
