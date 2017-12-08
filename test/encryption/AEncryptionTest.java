/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encryption;

import encryption.application.controller.algorithm.EncryptionDecorator;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author water
 */
public abstract class AEncryptionTest {
    protected List<String> clear;
    protected List<String> key;
    protected List<String> cypher;
    protected EncryptionDecorator ed;

    public AEncryptionTest() {
        clear = new ArrayList<>();
        key = new ArrayList<>();
        cypher = new ArrayList<>();
        ed = new EncryptionDecorator();
    }
    
    public abstract void testEncrypt();
    
    public abstract void testDecrypt();
    
}
