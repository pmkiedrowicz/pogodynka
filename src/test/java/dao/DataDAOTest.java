package dao;

import dto.Data;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataDAOTest {
    String login = "root";
    String password = "root";
    String database = "pogodynkaTest";
    DataDAO dataDAO = new DataDAO(login, password,database);
   // private static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/pogodynkaTest?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    LocalDate currentlyDate = LocalDate.parse("2018-05-05");
    Data data = new Data(1,22, 23, currentlyDate);

    @Test
    public void insert() {


    }

    @Test
    public void getAll() {
        List<Data> expected = new ArrayList<>();
        expected.add(data);
        List<Data> result = new DataDAO(login, password,database).getAll();
        result.forEach(data -> System.out.println(data));
        Assert.assertEquals(expected, result);
    }

    @Test
    public void getRecent7Days() {
    }

    @Test
    public void getRecentRecord() {
    }

}