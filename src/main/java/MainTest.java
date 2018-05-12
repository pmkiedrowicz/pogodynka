import dao.DataDAO;
import dto.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

public class MainTest {

    public static void main(String[] args) {
//        String database = "pogodynka";
//        String databaseTest = "pogodynkaTest";
        //        port(8080);
//        get("/hello", (req, res) -> "Hello World");
//        // http://localhost:8080/sensor?temperature=22.4&humidity=33
//        post("/sensor", (request, response) -> {
//            String temperature = request.queryParams("temperature");
//            String humidity = request.queryParams("humidity");
//            return "Podana temperatura=" + temperature + ", wilgotność=" + humidity;
//        });
//        double temp = 22;
//        double humi = 23;
//        LocalDateTime localDateTime = LocalDateTime.now();
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Podaj login: ");
//        String login = scanner.next();
//        System.out.print("Podaj hasło: ");
//        String password = scanner.next();
//
//        Data newData = new Data(temp, humi, localDateTime);
//        new DataDAO(login, password,database).insert(newData);
//
//        System.out.println("it gets all");
//        List<Data> result = new DataDAO(login, password,database).getAll();
//        result.forEach(data -> System.out.println(data));
//        System.out.println("7days");
//        List<Data> result2 = new DataDAO(login, password,database).getRecent7Days();
//        result2.forEach(data -> System.out.println(data));
//        System.out.println("recent record");


//        Boolean result3 = new DataDAO(login, password, databaseTest).deleteRecords();
//        System.out.println(result3);


    }
}
