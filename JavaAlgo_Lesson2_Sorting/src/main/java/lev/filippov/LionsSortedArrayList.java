package lev.filippov;

public class LionsSortedArrayList<E extends Object & Comparable<E>> extends LionsArrayList<E>{

    @Override
    public void add(E value) {
        ensure_capasity();
        if(CURRENT_SIZE==0) super.add(value);
        else {
            int low = 0;
            int high = CURRENT_SIZE-1;
            int med=0;
            int index;

            while(low<high) {
                med = (low+high)/2;
                if(value.compareTo(data[med])==0) {
                    break;
                }
                if(value.compareTo(data[med])<0) {
                    high=med-1;
                } else low=med+1;

                if(low==high) {
                    med=low;
                    break;
                }
            }

            if(value.compareTo(data[med])<0 || value.compareTo(data[med])==0 /* нужно поставить value на это место*/) {
                index=med;
            } else  { //если value больше data[med], то value - следующее после med
                index=med+1;
            }

            for (int i=CURRENT_SIZE; i >index; i--) {
                data[i]=data[i-1];
            }
            data[index]=value;
            CURRENT_SIZE++;
        }
    }

    public int getBynaryIndex(E value) {
        return getBynaryIndexByValue(value);
    }

    private int getBynaryIndexByValue(E value) {
        int low = 0;
        int high = CURRENT_SIZE;

        do {
            int med = (low + high) / 2;

            if (value.compareTo(data[med]) == 0) {
                return med;
            } else if (value.compareTo(data[med]) > 0) {
                low = med + 1;
            } else {
                high = med - 1;
            }
        } while (low > high);

        return WRONG_INDEX;
    }

}
