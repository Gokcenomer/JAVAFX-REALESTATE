package application;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;

import com.MySql.Util.VeritabaniUtil;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class AddSection {
	
	  Connection connection;
	  
	    PreparedStatement statement;
	public AddSection() {
	connection=VeritabaniUtil.Connect();
	}
	
	@FXML
	private ImageView image;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnSave;

    @FXML
    private Button btn_addPicture;

    @FXML
    private CheckBox checkboxFurnished;

    @FXML
    private ComboBox<String> cmboSelectCity;

    @FXML
    private ComboBox<String> cmboSelectCountry;

    @FXML
    private ComboBox<String> cmboSelectDistrict;

    @FXML
    private ComboBox<String> cmboSelectHHS;

    @FXML
    private ComboBox<String> cmboSelectNoR;

    @FXML
    private DatePicker datepickerBuildAge;

    @FXML
    private RadioButton radioforRent;

    @FXML
    private RadioButton radioforSell;

    @FXML
    private TextField txtPrice;

    @FXML
    private TextField txtSqrMeters;

    @FXML
    private TextArea txtareaAdress;
    
    @FXML
    private AnchorPane anchorList;
    
    ToggleGroup forradio=new ToggleGroup();
    
    String alertTitle="Real Estate Automation";
    String alertHeader="you have successfully registered!";
    @FXML
    void btnSaveClick(ActionEvent event) {
    	ToggleButton selected=(ToggleButton) forradio.getSelectedToggle();
    	

    	try {
    		if (!(txtareaAdress.getText().trim().equals("") && txtPrice.getText().trim().equals("") 
    				&& txtSqrMeters.getText().trim().equals(""))) {
    			
    			
    		
        	 
        		 javafx.scene.control.Alert alert=new javafx.scene.control.Alert(AlertType.INFORMATION);
            	 alert.setTitle(alertTitle);
            	 alert.setHeaderText(alertHeader);
            	Optional<ButtonType> result= alert.showAndWait();
            	if (result.isPresent() && result.get()==ButtonType.OK)
            	{
            		java.sql.Date sqlDate =java.sql.Date.valueOf(datepickerBuildAge.getValue());
                	insert(cmboSelectCity.getSelectionModel().getSelectedItem(), cmboSelectCountry.getSelectionModel().getSelectedItem(), cmboSelectDistrict.getSelectionModel().getSelectedItem(), cmboSelectNoR.getSelectionModel().getSelectedItem(), cmboSelectHHS.getSelectionModel().getSelectedItem(),
                			checkboxFurnished.isSelected(), txtareaAdress.getText().trim(), Integer.parseInt(txtPrice.getText()), Integer.parseInt(txtSqrMeters.getText()), sqlDate, selected.getText().trim());
                	clear();
            	}
            	
    		 
        	}
        	else {
        		 javafx.scene.control.Alert alert=new javafx.scene.control.Alert(AlertType.INFORMATION);
            	 alert.setTitle(alertTitle);
            	 alert.setHeaderText("Textfields cannot be blank!!!");
            	 alert.showAndWait();
    			
    		}
		} catch (Exception e) {
			// TODO: handle exception
		}
    	
    }

    
    @FXML
    void btn_addPictureClick(ActionEvent event) throws IOException {
    	btn_addPicture.getScene().getWindow().hide();
    	
    }

    @FXML
    void checkboxFurnishedClick(ActionEvent event) {

    }

    @FXML
    void cmboSelectCityClick(ActionEvent event) {

    }

    @FXML
    void cmboSelectCountryClick(ActionEvent event) {

    }

    @FXML
    void cmboSelectDistrictClick(ActionEvent event) {

    }

    @FXML
    void cmboSelectHHSClick(ActionEvent event) {

    }

    @FXML
    void cmboSelectNoRClick(ActionEvent event) {

    }

    @FXML
    void radioforRentClick(ActionEvent event) {
    	forradio.setUserData("For Rent");
    }

    @FXML
    void radioforSellClick(ActionEvent event) {
    	forradio.setUserData("radioforSell");
    }
  
    
    public void insert(String city,String country,String district,String numberofrooms,
    		String homeheatingsystem, boolean furnished,String adress,int price,int squaremeters,Date buildingage,String situation)
    {	
    	
         try{
             
             String sql = "insert into estate (City,Country,District,NumberOfRooms,HomeHeatingSystem,Furnished,Adress,Price,SquareMeters,BuildingAge,Situation) values (?,?,?,?,?,?,?,?,?,?,?)";
             statement = connection.prepareStatement(sql);
             statement.setString(1,city);
             statement.setString(2,country);
             statement.setString(3,district);
             statement.setString(4,numberofrooms);
             statement.setString(5,homeheatingsystem);
             statement.setBoolean(6,furnished);
             statement.setString(7,adress);
             statement.setInt(8,price);
             statement.setInt(9,squaremeters);
             statement.setDate(10,buildingage);
             statement.setString(11,situation);
            
             statement.executeUpdate();
         }catch (SQLException exception){
        	 System.out.println(exception.getMessage().toString());
         }
    }
    

    
    public  void clear() {
    	cmboSelectCity.getSelectionModel().clearSelection();
    	cmboSelectCountry.getSelectionModel().clearSelection();
    	cmboSelectDistrict.getSelectionModel().clearSelection();
    	cmboSelectNoR.getSelectionModel().clearSelection();
    	cmboSelectHHS.getSelectionModel().clearSelection();
    	checkboxFurnished.setSelected(false);
    	txtareaAdress.clear();
    	txtPrice.clear();
    	datepickerBuildAge.setValue(null);
    	txtSqrMeters.clear();
    	forradio.getSelectedToggle().setSelected(false);
    }
    @FXML
    void initialize() {
        
    	 radioforRent.setToggleGroup(forradio);
         radioforSell.setToggleGroup(forradio);
        ObservableList<String> city=FXCollections.observableArrayList("Mardin","Adana","Trabzon");
        ObservableList<String> country=FXCollections.observableArrayList("Artuklu","Ceyhan","Arakli");
        ObservableList<String> district=FXCollections.observableArrayList("13 Mart","Adana Mahallesi","Trabzon Mahallesi");
        ObservableList<String> numberOfRooms=FXCollections.observableArrayList("1+0","1+1","2+1","3+1");
        ObservableList<String> homeHeatingSystem=FXCollections.observableArrayList("Furnaces","Boilers","Heat Pumps","Electric Space Heaters");
        cmboSelectCity.getItems().addAll(city);
        cmboSelectCountry.getItems().addAll(country);
        cmboSelectDistrict.getItems().addAll(district);
        cmboSelectNoR.getItems().addAll(numberOfRooms);
        cmboSelectHHS.getItems().addAll(homeHeatingSystem);

    }

}
