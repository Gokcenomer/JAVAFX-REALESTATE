package application;

public class Table_Estate {

	private int ID;
	private String City;
	private String Country;
	private String District;
	private String NumberOfRooms;
	private String HomeHeatingSystem;
	private int Furnished;
	private String Adress;
	private int Price;
	private int SquareMeters;
	private String BuildingAge;
	private String Situation;
	public Table_Estate() {
		this.Furnished=0;
	}
	public Table_Estate(int ID, String City, String Country,
			String District, String NumberOfRooms,
			String HomeHeatingSystem,
			int Furnished, String Adress, int Price, int SquareMeters, 
			String BuildingAge, String Situation) {
		this.ID=ID;
		this.City=City;
		this.Country=Country;
		this.District=District;
		this.NumberOfRooms=NumberOfRooms;
		this.HomeHeatingSystem=HomeHeatingSystem;
		this.Furnished=Furnished;
		this.Adress=Adress;
		this.Price=Price;
		this.SquareMeters=SquareMeters;
		this.BuildingAge=BuildingAge;
		this.Situation=Situation;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
	public String getDistrict() {
		return District;
	}
	public void setDistrict(String district) {
		District = district;
	}
	public String getNumberOfRooms() {
		return NumberOfRooms;
	}
	public void setNumberOfRooms(String numberOfRooms) {
		NumberOfRooms = numberOfRooms;
	}
	public String getHomeHeatingSystem() {
		return HomeHeatingSystem;
	}
	public void setHomeHeatingSystem(String homeHeatingSystem) {
		HomeHeatingSystem = homeHeatingSystem;
	}
	public int getFurnished() {
		return Furnished;
	}
	public void setFurnished(int furnished) {
		Furnished = furnished;
	}
	public String getAdress() {
		return Adress;
	}
	public void setAdress(String adress) {
		Adress = adress;
	}
	public int getPrice() {
		return Price;
	}
	public void setPrice(int price) {
		Price = price;
	}
	public int getSquareMeters() {
		return SquareMeters;
	}
	public void setSquareMeters(int squareMeters) {
		SquareMeters = squareMeters;
	}
	public String getBuildingAge() {
		return BuildingAge;
	}
	public void setBuildingAge(String buildingAge) {
		BuildingAge = buildingAge;
	}
	public String getSituation() {
		return Situation;
	}
	public void setSituation(String situation) {
		Situation = situation;
	}
	
}
