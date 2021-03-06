import DAO.BaseDAO;
import DAO.ResultDAOImpl;
import DAO.StudentDAO;
import DAO.TestDAO;
import beans.Result;
import beans.Student;
import beans.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.*;
import Connection.Connector;
import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {
        StudentDAO studentDAO = new StudentDAO();
        TestDAO testDAO = new TestDAO();
        ResultDAOImpl resultDAO = new ResultDAOImpl();
        Result result;


        try (Scanner scanner = new Scanner(new FileReader(Constants.PATH))) {
            while (scanner.hasNext()) {
                String[] values = scanner.nextLine().split(";");
                Student student = new Student(values[0]);
                Test test = new Test(values[1]);
                studentDAO.create(student);
                testDAO.create(test);
                result = new Result(studentDAO.getStudentId(student), testDAO.getTestId(test),
                        Date.valueOf(values[2]), Integer.parseInt(values[3]));
                resultDAO.create(result);
            }
            System.out.println("all upload");

        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
