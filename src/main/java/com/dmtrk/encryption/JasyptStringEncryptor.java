package com.dmtrk.encryption;


import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class JasyptStringEncryptor {
    private StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
    //
    private String algorithm;

    public JasyptStringEncryptor() {
        this("PBEWithMD5AndTripleDES");//PBEWithMD5AndTripleDES,PBEWithHmacSHA256AndAES_128
    }

    public JasyptStringEncryptor(String algorithm) {
        this.encryptor.setAlgorithm(this.algorithm=algorithm);
    }

    public String getAlgorithm() {
        return algorithm;
    }

    public void setEncryptionPassword(char[]... encryptionPassword) {
        encryptor.setPasswordCharArray(addAll(encryptionPassword));
    }

    public String encrypt(String string)  {
        String result = encryptor.encrypt(string);
        return result;
    }

    public String decrypt(String string)  {
        String result = encryptor.decrypt(string);
        return result;
    }

    private static char[] addAll(char[]... arrays) {
        int length = 0;
        for (char[] array : arrays) {
            length += array.length;
        }
        final char[] result = new char[length];
        //
        int offset = 0;
        for (char[] array : arrays) {
            System.arraycopy(array, 0, result, offset, array.length);
            offset += array.length;
        }
        return result;
    }
}
