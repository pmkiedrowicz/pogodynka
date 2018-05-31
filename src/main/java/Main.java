import controlers.WeatherAppControler;
import dao.DataDAOImpl;
import dao.GetPost;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.log4j.BasicConfigurator;
import settings.AppSettings;
import threads.TemperatureWatcher;

public class Main extends Application {
    //main method
    public static void main(String[] args) {
        Application.launch(Main.class, args);
        BasicConfigurator.configure();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        //Execute GetPost HTTP requests
        GetPost getPost = new GetPost();
        getPost.sensorData();

        DataDAOImpl dataDAOImp = new DataDAOImpl(AppSettings.login, AppSettings.password, AppSettings.port, AppSettings.database);

        Parent root = FXMLLoader.load(getClass().getResource("/graphView.fxml"));
        Parent root3 = FXMLLoader.load(getClass().getResource("/graphViewWithDates.fxml"));

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/weatherAppTemp.fxml"));
        Parent root2 = loader.load();

        Scene scene = new Scene(root, 500, 300);
        Scene scene2 = new Scene(root2, 500, 300);
        Scene scene3 = new Scene(root3, 600, 400);

        scene.getStylesheets().add("style.css");
        Stage stage = new Stage();
        Stage stage2 = new Stage();
        Stage stage3 = new Stage();

        stage.setTitle("Wykres");
        stage.setScene(scene);
        stage2.setTitle("Pogodynka");
        stage2.setScene(scene2);
        stage3.setTitle("Daty");
        stage3.setScene(scene3);

        WeatherAppControler controler = loader.<WeatherAppControler>getController();
        TemperatureWatcher temperatureWatcher = new TemperatureWatcher(dataDAOImp, controler);
        temperatureWatcher.start();

//        stage.show();
//        stage2.show();
//        stage3.show();
    }
}
