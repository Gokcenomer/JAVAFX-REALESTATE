package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class MainFormController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn_addsection;

    @FXML
    private Button btn_listsection;

    @FXML
    void btn_addsectionClick(ActionEvent event) {
    	
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddSection.fxml"));
	        Parent pane;
			pane = (Parent) fxmlLoader.load();
			  Stage stage = new Stage();
		        stage.setResizable(false);
		        Scene scene=new Scene(pane);
		        stage.getIcons().add(new Image(getClass().getResourceAsStream("img/joyent_64px.png")));
		        stage.setScene(scene);
		        scene.getStylesheets().add(getClass().getResource("mycss.css").toExternalForm());
		        stage.show(); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      
        
    }

    @FXML
    void btn_listsection_Click(ActionEvent event) {

    	try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ListSection.fxml"));
	        Parent pane;
			pane = (Parent) fxmlLoader.load();
			  Stage stage = new Stage();
		        stage.setResizable(false);
		        Scene scene=new Scene(pane);
		        stage.setScene(scene);
		        scene.getStylesheets().add(getClass().getResource("mycss.css").toExternalForm());
		        stage.getIcons().add(new Image(getClass().getResourceAsStream("img/list.png")));
		        stage.show(); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void initialize() {
        
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
