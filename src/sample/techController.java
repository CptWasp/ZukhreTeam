package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class techController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button go_button;

    @FXML
    private Button exit_button;

    @FXML
    private TableView<?> table_area;

    @FXML
    private TableColumn<?, ?> td_fio_area;

    @FXML
    private TableColumn<?, ?> td_auditorium_field;

    @FXML
    private TableColumn<?, ?> td_device_field;

    @FXML
    private TableColumn<?, ?> td_comment_field;

    @FXML
    private TableColumn<?, ?> td_date_field;

    @FXML
    private TableColumn<?, ?> td_status_field;

    @FXML
    private TableColumn<?, ?> td_id_field;

    @FXML
    private TextField id_field;

    @FXML
    private Button accept_button;

    @FXML
    void initialize() {
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



    }
}
