import dto.Data;
import dto.SensorService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.List;

public class LineChartControler {

    @FXML
    private LineChart<?, ?> LineChart;

    @FXML
    private CategoryAxis x;

    @FXML
    private NumberAxis y;

    @FXML
    private Button pobierzTemperatureRecent;

    @FXML
    private TextField temp_6;

    @FXML
    private TextField temp_5;

    @FXML
    private TextField temp_4;

    @FXML
    private TextField temp_3;

    @FXML
    private TextField temp_2;

    @FXML
    private TextField temp_1;

    @FXML
    private TextField temp_0;

    @FXML
    private TextField humi_6;

    @FXML
    private TextField humi_5;

    @FXML
    private TextField humi_4;

    @FXML
    private TextField humi_3;

    @FXML
    private TextField humi_2;

    @FXML
    private TextField humi_1;

    @FXML
    private TextField humi_0;

    @FXML
    void onClick1(ActionEvent event) {
        SensorService sensorService = new SensorService();
        List<Data> last7Days = sensorService.getRecent7DaysFrom12OClock();
        temp_6.setText(Double.toString(last7Days.get(0).getTemperature()));
        temp_5.setText(Double.toString(last7Days.get(1).getTemperature()));
        temp_4.setText(Double.toString(last7Days.get(2).getTemperature()));
        temp_3.setText(Double.toString(last7Days.get(3).getTemperature()));
        temp_2.setText(Double.toString(last7Days.get(4).getTemperature()));
        temp_1.setText(Double.toString(last7Days.get(5).getTemperature()));
        temp_0.setText(Double.toString(last7Days.get(6).getTemperature()));
        humi_6.setText(Double.toString(last7Days.get(0).getHumidity()));
        humi_5.setText(Double.toString(last7Days.get(1).getHumidity()));
        humi_4.setText(Double.toString(last7Days.get(2).getHumidity()));
        humi_3.setText(Double.toString(last7Days.get(3).getHumidity()));
        humi_2.setText(Double.toString(last7Days.get(4).getHumidity()));
        humi_1.setText(Double.toString(last7Days.get(5).getHumidity()));
        humi_0.setText(Double.toString(last7Days.get(6).getHumidity()));

    }

}


//    public void start(Stage stage) {
//        stage.setTitle("Show Last Week");
//        final CategoryAxis xAxis = new CategoryAxis();
//        final NumberAxis yAxis = new NumberAxis();
//        xAxis.setLabel("Month");
//        final LineChart<String, Number> lineChart =
//                new LineChart<String, Number>(xAxis, yAxis);
//
//        lineChart.setTitle("Last Week");
//
//        XYChart.Series series1 = new XYChart.Series();
//        series1.setName("Temp");
//
//        series1.getData().add(new XYChart.Data("7 day ago", 23));
//        series1.getData().add(new XYChart.Data("6 day ago", 14));
//        series1.getData().add(new XYChart.Data("5 day ago", 15));
//        series1.getData().add(new XYChart.Data("4 day ago", 24));
//        series1.getData().add(new XYChart.Data("3 day ago", 34));
//        series1.getData().add(new XYChart.Data("2 day ago", 36));
//        series1.getData().add(new XYChart.Data("Yesterday", 22));
//        series1.getData().add(new XYChart.Data("Today", 45));
//
//        XYChart.Series series2 = new XYChart.Series();
//        series2.setName("Humi");
//        series2.getData().add(new XYChart.Data("7 day ago", 55));
//        series2.getData().add(new XYChart.Data("6 day ago", 68));
//        series2.getData().add(new XYChart.Data("5 day ago", 61));
//        series2.getData().add(new XYChart.Data("4 day ago", 54));
//        series2.getData().add(new XYChart.Data("3 day ago", 70));
//        series2.getData().add(new XYChart.Data("2 day ago", 75));
//        series2.getData().add(new XYChart.Data("Yesterday", 55));
//        series2.getData().add(new XYChart.Data("Today", 70));
//
//        Scene scene  = new Scene(lineChart,500,300);
//        lineChart.getData().addAll(series1, series2);
//
//        stage.setScene(scene);
//        stage.show();
//    }
//
//    public static void main(String[] args) {
//        launch(args);
//    }
//}

