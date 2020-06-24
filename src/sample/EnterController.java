package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EnterController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button auth_button;

    @FXML
    private TextField FIO_FIELD;

    @FXML
    private TextField PROFESSOIN_FEILD;

    @FXML
    private Button AuthAsTech;

    @FXML
    private Button Reg_button;

    @FXML
    private Button AuthAsProff;

    @FXML
    void initialize() {

        auth_button.setOnAction(event -> {
            String pass = PROFESSOIN_FEILD.getText();
            String login = FIO_FIELD.getText();

            if(pass.equals("1234") && login.equals("Бахарева Ольга Владимировна")){
                System.out.println("вход в систему как преподаватель");
                AuthAsProff.getScene().getWindow().hide();
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("OZDclientview.fxml"));

                try {
                    loader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Parent root = loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.showAndWait();
            }else{
                if (pass.equals("4321") && login.equals("Таепов Алмаз Торфимович")){
                    System.out.println("вход в систему как техник");
                    AuthAsTech.getScene().getWindow().hide();
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("OZDuserview.fxml"));

                    try {
                        loader.load();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    Parent root = loader.getRoot();
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root));
                    stage.showAndWait();
                }
            }

        });


        AuthAsProff.setOnAction(event -> {
            System.out.println("вход в систему как преподаватель");
            AuthAsProff.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("OZDclientview.fxml"));

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
        AuthAsTech.setOnAction(event -> {
            System.out.println("вход в систему как техник");
            AuthAsTech.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("OZDuserview.fxml"));

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

        Reg_button.setOnAction(event -> {
            System.out.println("Регистрация в системе");
            AuthAsTech.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("OZDSignUp.fxml"));

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
