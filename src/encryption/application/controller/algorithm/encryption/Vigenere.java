/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encryption.application.controller.algorithm.encryption;

import encryption.application.controller.algorithm.AEncryption;

/**
 *
 * @author bt57100
 */
public class Vigenere extends AEncryption {

    public Vigenere() {
    }

    public Vigenere(AEncryption encryption) {
        super(encryption);
    }

    @Override
    public String encrypt() {
        System.out.println("Encrypt \n");
        return null;
      
    }

    @Override
    public String decrypt() {
        System.out.println("Decrypt \n");
        return null;
    }
    
    
}
