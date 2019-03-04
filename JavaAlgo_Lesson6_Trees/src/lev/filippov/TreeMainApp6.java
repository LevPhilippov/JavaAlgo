package lev.filippov;

public class TreeMainApp6 {
    public static void main(String[] args) {
        Tree<Integer> tree = new TreeImpl<>();
        tree.insert(60);
        tree.insert(20);
        tree.insert(70);
        tree.insert(25);
        tree.insert(18);
        tree.insert(68);

        tree.display();
//        System.out.println(tree.find(60));
//        System.out.println(tree.find(25));
//        System.out.println(tree.find(68));
//        System.out.println(tree.find(70));
//        System.out.println(tree.find(20));
//        System.out.println(tree.find(666));
//
//
//        tree.traverse(Tree.TaverseMode.IN_ORDER);
//        System.out.println("---------------------");
//        tree.traverse(Tree.TaverseMode.PRE_ORDER);
//        System.out.println("---------------------");
//        tree.traverse(Tree.TaverseMode.POST_ORDER);

//        tree.traverse(Tree.TaverseMode.IN_ORDER);
//        System.out.println("---------------------");
//        System.out.println(tree.delete(20));
//        tree.traverse(Tree.TaverseMode.IN_ORDER);
//        System.out.println("---------------------");
    }
}
