package util;
import java.util.List;
import java.util.Objects;

import functional.BiPredicate;

public class CheckSame {
    public static<T> boolean correctAnswerListT(List<T> ans, List<T> output) {
        Objects.requireNonNull(ans);
        Objects.requireNonNull(output);
        for(int i=0; i<ans.size(); i++) {
            if(ans.get(i) == null) {
                if(output.get(i) == null) {
                    continue;
                }
                else {
                    return false;
                }
            }
            if(! ans.get(i).equals(output.get(i))) {
                return false;
            }
        }
        return true;
    }
    public static<T extends Number> boolean correctAnswerListNumber(List<T> ans, List<T> output) {
        Objects.requireNonNull(ans);
        Objects.requireNonNull(output);
        for(int i=0; i<ans.size(); i++) {
            Objects.requireNonNull(ans.get(i));
            Objects.requireNonNull(output.get(i));
            if(! ans.get(i).equals(output.get(i))) {
                return false;
            }
        }
        return true;
    }
    public static BiPredicate<List<Float>> correctAnswerListTolerance(float tolerance) {
        return (ans, output) -> {
            Objects.requireNonNull(ans);
            Objects.requireNonNull(output);
            for(int i=0; i<ans.size(); i++) {
                Objects.requireNonNull(ans.get(i));
                Objects.requireNonNull(output.get(i));
                if(! ans.get(i).equals(output.get(i))) {
                    return false;
                }
            }
            return true;
        };
    }
    public static BiPredicate<List<Double>> correctAnswerListTolerance(double tolerance) {
        return (ans, output) -> {
            Objects.requireNonNull(ans);
            Objects.requireNonNull(output);
            for(int i=0; i<ans.size(); i++) {
                Objects.requireNonNull(ans.get(i));
                Objects.requireNonNull(output.get(i));
                if(! ans.get(i).equals(output.get(i))) {
                    return false;
                }
            }
            return true;
        };
    }
    public static<T extends Number> boolean correctAnswerList2DNumber(List<List<T>> ans, List<List<T>> output) {
        Objects.requireNonNull(ans);
        Objects.requireNonNull(output);
        for(int i=0; i<ans.size(); i++) {
            List<T> first = ans.get(i);
            List<T> second = output.get(i);
            Objects.requireNonNull(first);
            Objects.requireNonNull(second);
            if(first.size() != second.size()) {
                return false;
            }
            for(int j=0; j<first.size(); j++) {
                Objects.requireNonNull(first.get(j));
                Objects.requireNonNull(second.get(j));
                if(! first.get(j).equals(second.get(j))) {
                    return false;
                }
            }
        }
        return true;
    }
    public static<T> boolean correctAnswerArray(T[] ans, T[] output) {
        Objects.requireNonNull(ans);
        Objects.requireNonNull(output);
        for(int i=0; i<ans.length; i++) {
            if(ans[i] == null) {
                if(output[i] == null) {
                    continue;
                }
                else {
                    return false;
                }
            }
            if(! ans[i].equals(output[i])) {
                return false;
            }
        }
        return true;
    }
    public static<T extends Number> boolean correctAnswerArray(T[] ans, T[] output) {
        Objects.requireNonNull(ans);
        Objects.requireNonNull(output);
        for(int i=0; i<ans.length; i++) {
            Objects.requireNonNull(ans[i]);
            Objects.requireNonNull(output[i]);
            if(! ans[i].equals(output[i])) {
                return false;
            }
        }
        return true;
    }
    public static<T> boolean correctAnswerT(T ans, T output) {
        if(ans == null) {
            return output == null;
        }
        return ans.equals(output);
    }
    public static boolean correctAnswerBoolean(Boolean ans, Boolean output) {
        Objects.requireNonNull(ans);
        Objects.requireNonNull(output);
        return ans.equals(output);
    }
    public static boolean correctAnswerNumber(Number ans, Number output) {
        Objects.requireNonNull(ans);
        Objects.requireNonNull(output);
        return ans.equals(output);
    }
    public static boolean correctAnswerNumber(Integer ans, Integer output) {
        Objects.requireNonNull(ans);
        Objects.requireNonNull(output);
        return ans.equals(output);
    }
    public static BiPredicate<Float> correctAnswerTolerance(float tolerance) {
        return (ans, output) -> {
            Objects.requireNonNull(ans);
            Objects.requireNonNull(output);
            return ((float) Math.abs(ans - output)) < tolerance;
        };
    }
    public static boolean correctAnswerNumber(Double ans, Double output) {
        Objects.requireNonNull(ans);
        Objects.requireNonNull(output);
        return ans.equals(output);
    }
    public static BiPredicate<Double> correctAnswerTolerance(double tolerance) {
        return (ans, output) -> {
            Objects.requireNonNull(ans);
            Objects.requireNonNull(output);
            return Math.abs(ans - output) < tolerance;
        };
    }
}
