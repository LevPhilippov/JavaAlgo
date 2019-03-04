package lev.filippov;

import java.util.ArrayList;
import java.util.Random;

public class TreeMainApp6 {

    public static void main(String[] args) {

        TreeImpl<Integer> tree;
        ArrayList<TreeImpl<Integer>> treeList = new ArrayList<>();
        Random random = new Random();


        for (int i = 0; i < 20; i++) {

            tree = new TreeImpl<>();

            for (int j = 0; j <20 ; j++) {
                int value = ((int)((random.nextDouble()*201) - 100));
                tree.insert(value);
            }
            treeList.add(tree);
        }
        double treeBalance = 0;

        for (TreeImpl<Integer> o: treeList) {
            o.display();
            treeBalance += o.checkBalance();
            System.out.println();
        }
        System.out.println("Среднеарифметическое процентное соотношение левой стороны дерева к общему количеству элементов: " + treeBalance/treeList.size());

    }
}
