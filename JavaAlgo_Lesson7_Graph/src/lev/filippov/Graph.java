package lev.filippov;

import java.util.*;
import java.util.stream.Stream;

public class Graph<E> {

    private final int maxVertexNumber;
    private List<Vertex<E>> graph;
    private List<LinkedList<Vertex<E>>> edges;
    int size;

    public Graph(int maxVertexNumber) {
        this.maxVertexNumber = maxVertexNumber;
//        graph = new ArrayList<Vertex<E>>(maxVertexNumber);
        edges = new ArrayList<LinkedList<Vertex<E>>>(maxVertexNumber);
    }

    //метод добавления одного элемента в граф и в список смежности
    public void addVertex(E label) {
        //проверяем что в графе нет экземпляра этой вершины
        if (find(label))
            throw new IllegalArgumentException("Такая вершина ужже присутствует в графе");
//        graph.add(new Vertex<>(label));
        edges.add(new LinkedList<Vertex<E>>(){
            {
                add(new Vertex<>(label));
            }
        });
    }


    //метод добавления нескольких элементов в граф
    public void addVertexes(E...labels) {
        Arrays.stream(labels).forEach(this::addVertex);
    }

    public void addEgdes(E start, E...finishes) {
        if (!findMatches(start, finishes))
            throw new IllegalArgumentException("Одна или несколько заданных вершин отсутствуют в графе");
        for (int i = 0; i <finishes.length ; i++) {
            addEdge(start, finishes[i]);
        }

    }
//проверим, что все подаваемые на вход вершины присутствуют в графе
    private boolean findMatches(E label, E[] labels) {
        return Arrays.stream(labels).allMatch(this::find) && find(label);
    }

    public void addEdge(E start, E finis) {
        //проверить, есть ли обе вершины
        Vertex<E> startVertex = getVertex(start);
        Vertex<E> finisVertex = getVertex(finis);
        if (startVertex==null)
            throw new IllegalArgumentException("Invalid vertex: " + start);
        else if (finisVertex==null)
            throw new IllegalArgumentException("Invalid vertex: " + finis);
    /*если проверка пройдена - добавить связь между вершинами (запоминание делаем для того чтобы
    сохранить ссылки на элементы в коллекции, а не создавать новые))*/
        for (LinkedList<Vertex<E>> edge : edges) {
            if(edge.getFirst().equals(startVertex)) {
                edge.add(finisVertex);
            }
            else if (edge.getFirst().equals(finisVertex)){
                edge.add(startVertex);
            }
        }
    }

    //метод поиска элемента (true/false)
    public boolean find(E label) {
        return getVertex(label)!=null;
    }

    //поиск элемента по значению (возвращает значение или null)
    private Vertex<E> getVertex(E label) {
        Vertex<E> tempVertex;
        for (LinkedList<Vertex<E>> edge : edges) {
            tempVertex = edge.getFirst();
            if (((Vertex) tempVertex).getLabel().equals(label))
                return tempVertex;
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
        //находим нуный список
       LinkedList <Vertex<E>> tempEdgeList = null;
        for (LinkedList<Vertex<E>> edge : edges) {
            if(edge.getFirst().equals(vertex)) {
                tempEdgeList = edge;
                break;
            }
        }
//        if (tempEdgeList==null)
//            return null;
        //ищем непосещенные элементы
        Vertex<E> tempUnvisitedVertex = null;

        for (int i = 0; i<tempEdgeList.size();i++) {
            if (!tempEdgeList.get(i).isVisited())
                tempUnvisitedVertex = tempEdgeList.get(i);
        }
        return tempUnvisitedVertex;
    }

    public void dfs(E label){
        Stack <Vertex<E>> stack = new Stack<>();
        //выполним проверку на наличие такой вершины в графе
        if(!find(label))
            throw new IllegalArgumentException("Указанной вершины не существует!");
        //проверка пройдена
        setVisitedDFS(stack, getVertex(label));
        Vertex<E> currentVertex=null;
        Vertex<E> temp;

        while(!stack.isEmpty()) {
            temp = getUnvisitedVertex(stack.peek());
            if(temp ==null) {
                //вывод в консоль
                System.out.print(stack.pop());
                System.out.print("-->");
                continue;
            }
            currentVertex = temp;
            setVisitedDFS(stack, currentVertex);
        }
        System.out.println();
        System.out.println("Обход закончен");
        //метод для обнуления посещений
        clearVertexes();
    }

    private void setVisitedDFS(Stack<Vertex<E>> stack, Vertex<E> vertex ) {
        stack.push(vertex);
        stack.peek().visit();
    }

    public void bfs (E label) {
        bfs(label, true);
    }
    //boolean переменная mode в состоянии true печатает обход по методу bfs, в состоянии false - используется в алгоритме поиска кратчайшего пути.
    private void bfs(E label, boolean mode) {
        LinkedList<Vertex<E>> queue = new LinkedList<Vertex<E>>();
        //выполним проверку на наличие такой вершины в графе
        if(!find(label))
            throw new IllegalArgumentException("Не существует вершины: " + label);
        //проверка пройдена
        setVisitedBFS(queue, getVertex(label));
        Vertex<E> currentVertex=queue.peek() ;
        Vertex<E> temp=currentVertex;
        while (!queue.isEmpty()) {
            temp = getUnvisitedVertex(currentVertex);
            if (temp == null) {
                if(mode) {
                    System.out.print(queue.pop());
                    System.out.print("-->");
                }
                queue.pop();
                currentVertex = queue.peek();
                continue;
            }
            setVisitedBFS(queue, temp);
        }
        if(mode){
            System.out.println("");
            System.out.println("Обход закончен");
        }
        if(mode)
        clearVertexes();
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

    private void setVisitedBFS(LinkedList<Vertex<E>> queue, Vertex<E> vertex) {
        vertex.visit();
        vertex.setPrevious(queue.peek());
        queue.add(vertex);
    }
//попробовал использовать реализацию перегруженного метода bfs
    public void  findShortestWay (E start, E finish) {
        if(!find(finish))
            throw new IllegalArgumentException("Не существует вершины: " + finish);

        bfs(start, false);
        Vertex<E> temp = null;
        for (LinkedList<Vertex<E>> edge : edges) {
            temp = edge.getFirst();
            if(temp.getLabel().equals(finish))
                break;
        }

        System.out.printf("Поиск кратчайшего маршрута от %s  к  %s",start,finish);
        System.out.println();
        Stack<E> stack = new Stack<>();
        while (temp !=null) {
            stack.push(temp.getLabel());
            temp = temp.getPrevious();
        }
        while (!stack.isEmpty()){
            System.out.print(stack.pop());
            System.out.print("-->");
        }
        System.out.println();
        clearVertexes();
    }


    public void findAllWays(E start, E finish, int targetLevel) {
        Vertex <E> routes = evaluateAllWays(start, finish, targetLevel);
        System.out.println(routes + " " + routes.getPreviousLinks());
        for (Vertex<E> vertex : routes.getPreviousLinks()) {
            printStack(getStack(routes, vertex));
        }
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

    private Vertex<E> evaluateAllWays (E start, E finish, int targetLevel) {
        if (!find(start) || !find(finish) || start.equals(finish))
            throw new IllegalArgumentException("Illegal start of finish point");

        LinkedList<Vertex<E>> queue = new LinkedList<>();
        LinkedList<Vertex<E>> nextToQueueList = new LinkedList<>();
        Vertex<E> outerVertex=null, innerVertex=null;
        int routeLevel=0;

        getVertex(start).visit();
        queue.add(getVertex(start));

        while(!queue.isEmpty()) {

            while (!queue.isEmpty()) {
                innerVertex = getUnvisitedVertex(queue.peek());

                while (innerVertex != null) {

                    if (isFinishVertex(finish,innerVertex)) {
                        outerVertex=innerVertex;
                        innerVertex.getPreviousLinks().add(queue.peek());
                        break;
                    }
                        nextToQueueList.push(innerVertex);
                        innerVertex = visitCurrentAndGetNextVertex(queue, innerVertex);
                }

                queue.pop();
            }

            if (outerVertex != null) { //здесь всегда будет nullpointerEx
                if(routeLevel==targetLevel) {
                    break;
                }

            routeLevel++;
            }

            fillTheQueue(queue, nextToQueueList);
            nextToQueueList.clear();
        }

        return outerVertex;
    }

    private boolean isFinishVertex(E finish, Vertex<E> innerVertex) {
        return innerVertex.getLabel().equals(finish);
    }

    private void fillTheQueue(LinkedList<Vertex<E>> queue, LinkedList<Vertex<E>> nextToQueueList) {
        if(!nextToQueueList.isEmpty()){
            for (Vertex<E> vertex : nextToQueueList) {
                queue.push(vertex);
            }
        }
    }

    private Vertex<E> visitCurrentAndGetNextVertex(LinkedList<Vertex<E>> queue, Vertex<E> innerVertex) {
        Vertex<E> previous = queue.peek();
        innerVertex.visit();
        innerVertex.setPrevious(previous);
        return getUnvisitedVertex(previous);
    }
}
