package lev.filippov;

import java.util.Stack;


public class TreeImpl<E extends Comparable<? super E>> implements Tree<E> {

    public static final int DEFAULT_PENETRATION_LEVEL = 6;
    public static int ALLOWED_PENETRATION_LEVEL;
    private Node<E> rootNode;
    private boolean PENETRATION_MODE;
    private static boolean DEFAULT_PENETRATION_MODE=false;


    public TreeImpl(int maxPenetrationLevel, boolean PENETRATION_MODE) {
        this.ALLOWED_PENETRATION_LEVEL = maxPenetrationLevel;
        this.PENETRATION_MODE = PENETRATION_MODE;
    }

    public TreeImpl () {
        this(DEFAULT_PENETRATION_LEVEL, DEFAULT_PENETRATION_MODE);
    }

    @Override
    public void clear(){
        rootNode=null;
    }

    @Override
    public void insert(E value) {
        //текущий элемент в обертке
        Node<E> currentNode = new Node<E>(value);
        //если вставляется первый элемент
        if(rootNode==null) {
            //блок пенетрации не применяется, т.к. это 0 уровень
            rootNode = currentNode;
            return;
        }
//        //блок пенетрации
//        if (PENETRATION_MODE && currentNode != rootNode){ //we should apply "=" because we have to ensure that a currentNode is not the rootNode
//            currentNode.penetrate();
//        }
        //если rootNode уже существует, ищем место @targetNode для вставляемого элемента
        Node<E> targetNode = rootNode;//элемент-курсор
        Node<E> parentNode = rootNode;//элемент-родитель

        int PENETRATION_LEVEL=0;

        while(targetNode!=null) {
            if (currentNode.equals(targetNode)) {
                return; // Element is already exist in a Tree
            }
            parentNode = targetNode;

            if(currentNode.isLeftChild(parentNode)) { // идем влево от узла
                targetNode = parentNode.getLeftChild();
                //блок пенетрации
                if (PENETRATION_MODE){
                    if(++PENETRATION_LEVEL > ALLOWED_PENETRATION_LEVEL)
                        return;
//                    if(currentNode.getPenetrationLevel() < ALLOWED_PENETRATION_LEVEL)
//                    currentNode.penetrate();
//                    else return;
                }
            }
            else {  //идем вправо от узла
                targetNode = parentNode.getRightChild();
                //блок пенетрации
                if (PENETRATION_MODE){
                    if(++PENETRATION_LEVEL > ALLOWED_PENETRATION_LEVEL)
                        return;
//                    if(currentNode.getPenetrationLevel() < ALLOWED_PENETRATION_LEVEL)
//                        currentNode.penetrate();
//                    else return;
                }
            }
        }
        //когда место найдено снова делаем проверочную операцию для определения, будет это левый или правый child
        if(currentNode.isLeftChild(parentNode)) { // идем влево от узла
            parentNode.setLeftChild(currentNode);
        }
        else {  //идем вправо от узла
            parentNode.setRightChild(currentNode);
        }
    }

    @Override
    public boolean find(E value) {
        Node<E> targetNode = rootNode;//элемент-курсор
        Node<E> requiredNode = new Node<>(value);
        while(targetNode!=null) {
            if (targetNode.equals(requiredNode))
                return true;
            // идем влево от узла
            if(requiredNode.isLeftChild(targetNode)) {
                targetNode = targetNode.getLeftChild();
            }
            else {//идем вправо от узла (на этом этапе уже не должно быть одинаковых элементов)
                targetNode = targetNode.getRightChild();
            }
        }
        return false;
    }

    @Override
    public boolean delete(E value) {
        //элемент-курсор
        Node<E> targetNode = rootNode;
        Node<E> parentNode = rootNode;

        //поиск элемента
        while(targetNode!=null) {
            //если искомый элемент найден - выходим из цикла
            if (value.equals(targetNode.getValue()))
                break;
            //если нет - запоминаем родителя.
            parentNode=targetNode;
            // идем влево от узла
            if(value.compareTo(targetNode.getValue()) < 0) {
                targetNode = targetNode.getLeftChild();
            }
            else {  //идем вправо от узла (на этом этапе уже не должно быть одинаковых элементов)
                targetNode = targetNode.getRightChild();
            }
        }
        //если элемент не найден - вернем false
        if (targetNode==null)
            return false;

        //если элемент является листом
        if (isLeaf(targetNode)) {
            if(parentNode.getLeftChild().equals(targetNode)){
                parentNode.setLeftChild(null);
            }
            else {
                parentNode.setRightChild(null);
            }
        }
        //если элемент имеет только одного наследника
        else if (hasOnlyOneChild(targetNode)) {
            //определяем дочерний элемент для удаляемого
            Node<E> childNode = (targetNode.getLeftChild() != null)
                    ? targetNode.getLeftChild()
                    : targetNode.getRightChild();
            //если удаляемы элемент - корень
                if(targetNode==rootNode) {
                rootNode=childNode;
                }
            //удаляемый элемент является левым у родителя
                else if(targetNode.equals(parentNode.getLeftChild())){
                    parentNode.setLeftChild(childNode);
                }
                else {
                    parentNode.setRightChild(childNode);
                }
        }
        //если у удаляемого элемента есть оба наследника
        else {
        // поиск идеального кандидата на замену и подмена наследования для subNode
            Node<E> subNode = findSubstitute(targetNode);
            //если у подменного элемента есть правый наследник? то ссылка на него уже присвоена
            // родителю subNode (или удаляемому элементу в случае, если у правого наследника targetNode нет левых наследников)
            //подменяем ссылки на левые дочерние элементы
            subNode.setLeftChild(targetNode.getLeftChild());
            //подменем ссылки направые доерние элементы
            subNode.setRightChild(targetNode.getRightChild());
            //меняем ссылку родетеля удаляемого элемента
            if(targetNode.equals(parentNode.getLeftChild())){
                parentNode.setLeftChild(subNode);
            }
            else {
                parentNode.setRightChild(subNode);
            }
        }
        return true;
    }

    private boolean hasOnlyOneChild(Node<E> targetNode) {
        return targetNode.getLeftChild() == null || targetNode.getRightChild() == null;
    }

    private boolean isLeaf(Node<E> targetNode) {
        return targetNode.getLeftChild()==null && targetNode.getRightChild()==null;
    }

    @Override
    public void display() {
        Stack<Node> globalStack = new Stack();
        globalStack.push(rootNode);
        int nBlanks = 64;

        boolean isRowEmpty = false;
        System.out.println("................................................................");

        while (!isRowEmpty) {
            Stack<Node> localStack = new Stack<>();

            isRowEmpty = true;
            for (int i = 0; i < nBlanks; i++) {
                System.out.print(" ");
            }

            while (!globalStack.isEmpty()) {
                Node tempNode = globalStack.pop();
                if (tempNode != null) {
                    System.out.print(tempNode.getValue());
                    localStack.push(tempNode.getLeftChild());
                    localStack.push(tempNode.getRightChild());
                    if (tempNode.getLeftChild() != null || tempNode.getRightChild() != null) {
                        isRowEmpty = false;
                    }
                } else {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < nBlanks * 2 - 2; j++) {
                    System.out.print(" ");
                }
            }

            System.out.println();

            while (!localStack.isEmpty()) {
                globalStack.push(localStack.pop());
            }

            nBlanks /= 2;
        }
        System.out.println("................................................................");
    }

    @Override
    public void traverse(TaverseMode mode) {
        switch (mode){
            case IN_ORDER:
                inOrder(rootNode);
                break;
            case PRE_ORDER:
                preOrder(rootNode);
                break;
            case POST_ORDER:
                postOrder(rootNode);
                break;
                default: throw new IllegalArgumentException("Unknown mode");
        }

    }

    private void postOrder(Node<E> node) {
        if (node==null)
            return;
        postOrder(node.getLeftChild());
        postOrder(node.getRightChild());
        System.out.println(node);
    }

    private void preOrder(Node<E> node) {
        if (node==null)
            return;
        System.out.println(node);
        preOrder(node.getLeftChild());
        preOrder(node.getRightChild());
    }

    private void inOrder(Node<E> node) {
        if (node==null)
            return;
        inOrder(node.getLeftChild());
        System.out.println(node);
        inOrder(node.getRightChild());
    }

    private Node<E> findSubstitute(Node<E> targetNode) {
        Node<E> subNode = targetNode.getRightChild();
        Node<E> parSubNode = targetNode;

        while (subNode.getLeftChild()!= null) {
            parSubNode = subNode;
            subNode = subNode.getLeftChild();
        }
            //если у правого child'a targetNode нет левых наследников
            if(parSubNode.getRightChild().equals(subNode)) {
                parSubNode.setRightChild(subNode.getRightChild());
            } else
        //если у правого child'a targetNode есть левые наследники
            if(parSubNode.getLeftChild().equals(subNode)){
                parSubNode.setLeftChild(subNode.getRightChild());
            }

        return subNode;
    }
    //пара методов для проверки баланса дерева
//    public double checkBalance() {
//        int startCountFrom = 0;
//        int leftSide= checkSide(rootNode.getLeftChild(), startCountFrom);
//        int rightSide= checkSide(rootNode.getRightChild(), startCountFrom);
//        return leftSide*100/(rightSide+leftSide);
//
//    }
//    public int findUnbalancedTree() {  //преположим, что если у дерева одна меньше 30%
//        int startCountFrom = 0;
//        int leftSide= checkSide(rootNode.getLeftChild(), startCountFrom);
//        int rightSide= checkSide(rootNode.getRightChild(), startCountFrom);
//
//        if (leftSide*100/(rightSide+leftSide)<0.3 || rightSide*100/(rightSide+leftSide)<0.3 )
//            return 1;
//        else return 0;
//    }
//
//
//    private int checkSide(Node<E> currentNode, int counter){
//        if(currentNode==null)
//            return counter;
//        counter++;
//        counter = checkSide(currentNode.getLeftChild(), counter);
//        counter = checkSide(currentNode.getRightChild(), counter);
//        return counter;
//    }


    public boolean isBalanced() {
        return isBalanced(rootNode);
    }

    private static boolean isBalanced(Node node) {
        return (node == null) ||
                isBalanced(node.getLeftChild()) &&
                        isBalanced(node.getRightChild()) &&
                        Math.abs(height(node.getLeftChild()) - height(node.getRightChild())) <= 1;
    }

    private static int height(Node node) {
        return node == null ? 0 : 1 + Math.max(height(node.getLeftChild()), height(node.getRightChild()));
    }
}
