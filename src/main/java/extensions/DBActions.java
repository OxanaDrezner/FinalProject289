package extensions;

import io.qameta.allure.Step;
import utilities.CommonOps;

import java.util.ArrayList;
import java.util.List;

public class DBActions extends CommonOps {

    @Step("Get Credentials from Database")
    public static List<String> getCredentials(String query){
        List<String> credentials = new ArrayList<>();
        try {
            rs = stmt.executeQuery(query);
            rsmd = rs.getMetaData();
            while (rs.next()) {
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    credentials.add(rs.getString(i));
                }
            }
        } catch (Exception e) {
            System.out.println("Error Occurred while trying to retrieve Data from DB, see details: "+e);
        }
        return credentials;
    }
}
