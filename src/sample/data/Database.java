package sample.data;

import java.sql.*;

public class Database {
    private static Database mInstance;
    private Statement statement;

    public static Database getInstance() throws ClassNotFoundException {
        if(mInstance == null){
            mInstance = new Database("root","qwerty","jdbc:mysql://localhost:3306/mydb?serverTimezone=UTC");
        }
        return mInstance;
    }

    public Database(String userName, String password, String connectionUrl) throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        try(Connection connection = DriverManager.getConnection(connectionUrl,userName,password);) {
            statement = connection.createStatement();
            //System.out.println("EZ");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
