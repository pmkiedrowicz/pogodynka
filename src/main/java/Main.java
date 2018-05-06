import dao.DataDAO;
import dto.Data;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

public class Main {
    public static void main(String[] args) {
//        port(8080);
//        get("/hello", (req, res) -> "Hello World");
//        // http://localhost:8080/sensor?temperature=22.4&humidity=33
//        post("/sensor", (request, response) -> {
//            String temperature = request.queryParams("temperature");
//            String humidity = request.queryParams("humidity");
//            return "Podana temperatura=" + temperature + ", wilgotność=" + humidity;
//        });
            double temp=40;
            double humi=40;
             LocalDate data2 = LocalDate.now();
            Scanner scanner = new Scanner(System.in);
            System.out.print("Podaj login: ");
            String login = scanner.next();
            System.out.print("Podaj hasło: ");
            String password = scanner.next();

           Data newData = new Data(temp,humi,data2);
           new DataDAO(login, password).insert(newData);

           List<Data> result = new DataDAO(login, password).getAll();
             result.forEach(data -> System.out.println(data));
    }
}
