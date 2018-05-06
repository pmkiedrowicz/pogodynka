package dao;

import dto.Data;
import org.junit.Test;

import java.util.List;

public class DataDAOTest {
    String login = "root";
    String password = "root";
    DataDAO dataDAO = new DataDAO(login, password);
    private static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/pogodynkaTest?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";


    @Test
    public void insert() {
    }
    @Test
    public void getAll() {
        List<Data> result = new DataDAO(login, password).getAll(CONNECTION_STRING);
        result.forEach(data -> System.out.println(data));

    }

    @Test
    public void getRecent7Days() {
    }

    @Test
    public void getRecentRecord() {
    }

}