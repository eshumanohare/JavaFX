package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SwitchingScenes extends Application {

	Stage window;
	Scene scene1, scene2, scene3;
	
	public static void main(String[] args)  {
		launch();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		
		// Scene 1 objects
		Button button1 = new Button("Go to Scene 2");
		button1.setOnAction(e -> window.setScene(scene2));
		Label label1 = new Label("This is the Scene 1");
		
		// Scene 1 Layout is StackPane
		StackPane layout1 = new StackPane();
		layout1.getChildren().addAll(label1, button1);
		
		scene1 = new Scene(layout1, 600,500);
		window.setScene(scene1);
		window.setTitle("Switching Shit");
		window.show();
		
		// Scene2 Objects
		Button button2 = new Button("This Scene Sucks, Go to Scene 1");
		button2.setOnAction(e -> window.setScene(scene1));
		
		Button button3 = new Button("This Scene Sucks, Go to Scene 3");
		button3.setOnAction(e -> window.setScene(scene3));
		
		Label label2 = new Label("This is Scene 2");
		
		// Layout of Scene is StackPane
		VBox layout2 = new VBox();
		layout2.getChildren().addAll(label2,button2,button3);
		
		scene2 = new Scene(layout2, 600,500);
		
		// Objects of Scene 3
		Button button4 = new Button("Go back to Scene 2");
		button4.setOnAction(e -> window.setScene(scene2));
		Label label3 = new Label("This is the Scene 3");
		
		//layout of Scene 3 is VBox
		VBox layout3 = new VBox();
		layout3.getChildren().addAll(button4, label3);
	
		scene3 = new Scene(layout3,600,500);
	}

}
