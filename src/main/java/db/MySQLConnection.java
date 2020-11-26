package db;

import java.sql.*;

public class MySQLConnection {

    private Connection connection;

    public MySQLConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void connect(){
        try {
            connection = DriverManager.getConnection("jdbc:mysql://200.3.193.22:3306/P09728_1_11", "P09728_1_11", "ZCSaQGZU");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void disconnect(){
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public boolean createDataBase(){
        boolean success = false;
        connect();
        try {
            Statement statement = connection.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS tareasJaimeCardona(id INT PRIMARY KEY AUTO_INCREMENT,descripcion VARCHAR(200),to_do INT, doing INT, done INT, fecha VARCHAR(100))");
            success = true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            success = false;
        }finally {
            disconnect();
        }
        return success;
    }

    public boolean executeSQL(String sql){
        boolean success = false;
        connect();
        try {
            Statement statement = connection.createStatement();
            statement.execute(sql);
            success = true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            disconnect();
        }
        return success;
    }

    public ResultSet query(String sql){
        ResultSet output = null;
        try {
            connect();
            Statement statement = connection.createStatement();
            output = statement.executeQuery(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return output;
    }

}
