import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import functional.BiPredicate;
import util.CheckSame;

//change this field and constructor
class Arguments {
    public String s;
    public List<String> wordDict;
    public Arguments(String s, List<String> wordDict) {
        this.s = s;
        this.wordDict = wordDict;
    }
}

public class Driver {
	public static void main(String[] args) {
        //change main function and Arguments
        ArrayList<Arguments> input = new ArrayList<>(8);
        ArrayList<Boolean> output = new ArrayList<>(8);
        input.add(new Arguments("leetcode", List.of("leet", "code")));
        output.add(true);
        input.add(new Arguments("applepenapple", List.of("apple", "pen")));
        output.add(true);
        input.add(new Arguments("catsandog", List.of("cats","dog","sand","and","cat")));
        output.add(false);
        input.add(new Arguments("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", List.of("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa")));
        output.add(false);
        test(input, output, CheckSame::correctAnswerT, "wordBreak");
    }
    //switch invoke to direct call for better speed
    @SuppressWarnings("unchecked")
    public static <T>void test(ArrayList<Arguments> input, ArrayList<T> output, BiPredicate<T> checkfn, String methodname) {
        Objects.requireNonNull(input);
        Objects.requireNonNull(output);
        if(input.size() == 0) {
            return;
        }
        long start = 0;
        long end = 0;
        ArrayList<Long> elapse = new ArrayList<Long>(8);
        try {
            Method[] methods = Solution.class.getMethods();
            Method method = null;
            for(int j=0; j<methods.length; j++) {
                 if(methods[j].getName() == methodname) {
                    method = methods[j];
                }
            }
            Field[] args = Arguments.class.getFields();
            for(int i=0; i<input.size(); i++) {
                Object[] obj = new Object[args.length];
                Solution solution = new Solution();
                for(int j=0; j<args.length; j++) {
                    obj[j] = args[j].get(input.get(i));
                }
                start = System.currentTimeMillis();
                T answer = (T) method.invoke(solution, obj);
                //T answer = (T) new Solution().combine(input.get(i).n, input.get(i).k);
                end = System.currentTimeMillis();
                elapse.add(end - start);
                if(checkfn.test(answer, output.get(i))) {
                    System.out.println("testcase " + i + ", time = " + elapse.get(i) + "ms, get: "+answer + " (correct)");
                }
                else {
                    System.out.println("testcase " + i + ", time = " + elapse.get(i) + "ms, expect: " + output.get(i) + ", get: " + answer + " (incorrect)");
                }
            }
        }
        catch(IllegalAccessException | InvocationTargetException  e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        end = 0;
        for(int i=0; i<input.size(); i++) {
            end += elapse.get(i);
        }
        System.out.println("total time=" + end);
    }
}