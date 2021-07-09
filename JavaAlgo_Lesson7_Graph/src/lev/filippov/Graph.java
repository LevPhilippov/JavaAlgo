package lev.filippov;

import java.util.*;

public class Graph<E> {

//    private final int maxVertexNumber;
    private List<Vertex<E>> graph;
    private List<LinkedList<Vertex<E>>> edges;
    int size;

    public Graph() {
//        this.maxVertexNumber = maxVertexNumber;
//        graph = new ArrayList<Vertex<E>>(maxVertexNumber);
        edges = new ArrayList<LinkedList<Vertex<E>>>();
    }

    //метод добавления одного элемента в граф и в список смежности
    public void addVertex(E label) {
        //проверяем что в графе нет экземпляра этой вершины
        if (contains(label))
            throw new IllegalArgumentException("Такая вершина уже присутствует в графе");
//        graph.add(new Vertex<>(label));
        LinkedList<Vertex<E>> list = new LinkedList<>();
        list.add(new Vertex<>(label));
        edges.add(list);
    }


    //метод добавления нескольких элементов в граф
    public void addVertexes(E...labels) {
        Arrays.stream(labels).forEach(this::addVertex);
    }

    //метод добавления нескольких связей для одной вершины
    public void addEgdes(E start, E...finishes) {
        if (!findMatches(start, finishes))
            throw new IllegalArgumentException("Одна или несколько заданных вершин отсутствуют в графе");
        for (int i = 0; i <finishes.length ; i++) {
            addEdge(start, finishes[i]);
        }

    }
//проверим, что все подаваемые на вход вершины присутствуют в графе
    private boolean findMatches(E label, E...labels) {
        return Arrays.stream(labels).allMatch(this::contains) && Arrays.stream(labels).allMatch(Objects::nonNull) && Objects.nonNull(label) && contains(label) ;
    }

    public void addEdge(E start, E finish) {
        //проверить, есть ли обе вершины
        Vertex<E> startVertex = getVertex(start);
        Vertex<E> finishVertex = getVertex(finish);

        if (!findMatches(start, finish))
            throw new IllegalArgumentException("Invalid vertex: " + start);

    /*если проверка пройдена - добавить связь между вершинами (запоминание делаем для того чтобы
    сохранить ссылки на элементы в коллекции, а не создавать новые))*/

        for (LinkedList<Vertex<E>> edge : edges) {
            if(edge.getFirst().equals(startVertex)) {
                edge.add(finishVertex);
            }
            else if (edge.getFirst().equals(finishVertex)){
                edge.add(startVertex);
            }
        }
    }

    //метод поиска элемента (true/false)
    public boolean contains(E label) {
        return getVertex(label)!=null;
    }

    //поиск элемента по значению (возвращает значение или null)
    private Vertex<E> getVertex(E label) {
        for (LinkedList<Vertex<E>> edge : edges) {
            if ((edge.getFirst()).getLabel().equals(label))
                return edge.getFirst();
        }
        return null;
    }

    public void display() {
        for (LinkedList<Vertex<E>> edge : edges) {
            for (Vertex<E> vertex : edge) {
                System.out.print(vertex.getLabel());
                System.out.print("-->");
            }
            System.out.println();
        }
    }
//обход и методы обхода

    private Vertex<E> getUnvisitedVertex(Vertex<E> vertex) {
        //находим нужный список
       LinkedList <Vertex<E>> tempEdgeList = null;
        for (LinkedList<Vertex<E>> edgeList : edges) {
            if(edgeList.getFirst().equals(vertex)) {
                tempEdgeList = edgeList;
                break;
            }
        }
//        if (tempEdgeList==null)
//            return null;
        //ищем непосещенные элементы
        Vertex<E> tempUnvisitedVertex = null;

        for (int i = 0; i<tempEdgeList.size();i++) {
            if (!tempEdgeList.get(i).isVisited()) {
                tempUnvisitedVertex = tempEdgeList.get(i);
                break;
            }
        }
        return tempUnvisitedVertex;
    }

    public void dfs(E label){
        //выполним проверку на наличие такой вершины в графе
        if(!contains(label))
            throw new IllegalArgumentException("Указанной вершины не существует!");
        //проверка пройдена
        Stack <Vertex<E>> utilityStack = new Stack<>();
        Stack <Vertex<E>> displayStack = new Stack<>();
        setVisited(utilityStack, getVertex(label));
        Vertex<E> unvisitedVertex;

        while(!utilityStack.isEmpty()) {
            unvisitedVertex = getUnvisitedVertex(utilityStack.peek());
            if(unvisitedVertex != null){
                setVisited(utilityStack, unvisitedVertex);
                continue;
            }
            //вывод в консоль
            displayStack.push(utilityStack.pop());
        }
        System.out.println("Начало обхода в глубину");

        while(!displayStack.isEmpty()) {
            System.out.print(displayStack.pop() + "-->");
        }

        System.out.println("\nОбход закончен");
        //метод для обнуления состояния вершин
        clearVertexes();
    }

    private void setVisited(Stack<Vertex<E>> stack, Vertex<E> vertex ) {
        stack.push(vertex);
        stack.peek().visit();
    }

    private void setVisited(Queue<Vertex<E>> queue, Vertex<E> vertex) {
        vertex.visit();
        vertex.setPrevious(queue.peek());
        queue.add(vertex);
    }


    public void bfs (E label) {
        bfs(label, true);
    }
    //boolean переменная displayMode в состоянии true печатает обход по методу bfs, в состоянии false - используется в алгоритме поиска кратчайшего пути.
    private void bfs(E label, boolean displayMode) {
        //выполним проверку на наличие такой вершины в графе
        if(!contains(label))
            throw new IllegalArgumentException("Указанной вершины не существует!");
        //проверка пройдена
        Queue<Vertex<E>> queue = new LinkedList<Vertex<E>>(), displayList = new LinkedList<>();
        setVisited(queue, getVertex(label));
        Vertex<E> tempVertex=null;

        while (!queue.isEmpty()) {
            tempVertex = getUnvisitedVertex(queue.peek());
            if (tempVertex != null) {
                setVisited(queue, tempVertex);
                continue;
            }
            displayList.add(queue.poll());
        }

        if(displayMode){
            System.out.println("\nНачало обхода в ширину");
            while(!displayList.isEmpty())
                System.out.print(displayList.poll() + "-->");
            System.out.println("\nОбход закончен");
            clearVertexes();
        }
    }

    private void clearVertexes() {
        for (LinkedList<Vertex<E>> edge : edges) {
            for (Vertex<E> vertex : edge) {
                vertex.unVisit();
                vertex.setPrevious(null);
                vertex.getPreviousLinks().clear();
            }
        }
    }

//find shortest way algo
    public void  findShortestWay (E start, E finish) {
        if(!contains(finish) || !contains(start))
            throw new IllegalArgumentException("Не существует вершины!");

        bfs(start, false);
        Vertex<E> temp = null;

        for (LinkedList<Vertex<E>> edge : edges) {
            temp = edge.peek();
            if(temp.getLabel().equals(finish))
                break;
        }

        System.out.printf("Поиск кратчайшего маршрута от %s  к  %s\n",start,finish);
        Stack<Vertex<E>> stack = new Stack<>();

        while (!temp.getLabel().equals(start)) {
            stack.push(temp);
            temp = temp.getPrevious();
        }
        stack.push(temp);

        while (!stack.isEmpty()){
            System.out.print(stack.pop().getLabel());
            System.out.print("-->");
        }

        System.out.println();
        clearVertexes();
    }

    private void printStack(Stack<Vertex<E>> routeStacks) {
        while (!routeStacks.isEmpty()) {
            System.out.print(routeStacks.pop());
            if(routeStacks.isEmpty())
                break;
            System.out.print("->");
        }
        System.out.println();
    }

    private Stack<Vertex<E>> getStack (Vertex<E> finishVertex, Vertex<E> routeVertex) {
            Stack<Vertex<E>> stack = new Stack<>();
            stack.push(finishVertex);
            while(routeVertex != null) {
                stack.push(routeVertex);
                routeVertex = routeVertex.getPrevious();
            }
            return stack;
    }


}
