package util;
import java.util.List;
import java.util.Objects;
import java.util.ArrayList;

public class ListGenerator {
    public static List<Integer> getIntList(String str) {
        Objects.requireNonNull(str);
        if(str.charAt(0) != '[') {
            throw new IllegalArgumentException("list should start with '['");
        }
        if(str.charAt(str.length() - 1) != ']') {
            throw new IllegalArgumentException("list should end with ']'");
        }
        ArrayList<Integer> list = new ArrayList<>();
        int listindex = 0;
        int intstart = 0;
        int intphase = 0; // 0:before, 1: between, 2: after
        Integer.parseInt("10");
        for(int i=1; i<str.length() - 1; i++) {
            char c = str.charAt(i);
            if(intphase == 0) {
                if(c == '+' || c == '-' || (c >= '0' && c <= '9')) {
                    intphase = 1;
                    intstart = i;
                }
                if(c == ',') {
                    throw new IllegalArgumentException("skip index " + listindex);
                }
            }
            else if(intphase == 1){
                if(! (c >= '0' && c <= '9')) {
                    int added = Integer.parseInt(str.substring(intstart, i));
                    list.add(added);
                    intphase = 2;
                }
                if(c == ',') {
                    listindex ++;
                    intphase = 0;
                }
            }
            else {
                if(c == ',') {
                    listindex ++;
                    intphase = 0;
                }
                else if(c >= '0' && c <= '9') {
                    throw new IllegalArgumentException("illegal list index " + listindex);
                }
            }
        }
        if(intphase == 1) {
            int added = Integer.parseInt(str.substring(intstart, str.length() - 1));
            list.add(added);

        }
        return list;
    }
    public static List<List<Integer>> getIntList2D(String str) {
        Objects.requireNonNull(str);
        if(str.charAt(0) != '[') {
            throw new IllegalArgumentException("2d list should start with '['");
        }
        if(str.charAt(str.length() - 1) != ']') {
            throw new IllegalArgumentException("2d list should end with ']'");
        }
        ArrayList<List<Integer>> list = new ArrayList<>();
        int listindex = 0;
        int listatart = 0;
        int listphase = 0; // 0:before, 1: between, 2: after
        Integer.parseInt("10");
        for(int i=1; i<str.length() - 1; i++) {
            char c = str.charAt(i);
            if(listphase == 0) {
                if(c == '[') {
                    listphase = 1;
                    listatart = i;
                }
                else if(c != ' ') {
                    throw new IllegalArgumentException("illegal 2d list index " + listindex);
                }
            }
            else if(listphase == 1){
                if(c == ']') {
                    try {
                        list.add(getIntList(str.substring(listatart, i + 1)));
                        listphase = 2;
                    }
                    catch(IllegalArgumentException e) {
                        throw new IllegalArgumentException("illegal 2d list index " + listindex, e);
                    }
                }
            }
            else {
                if(c == ',') {
                    listindex ++;
                    listphase = 0;
                }
                else if(c != ' ') {
                    throw new IllegalArgumentException("illegal 2d list index " + listindex);
                }
            }
        }
        if(listphase != 2) {
            throw new IllegalArgumentException("2d list doesn't end properly (miss [ or ])");
        }
        return list;
    }
}
