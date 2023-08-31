package util;

public class SymmetryEncrypt {
    public static int encrypt(int raw, int key) {
        return raw ^ key;
    }
    public static int decrypt(int encrypted, int key) {
        return encrypted ^ key;
    }
}
