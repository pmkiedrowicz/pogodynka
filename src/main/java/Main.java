import dao.DataDAO;
import dto.Data;
import dto.SensorService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

public class Main extends Application {
    public static void main(String[] args) {
        Application.launch(Main.class, args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/graphView.fxml"));
        Scene scene = new Scene(root,500,300);
        Stage stage = new Stage();
        stage.setTitle("FXML Example");
        stage.setScene(scene);
        stage.show();

//        String database = "pogodynka";
        String login = "root";
        String password = "root";
        String databaseTest = "pogodynkaTest";
//
        DateTimeFormatter dTF = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        DataDAO dataDAO = new DataDAO(login, password, databaseTest);
        System.out.println(dataDAO.getRecent7Days());
        //
//
        port(8080);
        get("/sensor", (req, res) -> {
            String temperature = req.queryParams("temperature");
            String humidity = req.queryParams("humidity");
            return "Podana temperatura=" + temperature + ", wilgotność=" + humidity;
        });
//         http://localhost:8080/sensor?temperature=22.4&humidity=33
        post("/sensor", (request, response) -> {
        LocalDateTime currentlyDate = LocalDateTime.parse(LocalDateTime.now().format(dTF));

            //need to add IF statement to check if its not send empty String (makes error)
            //java.lang.NumberFormatException: empty String
            //	at sun.misc.FloatingDecimal.readJavaFormatString(FloatingDecimal.java:1842)
            Double temperature = Double.valueOf(request.queryParams("temperature"));
            Double humidity = Double.valueOf(request.queryParams("humidity"));
            Data data = new Data(temperature, humidity, currentlyDate);
            dataDAO.insert(data);
            return "Data were put into database";
        });
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
