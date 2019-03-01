public class Factorial {

    public static void main(String[] args) {
        System.out.println(factorial(20));
    }

    private static long factorial(int arg) {

        if(arg==1) {
            return arg;
        }

        return arg*factorial(arg-1);
    }
}