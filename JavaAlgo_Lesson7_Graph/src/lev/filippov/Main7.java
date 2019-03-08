package lev.filippov;

public class Main7 {
    public static void main(String[] args) {
        Graph<String> graph = new Graph<>(10);

//        graph.addVertex("A");
//        graph.addVertex("B");
//        graph.addVertex("C");
//        graph.addVertex("D");
//        graph.addEdge("A","B");
//        graph.addEdge("A","C");
//        graph.addEdge("A","D");

        graph.addVertexes("A", "B", "C", "D", "E");
        graph.addEgdes("A", "B", "E");
        graph.display();
        graph.bfs("A");
    }

}
