package dao;

import dto.Data;
import org.junit.Assert;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DataDAOTest {
    String login = "root";
    String password = "kakashi6";
    String database = "pogodynkaTest";
    DataDAO dataDAO = new DataDAO(login, password, database);
    //    DataDAO dataDAO2 = new DataDAO(login, password,database2);
//    java.util.Date date;
    DateTimeFormatter dTF = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
    LocalDateTime currentlyDate = LocalDateTime.parse(LocalDateTime.now().format(dTF));
    Data data = new Data(29, 43, currentlyDate);


    @Test
    public void insert() {
        List<Data> expected = new ArrayList<>();
        expected.add(data);
        dataDAO.insert(data);
        Assert.assertEquals(expected, dataDAO.getRecentRecord());
    }

    @Test
    public void getAll() {
        dataDAO.deleteRecords();
        dataDAO.insert(data);
        List<Data> result = new DataDAO(login, password, database).getAll();
//        Assert.assertEquals(expected, result);
    }

    @Test
    public void getRecent7Days() {
    }

    @Test
    public void getRecentRecord() {
    }

}