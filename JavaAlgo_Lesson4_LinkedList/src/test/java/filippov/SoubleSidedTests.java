package lev.filippov;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SoubleSidedTests {
    LionDoubleSidedLinkedListImpl<Integer> dslist;
    final static int WRONG = 777;

    @Before
    public void createArray() {
        dslist = new LionDoubleSidedLinkedListImpl(){
            {
                add(33);
                addLast(222);
                addLast(444);
                add(3);
                add(5);
                addLast(666);
                add(12);
                add(33);
                addLast(54);
                addLast(67);
                addLast(88);
                addLast(15);
                add(89);
                addLast(56);

            }
        };
    }
    @Test
    public void addFirst(){
        dslist.add(WRONG);
        Assert.assertThat(WRONG, Is.is(dslist.getFirst()));
    }

    @Test
    public void addLast(){
        dslist.addLast(WRONG);
        Assert.assertThat(WRONG, Is.is(dslist.getLast()));
    }

    @Test
    public void removeFirst(){
        Assert.assertThat(89, Is.is(dslist.removeFirst()));
        Assert.assertThat(33, Is.is(dslist.getFirst()));
    }

    @Test
    public void removeLast() {
        Assert.assertThat(56, Is.is(dslist.removeLast()));
        Assert.assertThat(15, Is.is(dslist.getLast()));
    }

    @Test
    public void removeValue(){
        Assert.assertThat(222, Is.is(dslist.remove(222)));
    }

    @Test
    public  void removeWrongValue() {
        Assert.assertThat(null, Is.is(dslist.remove(WRONG)));
    }

    @Test
    public void removeAllFromFront(){
        int i = dslist.size;
        for (int j = 0; j <=i ; j++) {
            dslist.removeFirst();
        }
        Assert.assertThat(0, Is.is(dslist.size));
    }
    @Test
    public void removeMoreThanAllFromFront(){
        int i = dslist.size*2;
        for (int j = 0; j <=i ; j++) {
            dslist.removeFirst();
        }
        Assert.assertThat(0, Is.is(dslist.size));
    }

    @Test
    public void removeAllFromRear(){
        int i = dslist.size;
        for (int j = 0; j <=i ; j++) {
            dslist.removeLast();
        }
        Assert.assertThat(0, Is.is(dslist.size));
    }
    @Test
    public void removeMoreThanAllFromrear(){
        int i = dslist.size*2;
        for (int j = 0; j <=i ; j++) {
            dslist.removeLast();
        }
        Assert.assertThat(0, Is.is(dslist.size));
    }

}
