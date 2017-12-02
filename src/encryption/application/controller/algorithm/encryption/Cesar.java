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
        int key = Integer.parseInt(this.algo.getKey());
        String cypher = "";
        algo.encrypt();
        for(char c : this.algo.getValue().toCharArray()) {
            int newChar = c + key;
            
            if(newChar > 255) {
                newChar -= 255;
            } else if (newChar < 0) {
                newChar += 255;
            }
            
            cypher += (char) newChar;
        }
        
        this.setValue(cypher);
        
        System.out.println(cypher);
    }

    @Override
    public void decrypt() {
        algo.decrypt();
        System.out.println("yet to impl");
    }

}