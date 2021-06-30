import java.math.BigDecimal;

public class RecursionDegree {

    public static BigDecimal RecDeg(double argument, int degree) {
        BigDecimal arg = new BigDecimal(argument);
        if(arg.equals(new BigDecimal(0))){
            return new BigDecimal(0);
        } else if (degree == 0 ) {
            return new BigDecimal(1);
        } else if (degree>0) {
            return arg.multiply(RecDeg(argument, degree - 1));
        } else {
            return (new BigDecimal(1).divide(arg)).multiply(RecDeg(argument, degree+1));
        }
    }


    public static void main(String[] args) {
        System.out.println(RecDeg(25,-3));
    }

}
