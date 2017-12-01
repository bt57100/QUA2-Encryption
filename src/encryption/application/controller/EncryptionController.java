/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encryption.application.controller;

import encryption.application.controller.algorithm.EncryptionDecorator;
import encryption.application.controller.algorithm.encryption.Cesar;
import encryption.application.controller.algorithm.encryption.Vigenere;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 *
 * @author bt57100
 */
public class EncryptionController implements Initializable {

    @FXML
    private Label label;
    @FXML
    private TextField chaineInput;
    @FXML
    private TextField cleInput;
    @FXML
    private TextArea resultatInput;
    @FXML
    private TextField nbCesar;
    @FXML
    private TextField nbVigenere;

    @FXML
    private void chiffrer(ActionEvent event) {
        System.out.println("Chiffrer");
        String chaine = chaineInput.getText();
        String cle = cleInput.getText();
        
        int nbCesar =  Integer.parseInt(this.nbCesar.getText());
        int nbVigenere =  Integer.parseInt(this.nbVigenere.getText());
        
        Cesar ed = new Cesar();
        Vigenere ed2 = new Vigenere(ed);
        
        ed.encrypt();
     
    }

    @FXML
    private void dechiffrer(ActionEvent event) {
        System.out.println("Dechiffrer");
        String chaine = chaineInput.getText();
        String cle = cleInput.getText();
        
        int nbCesar =  Integer.parseInt(this.nbCesar.getText());
        int nbVigenere =  Integer.parseInt(this.nbVigenere.getText());
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
