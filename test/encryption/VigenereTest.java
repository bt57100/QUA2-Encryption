/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encryption;

import encryption.application.controller.algorithm.encryption.Vigenere;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author water
 */
public class VigenereTest extends AEncryptionTest {

    private final Vigenere vigenere;

    public VigenereTest() {
        super();
        vigenere = new Vigenere(ed);
    }

    @Before
    public void setUp() {
        this.clear.add("IJKLMN");
        this.key.add(" !\"");
        this.cypher.add("IKMLNP");

        this.clear.add("}~abcdef");
        this.key.add("abc");
        this.cypher.add("_aEDFHGI");
    }

    @Override
    public void testEncrypt() {
        for (int i = 0; i < clear.size(); i++) {
            ed.setValue(clear.get(i));
            ed.setKey(key.get(i));
            vigenere.encrypt();
            assertEquals("Cypher not match. Find " + vigenere.getValue(), cypher.get(i), vigenere.getValue());
        }
    }

    @Test
    @Override
    public void testDecrypt() {
        for (int i = 0; i < clear.size(); i++) {
            ed.setValue(cypher.get(i));
            ed.setKey(key.get(i));
            vigenere.decrypt();
            assertEquals("Cypher not match. Find " + vigenere.getValue(), clear.get(i), vigenere.getValue());
        }
    }
}
