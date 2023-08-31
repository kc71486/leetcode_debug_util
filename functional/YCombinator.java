package functional;

public class YCombinator<P, Q> implements Function<RecursiveBase<P, Q>, Function<P, Q>> {
    /**
     * Do Y combinator work.
     * @param f function that recieve itself as a parameter and return a function that yield results
     * @return a function that is capable to yield results in recursive way
     */
    @Override
    @SuppressWarnings({"rawtypes", "unchecked"})
    public Function<P, Q> apply(RecursiveBase<P, Q> f) {
        return new Function<Function<Function, Function>, Function>() {
            @Override
            public Function apply(Function<Function, Function> g) {
                return g.apply(g);
            }
        }.apply(new Function<Function, Function>() {
            @Override
            public Function apply(Function h) {
                return f.apply(new Function<P, Q>() {
                    @Override
                        public Q apply(P x) {
                            return ((Function<P, Q>) h.apply(h)).apply(x);
                        }
                });
            }
        });
    }
}