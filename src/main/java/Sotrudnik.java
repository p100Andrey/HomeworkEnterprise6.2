import java.sql.*;

public class Sotrudnik {

    int idSotrudnik;
    String familiya;
    String imya;
    String dateRojdeniya;
    int telefon;
    String doljnosty;
    int oklad;

    public Sotrudnik(int idSotrudnik, String familiya, String imya, String dateRojdeniya, int telefon, String doljnosty, int oklad) {
        this.idSotrudnik = idSotrudnik;
        this.familiya = familiya;
        this.imya = imya;
        this.dateRojdeniya = dateRojdeniya;
        this.telefon = telefon;
        this.doljnosty = doljnosty;
        this.oklad = oklad;
        addSotrudnik(this);
    }

    public Sotrudnik() {

    }

    public void addSotrudnik(Sotrudnik sotrudnik) {
        try (Connection connection = DBConnection.getDBConnection();
             Statement statement = connection.createStatement()) {
            String sql;
            sql = "INSERT INTO SOTRUDNIK VALUES(" + idSotrudnik + ',' +
                    familiya + ',' + imya + ',' + dateRojdeniya + ',' +
                    telefon + ',' + doljnosty + ',' + oklad + ")";
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delSotrudnik(String familiya) {
        try (Connection connection = DBConnection.getDBConnection();
             Statement statement = connection.createStatement()) {
            String sql;
            sql = "DELETE FROM SOTRUDNIK WHERE familiya=" + familiya;
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void lookForSotrudnik(String familiyaSotrudnika) {
        try (Connection connection = DBConnection.getDBConnection();
             Statement statement = connection.createStatement()) {
            String sql;
            sql = "SELECT * FROM SOTRUDNIK WHERE familiya=" + familiyaSotrudnika;
            ResultSet resultSet = statement.executeQuery(sql);
            printQuery(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void printSotrudniks() {
        Connection connection = DBConnection.getDBConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String sql;
            sql = "SELECT * FROM SOTRUDNIK";

            ResultSet resultSet = statement.executeQuery(sql);
            printQuery(resultSet);
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null)
                    statement.close();
            } catch (SQLException se2) {
        }
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    private void printQuery(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            int id = resultSet.getInt("idsotrudnik");
            String familiya = resultSet.getString("familiya");
            String imya = resultSet.getString("imya");
            Date dateRojd = resultSet.getDate("dateRojdeniya");
            int telefon = resultSet.getInt("telefon");
            String doljnosty = resultSet.getString("doljnosty");
            int oklad = resultSet.getInt("oklad");

            System.out.print("ID Sotrudnik: " + id);
            System.out.print(", familiya: " + familiya);
            System.out.print(", imya: " + imya);
            System.out.print(", dateRojd: " + dateRojd);
            System.out.print(", telefon: " + telefon);
            System.out.print(", doljnosty: " + doljnosty);
            System.out.println(", oklad: " + oklad);
        }
    }
}
