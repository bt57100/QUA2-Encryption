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
    protected static final int FIRST = 32;
    protected static final int LAST = 126;
    protected static final int SIZE = LAST - FIRST;

    protected EncryptionDecorator algo;

    @Override
    public abstract void encrypt();

    @Override
    public abstract void decrypt();
    
    protected int mult(boolean encrypt){
        return encrypt? 1 : -1;
    }
    
}
