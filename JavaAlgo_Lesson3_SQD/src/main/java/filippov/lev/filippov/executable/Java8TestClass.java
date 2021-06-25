package filippov.lev.filippov.executable;

public class Java8TestClass {

    public static void main(String[] args) {


        MyInterface<Integer, String> mi = (from -> Integer.parseInt(from));
        // присваеваем экземпляру интерфейса ссылку на статический метод
        MyInterface<Integer, String> mi2 = Integer::parseInt;

        System.out.println(mi2.test("123"));

        //ссылаемся на метод объекта, который удовлетворяет параметрам интерфейса
        Cat cat = new Cat();
        MyInterface<String, Integer> mi3 = cat::info;
        System.out.println(mi3.test(13));

        //передаем ссылку на конструктор
        CatFactory catFactory = Cat::new;
        Cat cat1 = catFactory.getInstance("Barsik", 5);
        cat1.info();
    }

    private static Integer test(String from) {
        return Integer.parseInt("123");
    }
}
