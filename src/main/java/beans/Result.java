package beans;

import java.sql.Date;

public class Result {
    private int studentId;
    private int testId;
    private Date date;
    private int mark;

    public Result(int studentId, int testId, Date date, int mark) {
        this.studentId = studentId;
        this.testId = testId;
        this.date = date;
        this.mark = mark;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getTestId() {
        return testId;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }
}
