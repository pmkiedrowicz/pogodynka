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
    String database2="pogodynka";
    DataDAO dataDAO = new DataDAO(login, password,database);
    DataDAO dataDAO2 = new DataDAO(login, password,database2);

    LocalDate currentlyDate = LocalDate.parse("2018-05-06");
    Data data = new Data(29, 43, currentlyDate);

    @Test
    public void insert() {
    dataDAO2.insert(data);
    dataDAO.insert(data);


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