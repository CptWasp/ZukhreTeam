package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button go_button;

    @FXML
    private Button back_button;

    @FXML
    private Button exit_button;

    @FXML
    private Button take_button;

    @FXML
    private TextField name_field;

    @FXML
    private TextField auditorium_field;

    @FXML
    private TextField device_field;

    @FXML
    private TextField date_field;

    @FXML
    private TextField status_field;

    @FXML
    private TextArea comment_area;

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
