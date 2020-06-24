package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SignUpController implements Initializable {

    @FXML
    private JFXTextField username;

    @FXML
    private JFXRadioButton male;

    @FXML
    private ToggleGroup gender;

    @FXML
    private JFXRadioButton female;

    @FXML
    private JFXRadioButton other;

    @FXML
    private JFXPasswordField password;

    @FXML
    private JFXPasswordField confirmpass;

    @FXML
    private JFXButton signUp;

    @FXML
    private JFXButton signIn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("");
    }

    @FXML
    public void SignInAction(ActionEvent e) throws IOException{
        signUp.getScene().getWindow().hide();

        Stage signInStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("MainSignIn.fxml"));
        signInStage.setScene(new Scene(root));
        signInStage.show();
        signInStage.setResizable(false);
    }
}
