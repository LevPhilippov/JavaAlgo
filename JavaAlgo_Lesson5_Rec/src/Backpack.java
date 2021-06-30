import java.util.*;

public class Backpack {

    public static enum Items {
        BOOK(1, 600), BINOCULAR(2, 5000), MEDICINE(4, 1500),
        LAPTOP(2, 40000), POT(1, 500);

        private int weght;
        private int price;

        Items(int weght, int price) {
            this.weght = weght;
            this.price = price;
        }

        public int getWeght() {
            return weght;
        }

        public int getPrice() {
            return price;
        }

        @Override
        public String toString() {
            return "Items{" +
                    "weght=" + weght +
                    ", price=" + price +
                    '}';
        }
    }

    //масимальный вес рюкзака
    private int max_weight;

    //хранилище для лучшего набора
    private List<List<Items>> backpacksList;

    //переменная для хранения максимальной цены набора
    private int max_cost_set;

    //хранилище для Items
    private List<Items> items;

    public Backpack(int max_weight) {
//        this.backpacksList = new HashSet<>();
        this.backpacksList = new ArrayList<>();
        this.max_weight = max_weight;
        this.items = new ArrayList<>();
        items.addAll(Arrays.asList(Items.BOOK, Items.BINOCULAR, Items.MEDICINE, Items.LAPTOP, Items.POT));
    }


    public void findMaxValuableBackpack() {
        backpacksList.clear();
        findMaxValuableBackpack(new ArrayList<>());
        for (List<Items> itemsList : backpacksList) {
            System.out.printf("------------\nЦена содержимого: %d\nВес содержимого: %d\nСодержимое:\n", getCurrentCost(itemsList), getCurrentWeight(itemsList));
            for (Items i : itemsList) {
                System.out.print(i.name() + ", ");
            }
        }
    }

    private void findMaxValuableBackpack(List<Items> currentList) {

        if(getCurrentWeight(currentList) > max_weight){
            return;
        }

        for (int index = 0; index < items.size(); index++) {
            currentList.add(items.get(index));
            findMaxValuableBackpack(currentList);
            currentList.remove(currentList.size()-1);

            int cost_set = getCurrentCost(currentList);

            if (cost_set == max_cost_set) {
                if(!backpacksList.get(backpacksList.size()-1).equals(currentList))
                    backpacksList.add(new ArrayList<>(currentList));
            }
            else if (cost_set > max_cost_set){
                max_cost_set = cost_set;
                backpacksList.clear();
                backpacksList.add(new ArrayList<>(currentList));
//                System.out.println(max_cost_set);
            }
      }
    }

    private int getCurrentWeight(List<Items> currentList) {
        return currentList.stream().mapToInt(Items::getWeght).sum();
    }

    private int getCurrentCost(List<Items> currentList) {
        return currentList.stream().mapToInt(Items::getPrice).sum();
    }


}
