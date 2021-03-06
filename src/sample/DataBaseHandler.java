package sample;

import java.sql.*;

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
        String insert = "INSERT INTO `applications` (`application_id`, `auditorium`, `device`, `comment`, `date`, `status`, `user_id`) VALUES"
                +" (NULL, '"+auditorium+"', '"+device+"', '"+comment+"', '"+date+"', '"+status+"', '"+userId+"');";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void getApplication(String id){
        String techInsert = "UPDATE `applications` SET `status` = 'починен' WHERE `applications`.`application_id` = "+id+";";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(techInsert);
            prSt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public void SignUp(String FIO, String profession){
        String techInsert = "INSERT INTO `users` (`user_id`, `user_name`, `profession`) VALUES " +
                "(NULL, '"+FIO+"', '"+profession+"');";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(techInsert);
            prSt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }





}
