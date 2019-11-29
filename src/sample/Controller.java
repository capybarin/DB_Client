package sample;

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
    public TableColumn<PcDetail, String> pcDetailModelId;
    public TableColumn<PcDetail, String> detailName;
    public TableColumn<PcDetail, String> detailPrice;

    public TableView<PcDetailModel> pcDetailModelTableView;
    public TableColumn<PcDetailModel, Integer> pcDetailModelId_;
    public TableColumn<PcDetailModel, String> pcDetailModelModel;
    public TableColumn<PcDetailModel, String> pcDetailModelManufactureId;
    public TableColumn<PcDetailModel, String> pcDetailModelTypeId;

    public TableView<PcDetailType> pcDetailTypeTableView;
    public TableColumn<PcDetailType, Integer> pcDetailTypeId;
    public TableColumn<PcDetailType, String> pcDetailTypeName;

    private Database db;
    private ObservableList<Manufacture> manufactureData  = FXCollections.observableArrayList();
    private ObservableList<PcDetail> pcDetailsData = FXCollections.observableArrayList();
    private ObservableList<PcDetailModel> pcDetailModelData = FXCollections.observableArrayList();
    private ObservableList<PcDetailType> pcDetailTypeData = FXCollections.observableArrayList();

    public void initialize() throws ClassNotFoundException {
        db = Database.getInstance();
        initializeTable();
    }

    public void buttonAddClicked(ActionEvent actionEvent) {
        switch (tableContainer.getSelectionModel().getSelectedIndex()){
            //Manufacture
            case (0):{
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/sample/addManufacture.fxml"));
                Parent root = null;
                try {
                    root = (Parent) fxmlLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.showAndWait();
            }break;

            //PcDetail
            case(1):{
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/sample/addPcDetail.fxml"));
                Parent root = null;
                try {
                    root = (Parent) fxmlLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.showAndWait();
            }break;

            //PcDetailModel
            case(2):{
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/sample/addPcDetailModel.fxml"));
                Parent root = null;
                try {
                    root = (Parent) fxmlLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.showAndWait();
            }break;

            //PcDetailType
            case(3):{
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/sample/addPcDetailType.fxml"));
                Parent root = null;
                try {
                    root = (Parent) fxmlLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.showAndWait();
            }break;
        }
    }

    public void buttonRemoveClicked(ActionEvent actionEvent) {
    }

    public void buttonConnectClicked(ActionEvent actionEvent) throws SQLException {
        manufactureData.addAll(db.getManufacturesList());
        pcDetailsData.addAll(db.getPcDetailsList());
        pcDetailModelData.addAll(db.getPcDetailModelList());
        pcDetailTypeData.addAll(db.getPcDetailTypes());
    }

    private void initializeTable(){
        manufactureId.setCellValueFactory(new PropertyValueFactory<Manufacture, Integer>("id"));
        manufactureName.setCellValueFactory(new PropertyValueFactory<Manufacture, String>("name"));
        manufactureView.setItems(manufactureData);

        pcdetailId.setCellValueFactory(new PropertyValueFactory<PcDetail, Integer>("id"));
        pcDetailModelId.setCellValueFactory(new PropertyValueFactory<PcDetail, String>("pcDetailModelId"));
        detailName.setCellValueFactory(new PropertyValueFactory<PcDetail, String>("detailName"));
        detailPrice.setCellValueFactory(new PropertyValueFactory<PcDetail, String>("detailPrice"));
        pcDetailTableView.setItems(pcDetailsData);

        pcDetailModelId_.setCellValueFactory(new PropertyValueFactory<PcDetailModel, Integer>("id"));
        pcDetailModelModel.setCellValueFactory(new PropertyValueFactory<PcDetailModel, String>("model"));
        pcDetailModelManufactureId.setCellValueFactory(new PropertyValueFactory<PcDetailModel, String>("manufactureId"));
        pcDetailModelTypeId.setCellValueFactory(new PropertyValueFactory<PcDetailModel, String>("pcDetailTypeId"));
        pcDetailModelTableView.setItems(pcDetailModelData);

        pcDetailTypeId.setCellValueFactory(new PropertyValueFactory<PcDetailType, Integer>("id"));
        pcDetailTypeName.setCellValueFactory(new PropertyValueFactory<PcDetailType, String >("name"));
        pcDetailTypeTableView.setItems(pcDetailTypeData);
    }
}
