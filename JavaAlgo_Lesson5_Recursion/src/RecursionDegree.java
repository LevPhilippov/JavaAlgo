public class RecursionDegree {

    public static long RecDeg(int arg, int degree) {

        if(arg==0){
            return 0;
        } else if (degree == 0 ) {
            return 1;
        } else if (degree>0) {
            return arg * RecDeg(arg, degree - 1);
        }
        throw new RuntimeException("Не вычисляю корни!");
    }


    public static void main(String[] args) {
        System.out.println(RecDeg(2,8));
    }

}
