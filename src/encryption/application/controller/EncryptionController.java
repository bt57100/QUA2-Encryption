/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encryption.application.controller;

import encryption.application.utils.EncryptionUtils;
import encryption.application.controller.algorithm.EncryptionDecorator;
import encryption.application.controller.algorithm.encryption.Cesar;
import encryption.application.controller.algorithm.encryption.Vigenere;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author bt57100
 */
public class EncryptionController implements Initializable {

    @FXML
    private TextField chaineInput;
    @FXML
    private TextField clefCesar;
    @FXML
    private TextField clefVigenere;
    @FXML
    private TextArea resultatInput;
    @FXML
    private TextField nbCesar;
    @FXML
    private TextField nbVigenere;

    /**
     * Action on button click "Chiffrer"
     * @param event
     */
    @FXML
    private void chiffrer(ActionEvent event) {
        System.out.println("Chiffrer");
        EncryptionDecorator ed = prepareAlgorithm();
        ed.encrypt();
        resultatInput.setText(ed.getValue());
        System.out.println();
    }

    /**
     * Action on button click "Dechiffrer"
     * @param event
     */
    @FXML
    private void dechiffrer(ActionEvent event) {
        System.out.println("Dechiffrer");
        EncryptionDecorator ed = prepareAlgorithm();
        ed.decrypt();
        resultatInput.setText(ed.getValue());
        System.out.println();
    }
    
    /**
     * Clear Cesar key on click 
     * @param event
     */
    @FXML
    public void clearCesar(MouseEvent event) {
    	clefCesar.setText("");
    }
    
    /**
     * Clear chaine input on click
     * @param event
     */
    @FXML
    public void clearChaineInput(MouseEvent event) {
    	chaineInput.setText("");
    }
    
    /**
     * Clear Vigenere key on click
     * @param event
     */
    @FXML
    public void clearVigenere(MouseEvent event) {
    	clefVigenere.setText("");
    }
    
    /**
     * Check prevent other character than numeric
     * @return the key event
     */
    private EventHandler<KeyEvent> validateNumeric() {
    	return (KeyEvent event) -> {
            if(!event.getCharacter().matches("[0-9]")) {
                event.consume();
            }
        };
    }

    /**
     * Check prevent other character than those consider by the application
     * @return the key event
     */
    private EventHandler<KeyEvent> validateCustomAlphaNumeric() {
    	return (KeyEvent event) -> {
            if(!event.getCharacter().matches(EncryptionUtils.getRegExpCustomAlphaNum())) {
                event.consume();
            }
        };
    }

    /**
     * Initialize JavaFX components
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nbCesar.addEventFilter(KeyEvent.KEY_TYPED, validateNumeric());
        nbVigenere.addEventFilter(KeyEvent.KEY_TYPED, validateNumeric());
    	clefCesar.addEventFilter(KeyEvent.KEY_TYPED, validateNumeric());
        clefVigenere.addEventFilter(KeyEvent.KEY_TYPED, validateCustomAlphaNumeric());
        chaineInput.addEventFilter(KeyEvent.KEY_TYPED, validateCustomAlphaNumeric());
    }
    
    /**
     * Convert Cesar key if possible 
     * else return 0 
     * @return cesar key
     */
    private int convertCesarKey() {
        int key = 0;        
        if(this.nbCesar.getText() != null && 
                this.clefCesar.getText().matches(EncryptionUtils.getRegExpNum())) {
            key = Integer.parseInt(this.clefCesar.getText());
        }
        return key;
    }
    
    /**
     * Prepare the encryption using decorator pattern
     * @return the encryption algorithm
     */
    private EncryptionDecorator prepareAlgorithm() {
        EncryptionDecorator ed = new EncryptionDecorator();
        ed.setValue(this.chaineInput.getText());
         
        /* Cesar */
        if(convertCesarKey() > 0) {
            ed.setKey(this.clefCesar.getText());
            for(int i=0; i < Integer.parseInt(this.nbCesar.getText()); i++) {
                ed = new Cesar(ed);
                ed.setValue(this.chaineInput.getText());
                ed.setKey(this.clefCesar.getText());
            }
        }
        
        /* Vigenere */
        if(Integer.parseInt(this.nbVigenere.getText() == null ? "0" :this.nbVigenere.getText()) > 0) {
            ed.setKey(this.clefVigenere.getText());
            for(int i=0; i < Integer.parseInt(this.nbVigenere.getText()); i++) {
                ed = new Vigenere(ed);
                ed.setValue(this.chaineInput.getText());
                ed.setKey(this.clefVigenere.getText());
            }
        }
        
        return ed;
    }
}
