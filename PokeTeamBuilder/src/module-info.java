module PokeTeamBuilder {
	requires javafx.controls;
	requires javafx.fxml;
	requires com.google.gson;
	
	opens application to javafx.graphics, javafx.fxml;
}
