/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encryption.application.controller.algorithm;

/**
 * Abstract class corresponding to all algorithm
 * @author bt57100
 */
public abstract class AEncryption extends EncryptionDecorator {
    
    protected EncryptionDecorator algo;

    /**
     * Encrypt function used in decorator
     */
    @Override
    public abstract void encrypt();

    /**
     * Decrypt function used in decorator
     */
    @Override
    public abstract void decrypt();
    
    /**
     * Change the encrypt or the decrypt variable whether it is encryption or decryption 
     * @param encrypt
     * @return 1 if encrypt and -1 if decrypt
     */
    protected int mult(boolean encrypt){
        return encrypt? 1 : -1;
    }
    
}
