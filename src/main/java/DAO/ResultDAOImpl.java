package DAO;

import beans.Result;

import java.sql.*;

import Connection.Connector;

public class ResultDAOImpl implements BaseDAO<Result> {

    public void create(Result object) {
        try {
            Connection connection = Connector.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO results(loginId,testId," +
                    "dat,mark) values (?,?,?,?)");
            preparedStatement.setInt(1, object.getStudentId());
            preparedStatement.setInt(2, object.getTestId());
            preparedStatement.setDate(3, object.getDate());
            preparedStatement.setInt(4, object.getMark());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
