package filippov.lev.filippov;

public class Main7 {
    public static void main(String[] args) {
        Graph<String> graph = new Graph<>(10);

        graph.addVertexes("Москва", "Тула", "Калуга", "Липецк", "Воронеж", "Саратов", "Тамбов", "Рязань", "Орел", "Курск");
        graph.addEgdes("Москва", "Тула", "Рязань", "Калуга");
        graph.addEdge("Тула", "Липецк");
        graph.addEdge("Липецк", "Воронеж");
        graph.addEdge("Рязань", "Тамбов");
        graph.addEdge("Тамбов", "Саратов");
        graph.addEdge("Саратов", "Воронеж");
        graph.addEdge("Калуга", "Орел");
        graph.addEdge("Орел", "Курск");
        graph.addEdge("Курск", "Воронеж");
        graph.display();
//        graph.dfs("Москва");
//        graph.bfs("Москва");
     //   graph.findShortestWay("Москва", "Воронеж");

        //graph.bfs("A");
        graph.findAllWays("Москва", "Воронеж",2);
    }

}
