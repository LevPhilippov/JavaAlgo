package lev.filippov;

import java.util.ArrayList;
import java.util.Random;

public class TreeMainApp6 {

    public static void main(String[] args) {

        int maxPenetrationLevel = 2;

        ArrayList<TreeImpl<Integer>> treeList = new ArrayList<>();
        Random random = new Random();


        for (int i = 0; i < 1000; i++) {
            TreeImpl<Integer> integerTree = new TreeImpl<>(maxPenetrationLevel, true);

            for (int j = 0; j <Math.pow(maxPenetrationLevel,2)-1 ; j++) {
                integerTree.insert(random.nextInt(41)-20);
            }
            treeList.add(integerTree);
        }
        int unbalancedTrees =0;
//
        for (TreeImpl<Integer> o: treeList) {
//            o.display();
            if(!(o.isBalanced()))
                unbalancedTrees++;
        }

        System.out.printf("Количество несбалансированных деревьев в выборке из %1$d составляет %2$d",treeList.size(), unbalancedTrees);

    }


}
