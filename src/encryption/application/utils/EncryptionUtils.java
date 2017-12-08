/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encryption.application.utils;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author water
 */
public class EncryptionUtils {
    public static final int FIRST = 32;
    public static final int LAST = 126;
    public static final int SIZE = LAST - FIRST +1;

    /**
     * Regex corresponding to the consider ASCII table
     * @return regex
     */
    public static final String getRegExpCustomAlphaNum(){
        return "["+Character.toString((char)EncryptionUtils.FIRST)+
                "-"+Character.toString((char)EncryptionUtils.LAST)+"]";
    }
    
    /**
     * Regex corresponding to numerical charater
     * @return regex
     */
    public static final String getRegExpNum(){
        return "[0-9]";
    }

    
    /**
     * Convert the string parameter to a list of corresponding Integer in ASCII table
     * @param string
     * @return the list of Integer
     */
    public static List<Integer> stringToIntList(String string){
        List<Integer> result = new ArrayList<>();
        
        for(int i = 0; i<string.length(); i++){
            result.add((int) string.charAt(i));
        }
        return result;
    }
    
    /**
     * Convert the list of corresponding Integer parameter to String in ASCII table
     * @param list
     * @return the String 
     */
    public static String intListToString(List<Integer> list){
        String result = "";
        
        for(int c :list){
            result += (char) c;
        }
        
        return result;
    }
}
