package functional;
@FunctionalInterface
public interface BiPredicate<T> {
    public boolean test(T t1, T t2);
}
