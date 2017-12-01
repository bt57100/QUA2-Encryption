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
    
    public String encrypt() {
        System.out.println("EncryptionDecorator Encrypt");
        return "EncryptionDecorator encrypt";
    }

    public String decrypt() {
        System.out.println("EncryptionDecorator Decrypt");
        return "EncryptionDecorator decrypt";
    }
    
}
