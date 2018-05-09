package dto;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

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
    private LocalDateTime dateTime;

    public Data(double temperature, double humidity, LocalDateTime dateTime) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.dateTime = dateTime;
    }
}
