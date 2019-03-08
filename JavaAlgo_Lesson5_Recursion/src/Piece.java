public class Piece {

    String name;
    int value;
    int weight;

    public Piece(String name, int weight, int value) {
        this.name = name;
        this.value = value;
        this.weight = weight;
        }

    public String getName() {
        return name;
        }

    public int getValue() {
        return value;
        }

    public int getWeight() {
        return weight;
        }

    @Override
    public String toString() {
        return name;
        }
        }
