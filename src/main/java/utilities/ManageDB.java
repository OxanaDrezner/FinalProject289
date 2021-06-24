package utilities;

import java.sql.DriverManager;

public class ManageDB extends CommonOps {

    /*
    ############################################################################
    Method Name: openConnection
    Method Description: This Method Opens DB Connection with passed Parameters.
    Method Parameters: 3 values of String
    Method Return Type: void
    ############################################################################
     */
    public static void openConnection(String dbURL, String user, String password){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(dbURL, user, password);
            stmt = con.createStatement();
        } catch (Exception e) {
            System.out.println("Error Occurred while Connecting to DB, see details: "+e);
        }
    }

    /*
    #######################################################
    Method Name: closeConnection
    Method Description: This Method Closes DB Connection.
    Method Parameters: void
    Method Return Type: void
    #######################################################
     */
    public static void closeConnection(){
        try {
            con.close();
        } catch (Exception e) {
            System.out.println("Error Occurred while Closing Connection to DB, see details: "+e);
        }
    }
}
