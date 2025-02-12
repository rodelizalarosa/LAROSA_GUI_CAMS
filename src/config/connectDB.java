
package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class connectDB {
    


    private Connection connect;

           // constructor to connect to our database
            public connectDB(){
                try{
                    connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/clinicSystem", "root", "");
                    System.out.println("OHAHA");
                }catch(SQLException ex){
                        System.out.println("Can't connect to database: "+ex.getMessage());
                }
            }
            
             // Method to return the connection
            public Connection getConnection() {
                return connect;
            }
            
            // Function to insert data
            public int insertData(String sql) {
                int result = 0;
                try (PreparedStatement pst = connect.prepareStatement(sql)) {
                    pst.executeUpdate();
                    System.out.println("Inserted successfully!");
                    result = 1;
                } catch (SQLException ex) {
                    System.err.println("Insert error: " + ex.getMessage());
                }
                return result;
            }

            // Function to retrieve data
            public ResultSet getData(String sql) throws SQLException {
                Statement stmt = connect.createStatement();
                return stmt.executeQuery(sql);
            }

            // Method to close the connection
            public void closeConnection() {
                try {
                    if (connect != null && !connect.isClosed()) {
                        connect.close();
                        System.out.println("Database connection closed.");
                    }
                } catch (SQLException ex) {
                    System.err.println("Error closing connection: " + ex.getMessage());
                }
            }
}
