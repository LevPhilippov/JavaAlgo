package lev.filippov.executable;

@FunctionalInterface
public interface MyInterface <K, T> {
    K test(T from);
}
