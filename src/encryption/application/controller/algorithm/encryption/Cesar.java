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
public class Cesar extends AEncryption {

    public Cesar(EncryptionDecorator encrypt) {
        algo = encrypt;
    }

    @Override
    public void encrypt() {
        algo.encrypt();
        
        String result = cesarAlgo(true);
        this.setValue(result);
        
        System.out.println(result);
    }

    @Override
    public void decrypt() {
        algo.decrypt();
        
        String result = cesarAlgo(false);
        this.setValue(result);
        
        System.out.println(result);
    }
    
    private String cesarAlgo(boolean encrypt){
        int key = Integer.parseInt(this.algo.getKey());
        String result = "";
        for(char c : this.algo.getValue().toCharArray()) {
            result += (char) ((c-FIRST + mult(encrypt)*key) % SIZE + FIRST);
        }
        return result;
    }

}