module PokeTeamBuilder {
	exports application to com.google.gson;
	requires javafx.controls;
	requires javafx.fxml;
	requires com.google.gson;
	requires javafx.graphics;
	
	opens application to javafx.graphics, javafx.fxml, com.google.gson;
}
