package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.ResourceBundle;

import com.MySql.Util.VeritabaniUtil;
import com.mysql.cj.protocol.Resultset;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
public class ListSectionController {
	
	
	Connection connection;
	  
    PreparedStatement statement;
    public ListSectionController() {
    	connection=VeritabaniUtil.Connect();
    	}

    @FXML
    private TableColumn<Table_Estate, String> Adress;

    @FXML
    private TableColumn<Table_Estate, String> BuildingAge;

    @FXML
    private TableColumn<Table_Estate, String> City;

    @FXML
    private TableColumn<Table_Estate, String> Country;

    @FXML
    private TableColumn<Table_Estate, String> District;

    @FXML
    private TableColumn<Table_Estate, Integer> Furnished;

    @FXML
    private TableColumn<Table_Estate, String> HomeHeatingSystem;

    @FXML
    private TableColumn<Table_Estate, Integer> ID;

    @FXML
    private TableColumn<Table_Estate, String> NumberOfRooms;

    @FXML
    private TableColumn<Table_Estate, Integer> Price;

    @FXML
    private TableColumn<Table_Estate, String> Situation;

    @FXML
    private TableColumn<Table_Estate, Integer> SquareMeters;
    @FXML
    private TableView<Table_Estate> tableViewList;
    @FXML
    private ResourceBundle resources;

    @FXML
    private Button btnLogin;
    
    @FXML
    private URL location;
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
    private TextArea txtareaAdress;

    @FXML
    private AnchorPane anchorListSection;
    @FXML
    private DatePicker datepickerMax;

    @FXML
    private DatePicker datepickerMin;

    @FXML
    private TextField txtMaxPrice;

    @FXML
    private TextField txtMaxSqrMeters;

    @FXML
    private TextField txtMinSqrMeters;

    @FXML
    private TextField txtMınPrice;

    @FXML
    private ComboBox<String> cmboFurnished;
    @FXML
    private Button btnDelete;

    @FXML
    private Button btnUpdate;
    
    @FXML
    private TextField txtPrice;

    @FXML
    private TextField txtSqrMeters;

    @FXML
    private TextField txtdate;

    
    @FXML
    void checkboxFurnishedClick(ActionEvent event) {
    	String furnished;
    	if (cmboFurnished.getSelectionModel().getSelectedIndex()==0) {
    		furnished="YES";
		}
    	else {
    		furnished="NO";
		}
    	String sql="select * from estate where Furnished==furnished";
    	buildData(tableViewList,sql);
    }

    @FXML
    void cmboSelectCityClick(ActionEvent event) {

    	String sql="select * from estate where City='"+cmboSelectCity.getSelectionModel().getSelectedItem()+"'";
    	buildData(tableViewList,sql);
    }

    @FXML
    void cmboSelectCountryClick(ActionEvent event) {
    	String sql="select * from estate where Country='"+cmboSelectCountry.getSelectionModel().getSelectedItem()+"'";
    	buildData(tableViewList,sql);
    }

    @FXML
    void cmboSelectDistrictClick(ActionEvent event) {
    	String sql="select * from estate where District='"+cmboSelectDistrict.getSelectionModel().getSelectedItem()+"' ";
    	buildData(tableViewList,sql);
    }

    @FXML
    void cmboSelectHHSClick(ActionEvent event) {

    	String sql="select * from estate where HomeHeatingSystem='"+cmboSelectHHS.getSelectionModel().getSelectedItem()+"' ";
    	buildData(tableViewList,sql);
    }

    @FXML
    void cmboSelectNoRClick(ActionEvent event) {
    	String sql="select * from estate where NumberOfRooms='"+cmboSelectNoR.getSelectionModel().getSelectedItem()+"'";
    	buildData(tableViewList,sql);
    }

    @FXML
    private Button btnSearch;
    @FXML
    void radioforRentClick(ActionEvent event) {
    	forradio.setUserData("For Rent");
    	String sql="select * from estate where Situation='"+forradio.getUserData().toString()+"' ";
    	buildData(tableViewList, sql);
    	
    }

    @FXML
    void radioforSellClick(ActionEvent event) {
    	forradio.setUserData("For Sell");
    	String sql="select * from estate where Situation='"+forradio.getUserData().toString()+"' ";
    	buildData(tableViewList, sql);
    }
    @FXML
    void Search(ActionEvent event) {
    	try {
    		String sql="select * from estate where Price> '"+Integer.parseInt(txtMınPrice.getText())+"' and Price<'"+Integer.parseInt(txtMaxPrice.getText())+"'"
        			+ "and SquareMeters > '"+Integer.parseInt(txtMinSqrMeters.getText())+"' and SquareMeters<'"+Integer.parseInt(txtMaxSqrMeters.getText())+"'"
        					+ "and BuildingAge > '"+ datepickerMin.getValue()+ "' and  BuildingAge< '"+ datepickerMax.getValue()+"' " ;
        	buildData(tableViewList, sql);
		} catch (Exception e) {
			// TODO: handle exception
		}

    	
    	
    	
    	
    
    	
    }
    @FXML
    void Login(ActionEvent event) {
    	
    	try {
    		btnLogin.getScene().getWindow().hide();
        	
        	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Login.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setResizable(false);
            Scene scene=new Scene(root);
            stage.getIcons().add(new Image(getClass().getResourceAsStream("img/enter_24px.png")));
            scene.setFill(Color.TRANSPARENT);
            stage.setScene(scene);
            scene.getStylesheets().add(getClass().getResource("mycss.css").toExternalForm());
            stage.show(); 
		} catch (Exception e) {
			// TODO: handle exception
		}
    	
    }
    
    @FXML
    private Button btnClear;
    ToggleGroup forradio=new ToggleGroup();
    String alertTitle="Real Estate Automation";
    String alertHeader="Are you sure you want to continue?";
    @FXML
    void Delete(ActionEvent event) {
    	try {
    		  javafx.scene.control.Alert alert=new javafx.scene.control.Alert(AlertType.CONFIRMATION);
    		   	 alert.setTitle(alertTitle);
    		   	 alert.setHeaderText(alertHeader);
    		   	Optional<ButtonType> result= alert.showAndWait();
    		   	if (result.isPresent() && result.get()==ButtonType.OK)
    		   	{
    		   		deleteEstate();
    		    	buildData(tableViewList,"select * from estate");
    		    	clear();
    		   	}
    		   	else {
    		   		alert.setAlertType(AlertType.INFORMATION);
    				alert.setHeaderText("");
    				alert.setContentText("Cancelled!");
    				alert.show();
    			}
		} catch (Exception e) {
			// TODO: handle exception
		}
  
    	
    }
    @FXML
    void Clear(ActionEvent event) {
    	
    	try {
    		clear();
		} catch (Exception e) {
			// TODO: handle exception
		}
    }

    public boolean checkedFurnished() {
   	if (cmboFurnished.getSelectionModel().getSelectedIndex()==0) {
		return true;
	}
   	else {
		return false;
	}
    }
    
    @FXML
    void Update(ActionEvent event) {
    	try {
    		javafx.scene.control.Alert alert=new javafx.scene.control.Alert(AlertType.CONFIRMATION);
        	alert.setAlertType(AlertType.INFORMATION);
     		alert.setHeaderText("");
     		alert.setContentText("Updated!");
     		alert.show();
        	ToggleButton selected=(ToggleButton) forradio.getSelectedToggle();
        	
     
        	java.sql.Date sqlDate =java.sql.Date.valueOf(datepickerBuildAge.getValue());
        	update(cmboSelectCity.getSelectionModel().getSelectedItem(), cmboSelectCountry.getSelectionModel().getSelectedItem(), cmboSelectDistrict.getSelectionModel().getSelectedItem(), cmboSelectNoR.getSelectionModel().getSelectedItem(), cmboSelectHHS.getSelectionModel().getSelectedItem(),
        			checkedFurnished(), txtareaAdress.getText(), Integer.parseInt(txtPrice.getText()), Integer.parseInt(txtSqrMeters.getText()), sqlDate,selected.getText());
        	buildData(tableViewList,"select * from estate");
        	clear();
		} catch (Exception e) {
			// TODO: handle exception
		}
    	
    	
    }
    
   
    public  void clear() {
    	cmboSelectCity.getSelectionModel().clearSelection();
    
    	cmboSelectCountry.getSelectionModel().clearSelection();
    	
    	cmboSelectDistrict.getSelectionModel().clearSelection();
    	
    	
    	cmboSelectNoR.getSelectionModel().clearSelection();
    	cmboSelectHHS.getSelectionModel().clearSelection();
    	cmboFurnished.getSelectionModel().clearSelection();
    	txtareaAdress.clear();
    	txtPrice.clear();
    	datepickerBuildAge.setValue(null);
    	txtSqrMeters.clear();
    	forradio.getSelectedToggle().setSelected(false);
    	buildData(tableViewList, "select * from estate");
    	
    }
	public void buildData(TableView table,String sql) {
		
		
		
		ObservableList<Table_Estate> data=FXCollections.observableArrayList();
		try {
			 statement = connection.prepareStatement(sql);
			 ResultSet rs=statement.executeQuery();
			 while (rs.next()) {
				 data.add(new Table_Estate(
						 rs.getInt("ID"),
						 rs.getString("City"),
						 rs.getString("Country"),
						 rs.getString("District"),
						 rs.getString("NumberOfRooms"),
						 rs.getString("HomeHeatingSystem"),
						 rs.getInt("Furnished"),
						 rs.getString("Adress"),
						 rs.getInt("Price"),
						 rs.getInt("SquareMeters"),
						 rs.getString("BuildingAge"),
						 rs.getString("Situation")
						 ));
				
				 
			}
			 ID.setCellValueFactory(new PropertyValueFactory<>("ID") );
			 City.setCellValueFactory(new PropertyValueFactory<>("City") );
			 Country.setCellValueFactory(new PropertyValueFactory<>("Country") );
			 District.setCellValueFactory(new PropertyValueFactory<>("District") );
			 NumberOfRooms.setCellValueFactory(new PropertyValueFactory<>("NumberOfRooms") );
			 HomeHeatingSystem.setCellValueFactory(new PropertyValueFactory<>("HomeHeatingSystem") );
			 Furnished.setCellValueFactory(new PropertyValueFactory<>("Furnished") );
			 Adress.setCellValueFactory(new PropertyValueFactory<>("Adress") );
			 Price.setCellValueFactory(new PropertyValueFactory<>("Price") );
			 SquareMeters.setCellValueFactory(new PropertyValueFactory<>("SquareMeters") );
			 BuildingAge.setCellValueFactory(new PropertyValueFactory<>("BuildingAge") );
			 Situation.setCellValueFactory(new PropertyValueFactory<>("Situation") );
			 tableViewList.setItems(data);
			 
			 
		} catch (Exception e) {
			System.out.println(e.getMessage().toString());
		}
    }
    
    public void update(String city,String country,String district,
    		String numberofrooms,String homeheatingsystem, boolean furnished
    		,String adress,int price,int squaremeters,Date buildingage,String situation)
    {	
    	
    	Table_Estate record= new Table_Estate();
		record=(Table_Estate) tableViewList.getItems().get(tableViewList.getSelectionModel().getSelectedIndex());
    	 System.out.println(record);
         try{
            
             String sql = "UPDATE  `estate` SET "
            		 + "`city`=?,"
            		 + "`country`=?,"
            		 + "`district`=?,"
            		 + "`numberofrooms`=?,"
            		 + "`homeheatingsystem`=?,"
            		 + "`furnished`=?,"
            		 + "`adress`=?,"
            		 + "`price`=?,"
            		 + "`squaremeters`=?,"
            		 + "`buildingage`=?,"
            		 + "`situation`=?  WHERE ID = '"+record.getID()+"'";
             	
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
             System.out.println(record);
            
             statement.executeUpdate();
             
         }catch (SQLException exception){
             System.out.println(exception.getMessage().toString());
         }
    }
  
	public void deleteEstate()
    {
    	
    	
    	Table_Estate record= new Table_Estate();
		record=(Table_Estate) tableViewList.getItems().get(tableViewList.getSelectionModel().getSelectedIndex());
    	String sql="delete from estate where ID=? ";
    	try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1,record.getID());
			statement.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
    }
    void setText() {
    	
    	tableViewList.setOnMouseClicked((MouseEvent event) -> {
            if (event.getButton().equals(MouseButton.PRIMARY) && event.getClickCount() == 2){
                Table_Estate record= new Table_Estate();
        		record=(Table_Estate) tableViewList.getItems().get(tableViewList.getSelectionModel().getSelectedIndex());
              	cmboSelectCity.getSelectionModel().select(record.getCity());
              	cmboSelectCountry.getSelectionModel().select(record.getCountry());
              	cmboSelectDistrict.getSelectionModel().select(record.getDistrict());
              	cmboSelectNoR.getSelectionModel().select(record.getNumberOfRooms());
              	cmboSelectHHS.getSelectionModel().select(record.getHomeHeatingSystem());
              	
              	
              	if ((record.getFurnished())==1) {
        			cmboFurnished.getSelectionModel().select("YES");
        		}
              	else {
        			cmboFurnished.getSelectionModel().select("NO");
        		}
              
              	if (record.getSituation().equals("For Sell")) {
        			radioforSell.setSelected(true);
        			
        		}
              	else {
        			radioforRent.setSelected(true);
        			
        		}
              	
              	txtPrice.setText(String.valueOf(record.getPrice()));
              	txtSqrMeters.setText(String.valueOf(record.getSquareMeters()));
              	
              	String selectedDate=(record.getBuildingAge());
              	 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
              	 

              	  //convert String to LocalDate
              	 LocalDate localDate = LocalDate.parse(selectedDate, formatter);
              	datepickerBuildAge.setValue(localDate);
              	

              	txtareaAdress.setText(record.getAdress().toString());
            }
        });

      	
  
      	}
    
  LoginController ls=new LoginController();
    public void checkType() {
    	System.out.println(ls.session);
    	 String sql="select * from users where username=? ";
    	 try {
    		  statement = connection.prepareStatement(sql);
    	         statement.setString(1,ls.session);
    	         
    	         ResultSet resultSet = statement.executeQuery();
    	         if (resultSet.next()) {
    	        	if (Integer.parseInt(resultSet.getString("Type"))==1) {
    	        		btnDelete.setVisible(true);
    	                btnUpdate.setVisible(true);
					}
					
				}
    	        
		} catch (Exception e) {
			// TODO: handle exception
		}
       
    	
    }
    @FXML
    void initialize() {
    	buildData(tableViewList,"select * from estate");
    	setText();
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
         cmboFurnished.getItems().add("YES");
         cmboFurnished.getItems().add("NO");
         btnDelete.setVisible(false);
         btnUpdate.setVisible(false);
         checkType();
         
         
         
         
         
         
    }
}
