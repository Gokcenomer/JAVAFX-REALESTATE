module Realestateautomation {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires java.sql;
	requires mysql.connector.java;
	requires javafx.base;
	
	opens application to javafx.graphics, javafx.fxml,javafx.base;
}
