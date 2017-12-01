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
public abstract class EncryptionDecorator {
    private IEncryption encryption;

    public EncryptionDecorator(IEncryption encryption) {
        this.encryption = encryption;
    }
    
}
