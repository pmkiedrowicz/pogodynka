package dto;

import dao.DataDAOImpl;
import settings.AppSettings;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class SensorService {

    String login = AppSettings.login;
    String password = AppSettings.password;
    String database = AppSettings.database;
    String port = AppSettings.port;
    DataDAOImpl dataDAO = new DataDAOImpl(login, password, port, database);

    List<Data> list = dataDAO.getRecent7Days();

    public List<Data> getRecent7DaysFrom12OClock() {
        List<Data> result = new ArrayList<>();

        //Adds local date
        LocalDate now = LocalDate.now();
        //Count last 7 days
        for (int i = 6; i >= 0; i--) {
            //Counter for actual day, each iterate of loop change a day
            int then = now.minusDays(i).getDayOfMonth();
            //Every iterate substract existing list of last 7 days elements
            for (int j = 0; j < list.size(); j++) {
                //If element of that list is the checking day, then...
                if (list.get(j).getDateTime().getDayOfMonth() == then) {
                    //...returns first record after 12pm
                    if (list.get(j).getDateTime().getHour() >= 12) {
                        //Adds elemment to result list
                        result.add(list.get(j));
                        //
                        j = list.size() - 1;
                        //jeśli nie będzie powyżej godziny 12, to doda pierwszą z tego dnia
                    } else if (list.get(j).getDateTime().getHour() <= 12) {
                        result.add(list.get(j));
                        j = list.size() - 1;
                    }
                }
            }
        }
        return result;
    }

    public Data getLast() {
        Data result = dataDAO.getRecentRecord();
        return result;
    }

    public List<Data> getSelectedRecordsService(String from, String to) {
        List<Data> selectedList = dataDAO.getSelectedRecords(from, to);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.from(dateTimeFormatter.parse(to));
        List<Data> result = new ArrayList<>();
        for (int i = selectedList.size(); i >= 0; i--) {
            int then = localDate.minusDays(i).getDayOfMonth();
            for (int j = 0; j <= selectedList.size() - 1; j++) {
                if (selectedList.get(j).getDateTime().getDayOfMonth() == then) {
                    if (selectedList.get(j).getDateTime().getHour() >= 12) {
                        result.add(selectedList.get(j));
                        j = selectedList.size() - 1;
                    } else if (selectedList.get(j).getDateTime().getHour() <= 12) {
                        result.add(selectedList.get(j));
                        j = selectedList.size() - 1;

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
