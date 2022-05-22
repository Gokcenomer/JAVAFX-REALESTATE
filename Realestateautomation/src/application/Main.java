package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.fxml.FXMLLoader;


public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("ListSection.fxml"));
			Scene scene = new Scene(root);
			 scene.getStylesheets().add(getClass().getResource("mycss.css").toExternalForm());
			 scene.setFill(Color.TRANSPARENT);
			primaryStage.setScene(scene);
			primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("img/list.png")));
			
			primaryStage.setResizable(true);
//			 primaryStage.initStyle(StageStyle.TRANSPARENT);
//			 scene.setFill(Color.TRANSPARENT);
//			primaryStage.setTitle("ListSection");
			
			
			primaryStage.show();
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
