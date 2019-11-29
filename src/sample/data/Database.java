package sample.data;

import io.reactivex.Single;
import sample.models.Manufacture;
import sample.models.PcDetail;
import sample.models.PcDetailModel;
import sample.models.PcDetailType;

import java.sql.*;
import java.util.ArrayList;

public class Database {
    private static Database mInstance;
    private Connection connection;

    public static Database getInstance() throws ClassNotFoundException {
        if(mInstance == null){
//            mInstance = new Database("root","qwerty","jdbc:mysql://localhost:3306/mydb?serverTimezone=UTC");
            mInstance = new Database("root","12345678","jdbc:mysql://localhost:3306/csd_db1?serverTimezone=UTC");
        }
        return mInstance;
    }

    private Database(String userName, String password, String connectionUrl) throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        try {
            connection = DriverManager.getConnection(connectionUrl,userName,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public ArrayList<Manufacture> getManufacturesList() throws SQLException {
            ArrayList<Manufacture> manufacturesList = new ArrayList<>();
            ResultSet manufactures = connection.createStatement().executeQuery("SELECT * FROM manufacture");
            while (manufactures.next()) {
                manufacturesList.add(new Manufacture(manufactures.getInt(1), manufactures.getString(2)));
            }
            return manufacturesList;
    }

    public ArrayList<PcDetail> getPcDetailsList() throws SQLException {
        ArrayList<PcDetail> pcDetailsList = new ArrayList<>();
        ResultSet pcDetails = connection.createStatement().executeQuery("SELECT * FROM pc_detail");
        while (pcDetails.next()) {
            pcDetailsList.add(new PcDetail(pcDetails.getInt(1), pcDetails.getInt(2),pcDetails.getString(3),pcDetails.getDouble(4)));
        }
        return pcDetailsList;
    }

    public ArrayList<PcDetailModel> getPcDetailModelList() throws SQLException {
        ArrayList<PcDetailModel> pcDetailModelsList = new ArrayList<>();
        ResultSet pcDetails = connection.createStatement().executeQuery("SELECT * FROM pc_detail_model");
        while (pcDetails.next()) {
            pcDetailModelsList.add(new PcDetailModel(pcDetails.getInt(1), pcDetails.getString(2),pcDetails.getInt(3),pcDetails.getInt(4)));
        }
        return pcDetailModelsList;
    }

    public ArrayList<PcDetailType> getPcDetailTypes() throws SQLException {
        ArrayList<PcDetailType> pcDetailTypesList = new ArrayList<>();
        ResultSet pcDetails = connection.createStatement().executeQuery("SELECT * FROM pc_detail_type");
        while (pcDetails.next()) {
            pcDetailTypesList.add(new PcDetailType(pcDetails.getInt(1), pcDetails.getString(2)));
        }
        return pcDetailTypesList;
    }

    public Single<Boolean> addManufacture(String manufactureName){
        return Single.create(emitter ->{
            try {
                connection.createStatement().execute("insert into manufacture (manufacture_name) values ('"+ manufactureName+ "')");
                emitter.onSuccess(true);
            }catch (Exception exception){
                emitter.onError(exception);
            }
                }
        );
    }

    public Single<Boolean> addPcDetail(String pcDetailId, String Dname, String price){
        return Single.create(emitter ->{
                    try {
                        connection.createStatement().execute("INSERT INTO pc_detail (pc_detail_model_id, detail_name, detail_price) VALUES ('" + pcDetailId +"','" + Dname + "','" + price +"');");
                        emitter.onSuccess(true);
                    }catch (Exception exception){
                        emitter.onError(exception);
                    }
                }
        );
    }



}
