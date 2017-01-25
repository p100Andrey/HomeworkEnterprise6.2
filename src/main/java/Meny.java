import java.sql.*;

public class Meny {

    int idMeny;
    String nazvanieMeny;

    public Meny(int idMeny, String nazvanieMeny) {
        this.idMeny = idMeny;
        this.nazvanieMeny = nazvanieMeny;
        addNewMeny(this);
    }

    public Meny() {

    }

    public void addNewMeny(Meny meny) {
        try (Connection connection = DBConnection.getDBConnection();
             Statement statement = connection.createStatement()) {
            String sql;
            sql = "INSERT INTO MENY(" + idMeny + ',' + nazvanieMeny + ")";
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delMeny(String menyName) {
        try (Connection connection = DBConnection.getDBConnection();
             Statement statement = connection.createStatement()) {
            String sql;
            sql = "DELETE FROM MENY WHERE nazvanie=" + nazvanieMeny;
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addBlydoToMeny(String blydoName, String menyName) {
        try (Connection connection = DBConnection.getDBConnection();
             Statement statement = connection.createStatement()) {
            String sqlGetIdBlyda;
            sqlGetIdBlyda = "SELECT * FROM blydo WHERE nazvanie = " + blydoName;
            ResultSet resultSet = statement.executeQuery(sqlGetIdBlyda);
            resultSet.next();
            int idBlydo = resultSet.getInt("idBlydo");

            String sqlGetIdMeny;
            sqlGetIdMeny = "SELECT * FROM meny WHERE nazvaniemeny = " + menyName;
            resultSet = statement.executeQuery(sqlGetIdMeny);
            resultSet.next();
            int idMeny = resultSet.getInt("idMeny");

            String sql;
            sql = "INSERT INTO blyda_meny VALUES(2," + idMeny + "," + idBlydo +")";
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delBlydoFromMeny(Blydo blydo) {

    }

    public void lookForMeny(String menyName) {

    }

    public void printMeny() {

    }
}
