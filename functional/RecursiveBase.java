package functional;

public interface RecursiveBase<P, Q> extends Function<Function<P, Q>, Function<P, Q>> {
    @Override
    public Function<P, Q> apply(Function<P, Q> f);
}

// example class
class Factorial implements RecursiveBase<Integer, Integer> {
    @Override
    public Function<Integer, Integer> apply(Function<Integer, Integer> f) {
        return new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer n) {
                if(n == 0) {
                    return Integer.valueOf(1);
                }
                return n * f.apply(n - 1);
            }
        };
    }
    public static void main(String[] args) {
        RecursiveBase<Integer, Integer> fac = new Factorial();
        Function<Integer, Integer> factorial = new YCombinator<Integer, Integer>().apply(fac::apply);
        Integer i = factorial.apply(6);
        System.out.println(i);
    }
}