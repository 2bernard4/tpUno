package bernardoChiletto.bdd;

import bernardoChiletto.models.Human;

import java.sql.*;
import java.util.Optional;

public class Jbdc {

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/tp1";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "";


    public void insertBdd(Optional<Human> viking){
        Connection conn = null;
        Statement stmt = null;
        try{
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query

            stmt = conn.prepareStatement("INSERT INTO winners(nameWinner, totalDrinks) "
                    + "VALUES(?,?)");

            // Insert first record
            ((PreparedStatement) stmt).setString(1, viking.get().getName());
            ((PreparedStatement) stmt).setInt(2, viking.get().getDrinks());
            ((PreparedStatement) stmt).executeUpdate();


        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    conn.close();
            }catch(SQLException se){
            }// do nothing
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
    }
}