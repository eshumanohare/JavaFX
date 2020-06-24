package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{

    // fx_id used in the SignIn page
    @FXML
    private JFXTextField username;
    @FXML
    private JFXPasswordField password;
    @FXML
    private JFXCheckBox remember;
    @FXML
    private JFXButton signIn;
    @FXML
    private JFXButton signUp;
    @FXML
    private JFXButton forgot;
    @FXML
    private ImageView progress_gif;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        progress_gif.setVisible(false);
        username.setStyle("fx-text-inner-color : #a0a2ab");
        password.setStyle("fx-text-inner-color : #a0a2ab");
    }

    @FXML
    public void loginAction(ActionEvent e){
        progress_gif.setVisible(true);
        PauseTransition pause = new PauseTransition();
        pause.setDelay(Duration.seconds(3));
        pause.setOnFinished(ev -> {
            System.out.println("Login Successfully");
        });
        pause.play();
    }

    public void signUpAction(ActionEvent e1) throws IOException {
        // when the signUp button is pressed
        // Close the current stage
        // open a new stage with SignUp fxml loader
        signIn.getScene().getWindow().hide();

        Stage signUpStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
        signUpStage.setScene(new Scene(root));
        signUpStage.show();
        signUpStage.setResizable(false);

    }

}
