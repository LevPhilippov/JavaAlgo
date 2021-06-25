import philippov.Array;
import philippov.LionsArrayList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class LionsArrayTests {

    Array<Integer> testArray = new LionsArrayList<>();



@BeforeEach
void fillArray() {
    testArray.add(5);
    testArray.add(3);
    testArray.add(87);
    testArray.add(14);
    testArray.add(27);
    testArray.add(58);

}
    @Test
    void addTest(){
        Assertions.assertEquals(5, testArray.get(0));
        Assertions.assertEquals(3, testArray.get(1));
        Assertions.assertEquals(87, testArray.get(2));
        Assertions.assertEquals(14, testArray.get(3));
        Assertions.assertEquals(27, testArray.get(4));
        Assertions.assertEquals(58, testArray.get(5));
    }

    @Test
    void containsTest() {
        Assertions.assertTrue(testArray.contains(14));
        Assertions.assertTrue(testArray.contains(5));
        Assertions.assertTrue(testArray.contains(87));
        Assertions.assertFalse(testArray.contains(33));
        Assertions.assertFalse(testArray.contains(110));

    }

    @Test
    void removeByIndexTest(){
        int indexToRemove = testArray.size()-1;
        Assertions.assertTrue(testArray.remove(indexToRemove));
        Assertions.assertFalse(testArray.contains(58));
        Assertions.assertNull(testArray.get(indexToRemove));
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> testArray.remove(32));

    }

    @Test
    void removeByValueTest() {
        Integer valueToRemove = 14;
        Assertions.assertTrue(testArray.remove(valueToRemove));
        Assertions.assertFalse(testArray.contains(valueToRemove));
    }

    @Test
    void getIndexTest(){
        Assertions.assertEquals(0, testArray.getIndex(5));
        Assertions.assertEquals(1, testArray.getIndex(3));
        Assertions.assertEquals(2, testArray.getIndex(87));
        Assertions.assertEquals(5, testArray.getIndex(58));
    }

    @Test
    void getTest(){
        Assertions.assertEquals(5,testArray.get(0));
        Assertions.assertEquals(3,testArray.get(1));
        Assertions.assertEquals(87,testArray.get(2));
        Assertions.assertEquals(58,testArray.get(5));
    }
}
