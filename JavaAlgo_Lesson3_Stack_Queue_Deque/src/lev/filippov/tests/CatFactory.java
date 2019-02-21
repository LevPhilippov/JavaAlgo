package lev.filippov.tests;

public interface CatFactory<K extends Cat> {
    K create(String name, int age);
}
