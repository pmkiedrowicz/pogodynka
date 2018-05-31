package dao;

import dto.Data;
import org.apache.log4j.Logger;
import settings.AppSettings;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

public class GetPost {
    final static Logger logger=Logger.getLogger(GetPost.class.getName());
    DataDAOImpl dataDAO = new DataDAOImpl(AppSettings.login, AppSettings.password, AppSettings.port, AppSettings.database);
    //Adds DateTime pattern-format, except this theres issue with miliseconds input/output database
    DateTimeFormatter dTF = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

    public void sensorData() {
        //sets inputPort for microcontroller
        port(AppSettings.inputPort);
        get("/sensor", (req, res) -> {
            String temperature = req.queryParams("temperature");
            String humidity = req.queryParams("humidity");
            return "Podana temperatura=" + temperature + ", wilgotność=" + humidity;
        });
        post("/sensor", (request, response) -> {
//            System.out.println(dataDAO.getRecent7Days());
            LocalDateTime currentlyDate = LocalDateTime.parse(LocalDateTime.now().format(dTF));
            String temperature = request.queryParams("temperature");
            String humidity = request.queryParams("humidity");
            ValueCheck valueCheck = new ValueCheck();
            if (valueCheck.isDouble(temperature, humidity) == true) {
                Double temp = Double.parseDouble(temperature);
                Double humi = Double.parseDouble(humidity);
                Data data = new Data(temp, humi, currentlyDate);
                dataDAO.insert(data);
            } else {
                logger.warn("Data were not put into database, temperature: "+temperature+" and humidity: "+humidity);
                return "Data were not put into database";
            }
            return "Data were put into database";
        });
    }
}
