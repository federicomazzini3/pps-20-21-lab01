import lab01.tdd.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    private CircularList circularList;
    private SelectStrategyFactory selectStrategy;

    @BeforeEach
    void beforeEach(){
        circularList = new CircularListImpl();
        selectStrategy = new SelectStrategyFactory();
    }

    private int[] generateElementsForTesting(int elementsNumber) {
        int[] elementsForTesting = new int[elementsNumber];
        for (int i = 0; i < elementsNumber; i++) {
            elementsForTesting[i] = (int) Math.random();
        }
        return elementsForTesting;
    }

    private void addElementsToCircularList(int[] elementsForTesting){
        for(int i = 0; i < elementsForTesting.length; i ++){
            circularList.add(elementsForTesting[i]);
        }
    }

    @Test
    void testInitiallyEmpty(){
        assertTrue(circularList.isEmpty());
    }

    @Test
    void testAddElement(){
        circularList.add(1);
        assertFalse(circularList.isEmpty());
    }

    @Test
    void testSize(){
        int[] randomElements = generateElementsForTesting(5);
        addElementsToCircularList(randomElements);
        assertEquals(randomElements.length, circularList.size());
    }

    @Test
    void testNextWithEmptyCircularList(){
        assertEquals(Optional.empty(), circularList.next());
    }

    @Test
    void testNext(){
        int[] randomElements = generateElementsForTesting(3);
        addElementsToCircularList(randomElements);
        assertEquals(randomElements[0], circularList.next().get());
        assertEquals(randomElements[1], circularList.next().get());
        assertEquals(randomElements[2], circularList.next().get());
    }

    @Test
    void testCircularNext(){
        int[] randomElements = generateElementsForTesting(3);
        addElementsToCircularList(randomElements);
        assertEquals(randomElements[0], circularList.next().get());
        assertEquals(randomElements[1], circularList.next().get());
        assertEquals(randomElements[2], circularList.next().get());
        assertEquals(randomElements[0], circularList.next().get());
    }

    @Test
    void testPreviousWithEmptyCircularList(){
        assertEquals(Optional.empty(), circularList.previous());
    }

    @Test
    void testPrevious(){
        int[] randomElements = generateElementsForTesting(2);
        addElementsToCircularList(randomElements);
        circularList.next();
        circularList.next();
        assertEquals(randomElements[0], circularList.previous().get());
    }

    @Test
    void testCircularPrevious(){
        int[] randomElements = generateElementsForTesting(2);
        addElementsToCircularList(randomElements);
        assertEquals(randomElements[1], circularList.previous().get());
    }

    @Test
    void testReset(){
        int[] randomElements = generateElementsForTesting(3);
        addElementsToCircularList(randomElements);
        assertEquals(randomElements[0], circularList.next().get());
        assertEquals(randomElements[1], circularList.next().get());
        circularList.reset();
        assertEquals(randomElements[0], circularList.next().get());
    }

    @Test
    void testNextEvenWithStrategy(){
        int[] elements = new int[]{1,2,3};
        addElementsToCircularList(elements);
        circularList.next();
        assertEquals(2, circularList.next(selectStrategy.even()).get());
    }

    @Test
    void testNextMultipleOfStrategy(){
        int[] elements = new int[]{3,3,8,5};
        addElementsToCircularList(elements);
        assertEquals(8, circularList.next(selectStrategy.multipleOf(2)).get());
    }

    @Test
    void testNextEqualsStrategy(){
        int[] elements = new int[]{3,3,8,5};
        addElementsToCircularList(elements);
        assertEquals(8, circularList.next(selectStrategy.equalsOf(8)).get());
    }
}
