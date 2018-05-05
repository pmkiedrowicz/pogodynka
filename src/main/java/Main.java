import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

public class Main {
    public static void main(String[] args) {
        port(8080);
        get("/hello", (req, res) -> "Hello World");
        // http://localhost:8080/sensor?temperature=22.4&humidity=33
        post("/sensor", (request, response) -> {
            String temperature = request.queryParams("temperature");
            String humidity = request.queryParams("humidity");
            return "Podana temperatura=" + temperature + ", wilgotność=" + humidity;
        });
    }
}
