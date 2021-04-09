package Sample;

import java.awt.Label;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
public class Main extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		//Parent root = FXMLLoader.load(getClass().getResource("Sample.fxml"));
		GridPane root= new GridPane();
		root.setVgap(10);
		root.setHgap(10);
		root.setAlignment(Pos.CENTER);
		Label greeting = new Label("welcome to javafx");
		root.getChildren().add(greeting);
		primaryStage.setTitle("hello");
		primaryStage.setScene(new Scene(root,300, 275));
		primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}

}
