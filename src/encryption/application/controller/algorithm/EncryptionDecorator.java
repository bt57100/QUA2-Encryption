/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encryption.application.controller.algorithm;

/**
 *
 * @author bt57100
 */
public class EncryptionDecorator {
    
    private String value;
    private String key;
    
    public void encrypt() {
        System.out.println("EncryptionDecorator Encrypt");
    }

    public void decrypt() {
        System.out.println("EncryptionDecorator Decrypt");
    }

    public String getValue() {
        return value;
    }

    public String getKey() {
        return key;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setKey(String key) {
        this.key = key;
    }
    
}
