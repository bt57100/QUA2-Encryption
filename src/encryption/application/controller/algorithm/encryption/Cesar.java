/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encryption.application.controller.algorithm.encryption;

import encryption.application.controller.algorithm.AEncryption;
import encryption.application.controller.algorithm.EncryptionDecorator;
import encryption.application.utils.EncryptionUtils;

/**
 * Cesar algorithm
 * @author bt57100
 */
public class Cesar extends AEncryption {

	/**
	 * Constructor used by the decorator
	 * @param encrypt
	 */
    public Cesar(EncryptionDecorator encrypt) {
        algo = encrypt;
    }

    /**
     * Encrypt the value using the key
     * Decorator function
     */
    @Override
    public void encrypt() {
        algo.encrypt();
        String result = cesarAlgo(true);
        this.setValue(result);
    }

    /**
     * Decrypt the value using the key
     * Decorator function
     */
    @Override
    public void decrypt() {
        algo.decrypt();
        String result = cesarAlgo(false);
        this.setValue(result);
    }
    
    /**
     * Algorithm used to encrypt or decrypt
     * @param encrypt true=encryption / false = decryption
     * @return the cypher
     */
    private String cesarAlgo(boolean encrypt){
        int key = Integer.parseInt(this.algo.getKey());
        String result = "";
        for(char c : this.algo.getValue().toCharArray()) {
            result += (char) (Math.floorMod(c-EncryptionUtils.FIRST + 
                    mult(encrypt)*key, EncryptionUtils.SIZE) + EncryptionUtils.FIRST);
        }
        return result;
    }

}