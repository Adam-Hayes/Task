package DAO;

import beans.Student;
import beans.Test;

import java.sql.*;

import Connection.Connector;

public class TestDAO implements BaseDAO<Test> {

    public void create(Test object) {
        try {
            Connection connection = Connector.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO tests(name ) values (?)");
            preparedStatement.setString(1, object.getName());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
//    public void create(Test object) {
//        try {
//            Connection connection = Connector.getConnection();
//            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO tests(name ) values (?)");
//            preparedStatement.setString(1, object.getName());
//            preparedStatement.execute();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

    public int getTestId(Test test) {
        ResultSet resultSet = null;
        int id = 0;
        try (Connection connection = Connector.getConnection()) {
            String query = "select idTest from Tests where name like ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, test.getName());
            resultSet = preparedStatement.executeQuery(query);
            while (resultSet.next()) {
                id = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }


}
