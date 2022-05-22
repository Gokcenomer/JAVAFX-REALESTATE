package application;

public class Table_Users {

	private int ID;
	private String First_Name;
	private String Last_Name;
	private String Email;
	private String Password;
	private String Username;
	private int Type;
	public Table_Users() {
		
	}
	public Table_Users(int ID,String First_Name,
			String Last_Name,String Email,String Password,String Username,int Type) {
		this.ID=ID;
		this.First_Name=First_Name;
		this.Last_Name=Last_Name;
		this.Email=Email;
		this.Password=Password;
		this.Username=Username;
		this.Type=Type;
		
		
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getFirst_Name() {
		return First_Name;
	}
	public void setFirst_Name(String first_Name) {
		First_Name = first_Name;
	}
	public String getLast_Name() {
		return Last_Name;
	}
	public void setLast_Name(String last_Name) {
		Last_Name = last_Name;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public int getType() {
		return Type;
	}
	public void setType(int type) {
		Type = type;
	}
	
}

