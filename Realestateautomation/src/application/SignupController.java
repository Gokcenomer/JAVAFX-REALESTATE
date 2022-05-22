package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;

import com.MySql.Util.VeritabaniUtil;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class SignupController implements Initializable  {
	

	  Connection connection;
	  
      PreparedStatement statement;
	public SignupController() {
		connection=VeritabaniUtil.Connect();
	
		
	}

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn_ihacoount;

    @FXML
    private Button btn_signup;

    @FXML
    private TextField txt_confirmpassword;

    @FXML
    private TextField txt_email;

    @FXML
    private TextField txt_firstname;

    @FXML
    private TextField txt_lastname;
    
    @FXML
    private TextField txt_username;

    @FXML
    private TextField txt_password;

   
    @FXML
    void btn_ihaaccountClick(ActionEvent event) throws IOException {
    	 
    	
    		btn_ihacoount.getScene().getWindow().hide();
        	
        	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Login.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setResizable(false);
            stage.getIcons().add(new Image(getClass().getResourceAsStream("img/enter_24px.png")));
            Scene scene=new Scene(root);
            stage.setScene(scene);
            stage.show(); 
            scene.getStylesheets().add(getClass().getResource("mycss.css").toExternalForm());
    
    	
    }

    String alertTitle="Real Estate Automation";
    String alertHeader="Are you sure you want to continue?";
    @FXML
    void btn_signupClick(ActionEvent event) throws Exception {
    	
    	if (!(txt_username.getText().trim().equals("") && txt_password.getText().trim().equals("") && txt_confirmpassword.getText().trim().equals("")
    			&& txt_email.getText().trim().equals("") && txt_firstname.getText().trim().equals("") && txt_lastname.getText().trim().equals(""))) {
			
		
    	javafx.scene.control.Alert alert=new javafx.scene.control.Alert(AlertType.INFORMATION);
    	alert.setTitle(alertTitle);
    	alert.setHeaderText("You have Succesfully Signed Up!");
    	alert.setContentText("");
    	alert.showAndWait();
    	
    	insert(txt_firstname.getText(),txt_lastname.getText(),txt_email.getText(),VeritabaniUtil.MD5Encryption( txt_password.getText().trim()),txt_username.getText());

    	btn_signup.getScene().getWindow().hide();
    	
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Login.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setResizable(false);
        stage.getIcons().add(new Image(getClass().getResourceAsStream("img/enter_24px.png")));
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.show(); 
        scene.getStylesheets().add(getClass().getResource("mycss.css").toExternalForm());
    	}
    	else {
    		javafx.scene.control.Alert alert=new javafx.scene.control.Alert(AlertType.ERROR);
        	alert.setTitle(alertTitle);
        	alert.setHeaderText("Textfields cannot be blank!");
        	alert.setContentText("");
        	alert.show();
    		
		}
          
    
    }

    
    public void insert(String firstname,String lastname,String email,String password,String username) {
    	
        try{
       
            String sql="INSERT INTO users(First_Name,Last_Name,Email,Password,Username) VALUES (?,?,?,?,?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1,firstname);
            statement.setString(2,lastname);
            statement.setString(3,email);
            statement.setString(4,VeritabaniUtil.MD5Encryption(password));
            statement.setString(5,username);
           
            statement.executeUpdate();
    }catch (SQLException exception){
    	System.out.println(exception.getMessage().toString());
    }
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
