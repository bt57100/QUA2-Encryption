/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encryption.application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Main class to launch application
 * @author bt57100
 */
public class EncryptionApplication extends Application {
    
	/**
	 * Launch Java FX
	 */
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("view/EncryptionView.fxml"));
        
        Scene scene = new Scene(root);
        stage.setTitle("QUA2 - Encryption");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Launch main application
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
