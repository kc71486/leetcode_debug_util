package functional;
@FunctionalInterface
public interface Function<T, R> {
    public R apply(T t);
}
