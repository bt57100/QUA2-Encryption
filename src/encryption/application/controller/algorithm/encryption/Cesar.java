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
    
    
    private int keyToInt(){
        return Integer.parseInt(this.getKey());
    }
    
    private String algoCesar(int key, String value){
        String cypher = "";
        int current;
        int length = this.getValue().length();
        for (int i = 0; i < length; i++){
            current = Character.getNumericValue(this.getValue().charAt(i));
            current += key;
            cypher.concat(Character.toString((char) current));
        }
        System.out.print(cypher);
        return cypher;
    }

    @Override
    public String encrypt() {
        algo.encrypt();
        System.out.println(algoCesar(keyToInt(), this.getValue()));
        return algoCesar(keyToInt(), this.getValue());

    }

    @Override
    public String decrypt() {
        String result = algo.decrypt();
        System.out.println(algoCesar(-keyToInt(), this.getValue()));
        return result + " Cesar Decrypt";
    }

}