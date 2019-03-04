package lev.filippov;

import java.util.Stack;


public class TreeImpl<E extends Comparable<? super E>> implements Tree<E> {

    public static final int PENETRATION_LEVEL = 4;
    private Node<E> rootNode;
    private boolean PENETRATION_MODE=true;

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
            rootNode = currentNode;
            //блок пенетрации
            if (PENETRATION_MODE){
                currentNode.penetrate();
            }
            //блок пенетрации
            return;
        }

        //блок пенетрации
        if (PENETRATION_MODE){
            currentNode.penetrate();
        }
        //блок пенетрации

        //если корень уже существует, ищем место @targetNode для вставляемого элемента
        //элемент-курсор
        Node<E> targetNode = rootNode;
        //элемент-родитель
        Node<E> parentNode = rootNode;
        while(targetNode!=null) {
            parentNode = targetNode;
            if(value.compareTo(targetNode.getValue()) < 0) { // идем влево от узла
                targetNode = parentNode.getLeftChild();
                //блок пенетрации
                if (PENETRATION_MODE){
                    if(currentNode.getPenetrationLevel() < PENETRATION_LEVEL)
                    currentNode.penetrate();
                    else return;
                }
                //блок пенетрации
            }
            else if (value.compareTo(targetNode.getValue()) > 0)  {  //идем вправо от узла
                targetNode = parentNode.getRightChild();
                //блок пенетрации
                if (PENETRATION_MODE){
                    if(currentNode.getPenetrationLevel() < PENETRATION_LEVEL)
                        currentNode.penetrate();
                    else return;
                }
                //блок пенетрации
            }
            else { //если мы вставляем элемент, который уже присутствует в дереве
                return;
                //throw new IllegalArgumentException("Such element is already exist in the tree.");
            }
        }
        //когда место найдено снова делаем проверочную операцию для определения, будет это левый или правый child
        if(value.compareTo(parentNode.getValue()) < 0) { // идем влево от узла
            parentNode.setLeftChild(currentNode);
        }
        else {  //идем вправо от узла
            parentNode.setRightChild(currentNode);
        }
    }


    @Override
    public boolean find(E value) {
        //элемент-курсор
        Node<E> targetNode = rootNode;

        while(targetNode!=null) {
            if (value.equals(targetNode.getValue()))
                return true;
            // идем влево от узла
            if(value.compareTo(targetNode.getValue()) < 0) {
                targetNode = targetNode.getLeftChild();
            }
            else {  //идем вправо от узла (на этом этапе уже не должно быть одинаковых элементов)
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
        else if (isLeaf(targetNode)) {
            if(parentNode.getLeftChild().getValue().equals(value)){
                parentNode.setLeftChild(null);
            }
            else {
                parentNode.setRightChild(null);
            }
            //return true;
        }
        //если элемент имеет только одного наследника
        else if (hasOnlyOneChild(targetNode)) {
            //определяем дочерний элемент для удаляемого
            Node<E> childNode = targetNode.getLeftChild() != null
                    ? targetNode.getLeftChild()
                    : targetNode.getRightChild();
            //если удаляемы элемент - корень
                if(targetNode==rootNode) {
                rootNode=childNode;
                }
            //удаляемый элемент является левым у родителя
                else if(value.equals(parentNode.getLeftChild().getValue())){
                    parentNode.setLeftChild(childNode);
                }
                else {
                    parentNode.setRightChild(childNode);
                }
            //если только правый элемент
                if(value.equals(parentNode.getLeftChild().getValue())){
                    parentNode.setLeftChild(childNode);
                }
                else {
                    parentNode.setRightChild(childNode);
                }
            //return true;
        }
        //если у удаляемого элемента есть оба наследника
        else {
        // поиск идеального кандидата на замену и подмена наследования для subNode
            Node<E> subNode = findSubstitute(targetNode);
            //если у подменного элемента есть правый наследник? то ссылка на него уже присвоена
            // родителю subNode
            //подменяем ссылки на левые дочерние элементы
            subNode.setLeftChild(targetNode.getLeftChild());
            //подменем ссылки направые доерние элементы
            subNode.setRightChild(targetNode.getRightChild());
            //меняем ссылку родетеля удаляемого элемента
            if(value.equals(parentNode.getLeftChild().getValue())){
                parentNode.setLeftChild(subNode);
            }
            else {
                parentNode.setRightChild(subNode);
            }
           // return true;
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
        //заменяем ссылку родителя subNode на дочернюю subNode
            if(parSubNode.getLeftChild().equals(subNode)){
                parSubNode.setLeftChild(subNode.getRightChild());
            }
            else {
                parSubNode.setRightChild(subNode.getRightChild());
            }
        return subNode;
    }
    //пара методов для проверки баланса дерева
    public double checkBalance() {
        int startCountFrom = 0;
        int leftSide= checkSide(rootNode.getLeftChild(), startCountFrom);
        int rightSide= checkSide(rootNode.getRightChild(), startCountFrom);
        return leftSide*100/(rightSide+leftSide);

    }

    private int checkSide(Node<E> currentNode, int counter){
        if(currentNode==null)
            return counter;
        counter++;
        counter = checkSide(currentNode.getLeftChild(), counter);
        counter = checkSide(currentNode.getRightChild(), counter);
        return counter;
    }
}
