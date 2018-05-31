package dao;

public class ValueCheck {

    public boolean isDouble(String temperature, String humidity) {
        try {
            Double.parseDouble(temperature);
            Double.parseDouble(humidity);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public boolean isHumiInRange(String humidity) {
        try {
            Double humi = Double.parseDouble(humidity);
            if (humi < 0 || humi > 100) {
                return false;
            }
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
