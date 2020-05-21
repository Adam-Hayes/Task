package DAO;

import Connection.Connector;
import beans.Student;
import beans.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDAO implements BaseDAO<Student> {
    public void create(Student object) {
        try(Connection connection = Connector.getConnection();) {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO logins(name ) values (?)");
            preparedStatement.setString(1, object.getName());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public int getStudentId(Student student) {
        ResultSet resultSet = null;
        int id = 0;
        try (Connection connection = Connector.getConnection()) {
          //  String query = "select Idlogin from logins where name like ?"; //вынести в файнал статик переменную
            PreparedStatement preparedStatement = connection.prepareStatement("select Idlogin from logins where name like ?");
            preparedStatement.setString(1, student.getName());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                id = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }
}
