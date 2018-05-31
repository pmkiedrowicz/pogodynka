package dto;

public class ValueCheck {

    public boolean isDouble(String temperature, String humidity) {
        try {
            Double temp = Double.parseDouble(temperature);
            Double humi = Double.parseDouble(humidity);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
