package lev.filippov;

import oracle.jrockit.jfr.ActiveSettingEvent;
import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class SingleListTest {
    LionSimpleLinkedListImpl<Integer> sslist;
    final static int WRONG = 777;

@Before
    public void test1() {
    sslist = new LionSimpleLinkedListImpl() {
        {
            add(1);
            add(333);
            add(1);
            add(2);
            add(3);
            add(5);
            add(7);
            add(12);
        }
    };
}

        @Test
        public void removeTest() {
        Assert.assertThat(12, Is.is(sslist.removeFirst()));
        Assert.assertThat(7,Is.is(sslist.getFirst()));
        }
        @Test
    public void removeTest2() {
    Assert.assertThat(2, Is.is(sslist.remove(2)));
        }

        @Test
    public void addTest() {
    sslist.add(WRONG);
    Assert.assertThat(WRONG, Is.is(sslist.getFirst()));
        }
}
