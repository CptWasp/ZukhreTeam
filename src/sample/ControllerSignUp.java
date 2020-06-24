package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.sun.org.apache.xpath.internal.functions.FuncFalse;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ControllerSignUp {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button exit_button;

    @FXML
    private Button sigup_button;

    @FXML
    private TextField FIO_field;

    @FXML
    private TextField profession_field;

    @FXML
    private Label signLabel;

    @FXML
    void initialize() {
        signLabel.setVisible(false);
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

        sigup_button.setOnAction(event -> {
            DataBaseHandler handler = new DataBaseHandler();
            handler.SignUp(FIO_field.getText(), profession_field.getText());
            signLabel.setVisible(true);
        });


    }
}
