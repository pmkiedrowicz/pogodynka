package dao;

import dto.Data;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataDAOTest {
    String login = "root";
    String password = "root";
    DataDAO dataDAO = new DataDAO(login, password);
    private static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/pogodynkaTest?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    LocalDate currentlyDate = LocalDate.parse("2018-05-05");
    Data data = new Data(1, 22, 23, currentlyDate);
    Data data2 = new Data(28.8, 38.7, currentlyDate);
    Data data3 = new Data(1, 22, 23, currentlyDate);
    Data data4 = new Data(1, 22, 23, currentlyDate);
    Data data5 = new Data(1, 22, 23, currentlyDate);

    List<Data> expected = new ArrayList<>();


    @Test
    public void insert() {

        expected.add(data2);
        int result = new DataDAO(login, password).insert(data2, CONNECTION_STRING);
        List<Data> database = dataDAO.getAll(CONNECTION_STRING);

        Assert.assertTrue(result == database.size());
    }

    @Test
    public void getAll() {
        expected.add(data);
        List<Data> result = new DataDAO(login, password).getAll(CONNECTION_STRING);
//        result.forEach(data -> System.out.println(data));
        Assert.assertEquals(expected, result);
    }

    @Test
    public void getRecent7Days() {
    }

    @Test
    public void getRecentRecord() {
    }

}