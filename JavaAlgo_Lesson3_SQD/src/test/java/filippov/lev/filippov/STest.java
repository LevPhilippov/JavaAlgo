package filippov.lev.filippov;

import filippov.lev.filippov.interfaces.Stack;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class STest {
    Stack<Integer> testStack;
    Integer[] array;
    private static final int stack_size=8;

    @Test
    @BeforeEach
    void pushIsFullTest(){
        Random random = new Random();
        testStack=new LionsStack<>();
        array = new Integer[stack_size];

        for (int i = 0; i < stack_size; i++) {
            int value = random.nextInt(100);
            testStack.push(value);
            array[i]=value;
        }

        Assertions.assertTrue(testStack.isFull());
        Assertions.assertEquals(testStack.getSize(), stack_size);
    }


    @Test
    void popIsEmptyTest(){
        for(int i = 0; i< array.length;i++){
            Assertions.assertEquals(array[array.length-1-i],testStack.pop());
        }
        Assertions.assertEquals(testStack.getSize(),0);
    }

    @Test
    void getSizeTest(){
        for(int i = stack_size; i>=0; i--) {
            Assertions.assertEquals(testStack.getSize(),i);
            if(testStack.getSize() != 0)
                testStack.pop();
        }
    }

    @Test
    void overfillingTest(){
        Assertions.assertThrows(RuntimeException.class, () -> testStack.push(1));
    }

    @Test
    void nothingToPopTest(){
        getSizeTest();
        Assertions.assertThrows(RuntimeException.class, () -> testStack.pop());
    }
}
