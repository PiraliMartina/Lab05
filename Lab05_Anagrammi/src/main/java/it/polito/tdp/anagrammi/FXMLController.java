package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.anagrammi.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	private Model model;

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TextField txtParola;

	@FXML
	private Button btnCalcolaAnagrammi;

	@FXML
	private TextArea txtAnagrammiCorretti;

	@FXML
	private TextArea txtAnagrammiErrati;

	@FXML
	private Button btnReset;

	@FXML
	void doCalcolaAnagrammi(ActionEvent event) {
		txtAnagrammiCorretti.clear();
		txtAnagrammiErrati.clear();
		try {
			String parola = txtParola.getText();
			
			if(parola.matches("[a-z A-Z ?]+")) {
				for(String s: model.anagrammiCorretti(parola)) {
					txtAnagrammiCorretti.appendText(s+"\n");
				}
				for(String s: model.anagrammiSbagliati(parola)) {
					txtAnagrammiErrati.appendText(s+"\n");
				}
			} else {
				txtAnagrammiCorretti.setText("Non hai inserito una parola alfabetica");
			}
			
		} catch(RuntimeException e) {
			txtAnagrammiCorretti.setText("ERRORE DI CONNESSIONE AL DATABASE!");
		} 
	}

	@FXML
	void doReset(ActionEvent event) {
		txtParola.clear();
		txtAnagrammiCorretti.clear();
		txtAnagrammiErrati.clear();
	}

	@FXML
	void initialize() {
		assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
		assert btnCalcolaAnagrammi != null : "fx:id=\"btnCalcolaAnagrammi\" was not injected: check your FXML file 'Scene.fxml'.";
		assert txtAnagrammiCorretti != null : "fx:id=\"txtAnagrammiCorretti\" was not injected: check your FXML file 'Scene.fxml'.";
		assert txtAnagrammiErrati != null : "fx:id=\"txtAnagrammiErrati\" was not injected: check your FXML file 'Scene.fxml'.";
		assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

	}

	public void setModel(Model model) {
		this.model = model;

	}
}
