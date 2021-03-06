package engine;

import models.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;

public class HomeworkImpl implements Homework {
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private Connection conn;

    public HomeworkImpl(Connection connection) {
        this.conn = connection;
    }

    @Override
    public void executeTask() throws IOException, SQLException {
        System.out.println("Enter task number: ");
        String taskNumber = reader.readLine();

        if (taskNumber.equals("") || taskNumber.isEmpty()) {
            throw new IllegalArgumentException("Invalid task number!");
        }
        Exercise exe;

        switch (taskNumber) {
            case "2":
                exe = new Exe2(conn);
                break;
            case "3":
                exe = new Exe3(conn);
                break;
            case "4":
                exe = new Exe4(conn);
                break;
            case "5":
                exe = new Exe5(conn);
                break;
            case "6":
                exe = new Exe6(conn);
                break;
            case "7":
                exe = new Exe7(conn);
                break;
            case "8":
                exe = new Exe8(conn);
                break;
            case "9":
                exe = new Exe9(conn);
                break;
            default:
                throw new IllegalStateException("Wrong task number: " + taskNumber);
        }
        System.out.println(exe.getName());
        exe.execute();
    }
}
