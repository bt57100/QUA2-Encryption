/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encryption.application.controller.algorithm.encryption;

import encryption.application.controller.algorithm.AEncryption;
import encryption.application.controller.algorithm.EncryptionDecorator;

/**
 *
 * @author bt57100
 */
public class Vigenere extends AEncryption {

    public Vigenere(EncryptionDecorator encrypt) {
        algo = encrypt;
    }

    @Override
    public String encrypt() {
        algo.encrypt();
        System.out.println("Vigenere Encrypt");
        return "Vigenere Encrypt";
      
    }

    @Override
    public String decrypt() {
        String result = algo.decrypt();
        System.out.println("Vigenere Decrypt");
        return result + " Vigenere Decrypt";
    }
    
    
}
