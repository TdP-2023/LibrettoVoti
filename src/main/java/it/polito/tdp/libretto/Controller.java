package it.polito.tdp.libretto;

import it.polito.tdp.libretto.model.Libretto;
/**
 * Sample Skeleton for 'main.fxml' Controller Class
 */
import it.polito.tdp.libretto.model.Voto;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


public class Controller { // controller non deve fare mai la new !! la new la fa il main!!!
	
	private Libretto model;// NON DEVO MAI INIZIALIZZARLO QUA IL MODELLO!! DEVO CREARE FUNZIONE SETMODEL!!!
	
	 @FXML // ResourceBundle that was given to the FXMLLoader
	    private ResourceBundle resources;

	    @FXML // URL location of the FXML file that was given to the FXMLLoader
	    private URL location;

	    @FXML // fx:id="buttonInserisci"
	    private Button buttonInserisci; // Value injected by FXMLLoader

	    @FXML // fx:id="comboVoto"
	    private ComboBox<Integer> comboVoto; // Value injected by FXMLLoader

	    @FXML // fx:id="nomeCorso"
	    private TextField nomeCorso; // Value injected by FXMLLoader

	    @FXML // fx:id="selezioneData"
	    private DatePicker selezioneData; // Value injected by FXMLLoader

	    @FXML // fx:id="txtRisultato"
	    private TextArea txtRisultato; // Value injected by FXMLLoader

	    @FXML
	    void handleInserisci(ActionEvent event) {
	    	String corso=nomeCorso.getText();
	    	Integer punti=comboVoto.getValue();
	    	LocalDate data=this.selezioneData.getValue();
	    	try {
		    	Voto voto=new Voto(corso,punti,data);
		    	model.add(voto);
		    	this.txtRisultato.setText(model.stampa());
	    	}catch (IllegalArgumentException e) {
	    		txtRisultato.setText("Impossibile inserire voto a causa di Conflitto o duplicazione");
	    	}
	    	
	    	

	    }

	    @FXML // This method is called by the FXMLLoader when initialization is complete
	    void initialize() {
	        assert buttonInserisci != null : "fx:id=\"buttonInserisci\" was not injected: check your FXML file 'main.fxml'.";
	        assert comboVoto != null : "fx:id=\"comboVoto\" was not injected: check your FXML file 'main.fxml'.";
	        assert nomeCorso != null : "fx:id=\"nomeCorso\" was not injected: check your FXML file 'main.fxml'.";
	        assert selezioneData != null : "fx:id=\"selezioneData\" was not injected: check your FXML file 'main.fxml'.";
	        assert txtRisultato != null : "fx:id=\"txtRisultato\" was not injected: check your FXML file 'main.fxml'.";
	        
	        for (int p=18; p<=30;p++)
	        	comboVoto.getItems().add(p);
	    }
	    public void setModel(Libretto model) {
			this.model = model;
		}

}
