package sample;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import sample.User;

public class techController {
    private ObservableList<User> usersData = FXCollections.observableArrayList();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button go_button;

    @FXML
    private Button exit_button;

    @FXML
    private TableView<User> table_area;

    @FXML
    private TableColumn<User, String> td_fio_area;

    @FXML
    private TableColumn<User, String> td_auditorium_field;

    @FXML
    private TableColumn<User, String> td_device_field;

    @FXML
    private TableColumn<User, String> td_comment_field;

    @FXML
    private TableColumn<User, String> td_date_field;

    @FXML
    private TableColumn<User, String> td_status_field;

    @FXML
    private TableColumn<User, String> td_id_field;

    @FXML
    private TextField id_field;

    @FXML
    private Button accept_button;

    @FXML
    void initialize() {
        DataBaseHandler handler = new DataBaseHandler();

       exit_button.setOnAction(event -> {
           System.out.println("назад");
           exit_button.getScene().getWindow().hide();
           FXMLLoader loader = new FXMLLoader();
           loader.setLocation(getClass().getResource("authModal.fxml"));

           try {
               loader.load();
           } catch (IOException e) {
               e.printStackTrace();
           }

           Parent root = loader.getRoot();
           Stage stage = new Stage();
           stage.setScene(new Scene(root));
           stage.showAndWait();
       });
        go_button.setOnAction(event -> {
            DBWorker worker = new DBWorker();
            String selectQuery = "SELECT * FROM `applications`";
            try {
                Statement statement = worker.getConnection().createStatement();
                ResultSet resultSet = statement.executeQuery(selectQuery);

                    while (resultSet.next()) {
    //                    int id = resultSet.getInt(1);
    //                    System.out.println(id);
                        User user = new User();
                        user.setId(resultSet.getString(1));
                        user.setAuditorium(resultSet.getString(2));
                        user.setDevice(resultSet.getString(3));
                        user.setComment(resultSet.getString(4));
                        user.setDate(resultSet.getString(5));
                        user.setStatus(resultSet.getString(6));
                        usersData.add(new User("Бахарева Ольга Владимировна", user.getAuditorium(), user.getDevice(), user.getComment(), user.getDate(), user.getStatus(), user.getId()));
                    }

                    td_fio_area.setCellValueFactory(new PropertyValueFactory<User, String>("FIO"));
                    td_auditorium_field.setCellValueFactory(new PropertyValueFactory<User, String>("auditorium"));
                    td_device_field.setCellValueFactory(new PropertyValueFactory<User, String>("device"));
                    td_comment_field.setCellValueFactory(new PropertyValueFactory<User, String>("comment"));
                    td_date_field.setCellValueFactory(new PropertyValueFactory<User, String>("date"));
                    td_status_field.setCellValueFactory(new PropertyValueFactory<User, String>("status"));
                    td_id_field.setCellValueFactory(new PropertyValueFactory<User, String>("id"));

                    table_area.setItems(usersData);


            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        });


        accept_button.setOnAction(event -> {
            System.out.println("принятие заказа");
            handler.getApplication(id_field.getText());
        });


//        initData();
//        td_fio_area.setCellValueFactory(new PropertyValueFactory<User, String>("FIO"));
//        td_auditorium_field.setCellValueFactory(new PropertyValueFactory<User, String>("auditorium"));
//        td_device_field.setCellValueFactory(new PropertyValueFactory<User, String>("device"));
//        td_comment_field.setCellValueFactory(new PropertyValueFactory<User, String>("comment"));
//        td_date_field.setCellValueFactory(new PropertyValueFactory<User, String>("date"));
//        td_status_field.setCellValueFactory(new PropertyValueFactory<User, String>("status"));
//        td_id_field.setCellValueFactory(new PropertyValueFactory<User, String>("id"));
//
//        table_area.setItems(usersData);
    }

//    private void initData(){
//        usersData.add(new User("Ашрафуллин Айзат Рустамович", "3-432", "кофеварка", "сломался, течет", "2020-05-06", "1", "2"));
//    }


}
