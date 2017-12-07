/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encryption.application.utils;

/**
 *
 * @author water
 */
public class EncryptionUtils {
    public static final int FIRST = 32;
    public static final int LAST = 126;
    public static final int SIZE = LAST - FIRST;
    
    public static final String getRegExp(){
        return "["+Character.toString((char)EncryptionUtils.FIRST)+
                "-"+Character.toString((char)EncryptionUtils.LAST)+"]";
    }
}
