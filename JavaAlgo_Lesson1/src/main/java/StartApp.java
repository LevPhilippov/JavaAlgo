public class StartApp {
    public String st2;

    public static void main(String[] args) {
        StartApp startApp = new StartApp();
        startApp.st2="Hello!";
        int a=5;
        String st = "String";
        System.out.println(a);
        System.out.println(st);
        /* При передаче примитивного типа  в метод передается значение, метод создает свою (локальную) переменную, присваивая ей принятое,
         которое,создается и кранится в stack*/
        changePrimitive(a);
        /* При передаче ссылочного типа  в метод передается копия ссылки, которая создается в stack, сам же объект хранится в heep*/
        changeLinked(startApp);
        changeString(st);
        System.out.println(a);
        System.out.println(st);
        System.out.println(startApp.st2);
    }

    private static void changeString(String st) {
        st="String2";
    }

    private static void changeLinked(StartApp startApp) {
        /*При содании нового объекта и присвоении переданной копии ссылки нового значения (области памяти, где хранится новый объект,
        старый обект и ссылка на него остается неизменными.)*/
        startApp=new StartApp();
        startApp.st2="World!";
    }

    private static void changePrimitive(int a) {
    a=10;
    }
}
