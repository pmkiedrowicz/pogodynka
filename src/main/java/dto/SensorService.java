package dto;

import dao.DataDAO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SensorService {

    String login = "root";
    String password = "kakashi6";
    String database = "pogodynka";
    String port = "3306";
    DataDAO dataDAO = new DataDAO(login, password, port, database);

    List<Data> list = dataDAO.getRecent7Days();

    public List<Data> getRecent7DaysFrom12OClock() {
        List<Data> result = new ArrayList<>();

        LocalDate now = LocalDate.now();
        for (int i = 7; i >= 0; i--) {
            int then = now.minusDays(i).getDayOfMonth();
            for (int j = 0; j <= list.size() - 1; j++) {
                if (list.get(j).getDateTime().getDayOfMonth() == then) {
                    if (list.get(j).getDateTime().getHour() >= 12) {
                        result.add(list.get(j));
                        j = list.size() - 1;
                    }
                }
            }
        }
        return result;
    }
}


//
//    public List<Data> getRecent7DaysFrom12OClock2() {
//        List<Data> result = new ArrayList<>();
//        LocalDate now = LocalDate.now();
//        int records = 7;
//        int then;
//        for (int j = 0; j <= list.size() - 1; j++) {
//            then = now.minusDays(records).getDayOfMonth();
//            if (list.get(j).getDateTime().getDayOfMonth() == then) {
//                if (list.get(j).getDateTime().getHour() >= 12) {
//                    result.add(list.get(j));
//                    j = list.size() - 1;
//                    records--;
//                } else if (j == list.size() - 1) {
//                    j = 0;
//                    records--;
//                }
//
//            }
//        }
//        return result;
//    }
