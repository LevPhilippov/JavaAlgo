package lev.filippov;

public class Main7 {
    public static void main(String[] args) {
        Graph<String> graph=null;
//        displayDfs(graph);
//            displayBfs(graph);
//
        findShortestWay(graph);
        //graph.bfs("A");
//        graph.findAllWays("Москва", "Воронеж",2);
    }

    private static void displayDfs(Graph<String> graph) {
        graph=new Graph<>();
        graph.addVertexes("Москва", "Тула", "Калуга", "Липецк", "Воронеж", "Саратов", "Тамбов", "Рязань", "Орел", "Курск");
        graph.addEgdes("Москва", "Тула", "Рязань", "Калуга");
        graph.addEdge("Тула", "Липецк");
        graph.addEdge("Липецк", "Воронеж");
        graph.addEdge("Рязань", "Тамбов");
        graph.addEdge("Тамбов", "Саратов");
        graph.addEdge("Калуга", "Орел");
        graph.addEdge("Орел", "Курск");
        graph.dfs("Москва");
    }
    private static void displayBfs(Graph<String> graph) {
        graph=new Graph<>();
        graph.addVertexes("Москва", "Тула", "Калуга", "Липецк", "Воронеж", "Саратов", "Тамбов", "Рязань", "Орел", "Курск");
        graph.addEgdes("Москва", "Тула", "Рязань", "Калуга");
        graph.addEdge("Тула", "Липецк");
        graph.addEdge("Липецк", "Воронеж");
        graph.addEdge("Рязань", "Тамбов");
        graph.addEdge("Тамбов", "Саратов");
        graph.addEdge("Калуга", "Орел");
        graph.addEdge("Орел", "Курск");
        graph.bfs("Москва");
    }

    private static void findShortestWay(Graph<String> graph) {
        graph=new Graph<>();
        graph.addVertexes("Москва", "Тула", "Калуга", "Липецк", "Воронеж", "Саратов", "Тамбов", "Рязань", "Орел", "Курск");
        graph.addEgdes("Москва", "Тула", "Рязань", "Калуга");
        graph.addEdge("Тула", "Липецк");
        graph.addEdge("Липецк", "Воронеж");
        graph.addEdge("Рязань", "Тамбов");
        graph.addEdge("Тамбов", "Саратов");
        graph.addEdge("Калуга", "Орел");
        graph.addEdge("Орел", "Курск");
        graph.addEdge("Саратов", "Воронеж");
        graph.addEdge("Курск", "Воронеж");

        graph.findShortestWay("Москва", "Воронеж");
    }


}
