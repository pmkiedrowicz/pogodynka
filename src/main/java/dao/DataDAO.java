package dao;
import dto.Data;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataDAO {

    private static final String ID = "Id";
    private static final String TEMPERATURE = "Temperature";
    private static final String HUMIDITY = "Humidity";
    private static final String DATE = "DateTime";

    private static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/pogodynka?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String insertQuery = "INSERT INTO data (Temperature,Humidity,DateTime)VALUES(?,?,?)";

    private String login;
    private String password;

    public DataDAO(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public List<Data> getAll() {
        List<Data> result = new ArrayList<>();
        try {
            try (Connection con = DriverManager.getConnection(CONNECTION_STRING, login, password)) {
                try (Statement statement = con.createStatement()) {
                    String tableSql = "SELECT * FROM Data";
                    try (ResultSet resultSet = statement.executeQuery(tableSql)) {
                        while (resultSet.next()) {
                            Data data = Data.builder()
                                    .id(resultSet.getInt("id"))
                                    .temperature(resultSet.getDouble("temperature"))
                                    .humidity(resultSet.getDouble("humidity"))
                                    .dateTime(resultSet.getDate(DATE).toLocalDate())
                                    .build();
                            result.add(data);
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public Integer insert(Data data) {
        Integer result = null;
        try {
            try (Connection con = DriverManager.getConnection(CONNECTION_STRING, login, password)) {
                try (PreparedStatement statement = con.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS)) {
                    statement.setDouble(1, data.getTemperature());
                    statement.setDouble(2, data.getHumidity());
                    statement.setTimestamp(3, Timestamp.valueOf(data.getDateTime().atStartOfDay()));
                    statement.executeUpdate();
                    try (ResultSet rs = statement.getGeneratedKeys()) {
                        if (rs.next()) {
                            result = rs.getInt(1);
                        }
                    }
                    data.setId(result);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;

    }
}
