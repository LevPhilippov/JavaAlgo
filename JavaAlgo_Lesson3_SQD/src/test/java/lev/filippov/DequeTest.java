package lev.filippov;

import lev.filippov.interfaces.Deque;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class DequeTest {
    Deque<Integer> testDeque;
    private final static int DEQUE_SIZE = 16;




    @Test
    @BeforeEach
    void pushTest(){
        testDeque=new LionsDeque<>(DEQUE_SIZE);
        Random random = new Random();

        for (int i = 0; i < DEQUE_SIZE; i++) {
            testDeque.insertRight(random.nextInt());
        }

        Assertions.assertEquals(DEQUE_SIZE, testDeque.getSize());
        Assertions.assertTrue(testDeque.isFull());
        Assertions.assertThrows(RuntimeException.class, ()-> testDeque.insertLeft(1));
    }

    @Test
    void insertRightTest() {
        testDeque=new LionsDeque<>(DEQUE_SIZE);
        Random random = new Random();

        for (int i = 0; i < DEQUE_SIZE; i++) {
            testDeque.insertLeft(random.nextInt());
        }

        Assertions.assertEquals(DEQUE_SIZE, testDeque.getSize());
        Assertions.assertTrue(testDeque.isFull());
        Assertions.assertThrows(RuntimeException.class, ()-> testDeque.insertRight(1));

    }

    @Test
    void insertLeftRigntTest(){
        testDeque=new LionsDeque<>(DEQUE_SIZE);
        Random random = new Random();
        for (int i = 0; i < DEQUE_SIZE/2; i++) {
            testDeque.insertLeft(random.nextInt());
            testDeque.insertLeft(random.nextInt());
        }
        Assertions.assertEquals(DEQUE_SIZE, testDeque.getSize());
        Assertions.assertTrue(testDeque.isFull());
        Assertions.assertThrows(RuntimeException.class, ()-> testDeque.insertRight(1));
    }

    @Test
    void deleteLeftRightTest(){
        for (int i = DEQUE_SIZE; i > 0 ; i-=2) {
            Assertions.assertEquals(i, testDeque.getSize());
            testDeque.deleteLeft();
            testDeque.deleteRight();
        }
        Assertions.assertThrows(RuntimeException.class, ()-> testDeque.deleteLeft());
    }


    @Test
    void deleteLeftTest(){
        for (int i = DEQUE_SIZE; i > 0 ; i--) {
            Assertions.assertEquals(i, testDeque.getSize());
            testDeque.deleteLeft();
        }
            Assertions.assertThrows(RuntimeException.class, ()-> testDeque.deleteLeft());
    }

    @Test
    void deleteRightTest(){
        for (int i = DEQUE_SIZE; i > 0 ; i--) {
            Assertions.assertEquals(i, testDeque.getSize());
            testDeque.deleteRight();
        }
        Assertions.assertThrows(RuntimeException.class, ()-> testDeque.deleteRight());
    }


}
