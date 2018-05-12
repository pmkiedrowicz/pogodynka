import dao.DataDAO;
import dto.Data;
import dto.SensorService;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

public class Main {
    public static void main(String[] args) {
//        String database = "pogodynka";
//        String login = "root";
//        String password = "root";
//        String databaseTest = "pogodynkaTest";
//        port(8080);
//
//        DateTimeFormatter dTF = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
//        LocalDateTime currentlyDate = LocalDateTime.parse(LocalDateTime.now().format(dTF));
//        DataDAO dataDAO = new DataDAO(login, password, databaseTest);
//
//
//        get("/sensor", (req, res) -> {
//            String temperature = req.queryParams("temperature");
//            String humidity = req.queryParams("humidity");
//            return "Podana temperatura=" + temperature + ", wilgotność=" + humidity;
//        });
//        // http://localhost:8080/sensor?temperature=22.4&humidity=33
//        post("/sensor", (request, response) -> {
//            Double temperature = Double.valueOf(request.queryParams("temperature"));
//            Double humidity = Double.valueOf(request.queryParams("humidity"));
//            Data data = new Data(temperature, humidity, currentlyDate);
////            return "Podana temperatura=" + temperature + ", wilgotność=" + humidity;
//            dataDAO.insert(data);
//            return "Data were put into database";
//        });
//
//
        SensorService sensorService=new SensorService();
        sensorService.getRecent7DaysFrom12OClock().forEach(el-> System.out.println(el.toString()));
//        System.out.println(" 222");
//        sensorService.getRecent7DaysFrom12OClock2().forEach(el-> System.out.println(el.toString()));
//
//        LocalDate now = LocalDate.now();
//        int then = now.minusDays(7).getDayOfMonth();
//        System.out.println(then);
    }
}