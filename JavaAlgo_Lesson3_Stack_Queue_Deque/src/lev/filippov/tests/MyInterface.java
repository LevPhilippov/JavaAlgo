package lev.filippov.tests;

@FunctionalInterface
public interface MyInterface <K, T> {
    K test(T from);
}
