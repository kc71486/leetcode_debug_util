package util;

/**
 * Generates random sequence.
 * Low and high are inclusive.
 * */
public class RandomGenerator {
    public static void main(String[] args) {
        String str = randomString(500, 'a', 'f');
        System.out.println(str);
    }
    public static int randomInt(int low, int high) {
        return (int) Math.floor(Math.random() * (high - low + 1) + low);
    }
    public static int[] randomIntArray(int len, int low, int high) {
        int[] outarr = new int[len];
        for(int i=0; i<len; i++) {
            outarr[i] = (int) Math.floor(Math.random() * (high - low + 1) + low);
        }
        return outarr;
    }
    public static String randomString(int len, char low, char high) {
        char[] outarr = new char[len];
        for(int i=0; i<len; i++) {
            outarr[i] = (char) Math.floor(Math.random() * (high - low + 1) + low);
        }
        return String.valueOf(outarr);
    }
}
