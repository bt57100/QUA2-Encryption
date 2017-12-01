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
public abstract class AEncryption extends EncryptionDecorator {
    
    String value ="";
    String key="";

    public AEncryption() {
    }

    public AEncryption(AEncryption encryption) {
        super(encryption);
    }
    
   abstract public  String  encrypt();
            
   abstract public String decrypt();
}
