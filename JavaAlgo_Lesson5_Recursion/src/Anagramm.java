import java.util.Arrays;
import java.util.HashSet;

public class Anagramm {
    private String word;
    private char[] chars;
    private HashSet<String> stringSet;


    public Anagramm(String word) {
        this.word = word;
        chars = word.toCharArray();
        stringSet = new HashSet<>();
    }

    public void getAnagramm() {
        stringSet.clear();
        getAnagramm(0);

        for (String o: stringSet) {
            System.out.println(o);
        }
    }

    private void print() {
        stringSet.add(new String(chars));
    }

    private void getAnagramm(int index) {
        if (chars.length - index == 1) {
            return;
        }
        for (int i = index; i < chars.length; i++) {
            getAnagramm(index+1);
            print();
            char temp = chars[index];
            for (int j = index; j <chars.length-1; j++) {
                chars[j] = chars[j+1];
            }
            chars[chars.length-1] = temp;
         }
    }
}
