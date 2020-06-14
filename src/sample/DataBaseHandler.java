package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataBaseHandler extends bdConnection {
    Connection dbConnection;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException{

        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName + "?verifyServerCertificate=false"+
                "&useSSL=false"+
                "&requireSSL=false"+
                "&useLegacyDatetimeCode=false"+
                "&amp"+
                "&serverTimezone=UTC";
        Class.forName("com.mysql.cj.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);

        return dbConnection;
    }






    public void takeApplication(String userId, String auditorium, String device, String comment, String date, String status){

//        INSERT INTO `applications` (`application_id`, `auditorium`, `device`, `comment`, `date`, `status`, `user_id`, `tec_id`)
//        VALUES (NULL, '203-5', 'утюг', 'не греет вообще и не брызгает вода', '2020-06-09', '2', '2', '1');


        String insert = "INSERT INTO `applications` (`application_id`, `auditorium`, `device`, `comment`, `date`, `status`, `user_id`, `tec_id`) VALUES"
                +" (NULL, '"+auditorium+"', '"+device+"', '"+comment+"', '"+date+"', '"+status+"', '"+userId+"', '1');";



        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}
