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

    
    
    public Vigenere(EncryptionDecorator encrypt) {
        algo = encrypt;
    }
    

    
    private List stringToIntList(String string){
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i<string.length(); i++){
            result.add((int) string.charAt(i));
        }
        return result;
    }
    
    private String intListToString(List<Integer> list){
        String result = new String();
        for(int c :list){
            result += (char) c;
        }
        
        return result;
    }

    @Override
    public void encrypt() {
        algo.encrypt();
        String cypher = vigenereAlgo(true);
        this.setValue(cypher);
    }

    @Override
    public void decrypt() {
        algo.decrypt();
        String cypher = vigenereAlgo(false);
        this.setValue(cypher);
    }
    
    private String vigenereAlgo(boolean encrypt){
        List<Integer> value = stringToIntList(algo.getValue());
        int valueLength = value.size();
        List<Integer> key = stringToIntList(algo.getKey());
        int keyLength = key.size();
        
        List<Integer> crypt = new ArrayList<>();
        
        for (int i = 0; i < valueLength; i++){
            crypt.add(Math.floorMod(value.get(i)-EncryptionUtils.FIRST+ mult(encrypt)*
                    (key.get(i%keyLength)-EncryptionUtils.FIRST),EncryptionUtils.SIZE) +EncryptionUtils.FIRST);
        }
        return intListToString(crypt);
    }
    
    
}
