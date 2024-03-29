package sample.controllers;

import io.reactivex.rxjavafx.schedulers.JavaFxScheduler;
import io.reactivex.schedulers.Schedulers;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import sample.data.Database;
import sample.models.Manufacture;
import sample.models.PcDetail;
import sample.models.PcDetailModel;
import sample.models.PcDetailType;

import java.io.IOException;
import java.sql.SQLException;

public class Controller {

    public TabPane tableContainer;

    public TableView<Manufacture> manufactureView;
    public TableColumn<Manufacture, Integer> manufactureId;
    public TableColumn<Manufacture, String> manufactureName;

    public TableView<PcDetail> pcDetailTableView;
    public TableColumn<PcDetail, Integer> pcdetailId;
    public TableColumn<PcDetail, Integer> pcDetailModelId;
    public TableColumn<PcDetail, String> detailName;
    public TableColumn<PcDetail, Double> detailPrice;

    public TableView<PcDetailModel> pcDetailModelTableView;
    public TableColumn<PcDetailModel, Integer> pcDetailModelId_;
    public TableColumn<PcDetailModel, String> pcDetailModelModel;
    public TableColumn<PcDetailModel, Integer> pcDetailModelManufactureId;
    public TableColumn<PcDetailModel, Integer> pcDetailModelTypeId;

    public TableView<PcDetailType> pcDetailTypeTableView;
    public TableColumn<PcDetailType, Integer> pcDetailTypeId;
    public TableColumn<PcDetailType, String> pcDetailTypeName;

    private Database db;

    private ObservableList<Manufacture> manufactureData  = FXCollections.observableArrayList();
    private ObservableList<PcDetail> pcDetailsData = FXCollections.observableArrayList();
    private ObservableList<PcDetailModel> pcDetailModelData = FXCollections.observableArrayList();
    private ObservableList<PcDetailType> pcDetailTypeData = FXCollections.observableArrayList();

    public void initialize() {
        initializeTable();
    }

    public void buttonAddClicked(ActionEvent actionEvent) throws IOException, SQLException {
        switch (tableContainer.getSelectionModel().getSelectedIndex()){
            //Manufacture
            case (0):{
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/sample/windows/addManufacture.fxml"));
                Parent root = null;
                try {
                    root = (Parent) fxmlLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.showAndWait();
                loadManufactures();

            }break;

            //PcDetail
            case(1):{
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/sample/windows/addPcDetail.fxml"));
                Parent root = null;
                try {
                    root = (Parent) fxmlLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.showAndWait();
                loadDetailsData();
            }break;

            //PcDetailModel
            case(2):{
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/sample/windows/addPcDetailModel.fxml"));
                Parent root = null;
                try {
                    root = (Parent) fxmlLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.showAndWait();
                loadModelData();
            }break;

            //PcDetailType
            case(3):{
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/sample/windows/addPcDetailType.fxml"));
                Parent root = null;
                try {
                    root = (Parent) fxmlLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.showAndWait();
                loadTypeData();
            }break;
        }
    }

    public void buttonRemoveClicked(ActionEvent actionEvent) {
        switch (tableContainer.getSelectionModel().getSelectedIndex()){
            case (0):{
                Manufacture manufacture = manufactureView.getSelectionModel().getSelectedItem();
                if (manufacture!=null){
                    db.delManufacture(manufacture.getId())
                            .subscribeOn(Schedulers.io())
                            .observeOn(JavaFxScheduler.platform())
                            .subscribe(result -> {
                                System.out.println("success");
                                loadManufactures();
                            }, throwable -> {
                                System.out.println(throwable.getLocalizedMessage());
                            });
                    System.out.println(manufacture.getId());}
            }break;
            case (1):{
                    PcDetail pcDetail = pcDetailTableView.getSelectionModel().getSelectedItem();
                if (pcDetail!=null){
                    db.delDetail(pcDetail.getId())
                            .subscribeOn(Schedulers.io())
                            .observeOn(JavaFxScheduler.platform())
                            .subscribe(result -> {
                                System.out.println("success");
                                loadDetailsData();
                            }, throwable -> {
                                System.out.println(throwable.getLocalizedMessage());
                            });
                    System.out.println(pcDetail.getId());}
            }break;
            case (2):{
                    PcDetailModel pcDetailModel = pcDetailModelTableView.getSelectionModel().getSelectedItem();
                if (pcDetailModel!=null){
                    db.delDetailModel(pcDetailModel.getId())
                            .subscribeOn(Schedulers.io())
                            .observeOn(JavaFxScheduler.platform())
                            .subscribe(result -> {
                                System.out.println("success");
                                loadModelData();
                            }, throwable -> {
                                System.out.println(throwable.getLocalizedMessage());
                            });
                    System.out.println(pcDetailModel.getId());}
            }break;
            case (3):{
                    PcDetailType pcDetailType = pcDetailTypeTableView.getSelectionModel().getSelectedItem();
                if (pcDetailType!=null){
                    db.delDetailType(pcDetailType.getId())
                            .subscribeOn(Schedulers.io())
                            .observeOn(JavaFxScheduler.platform())
                            .subscribe(result -> {
                                System.out.println("success");
                                loadTypeData();
                            }, throwable -> {
                                System.out.println(throwable.getLocalizedMessage());
                            });
                    System.out.println(pcDetailType.getId());}
            }break;
        }
    }

    public void buttonConnectClicked(ActionEvent actionEvent) throws SQLException {
        try {
            db = Database.getInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        loadManufactures();
        loadDetailsData();
        loadModelData();
        loadTypeData();
    }

    private void loadModelData() throws SQLException {
        pcDetailModelData.clear();
        pcDetailModelData.addAll(db.getPcDetailModelList());
    }

    private void loadTypeData() throws SQLException {
        pcDetailTypeData.clear();
        pcDetailTypeData.addAll(db.getPcDetailTypes());
    }

    private void loadManufactures() throws SQLException {
        manufactureData.clear();
        manufactureData.addAll(db.getManufacturesList());
    }

    private void loadDetailsData() throws SQLException {
        pcDetailsData.clear();
        pcDetailsData.addAll(db.getPcDetailsList());
    }

    private void initializeTable(){
        manufactureId.setCellValueFactory(new PropertyValueFactory<Manufacture, Integer>("id"));
        manufactureName.setCellValueFactory(new PropertyValueFactory<Manufacture, String>("name"));
        manufactureView.setItems(manufactureData);

        pcdetailId.setCellValueFactory(new PropertyValueFactory<PcDetail, Integer>("id"));
        pcDetailModelId.setCellValueFactory(new PropertyValueFactory<PcDetail, Integer>("pcDetailModelId"));
        detailName.setCellValueFactory(new PropertyValueFactory<PcDetail, String>("detailName"));
        detailPrice.setCellValueFactory(new PropertyValueFactory<PcDetail, Double>("detailPrice"));
        pcDetailTableView.setItems(pcDetailsData);

        pcDetailModelId_.setCellValueFactory(new PropertyValueFactory<PcDetailModel, Integer>("id"));
        pcDetailModelModel.setCellValueFactory(new PropertyValueFactory<PcDetailModel, String>("model"));
        pcDetailModelManufactureId.setCellValueFactory(new PropertyValueFactory<PcDetailModel, Integer>("manufactureId"));
        pcDetailModelTypeId.setCellValueFactory(new PropertyValueFactory<PcDetailModel, Integer>("pcDetailTypeId"));
        pcDetailModelTableView.setItems(pcDetailModelData);

        pcDetailTypeId.setCellValueFactory(new PropertyValueFactory<PcDetailType, Integer>("id"));
        pcDetailTypeName.setCellValueFactory(new PropertyValueFactory<PcDetailType, String >("name"));
        pcDetailTypeTableView.setItems(pcDetailTypeData);
    }
}
