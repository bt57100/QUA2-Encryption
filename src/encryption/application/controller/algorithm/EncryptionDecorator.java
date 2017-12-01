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
    private AEncryption encryption;

    public EncryptionDecorator(AEncryption encryption) {
        this.encryption = encryption;
    }
 
   
    public String encrypt() {
        return encryption.encrypt();
    }

  
    public String decrypt() {
        return encryption.decrypt();
    }
    
}
