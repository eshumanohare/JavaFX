package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LogIn  extends Application {
	Scene scene;
	Stage window;
	
	public static void main(String[] args){
		launch();
	}
	
	@Override
	public void start(Stage arg0) throws Exception {
		
		window = arg0;
		window.setTitle("Log-in or Fyck Off");
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10,10,10,10));
		grid.setVgap(10);
		grid.setHgap(8);
		
		Label username = new Label("Username:");
		//username.setId("bold-label");
		GridPane.setConstraints(username, 0, 0);
		
		TextField name = new TextField("Eshu");
		GridPane.setConstraints(name, 1, 0);
		
		Label password = new Label("Password:");
		GridPane.setConstraints(password, 0, 1);
		
		PasswordField pass = new PasswordField();
		pass.setPromptText("password");
		GridPane.setConstraints(pass, 1, 1);
		
		Button login = new Button("Log In");
		GridPane.setConstraints(login, 1, 2);
		
		Button signup = new Button("Sign Up");
		GridPane.setConstraints(signup, 1, 3);
		signup.getStyleClass().add("button-blue");
		
		grid.getChildren().addAll(username,name,password,pass,login,signup);
		scene = new Scene(grid, 400,400);
		scene.getStylesheets().add("viper.css");
		window.setScene(scene);
		window.show();
	
	}
}
