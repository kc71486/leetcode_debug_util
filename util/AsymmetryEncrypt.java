package util;

public class AsymmetryEncrypt {
    public static int encrypt(int raw, int enckey) {
        return raw + enckey;
    }
    public static int decrypt(int encrypted, int deckey) {
        return encrypted + deckey;
    }
}
