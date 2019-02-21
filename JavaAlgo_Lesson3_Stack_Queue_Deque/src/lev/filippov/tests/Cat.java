package lev.filippov.tests;

public class Cat {
    int age = -1;
    String name = "noname";

    public Cat(){
    }

    public Cat(String name, int age) {
        this.age = age;
        this.name = name;
    }

    public Cat(int age) {
        this.age = age;
    }

    public String info() {
        String msg = new String("Кот" + name + " " + age);
        System.out.println(msg);
        return msg;
    }
    public String info(int age) {
        return new String(name + " " + age);
    }
}
