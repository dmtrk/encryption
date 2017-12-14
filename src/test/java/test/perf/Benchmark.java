package test.perf;

import com.dmtrk.encryption.JasyptStringEncryptor;
import org.databene.contiperf.PerfTest;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Benchmark {
    private final static String encryptionPassword = "12345678";
    private final static String plainText = "some text";

    @Rule
    public ContiPerfRule perfRule = new ContiPerfRule();
    private static JasyptStringEncryptor jasyptStringEncryptor = new JasyptStringEncryptor("PBEWithMD5AndTripleDES");

    @BeforeClass
    public static void setUpClass() throws Exception {
        jasyptStringEncryptor.setEncryptionPassword(encryptionPassword.toCharArray());
    }

    //@Before
    public void setUp() throws Exception {
        //
    }

    //@After
    public void tearDown() throws Exception {
        //
    }

    @Test
    @PerfTest(duration = 2000, threads = 2, warmUp = 500)
    public void jasyptStringEncryptor_Test() throws Exception {
        String encryptedText = jasyptStringEncryptor.encrypt(plainText);
        assertEquals(plainText,jasyptStringEncryptor.decrypt(encryptedText));
    }
}
