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
import java.util.ResourceBundle;
import com.google.gson.Gson;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;

public class TBuilderController implements Initializable {
	@FXML
	private Button slot1,slot2,slot3,slot4,slot5,slot6, addBtn, removeBtn;
	
	@FXML
	private TextField searchBar;
	
	@FXML
	private TextArea printArea;
	
	private Button[] allBtns;
	
	//These 2 variables act as pseudo-stack:
	//Will store 6 pokemon maximum
	private Pokemon[] team;
	//Current highest index
	private int top;
	
	public void initialize(URL arg0, ResourceBundle arg1){
		//Have buttons and logos synchronized
		this.allBtns = new Button[6];
		this.team = new Pokemon[6];
		this.top = -1;
		
		//Initializing buttons
		this.slot1.setText("");
		this.slot2.setText("");
		this.slot3.setText("");
		this.slot4.setText("");
		this.slot5.setText("");
		this.slot6.setText("");
		this.allBtns[0] = this.slot1;
		this.allBtns[1] = this.slot2;
		this.allBtns[2] = this.slot3;
		this.allBtns[3] = this.slot4;
		this.allBtns[4] = this.slot5;
		this.allBtns[5] = this.slot6;
		this.addBtn.setText("Add");
		this.removeBtn.setText("Remove Last Added");
		
		//Set text area to be read-only
		this.printArea.setEditable(false);
	}
	
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
				if(con.getResponseCode() == 200) {
					Gson gson = new Gson();
					Pokemon found = gson.fromJson(new BufferedReader(new InputStreamReader(con.getInputStream())), Pokemon.class);
					this.printArea.setText(found.toString());
					if(this.top < 6) {
						this.top++;
						this.team[this.top] = found;
						//this.allBtns[this.top];
					}
					else {
						Alert alert = new Alert(AlertType.WARNING);
						alert.setContentText("Pokemon found can't be added, maximum capacity of the team reached!");
						alert.showAndWait();
					}
				}
				else {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setContentText("No results, please enter a valid Pokemon name!");
					alert.showAndWait();
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
