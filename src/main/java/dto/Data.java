package dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor

public class Data {
    private int id;
    private double temperature;
    private double humidity;
    private LocalDate dateTime;

    public Data(double temperature, double humidity, LocalDate dateTime) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.dateTime = dateTime;
    }
}
