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

    public void getApplication(String id){
        String techInsert = "UPDATE `applications` SET `status` = '0' WHERE `applications`.`application_id` = "+id+";";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(techInsert);
            prSt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


        //another query
    public void getDBID(String number){
        try {
            String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName + "?verifyServerCertificate=false"+
                    "&useSSL=false"+
                    "&requireSSL=false"+
                    "&useLegacyDatetimeCode=false"+
                    "&amp"+
                    "&serverTimezone=UTC";
            Connection conn = DriverManager.getConnection(connectionString,"root","root");
            Statement stmt = conn.createStatement();
            ResultSet rs;

            rs = stmt.executeQuery("SELECT * FROM `applications`");
                String numID = rs.getString("device");
                System.out.println(numID);
            conn.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }






}
