package filippov.lev.filippov.executable;

public interface CatFactory<K extends Cat> {
    K getInstance(String name, int age);
}
