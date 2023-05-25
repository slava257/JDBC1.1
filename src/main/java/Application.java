import java.sql.*;

public class Application {
          private   final   String  user = "postgres";

          private   final String password = "last1379";

          private   final String url = "jdbc:postgresql://localhost:5432/skypro";
          private final Connection connection;

    public Application(Connection connection) {
        this.connection = connection;
    }

    public Application findById(Integer id) {
        try (final Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM employee WHERE id =(?)")) {
            statement.setInt(1, 2);
            final ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String firstName = "Имя: " + resultSet.getString("first_name");
                System.out.println(firstName);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
