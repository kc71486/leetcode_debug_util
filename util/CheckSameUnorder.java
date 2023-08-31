package util;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CheckSameUnorder {
    public static<T> boolean correctAnswerListT(Collection<T> ans, Collection<T> output) {
        Objects.requireNonNull(ans);
        Objects.requireNonNull(output);
        HashMap<T, Integer> map = new HashMap<T, Integer>();
        for(T obj:output) {
            if(map.containsKey(obj)) {
                map.put(obj, map.get(obj) + 1);
            }
            else {
                map.put(obj, 1);
            }
        }
        for(T obj:ans) {
            if(map.containsKey(obj)) {
                map.put(obj, map.get(obj) - 1);
            }
            else {
                return false;
            }
        }
        for(Map.Entry<T, Integer> entry:map.entrySet()) {
            if(entry.getValue() != 0) {
                return false;
            }
        }
        return true;
    }
    public static<T extends Number> boolean correctAnswerListNumber(Collection<T> ans, Collection<T> output) {
        Objects.requireNonNull(ans);
        Objects.requireNonNull(output);
        HashMap<T, Integer> map = new HashMap<T, Integer>();
        for(T obj:output) {
            Objects.requireNonNull(obj);
            if(map.containsKey(obj)) {
                map.put(obj, map.get(obj) + 1);
            }
            else {
                map.put(obj, 1);
            }
        }
        for(T obj:ans) {
            Objects.requireNonNull(obj);
            if(map.containsKey(obj)) {
                map.put(obj, map.get(obj) - 1);
            }
            else {
                return false;
            }
        }
        for(Map.Entry<T, Integer> entry:map.entrySet()) {
            if(entry.getValue() != 0) {
                return false;
            }
        }
        return true;
    }
    public static boolean correctAnswerListString(Collection<String> ans, Collection<String> output) {
        Objects.requireNonNull(ans);
        Objects.requireNonNull(output);
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for(String obj:output) {
            Objects.requireNonNull(obj);
            if(map.containsKey(obj)) {
                map.put(obj, map.get(obj) + 1);
            }
            else {
                map.put(obj, 1);
            }
        }
        for(String obj:ans) {
            Objects.requireNonNull(obj);
            if(map.containsKey(obj)) {
                map.put(obj, map.get(obj) - 1);
            }
            else {
                return false;
            }
        }
        for(Map.Entry<String, Integer> entry:map.entrySet()) {
            if(entry.getValue() != 0) {
                return false;
            }
        }
        return true;
    }
}
