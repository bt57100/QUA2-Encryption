/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encryption;

import encryption.application.controller.algorithm.encryption.Cesar;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author water
 */
public class CesarTest extends AEncryptionTest {
    
    private final Cesar cesar;
    
    public CesarTest() {
        super();
        cesar = new Cesar(ed);
    }
    
    @Before
    public void setUp() {
        this.clear.add("Cesar");
        this.key.add("3");
        this.cypher.add("Fhvdu");
        
        this.clear.add("}~");
        this.key.add("2");
        this.cypher.add(" !");
    }
    
    @Test
    @Override
    public void testEncrypt(){
        for (int i = 0; i<clear.size(); i++){
            ed.setValue(clear.get(i));
            ed.setKey(key.get(i));
            cesar.encrypt();
            assertEquals("Cypher not match. Find " + cesar.getValue(), cypher.get(i), cesar.getValue());
        }
    }
    
    @Test
    @Override
    public void testDecrypt(){
        for (int i = 0; i<clear.size(); i++){
            ed.setValue(cypher.get(i));
            ed.setKey(key.get(i));
            cesar.decrypt();
            assertEquals("Cypher not match. Find " + cesar.getValue(), clear.get(i), cesar.getValue());
        }
    }
}
