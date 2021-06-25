package filippov.lev.filippov;

import java.util.ArrayList;
import java.util.Random;
import java.util.function.Supplier;

public class TreeMainApp6 {

    public static void main(String[] args) {

        int maxPenetrationLevel = 4;

        TreeImpl<Integer> tree;
        ArrayList<TreeImpl<Integer>> treeList = new ArrayList<>();
        Random random = new Random();

        //Supplier<TreeImpl> supplier = TreeImpl::new;

        for (int i = 0; i < 1000; i++) {

            tree = new TreeImpl<>(maxPenetrationLevel);
         //   tree = supplier.get();

            for (int j = 0; j <20 ; j++) {
                int value = ((int)((random.nextDouble()*201) - 100));
                tree.insert(value);
            }
            treeList.add(tree);
        }
        int unbalancedTrees =0;
//
        for (TreeImpl<Integer> o: treeList) {
            o.display();
            if(!(o.isBalanced()))
                unbalancedTrees++;
        }

        System.out.printf("Количество насбалансированных деревьев в выборке из %1$d составляет %2$d",treeList.size(), unbalancedTrees);

    }


}
