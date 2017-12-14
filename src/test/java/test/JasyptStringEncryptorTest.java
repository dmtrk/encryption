package test;

import com.dmtrk.encryption.JasyptStringEncryptor;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class JasyptStringEncryptorTest {
    private final String encryptionPassword = "12345678";
    private final String plainText = "some text";

    @Before
    public void setUp() throws Exception {
        //
    }

    @After
    public void tearDown() throws Exception {
        //
    }

    public JasyptStringEncryptor getInstance(String algorithm){
        JasyptStringEncryptor stringEncryptor = new JasyptStringEncryptor(algorithm);
        stringEncryptor.setEncryptionPassword(encryptionPassword.toCharArray());
        System.out.println(stringEncryptor.getAlgorithm());
        return stringEncryptor;
    }

    @Test
    public void roundTrip_Test1() throws Exception {
        JasyptStringEncryptor stringEncryptor = getInstance("PBEWithMD5AndTripleDES");
        String encryptedText = stringEncryptor.encrypt(plainText);
        assertEquals(plainText,stringEncryptor.decrypt(encryptedText));
    }

    @Test @Ignore
    public void roundTrip_Test2() throws Exception {
        JasyptStringEncryptor stringEncryptor = getInstance("PBEWithSHA1AndTripleDES");
        String encryptedText = stringEncryptor.encrypt(plainText);
        assertEquals(plainText,stringEncryptor.decrypt(encryptedText));
    }

    @Test @Ignore
    public void roundTrip_Test3() throws Exception {
        JasyptStringEncryptor stringEncryptor = getInstance("PBEWithHmacSHA256AndAES_128");
        String encryptedText = stringEncryptor.encrypt(plainText);
        assertEquals(plainText,stringEncryptor.decrypt(encryptedText));
    }
}
