import java.sql.*;

public class DBConnection {

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "org.postgresql.Driver";
    static final String DB_URL = "jdbc:postgresql://localhost:5432/Restaurant";

    //  Database credentials
    static final String USER = "postgres";
    static final String PASS = "31388";

    public static void main(String[] args) {
        Meny meny = new Meny();
        meny.addBlydoToMeny("\'sup\'", "\'pervieBlyuda\'");
//        meny.addBlydoToMeny("\'sup\'", "\'pervieBlyuda\'");

//        Sotrudnik sotrudnik = new Sotrudnik();
//        sotrudnik.lookForSotrudnik("\'Pupkin\'");
//        sotrudnik.delSotrudnik("\'Sidorof\'");
//        sotrudnik.printSotrudniks();
//        Sotrudnik sotrudnik1 = new Sotrudnik(5, "\'Venikov\'", "\'Ivan\'", "\'1994-04-04\'", 12348, "\'skladovik\'", 4800);
    }

    public static Connection getDBConnection() {
        Connection dbConnection = null;
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            dbConnection = DriverManager.getConnection(DB_URL, USER, PASS);
            return dbConnection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dbConnection;
    }

    public static void getSotrudnik() {
        Connection conn = null;
        Statement stmt = null;
        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM sotrudnik";
            ResultSet rs = stmt.executeQuery(sql);

            //STEP 5: Extract data from result set
            while (rs.next()) {
                //Retrieve by column name
                int id = rs.getInt("idsotrudnik");
                String familiya = rs.getString("familiya");
                String imya = rs.getString("imya");

                //Display values
                System.out.print("ID Sotrudnik: " + id);
                System.out.print(", familiya: " + familiya);
                System.out.println(", imya: " + imya);
            }
            //STEP 6: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Goodbye!");
    }

}
