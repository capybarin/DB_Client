package sample.data;

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
            mInstance = new Database("root","qwerty","jdbc:mysql://localhost:3306/mydb?serverTimezone=UTC");
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
            pcDetailsList.add(new PcDetail(pcDetails.getInt(1), pcDetails.getString(2),pcDetails.getString(3),pcDetails.getString(4)));
        }
        return pcDetailsList;
    }

    public ArrayList<PcDetailModel> getPcDetailModelList() throws SQLException {
        ArrayList<PcDetailModel> pcDetailModelsList = new ArrayList<>();
        ResultSet pcDetails = connection.createStatement().executeQuery("SELECT * FROM pc_detail_model");
        while (pcDetails.next()) {
            pcDetailModelsList.add(new PcDetailModel(pcDetails.getInt(1), pcDetails.getString(2),pcDetails.getString(3),pcDetails.getString(4)));
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
}
