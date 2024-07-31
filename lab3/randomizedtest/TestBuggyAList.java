package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.checkerframework.checker.units.qual.A;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
    @Test
    public void testThreeAddThreeRemove() {
        AListNoResizing<Integer> expected = new AListNoResizing<>();
        BuggyAList<Integer> broken = new BuggyAList<>();

        expected.addLast(4);
        expected.addLast(5);
        expected.addLast(6);

        broken.addLast(4);
        broken.addLast(5);
        broken.addLast(6);

        assertEquals(expected.size(), broken.size());

        assertEquals(expected.removeLast(), broken.removeLast());
        assertEquals(expected.removeLast(), broken.removeLast());
        assertEquals(expected.removeLast(), broken.removeLast());
    }

    @Test
    public void randomizedTest() {
        AListNoResizing<Integer> expected = new AListNoResizing<>();
        BuggyAList<Integer> broken = new BuggyAList<>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                expected.addLast(randVal);
                broken.addLast(randVal);
            } else if (operationNumber == 1 && expected.size() > 0) {
                // getLast
                assertEquals(expected.getLast(), broken.getLast());
            } else if (operationNumber == 2 && expected.size() > 0) {
                // removeLast
                assertEquals(expected.removeLast(), broken.removeLast());
            } else if (operationNumber == 3){
                // size
                assertEquals(expected.size(), broken.size());
            }

        }
    }
}
