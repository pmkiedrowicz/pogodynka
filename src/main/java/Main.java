import dao.DataDAO;
import dto.Data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

public class Main {
    public static void main(String[] args) {
        String database = "pogodynka";
        String login = "root";
        String password = "root";
        String databaseTest = "pogodynkaTest";
        port(8080);

        DateTimeFormatter dTF = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        LocalDateTime currentlyDate = LocalDateTime.parse(LocalDateTime.now().format(dTF));
        DataDAO dataDAO = new DataDAO(login, password, databaseTest);


        get("/sensor", (req, res) -> {
            String temperature = req.queryParams("temperature");
            String humidity = req.queryParams("humidity");
            return "Podana temperatura=" + temperature + ", wilgotność=" + humidity;
        });
        // http://localhost:8080/sensor?temperature=22.4&humidity=33
        post("/sensor", (request, response) -> {
            Double temperature = Double.valueOf(request.queryParams("temperature"));
            Double humidity = Double.valueOf(request.queryParams("humidity"));
            Data data = new Data(temperature, humidity, currentlyDate);
//            return "Podana temperatura=" + temperature + ", wilgotność=" + humidity;
            dataDAO.insert(data);
            return "Data were put into database";
        });
    }
}