package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;

import com.MySql.Util.VeritabaniUtil;

import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

public class LoginController  {

	Connection connection;
	  
    PreparedStatement statement;
	public LoginController(){
		connection=VeritabaniUtil.Connect();
		
		
	}
	
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn_login;

    @FXML
    private Button btn_signup;

    @FXML
    private TextField txt_login;

    @FXML
    private PasswordField txt_password;
    public static String session;
   
    @FXML
    void btn_loginClick(ActionEvent event)  {
    	
    	
			
		
    	int control = LoginCheck(txt_login.getText(),VeritabaniUtil.MD5Encryption(txt_password.getText().trim()));
    	if (control==0) {
    		
    		
    		try{
    			 session=txt_login.getText().trim();
    			 javafx.scene.control.Alert alert=new javafx.scene.control.Alert(AlertType.INFORMATION);
    			 String alertTitle="Real Estate Automation";
    			    String alertHeader=session  + " You have succesfully logged in!";
    	    	 alert.setTitle(alertTitle);
    	    	 alert.setHeaderText(alertHeader);
    	    	Optional<ButtonType> result= alert.showAndWait();
    	    	if (result.isPresent() && result.get()==ButtonType.OK)
    	    	{
    	    		 Parent root = FXMLLoader.load(getClass().getResource("MainForm.fxml"));
    	                Stage stage = new Stage();
    	                Scene scene = new Scene(root);
//    	                stage.initStyle(StageStyle.UNDECORATED);
    	                stage.getIcons().add(new Image(getClass().getResourceAsStream("img/form_64px.png")));
    	                stage.setScene(scene);
    	                stage.show();
    	                
    	                scene.getStylesheets().add(getClass().getResource("mycss.css").toExternalForm());
    	    	}
               
               
            }catch (IOException exception) {
                System.out.println("Hata Verildi000");
                System.out.println("Error : "+exception.getMessage());
            }
            Stage stage = (Stage)btn_login.getScene().getWindow();
            stage.close();
        } else {
            System.out.println("hatali giris");
        }

    	}
    	   

    public int LoginCheck(String username,String password ){
    	
        ResultSet resultSet;
        try{
        	
        	String sql="select * from users where username=? and password=?  ";
            statement = connection.prepareStatement(sql);
            statement.setString(1,username);
            statement.setString(2,VeritabaniUtil.MD5Encryption(password));
            
            
            
         
            resultSet = statement.executeQuery();
           
            
            
            if(resultSet.next()) {
                return 0;
            } else {
                return 1;
            }
        }catch (SQLException exception){
            System.out.println(exception.getMessage().toString());
            return 1;
        }
    }
        
    

    @FXML
    void btn_signupClick(ActionEvent event) throws IOException {

    	
    	btn_signup.getScene().getWindow().hide();
    	
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Signup.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setResizable(false);
        stage.getIcons().add(new Image(getClass().getResourceAsStream("img/sign.png")));
        Scene scene=new Scene(root1);
        stage.setScene(scene);
        scene.setFill(Color.TRANSPARENT);
        stage.show(); 
        scene.getStylesheets().add(getClass().getResource("mycss.css").toExternalForm());
        
    }
    
    @FXML
    private ImageView img;
    @FXML
    void initialize() {
    	

    	img.setImage(new Image(getClass().getResourceAsStream("img/gandalf.jpg")));
    	TranslateTransition translate= new TranslateTransition();
    	translate.setNode(img);
    	translate.setDuration(Duration.millis(1000));
    	translate.setCycleCount(TranslateTransition.INDEFINITE);
    	translate.setByY(100);
    	translate.setAutoReverse(true);
    	translate.play();
    	
    	
    	
    }

	

}
