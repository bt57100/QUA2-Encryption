/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encryption.application.controller.algorithm.encryption;

import encryption.application.controller.algorithm.AEncryption;
import encryption.application.controller.algorithm.EncryptionDecorator;
import encryption.application.utils.EncryptionUtils;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bt57100
 */
public class Vigenere extends AEncryption {

	/**
	 * Constructor used by the decorator
	 * @param encrypt
	 */
    public Vigenere(EncryptionDecorator encrypt) {
        algo = encrypt;
    }

    /**
     * Encrypt the value using the key
     * Decorator function
     */
    @Override
    public void encrypt() {
        algo.encrypt();
        String cypher = vigenereAlgo(true);
        this.setValue(cypher);
    }

    /**
     * Decrypt the value using the key
     * Decorator function
     */
    @Override
    public void decrypt() {
        algo.decrypt();
        String cypher = vigenereAlgo(false);
        this.setValue(cypher);
    }
    
    /**
     * Algorithm used to encrypt or decrypt
     * @param encrypt true=encryption / false = decryption
     * @return the cypher
     */
    private String vigenereAlgo(boolean encrypt){
        List<Integer> key = EncryptionUtils.stringToIntList(algo.getKey());
        List<Integer> value = EncryptionUtils.stringToIntList(algo.getValue());
        int keyLength = key.size();
        int valueLength = value.size();
        
        List<Integer> crypt = new ArrayList<>();
        
        for (int i = 0; i < valueLength; i++){
            crypt.add(Math.floorMod(value.get(i)-EncryptionUtils.FIRST+ mult(encrypt)*
                    (key.get(i%keyLength)-EncryptionUtils.FIRST),EncryptionUtils.SIZE) +EncryptionUtils.FIRST);
        }
        
        return EncryptionUtils.intListToString(crypt);
    }
    
    
}
