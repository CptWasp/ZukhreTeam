package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

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
        assert go_button != null : "fx:id=\"go_button\" was not injected: check your FXML file 'OZDuserview.fxml'.";
        assert exit_button != null : "fx:id=\"exit_button\" was not injected: check your FXML file 'OZDuserview.fxml'.";
        assert table_area != null : "fx:id=\"table_area\" was not injected: check your FXML file 'OZDuserview.fxml'.";
        assert td_fio_area != null : "fx:id=\"td_fio_area\" was not injected: check your FXML file 'OZDuserview.fxml'.";
        assert td_auditorium_field != null : "fx:id=\"td_auditorium_field\" was not injected: check your FXML file 'OZDuserview.fxml'.";
        assert td_device_field != null : "fx:id=\"td_device_field\" was not injected: check your FXML file 'OZDuserview.fxml'.";
        assert td_comment_field != null : "fx:id=\"td_comment_field\" was not injected: check your FXML file 'OZDuserview.fxml'.";
        assert td_date_field != null : "fx:id=\"td_date_field\" was not injected: check your FXML file 'OZDuserview.fxml'.";
        assert td_status_field != null : "fx:id=\"td_status_field\" was not injected: check your FXML file 'OZDuserview.fxml'.";
        assert td_id_field != null : "fx:id=\"td_id_field\" was not injected: check your FXML file 'OZDuserview.fxml'.";
        assert id_field != null : "fx:id=\"id_field\" was not injected: check your FXML file 'OZDuserview.fxml'.";
        assert accept_button != null : "fx:id=\"accept_button\" was not injected: check your FXML file 'OZDuserview.fxml'.";

    }
}
