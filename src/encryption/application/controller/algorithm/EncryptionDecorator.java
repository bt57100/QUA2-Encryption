/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encryption.application.controller.algorithm;

/**
 * Decorator class for algorithm
 * @author bt57100
 */
public class EncryptionDecorator {
    
    private String value;
    private String key;
    
    /**
     * Encrypt decorator
     */
    public void encrypt() {
        System.out.println("EncryptionDecorator Encrypt");
    }
    
    /**
     * Decrypt decorator
     */
    public void decrypt() {
        System.out.println("EncryptionDecorator Decrypt");
    }

    /**
     * Get value to encrypt or the cypher
     * @return
     */
    public String getValue() {
        return value;
    }

    /**
     * Get key for the algorythm
     * @return
     */
    public String getKey() {
        return key;
    }

    /**
     * Set the value as cypher or the cypher
     * @param value
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Set the key for the algorithm
     * @param key
     */
    public void setKey(String key) {
        this.key = key;
    }
    
}
