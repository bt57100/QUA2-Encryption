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
    public String encrypt() {
        algo.encrypt();
        System.out.println("Cesar Encrypt");
        return "Cesar Encrypt";

    }

    @Override
    public String decrypt() {
        String result = algo.decrypt();
        System.out.println("Cesar Decrypt");
        return result + " Cesar Decrypt";
    }

}
