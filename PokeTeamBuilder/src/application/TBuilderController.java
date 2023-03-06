package application;

/**
 * @author: Carlos Rodriguez
 * Class takes care of the actions from the FXML file*/
import javafx.fxml.FXML;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.google.gson.Gson;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class TBuilderController {
	@FXML
	private Button slot1,slot2,slot3,slot4,slot5,slot6, addBtn, removeBtn;
	
	@FXML
	private TextField searchBar;
	
	@FXML
	private TextArea printArea;
	
	@FXML
	public void search() {
		String textFound = searchBar.getText();
		if(textFound.isBlank()) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText("Search bar is empty, please enter a valid Pokemon!");
			alert.showAndWait();
		}
		else {
			textFound = textFound.toLowerCase();
			try {
				URL url = new URL("https://pokeapi.co/api/v2/pokemon/" + textFound);
				HttpURLConnection con = (HttpURLConnection) url.openConnection();
				con.setRequestMethod("GET");
				con.setRequestProperty("User", "user");
				if(con.getResponseCode() == 200) {
					Gson gson = new Gson();
					Pokemon found = gson.fromJson(new BufferedReader(new InputStreamReader(con.getInputStream())), Pokemon.class);
					this.printArea.setText(found.toString());
				}
				con.disconnect();
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	@FXML
	public void remove () {}
}
