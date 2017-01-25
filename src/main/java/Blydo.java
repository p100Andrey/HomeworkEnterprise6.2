import java.sql.*;

public class Blydo {

    int idBlydo;
    String nazvanie;
    String kategoriya;
    double stoimost;
    double ves;

    public Blydo(int idBlydo, String nazvanie, String kategoriya, double stoimost, double ves) {
        this.idBlydo = idBlydo;
        this.nazvanie = nazvanie;
        this.kategoriya = kategoriya;
        this.stoimost = stoimost;
        this.ves = ves;
        addNewBlydo(this);
    }

    public Blydo() {

    }

    public void addNewBlydo(Blydo blydo) {
        try (Connection connection = DBConnection.getDBConnection();
             Statement statement = connection.createStatement()) {
            String sql;
            sql = "INSERT INTO BLYDO(" + idBlydo + ',' + nazvanie + ','
                    + kategoriya + ',' + stoimost + ',' + ves + ")";
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delBlydo(Blydo nazvanie) {
        try (Connection connection = DBConnection.getDBConnection();
             Statement statement = connection.createStatement()) {
            String sql;
            sql = "DELETE FROM BLYDO WHERE nazvanie=" + nazvanie;
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void lookForBlydo(String blydoName) {
        try (Connection connection = DBConnection.getDBConnection();
             Statement statement = connection.createStatement()) {
            String sql;
            sql = "SELECT * FROM BLYDO WHERE nazvanie=" + blydoName;
            ResultSet resultSet = statement.executeQuery(sql);
            printQuery(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void printBlydo() {
        try (Connection connection = DBConnection.getDBConnection();
             Statement statement = connection.createStatement()) {
            String sql;
            sql = "SELECT * FROM BLYDO";
            ResultSet resultSet = statement.executeQuery(sql);
            printQuery(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void printQuery(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            int id = resultSet.getInt("idBlydo");
            String nazvanie = resultSet.getString("nazvanie");
            String kategoriya = resultSet.getString("kategoriya");
            double stoimost = resultSet.getDouble("telefon");
            double ves = resultSet.getDouble("ves");

            System.out.print("ID Blydo: " + id);
            System.out.print(", nazvanie: " + nazvanie);
            System.out.print(", kategoriya: " + kategoriya);
            System.out.print(", stoimost: " + stoimost);
            System.out.print(", ves: " + ves);
        }
    }
}
