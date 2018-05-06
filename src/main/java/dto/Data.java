package dto;
import lombok.*;

import java.time.LocalDate;


@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@EqualsAndHashCode

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
