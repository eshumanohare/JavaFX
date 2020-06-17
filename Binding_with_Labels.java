package application;
	
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
public class Main extends Application {

	Stage window;
	Scene scene;

	public static void main(String[] args) {
		launch(args);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		window.setTitle("Menu");
		ConfirmBox ob = new ConfirmBox();
		
		window.setOnCloseRequest(e -> {
			ob.display("Choose", "Do you want to quit?"); 
			if(ob.result == false)
				e.consume();           // e.consume consumes the root of the stack from where the initial calling started
		});
		
		TextField userInput = new TextField();
		userInput.setPromptText("Search");
		userInput.setMaxWidth(300);
		
		Label label1 = new Label("Welcome to the Site");
		Label label2 = new Label();
		
		// Real binding of label with userInput so that changes can be witnessed in real time
		label2.textProperty().bind(userInput.textProperty()); 
		
		HBox bottom = new HBox(label1);
		bottom.setAlignment(Pos.CENTER);
		
		VBox layout = new VBox(10);
		layout.getChildren().addAll(userInput, bottom, label2);
		layout.setAlignment(Pos.CENTER);
		scene = new Scene(layout,400,200);
		window.setScene(scene);
		window.show();
	
}
}
