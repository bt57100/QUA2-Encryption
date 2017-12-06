/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encryption.application.controller.algorithm.encryption;

import encryption.application.controller.algorithm.AEncryption;
import encryption.application.controller.algorithm.EncryptionDecorator;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bt57100
 */
public class Vigenere extends AEncryption {

    private final int first;
    private final int last;
    private final int size;
    
    public Vigenere(EncryptionDecorator encrypt) {
        algo = encrypt;
        first = 32;
        last = 126;
        size = last - first;
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
        System.out.println("Vigenere Encrypt");
        List<Integer> value = stringToIntList(algo.getValue());
        int valueLength = value.size();
        List<Integer> key = stringToIntList(algo.getKey());
        int keyLength = key.size();
        
        List<Integer> crypt = new ArrayList<>();
        
        for (int i = 0; i < valueLength; i++){
            int res = (value.get(i)+ key.get(i%keyLength)-2*first)%size +first;
            crypt.add(res);
        }
        String cypher = intListToString(crypt);
        this.setValue(cypher);
    }

    @Override
    public void decrypt() {
        algo.decrypt();
        System.out.println("Vigenere Decrypt");
        List<Integer> value = stringToIntList(algo.getValue());
        int valueLength = value.size();
        List<Integer> key = stringToIntList(algo.getKey());
        int keyLength = key.size();
        
        List<Integer> crypt = new ArrayList<>();
        
        for (int i = 0; i < valueLength; i++){
            int res = (value.get(i)- key.get(i%keyLength))%size +first;
            crypt.add(res);
        }
        String cypher = intListToString(crypt);
        System.out.println(cypher);
        this.setValue(cypher);
    }
    
    
}
