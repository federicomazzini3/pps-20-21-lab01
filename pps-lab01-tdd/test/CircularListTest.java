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
    private int[] randomElements;
    public static final int ELEMENTS_NUMBER_FOR_TESTING = 5;

    @BeforeEach
    void beforeEach(){
        circularList = new CircularListImpl();
        selectStrategy = new SelectStrategyFactory();
        randomElements = generateElementsForTesting(ELEMENTS_NUMBER_FOR_TESTING);
    }

    private int[] generateElementsForTesting(int elementsNumber) {
        int[] elementsForTesting = new int[elementsNumber];
        for (int i = 0; i < elementsNumber; i++) {
            elementsForTesting[i] = (int) Math.random();
        }
        return elementsForTesting;
    }

    private void addElementsToCircularList(){
        for(int i = 0; i < randomElements.length; i ++){
            circularList.add(randomElements[i]);
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
        addElementsToCircularList();
        assertEquals(randomElements.length, circularList.size());
    }

    @Test
    void testNextWithEmptyCircularList(){
        assertEquals(Optional.empty(), circularList.next());
    }

    @Test
    void testNext(){
        addElementsToCircularList();
        assertEquals(randomElements[0], circularList.next().get());
        assertEquals(randomElements[1], circularList.next().get());
        assertEquals(randomElements[2], circularList.next().get());
    }

    @Test
    void testCircularNext(){
        addElementsToCircularList();
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
        addElementsToCircularList();
        circularList.next();
        circularList.next();
        assertEquals(randomElements[0], circularList.previous().get());
    }

    @Test
    void testCircularPrevious(){
        addElementsToCircularList();
        assertEquals(randomElements[1], circularList.previous().get());
    }

    @Test
    void testReset(){
        addElementsToCircularList();
        assertEquals(randomElements[0], circularList.next().get());
        assertEquals(randomElements[1], circularList.next().get());
        circularList.reset();
        assertEquals(randomElements[0], circularList.next().get());
    }

    @Test
    void testNextEvenWithStrategy(){
        circularList.add(1);
        circularList.add(2);
        circularList.add(3);
        assertEquals(2, circularList.next(selectStrategy.even()).get());
    }

    @Test
    void testNextMultipleOfStrategy(){
        circularList.add(3);
        circularList.add(3);
        circularList.add(8);
        circularList.add(5);
        assertEquals(8, circularList.next(selectStrategy.multipleOf(2)).get());
    }

    @Test
    void testNextEqualsStrategy(){
        circularList.add(3);
        circularList.add(3);
        circularList.add(8);
        circularList.add(5);
        assertEquals(8, circularList.next(selectStrategy.equalsOf(8)).get());
    }
}
