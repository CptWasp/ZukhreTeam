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
        DataBaseHandler handler = new DataBaseHandler();

        exit_button.setOnAction(event -> {
            System.out.println("к заявкам");
            exit_button.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("prepodsView.fxml"));

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

        take_button.setOnAction(event -> {
//            handler.takeApplication("1", "3-203", "Фильтр",
//                    "Удлиннительный фильтр начал замыкать", "2020-06-06", "1");
            handler.takeApplication(name_field.getText(), auditorium_field.getText(), device_field.getText(), comment_area.getText(),
                    date_field.getText(), status_field.getText());
        });


    }
}
