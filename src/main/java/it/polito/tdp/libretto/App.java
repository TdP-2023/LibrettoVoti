package it.polito.tdp.libretto;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {
    	
    	FXMLLoader loader = new FXMLLoader(App.class.getResource("main.fxml")) ;
    	Parent root = loader.load();
    	Scene scene = new Scene(root) ;

    	stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}