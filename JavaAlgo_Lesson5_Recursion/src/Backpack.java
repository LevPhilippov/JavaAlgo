import java.util.ArrayList;
import java.util.Arrays;

public class Backpack {

    Piece[] pieces;
    Piece[] backpackCapacity;
    int maxLoad;
    int maxWeight;
    int maxValue;
    Piece[] maxValueBP;

    public Backpack(int maxLoad, int numberOfPieces) {
        this.maxLoad = maxLoad;
        backpackCapacity = new Piece[numberOfPieces];
        maxWeight = 0;
        maxValue =  0;
        maxValueBP = new Piece[numberOfPieces];
    }

    {
        pieces = new Piece[]
                {
                new Piece("Binocular", 2,5000),
                new Piece("Book",1,600),
                new Piece("FirstAidKit", 4, 1500),
                new Piece("Laptop", 2, 40000),
                new Piece("Bowl", 1,500)
                };

    }

    public void fillIt(){
        fillIt(0);
        System.out.println("Максимальный вес равен: " + maxValue);
        System.out.println(Arrays.toString(maxValueBP));
    }

    private void fillIt(int count){  // ограничение в 5 предметов в рюкзаке

        if(backpackCapacity.length - count < 1) {

            if (sum()>maxLoad) {
                return;
            }

            System.out.println(Arrays.toString(backpackCapacity) + " " + sum() + " " + sumValue());

            if (maxValue < sumValue()) {  // определяем максимальный value (потом удалить)
                maxValue = sumValue();
                for (int i = 0; i<maxValueBP.length; i++)   {
                    maxValueBP[i]=backpackCapacity[i];
                }
            }

            return;
        }

        for (int i = 0; i <pieces.length ; i++) {

            backpackCapacity[count] = pieces[i];

            fillIt(count+1);

        }

    }



    private int sum(){
        int weight = 0;
        for (Piece o: backpackCapacity) {
            weight += o.getWeight();
        }
        return weight;
    }

    private int sumValue(){
        int value = 0;
        for (Piece o: backpackCapacity) {
            value += o.getValue();
        }
        return value;
    }


    public static void main(String[] args) {
        new Backpack(7,5).fillIt();
    }


}