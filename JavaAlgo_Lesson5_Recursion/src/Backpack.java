import java.util.ArrayList;

public class Backpack {

    ArrayList<Piece> pieces;
    ArrayList<Piece> currentBP;
    int numberOfPieces;
    int lvl;
    ArrayList<Piece> tempList;
    int maxLoad;
    int maxValue;
    ArrayList<Piece> maxValueBP;

    public Backpack(int maxLoad) {
        this.maxLoad = maxLoad;
        numberOfPieces = pieces.size();
        currentBP = new ArrayList<>();
        //currentBP = new Piece[numberOfPieces];
        maxValueBP = new ArrayList<>();
        //maxValueBP = new Piece[numberOfPieces];
        lvl=-1;
    }

    {
        pieces = new ArrayList<Piece>(){
            {
                add(new Piece("Binocular", 2,5000));
                add(new Piece("Book",1,600));
                add(new Piece("FirstAidKit", 4, 1500));
                add(new Piece("Laptop", 2, 40000));
                add(new Piece("Bowl", 1,500));
            };
        };
    }


    public void find(){
        findBestSet(0);
        System.out.println(maxValue);
        System.out.println("Best set is " + maxValueBP);
    }

    private void findBestSet(int index){
        if(sumWeight()>maxLoad){
            currentBP.remove(lvl);
//            int tempValue = sumValue();
//            if(tempValue >= maxValue)
//                maxLoad = tempValue;

            if(!(currentBP.equals(tempList))) {
                System.out.println(currentBP + " " + evaluate());
                tempList = new ArrayList<>(currentBP);
            }

            lvl--;
            return;
        }

        for (int i = 0; i < numberOfPieces; i++) {
            clear(i);
            currentBP.add(pieces.get(i));
            lvl++;
            findBestSet(i);
        }
        lvl--;
    }

    private void clear(int i) {
        for (int j = currentBP.size()-1; j > lvl; j--){
                currentBP.remove(j);
            }
        }

    private int sumWeight(){
        int weight = 0;
        for (Piece o: currentBP) {
            weight += o.getWeight();
        }
        return weight;
    }

    private int evaluate(){
        int tempValue = 0;
        for (Piece o: currentBP) {
            tempValue += o.getValue();
        }
        if (maxValue < tempValue) {
            maxValue=tempValue;
            maxValueBP = new ArrayList<>(currentBP);
        }
        return tempValue;
    }
}