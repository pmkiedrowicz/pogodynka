package dao;

import dto.Data;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class DataDAOTest {
    String login = "root";
    String password = "root";
    String database = "pogodynkaTest";
    DataDAO dataDAO = new DataDAO(login, password, database);
    //    DataDAO dataDAO2 = new DataDAO(login, password,database2);
    java.util.Date date;
    LocalDateTime currentlyDate = LocalDateTime.of(2016, Month.JANUARY, 14, 17, 22, 33, 666);
    Data data = new Data(29, 43, currentlyDate);

    @Test
    public void insert() {
        dataDAO.insert(data);
    }

    @Test
    public void getAll() {
//        List<Data> expected = new ArrayList<>();
//        expected.add(data);
//        List<Data> result = new DataDAO(login, password, database).getAll();
//        result.forEach(data -> System.out.println(data));
//        Assert.assertEquals(expected, result);
    }

    @Test
    public void getRecent7Days() {
    }

    @Test
    public void getRecentRecord() {
    }

}